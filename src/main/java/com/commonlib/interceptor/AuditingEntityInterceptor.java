package com.commonlib.interceptor;

import com.commonlib.annotation.EntityListener;
import com.commonlib.domain.enumration.ActionType;
import com.commonlib.util.action.AuditingEntityListener;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Aspect
@Slf4j
@Component
public class AuditingEntityInterceptor {

    @Autowired
    private ApplicationContext applicationContext;

    @Pointcut("execution(* com.*.service.*.update(..))")
//    @Pointcut("within(com.usermanagement.service..*)")
    public void loggingUpdateServicePointcut() {
        log.info("loggingPointcut");
    }

    @Pointcut("execution(* com.*.service.*.create(..))")
    public void loggingCreateServicePointcut() {
        log.info("loggingPointcut");
    }

    @Pointcut("execution(* com.*.service.*.remove(..))")
    public void loggingDeleteServicePointcut() {
        log.info("loggingPointcut");
    }

    @Around(value = "loggingUpdateServicePointcut() || loggingCreateServicePointcut()")
    public Object aroundCreateAndUpdate(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        EntityListener entityLoggerAnnotation = proceedingJoinPoint.getTarget().getClass().getAnnotation(EntityListener.class);
        if (Objects.isNull(entityLoggerAnnotation)) {
            return proceedingJoinPoint.proceed();
        }

        // call original method
        String calledMethodName = proceedingJoinPoint.getSignature().getName();
        AuditingEntityListener actionLogger = getActionLogger(entityLoggerAnnotation);
        try {
            Object object = proceedingJoinPoint.proceed();
            if (isLogActivateOnMethod(entityLoggerAnnotation.createMethods(), calledMethodName)) {
                actionLogger.log(object, ActionType.CREATE);
            }
            if (isLogActivateOnMethod(entityLoggerAnnotation.updateMethods(), calledMethodName)) {
                actionLogger.log(object, ActionType.UPDATE);
            }
            return object;
        } catch (Exception exception) {
//            if (isLogActivateOnMethod(entityLoggerAnnotation.createMethods(), calledMethodName)) {
//                actionLogger.log(proceedingJoinPoint.getArgs()[0], ActionType.FAILED_TO_CREATE, exception);
//            }
            if (isLogActivateOnMethod(entityLoggerAnnotation.updateMethods(), calledMethodName)) {
                actionLogger.log(proceedingJoinPoint.getArgs()[0], ActionType.FAILED_TO_UPDATE, exception);
            }

            throw exception;
        }
    }

    @Around(value = "loggingDeleteServicePointcut()")
    public void aroundDelete(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        EntityListener entityLoggerAnnotation = proceedingJoinPoint.getTarget().getClass().getAnnotation(EntityListener.class);

        Object[] args = proceedingJoinPoint.getArgs();
        if (Objects.isNull(entityLoggerAnnotation)) {
            proceedingJoinPoint.proceed(args);
            return;
        }

        // call original method
        String calledMethodName = proceedingJoinPoint.getSignature().getName();
        AuditingEntityListener actionLogger = getActionLogger(entityLoggerAnnotation);
        try {
            proceedingJoinPoint.proceed();
            if (isLogActivateOnMethod(entityLoggerAnnotation.deleteMethods(), calledMethodName)) {
                actionLogger.log(args[0], ActionType.DELETE);
            }
        } catch (Exception exception) {
            if (isLogActivateOnMethod(entityLoggerAnnotation.deleteMethods(), calledMethodName)) {
                actionLogger.log(args[0], ActionType.FAILED_TO_DELETE, exception);
                throw exception;
            }
        }
    }

    @AfterThrowing(value = "loggingUpdateServicePointcut() || loggingCreateServicePointcut()", throwing = "exception")
    public void afterCreateAndUpdateThrowingException(JoinPoint joinPoint,
                                                      Exception exception) {
        log.info("afterCreateAndUpdateThrowingException with signature = "  + joinPoint.getSignature() +
                ", exception = " + exception);
    }

    private static boolean isLogActivateOnMethod(String[] entityLoggerAnnotation, String calledMethodName) {
        return Arrays.stream(entityLoggerAnnotation).allMatch(allowedMethod -> allowedMethod.equals(calledMethodName));
    }

    private AuditingEntityListener getActionLogger(EntityListener entityLoggerAnnotation) {
        return (AuditingEntityListener) applicationContext.getBean(entityLoggerAnnotation.listenerClass());
    }

}
