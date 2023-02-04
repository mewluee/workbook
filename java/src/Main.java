import charaterAndAsciicodeExample.CharaterAndAsciicodeExample;
import combination.BlackJack;
import gcd.PeperoDay;
import graphExample.GraphExample;
import permutation.NewChickenSauceRecipe;
import permutation.RockPaperScissors;
import set.HomeFood;
import sort.CompareToExample;

import java.util.ArrayList;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        /*QueueReference qr=new QueueReference();
        int bufferSize = 2;
        int capacities = 10;
        int[] documents = new int[]{7,4,5,6};
        int output=qr.queuePrinter(bufferSize,capacities,documents);
        System.out.println(output);*/

        /*//코플릿 5
        RockPaperScissors rps=new RockPaperScissors();
        ArrayList<String[]> output = rps.rockPaperScissors(3);

        System.out.println(Arrays.deepToString(output.toArray()));*/
/*
        //코플릿 7
        BlackJack bj=new BlackJack();
        //int output=bj.boringBlackjack(new int[]{4,6,9,13,21,28,32,37,48});
        //int output=bj.boringBlackjack(new int[]{1,2,3,4});
        int output=bj.boringBlackjack(new int[]{2,4,6,8,14,27});

        System.out.println(output);*/

      /*  //코플릿 6
        NewChickenSauceRecipe ncsr=new NewChickenSauceRecipe();
        ArrayList<Integer[]> output1 = ncsr.newChickenRecipe(new int[]{11, 1, 10, 1111111111, 10000}, 4);
        System.out.println(output1);*/

        //코플릿8
     /*   int M = 4;
        int N = 8;
        PeperoDay pd=new PeperoDay();
        ArrayList<Integer[]> output = pd.divideChocolateStick(M, N);
        System.out.println(output);*/


     /*   HomeFood hf=new HomeFood();
        ArrayList<String[]> output = hf.missHouseMeal(new String[]{"eggroll", "kimchi", "fishSoup"});
        System.out.println(output);*/

        CompareToExample cte=new CompareToExample();
        cte.result();

        CharaterAndAsciicodeExample cae=new CharaterAndAsciicodeExample();
        cae.result();
    }
}