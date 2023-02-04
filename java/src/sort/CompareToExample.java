package sort;

public class CompareToExample {
    public void result(){
        //1. 숫자비교 (int형)
        int st=34;
        int co=50;
        int result=Integer.compare(st,co);
        //System.out.println(result);
        //결과값 : 기준값>비교값(1) 기준값=비교값(0) 기준값<비교값(-1)

        //2. 숫자비교 (Integer형)
        Integer st2=34;
        Integer co2=50;
        int result2=st2.compareTo(co2);
        //System.out.println(result2);
        //결과값 : 1번과 동일

        //3.문자열 비교 (String형)
        String st3="abcde";
        String co3="d";
        int result3=st3.compareTo(co3);
        //System.out.println(result3);
        //abcde - abc = 2
        //abcde - d = -3 (같은 위치의 문자를 비교하므로 a와 d를 비교해서 아스키코드 차이값을 리턴한다.


        System.out.println();


    }
}
