package interfaceExample.src;

public class Main2 {
    public static void main(String[] args) {
        CafeOwner cafeOwner=new CafeOwner();
       // CafeCustomerA a=new CafeCustomerA();
       // CafeCustomerB b=new CafeCustomerB();
        CafeCustomer a=new CafeCustomer("a","strawberry latte"); // 상속 없는 기본
        CafeCustomer b=new CafeCustomer("b","americano"); // 상속 없는 기본

        cafeOwner.getItem(a);
        cafeOwner.getItem(b);

//        --------------------------------------------------
        // 상속
        // class CafeCustomerC extends CafeCustomer
        CafeCustomer c1=new CafeCustomerC("c1","coffee latte1"); // 상하 가능
        CafeCustomerC c2=new CafeCustomerC("c2","coffee latte2"); // 하하 가능
        //CafeCustomerC c2=new CafeCustomer("c2","coffee latte2"); // 하상 불가능이라서 에러남




        // getItem(CafeCustomer cafeCustomer)
        cafeOwner.getItem(c1); // 상상 or 상하 (어쨌든 왼쪽이 상이면 무조건 가능.)
        cafeOwner.getItem(c2); // 상상 or 상하

//        ------------------------------------------------------
        //인터페이스

        // class CafeCustomerD implements CafeCustomer2
        CafeCustomer2 d=new CafeCustomerD(); // 상하 가능
        CafeCustomerD d2=new CafeCustomerD();

        //getItem2(CafeCustomer2 cafeCustomer2)
        cafeOwner.getItem2(d); // 상상 or 상하 가능
        // getItem3(CafeCustomerD cafeCustomerD)
        // cafeOwner.getItem3(d); // 에러남. 하상 불가능
        cafeOwner.getItem3(d2); // 하하 가능
    }

}

interface CafeCustomer2{
    public String getOrder2();


}

// 추상화의 목적 : 중복 코드 줄이기.
// 추상화의 구현 : 추상클래스/인터페이스 구현
// 추상화하려면 무엇을 먼저 따져야할까?
// 1. 중복된 코드가 있는가.
// 2. 결합도를 낮추기 위해서 하나의 기능이 바뀌면 연관된 기능도 바뀌는 걸 막아야함.
class CafeCustomer{ // 추상클래스 여부는 인스턴스화 하는가 안하는가? : 여기선 인스턴스화 해도 돼니까 추상클래스로 만들 필요없다.
    public String cafeCustomerName;
    public String orderDrinksName; // 드링크 내가 추가함.

    CafeCustomer(String name,String drinkname){
        System.out.println("생성자 출력");
        cafeCustomerName=name;
        orderDrinksName=drinkname;
    }
    public void setCafeCustomerName(String cafeCustomerName){ //setter
        this.cafeCustomerName=cafeCustomerName;
    }
    public void setOrderDrinksName(String orderDrinksName){ //setter
        this.orderDrinksName=orderDrinksName;
    }

    // 내부적으로 처리가능할 수 있게끔. 이 클래스 안에서 조작하기.
    public String getOrder(){
        return String.format("give %s to %s\n",orderDrinksName,cafeCustomerName);
    }
}

class CafeCustomerC extends CafeCustomer{

    CafeCustomerC(String name, String drinkname) {
        super(name, drinkname);
    }
}

class CafeCustomerD implements CafeCustomer2{


    @Override
    public String getOrder2() {
        return "give coffee and icecream to d";
    }
}

// 수정후
class CafeOwner implements CafeOwnerDo{

    // 여기보면,, 매개변수로 cafeCustomer했단말이지 그럼 그걸 상속받아서 만든  하위 객체는 넣을수있을까? 내 예상은 불가능 오류뜰뜻?
//    헐 근데 됨.. 내 예상이 틀림..엄청 어렵당 ㅠ 상하가능 ㅋㅋㅋ

    @Override
    public void getItem(CafeCustomer cafeCustomer) {
        System.out.println(cafeCustomer.getOrder()); //스트링으로 가져와서 출력만 하도록. 바꿈.
       // System.out.printf("give %s to %s\n",cafeCustomer.orderDrinksName,cafeCustomer.cafeCustomerName);
        // 순간 든 생각인데 이러면 cafecustomer클래스의 필드가 바뀌면 여기도 바뀌어야함. > 즉 이 부분은 cafecustomer가 담당해야함.
    }

    public void getItem2(CafeCustomer2 cafeCustomer2){
        System.out.println(cafeCustomer2.getOrder2());
    }

    public void getItem3(CafeCustomerD cafeCustomerD){
        System.out.println(cafeCustomerD.getOrder2());
    }

    /* 수정전.
    // 지금 똑같은 행동을 매개변수만 바꿔서 중복되서 하고있음.
    // >> 공통된 특성보단 기능이니까/특정 메서드를 강제적으로 구현하기 위해서 인터페이스로 구현.
    public void getItem(CafeCustomerB cafeCustomerB){
        System.out.println("give strawberry latte to B");
    }

    public void getItem(CafeCustomerA cafeCustomerA){
        System.out.println("give americano to A");
    }
    */

    @Override
    public void washingDishes() {
        System.out.println("Washing Dishes.");
    }

    @Override
    public void storeCleaning() {
        System.out.println("Cleaning Store.");
    }
}

// 수정 interface추가함
interface CafeOwnerDo {
    public void getItem(CafeCustomer cafeCustomer); // 카페사장이 하는 공통적인 기능을 생성.
    public void washingDishes();
    public void storeCleaning();
}