package com.luxoft.springaop.lab5.aspects;

import com.luxoft.springaop.lab5.exceptions.ValidationException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class ValidationAspect {
    @Pointcut("execution(* *.setAge(..))")
    public void setAgeMethod() {
    }

    @Before("setAgeMethod()")
    public void checkAge(JoinPoint joinPoint) throws Throwable {
        Object[] methodArgs = joinPoint.getArgs();
        Integer age = (Integer) methodArgs[0];
        if (age > 100) {
            throw new ValidationException("Wrong age: "+age);
        }
    }
}
