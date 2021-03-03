package tn.esprit.spring.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class TimerAndLoggingAspect {
private static final Logger logger =
LogManager.getLogger(TimerAndLoggingAspect.class);
@Before("execution(* tn.esprit.spring.services.*.*(..))")
public void logMethodEntry(JoinPoint joinPoint) {
String name = joinPoint.getSignature().getName();
logger.info(" Started Service  " + name + " : ");
}
@After("execution(* tn.esprit.spring.services.*.*(..))")
public void logMethodExit(JoinPoint joinPoint) {
String name = joinPoint.getSignature().getName();
logger.info("Out of Service " + name+ "  !" );
}
@Around("execution(* tn.esprit.spring.services.*.*(..))")
public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
  long startTime = System.nanoTime();
  try {
    return joinPoint.proceed();
  }
  finally {
    System.out.println(joinPoint + "  execution time of service  ->  " + (System.nanoTime() - startTime) / 1000000 + " ms");
  }
}
}
