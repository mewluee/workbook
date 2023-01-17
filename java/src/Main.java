import annotationAndRambdaExample.AnnotationAndRambdaExample;
import enumExample.EnumExample;
import genericExample.GenericExample;
import queueExample.QueueExample;
import streamExample.StreamExample;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        QueueExample qe=new QueueExample();
        int bufferSize = 2;
        int capacities = 10;
        int[] documents = new int[]{7,4,5,6};

        int output=qe.queuePrinter(bufferSize,capacities,documents);
        System.out.println(output);

    }
}