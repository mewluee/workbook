package array;

public class ArrayExample {

    public static void main(String[] args){
        String str=new String();

        double a = 10.456;
        double b = 10.789;
        int c = (int) a;
        int d = (int) b;
        System.out.println(c+","+d); //10,10

        double a = 10.456;
        double b = 10.789;
        int e=(int)Math.round(a);
        int f=(int)Math.round(b);
        System.out.println(e+","+f); //10,11

    }

    //이건 오류나지롱? 왜인지는 모르겠네.
    /*class Aclass{

        static int a;

        static void hihi(){

        }
    }*/
}

class Bclass{

    static int b;

    static void hibbi(){

    }
}