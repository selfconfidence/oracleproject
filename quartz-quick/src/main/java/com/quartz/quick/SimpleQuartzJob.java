package com.quartz.quick;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @author misterWei
 * @create 2018年10月01号:23点56分
 * @mailbox mynameisweiyan@gmail.com
 */
public class SimpleQuartzJob implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(new Date().toLocaleString()+"---"+jobExecutionContext.getTrigger().getClass().getName()+"---"+Thread.currentThread().getName());
    }
}
