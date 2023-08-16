package array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 이차원배열복사하기 {

    public static void main(String[] args) {
        char[][] one=new char[3][3];
        IntStream.range(0, one.length)
                .forEach(e->Arrays.fill(one[e],'-'));
        배열출력(one);
        System.out.println("---");
        char[][] two=이차원배열복사(one);
        배열출력(two);
        System.out.println("one:"+one+", two:"+two);
        //실제로 다른 저장소인지 확인
    }

    static char[][] 이차원배열복사(char[][] origin){
        char[][] newOne=new char[origin.length][origin[0].length];
        IntStream.range(0,origin.length)
                .forEach(e->newOne[e]=Arrays.copyOf(origin[e],origin[e].length));
        return newOne;
    }

    static void 배열출력(char[][] arr) {
        IntStream.range(0, arr.length)
                .forEach(e-> System.out.println(Arrays.toString(arr[e])));
    }
}
