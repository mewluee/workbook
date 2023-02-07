package com.example.coreConcept;

import com.example.coreConcept.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }
    //TestBean클래스를 BeanDefinition이라고 넘겨줬지만
    //@Configuration과 @Bean을 해두지 않아서 빈이 등록이 안됨.
    //그런 상태에서 @Autowired 애너테이션을 보고 의존성 주입을 해보지만..!
    //응 안돼!!! 그래서 오류 발생하는데 그걸 처리하는 방법임.

    static class TestBean {

        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
