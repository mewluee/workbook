package permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class RockPaperScissors {

    public ArrayList<String[]> rockPaperScissors(int rounds) {
        String[] rps=new String[]{"rock", "paper", "scissors"};
        //중복순열
        ArrayList<String[]> result=new ArrayList<>();
        result.add(new String[]{rps[0]});
        result.add(new String[]{rps[1]});
        result.add(new String[]{rps[2]});
        //result={rock,paper,scissors}

        //스트림으로 정렬구현해보기
        //Comparator써보기???>>근데 안해도 됬음.뭐임???

        result=getRPS(result,rps,rounds-1); // 5입력시 4번
        System.out.println("결과 사이즈:"+result.size());

        return result;
    }

    public ArrayList<String[]> getRPS(ArrayList<String[]> list,String[] rps, int rounds){

        if(rounds==0) {
            return list;
        }

        System.out.println("전:"+Arrays.deepToString(list.toArray()));
        ArrayList<String[]> newlist=new ArrayList<>();

        for(int i=0; i<list.size(); i++){
            String[] one=list.get(i); //리스트에서 String[] 하나 뽑아와서
            System.out.println("one:"+Arrays.toString(one));
            String[] newone= Arrays.copyOf(one,one.length+1);//복사본만드는데 String[length+1] 한칸 늘려서 만든다.
            System.out.println("newone0:"+Arrays.toString(newone));
            for(int j=0; j<rps.length; j++){
                newone[newone.length-1]=rps[j]; //복사본에 하나씩 새로운 가위/바위/보 넣어서
                //newone=arrSort(newone);
                System.out.println("newone1:"+Arrays.toString(newone));
                newlist.add(Arrays.copyOf(newone,newone.length)); //새로운 리스트에 저장함. 여기서 사이즈가 곱3이됨.
                //Arrays.copyOf안하면..배열은 늘 참조값이 저장되다보니까 여기서 newlist가 갱신될때마다 나중에도 다 똑같이 바뀜;;;;;;
                //새로 무조건 해야함!!!
                System.out.println("add 후:"+Arrays.deepToString(newlist.toArray()));

            }
        }
        System.out.println("후:"+Arrays.deepToString(newlist.toArray()));
        System.out.println("newlist size:"+newlist.size());

        return getRPS(newlist,rps,rounds-1);

    }

    public String[] arrSort(String[] strarr){
        Comparator<String> comparator=new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int a=0;
                int b=0;

                if(o1.equals("rock")) a=3;
                else if(o1.equals("paper")) a=2;
                else a=1;

                if(o2.equals("rock")) b=3;
                else if(o2.equals("paper")) b=2;
                else b=1;

                return b-a;
            }
        };
        //System.out.println("정렬 전:"+Arrays.toString(strarr));
        Arrays.sort(strarr,comparator);
        //System.out.println("정렬 후:"+Arrays.toString(strarr));
        return strarr;
    }
}
