package streamExample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

    public void result(){


        question4();



    }

    private void question1(){
        //코플릿 1번
        List<Integer> list= Arrays.asList(1,2,3,4,5);
        System.out.println(list.stream().mapToInt(x->x).sum());
    }

    private void question2(){
        //코플릿 2번 : computeAverageOfNumbers
        List<Integer> list= Arrays.asList(1,2,3,4,5);
        if(list.size()==0) System.out.println("0");
        System.out.println(list.stream().mapToInt(x->x).average().getAsDouble());
    }

    private void question3(){
        //코플릿 3번 : filterOddNumbers
        List<Integer> list= Arrays.asList(1,2,3,4,5);
        System.out.println(list.stream().filter(x->x%2==0).collect(Collectors.toList()).toString());
    }

    private void question4(){
        //코플릿 4번 : computeCountOfFemailMember
        Member coding= new Member("coding","Female");
        Member coding2= new Member("coding","Female");
        Member hacker=new Member("hacker","Male");
        List<Member> members=Arrays.asList(coding,hacker,coding2);
        long a=33;

        System.out.println(members.stream().filter(x->x.getGender().equals("Female")).collect(Collectors.toList()).size());

    }

    static class Member{
        String name;
        String gender;

        public Member(String name, String gender){
            this.name=name;
            this.gender=gender;
        }
        public String getName(){
            return name;
        }
        public String getGender(){
            return gender;
        }
    }

}
