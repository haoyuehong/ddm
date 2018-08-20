package vip.ddm.ddm.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.ddm.ddm.dao.DiscountMapper;
import vip.ddm.ddm.dao.GoodsMapper;
import vip.ddm.ddm.dto.DiscountDto;
import vip.ddm.ddm.exception.GlobleException;
import vip.ddm.ddm.model.Discount;
import vip.ddm.ddm.model.Goods;
import vip.ddm.ddm.result.CodeMsg;
import vip.ddm.ddm.vo.DiscountVo;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class DisCountService {

    @Autowired
    private DiscountMapper discountMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    public void save(@Valid DiscountDto discountDto){
        Discount discount = new Discount();
        BeanUtils.copyProperties(discountDto,discount);
        Goods goods = goodsMapper.selectByPrimaryKey(discount.getGoodsId());
        if(goods == null){
            throw new GlobleException(CodeMsg.GOOD_NULL);
        }
        if(goods.getStatus() != 0){
            throw new GlobleException(CodeMsg.GOOD_DOWN);
        }
        if(discountDto.getId() != null){
            discountMapper.updateByPrimaryKey(discount);
        }else{
            discountMapper.insertSelective(discount);
        }
    }


    public void delete(Integer id){
        if(id == null){
            throw new GlobleException(CodeMsg.DISCOUNT_ID_NULL);
        }
        Discount discount = discountMapper.selectByPrimaryKey(id);
        if(discount == null){
            throw new GlobleException(CodeMsg.DISCOUNT_NULL);
        }
        discount.setStatus((byte)1);
        discountMapper.updateByPrimaryKey(discount);
    }


    public PageInfo<DiscountVo> list(Discount discount,int page,int rows){
        PageHelper.startPage(page,rows);
        List<DiscountVo> list = discountMapper.findList(discount);
        for(DiscountVo discountVo : list){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if(discountVo.getDate() != null){
                String strDate = format.format(discountVo.getDate());
                discountVo.setStrDate(strDate);
            }else{
                discountVo.setStrDate("长期有效");
            }

        }
        return new PageInfo<>(list);
    }

    public Discount findByGoodsId(Integer id) {

        return discountMapper.findByGoodsId(id);
    }
}
