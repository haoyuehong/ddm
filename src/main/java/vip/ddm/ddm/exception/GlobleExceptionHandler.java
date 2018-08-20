package vip.ddm.ddm.exception;

import org.mybatis.spring.MyBatisSystemException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import vip.ddm.ddm.result.CodeMsg;
import vip.ddm.ddm.result.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

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
        e.printStackTrace();
        System.out.println("==============>"+e.getClass());
        if(e instanceof BindException){
            BindException be =  (BindException)e;
            List<ObjectError> errorList = be.getAllErrors();
            String msg = "";
            msg = errorList.get(0).getDefaultMessage();
            return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
        }else if(e instanceof MyBatisSystemException){
            MyBatisSystemException me = (MyBatisSystemException)e;
            String msg =Objects.requireNonNull(me.getRootCause()).getLocalizedMessage();
            return Result.error(CodeMsg.CODE_ERROR.fillArgs(msg));
        }else if(e instanceof DataIntegrityViolationException){
            DataIntegrityViolationException ve = (DataIntegrityViolationException)e;
            String msg = Objects.requireNonNull(ve.getRootCause()).getLocalizedMessage();
            return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
        }else if(e instanceof GlobleException){
            GlobleException ge = (GlobleException)e;
            return Result.error(ge.getCodeMsg());
        }else{
            return Result.error(CodeMsg.SERVER_ERROR);
        }

    }
}
