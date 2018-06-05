package com.lv.basui.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class MyScheduler {

    /*public static void main(String[] args) throws SchedulerException {
        SchedulerFactory factory = new StdSchedulerFactory();

        Scheduler scheduler = factory.getScheduler();
        JobDetail jobDetail = JobBuilder.newJob(HelloWorldJob.class).withIdentity("job1","group1").build();

        //创建触发器Trigger实例(立即执行，每隔1S执行一次)
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "triggerGroup1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever())
                .build();

        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
    }*/
}
