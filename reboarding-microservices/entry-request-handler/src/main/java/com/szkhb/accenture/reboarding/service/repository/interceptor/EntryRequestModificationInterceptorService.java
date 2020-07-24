package com.szkhb.accenture.reboarding.service.repository.interceptor;

import java.util.Set;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import com.szkhb.accenture.reboarding.repository.EntryRequestRepository;

@Service
@Aspect
public class EntryRequestModificationInterceptorService {

  private static final Logger logger = LoggerFactory.getLogger(EntryRequestModificationInterceptorService.class);

  @Autowired
  private EntryRequestRepository repository;

  private Set<EntryRequestModificationInterceptor> interceptors;

  @Pointcut("@target(org.springframework.stereotype.Repository)")
  public void methodCallInEntryRequestRepository() {
  }

  @Pointcut("@target(org.springframework.stereotype.Repository)")
  public void methodCallInEntryRequestRepository() {
  }

  // @Around("methodCallInEntryRequestRepository()")
  public Object logMethodExecData(ProceedingJoinPoint jp) throws Throwable {
    String targetName = jp.getSignature().getDeclaringTypeName();
    String methodName = jp.getSignature().getName();
    Object[] args = jp.getArgs();
    Logger logger = LoggerFactory.getLogger(targetName);
    final StopWatch stopWatch = new StopWatch();
    logger.warn("called: " + methodName + "(" + args + ")");
    stopWatch.start();
    Object result = null;
    try {
      result = jp.proceed();
      stopWatch.stop();
      logger.info("returned: " + " after " + stopWatch.getTotalTimeMillis() + "ms: " + methodName + "(" + args + ") => " + result);
    } catch (Throwable e) {
      logger.error("failed with  [" + e + "] after " + stopWatch.getTotalTimeMillis() + "ms: " + methodName + "(" + args + ")");
      throw e;
    }
    return result;
  }

}
