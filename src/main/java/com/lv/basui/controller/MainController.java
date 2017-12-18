package com.lv.basui.controller;

import com.lv.basui.entity.Text;
import com.lv.basui.entity.Title;
import com.lv.basui.service.TitleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private TitleService titleService;

    @RequestMapping(value = "/")
    private String index(){

        return "redirect:/index";
    }

    @RequestMapping("index")
    private String toIndex(){


        return "index";
    }


    @RequestMapping(value = "/title")
    public String titleIndex(HttpServletRequest request, HttpServletResponse response){
        List<Title> titles = titleService.listTitle();
        request.setAttribute("titleList",titles);

        return "title";
    }


    @RequestMapping(value = "/content")
    public String queryContent(HttpServletRequest request, HttpServletResponse response){
        String textId = request.getParameter("textId");
        if(StringUtils.isBlank(textId)){
            textId = "1";
        }
        Text text = titleService.querySpecificContent(Integer.valueOf(textId));

        request.setAttribute("context",text);

        return "content";
    }
}
