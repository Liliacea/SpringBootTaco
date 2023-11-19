package com.example.tacocloud;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLoggerApplication {
    static final Logger log =
            LoggerFactory.getLogger(SpringLoggerApplication.class);

    public static void main(String[] args) {
        log.info("Before Starting application");
        SpringApplication.run(SpringLoggerApplication.class, args);
        log.debug("Starting my application in debug with {} args", args.length);
        log.info("Starting my application with {} args.", args.length);
    }
}
