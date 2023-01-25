package queue;

import java.util.*;

public class QueueExample {

    public int paveBox(Integer[] boxes){

        Queue<Integer> queue=new LinkedList<Integer>();
        for(int i=0; i<boxes.length; i++){
            queue.add(boxes[i]);
        }

        int max=0;
        //앞사람 값 뽑아두기.(기준값용)
        while(!queue.isEmpty()){
            //System.out.println("while문 시작");
            int boxForFirst=queue.peek();
            int count=0;
            //System.out.println("queue siez:"+queue.size());
            int size=queue.size();
            for(int j=0; j<size; j++){
                //System.out.println("j:"+j);
                if(boxForFirst>=queue.peek()){
                    //System.out.println("peek:"+queue.peek());
                    queue.poll();
                    count++;
                }else{
                    //System.out.println("queue.peek():"+queue.peek());
                    //System.out.println("First:"+boxForFirst);
                    break;
                }
            }
            if(count>max){
                max=count;
            }
        }
        return max;
    }

    public int queuePrinter(int bufferSize, int capacities, int[] documents){
        Queue<Integer> docBuffer=new LinkedList<Integer>();
        for(int i=0; i<documents.length; i++){
            docBuffer.add(documents[i]);
        }
        //docBuffer에 추가됨.

        Queue<Integer> buffer=new LinkedList<>();
        //int[] bufferArr=new int[bufferSize];
        //Arrays.fill(bufferArr,0);
        ArrayList<Integer> bufferArr2=new ArrayList(
                Collections.nCopies(bufferSize,0) // 0을 buffersize개수 만큼 초기화 {0, 0, 0...}
        );
        int sec=0; //초 세기

        //buffer의 사이즈가 bufferSize보다 작을때만 문서 입력
        //1 < 2일때
        //단 입력할때 capacities-(buffer 스택안의 값들의 합) >= 입력할 새로운 문서의 용량 일때만 입력해야함.

        // 전체 while문
        while(!buffer.isEmpty()||!docBuffer.isEmpty()){ // buffer큐가 비어있지 않고 docBuffer큐가 비어있지 않는다는건 문서가 큐에 있다는ㄱ ㅓㅅ.

            //System.out.println("sec:"+sec);


            int doc=0;

            /*if(!docBuffer.isEmpty()) {
                //입력해야할 값이 있을 경우

                doc = docBuffer.peek(); //넣을지 안넣을지 모르니까 일단 peek
                System.out.println("doc:" + doc);

                if (buffer.size() < bufferSize) { // 입력작업 조건 공간이 있을때
                    // 공간이 있다고 막 넣으면 안됨. 0<2 or 1<2
                    System.out.println("(3) 입력조건");
                    if (capacities - size >= doc) { // 새로운 문서를 넣을 용량이 되면 (총용량-buffer의문서총합) >= doc사이즈
                        buffer.add(doc); // 그때 넣기.
                        bufferArr[bufferSize-1]=1; // 배열 맨 뒤에서 하나씩 넣기.(인덱스 뒤에서부터 1씩)
                        docBuffer.poll(); // docbuffer에선 출력하기.

                    }else if (buffer.size() >= bufferSize) { // 출력작업 조건1 버퍼 큐에 사이즈만큼 있다는건 출력 작업을 해야하는것.
                        System.out.println("(1) 출력조건1");
                        buffer.poll(); // buffer에서 출력.

                    } else if (size + doc > capacities) { // 출력작업 조건2 사이즈만큼은 없지만 새로운 문서를 넣을 수 없을 만큼의 총량일때 출력 작업해야함.
                        System.out.println("(2) 출력조건2");
                        buffer.poll();
                    }
                }
            }else{
                if(bufferArr[0]==1){ // 문서가 큐의 맨앞에 있는 경우 출력해야함.
                    buffer.poll();
                    bufferArr[0]=0; // 바꿔줌!
                }


            }*/

            //출력 조건
            if(!buffer.isEmpty()){ // 버퍼에 문서가 있는 경우

                if(bufferArr2.get(0)==1){ // (1) buffer큐의 왼쪽끝(출력)에 문서가 있을 경우
                    buffer.poll();
                    bufferArr2.remove(0); // 맨 왼쪽(출력)에 삭제하고
                    bufferArr2.add(0); // 맨 오른쪽(입력)에 추가한다.

                }else{ // (2) buffer큐의 중간에 문서가 있는 경우
                    // 한칸씩 이동하는 코드(큐는 건들지 않고 리스트로 상태 구현)
                    bufferArr2.remove(0); // 맨 왼쪽(출력)에 삭제하고
                    bufferArr2.add(0); // 맨 오른쪽(입력)에 추가한다.

                }
            }

            //입력 조건
            if(!docBuffer.isEmpty()){ // doc버퍼에 문서가 있는 경우
                doc=docBuffer.peek(); // 입력하기 위해 비교용으로 peek만함. 실제 넣을지말지는 모름.

                if(bufferArr2.get(bufferArr2.size()-1)==0){ //buffer큐의 오른쪽 끝(입력)에 공간이 있는 경우

                    ////////////////////////////////////////////////////////
                    int bufferDocSize=0;
                    Iterator iterator=((LinkedList)buffer).iterator();
                    while(iterator.hasNext()){
                        bufferDocSize=bufferDocSize+((Integer)iterator.next()).intValue();
                        //System.out.println("buffer size:"+size);
                    }
                    //여기까지 현재 buffer에 저장된 문서들의 용량의 총 합 구하기
                    //////////////////////////////////////////////////////// 스트림으로 구현하기

                    if(bufferDocSize+doc<=capacities){ // (1) 새로운 문서를 넣었을 때 제한된 용량을 넘지 않는 경우
                        buffer.add(doc);
                        docBuffer.poll();
                        bufferArr2.set(bufferArr2.size()-1,1); // 맨 오른쪽(입력)을 1로 만든다.
                    }
                }
            }

            sec++;
            //System.out.println("buffer:"+buffer.toString());
        }

        return sec;




    }

    public void howResult(){

        //main메서드 입력 내용
        QueueExample qe=new QueueExample();
        int bufferSize = 2;
        int capacities = 10;
        int[] documents = new int[]{7,4,5,6};

        int output5=qe.queuePrinter(bufferSize,capacities,documents);
        System.out.println("코플릿5번:"+output5);



        int[] boxes=new int[]{5,1,4,6};
        Integer[] boxes2= Arrays.stream(boxes).boxed().toArray(Integer[]::new);
        int output4=qe.paveBox(boxes2);
        System.out.println("코플릿4번:"+output4);
    }
}
