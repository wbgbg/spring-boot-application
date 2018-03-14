package com.yugi.application.web;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {

    @Pointcut("execution(* com.yugi.application.web..*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void userControllerMethodPointcut() {}

    @Around("userControllerMethodPointcut()")
    public Object Interceptor(ProceedingJoinPoint jp) throws Throwable {
        Signature signature = jp.getSignature();
        System.out.print(signature);
        System.out.println(" start");
        Object result = jp.proceed();
        System.out.print(signature);
        System.out.println(" stop");
        return result;
    }
}
