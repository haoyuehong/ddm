package vip.ddm.ddm.controller;


import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.ddm.ddm.dto.CouponDto;
import vip.ddm.ddm.dto.CouponQuesryDto;
import vip.ddm.ddm.dto.IdQuery;
import vip.ddm.ddm.model.Coupon;
import vip.ddm.ddm.result.Result;
import vip.ddm.ddm.service.CouponService;

import javax.validation.Valid;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @RequestMapping("/save")
    public Result save(@RequestBody CouponDto couponDto){
        couponService.save(couponDto);
        return Result.success(true);
    }

    @RequestMapping("/delete")
    public Result delete(@RequestBody IdQuery idQuery){
        couponService.delete(idQuery.getId());
        return Result.success(true);
    }

    @RequestMapping("/list")
    public Result<PageInfo<Coupon>> list(@RequestBody CouponQuesryDto couponQuesryDto){
        return Result.success(couponService.list(couponQuesryDto));
    }
}
