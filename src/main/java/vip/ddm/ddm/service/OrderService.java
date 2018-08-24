package vip.ddm.ddm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.ddm.ddm.config.WebSocketController;
import vip.ddm.ddm.dao.*;
import vip.ddm.ddm.dto.OrderDto;
import vip.ddm.ddm.dto.OrderGoodsDto;
import vip.ddm.ddm.dto.OrderQueryDto;
import vip.ddm.ddm.exception.GlobleException;
import vip.ddm.ddm.model.*;
import vip.ddm.ddm.result.CodeMsg;
import vip.ddm.ddm.utils.SnowflakeIdWorker;
import vip.ddm.ddm.vo.OrderDetailVO;
import vip.ddm.ddm.vo.OrderGoodsVo;
import vip.ddm.ddm.vo.OrderVo;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderGoodsMapper orderGoodsMapper;
    @Autowired
    WebSocketController webSocketController;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private DiscountMapper discountMapper;
    @Autowired
    private CouponMapper couponMapper;
    @Autowired
    private FullDownMapper fullDownMapper;


    @Transactional
    public void save(@Valid OrderDto orderDto){
        Order order = new Order();
        BeanUtils.copyProperties(orderDto,order);
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
        String id = "DDM_VIP"+idWorker.nextId();
        order.setId(id);
        List<OrderGoodsDto> orderGoodsDtoList = orderDto.getOrderGoodsDtos();
        for(OrderGoodsDto orderGoodsDto:orderGoodsDtoList){
            OrderGoods orderGoods = new OrderGoods();
            orderGoods.setGoodsId(orderGoodsDto.getGoods_id());
            orderGoods.setOrderId(id);
            orderGoods.setNum(orderGoodsDto.getNum());
            orderGoodsMapper.insert(orderGoods);
        }
        orderMapper.insert(order);
        //推送消息
        webSocketController.template.convertAndSendToUser("DDMVIP123123","/message","order"+id);
    }

    public PageInfo<OrderVo> list(OrderQueryDto orderQueryDto){
        PageHelper.startPage(orderQueryDto.getPage(),orderQueryDto.getRows());
        List<OrderVo> orderVos = orderMapper.list(orderQueryDto.getOrder(),orderQueryDto.getKey());
        return new PageInfo<>(orderVos);
    }

    /**
     * 修改状态(除退款)
     */
    public void updateStatus(String id,Byte status){
        if(StringUtils.isBlank(id)){
            throw new GlobleException(CodeMsg.ORDER_ID_NULL);
        }
        Order order = orderMapper.selectByPrimaryKey(id);
        if(order == null){
            throw new GlobleException(CodeMsg.ORDER_NULL);
        }
        if(status == null){
            throw new GlobleException(CodeMsg.TARGET_STATUS_NULL);
        }
        order.setStatus(status);
        orderMapper.updateByPrimaryKey(order);
    }

    public OrderDetailVO detail(String id){
        OrderDetailVO orderDetailVO = new OrderDetailVO();
        List<OrderGoodsVo> orderGoodsVos = new ArrayList<>();
        List<OrderGoods> orderGoodsList = orderGoodsMapper.selectByOrderId(id);
        for(OrderGoods orderGoods : orderGoodsList){
            OrderGoodsVo orderGoodsVo = new OrderGoodsVo();
            Goods goods = goodsMapper.selectByPrimaryKey(orderGoods.getGoodsId());
            orderGoodsVo.setGoodsName(goods.getGoodsName());
            orderGoodsVo.setNum(orderGoods.getNum());
            orderGoodsVo.setPrice(goods.getPrice());
            Discount discount = discountMapper.findByGoodsId(orderGoods.getGoodsId());
            Double realPrice = goods.getPrice();
            if(discount != null){
                realPrice = discount.getDiscountPrice();
            }
            orderGoodsVo.setRealPrice(realPrice);
            orderGoodsVos.add(orderGoodsVo);
        }
        Order order = orderMapper.selectByPrimaryKey(id);
        orderDetailVO.setOrderGoodsVoList(orderGoodsVos);
        if(order.getCouponId() != null){
            Coupon coupon = couponMapper.findByIdAndStatus(order.getCouponId(),0);
            if(coupon != null){
                orderDetailVO.setCoupon(coupon.getName());
            }

        }
        if(order.getFullDownId() != null){
            FullDown fullDown = fullDownMapper.findByIdAndStatus(order.getFullDownId(),0);
            if(fullDown != null){
                orderDetailVO.setFullDown(fullDown.getName());
            }
        }

        return orderDetailVO;
    }





}
