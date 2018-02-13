package com.lv.basui.controller;

import com.lv.basui.utils.ThreeDes;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;


@Controller
public class BaseController {

    public Logger logger = LoggerFactory.getLogger(getClass());

    public RestTemplate restTemplate = new RestTemplate();


    public String getUserId(String token) {
        if (StringUtils.isBlank(token)) {
            return null;
        }
        String s = ThreeDes.decryptThreeDESECB(token);
        if(StringUtils.isBlank(s)){
            return null;
        }
        return s.split(",")[0];
    }

    public <T> T getParam(HttpServletRequest request, String param) {
        return this.getParam(request, param, String.class);
    }

    public <T> T getParam(HttpServletRequest request, String param, Class clazz) {
        String obj = request.getParameter(param) == null ? "" : request.getParameter(param).trim();
        if (StringUtils.isNotBlank(obj)) {
            if (Integer.class.equals(clazz)) {
                return (T) new Integer(obj);
            } else if (Double.class.equals(clazz)) {
                return (T) new Double(obj);
            } else if (Long.class.equals(clazz)) {
                return (T) new Long(obj);
            } else {
                return BigDecimal.class.equals(clazz) ? (T) new BigDecimal(obj) : (T) new String(obj);
            }
        } else {
            return null;
        }
    }

}
