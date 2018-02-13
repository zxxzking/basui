package com.lv.basui.interceptor;

import com.lv.basui.dto.ResultBean;
import com.lv.basui.entity.User;
import com.lv.basui.service.TokenService;
import com.lv.basui.utils.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    private Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    private TokenService tokenService;

    public LoginInterceptor(TokenService tokenService){
        this.tokenService = tokenService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getParameter("token");
        log.info("校验token "+token);
        if(token!=null){
            boolean checkToken = tokenService.checkToken(token);
            if(checkToken){
                log.info("==============校验通过============");
                // 校验通过
                return true;
            }
        }
        log.info("token失效");
        ResultBean resultBean = new ResultBean();
        resultBean.setCode("C1001");
        resultBean.setMsg("未登录或token失效");
        outWrite(response, resultBean,request);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


    private void outWrite(HttpServletResponse response, ResultBean resultBean, HttpServletRequest request) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write(GsonUtils.getJson(resultBean));
        out.flush();
    }
}
