package com.romanstetsiuk.spring_aspect.model;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class CompanyAspect {

    Logger log = LoggerFactory.getLogger(Company.class);

    @Before("execution(void com.romanstetsiuk.spring_aspect.model.Company.set*(..))")
    public void beforeSetters(JoinPoint joinPoint) {
        log.info("Przed setterem: " + joinPoint.getSignature().getName());

        Object[] arguments = joinPoint.getArgs();
        List<Object> argumentList = new ArrayList<>(Arrays.asList(arguments));
        argumentList.forEach(System.out::println);
    }

    @AfterReturning(pointcut = "execution(* com.romanstetsiuk.spring_aspect.model.*.get*(..))", returning = "r")
    public void beforeGetters(JoinPoint joinPoint, Object r) {
        log.info("Po getterze");
        log.info(r.toString());
    }

    @Around("execution(* com.romanstetsiuk.spring_aspect.model.Company.Company*(..))")
    public Object beforeCompanyConstructor(ProceedingJoinPoint point) {
        log.info("Przed konstruktorem");
        Object[] arguments = point.getArgs();
        List<Object> argumentList = new ArrayList<>(Arrays.asList(arguments));
        argumentList.forEach(System.out::println);

        Object company = null;
        try {
            company = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            log.info(company.toString());
            return company;
        }
    }


}
