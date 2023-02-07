package com.example.coreConcept;

import com.example.coreConcept.coffee.CoffeeRepository;
import com.example.coreConcept.coffee.CoffeeService;
import com.example.coreConcept.member.MemberRepository;
import com.example.coreConcept.member.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class DependencyConfig {

 /*   @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository()); //하단의 메서드 호출
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemberRepository();
    }

    @Bean
    public CoffeeService coffeeService() {
        return new CoffeeService(coffeeRepository()); //하단의 메서드 호출
    }

    @Bean
    public CoffeeRepository coffeeRepository() {
        return new CoffeeRepository();
    }*/
}
