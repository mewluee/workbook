package com.example.coreConcept;

import com.example.coreConcept.member.MemberService;
import com.example.coreConcept.singleton.SingletonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {
    static DependencyConfig dependencyConfig=new DependencyConfig();

    static AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(DependencyConfig.class);

    //static MemberService memberService1=dependencyConfig.memberService();
    //static MemberService memberService2=dependencyConfig.memberService();
    static MemberService memberService1=ac.getBean("memberService", MemberService.class);
    static MemberService memberService2=ac.getBean("memberService", MemberService.class);
    //이부분에 대해서 고민한게 onenote에 적혀있음!

    static SingletonService singletonService1=SingletonService.getInstance();
    static SingletonService singletonService2=SingletonService.getInstance();

    public static void main(String[] args){

        System.out.println("memberService1:"+memberService1); //1,2가 서로 다른 주소
        System.out.println("memberService2:"+memberService2);

        System.out.println("singletonService1:"+singletonService1); //1,2가 같은 주소
        System.out.println("singletonService2:"+singletonService2);
    }
}
