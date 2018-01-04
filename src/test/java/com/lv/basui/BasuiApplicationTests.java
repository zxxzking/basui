package com.lv.basui;

import com.lv.basui.constants.Constants;
import com.lv.basui.controller.MainController;
import com.lv.basui.entity.RemainingDays;
import com.lv.basui.service.JobService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasuiApplicationTests {


	@Autowired
	private MainController controller;

	@Autowired
	private JobService jobService;

	@Test
	public void contextLoads() {

		RemainingDays getdays = jobService.getdays(Constants.DAYS_TYPE.TYPE_1001);

		int i = jobService.updateDaysMsg(getdays);
		System.out.println(i);
	}

}
