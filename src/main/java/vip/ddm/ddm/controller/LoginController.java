package vip.ddm.ddm.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vip.ddm.ddm.common.OnlineUserInfo;
import vip.ddm.ddm.dto.LoginQuery;
import vip.ddm.ddm.exception.GlobleException;
import vip.ddm.ddm.model.Store;
import vip.ddm.ddm.result.CodeMsg;
import vip.ddm.ddm.result.Result;
import vip.ddm.ddm.utils.SessionUtil;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    //无权限
    //@ApiOperation(value="无权限", notes="")
    @ResponseBody
    @GetMapping("/unauthorized")
    Result unauthorized() {
        throw new GlobleException(CodeMsg.UNAUTHORIZED);
    }

    //登录校验
    @ResponseBody
    @PostMapping("/login")
    Result login(@RequestBody LoginQuery loginQuery, HttpServletRequest httpServletRequest) {

        //登录认证授权
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(loginQuery.getUsername(),loginQuery.getPassword());
        try{
            subject.login(usernamePasswordToken);
            Store store=(Store)subject.getPrincipal();
            OnlineUserInfo onlineUserInfo=new OnlineUserInfo();
            BeanUtils.copyProperties(store,onlineUserInfo);
            SecurityUtils.getSubject().getSession().setAttribute("onlineUserInfo",onlineUserInfo);
            httpServletRequest.getSession().setAttribute("token","success");
        }
        catch (Exception e){
            throw new GlobleException(CodeMsg.STORE_INFO_ERROR);
        }
        return Result.success(SessionUtil.getOnlineSession());
    }

    //登出
    @ResponseBody
    @GetMapping("/loginout")
    Result loginOut() throws Exception{
        SecurityUtils.getSubject().logout();
        return Result.success(true);
    }

    //登出
    @ResponseBody
    @GetMapping("/unlogin")
    Result unlogin() throws Exception{
        return Result.error(CodeMsg.UNLOGIN);
    }

    //获取登录用户
    @ResponseBody
    @GetMapping("/getUser")
    Result getUser(){
        OnlineUserInfo onlineUserInfo= SessionUtil.getOnlineSession();
        return Result.success(onlineUserInfo);
    }
}
