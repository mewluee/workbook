package com.example.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class Aspect3 {
    //@Around와 @Pointcut의 차이가 뭐죵.
    //@Pointcut 어노테이션이 적용된 메서드는 몸체에 코드가 없어야함.
    //@Around 안에 Pointcut 어노테이션이 적용된 메서드가 적ㅇ히면
    //해당 메서드의 위에 적용된 @Pointcut( 표현식 ) 을 참조하게됨.
    //약간 한다리 걸치는 느낌 !!!!

    @Pointcut("execution(* com.example.aop.order..*(..))")
    private void allOrder(){} //몸체없쥬 위에 포인트컷 어노테이션임.

    @Pointcut("execution(* *..*Service.*(..))")
    private void allService(){}

    //이게 Aspect4에서는 포인트컷만 따로 모은 클래스를 만들어서 참조함.
    @Around("allOrder()") // 위에서 선언된 포인트컷 적용 메서드의 이름을 갖고옴.
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("log -> {}", joinPoint.getSignature());
        return joinPoint.proceed();
    }

    @Around("allOrder() && allService()")
    public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {

        try {
            log.info("트랜잭션 시작 -> {}", joinPoint.getSignature());
            Object result = joinPoint.proceed();
            log.info("트랜잭션 커밋 -> {}", joinPoint.getSignature());
            return result;
        } catch (Exception e) {
            log.info("트랜잭션 롤백 -> {}", joinPoint.getSignature());
            throw e;
        } finally {
            log.info("리소스 릴리즈 -> {}", joinPoint.getSignature());
        }
    }
}
