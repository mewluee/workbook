import annotationAndRambdaExample.AnnotationAndRambdaExample;
import enumExample.EnumExample;
import genericExample.GenericExample;
import graphExample.GraphExample;
import greedyExample.GreedyExample;
import inheritanceAndinterfaceExample.InheritanceAndInterfaceExample;
import queueExample.QueueExample;
import queueExample.QueueReference;
import streamExample.StreamExample;

import java.util.*;

import static graphExample.GraphExample.getDirections;


public class Main {

    public static void main(String[] args) {
        /*QueueReference qr=new QueueReference();
        int bufferSize = 2;
        int capacities = 10;
        int[] documents = new int[]{7,4,5,6};
        int output=qr.queuePrinter(bufferSize,capacities,documents);
        System.out.println(output);*/

        //GraphExample ge=new GraphExample();
//        boolean result = getDirections(new int[][]
//                        {
//                                {0, 1, 0, 0},
//                                {0, 0, 1, 0},
//                                {0, 0, 0, 1},
//                                {0, 1, 0, 0}
//                        },
//                0,
//                2
//        );
//
//        System.out.println(result); // true
//
//        boolean result2 = getDirections(new int[][]
//                        {
//                                {0, 1, 0, 0, 0},
//                                {0, 0, 0, 1, 0},
//                                {0, 1, 0, 0, 0},
//                                {0, 1, 1, 0, 0},
//                                {1, 1, 1, 1, 0}
//                        },0,2
//        );
//        System.out.println(result2);

        //코플릿 1번
        GreedyExample ge=new GreedyExample();
//        int output=ge.movingStuff(new int[]{42,25,60,73,103,167}, 187);
//        System.out.println(output);


        //코플릿 2번
// 4000원을 받았을 때 500원짜리 동전 8개를 반환합니다.
//        int output1 = ge.partTimeJob(500);
//        System.out.println(output1);

        //코플릿 3번
        /*int[][] board1 = new int[][]{
                {0, 0, 0, 1},
                {1, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };
        int output1 = ge.boardGame(board1, "RRDLLD");
        System.out.println(output1); // 4

        int[][] board2 = new int[][]{
                {0, 0, 1},
                {1, 1, 1},
                {1, 0, 0}
        };
        Integer output2 = ge.boardGame(board2, "UUUDD");
        System.out.println(output2); // null

        int[][] board3 = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };
        int output3 = ge.boardGame(board3, "DDRRRUDUDUD");
        System.out.println(output3); // 0*/

        //코플릿4번
        long output = ge.ocean(50, new int[]{10, 20, 50});
        System.out.println("답:"+output); // 4

        //output = ge.ocean(100, new int[]{10, 20, 50});
        //System.out.println(output); // 10

        //output = ge.ocean(30, new int[]{5, 6, 7});
        //System.out.println(output); // 4

    }
}