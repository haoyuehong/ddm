package vip.ddm.ddm.shiro;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import vip.ddm.ddm.result.CodeMsg;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                return executeLogin(request, response);
            } else {
                return true;
            }
        } else {
            /*if(isAjax(request)){
                BaseRemark baseRemark=new BaseRemark();
                baseRemark.setCode(BaseRemark.USER_NOT_LOGIN_CODE);
                baseRemark.setRemark(BaseRemark.USER_NOT_LOGIN);

                response.getWriter().write(JSONObject.fromObject(baseRemark).toString());
            }else{
                this.saveRequestAndRedirectToLogin(request, response);
            }*/


            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JSON.toJSONString(CodeMsg.UNLOGIN));
            return false;
        }
    }

    private static boolean isAjax(ServletRequest request){
        String header = ((HttpServletRequest) request).getHeader("X-Requested-With");
        if("XMLHttpRequest".equalsIgnoreCase(header)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
