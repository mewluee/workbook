package hashmap;

import java.util.HashSet;

public class 해시셋조회 {
    //iterator말고 for문으로도 된다
    public static void main(String[] args){
        HashSet<Integer> set=new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        for(int x:set){
            System.out.println(x);
        }
    }
}
