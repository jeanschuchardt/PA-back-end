package com.example.pa_backend.aspect;

import com.example.pa_backend.exception.ServiceException;
import lombok.extern.apachecommons.CommonsLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@CommonsLog
public class AspectController {

    @Pointcut("execution(public * com.example.pa_backend.controller.*.*(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object aroundHandle(ProceedingJoinPoint pjd) {
        String action = pjd.getSignature().getName();
        log.info(action);
        try {
            return pjd.proceed();
        }
        catch (ServiceException e) {
            log.error(e.getMessage(), e);
            throw e;

        }
        catch (Throwable e) {
            log.error(e.getMessage(), e);
            throw  new RuntimeException();
        }

    }
}
