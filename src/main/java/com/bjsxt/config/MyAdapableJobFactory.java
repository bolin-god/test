package com.bjsxt.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

@Component("myAdapableJobFactory")
public class MyAdapableJobFactory extends AdaptableJobFactory {
    @Autowired
   private AutowireCapableBeanFactory autowireCapableBeanFactory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object jobInstance = super.createJobInstance(bundle);
        this.autowireCapableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
