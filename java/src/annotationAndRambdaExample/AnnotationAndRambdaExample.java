package annotationAndRambdaExample;

import java.util.function.BiFunction;

interface ExampleInterface{
    void example();
}

class ExampleClass implements ExampleInterface{

    //애너테이션 Annotation : 컴퓨터한테 정보 전달. <-> 사람은 주석으로 전달
    //@Override : 정보를 받으면 컴퓨터는 해당 클래스(하위 클래스)의 상위 클래스에 똑같은 이름의 메서드가 있는기 검사 > 없으면 컴파일 에러
    //컴파일 에러는 보통 신택스(문법적오류) 컴파일시 에러
    @Override
    public void example() {

    }
}

class OldClass{


    //@FunctionalInterface : 함수형 인터페이스를 선언할 때, 함수형 인터페이싀 선언이 바르게 되었는지 > 인터페이스가 단 하나의 추상 메서드를 갖고있는지
    //@SuppressWarnings : 컴파일 경고 메세지가 나타나지 않도록 함.  ex)@SuppressWarnings("deprecation")
    //@Deprecated : 다른 코드와의 호환성 문제로 남겨둬야하지만 사용을 권장하지 않을 때 사용 > 컴퓨터는 경고메세지를 띄움
    @Deprecated
    private int oldField;

    @Deprecated
    int getOldField(){
        return oldField;
    }

}

interface ExampleFunction{

    int sum(int num1, int num2);
}


class Member{
    private String name;
    private String id;

    public Member(String name){
        this.name=name;
    }

    public Member(String name, String id){
        this.name=name;
        this.id=id;
    }

    public String getInfo(){
        return name+">>"+id+" login";
    }
}


public class AnnotationAndRambdaExample {

    public void result(){

        OldClass oldClass=new OldClass();
        System.out.println(oldClass.getOldField()); // 잉.. 중간줄 안생기는데..?


        /*

        ExampleFunction exampleFunction = new 익명객체(){
            int sum(int num1, int num2){
                return num1+num2;
            }
        };

        */

        // 변수에 메서드를 할당하는 느낌으로.
        ExampleFunction exampleFunction =  (int num1, int num2) -> {
                                                                        System.out.println("메서드용");
                                                                        return num1+num2;
                                                                    };
        // >> ExampleFunction exampleFunction = (int num1, int num2) -> num1+num2;
        // 실행문이 한줄짜리로 가능하면 중괄화{}와 return문 생략 가능
        //


        // 그리고 인터페이스는 어떠한 기능이 있다는 걸 보장하기 때문에 이러한 특성을 이용해서 함수형 인터페이스를 만든 것 같다.
        System.out.println(exampleFunction.sum(2,5));
        // 인터페이스를 선언해놨기 때문에, sum함수가 있는 것은 보장. 근데 람다식에서는 1:1 매칭뿐이다.
        // 함수형 인터페이스는 하나의 인터페이스엔 하나의 추상메서드만 있으니까
        // 인터페이스 선언 유무에 따라 우선 에러 확인하고 작업 수행하는 느낌?
        // @FuctionalInterface 애너테이션이 정보전달함.


        // 메서드 참조 방식 구현
        // 클래스명 :: (정적)메서드 >> 이건 약간 Math.pow(n,m) 이런애들쓸때 좋음!
        // 참조변수 :: 메서드
        // 참조변수 :: 생성자(생성자도 사실 따지면 메서드니까 가능하다:연산자 new 로만 표현하는 차이만 있음)
        BiFunction<String, String, Member> biFunction = Member :: new;
        Member member=biFunction.apply("haneul","luee");

        System.out.println(member.getInfo());



    }
}
