import recursiveFunction.RecursiveFuctionExample;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("section2활동");/*
        Scanner input=new Scanner(System.in);
        int num=input.nextInt();*/
        RecursiveFuctionExample rfe=new RecursiveFuctionExample();
        //System.out.println("**"+Arrays.toString(rfe.reverseArr(new int[]{1,2,3,4,5,6,7})));
        //System.out.println(Arrays.toString(rfe.take(5,new int[]{1,2,3,4,5,6,7})));
        //System.out.println(Arrays.toString(rfe.reverseArr2(new int[]{1,2,3,4,5,6,7})));
        System.out.println(Arrays.toString(rfe.take2(5,new int[]{1,2,3,4,5,6,7,8})));


    }
}