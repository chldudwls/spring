package com.ch03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAdvice {
    // 포인트컷
    @Pointcut("execution(void com.ch03.MyService.insert())")
    public void insertPointCut(){}

    @Pointcut("execution(void com.ch03.MyService.select(..))")
    public void selectPointCut(){}


    @Before("insertPointCut() || selectPointCut()")
    public void defareAdvice() {
        System.out.println("부가기능 - defareAdvice");
    }

    @After("insertPointCut()")
    public void afterAdvice() {
        System.out.println("부가기능 - aferAdvice");

    }

    @AfterReturning("insertPointCut()")
    public void afterReturningAdvice() {
        System.out.println("부가기능 - afterReturningAdvice");

    }

    @Around("insertPointCut()")
    public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("부가기능 - aroundAdvice...1");
        pjp.proceed();
        System.out.println("부가기능 - aroundAdvice...2");

    }

    @AfterThrowing("selectPointCut()")
    public void afterThrowingAdvice() {
        System.out.println("부가기능 - afterThrowingAdvice");


    }

}
