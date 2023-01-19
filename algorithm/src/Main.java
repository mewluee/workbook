
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int N=Integer.parseInt(br.readLine()); // 카드 장수

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