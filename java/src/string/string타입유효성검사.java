package string;

public class string타입유효성검사 {

    public static void main(String[] args) {
        String a = "hello";
        String b = "";
        String c = null;
  //      String d;

        if (a == null) System.out.println("a:null");
        if (a.isEmpty()) System.out.println("a:empty");

        if (b == null) System.out.println("b:null");
        if (b.isEmpty()) System.out.println("b:empty");

        if (c == null) System.out.println("c:null");
        if (c.isEmpty()) System.out.println("c:empty");

//        if (d == null) System.out.println("d:null");
//        if (d.isEmpty()) System.out.println("d:empty");
    }
}
