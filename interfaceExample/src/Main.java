public class Main {
    public static void main(String[] args) {
        CafeOwner cafeOwner=new CafeOwner();
        CafeCustomerA a=new CafeCustomerA();
        CafeCustomerB b=new CafeCustomerB();

        cafeOwner.getItem(a);
        cafeOwner.getItem(b);
    }

}

// 추상화의 목적 : 중복 코드 줄이기.
// 추상화의 구현 : 추상클래스/인터페이스 구현
// 추상화하려면 무엇을 먼저 따져야할까?
// 1. 중복된 코드가 있는가.
// 2. 결합도를 낮추기 위해서 하나의 기능이 바뀌면 연관된 기능도 바뀌는 걸 막아야함.
class CafeCustomer{
    public String CafeCustomerName;

    public void setCafeCustomerName(String cafeCustomerName){
        this.CafeCustomerName=cafeCustomerName;
    }
}

class CafeCustomerA extends CafeCustomer{

}

class CafeCustomerB extends CafeCustomer{

}

class CafeOwner{
    public void getItem(CafeCustomerB cafeCustomerB){
        System.out.println("give strawberry latte to B");
    }

    public void getItem(CafeCustomerA cafeCustomerA){
        System.out.println("give americano to A");
    }
}

