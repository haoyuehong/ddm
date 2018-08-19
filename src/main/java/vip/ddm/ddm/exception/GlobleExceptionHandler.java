package vip.ddm.ddm.exception;

import org.mybatis.spring.MyBatisSystemException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import vip.ddm.ddm.result.CodeMsg;
import vip.ddm.ddm.result.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: mol
 * @Description:
 * @Date: create in 9:15 2018/5/7
 */
@ControllerAdvice
@ResponseBody
public class GlobleExceptionHandler {

    @ExceptionHandler
    public Result<String> exceptionHandler(HttpServletRequest request, Exception e){
        //e.printStackTrace();
        System.out.println("==============>"+e.getClass());
        if(e instanceof BindException){
            BindException be =  (BindException)e;
            List<ObjectError> errorList = be.getAllErrors();
            String msg = "";
            msg = errorList.get(0).getDefaultMessage();
            return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
        }else if(e instanceof MyBatisSystemException){
            MyBatisSystemException me = (MyBatisSystemException)e;
            String msg =me.getRootCause().getLocalizedMessage();
            return Result.error(CodeMsg.CODE_ERROR.fillArgs(msg));
        }else{
            return Result.error(CodeMsg.SERVER_ERROR);
        }

    }
}
