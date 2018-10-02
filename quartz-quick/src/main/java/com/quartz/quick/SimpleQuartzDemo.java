package com.quartz.quick;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author misterWei
 * @create 2018年10月01号:23点59分
 * @mailbox mynameisweiyan@gmail.com
 *
 * 以2 秒 调度进行实现
 */
public class SimpleQuartzDemo {
    public static void main(String[] args) {

        try {
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            JobDetail jobDetail = JobBuilder.newJob(SimpleQuartzJob.class).build();
            SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("myJob", "mygroup")
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2)
                            .withRepeatCount(100))
//                        .startAt(new Date(Calendar.getInstance().getTimeInMillis()+ 3000))
                    .startNow()
                    .build();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}



