package stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 배열을리스트로만들기 {

    public static void main(String[] args)throws IOException{

        String str="3 5 10 34";
        List<List<Integer>> map=new ArrayList<>();

        for(int i=0; i<3; i++) {
            map.add(Arrays.stream(str.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        }

        System.out.println(map);
    }
}
