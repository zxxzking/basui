package com.lv.basui.controller;

import com.lv.basui.dto.ResultBean;
import com.lv.basui.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {

    private Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBean error(Exception e){
        ResultBean resultBean = new ResultBean();
        if (e instanceof BaseException){
            BaseException e1 = (BaseException)e;
            resultBean.setCode(e1.getCode());
            resultBean.setMsg(e1.getMsg());
        }else{

            logger.error(e.getMessage(),e);
            resultBean.setCode("S1001");
            resultBean.setMsg("服务器出错");
        }

        return resultBean;
    }
}
