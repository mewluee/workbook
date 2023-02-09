package com.example.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Slf4j
@Aspect
public class Aspect5 {
    @Aspect
    @Order(2)
    public static class LogAspect {
        @Around("com.example.aop.order.aop.Pointcuts.allOrder()")
        public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
            log.info("log -> {}", joinPoint.getSignature());
            return joinPoint.proceed();
        }
    }

    @Aspect
    @Order(1)
    public static class TxAspect {
        //doTranscation메서드는 부가기능 즉, 어드바이스임.
        //Around어노테이션으로 해당 어드바이스를 어떤 타켓(메서드)에, 어느시점에 할지 표현식으로 정리되어있음
        //그런데 Pointcuts 객체의 메서드를 참조? 호출함.그럼 거기로가겟지..?
        @Around("com.example.aop.order.aop.Pointcuts.orderAndService()")
        public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {

            try {
                log.info("트랜잭션 시작 -> {}", joinPoint.getSignature());
                Object result = joinPoint.proceed();
                // 타겟 메서드 실행(즉 핵심로직) // 어떤 메서드냐 하면...포인트컷에서 알려줌
                //포인트컷 객체 내부의 orderAndService()메서드 위에
                //@PointCut 어노테이션으로 알려줌. (표현식)

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
}
