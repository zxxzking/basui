package com.lv.basui.controller;

import com.lv.basui.entity.Text;
import com.lv.basui.entity.Title;
import com.lv.basui.service.TitleService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    private Logger log = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private TitleService titleService;

    @RequestMapping(value = "/")
    private String index(){
        return "index";
    }

    @RequestMapping(value = "/content")
    public String queryContent(HttpServletRequest request, HttpServletResponse response){
        String textId = request.getParameter("textId");
        if(StringUtils.isBlank(textId)){
            textId = "1";
        }
        Text text = titleService.querySpecificContent(Integer.valueOf(textId));
        Title title = titleService.getTitle(Integer.valueOf(textId));
        request.setAttribute("title",title);
        if(null == text){
            text = new Text();
            text.setContent("暂无资源");
        }

        request.setAttribute("context",text);

        return "content";
    }

    @RequestMapping(value = "welcome")
    public String toWelcome(HttpServletRequest request, HttpServletResponse response){
        List<Title> titles = titleService.listTitle();
        request.setAttribute("titleList",titles);
        return "welcome";
    }


}
