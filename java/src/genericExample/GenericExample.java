package genericExample;

public class GenericExample {

    class Flower {}
    class Rose extends  Flower {}
    class Pasta {}
    interface Plant {}

    class Basket<T>{
        private T item;
        //static T item2; : 에러

        public T getItem(){
            return item;
        }

        public void setItem(T item){
            this.item=item;
        }

        public <T> void add(T element){
            // 반환값 void , 매개변수 element의 타입을 지정.
            // (**중요**) 클래스 옆에 있는 T와, 메서드의 T는 다른 T.
            // 즉 클래스 선언할 때 String타입으로 선언했다고 해서, 이 메서드도 String타입이 되는 건 아니다.
            // 이 메서드는 해당 메서드를 호출할때 정해짐.

            // 클래스 옆에 있는 <T>는 멤버변수의 타입을 결정 > 메서드에는 영향을 주지 않음.
            // 즉, static 메서드에 <T>가 붙어도 가능한 건...
            // 메서드는 메서드가 호출될때! 생성되니까 이미 호출했을때는 타입이 선언됨.

            // System.out.println(item.length()); : 에러
            // length()는 String타입만 호출가능한데
            // 제네릭 타입이라서 String타입말고 다른 타입이 올수도 있어서 불가능함.

            // 단, Object클래스의 메서드 : equals(), toString() 등은 가능
            // Object클래스는 최상위클래스라서!
        }

        // 여기 예제대로 쳤는데 빨간줄 ㅇㅅㅇ;;;
        static <T> int add2(T element){
            // (**중요**) 클래스 옆에 있는 T와, 메서드의 T는 다른 T.
            // 즉 클래스 선언할 때 String타입으로 선언했다고 해서, 이 메서드도 String타입이 되는 건 아니다.
            // 이 메서드는 해당 메서드를 호출할때 정해짐.

            // 클래스 옆에 있는 <T>는 멤버변수의 타입을 결정 > 메서드에는 영향을 주지 않음.
            // 즉, static 메서드에 <T>가 붙어도 가능한 건...
            // 메서드는 메서드가 호출될때! 생성되니까 이미 호출했을때는 타입이 선언됨.

            return 0;
        }
    }

    // < > 안에 T가 Flower클래스를 상속받도록 지정되어있음.
    class Basket2<T extends Flower>{
        private T item;

        public T getItem(){
            return item;
        }

        public void setItem(T item){
            this.item=item;
        }
    }

    // < > 안에 T가 Plant인터페이스를 상속받도록 지정되어있음. 인터페이스지만 extends키워드 사용
    class Basket3<T extends Plant> {}

    // < > 안에 T가 Flower클래스의 상속과, Plant인터페이스의 상속 둘다 받는 방법 >> &연산자
    // 단, 클래스가 인터페이스보다 앞쪽에 선언되어야 함.
    class Basket4<T extends Flower & Plant> {}

    public void result(){



        // Generic 타입이란
        // 내부의 매개변수의 타입을 미리 지정하고 싶지 않을 때 쓴다.
        // 클래스 옆에 <>로 제네릭 변수타입이란걸 알려준다.
        // 해당 클래스 생성시 <>안에 변수타입 지정(다른 클래스타입이 들어가기도 함)

        // ============== 제네릭 클래스 ==============

        Basket<Flower> flowerBasket=new Basket<>();
        // Basket클래스 인스턴스 생성하면서 그 안의 멤버필드와 멤버메서드를 Flower 클래스 타입으로 선언.
        flowerBasket.setItem(new Rose());
        // setItem의 매개변수로 Flower객체가 와야함 : Rose는 Flower를 상속받음 : 다형성 적용됨
        // System.out.println(new Rose() instanceof Flower); >> true 출력됨

        //flowerBasket.setItem(new Pasta()); : 이건 에러



        Basket2<Flower> flowerBasket2=new Basket2<>();
        //Basket2<Pasta> pastaBasket2=new Basket2<Pasta>(); : 이건 에러임
        //위에서 제네릭 타입이 Flower클래스를 상속받아야하는 걸로 지정되어있음.


        // ============== 제네릭 메서드 ==============

        Basket<String> stringBasket=new Basket<>();
        stringBasket.<Integer>add(10); // 위에 적어둠


        // ============== ? : 와일드 카드 ==============
        // 어떤 타입으로든 대체될 수 있다.
        // < ? extends T > : T 혹은 T를 상속하는(받는) 하위클래스
        // < ? super T > : T 혹은 T의 상위클래스

    }

}
