package com.bjsxt.quartz;

import com.bjsxt.service.UserService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class QuartzDemo implements Job {
    @Autowired
    private UserService userService;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        userService.addUser();
    }
}
