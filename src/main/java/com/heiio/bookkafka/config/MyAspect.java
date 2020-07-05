package com.heiio.bookkafka.config;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @Pointcut("execution(* com.heiio.bookkafka.model.*.*(..))")
    public void myPointCut() {

    }

    @Before("myPointCut()")
    public void beforeMethod() {
        System.out.println("Before");
    }

    @After("myPointCut()")
    public void afterMethod() {
        System.out.println("After");
    }
}
