package 스택_Stack;

import java.io.*;
import java.util.Stack;

public class 괄호_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T=Integer.parseInt(br.readLine());
        Stack<Character> stack=new Stack<>();
        for (int t = 0; t < T; t++) {
            stack.clear();
            String str=br.readLine();
            for (int i = 0; i < str.length(); i++) {
                char c=str.charAt(i);
                if(c=='(') stack.push(c);
                else {
                    if(stack.isEmpty()) {
                        stack.push(c);
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
            if(stack.isEmpty()) bw.write("YES\n");
            else bw.write("NO\n");
        }
        bw.flush();
        bw.close();
    }
}
