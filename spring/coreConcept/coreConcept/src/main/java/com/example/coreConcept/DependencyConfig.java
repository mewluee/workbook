package com.example.coreConcept;

import com.example.coreConcept.coffee.CoffeeRepository;
import com.example.coreConcept.coffee.CoffeeService;
import com.example.coreConcept.member.MemberRepository;
import com.example.coreConcept.member.MemberService;

public class DependencyConfig {

    public MemberService memberService() {
        return new MemberService(memberRepository()); //하단의 메서드 호출
    }

    public MemberRepository memberRepository() {
        return new MemberRepository();
    }

    public CoffeeService coffeeService() {
        return new CoffeeService(coffeeRepository()); //하단의 메서드 호출
    }

    public CoffeeRepository coffeeRepository() {
        return new CoffeeRepository();
    }
}
