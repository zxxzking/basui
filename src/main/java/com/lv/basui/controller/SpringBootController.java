package com.lv.basui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "needToLogin")
public class SpringBootController {

    @RequestMapping(value = "/springboot")
    public String toSpringBootIndex(){


        return "springBootIndex";
    }
}
