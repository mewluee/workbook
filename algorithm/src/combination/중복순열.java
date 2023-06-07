package combination;

import java.util.Arrays;

public class 중복순열 {

    public static void main(String[] args) {
        int[] arrs = new int[]{1, 2, 3, 4, 5};

        int[] anws = new int[3];

        for (int i = 0; i < arrs.length; i++) {
            anws[0] = arrs[i];
            for (int j = 0; j < arrs.length; j++) {
                anws[1] = arrs[j];
                for (int k = 0; k < arrs.length; k++) {
                    anws[2] = arrs[k];
                    System.out.println(Arrays.toString(anws));
                }
            }
        }

        /* 출력
            [1, 1, 1] [1, 1, 2] [1, 1, 3] [1, 1, 4] [1, 1, 5]
            [1, 2, 1] [1, 2, 2] [1, 2, 3] [1, 2, 4] [1, 2, 5]
            [1, 3, 1] [1, 3, 2] [1, 3, 3] [1, 3, 4] [1, 3, 5]
            [1, 4, 1] [1, 4, 2] [1, 4, 3] [1, 4, 4] [1, 4, 5]
            [1, 5, 1] [1, 5, 2] [1, 5, 3] [1, 5, 4] [1, 5, 5]

            [2, 1, 1] [2, 1, 2] [2, 1, 3] [2, 1, 4] [2, 1, 5]
            [2, 2, 1] [2, 2, 2] [2, 2, 3] [2, 2, 4] [2, 2, 5]
            [2, 3, 1] [2, 3, 2] [2, 3, 3] [2, 3, 4] [2, 3, 5]
            [2, 4, 1] [2, 4, 2] [2, 4, 3] [2, 4, 4] [2, 4, 5]
            [2, 5, 1] [2, 5, 2] [2, 5, 3] [2, 5, 4] [2, 5, 5]

            [3, 1, 1] [3, 1, 2] [3, 1, 3] [3, 1, 4] [3, 1, 5]
            [3, 2, 1] [3, 2, 2] [3, 2, 3] [3, 2, 4] [3, 2, 5]
            [3, 3, 1] [3, 3, 2] [3, 3, 3] [3, 3, 4] [3, 3, 5]
            [3, 4, 1] [3, 4, 2] [3, 4, 3] [3, 4, 4] [3, 4, 5]
            [3, 5, 1] [3, 5, 2] [3, 5, 3] [3, 5, 4] [3, 5, 5]

            [4, 1, 1] [4, 1, 2] [4, 1, 3] [4, 1, 4] [4, 1, 5]
            [4, 2, 1] [4, 2, 2] [4, 2, 3] [4, 2, 4] [4, 2, 5]
            [4, 3, 1] [4, 3, 2] [4, 3, 3] [4, 3, 4] [4, 3, 5]
            [4, 4, 1] [4, 4, 2] [4, 4, 3] [4, 4, 4] [4, 4, 5]
            [4, 5, 1] [4, 5, 2] [4, 5, 3] [4, 5, 4] [4, 5, 5]

            [5, 1, 1] [5, 1, 2] [5, 1, 3] [5, 1, 4] [5, 1, 5]
            [5, 2, 1] [5, 2, 2] [5, 2, 3] [5, 2, 4] [5, 2, 5]
            [5, 3, 1] [5, 3, 2] [5, 3, 3] [5, 3, 4] [5, 3, 5]
            [5, 4, 1] [5, 4, 2] [5, 4, 3] [5, 4, 4] [5, 4, 5]
            [5, 5, 1] [5, 5, 2] [5, 5, 3] [5, 5, 4] [5, 5, 5]
            총 개수 = 125
        */

    }
}
