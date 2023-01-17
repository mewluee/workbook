package queueExample;

import java.util.*;

public class QueueReference {

    public int queuePrinter(int bufferSize, int capacities, int[] documents){
        Queue<Integer> docBuffer=new LinkedList<Integer>();
        for(int i=0; i<documents.length; i++){
            docBuffer.add(documents[i]);
        }
        //docBuffer에 추가됨.

        Queue<Integer> buffer=new LinkedList<>(
                Collections.nCopies(bufferSize,0)
        );
        int sec=0; //초 세기

        buffer.poll();
        buffer.add(docBuffer.poll());
        sec++;

        //buffer의 사이즈가 bufferSize보다 작을때만 문서 입력
        //1 < 2일때
        //단 입력할때 capacities-(buffer 스택안의 값들의 합) >= 입력할 새로운 문서의 용량 일때만 입력해야함.

        // 전체 while문
        while(buffer.stream().reduce(0, Integer::sum)!=0||!docBuffer.isEmpty()){ // buffer큐가 비어있지 않고 docBuffer큐가 비어있지 않는다는건 문서가 큐에 있다는ㄱ ㅓㅅ.

            System.out.println("while 시작 sec:"+sec);


            int doc=0;

            System.out.println("출력전:"+Arrays.toString(buffer.stream().toArray()));
            //출력 조건
            if(buffer.stream().reduce(0, Integer::sum)!=0){ // 버퍼에 문서가 있는 경우

                if(buffer.peek()>0){ // (1) buffer큐의 왼쪽끝(출력)에 문서가 있을 경우
                    buffer.poll(); // 맨 왼쪽(출력)에 삭제하고
                    buffer.add(0); // 맨 오른쪽(입력)에 추가한다.

                }else{ // (2) buffer큐의 중간에 문서가 있는 경우
                    // 한칸씩 이동하는 코드(큐는 건들지 않고 리스트로 상태 구현)
                    buffer.poll(); // 맨 왼쪽(출력)에 삭제하고
                    buffer.add(0); // 맨 오른쪽(입력)에 추가한다.

                }
            }

            System.out.println("입력전:"+Arrays.toString(buffer.stream().toArray()));
            //입력 조건
            if(!docBuffer.isEmpty()){ // doc버퍼에 문서가 있는 경우
                System.out.println("실행이..안되나..?");
                doc=docBuffer.peek(); // 입력하기 위해 비교용으로 peek만함. 실제 넣을지말지는 모름.

                ////////////////////////////////////////////////////////
                int bufferDocSize=0;
                Iterator iterator=((LinkedList)buffer).iterator();
                while(iterator.hasNext()){
                    bufferDocSize=bufferDocSize+((Integer)iterator.next()).intValue();
                    //System.out.println("buffer size:"+size);
                }
                //여기까지 현재 buffer에 저장된 문서들의 용량의 총 합 구하기
                //////////////////////////////////////////////////////// 스트림으로 구현하기
                //System.out.println("size1:"+bufferDocSize);

                if(bufferDocSize+doc<=capacities){ // (1) 새로운 문서를 넣었을 때 제한된 용량을 넘지 않는 경우
                        System.out.println("size2:"+bufferDocSize);
                        System.out.println("doc:"+doc);
                        docBuffer.poll();
                        //buffer.poll();
                        ((LinkedList)buffer).removeLast();
                        buffer.add(doc); // 맨 오른쪽(입력)에 문서 입력
                        System.out.println(buffer);

                }
            }
            System.out.println("입력후:"+Arrays.toString(buffer.stream().toArray()));

            sec++;
            System.out.println(sec);
            //System.out.println("buffer:"+buffer.toString());
        }

        return sec;




    }
}
