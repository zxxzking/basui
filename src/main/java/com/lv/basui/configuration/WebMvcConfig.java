package com.lv.basui.configuration;

import com.lv.basui.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {


    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        /*registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/needToLogin/*");
        super.addInterceptors(registry);*/
    }
}
