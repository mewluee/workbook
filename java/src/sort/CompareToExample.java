package sort;

public class CompareToExample {
    public void result(){
        //1. 숫자비교 (int형)
        int st=34;
        int co=50;
        int result=Integer.compare(st,co); //(!주의!)compareTo메서드 아님.
        System.out.println(result); // -1
        //결과값 : 기준값>비교값(1) 기준값=비교값(0) 기준값<비교값(-1)

        //2. 숫자비교 (Integer형)
        Integer st2=84;
        Integer co2=50;
        int result2=st2.compareTo(co2);
        System.out.println(result2); // 1
        //결과값 : 1번과 동일

        //3.문자열 비교 (String형)
        String st3="a";
        String co3="agfgeiu";
        int result3=st3.compareTo(co3);
        System.out.println(result3); // (기준값) - (비교값)
        //(1) 앞자리부터 같을 경우 (기준 문자열 길이값 - 비교 문자열 길이값)
        // abcde(5) - abc(3) = 2
        // a(1) - agfgeiu(7) = -6

        String st4="gehqdz";
        String co4="uy";
        int result4=st4.compareTo(co4);
        System.out.println(result4); // -14
        //(2) 앞자리부터 틀릴 경우 (제일 첫번째 문자의 아스키코드 차이값 반환)
        //abcde - d = -3  >>  a(97) - d(100)
        //gehqdz - uy = - 14  >>  g(103) - y(117)



    }
}
