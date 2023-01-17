package recursiveFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursiveFuctionExample {

    public void gugudan(int n, int count){
        //1. 작은 문제로 쪼개기(어느 부분이 어떻게 반복하느냐?)
        //  >> 출력 x * 1~9
        //2. 입력값과 출력값
        //  >> 사용자 입력 n값/스트링 출력
        //3. 종료시점 정하기
        //  >> 9일때?

        if(count<1)
            return;

        System.out.println(n+" x "+(10-count)+" = "+n*(10-count));
        gugudan(n,--count);

    }

    //코플릿 1번 : 수(num)를 입력받아 1부터 num까지의 합을 리턴해야 합니다.
    public int sumTo(int num){ // 입력값은 num으로 정해짐
        if(num==0) return 0;
        if(num==1) return 1; // 종료시점(반환값)
        return num+sumTo(num-1); //재귀 호출
    }

    //코플릿 2번 : 수를 입력받아 홀수인지 여부를 리턴해야 합니다.(단, 나눗셈 나머지 연산자 사용 금지/0은 짝수)
    public boolean isOdd(int num){
        // 입력값과 출력값 정해짐
        // 종료시점은
        // 음수값도 처리하기 위해 절대값 구하는 함수 Math.abs() 사용
        int n=Math.abs(num);
        if(n==1) return true;
        if(n==0) return false;

        return isOdd(n-2);
    }

    //코플릿 3번 : 수를 입력받아 n-factorial(n!; 엔-팩토리얼) 값을 리턴해야 합니다.
    //n! 은 1부터 n까지 1씩 증가한 모든 값의 곱입니다.
    public int factorial(int num){
        if (num==0) return 1;
        return num*factorial(num-1);
    }

    //코플릿 4번 : 수(num)를 입력받아 피보나치 수열의 num번째 요소를 리턴해야 합니다.
    //
    //0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1입니다. 그 다음 2번째 피보나치 수부터는 바로 직전의 두 피보나치 수의 합으로 정의합니다.
    //0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
    public int fibonacci(int num){
        //입력값과 출력값 정해짐
        //종료시점
        if(num==1) return 1;
        if(num==0) return 0;
        return fibonacci(num-2)+fibonacci(num-1);
    }

    //코플릿 5번 : 배열을 입력받아 모든 요소의 합을 리턴해야 합니다.
    public int arrSum(int[] arr){
        //배열의 데이터는 손상 X
        //종료시점 배열에 데이터가 없을떄
        if(arr.length==0) return 0;
        int[] copyarr= Arrays.copyOfRange(arr,1,arr.length);
        //Arrays.copyOfRange(오리지널 배열,index A, index B) >> A부터 B전까지.
        return arr[0]+arrSum(copyarr);

    }

    //코플릿6번 : 배열을 입력받아 모든 요소의 곱을 리턴해야 합니다.
    public int arrProduct(int[] arr){
        if(arr.length==0) return 1;
        int[] copyarr=Arrays.copyOfRange(arr,1,arr.length);
        return arr[0]*arrProduct(copyarr);
    }

    //코플릿 7번:배열을 입력받아 그 길이를 리턴해야 합니다.
    public int arrLength(int[] arr){

        if(arr.length==0) return 0;
        int[] copyarr=Arrays.copyOfRange(arr,1,arr.length);
        return 1+arrLength(copyarr);
    }

    //코플릿 8번:수(num)와 배열을 입력받아 차례대로 num개의 요소가 제거된 새로운 배열을 리턴해야 합니다.
    public int[] drop(int num, int[] arr){
        if(arr.length==0 || num>arr.length) return new int[0];
        int[] copyarr=Arrays.copyOfRange(arr,1,arr.length);

        if(num==1) return copyarr;
        return drop(num-1,copyarr);
    }

    //코플릿 9번:수(num)와 배열을 입력받아 차례대로 num개의 요소만 포함된 새로운 배열을 리턴해야 합니다.
    public int[] take(int num, int[] arr){
        if(num>=arr.length) return arr;
        if(arr.length==0 || num==0) return new int[0];
        //drop함수에선 앞에서부터 하나씩 버렸찌만
        //take함수에선 뒤에서부터 하나씩 버리는 형태 >>>구현 힘듬;
        /*if(num==1) {
            System.out.println("num:"+num+" "+Arrays.toString(arr));
            return arr;
        }*/

        int[] copyone=Arrays.copyOfRange(arr,0,1);
//        System.out.println("copyone:"+Arrays.toString(copyone));
//        System.out.println("arr.length:"+arr.length);
        if(num==1){
            System.out.println("num:"+num+" "+Arrays.toString(copyone));
            return copyone;
        }
            //return copyone;
        int[] copyother=Arrays.copyOfRange(arr,1, arr.length);
//        System.out.println("arr:"+Arrays.toString(arr));
//        System.out.println("copyother:"+Arrays.toString(copyother));
        //System.out.println("num:"+num+" "+Arrays.toString(copyarr));

        int[] result=new int[num]; //
        System.out.println("Result1:"+Arrays.toString(result));
        System.arraycopy(copyone,0,result,0, copyone.length);
        // 생성한 result의 !!늘!! 첫번째 값으로 들어간다.
        // 인덱스가 그래서 0 고정.
        // result는 계속 5 > 4 > 3 > 2 > 1 순으로 작아짐. num-1로 함수 호출하기 때문에.
        System.out.println("result2:"+Arrays.toString(result)+" ");
        int[] takeResult=take(num-1, copyother);
        System.out.println("^^^^"+takeResult.length);
        System.arraycopy(takeResult,0,result,num-takeResult.length, takeResult.length);
        // 첫번째 값 빼고 나머지 값을 함수로 가져와 붙인다.
        // 인덱스 중요~
        System.out.println("result3:"+Arrays.toString(result));
        // result[5] = [5] + result[4]
        //           = [5] + [ [4] + result[3] ]


        return result;



    }

    //코플릿 10번:배열을 입력받아 모든 요소의 논리곱(and)을 리턴해야 합니다.
    public boolean and(boolean[] arr){
        if(arr.length==0) return true;
        boolean[] copyarr=Arrays.copyOfRange(arr,1,arr.length);
        return arr[0] && and(copyarr);
    }

    //코플릿 11번:배열을 입력받아 모든 요소의 논리합(or)을 리턴해야 합니다.
    public boolean or(boolean[] arr){
        if(arr.length==0) return false;
        boolean[] copyarr=Arrays.copyOfRange(arr,1,arr.length);
        return arr[0] || or(copyarr);
    }

    // 1 2 3 4
    // 4 1 2 3
    // 4 3 1 2
    // 4 3 2 1
    public int[] reverseArr(int[] arr){
        if(arr.length==0) return new int[0];

        int[] copyone=Arrays.copyOfRange(arr,arr.length-1,arr.length); // 뒤에 있는 걸 하나씩 뗴어와서
        int[] copyother=Arrays.copyOfRange(arr,0,arr.length-1); //하나 빼고 나머지.
       // System.out.println(Arrays.toString(copyone));
        //System.out.println(Arrays.toString(copyother));
        if(arr.length==1) {
            //System.out.println("길이 1 arr:"+Arrays.toString(arr));
            return arr;
        }
        int[] result=new int[arr.length];
        System.arraycopy(copyone,0,result,0,copyone.length);
        //System.out.println("1 "+Arrays.toString(result));
        int[] reverseResult=reverseArr(copyother);
        //System.out.println("reverResult:"+Arrays.toString(reverResult));
        System.arraycopy(reverseResult,0,result,arr.length-reverseResult.length,copyother.length);
        //System.out.println("2 "+Arrays.toString(result));

        //result 배열의 0번 인덱스부터 copyarr 배열의 0~length까지 복사해서 넣어라.

        //System.out.println(Arrays.toString(result));
        //return new int[0];

        // result에 붙여 넣기. 그런데 붙여넣는 인덱스값이 달라짐.(여기가 까다롭다)
        // 처음 입력받는 배열의 개수가 4면 / [ 4 + reverseArr([1,2,3]) ]               >>인덱스값 1~3(3개)
        //                               [ 4 + [ 3 + reverseArr([1,2]) ] ]         >>        2~3(2개)
        //                               [ 4 + [ 3 + [ 2 + reverseArr([1]) ] ] ]   >>        3~3(1개)
        //                               [ 4 + [ 3 + [ 2 + [     [1]     ] ] ] ]


        return result;
    }


    //코플릿 12번 문제 : 레퍼런스코드 구현해보기
    public int[] reverseArr2(int[] arr){

        if(arr.length==0) return new int[0];
        // 종료조건 설정 // 빈배열 반환

        // 헤드와 테일을 따로 나누기
        int[] head=Arrays.copyOfRange(arr,arr.length-1,arr.length); // copyOfRange(원본 배열,시작 인덱스,마지막 인덱스 전.까지)
        int[] tail=reverseArr2(Arrays.copyOfRange(arr, 0, arr.length-1));

        int[] result=new int[arr.length];

        System.arraycopy(head,0,result,0,head.length);
        //head
        System.arraycopy(tail, 0,result,head.length,tail.length);
        //tail

        // 12345 > 5 + reverse[1234] > 5 + [ 4 + reverse[123] ] > ... > 5 + [ 4 + [ 3 + [ 2 + [1] ] ] ]

        return result;
    }

    //코플릿 9번 문제 : 레퍼런스코드 구현해보기
    public int[] take2(int num, int[] arr){
        if(num>=arr.length) return arr;
        if(num==0 || arr.length==0) return new int[0];

        int[] head=Arrays.copyOfRange(arr,0,1); // 처음값 하나씩 가져오기
        int[] tail=take2(num-1,Arrays.copyOfRange(arr, 1, arr.length)); // 나머지값 분류하기

        System.out.println(Arrays.toString(tail));

        int[] result=new int[num];

        System.arraycopy(head,0,result,0,head.length);
        System.arraycopy(tail, 0,result,num-tail.length, tail.length);

        return result;
    }
}
