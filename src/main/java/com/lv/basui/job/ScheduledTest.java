package com.lv.basui.job;

import com.lv.basui.constants.Constants;
import com.lv.basui.dto.MailDto;
import com.lv.basui.utils.MailUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;


public class ScheduledTest implements SchedulingConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTest.class);

    private final String cron1="";

    @Scheduled(cron="0/5 * * * * ?")
    public void executeUploadTask() {
        // 间隔1分钟,执行工单上传任务
        Thread current = Thread.currentThread();
        System.out.println("定时任务2:"+current.getId());
        logger.info("ScheduledTest.executeUploadTask 定时任务2:"+current.getId() + ",name:"+current.getName());

    }

    @Scheduled(cron="0 0 8 * * ?")
    public void sendMail(){
        MailDto dto = new MailDto();
        MailUtils utils = new MailUtils();
        dto.setContent("hahaha");
        dto.setFromPerson("zxxz");
        dto.setToPerson("亲爱的用户");
        dto.setTargetMail("lvquan@paicaifu.com");
        dto.setSubject("新年倒计时");
        try {
            MailUtils.doSendMsg(dto);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

    }
}
