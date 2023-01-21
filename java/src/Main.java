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

        GraphExample ge=new GraphExample();
        int result = ge.connectedVertices3(new int[][]{
                {0, 1},
                {2, 3},
                {8, 3},
                {9, 3},
                {7, 4},
                {4, 6},
                {4, 5},
                {6, 5}
        });
        System.out.println(result); //3


    }
}