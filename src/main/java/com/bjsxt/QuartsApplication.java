package com.bjsxt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class QuartsApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuartsApplication.class, args);
    }

}
