package stackExample;

import java.util.ArrayList;
import java.util.Stack;

public class StackExample {

    private ArrayList<Integer> listStack=new ArrayList<Integer>();

    private void push(Integer data){
        listStack.add(data);
    }

    private Integer pop(){
        if(listStack.size()==0){
            return null;
        }else{
            return listStack.remove(listStack.size()-1); // 마지막 값(제일 마지막에 들어간 값) 뽑아오기
            //arraylist는 늘 마지막 인덱스에 값이 저장되기 때문에
            //스택에서 pop은 값도 가져오고, 삭제함. (Arraylist의 remove메서드)
        }
    }

    private int size(){
        return listStack.size();
    }

    private Integer peek(){
        if(listStack.size()==0){
            return null;
        }else{
            return listStack.get(listStack.size()-1);
            //스택에서 peek은 값만 가져옴. (삭제X > Arraylist의 get메서드)
        }
    }

    private String show(){
        return listStack.toString();
    }

    private void clear(){
        listStack.clear();
    }

    public void result(){
        //main메서드에서 불러오는 함수.

        String[] ac=new String[10];
        Stack<String> stack=new Stack<>();
        stack.size();
        ArrayList<Integer> hi=new ArrayList<>();
        hi.isEmpty();
    }
}
