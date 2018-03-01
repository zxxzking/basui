package com.lv.basui;

import com.lv.basui.constants.Constants;
import com.lv.basui.controller.MainController;
import com.lv.basui.entity.RemainingDays;
import com.lv.basui.job.ScheduledTest;
import com.lv.basui.service.JobService;
import com.lv.basui.utils.HttpToolKit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// @RunWith(SpringRunner.class)
// @SpringBootTest
public class BasuiApplicationTests {


	@Autowired
	private MainController controller;

	@Autowired
	private ScheduledTest test;

	@Autowired
	private JobService jobService;

	@Test
	public void contextLoads() {

		test.sendMail();
	}

	@Test
	public void test1(){
		ExecutorService exec = Executors.newFixedThreadPool(100);
		for (int i = 0; i < 10000; i++) {
			/*exec.execute(new Runnable() {
				public void run() {

					String res = HttpToolKit.doGet("http://192.168.65.221:8888/",null);
//                    String res = HttpUtils.get("http://192.168.65.223:9093/wechat/b");
					System.out.println(res);

				}
			});*/
			exec.execute(new Runnable() {
				public void run() {

					String res = HttpToolKit.doGet("http://192.168.65.221:8888/2?name=111111111111",null);
					//String res = HttpToolKit.doGet("http://localhost:9093/wechat/a",null);
//                    String res = HttpUtils.get("http://192.168.65.223:9093/wechat/a");
					System.out.println(res);

				}
			});

			/*exec.execute(new Runnable() {
				public void run() {

					// String res = HttpToolKit.doGet("http://192.168.65.221:8888/2?name=111111111111",null);
					String res = HttpToolKit.doGet("http://localhost:9093/wechat/a",null);

//                    String res = HttpUtils.get("http://192.168.65.223:9093/wechat/a");
					System.out.println(res);

				}
			});*/
		}

        try {
            Thread.sleep(10*1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		// exec.shutdown();


	}

}
