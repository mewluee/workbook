package greedyExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GreedyExample {

    public int movingStuff(int[] stuff, int limit) {
        // TODO:

        //중요한건 한번에 짐을 많이..?옮겨야함.
        //정렬하고 >
        //1)제일 앞쪽의 작은수 골라놓고
        //2)제일 뒤부터 큰수 넣어서 limit안넘으면 같이 아웃.
        List<Integer> arrstuff = Arrays.stream(stuff).sorted().boxed().collect(Collectors.toList());
        System.out.println(arrstuff.toString());

        int count = 0;
        boolean flag = true;

        while (arrstuff.size() > 0) {//옮길물건이 남아있다면
            System.out.println("while문 시작");
            if (flag) {
                int min = arrstuff.get(0); // 최소값 저장
                System.out.println("min:" + min);
                for (int i = arrstuff.size() - 1; i >= 1; i--) {
                    //정렬됬으니까 뒤에서부터 큰값부터 순회.
                    System.out.println("stuff:" + arrstuff.get(i));
                    if (arrstuff.get(i) + min <= limit) {
                        System.out.println("if문 실행됨 stuff는 " + arrstuff.get(i));
                        count++;
                        arrstuff.remove(i);
                        arrstuff.remove(0);
                        //카운트 올리고
                        //0번과 i인덱스 리스트에서 삭제.
                        //순서 중요. i먼저 삭제하고 0 삭제해야함.
                        //0부터 삭제하면 인덱스값이 달라져버림.
                        System.out.println(arrstuff.toString());
                        break;//for반복문 종료시킴.
                    } else if (i == 1) {
                        //더이상 조합을 못만들면
                        System.out.println("else문 실행됨 stuff는 " + arrstuff.get(i) + " i:" + i);
                        flag = false;
                        break;
                    }
                }
            } else {
                count = count + arrstuff.size();
                arrstuff.clear(); // while문 종료시키기
            }

        }

        return count;
    }

    public int partTimeJob(int k) {
        // TODO:

        //동전을 배열에 넣고.
        //순회하면서 최대로 나눌수있는 값을 뽑아낸다.
        int[] coins = new int[]{1, 5, 10, 50, 100, 500};
        //초기화

        int count = 0;
        for (int i = coins.length-1; i >=0 ; i--) {
            if (k >= coins[i]) {
                //남은 돈이 동전보다 크다면 나눠서 해당 동전의 최대개수를 구하고
                System.out.println("k:" + k + " coins[i]:" + coins[i]);
                int num = k / coins[i];
                count = count + num;
                k = k - (coins[i] * num); // 그만큼 빼버려서 남은 돈 구하고 다시고 for문 돌리기
                System.out.println("남은 k:" + k + " num:" + num);
            }
        }

        return count;
    }

    //코플릿 3번
    public Integer boardGame(int[][] board, String operation) {
        // TODO:
        int count=0;
        int x=0;
        int y=0;
        boolean isOut=false;
        for(int i=0; i<operation.length(); i++){
            System.out.println(operation.charAt(i));
            if(operation.charAt(i)=='U'){//위로 x-1
                x=x-1;
            }else if(operation.charAt(i)=='D'){//아래로 x+1
                x=x+1;
            }else if(operation.charAt(i)=='L'){//좌로 y-1
                y=y-1;
            }else{//우로 y+1
                y=y+1;
            }
            System.out.println("x:"+x+" y:"+y);
            if(x<0 || x>board.length || y<0 || y>board[0].length){
                System.out.println("이탈함");
                return null;
            }else if(board[x][y]==1){
                System.out.println("??3333?");
                count++;
            }
        }

        return count;
    }

    //코플릿 4번
    public long ocean(int target, int[] type) {
        // TODO:
        //target은 훔칠가격이고 type는 들어있는 지폐?
        //동전교환 프로그램은 target을 구성할수잇는 type들의 최소값을 반환함.
        //근데 이 문제는 구성개수 ㅇㅅㅇ..
        //일단 배열을 구성해보면
        //target의 수만큼의 배열공간 만들어야함
        int[] dp=new int[target+1]; // total의 개수
        System.out.println(Arrays.toString(dp));
        //인덱스 하나를 증가하는 이유는 제일 첫번쨰는 0으로 고정함.
        //예를 들어 20이라고 하면 0~20 인덱스
        dp[0]=1; // 0번 인덱스는 채워두고 // 왜 1이지?

        //동전교환 알고리즘에서 >> 여긴 동전의 최소 개수 구하는게 아니고 경우의 수를 구하는 거기 때문에
        //dp배열을 1로 다 채워준다! 아니지. // 10원짜리잖아..생각해보니까..
        //      0  1  2  3  4 ... 10 ...  50
        //  10  0  0  0 ...       1       1  >> 경우의 수라서! /동전의 개수였으면 5임!
        //  20
        //  50

        //초기화 한줄 따로 안하는 이유는?
        //dp[0]=1만해도
        //target50이고 type10일때
        //(1~50) - 10 = (-9~40)범위
        //index가 0이 되는 순간 >> 즉 m이 10일때 10원은 10원동전 1개로 가능하니까 경우의 수 올라가야함.
        //그래서 dp[10]=dp[10]+dp[0] >> 0+1=1 로 만들어버림.
        //원래 초기화 10으로 했으면 밑에 for문 시작 n을 1로 했어야할듯.


        System.out.println(Arrays.toString(dp));

        // 초기화 했으니까
        for(int n=0; n<type.length; n++){
            System.out.println("type"+type[n]);

            for(int m=1; m<=target; m++){
                int index=(m-type[n]); // m은 1~50까지
                //System.out.println("index:"+index);
                if(index>=0){
                    System.out.println("if>>index:"+index);
                    dp[m]=dp[m]+dp[index];
                    System.out.println("dp["+m+"]:"+dp[m]);
                }

            }
        }

        return dp[target];

    }

}