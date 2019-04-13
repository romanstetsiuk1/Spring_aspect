package com.romanstetsiuk.spring_aspect.restController;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class MessageAspect {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    void getPointcut() {
    }

    @Before("getPointcut() && args(..,request)")
    void beforeRequst(HttpServletRequest request) {
        System.out.println("Przed żądaniem");
        System.out.println(request.getPathInfo());
    }

    @AfterReturning("getPointcut()")
    void afterGet() {
        System.out.println("Po żądaniu");
    }
}
