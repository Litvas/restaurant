package com.restaurant.client.menuservice.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("@annotation(com.restaurant.client.menuservice.annotation.Loggable))")
    public void catchExceptions() {
    }

    @Around("catchExceptions()")
    public Object logCriticalExceptions(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        long startTime = System.currentTimeMillis();

        try {
            Object result = joinPoint.proceed();
            long endTime = System.currentTimeMillis();
            log.info("{}#{} finished success. Result: {} [{} ms]", className, methodName, result, endTime - startTime);
            return result;
        } catch (RuntimeException ex) {
            log.error("{}#{} has an exception. Reason: {}", className, methodName, ex.getMessage(), ex);
            throw ex;
            }
        }

}
