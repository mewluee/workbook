package graphExample;

import java.util.Arrays;
import java.util.Stack;

public class GraphExample {

    public void howResult(){
        //main
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

    }

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

    //코플릿 10번 문제
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
        //

        //일단 매개변수로 들어온 2차원 배열 깊은 복사(값 복사/주소X/원본배열 그대로 유지)
        int[][] copy=new int[edges.length][];
        for(int i=0; i<copy.length; i++){
            copy[i]=Arrays.copyOf(edges[i],edges[i].length); // 통째로 복사해서 새로운 배열로 반환하기때문에 copy에 저장(깊은복사) > 원본 손실 안함

        }

        //최소 최대 구해서
        //boolean배열 만들기?>인접행렬구성
        //min/max 값 구해서 행렬구현?
        //어떻게 세지..?
        //깊이우선>스택/재귀
        //너비우선>큐

        //간 노드는 삭제해버릴까..?

        Stack<Integer> stack=new Stack<>();
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
        //2넣고 3넣고 > 순회해서 3으로 시작하는게 있으면 또 넣는다
        //4 넣고 > 4다음 없어서 > 4빼고 > 다시 3으로 돌아가고 > 5 검색.
        //스택에 [ ] 배열이 통째로 들어가야할까? 아니면 숫자만 들어가야할까?
        //>>일단 숫자만 넣고 구현해보자

        //주어진 노드들이 다 삭제될때까지! 삭제가 덜 됬으면.계속 반복문 돌아감

        while(copy.length>0){

            //int end=copy[0][1];
            stack.add(copy[0][0]); //스택의 시작 넣어주기.

            for(int n=0; n<copy.length; n++){

                int start=stack.peek();
                if(start==copy[n][0]){
                    stack.add(copy[n][1]);
                }
            }
        }

        return 0;
    }
}
