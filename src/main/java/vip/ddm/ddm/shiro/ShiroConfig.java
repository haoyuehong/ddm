package vip.ddm.ddm.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import vip.ddm.ddm.utils.EncryptTool;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

   /* @Autowired
    PermissionService permissionService;*/


    @Bean
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 默认配置
        shiroFilterFactoryBean.setLoginUrl("/unlogin");
        shiroFilterFactoryBean.setSuccessUrl("/home");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

        //自定义拦截器
        Map<String, Filter> filtersMap = new LinkedHashMap<String, Filter>();
       filtersMap.put("authc",new MyFormAuthenticationFilter());//为登录拦截器MyFormAuthenticationFilter指定名称authc
       // filtersMap.put("perms",new MyPermissionsAuthorizationFilter());//为权限拦截器MyPermissionsAuthorizationFilter指定名称perms
        shiroFilterFactoryBean.setFilters(filtersMap);

        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //权限配置
        LinkedHashMap<String , String> filterChainDefinitionMap = new LinkedHashMap<String , String>();
        //数据库动态配置
       /* List<UPermission> uPermissions = permissionService.getUPermissionListAll();
        for (UPermission uPermission : uPermissions) {
            if (uPermission.getType()!=null&&uPermission.getType() != 1) {
                //字符串拼接权限
                filterChainDefinitionMap.put(uPermission.getUrl(), "perms[" + uPermission.getName() + "]");
            }
        }*/

        //分别为url指定对应拦截器
        filterChainDefinitionMap.put("/static/**","anon");
        filterChainDefinitionMap.put("/getfile.do","anon");
        filterChainDefinitionMap.put("/login", "anon");


        filterChainDefinitionMap.put("/unauthorized", "anon");




        filterChainDefinitionMap.put("/webServer/**", "anon");
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/upload","anon");

       

        //filterChainDefinitionMap.put("/loginout", "logout");
        
        /*filterChainDefinitionMap.put("/", "authc");
        filterChainDefinitionMap.put("/items", "perms[list]");*/

        //filterChainDefinitionMap.put("/add", "loginFilter");//为/add指定拦截器loginFilter

        // <!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    @Bean("securityManager")
    public SecurityManager securityManager(@Qualifier("myRealm") MyRealm myRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        //securityManager.setCacheManager(RedisCacheManager.builder(redisConnectionFactory).build());
        return securityManager;
    }

    @Bean("myRealm")
    public MyRealm myRealm() {
        MyRealm realm = new MyRealm();
        // 定义凭据比较器
        /*HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("MD5");
        matcher.setHashIterations(21);
        realm.setCredentialsMatcher(matcher);*/
        //设置自定义凭据比较器
        realm.setCredentialsMatcher(new CredentialsMatcher());
        return realm;
    }

    /**
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }
}

//自定义比凭据比较器
class CredentialsMatcher extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;
        String inPassword = EncryptTool.encrypt(new String(utoken.getPassword()));
        //获得数据库中的密码
        String dbPassword=(String) info.getCredentials();
        //返回密码的比对结果
        return this.equals(inPassword, dbPassword);
    }

}
