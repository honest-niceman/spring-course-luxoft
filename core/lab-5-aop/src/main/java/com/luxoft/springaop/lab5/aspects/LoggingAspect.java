package com.luxoft.springaop.lab5.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	private final static Logger LOG = Logger.getLogger(LoggingAspect.class.getName());

	@Pointcut("execution(* *.set*(..))")
	public void setterMethod() {
	}

	@Around("setterMethod() ")
	public Object setterLogger(ProceedingJoinPoint thisJoinPoint) throws Throwable {
		String methodName = thisJoinPoint.getSignature().getName();
		Object[] methodArgs = thisJoinPoint.getArgs();
		StringBuilder args = new StringBuilder();
		for (Object arg: methodArgs) {
			if (args.length()>0) args.append(", ");
			args.append(arg.toString());
		}
		LOG.info("Call method " + methodName + " with args " + args);
		Object result = thisJoinPoint.proceed();
		LOG.info("Method " + methodName + " returns " + result);
		return result;
	}
}
