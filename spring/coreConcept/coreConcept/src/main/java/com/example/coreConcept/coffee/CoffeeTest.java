package com.example.coreConcept.coffee;

import com.example.coreConcept.DependencyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CoffeeTest {
    public static void main(String[] args){
        //DependencyConfig dependencyConfig=new DependencyConfig();
        //CoffeeService coffeeService = dependencyConfig.coffeeService();

        ApplicationContext ac=new AnnotationConfigApplicationContext(DependencyConfig.class);
        CoffeeService coffeeService=ac.getBean("coffeeService",CoffeeService.class);
        //CoffeeService.class타입의 이름이 coffeeService의 빈을 불러오겠다.

        Coffee coffee = new Coffee(0L, "바닐라 라떼", "vanilla latte", 5000);
        coffeeService.createCoffee(coffee);

        if(coffeeService.getCoffee(0L).getKorName().equals(coffee.getKorName())) {
            System.out.println("바닐라 라떼가 등록되었습니다.");
        }

        coffeeService.editCoffee(0L, "바닐라 라떼", 3000);

        if(coffeeService.getCoffee(0L).getPrice() == 3000) {
            System.out.println("바닐라 라떼의 금액이 정상적으로 변경되었습니다.");
        }

        coffeeService.deleteCoffee(0L);

        if(coffeeService.getCoffee(0L) == null) {
            System.out.println("바닐라 라떼가 정상적으로 삭제되었습니다.");
        }
    }
}
