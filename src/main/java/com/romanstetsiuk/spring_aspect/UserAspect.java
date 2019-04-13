package com.romanstetsiuk.spring_aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {

    Logger log = LoggerFactory.getLogger(UserAspect.class);

    @Before("upperPointcut()")
    public void beforeUpper() {
        log.info("Przed metoda upper");
    }

    @Pointcut("execution(public String getUpperName())")
    public void upperPointcut() {
    }

}
