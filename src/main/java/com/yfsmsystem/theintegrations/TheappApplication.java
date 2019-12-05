package com.yfsmsystem.theintegrations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TheappApplication {

    public static void main(String[] args) {
        SpringApplication.run(TheappApplication.class, args);
    }

}
