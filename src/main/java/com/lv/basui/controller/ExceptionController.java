package com.lv.basui.controller;

import com.lv.basui.dto.ResultBean;
import com.lv.basui.exception.BaseException;
import com.lv.basui.exception.TestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
            // 未知异常
            logger.error(e.getMessage(),e);
            resultBean.setCode("S1001");
            resultBean.setMsg("服务器出错！");
        }

        return resultBean;
    }

    @ExceptionHandler(value = TestException.class)
    public void testHandler(TestException e, HttpServletResponse response){
        System.out.println(e.getDescription()+"++++++++++++++++++++++++++++++");
        response.setStatus(200);
        try {
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write("产生异常 已处理");
        } catch (IOException e1) {

            e1.printStackTrace();
        }

    }
}
