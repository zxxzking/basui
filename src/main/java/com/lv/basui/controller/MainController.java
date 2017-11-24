package com.lv.basui.controller;

import com.lv.basui.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    @Autowired
    private FileService fileService;

    public void test(){



    }
}
