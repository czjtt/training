package test.Quartz;

/**
 * Created by tcc on 2017/6/13.
 */
//简单的任务管理类
//QuartzManager.java
import java.text.ParseException;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/** *//**
 * @Title:Quartz管理类
 *
 * @Description:
 *
 * @Copyright:
 * @author zz  2008-10-8 14:19:01
 * @version 1.00.000
 *
 */
public class QuartzManager {
    private static SchedulerFactory sf = new StdSchedulerFactory();
    private static String JOB_GROUP_NAME = "group1";
    private static String TRIGGER_GROUP_NAME = "trigger1";


    /** *//**
     *  添加一个定时任务，使用默认的任务组名，触发器名，触发器组名
     * @param jobName 任务名
     * @param jobClass     任务
     * @param time    时间设置，参考quartz说明文档
     * @throws SchedulerException
     * @throws ParseException
     */
    public static void addJob(String jobName,Class jobClass,String time)
            throws SchedulerException, ParseException{
        Scheduler sched = sf.getScheduler();

        //任务名，任务组，任务执行类
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName,JOB_GROUP_NAME).build();

        //触发器
        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(jobName,TRIGGER_GROUP_NAME)//触发器名,触发器组
                .withSchedule(CronScheduleBuilder.cronSchedule(time)).build();//触发器时间设定

        sched.scheduleJob(jobDetail,trigger);

        //启动
        if(!sched.isShutdown())
            sched.start();
    }

    /** *//**
     * 添加一个定时任务
     * @param jobName 任务名
     * @param jobGroupName 任务组名
     * @param triggerName  触发器名
     * @param triggerGroupName 触发器组名
     * @param job     任务
     * @param time    时间设置，参考quartz说明文档
     * @throws SchedulerException
     * @throws ParseException
     */
    public static void addJob(String jobName,String jobGroupName,
                              String triggerName,String triggerGroupName,
                              Job job,String time)
            throws SchedulerException, ParseException{
        Scheduler sched = sf.getScheduler();
        //任务名，任务组，任务执行类
        JobDetail jobDetail = JobBuilder.newJob(job.getClass()).withIdentity(jobName,JOB_GROUP_NAME).build();
        //触发器
        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(jobName,TRIGGER_GROUP_NAME)//触发器名,触发器组
                .withSchedule(CronScheduleBuilder.cronSchedule(time)).build();//触发器时间设定
        sched.scheduleJob(jobDetail,trigger);
        if(!sched.isShutdown())
            sched.start();
    }

    /** *//**
     * 修改一个任务的触发时间(使用默认的任务组名，触发器名，触发器组名)
     * @param jobName
     * @param time
     * @throws SchedulerException
     * @throws ParseException
     */
    public static void modifyJobTime(String jobName,String time)
            throws SchedulerException, ParseException{
//        Scheduler sched = sf.getScheduler();
//        Trigger trigger =  sched.getTrigger(TriggerKey.triggerKey(jobName,TRIGGER_GROUP_NAME));
//        if(trigger != null){
//            CronTriggerImpl cti = (CronTriggerImpl) trigger;
//            cti.setCronExpression(time);
////            CronTrigger  ct = TriggerBuilder.newTrigger()
////                    .withSchedule(CronScheduleBuilder.cronSchedule(time)).build();//修改时间
//            //重启触发器
//            sched.resumeTrigger(TriggerKey.triggerKey(jobName,TRIGGER_GROUP_NAME));
//        }

        try {
            Scheduler sched = sf.getScheduler();
            CronTrigger trigger = (CronTrigger) sched.getTrigger(TriggerKey.triggerKey(jobName,TRIGGER_GROUP_NAME));
            if (trigger == null) {
                return;
            }
            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(time)) {
                JobDetail jobDetail = sched.getJobDetail(JobKey.jobKey(jobName,JOB_GROUP_NAME));
                Class objJobClass = jobDetail.getJobClass();
                removeJob(jobName);
                addJob(jobName, objJobClass, time);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /** *//**
     * 修改一个任务的触发时间  无效
     * @param triggerName
     * @param triggerGroupName
     * @param time
     * @throws SchedulerException
     * @throws ParseException
     */
//    public static void modifyJobTime(String triggerName,String triggerGroupName,
//                                     String time)
//            throws SchedulerException, ParseException{
////        Scheduler sched = sf.getScheduler();
////        Trigger trigger =  sched.getTrigger(TriggerKey.triggerKey(triggerName,triggerGroupName));
////        if(trigger != null){
////            CronTriggerImpl cti = (CronTriggerImpl) trigger;
////            //修改时间
////            cti.setCronExpression(time);
//////            CronTrigger ct = TriggerBuilder.newTrigger()
//////                    .withSchedule(CronScheduleBuilder.cronSchedule(time)).build();//修改时间
////            //重启触发器
////            sched.resumeTrigger(TriggerKey.triggerKey(triggerName,triggerGroupName));
////        }
//
//        try {
//            Scheduler sched = sf.getScheduler();
//            CronTrigger trigger = (CronTrigger) sched.getTrigger(TriggerKey.triggerKey(triggerName,triggerGroupName));
//            if (trigger == null) {
//                return;
//            }
//            String oldTime = trigger.getCronExpression();
//            if (!oldTime.equalsIgnoreCase(time)) {
//                sched.pauseTrigger(TriggerKey.triggerKey(triggerName, triggerGroupName));
//                CronTriggerImpl cronTrigger = (CronTriggerImpl)trigger;
//                // 修改时间
//                cronTrigger.setCronExpression(time);
//                // 重启触发器
//                sched.resumeTrigger(TriggerKey.triggerKey(triggerName, triggerGroupName));
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    /** *//**
     * 移除一个任务(使用默认的任务组名，触发器名，触发器组名)
     * @param jobName
     * @throws SchedulerException
     */
    public static void removeJob(String jobName)
            throws SchedulerException{
        Scheduler sched = sf.getScheduler();
        sched.pauseTrigger(TriggerKey.triggerKey(jobName,TRIGGER_GROUP_NAME));//停止触发器
        sched.unscheduleJob(TriggerKey.triggerKey(jobName,TRIGGER_GROUP_NAME));//移除触发器
        sched.deleteJob(JobKey.jobKey(jobName,JOB_GROUP_NAME));//删除任务
    }

    /** *//**
     * 移除一个任务
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     * @throws SchedulerException
     */
    public static void removeJob(String jobName,String jobGroupName,
                                 String triggerName,String triggerGroupName)
            throws SchedulerException{
        Scheduler sched = sf.getScheduler();
        sched.pauseTrigger(TriggerKey.triggerKey(triggerName,triggerGroupName));//停止触发器
        sched.unscheduleJob(TriggerKey.triggerKey(triggerName,triggerGroupName));//移除触发器
        sched.deleteJob(JobKey.jobKey(jobName,jobGroupName));//删除任务
    }
}