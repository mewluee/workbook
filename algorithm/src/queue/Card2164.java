package queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Card2164 {

    private String site="https://www.acmicpc.net/problem/2164";

    public void result() throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int N=Integer.parseInt(br.readLine()); // ์นด๋ ์ฅ์

        Queue<Integer> queue=new LinkedList<>();

        for(int i=0; i<N; i++){
            queue.add(i+1);
        }

        //System.out.println(queue.toString());

        while(queue.size()>1){
            queue.poll();
            //System.out.println("1:"+queue.toString());
            queue.add(queue.poll());
            //System.out.println("2:"+queue.toString());
        }

        bw.write(Integer.toString(queue.peek()));

        bw.close();
    }
}
