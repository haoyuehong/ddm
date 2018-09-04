package vip.ddm.ddm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import vip.ddm.ddm.dao.CouponMapper;
import vip.ddm.ddm.dao.DiscountMapper;
import vip.ddm.ddm.dao.FullDownMapper;
import vip.ddm.ddm.model.Coupon;
import vip.ddm.ddm.model.Discount;
import vip.ddm.ddm.model.FullDown;
import vip.ddm.ddm.service.CouponService;
import vip.ddm.ddm.service.DisCountService;
import vip.ddm.ddm.service.FullDownService;

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
    @Autowired
    private FullDownMapper fullDownMapper;
    @Autowired
    private FullDownService fullDownService;

    /**
     * 优惠卷更新状态
     */
    @Scheduled(cron = "0 0 1 * * ? ")
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
    @Scheduled(cron = "0 0 1 * * ? ")
    public void updateDisCount(){
        List<Discount> discounts = disCountService.findByStatus(0);
        for(Discount discount : discounts){
            if(new Date().after(discount.getDate())){
                discount.setStatus((byte)2);
                discountMapper.updateByPrimaryKeySelective(discount);
            }
        }
    }

    @Scheduled(cron = "0 0 1 * * ? ")
    public void updateFullDown(){
        List<FullDown> fullDowns = fullDownService.findByStatus(0);
        for(FullDown fullDown : fullDowns){
            if(new Date().after(fullDown.getDate())){
                fullDown.setStatus((byte)2);
                fullDownMapper.updateByPrimaryKeySelective(fullDown);
            }
        }
    }



}
