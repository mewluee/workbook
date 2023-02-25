package com.example.aop.order.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
    //결과적으로 order이하의 모든 패키지 하단의 메서드를 타켓으로 한다!!!!!!!
    @Pointcut("execution(* com.example.aop.order..*(..))")
    public void allOrder(){}

    //Service이름을 갖고있는 클래스의 메서드를 타겟으로 한다!?!?!??
    @Pointcut("execution(* *..*Service.*(..))")
    public void allService(){}

    //아 위에 메서드를 참조하라고 하네..
    @Pointcut("allOrder() && allService()")
    public void orderAndService(){}
}
