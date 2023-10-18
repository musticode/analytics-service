package com.example.analyticsservice.aspect;


import com.example.analyticsservice.service.impl.LogServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ServiceAspect {



    @Before(value = "execution(* com.example.analyticsservice.service.impl.LogServiceImpl.*(..)))")
    public void beforeAdvice(JoinPoint joinPoint){
        log.info("Before...");
        log.info("Signature: {}",joinPoint.getSignature().toString());
    }

    @AfterReturning(value = "execution(* com.example.analyticsservice.service.impl.LogServiceImpl.*(..)))")
    public void afterAdvice(JoinPoint joinPoint){
        log.info("After... ");
        log.info("Signature: {}",joinPoint.getSignature().toString());
    }


}
