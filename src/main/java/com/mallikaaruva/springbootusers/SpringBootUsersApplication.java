package com.mallikaaruva.springbootusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mallikaaruva.springbootusers.controller"})
public class SpringBootUsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootUsersApplication.class, args);
    }
}
