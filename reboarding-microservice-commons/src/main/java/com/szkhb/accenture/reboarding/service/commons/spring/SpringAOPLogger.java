package com.szkhb.accenture.reboarding.service.commons.spring;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.util.StopWatch;

@Configuration
@EnableAspectJAutoProxy
@Aspect
public class SpringAOPLogger {
  @Pointcut("execution(* *(..)) && within(com.szkhb.accenture.reboarding..*)")
  public void methodCallInServiceLayer() {
  }

  @Pointcut("@annotation(org.springframework.context.annotation.Bean) && within(com.szkhb.accenture.reboarding..*)")
  public void beanMethodCall() {
  }

  @Around("methodCallInServiceLayer()")
  public Object logMethodExecutionTime(ProceedingJoinPoint jp) throws Throwable {
    String targetName = jp.getSignature().getDeclaringTypeName();
    String methodName = jp.getSignature().getName();
    Object[] args = jp.getArgs();
    Logger logger = LoggerFactory.getLogger(targetName);
    final StopWatch stopWatch = new StopWatch();
    logger.info("called: " + methodName + "(" + toPrintableArray(args) + ")");
    stopWatch.start();
    Object result = null;
    try {
      result = jp.proceed();
      stopWatch.stop();
      logger.info("returned: " + " after " + stopWatch.getTotalTimeMillis() + "ms: " + methodName + "(" + toPrintableArray(args) + ") => " + toPrintable(result));
    } catch (Throwable e) {
      logger.error("failed with  [" + e + "] after " + stopWatch.getTotalTimeMillis() + "ms: " + methodName + "(" + toPrintableArray(args) + ")");
      throw e;
    }

    return result;
  }

  @After("beanMethodCall()")
  public void logBeanCall(JoinPoint jp) {
    String targetName = jp.getSignature().getDeclaringTypeName();
    String methodName = jp.getSignature().getName();
    Logger logger = LoggerFactory.getLogger("additionallogging.using.bean");
    logger.info(methodName + "@" + targetName + " has been called.");
  }

  private String toPrintableArray(Object[] objs) {
    return Arrays.asList(objs).stream().map(this::toPrintable).collect(Collectors.joining(", "));
  }

  private String toPrintable(Object obj) {
    String printable = "null";
    if (obj != null) {
      if (obj.getClass().isArray()) {
        printable = "Array [";
        printable += Arrays.stream((Object[]) obj)
          .map(item -> toPrintable(item))
          .collect(Collectors.joining(", "));
        printable += "]";
      } else {
        printable = "(" + obj.getClass().getSimpleName() + ") " + obj;
      }
    }
    return printable;
  }
}