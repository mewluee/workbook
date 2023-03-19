import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main2 {

    public static void main(String[] args) throws IOException {
        solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000});
        solution(new int[][]{{40, 2900}, {23, 10000},{11,5200},{5,5900},{40,3100},{27,9200},{32,6900}}, new int[]{1300, 1500,1600,4900});
    }

    // 1 유저 - 4 이모티콘
    // 유저의 비율/돈 - 이모티콘 정가
    //
    // 목적
    // 1. 이모티콘 플러스 서비스 가입자 수 최대
    // 2. 이모티콘 판매액 최대

    // 이모티콘 플러스 서비스 가입자 수가 많으려면, 유저가 이모티콘을 많이 샀을 때 비용이 초과해야 한다.
    // 각 이모니콘마다 할인율을 다르게 해서 구매유저가 많아야한다.
    // 그렇다고 할인율을 올려서 다 사게했다고 치자. 비용이 초과를 안해서 서비스 가입자 수가 적을 수 있다.

    // 브루트 포스 알고리즘 > 각 이모티콘의 할인율에 따라 조합을 검사해서 1번 결과가 클 때만 답을 갱신하다.
    // 브루트 포스 범위를 줄일 수 있는가? 범위 사용자의 비율 범위내로 조정
    // 그럼 놓치는 값이 있는가? 모르겠음

    // 그리디 알고리즘
    // 그때그때 욕망에 따라.....음.....
    // 많이 구매해도 오케이 > 그럼 각 이모니콘마다 최대로 많이 사게 하면 됨. 무조건 할인율 크게 하면되는데 그러면 비용문제가 발생함.
    // 적절하지 않은 것 같다.

    // 놀랍게도.. 할인율은 1~40 40가지가 아니라..
    // 10 20 30 40 >> 4가지였다.....충격이네... 문제좀 여러번 읽어야겠다.

    // DFS BFS ?
    // 순열이래!!

    // 어떤 자료구조를 써야 효율적일까?


    public static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};

        //반복문을 돌면서
        //순열로 만든 비율 배열표로 모든 손님 배열을 순회해서 계산한다.
        //비율로 순열만들기!

        //DFS라는데 어느 부분에 DFS가 적용되야 하는가.
        //순열만들때? 순열은 그냥 만들어서 배열에 촤근촤근..?
        //만들때마다 검사하면 되는거아냐? 도대체 어디서 DFS가..?
        //일단 DFS없는 상황에서 만들어보자.>> ㅋㅋ불가능! 결과적으로 순열만들때 DFS써야한다.왜냐? 밑에있음.

        int[] discountRates = new int[emoticons.length];
        int[] fixedDiscountRate=new int[]{10, 20, 30, 40};


        return answer;
    }

    public static int[] getDiscountRates(int[] emoticons, int[] visited){
        //1. 순열 만들기 (주의, 조합이 아님, 순서도 식별해야한다)
        //이모티콘 개수는 1~7
        //깊이를 입력받으니까 재귀를 써야한다. 자자 visited도 만들어보실까! 이건 밖에서 입력받아야한다.
        //각 재귀때마다 배열의 한 칸을 채워야한다. 여기서 visited가 쓰인다....?
        //어왜..?
        //중복도 가능하잖아 사실...어라..?
        //내가 순열과 경우의 수를 헷갈린거같아.

        //어떻게 녹여야할지 모르겠어...
    }
}
