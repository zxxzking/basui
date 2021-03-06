package com.lv.basui.job;

import com.lv.basui.constants.Constants;
import com.lv.basui.dto.MailDto;
import com.lv.basui.entity.RemainingDays;
import com.lv.basui.service.JobService;
import com.lv.basui.utils.MailUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;


@Component
@EnableScheduling
public class ScheduledTest implements SchedulingConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTest.class);

    @Autowired
    private JobService jobService;

    // @Scheduled(cron="0 */30 * * * ?")
    public void sendMail(){
        RemainingDays days = jobService.getdays(Constants.DAYS_TYPE.TYPE_1001);
        String content = MessageFormat.format(days.getDescription(),days.getDays());
        MailDto dto = new MailDto();

        content = "铁锤啊 千万别花钱啊 还得去北京啊";

        dto.setContent(content);
        dto.setFromPerson("zxxz");
        dto.setToPerson("亲爱的用户");
        dto.setTargetMail("3046108153@qq.com");
        dto.setSubject("新年倒计时");
        try {
            MailUtils.doSendMsg(dto);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        // jobService.updateDaysMsg(days);
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

    }
}
