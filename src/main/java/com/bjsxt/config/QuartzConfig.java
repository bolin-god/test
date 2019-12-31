package com.bjsxt.config;

import com.bjsxt.quartz.QuartzDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean factory = new JobDetailFactoryBean();
        factory.setJobClass(QuartzDemo.class);
        return factory;
    }
/*    @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        SimpleTriggerFactoryBean factory = new SimpleTriggerFactoryBean();
        factory.setJobDetail(jobDetailFactoryBean.getObject());
        factory.setRepeatInterval(2000);
        factory.setRepeatCount(5);
        return factory;
    }*/
    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        CronTriggerFactoryBean factory = new CronTriggerFactoryBean();
        factory.setJobDetail(jobDetailFactoryBean.getObject());
        factory.setCronExpression("0/2 * * * * ?");
        return factory;

    }
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean simpleTriggerFactoryBean,MyAdapableJobFactory myAdapableJobFactory){
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setTriggers(simpleTriggerFactoryBean.getObject());
        factory.setJobFactory(myAdapableJobFactory);
        return factory;
    }
}
