package com.example.easyexcel.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author madio
 */
@Aspect
@Component
public class LogAspect {

    /**
     * 此处的切点是注解的方式，也可以用包名的方式达到相同的效果
     * '@Pointcut("execution(* com.wwj.springboot.service.impl.*.*(..))")'
     */
    @Pointcut("execution(* com.example.easyexcel.pojo.Person.getName(..))")
    public void operationLog() {
    }


    @Before("operationLog()")
    public void doBeforeAdvice(JoinPoint joinPoint) {
        System.out.println("Before进入方法前执行.....");
    }

    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     */
    @After("operationLog()")
    public void after(JoinPoint jp) {
        System.out.println("After方法最后执行.....");
    }

    /**
     * 处理完请求，返回内容
     *
     * @param ret
     */
    @AfterReturning(returning = "ret", pointcut = "operationLog()")
    public void doAfterReturning(Object ret) {
        System.out.println("AfterReturning方法的返回值 : " + ret);
    }

    /**
     * 后置异常通知
     */
    @AfterThrowing("operationLog()")
    public void throwss(JoinPoint jp) {
        System.out.println("AfterThrowing方法异常时执行.....");
    }


    /**
     * 环绕通知,环绕增强，相当于MethodInterceptor
     */
    @Around("operationLog()")
    public Object arround(ProceedingJoinPoint pjp) {
        System.out.println("Around方法环绕start.....");
        try {
            Object o = pjp.proceed();
            System.out.println("Around方法环绕proceed，结果是 :" + o);
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

}