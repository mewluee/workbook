package permutation;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewChickenSauceRecipe {

    public ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
        // TODO:

        ArrayList<Integer> usablelist= new ArrayList<Integer>();
        ArrayList<Integer[]> resultlist=new ArrayList<Integer[]>();

        //000상한거 > 제거할거에여
        for(int i=0; i<stuffArr.length; i++){
            if(!Integer.toString(stuffArr[i]).contains("000")){
                usablelist.add(stuffArr[i]);
            }
        }
        System.out.println(Arrays.toString(usablelist.toArray()));
        //제거된 리스트 완성
        if(usablelist.size()==0 || usablelist.size()<choiceNum) return null;

        Integer[] one = new Integer[choiceNum];

        //순열만들기
        //재귀니까 일단 반환값 설정해줘야하고
        //아까 가위바위보랑 좀 비슷한데 >> 걔는 이제 중복값을 넣어도 됬지만 얜 아님.
        //그래서 쓴 값을 뺀 배열을 매번 메서드 호출할때마다 넣어줘서 반환해야할거같음.
        //얘도 그럼 초기값 넣어주고

        //★★★★★★밑에있는 줄 주석처리하시고.
        //Collections.sort(usablelist);

        getRecipes(resultlist,usablelist,choiceNum,new Integer[]{});
      /*  for(int i=0; i<usablelist.size(); i++){
            ArrayList<Integer> oneRemovedList=new ArrayList<Integer>();
            for(Integer integer:usablelist){
                oneRemovedList.add(integer);
            } //새로 만든 배열에 그대로 복사하고
            //여기서 해당 인덱스만 빼버리면 '나'만 제거된 배열이 됨.
            oneRemovedList.remove(i);

            //배열이 들어가야함.....>>좀 거의 반복되서 아예 묶을가 싶은데 아주 초기값은 그럼 {}이 되고
            getRecipes(resultlist,oneRemovedList,choiceNum-1,new Integer[]{usablelist.get(i)});
        }*/
        //위에 부분을 밑으로 이제 함수로 구현.

        System.out.println(Arrays.deepToString(resultlist.toArray()));

        //정렬 화난다 정말 ㅡㅡ
        //Collections.sort(resultlist);
        //[]
        //resultlist > arraylist,.
        //Arrays.sort(resultlist.toArray());
        //Collections.sort(usablelist);
        //System.out.println(Arrays.deepToString(usablelist.toArray()));

        //
        /*Collections.sort(resultlist, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                for(int i=0; i<o1.length; i++)
                {
                    if(o1[i])
                }
            }
        });*/
        return resultlist;
    }

    public void getRecipes(ArrayList<Integer[]> result,ArrayList<Integer> removedlist, int choiceNum, Integer[] intarr){

        if(choiceNum==0) {

            //★★★★★★여기 밑에 부분 주석 해제하기.
            //Arrays.sort(intarr);>> 이거 해버리면 다 값이 똑같아짐. 왜냐~? 입력같이 똑같으니까!!!!ㅁㅋㅋ!
            result.add(intarr);
            return;
        }


        //예를 들어 1 10 111 일때
        //아예 intarr이 {}일때 처리가..오 무난무난할거같음
        for(int i=0; i<removedlist.size(); i++){

            Integer[] newone=Arrays.copyOf(intarr, intarr.length+1);
            //새로운 거 만들구
            //{null}만들어지고
            //{1}넣어서 다시 재귀호출할건데.
            newone[newone.length-1]=removedlist.get(i);

            ArrayList<Integer> oneRemovedList=new ArrayList<Integer>();
            for(Integer integer:removedlist){
                oneRemovedList.add(integer);
            } //새로 만든 배열에 그대로 복사하고
            //여기서 해당 인덱스만 빼버리면 '나'만 제거된 배열이 됨.
            oneRemovedList.remove(i);

            getRecipes(result, oneRemovedList, choiceNum-1, newone);

        }

    }



    //여기 리스트말고 배열로 구현할거임.근데 잘 안됨;
    public void getRecipes2(ArrayList<Integer[]> result,Integer[] removedlist, int choiceNum, Integer[] intarr){

        if(choiceNum==0) {
            //여기 부분 주석 해제하기.
            //Arrays.sort(intarr);
            result.add(intarr);
            return;
        }


        //예를 들어 1 10 111 일때
        //아예 intarr이 {}일때 처리가..오 무난무난할거같음
        for(int i=0; i<removedlist.length; i++){

            Integer[] newone=Arrays.copyOf(intarr, intarr.length+1);
            //새로운 거 만들구
            //{null}만들어지고
            //{1}넣어서 다시 재귀호출할건데.
            newone[newone.length-1]=removedlist[i];

            ArrayList<Integer> oneRemovedList=new ArrayList<Integer>();
            for(Integer integer:removedlist){
                oneRemovedList.add(integer);
            } //새로 만든 배열에 그대로 복사하고
            //여기서 해당 인덱스만 빼버리면 '나'만 제거된 배열이 됨.
            oneRemovedList.remove(i);
            //Integer[] oneRemevedArrays= Stream.of(oneRemovedList).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

            //getRecipes(result, , choiceNum-1, newone);

        }

    }
}
