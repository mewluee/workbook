import annotationAndRambdaExample.AnnotationAndRambdaExample;
import enumExample.EnumExample;
import genericExample.GenericExample;
import inheritanceAndinterfaceExample.InheritanceAndInterfaceExample;
import queueExample.QueueExample;
import queueExample.QueueReference;
import streamExample.StreamExample;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        QueueReference qr=new QueueReference();
        int bufferSize = 2;
        int capacities = 10;
        int[] documents = new int[]{7,4,5,6};
        int output=qr.queuePrinter(bufferSize,capacities,documents);
        System.out.println(output);
    }
}