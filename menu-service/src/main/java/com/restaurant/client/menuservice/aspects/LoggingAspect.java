package com.restaurant.client.menuservice.aspects;

import com.restaurant.client.menuservice.exception.MenuNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.jdbc.support.MetaDataAccessException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("@annotation(com.restaurant.client.menuservice.annotation.Loggable))")
    public void loggableControllerAndServiceMethods() {
    }

    @Around("loggableControllerAndServiceMethods()")
    public Object logControllerAndServiceExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        String layer = className.contains("Controller") ? "CONTROLLER" : "SERVICE";

        log.info("[{}] call method: {} with arguments: {}", layer, methodName, Arrays.toString(args));

        long startTime = System.currentTimeMillis();

        try {
            Object result = joinPoint.proceed();
            long endTime = System.currentTimeMillis();
            log.info("[{}] method: {} finished success. Result: {} [{} ms]", layer, methodName, result, endTime - startTime);
            return result;
        } catch (Exception ex) {
            log.error("[{}] exception in method: {}. Reason: {}", layer, methodName, ex.getMessage(), ex);

            if (ex instanceof RuntimeException) {
                throw ex;
            } else {
                throw new RuntimeException(ex.getCause());
            }
        }
    }

}
