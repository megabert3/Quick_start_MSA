package com.example.restservice.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Aspect()
public class LoggingAspect {

    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Pointcut("within(com.example.restservice.GreetingController)")
    public void processingMethod() { }

    @Before("processingMethod()")
    public void getMethodArgs(JoinPoint joinPoint) {
        Object[] methodArgs = joinPoint.getArgs();

        logger.log(Level.INFO, "Аргументы метода: " + Arrays.toString(methodArgs));
    }

    @AfterReturning(pointcut = "processingMethod()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.log(Level.INFO, "Возвращаемое значение: " + result);
    }

    @Around("@annotation(com.example.restservice.customAnnotation.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        logger.log(Level.INFO, "Метод: " + joinPoint.getSignature() + " выполнен за " + executionTime + "мс");
        return proceed;
    }
}
