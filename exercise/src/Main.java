import recursiveFunction.RecursiveFuctionExample;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("section2활동");
        Scanner input=new Scanner(System.in);
        int num=input.nextInt();
        RecursiveFuctionExample rfe=new RecursiveFuctionExample();
        rfe.gugudan(num,9);
    }
}