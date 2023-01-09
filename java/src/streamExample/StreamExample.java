package streamExample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

    public void result(){


        question12();



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
        Member coding= new Member("coding","Female",25);
        Member coding2= new Member("coding","Female",30);
        Member hacker=new Member("hacker","Male",32);
        List<Member> members=Arrays.asList(coding,hacker,coding2);
        long a=33;

        System.out.println(members.stream().filter(x->x.getGender().equals("Female")).collect(Collectors.toList()).size());
        System.out.println(members.stream().map(x->x.getGender().equals("Female")).collect(Collectors.toList()).size());

    }

    private void question5(){
        //코플릿 5번 : computeAverageOfMaleMember
        Member coding= new Member("coding","Female",25);
        Member coding2= new Member("coding","Male",30);
        Member hacker=new Member("hacker","Male",32);
        List<Member> members=Arrays.asList(coding,hacker,coding2);
        System.out.println(members.stream().filter(x->x.getGender().equals("Male")).mapToInt(x->x.getAge()).average().orElse(0.0));
        // 참고사이트 : https://cornswrold.tistory.com/301
    }

    private void question6(){
        //코플릿 6번 : makeUniqueNameArray
        List<String> list= Arrays.asList("김코딩","박해커","김코딩","최자바","박해커");
        String[] result=list.stream().distinct().sorted().toArray(String[]::new);

        System.out.println(Arrays.toString(result));

    }

    private void question7(){
        //코플릿 7번 : filterName
        List<String> list= Arrays.asList("김코딩","박해커","김코딩","최자바","박해커","김자바");
        List<String> list2= Arrays.asList("코딩김","박해커","코딩김","최자바","박해커","자바김");
        String[] result=list2.stream().filter(x->x.charAt(0)=='김').sorted().toArray(String[]::new);
        System.out.println(Arrays.toString(result));
    }

    private void question8(){
        //코플릿 8번 : findBiggestNumber
        int[] arr={1,10,5,32,5};
        int max=Arrays.stream(arr).max().getAsInt();
        System.out.println(max);
    }

    private void question9(){
        //코플릿 9번 : findLongestLength
        //Arrays.stream(strArr).mapToInt(x->x.length()).max().getAsInt()
        //mapToInt로 instream을 만드는데 그 값을 길이로 설정해서 max로 최대값을 가져온다.

    }

    private void question10(){
        //코플릿 8번 : mergeTwoStream
        List<String> list1 = Arrays.asList("김코딩", "박해커");
        List<String> list2 = Arrays.asList("최자바", "이스프링");
        //Stream.concat() 사용 (리스트/배열 둘다 가능)
        List<String> newone=Stream.concat(list1.stream(),list2.stream()).collect(Collectors.toList());

    }

    private void question11(){
        //코플릿 11번 : makeElementDouble
        //list.stream().map(x->x*2).collect(Collectors.toList());

    }

    private void question12(){
        //코플릿 12번 : isHot
         int[] temperature = {25, 29, 30, 31, 26, 30, 33};
         if(Arrays.stream(temperature).filter(x->x>=30).count()>=3) System.out.println("더움");

    }

    private void question13(){
        //코플릿 13번 : findPeople
        //Stream.concat(male.stream(),female.stream()).distinct().filter(x->x.charAt(0)==lastName.charAt(0)).sorted().collect(Collectors.toList());
        //lastName String타입 매개변수 입력값. '김'이런거~
    }
    static class Member{
        String name;
        String gender;
        int age;

        public Member(String name, String gender,int age){
            this.name=name;
            this.gender=gender;
            this.age=age;
        }
        public String getName(){
            return name;
        }
        public String getGender(){
            return gender;
        }
        public int getAge(){return age;}
    }

}
