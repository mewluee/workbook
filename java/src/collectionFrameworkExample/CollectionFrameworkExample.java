package collectionFrameworkExample;

import java.util.HashMap;

public class CollectionFrameworkExample {

    public void result(){

/*
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0; i<5; i++){

           al.add(i+1);
        }
        System.out.println(al);
        Integer integer=al.get(3).intValue();
        al.set(3, 3);

        int sum=0;

        Iterator it=al.iterator();
        while(it.hasNext()){
            sum+=(int)it.next();
        }

        System.out.println(sum);*/
/*
        HashMap<Character, Integer> hashMap=new HashMap<>();
        hashMap.put('a',1);
        hashMap.put('b',4);
        hashMap.put('c',6);
        hashMap.put('d',9);


        Set key=hashMap.keySet();
        int sum2=0;

        Iterator it2=key.iterator();

        while(it2.hasNext()){
            int one=(int)hashMap.get(it2.next());
            if(one%2==0) sum2+=one;
        }
        System.out.println(sum2);*/

        /*HashMap<String, List<String>> hashMap=new HashMap<String, List<String>>(){{
            put("apple", Arrays.asList("apple", "red"));
            put("banana", Arrays.asList("delicious"));
        }};

        String key="apple";
        int index=1;

        if(hashMap.containsKey(key)){
            if(hashMap.get(key).size()<=index) System.out.println("null");
            System.out.println(hashMap.get(key).get(index));

        }*/
/*
        HashMap<String, String> hashMap=new HashMap<String, String>(){{
            put("kimcoding", "1234");
            put("parkhacker", "qwer");
        }};

        System.out.println(hashMap.containsKey("kimcoding")&&hashMap.containsValue("qwer"));

    */

        // 코플릿 문제
        /*String[] arr = {"a", "c", "e"};

        HashMap<String, Integer> hashMap=new HashMap<String, Integer>(){{
            put("a", 1);
            put("b", 2);
            put("c", 3);

        }};

        HashMap<String, Integer> newone=new HashMap<>();

        for(int i=0;i<arr.length; i++){
            if(hashMap.containsKey(arr[i])){
                newone.put(arr[i],hashMap.get(arr[i]));
            }
        }*/

        String str="banana";
        HashMap<Character, Integer> hashmap=new HashMap<>();

        for(int i=0; i<str.length(); i++){
            if(!hashmap.containsKey(str.charAt(i))){ // 키 값이 없으면!
                hashmap.put(str.charAt(i),1); //키값-1 입력
                System.out.println(str.charAt(i)+"생성");
            }else{
                int count=(int)hashmap.get(str.charAt(i));
                System.out.println(str.charAt(i)+":"+count);
                hashmap.put(str.charAt(i),count+1);
                System.out.println(str.charAt(i)+":"+(int)(count+1));
            }
        }

        System.out.println(hashmap.toString());


    }
}
