import annotationAndRambdaExample.AnnotationAndRambdaExample;
import enumExample.EnumExample;
import genericExample.GenericExample;
import graphExample.GraphExample;
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

        boolean result2 = getDirections(new int[][]
                        {
                                {0, 1, 0, 0, 0},
                                {0, 0, 0, 1, 0},
                                {0, 1, 0, 0, 0},
                                {0, 1, 1, 0, 0},
                                {1, 1, 1, 1, 0}
                        },1,4
        );
        System.out.println(result2);

    }
}