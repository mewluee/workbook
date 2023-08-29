package stream;

import java.io.IOException;
import java.util.Arrays;

public class count함수 {
    public static void main(String[] args) throws IOException{
        int[] distance={0, 1, 1, 2, 3, 4, 2, 3};
        int count= (int) Arrays.stream(distance).filter(e->e==2).count();
        //왜 int형으로 cast해줘야 하나요?
        //count() 메서드가 long으로 반환하기 때문이다.
    }
}
