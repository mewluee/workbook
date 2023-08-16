package array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class char형배열생성하면초기값이뭐지 {
    public static void main(String[] args) {
        기본생성하면어떤값();
        이차원배열초기화스트림();
    }

    public static void 기본생성하면어떤값(){
        char[] map=new char[2];
        System.out.println(Arrays.toString(map));
        // [ null , null ] 출력
    }

    public static void 이차원배열초기화스트림(){
        char[][] map = new char[2][3];
        IntStream.range(0, 2)
                .forEach(e->Arrays.fill(map[e],'-'));
        System.out.println(Arrays.toString(map[1]));
        // [-,-,-] 출력
    }
}
