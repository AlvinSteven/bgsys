package com.vuetests.bgsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import io.sentry.Sentry;

@SpringBootApplication
public class BgsysApplication {

    public static void main(String[] args) {
//        Sentry.init("https://public:private@host:port/1");
        SpringApplication.run(BgsysApplication.class, args);
    }

}
