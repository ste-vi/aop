package org.stevi.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* org.stevi.springaop.service.*.*(..))")
    public void serviceMethods() {}

    @Pointcut("@annotation(org.stevi.springaop.annotation.NotLoggable)")
    public void annotationNotLoggable() {}

    @Before("serviceMethods() && !annotationNotLoggable()")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        System.out.println("Before method " + className + "." + methodName);
    }
}
