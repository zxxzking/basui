package com.lv.basui.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloWorldJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String strTime = new SimpleDateFormat("HH-mm-ss").format(new Date());
        System.out.println( strTime + ":Hello World！");
    }
}
