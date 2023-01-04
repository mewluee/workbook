package enumExample;


enum Level {
    LOW, MEDIUM, HIGH
    // 0, 1, 2
}

enum MyLevel {
    LOW, MEDIUM, HIGH
    // LOW=1 OR LOW="low" 이런식으로 값 지정 못함. 상수라고 해서 가능한 줄 알았는데..
    // 배열처럼 0 1 2 3 .. 상수값이 자동으로 할당된다.
}
public class EnumExample {

    // enum 개념
    // 기본 데이터 타입 외에 사용자 지정 타입을 switch 문에서 비교 가능
    // 다양한 메서드로 편리하게 관리 가능
    // 상수명 중복 피함
    // 타입에 대한 안전성 보장
    // 가독성이 좋아짐

    public void result() {
        Level level = Level.MEDIUM;

        Level[] allLevels = Level.values(); // 모든 열거 객체를 배열로 반환
        for (Level l : allLevels){
            System.out.printf("%s=%d\n",l.name(),l.ordinal());
            // name() 상수명 String형 반환
            // ordinal() 열거 객체의 순번 int형 반환 (배열처럼 0부터 시작)
            // 결과값 : LOW = 0
        }

        // 주어진 String형 매개변수와 같은 상수명을 가진 enum 객체 반환
        Level findLevel=Level.valueOf("LOW");

        System.out.println(findLevel);
        System.out.println(Level.LOW==Level.valueOf("LOW"));
        // 결과값: treu
        // enum 객체 == enum 객체 ?

        switch (level){
            case LOW:
                System.out.println("낮은 레벨");
                break;
            case MEDIUM:
                System.out.println("중간 레벨");
                break;
            case HIGH:
                System.out.println("높은 레벨");
                break;
        }



    }
}
