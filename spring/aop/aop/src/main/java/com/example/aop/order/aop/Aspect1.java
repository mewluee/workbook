package com.example.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class Aspect1 {

    @Around("execution(* com.example.aop.order..*(..))")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("log -> {}", joinPoint.getSignature());
        return joinPoint.proceed();
    }

    //한줄씩 해석보기

    //logging메서드가 어드바이스가 됨.
    //어드바이스 >> 공통기능 코드라고 생각하면 되고~,
    //아 애너테이션들이 해당 공통기능들의 동작 시점인 거고, 이게 총 5가지가 있는 거임.
    //@Around는 메서드 호출 자체를 가로채서 비즈니스 메소드 실행 전 & 후 모두에 처리할 로직을 삽입할 수 있다.
    //클라이언트의 요청을 가로챈 어드바이스는, 클라이언트가 호출한 비즈니스 메서드를 호출하기 위해서
    //ProceedingJoinPoint객체의 proceed() 메서드를 이용해서 비즈니스 메서드를 호출할 수 있다.

    //?????OrderService와 OrderRepository의 모든 메서드는 AOP 적용 대상이 됩니다.???예 갑자기요?

    //포인트컷은 어떤 메서드에 이 어드바이스를 적용할건지 알ㄹ려줌.
    //어드바이스의 인자로 들어가는게 포인트 컷인데 AspectJ가 제공하는 포인트컷 표현식으로 표현
    //즉 "execution(* example.aop.order..*(..))"
    // execution( ) > 포인트컷 지시자 Pointcut Designator =PCD로 시작함.
    // 어떤 특정 메서드 실행
    // 포인트 컷은 어드바이스가 실행되는 시기를 제어한다.
    //저 위치에 있는 모든 메서드에 저 어드바이스가 적용할거라는 의미

    //joinPoint.getSignature() > Signature객체 반환 : 어드바이스 메소드를 구현하기 위해서 클라이언트가 호출한 비즈니스 메소드의 정보가 필요함.
    //즉 이 메서드를 호출할때 클라이언트가 내가 어떤 비즈니스 로직을 하고있는지 해당 메서드에게 처리를 위한 정보를 넘겨주는 느낌?????
    //public interface " ProceedingJoinPoint " ( extends JoinPoint )
    //joinpoint 클래스한테서 상속받은 메서드 (getSignature / getTarget/ getArgs)
    //ProceedingJoinPoint 인터페이스에 선언된 메서드 (proceed)
    //(!!주의!!) Around 어드바이스에서만 ProceedingJoinPoint를 매개변수로 사용한다. 즉 proceed()메서드가 필요
    //나머지 어드바이스는 joinpoint를 매개변수로 사용한다.

    //예외처리 Throwabel 클래스(예외처리 최상위 클래스)
    //예외처리를 현재 메소드가 직접 처리하지 않고 호출한 곳에다가 예외의 발생 여부를 통보한다.
    //호출한 메소드는 이걸 또 던질건지 직접 처리할 건지 정해야한다(return보다 강력)
}
