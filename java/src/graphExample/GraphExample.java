package graphExample;

import greedyExample.GreedyExample;

import java.util.Arrays;
import java.util.Stack;

public class GraphExample {

    public void howResult(){
        //main에서 호출하는 방법
        int[][] output1 = createMatrix(new int[][]{
                {0, 2, 0},
                {2, 4, 1},
                {1, 3, 1},
                {2, 1, 0},
        });

        System.out.println(Arrays.deepToString(output1));
        //2차원배열은 toString() 안됨.
        //deepToString()써야함.

        boolean result = getDirections(new int[][]
                        {
                                {0, 1, 0, 0},
                                {0, 0, 1, 0},
                                {0, 0, 0, 1},
                                {0, 1, 0, 0}
                        },
                0,
                2
        );
        System.out.println(result);

        //GraphExample ge=new GraphExample();
//        boolean result = getDirections(new int[][]
//                        {
//                                {0, 1, 0, 0},
//                                {0, 0, 1, 0},
//                                {0, 0, 0, 1},
//                                {0, 1, 0, 0}
//                        },
//                0,
//                2
//        );
//
//        System.out.println(result); // true
//
//        boolean result2 = getDirections(new int[][]
//                        {
//                                {0, 1, 0, 0, 0},
//                                {0, 0, 0, 1, 0},
//                                {0, 1, 0, 0, 0},
//                                {0, 1, 1, 0, 0},
//                                {1, 1, 1, 1, 0}
//                        },0,2
//        );
//        System.out.println(result2);

        //알고리즘 코플릿 1번 그리지 짐나르기
        GreedyExample ge=new GreedyExample();
//        int output=ge.movingStuff(new int[]{42,25,60,73,103,167}, 187);
//        System.out.println(output);


        //알고리즘 코플릿 2번 그리디 편의점 알바
// 4000원을 받았을 때 500원짜리 동전 8개를 반환합니다.
//        int output1 = ge.partTimeJob(500);
//        System.out.println(output1);

        //알고리즘 코플릿 3번 구현 보드 게임
        /*int[][] board1 = new int[][]{
                {0, 0, 0, 1},
                {1, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };
        int output1 = ge.boardGame(board1, "RRDLLD");
        System.out.println(output1); // 4

        int[][] board2 = new int[][]{
                {0, 0, 1},
                {1, 1, 1},
                {1, 0, 0}
        };
        Integer output2 = ge.boardGame(board2, "UUUDD");
        System.out.println(output2); // null

        int[][] board3 = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };
        int output3 = ge.boardGame(board3, "DDRRRUDUDUD");
        System.out.println(output3); // 0*/

        //알고리즘 코플릿4번 dp금고를 털어라
        long output = ge.ocean(50, new int[]{10, 20, 50});
        System.out.println("답:"+output); // 4

        //output = ge.ocean(100, new int[]{10, 20, 50});
        //System.out.println(output); // 10

        //output = ge.ocean(30, new int[]{5, 6, 7});
        //System.out.println(output); // 4

    }

    //자료구조 코플릿 11번 문제 그래프 인접행렬 길찾기
    public static boolean getDirections(int[][] matrix, int from, int to){

        //from에서 to까지 어떤 값이 되느냐..우움
        //들어온 matrix에 해당 행이 시작점으로 두고
        //갈수있는 열을 체크 to가 바로있으면 true바로 반환
        //to가 없으면
        //각 열을 다시 from에 넣고 체크
        //더이상 진입할수없는 열이면 즉 00000이면.false반환
        //나->나로 가진 않음.

        //출발한 노드로는 다시 돌아가지 않는다.

        int[][] copyMatrix=new int[matrix.length][];

        for(int k=0; k<matrix.length; k++){
            int[] one=Arrays.copyOf(matrix[k],matrix[k].length);
            copyMatrix[k]=one;
        }

        System.out.println();
        System.out.println("-------------------------");
        System.out.println("getdirections들어옴");
        System.out.println("매개변수>from:"+from+" to:"+to);
        System.out.println("-------------------------");

        if(copyMatrix[from][to]==1) {
            System.out.println("존재함! 찾음! true반환!");
            //System.out.println("from:"+from+" to:"+to);
            return true; // 바로 연결되면 트루 반환
        }
        else{ // 바로 연결이 아닐경우

            boolean flag=false;
            for(int i=0; i<matrix[from].length; i++){

                //from에서 연결된 노드 찾아서
                //해당 노드를 from에 넣어서 재검색
                if(copyMatrix[from][i]==1){ //

                    System.out.print("if문>");
                    System.out.println("**from:"+from+" i:"+i);
                    copyMatrix[from][i]=0;
                    //matrix[i][from]=0; //무방향일때 없앰
                    //from=i; // 다시 못돌아가게 0으로 만들어버림.
                    //이 나쁜아이!!!from을 여기서 바꾸면서 for문의 from이 같이 바껴버림..ㅇㅇㅇ..
                    //여기 예시에서는 길이 하나였지만 만약 길이 여러개였따면 ..!
                    if(getDirections(copyMatrix,i,to)) return true;

                }
            }

            return false;

        }


    }

    //자료구조 코플릿 10번 그래프 인접행렬 생성하기 문제
    public int[][] createMatrix(int[][] edges) {
        // TODO:
        // 간선들의 목록?
        // 뭐노
        // 정점...시작정점..
        // {0,3,0} 은..음..시작정점 0에서 도착정점 3 으로가는데 간선인데 방향이다.
        //

        //1. 매트릭스 크기 설정하기
        //정점의 최대값 구해서 0~최대값(3) 까지 크기(최대값+1=4) 설정.
        //2. 매트릭스 값 설정하기
        //간선 (0,3,0)이란건 위에서 구현한 매트릭스에서 matrix[0][3]에 방향이니까 1
        //간선 (2,4,1)이란건 무방향이니까 maxtrix[2][4]와 maxtrix[4][2]에 1


        //1. 크기 설정하기
        //최대값 구해야함 //stream max로도 구할수있는가? 확인해보기
        int max=0;
        for(int i=0; i<edges.length; i++){
            int one=edges[i][0]; //시작정점
            int two=edges[i][1]; //도착정점
            int num;
            if(one>two) num=one;
            else num=two;

            if(num>max){
                max=num;
            }
        }
        System.out.println(max);


        int[][] resultMatrix=new int[max+1][max+1]; //new 키워드쓰면 알아서 0으로 초기화됨.
        //System.out.println(Arrays.toString(resultMatrix[0]));
        //Arrays.fill(resultMatrix,0); 에러남. >> fill은 1차원 배열만 가능하다고함.


        for(int j=0; j<edges.length; j++){
            int start=edges[j][0]; // 시작정점
            int end=edges[j][1]; // 도착정점
            if(edges[j][2]==0){ // 0일때 방향 1 한번만
                resultMatrix[start][end]=1;
            }else{ // 1일때 무방향 1 두번
                resultMatrix[start][end]=1;
                resultMatrix[end][start]=1;
            }
        }

        return resultMatrix;
    }

    //자료구조 코플릿 12번 문제 dfs/bfs 연결된 정점들
    public int connectedVertices(int[][] edges) {
        // TODO:
        //무향이라서 간선이 주어지면 일단 갔다가 오는건 무조건 가능.
        //컴포넌트의 조건이란..무엇일까..?
        //더이상 갈곳이 없으면 종료되야함.
        //간 노드들을 어디에 담아야하나요??...???
        //스택에 담아요..?
        //탐색을 했는데 못가는 경우도있을거아냐.
        //아 !
        //0~5 노드가 있다고 치면
        //0-1 2-3 4-5
        //0에서 막 이케저케 노드타고갓는데도 1만 연결되어잇어서 1만 체크될거고
        //다 체크가안됫으니까 1에서 노드타고가고 또 체크 다 안되고
        //2~5까지 다하겟지?
        //근데 이거 카운트는 어케 세냐ㅣ..?
        //sub dfs구현

        //일단 매개변수로 들어온 2차원 배열 깊은 복사(값 복사/주소X/원본배열 그대로 유지)
        //int[][] copy=new int[edges.length][];
        int max=0;
        for(int i=0; i<edges.length; i++){
            //copy[i]=Arrays.copyOf(edges[i],edges[i].length); // 통째로 복사해서 새로운 배열로 반환하기때문에 copy에 저장(깊은복사) > 원본 손실 안함
            int submax;
            if(edges[i][0]>edges[i][1]) submax=edges[i][0];
            else submax=edges[i][1];
            if(submax>max) max=submax;
        }
        boolean[] visitedNode=new boolean[max+1]; // 시작 노드는 늘 0이기때문에 +1해서 한칸 늘린 크기로 새 배열 만들어야함.
        System.out.println(Arrays.toString(visitedNode));
        //기본 초기값 false로 다 반환됨.

        //최소 최대 구해서
        //boolean배열 만들기?>인접행렬구성
        //min/max 값 구해서 행렬구현?
        //어떻게 세지..?
        //깊이우선>스택/재귀
        //너비우선>큐

        //간 노드는 삭제해버릴까..?

        Stack<Integer> stack=new Stack<>();
        //방문처리 불리안배열의 크기를 설정하는 방법..? min/max
        //스택에 copy에 담긴 배열을 하나씩 시작
        //주어진 값 기준으로
        //copy를 순회해서 처음에 0넣고
        //0에서 이어진게 1이니까 1넣고
        //copy를 순회해서 1로 시작하는 값이 있으면 또 진행.
        //없으면 스택에서 빼고
        //스택이 0이 되는 순간 카운트+1
        //copy에 담긴 0->1은 삭제해버리기
        //>>스택에 어떤 타입의 데이터를 넣어야하는가?
        //또 이제 안넣은 노드를 선택해서 스택에 넣기
        //2넣고 3넣고 > 순회해서 3으로
        // 시작하는게 있으면 또 넣는다
        //4 넣고 > 4다음 없어서 > 4빼고 > 다시 3으로 돌아가고 > 5 검색.
        //스택에 [ ] 배열이 통째로 들어가야할까? 아니면 숫자만 들어가야할까?
        //>>일단 숫자만 넣고 구현해보자

        //주어진 노드들이 다 삭제될때까지! 삭제가 덜 됬으면.계속 반복문 돌아감
        //못하겟당..크흥휴ㅠㅠ완전어렵당. 스택으로 구현해볼려고했는데 못하겟넹..
        //재귀는 대충은 할 수 있을거같다.
        //힌트>boolean배열로 방문처리해주기.

        int count=0; // count
        boolean isNotDone=true; // 모든 노드들을 방문 다 못햇는가? yes > true

        while(isNotDone){//sub DFS굴리기 // 모든 노드들을 방문 못했으니까! 돌려!

            System.out.println("while문 시작");

            //방문하지 않은 노드들을 시작점으로 찾기 위해서
            for(int k=0; k<visitedNode.length; k++){
                if(!visitedNode[k]){ //방문하지 않았다면!
                    stack.add(k); //스택에 넣고 시작
                    visitedNode[k]=true; //방문으로 true만들기
                    break;
                }
            }

            System.out.println("visit확인:"+Arrays.toString(visitedNode));



            while(!stack.isEmpty()){//스택이 비어있찌 않다면,

                //일단 비어있지않으니까 바로 연결할 수 있는 노드가 있는지 확인하기
                //그러기 위해서는 pop하거나 peek해서 top에있는 노드를 가져와야하는데.
                //pop할 경우 따로 연결되어있는지 아닌지 따로 if문 조건문 돌려서 확인할 필요가없다.
                //근데 이해는 peek이 이해가 좀 잘됨.
                //블로그 두개 비교안했으면 몰랐을 지도ㅇㅇ..

                //일단 pop써보기!

                int findnode=stack.pop();

                /*
                //dfs알고리즘 짤떄 입력값이
                //예를 들어 {{}, {2,5,8}, {...}} 이면
                //제일 첫번째 0번 인덱스를 비워둠. > 즉 노드가 1부터 시작해서 0번 인덱스는 안찾아볼라고 ㅎ
                // >> 노드 1부터 시작해서 n개까지 > 근데 배열엔 n+1개의 공간이 있는거지 > 하지만 제일 0번 인덱스는 X
                // >> 만약 노드가 0부터 시작했으면 딱 n개까지의 공간으로 구현
                for(int find:copy[findnode]){
                    //copy[findnode]는 배열을 반환하기 때문에 해당 배열의 요소들을 모두 다 순환하게 된다.
                    // 예를 들어 findnode가 0이면
                    // 해당 배열이 [0,1] 이기 떄문에
                    // find에는 0 과 1 이 순차적으로 들어가서 돌아가게됨.

                }
                #$#@$@#$@#$중요한건 여기서는 이게 무의미함. 다른 입력값이 들어오기 때문임.$#%#$%#$%#$%#$
                */

                //내가 해야할 작업 copy의 모든 요소(배열)들의 0번 인덱스를 확인해서
                //0번 인덱스=findnode 같으면 그 다음 1번 인덱스가 연결된 경로인거임. 그때 stack에 넣어줘야함!
                //>>문제점 발견!
                //입력값이 무방향 그래프다보니까
                //0번 인덱스만 비교하면 다 비교가 불가능하다.
                //예를 들어 3이라고 치면 3-8 , 3-9이지만 {9,3} 으로 입력되어있으면 찾질 못한다.
                /*for(int[] one:edges){
                    if(one[0]==findnode){ //내가 찾는 경로의 시작점이 맞다면~
                        stack.push(one[1]); //스택에 넣고
                        visitedNode[one[1]]=true; // 방문한 노드에 추가하기
                    }
                }*/

            }

            count++;

            for(int i=0; i<visitedNode.length; i++){
                if(visitedNode[i]==false){
                    isNotDone=true;
                }else if(i==visitedNode.length-1){
                    isNotDone=false;
                }
            }


        }

        return count;
    }
}
