package queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 우선순위큐선언방법 {
    public static void main(String[] args){
        //단순 오버라이드
        PriorityQueue<Passenger> pq1=new PriorityQueue(new Comparator<Passenger>() {
            @Override
            public int compare(Passenger o1, Passenger o2) {
                if(o1.distance==o2.distance)
                    if(o1.start[0]==o2.start[0])
                        return o1.start[1]-o2.start[1];
                    else
                        return o1.start[0]-o2.start[0];
                else
                    return o1.distance-o2.distance;
            }
        });
        //람다로 표현
        PriorityQueue<Passenger> pq2=new PriorityQueue((Comparator<Passenger>) (o1, o2) -> {
            if(o1.distance==o2.distance)
                if(o1.start[0]==o2.start[0])
                    return o1.start[1]-o2.start[1];
                else
                    return o1.start[0]-o2.start[0];
            else
                return o1.distance-o2.distance;
        });
    }

    static class Passenger{
        int[] start;
        int[] end;
        int distance;

        Passenger(int[] start, int[] end) {
            this.start = start;
            this.end = end;
            distance=0;
        }
    }
}
