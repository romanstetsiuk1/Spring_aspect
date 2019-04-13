package com.romanstetsiuk.spring_aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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

    @AfterReturning(pointcut = "upperPointcut()", returning = "result")
    public void returningName(JoinPoint joinPoint, String result) {
        log.info("Zwrocono: " + result + " dla metody " + joinPoint.toLongString());
    }

    @Around("upperPointcut()")
    public Object aroundName(ProceedingJoinPoint point) {
        log.info("Przed");

        Object object = null;

        try {
            point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            log.info("po metodzie");
            return object;
        }
    }

    @AfterThrowing(pointcut = "execution(* com.romanstetsiuk.spring_aspect.UserService.*(..))",
            throwing = "e")
    public void afterThroe(Throwable e) {
        log.error("Wystapil blad", e);
    }

    @Pointcut("execution(public String getUpperName())")
    public void upperPointcut() {
    }

}
