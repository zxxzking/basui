package com.lv.basui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement // 启注解事务管理
public class BasuiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasuiApplication.class, args);
	}
}
