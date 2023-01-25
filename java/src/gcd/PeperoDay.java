package gcd;

import java.util.ArrayList;
import java.util.Arrays;

public class PeperoDay {

    public ArrayList<Integer[]> divideChocolateStick(int M, int N) {
        // TODO:

        ArrayList<Integer[]> result=new ArrayList<Integer[]>();
        int min;
        if(M>=N) min=N;
        else min=M;

        for(int i=1; i<=min; i++){
            if(M%i==0 && N%i==0){
                result.add(new Integer[]{i,M/i,N/i});
            }
        }

        System.out.println(Arrays.deepToString(result.toArray()));

        return result;
    }
}
