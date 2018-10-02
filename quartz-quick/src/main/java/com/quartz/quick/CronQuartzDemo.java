package com.quartz.quick;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author misterWei
 * @create 2018年10月02号:00点00分
 * @mailbox mynameisweiyan@gmail.com
 *
 *   以Cron表达式进行设置的带调度 这里5秒执行一次
 */
public class CronQuartzDemo {

    public static void main(String[] args) {

        try {
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            JobDetail jobDetail = JobBuilder.newJob(SimpleQuartzJob.class).build();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simple")
                    .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))    //每隔5秒执行一次
                    .startNow()
                    .build();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }



}
