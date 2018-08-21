package vip.ddm.ddm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.ddm.ddm.dto.UserQueryDto;
import vip.ddm.ddm.dto.UserTypeDto;
import vip.ddm.ddm.result.Result;
import vip.ddm.ddm.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/list")
    public Result list(UserQueryDto userQueryDto){

        return null;
    }


    @RequestMapping("/updateType")
    public Result list(UserTypeDto userTypeDto){
        userService.updateType(userTypeDto);
        return Result.success(true);
    }


}
