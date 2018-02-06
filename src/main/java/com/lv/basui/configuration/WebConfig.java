package com.lv.basui.configuration;

import com.lv.basui.filter.CrossDomainFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    /**
     * 配置一个处理跨域请求的过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean domainCrossFilterBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        CrossDomainFilter filter = new CrossDomainFilter();
        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
