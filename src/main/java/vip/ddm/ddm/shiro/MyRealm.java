package vip.ddm.ddm.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import vip.ddm.ddm.common.OnlineUserInfo;
import vip.ddm.ddm.dao.StoreMapper;
import vip.ddm.ddm.model.Store;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    StoreMapper storeMapper;

    /*@Autowired
    PermissionService permissionService;*/

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("授权...");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> set = new LinkedHashSet<>();

        OnlineUserInfo onlineUserInfo = (OnlineUserInfo)SecurityUtils.getSubject().getSession().getAttribute("onlineUserInfo");
        /*if(onlineUserInfo!=null){
            if(onlineUserInfo.getType()==-1){//超级管理员
                for (UPermission uPermission : permissionService.getUPermissionListAll()) {
                    //类型不为菜单
                    if (uPermission.getType() != 1) {
                        set.add(uPermission.getName());
                    }
                }
            }else if(onlineUserInfo.getuPermissions()!=null&&onlineUserInfo.getuPermissions().size()>0){
                for (UPermission uPermission : onlineUserInfo.getuPermissions()) {
                    //类型不为菜单
                    if (uPermission.getType() != 1) {
                        set.add(uPermission.getName());
                    }
                }
            }
        }*/
        info.addStringPermissions(set);
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //查找用户
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String name = token.getUsername();
        List<Store> stores =storeMapper.findByName(name);
        //校验密码
        if(stores.size()==0){
            throw new AuthenticationException("用户未找到");
        }
        return new SimpleAuthenticationInfo(stores.get(0),stores.get(0).getPassword(),getName());
    }

}
