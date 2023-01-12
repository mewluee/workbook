package recursiveFunction;

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

}
