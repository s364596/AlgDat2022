package algData;

import java.util.Arrays;

public class Ukeoppgave2a {
    public static void main(String[] args) {
        int[] a = {17, 8, 20 , 3, 6, 2, 40};

        System.out.println(Arrays.toString(minmaks(a)));


    }
    static int[] minmaks (int[] a) {
        int min = a[0];
        int maks = a[0];

        for (int i=1; i < a.length; i++) {
            int value = a[i];

            if (value < min) {
                min = value;
            }

            if (value > maks) {
                maks = value;
            }
        }

        return new int[]{min, maks};
    }
}
