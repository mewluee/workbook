package charaterAndAsciicodeExample;

import java.util.Arrays;

public class CharaterAndAsciicodeExample {

    public void result() {

        char t1 = 65;
        char t2 = 'a';
        //아스키코드값 숫자 0(48) 1(49) .. 6(54)
        //아스키코드값 문자 A(65) B(66) ..  / a(97) b(98)
        System.out.println(t1); // A (변수 t1의 타입이 char형이라서 입력받은 int형 값을 자동형변환 후 출력)
        System.out.println(t2); // a (변수 t2의 타입이 char형이면서 입력값도 char형이라서 값을 그대로 출력)

        System.out.println(65); // 65 (숫자가 들어왔으니 숫자로 출력)
        System.out.println('0'); // 0 (char형이 들어왔으니 기본적으로 char형으로 출력)
        System.out.println((int) '0'); // 48 (char형을 int형으로 강제형변환 후 출력)
        System.out.println((char) 48); // 0 (int형을 char형으로 강제형변환 후 출력)

        System.out.println('0' - 'a'); // -49 ('0' 48 - 'a' 97 = -49)
        // char형 타입으로 들어오면 일단 내부적으로 숫자로 변환하고(컴퓨터는 문자몰라) > 숫자-숫자=숫자 > 결과가 int형이니까 그냥 그대로 숫자로 출력함.
        System.out.println('6' - '0'); // 6 ('6' 54 - '0' 48 = 6)
        // 이걸 응용하면 char -> int 형으로 형변환이 가능함.


        // *** 응용 ***
        // 입력받은 (단, 소문자으로만 구성됨)문자열의 알파벳을 카운트
        String str = "aaabbbbcefgzzzzyyx";
        int[] alphabetCount = new int[26]; // new생성자 사용시 모든 값이 0으로 초기화됨.

        for (int i = 0; i < str.length(); i++) {
            alphabetCount[str.charAt(i) - 'a']++; // 위의 20라인을 응용함.
        }

        System.out.println(Arrays.toString(alphabetCount));


    }
}
