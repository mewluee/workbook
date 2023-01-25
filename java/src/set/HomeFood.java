package set;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeFood {
    public ArrayList<String[]> missHouseMeal(String[] sideDishes) {
        // TODO:
        ArrayList<String[]> result=new ArrayList<>();

        //공집합과 그대로인 집합은 나중에 더하고
        //부분집합 구해야함
        //부분집합은 배열의 length가 3이라고 하면 >> 0 1 2  일텐데
        //0 과 3을 제외한 1과 2이 사이즈가 됨.
        //새로운 사이즈만큼 sidedishes를 넣어서 순열뽑는다?집합이니까 조합임.
        ArrayList<String> sideDishesList=new ArrayList<String>();
        for(String s:sideDishes){
            sideDishesList.add(s);
        }

        for(int i=sideDishes.length-1; i>=1; i--){
            getPartSet(result,i,sideDishesList,new String[]{});
        }

        System.out.println(Arrays.deepToString(result.toArray()));


        return new ArrayList<String[]>();
    }

    public void getPartSet(ArrayList<String[]> result,int n,ArrayList<String> sideDishes,String[] strs){
        if(n==0){
            result.add(strs);
            return;
        }

        String[] resultstr= Arrays.copyOf(strs,strs.length+1);

        for(int i=0; i<sideDishes.size(); i++){
            resultstr[resultstr.length-1]=sideDishes.get(i);

            ArrayList<String> removedSideDishes=new ArrayList<>();
            for(String s:sideDishes){
                removedSideDishes.add(s);
            }
            removedSideDishes.remove(i);

            getPartSet(result, n-1, removedSideDishes, resultstr);
        }
    }
}
