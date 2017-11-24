package com.lv.basui;

import com.lv.basui.controller.MainController;
import com.lv.basui.dao.FileDao;
import com.lv.basui.service.FileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasuiApplicationTests {

	@Autowired
	private FileDao fileDao;

	@Autowired
	private FileService fileService;

	@Autowired
	private MainController controller;

	@Test
	public void contextLoads() {
		controller.test();
	}

}
