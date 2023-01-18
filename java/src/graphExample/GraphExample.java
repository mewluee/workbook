package graphExample;

import java.util.Arrays;

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

        System.out.println();
        System.out.println("-------------------------");
        System.out.println("getdirections들어옴");
        System.out.println("매개변수>from:"+from+" to:"+to);
        System.out.println("-------------------------");

        if(matrix[from][to]==1) {
            System.out.println("존재함! 찾음! true반환!");
            System.out.println("from:"+from+" to:"+to);
            return true; // 바로 연결되면 트루 반환
        }
        else{ // 바로 연결이 아닐경우

            boolean flag=false;
            for(int i=0; i<matrix[from].length; i++){

                //from에서 연결된 노드 찾아서
                //해당 노드를 from에 넣어서 재검색
                if(matrix[from][i]==1){ //

                    System.out.print("if문>");
                    System.out.println("**from:"+from+" i:"+i);
                    matrix[from][i]=0;
                    matrix[i][from]=0;
                    from=i; // 다시 못돌아가게 0으로 만들어버림.
                    boolean result= getDirections(matrix,from,to);
                    if(result) flag=true;
                }
            }

            if(flag) return true;
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
}
