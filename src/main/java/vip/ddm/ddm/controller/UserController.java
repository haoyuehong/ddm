package vip.ddm.ddm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.ddm.ddm.dto.*;
import vip.ddm.ddm.result.Result;
import vip.ddm.ddm.service.UserCouponService;
import vip.ddm.ddm.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserCouponService userCouponService;


    @RequestMapping("/list")
    public Result list(@RequestBody UserQueryDto userQueryDto){

        return Result.success( userService.list(userQueryDto));
    }


    @RequestMapping("/updateType")
    public Result list(@RequestBody UserTypeDto userTypeDto){
        userService.updateType(userTypeDto);
        return Result.success(true);
    }

    @RequestMapping("/save")
    public Result save(UserDto userDto){
        userService.save(userDto);
        return Result.success(true);
    }

    @RequestMapping("/checkSave")
    public Result checkSave(String code,Integer storeId){
        return Result.success(userService.checkSave(code,storeId));
    }

    @RequestMapping("/findCoupon")
    public Result findCoupon(@RequestBody IdQuery idQuery){
        return Result.success(userCouponService.selectByUserId(idQuery.getUserId()));
    }


}
