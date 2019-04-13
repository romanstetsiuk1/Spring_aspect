package com.romanstetsiuk.spring_aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAspectApplication implements CommandLineRunner {

    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SpringAspectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userService.getUpperName();
        userService.error();
    }
}
