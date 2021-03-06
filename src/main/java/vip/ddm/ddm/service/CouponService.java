package vip.ddm.ddm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.ddm.ddm.dao.CouponGoodsGroupMapper;
import vip.ddm.ddm.dao.CouponGoodsMapper;
import vip.ddm.ddm.dao.CouponMapper;
import vip.ddm.ddm.dao.CouponStoreMapper;
import vip.ddm.ddm.dto.CouponDto;
import vip.ddm.ddm.dto.CouponQuesryDto;
import vip.ddm.ddm.exception.GlobleException;
import vip.ddm.ddm.model.*;
import vip.ddm.ddm.result.CodeMsg;
import vip.ddm.ddm.utils.SessionUtil;
import vip.ddm.ddm.vo.CouponVo;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class CouponService {


    @Autowired
    private CouponMapper couponMapper;
    @Autowired
    private UserCouponService userCouponService;
    @Autowired
    private CouponStoreMapper couponStoreMapper;
    @Autowired
    private CouponGoodsGroupMapper couponGoodsGroupMapper;
    @Autowired
    private CouponGoodsMapper couponGoodsMapper;
    @Autowired
    private StoreService storeService;


    @Transactional
    public void save(@Valid CouponDto couponDto){
        if(couponDto.getStoreId() == null || couponDto.getStoreId() == null){
            saveCoupon(couponDto,SessionUtil.getOnlineSession().getId());
        }else{
            saveCoupon(couponDto,couponDto.getStoreId());
        }
    }

    @Transactional
    public void saveCoupon(CouponDto couponDto,Integer storeId){
        Coupon coupon = new Coupon();
        BeanUtils.copyProperties(couponDto,coupon);
        couponMapper.insert(coupon);
        CouponStore couponStore = new CouponStore();
        couponStore.setCouponId(coupon.getId());
        couponStore.setStoreId(storeId);
        couponStoreMapper.insert(couponStore);
        if(couponDto.getType() == 1){
            for(Integer goodsGroupId : couponDto.getGoodsGroupIds()){
                CouponGoodsGroup couponGoodsGroup = new CouponGoodsGroup();
                couponGoodsGroup.setCouponId(coupon.getId());
                couponGoodsGroup.setGoodsGroupId(goodsGroupId);
                couponGoodsGroupMapper.insert(couponGoodsGroup);
            }
        }else if(couponDto.getType() == 3){
            for(Integer goodsId : couponDto.getGoodsIds()){
                CouponGoods couponGoods = new CouponGoods();
                couponGoods.setCouponId(coupon.getId());
                couponGoods.setGoodsId(goodsId);
                couponGoodsMapper.insert(couponGoods);
            }

        }
    }

    public void delete(Integer id){
        if(id == null){
            throw new GlobleException(CodeMsg.COUPON_ID_NULL);
        }
        Coupon coupon = couponMapper.selectByPrimaryKey(id);
        if(coupon == null){
            throw new GlobleException(CodeMsg.COUPON_NULL);
        }
        List<User> users = userCouponService.selectByCouponId(id);
        if(users.size()>0){
            throw new GlobleException(CodeMsg.COUPON_BEGET);
        }
        coupon.setStatus((byte)1);
        couponMapper.updateByPrimaryKey(coupon);
    }

    public PageInfo<CouponVo> list(CouponQuesryDto couponQuesryDto) {
        Integer storeId = couponQuesryDto.getStoreId();
        List<Integer> storeIds = getStoreIds(storeId);
        PageHelper.startPage(couponQuesryDto.getPage(),couponQuesryDto.getRows());
        List<CouponVo> coupons = couponMapper.list(couponQuesryDto.getCoupon(),storeIds);
        return new PageInfo<>(coupons);
    }

    public List<Integer> getStoreIds(Integer storeId){
        List<Integer> storeIds = new ArrayList<>();
        if(storeId == null){
            if(SessionUtil.getOnlineSession().getType() == 0){
                /*List<Store> storeList = storeService.finbyparent(SessionUtil.getOnlineSession().getId(), 1);
                for(Store store : storeList){
                    storeIds.add(store.getId());

                }*/
                storeIds.add(SessionUtil.getOnlineSession().getId());
            }else if(SessionUtil.getOnlineSession().getType() == -1){
                List<Store> list = storeService.list();
                for(Store store : list){
                    storeIds.add(store.getId());

                }
                //storeIds.add(SessionUtil.getOnlineSession().getId());
            }else{
                storeId = SessionUtil.getOnlineSession().getId();
                storeIds.add(storeId);
            }
        }else {
            storeIds.add(storeId);
        }
        return storeIds;
    }

    public List<Coupon> findByStatus(int status) {

        return couponMapper.findByStatus(status);
    }
}
