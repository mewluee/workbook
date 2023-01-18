

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
     /*   System.out.println("section2활동");

        String output = firstReverse("codestates");
        System.out.println(output); // "setatsedoc"

        String output1 = letterCapitalize("hello world");
        System.out.println(output1); // "Hello World"*/

        int[][] output1 = createMatrix(new int[][]{
                {0, 2, 0},
                {2, 4, 1},
                {1, 3, 1},
                {2, 1, 0},
        });



        System.out.println(Arrays.deepToString(output1));



    }
    public static int[][] createMatrix(int[][] edges) {
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

    public static String letterCapitalize(String str){
        String[] strarr=str.split(" ");
        String result="";
        for(int i=0; i<strarr.length; i++){
            String strone=strarr[i];
            if(strone.length()==0) continue;
            String charone=Character.toString(strone.charAt(0)).toUpperCase();
            String other=strone.substring(1);
            strarr[i]=charone+other;
        }

        return result=String.join(" ",strarr);
    }

    public static String firstReverse(String str){

      /*  int[] arr2=new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(arr2));
        //List<Integer> list=Arrays.asList(arr2); // 에러 : int[] 이라서 안됨. 래퍼클래스 Integer 로 바꿔줘야함.
        Integer[] arr3=Arrays.stream(arr2).boxed().toArray(Integer[]::new);
        //근데 arr2도 int라서 primitive type란 말이쥐..?얜 왜 돼..?char는 안돼...
        List<Integer> list=Arrays.asList(arr3);
        Collections.reverse(list);
        System.out.println(list.toString());*/


        ////////////////////

        char[] arr= str.toCharArray();
        System.out.println(Arrays.toString(arr));
     /*   Character[] arr4=Arrays.stream(arr).boxed().toArray(Character[]::new);
        //에러 뜸 왜.? char는 primitive type >> Charater는 Wrapperclass
        Stream<Character> characterStream=new String(arr).chars().mapToObj(i->(char)i);
        */
        Character[] chararr=new String(arr).chars().mapToObj(c->(char)c).toArray(Character[]::new);
        List<Character> charlist=Arrays.asList(chararr);
        System.out.println(charlist.toString());
        Collections.reverse(charlist);
        System.out.println(charlist.toString());
        String result=charlist.stream().map(String::valueOf).collect(Collectors.joining());

        //List는 출력 .toString()메서드
        //Array는 출력 Arrays.toString(배열변수)


//        ArrayList<Character> strarr=new ArrayList<Character>(Arrays.asList(str));
//        Collections.reverse(strarr);
//        System.out.println(strarr);

        return result;
    }
}