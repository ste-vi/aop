package org.stevi.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

    @Pointcut("execution(* org.stevi.service.*.*(..))")
    public void serviceMethods() {}

/*    @Pointcut("@annotation(org.stevi.annotation.NotLoggable)")
    public void annotationNotLoggable() {}*/

    //@Before("serviceMethods() && !annotationNotLoggable()")
    @Before("serviceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        System.out.println("Before method " + className + "." + methodName);
    }
}
