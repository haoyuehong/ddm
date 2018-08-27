package vip.ddm.ddm.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vip.ddm.ddm.common.OnlineUserInfo;

import java.util.List;

@Component
public class SessionUtil {


    public static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }

    //获取在线用户
    public static OnlineUserInfo getOnlineSession(){
        return (OnlineUserInfo) SecurityUtils.getSubject().getSession().getAttribute("onlineUserInfo");
    }

}
