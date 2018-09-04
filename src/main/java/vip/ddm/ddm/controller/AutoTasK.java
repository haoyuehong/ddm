package vip.ddm.ddm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import vip.ddm.ddm.dao.CouponMapper;
import vip.ddm.ddm.dao.DiscountMapper;
import vip.ddm.ddm.model.Coupon;
import vip.ddm.ddm.service.CouponService;
import vip.ddm.ddm.service.DisCountService;

import java.util.Date;
import java.util.List;

@Component
public class AutoTasK {

    @Autowired
    private CouponService couponService;
    @Autowired
    private CouponMapper couponMapper;

    @Autowired
    private DiscountMapper discountMapper;

    @Autowired
    private DisCountService disCountService;

    /**
     * 优惠卷更新状态
     */
    //@Scheduled(fixedRate = 5000)
    public void updateCouponSatus(){
        List<Coupon> coupons =  couponService.findByStatus(0);
        for(Coupon coupon : coupons){
            if(new Date().after(coupon.getDate())){
                coupon.setStatus((byte)2);
                couponMapper.updateByPrimaryKeySelective(coupon);
            }
        }
    }

    /**
     * 折扣商品
     */


}
