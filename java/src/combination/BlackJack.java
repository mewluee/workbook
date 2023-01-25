package combination;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.stream.Stream;

public class BlackJack {

    public int boringBlackjack(int[] cards) {
        // TODO:
        int[] result=new int[3];
        HashSet<Integer> hashSet=new HashSet<Integer>();
        int count=0;
        int test=0;

        /*for(int n=0;n<cards.length; n++){
            result[0]=cards[n]; // 첫번째 뽑고
            for(int m=0; m<cards.length; m++){
                if(m!=n){
                    result[1]=cards[m]; // 두번째 뽑고(단 앞에서 뽑은 카드는 안뽑음)
                    for(int k=0; k<cards.length; k++){
                        if(k!=m && k!=n){
                            result[2]=cards[k]; //세번째 뽑고(단 앞에서 뽑은 카드들은 안뽑음)
                            test++;//경우의 수 체크하려고 넣음
                            System.out.println(">>"+Arrays.toString(result));

                            int sum= Arrays.stream(result).sum();//스트림으로 sum값 구하기
                            System.out.println("sum:"+sum);

                            hashSet.add(sum); //hashset에 넣어서 중복값 저절로 정리됨.
                            System.out.println("hashset sum들:"+hashSet.toString());
                        }
                    }
                }
            }
        }*/

        for(int n=0; n<cards.length; n++){
            result[0]=cards[n];
            for(int m=n+1; m<cards.length; m++){
                result[1]=cards[m];
                for(int k=m+1; k<cards.length; k++){
                    result[2]=cards[k];
                    test++;
                    System.out.println(">>"+Arrays.toString(result));

                    int sum= Arrays.stream(result).sum();//스트림으로 sum값 구하기
                    System.out.println("sum:"+sum);

                    //hashSet.add(sum); //hashset에 넣어서 중복값 저절로 정리됨.
                    //System.out.println("hashset sum들:"+hashSet.toString());*//*
                    if(isPrime(sum)) count++;

                }
            }
        }
        System.out.println("test:"+test);

//        Iterator it=hashSet.iterator();
//        while(it.hasNext()){
//            if(isPrime((Integer)it.next())) count++; //소수면 카운트 올라감.
//        }

        return count;
    }

    public boolean isPrime(int number){
/*


        if(number<2){ //0과 1은 소수가 아님
            return false;
        }
        if(number==2){ //2는 소수임
            return true;
        }

        //소수라는 건 1과 자기자신을 약수로 갖고있음
        //즉 2부터 자기자신-1까지 나눠지는 수가 있으면 false임
        for(int i=2; i<number; i++){
            if(number%i==0){
                System.out.println("number:"+number+"(소수아님)");
                return false;
            }
        }

        System.out.println("number:"+number+"(소수임)");
        return true;*/

        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) return false;
        }
        return true;

    }
}
