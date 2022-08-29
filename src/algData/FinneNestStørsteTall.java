package algData;

import static java.lang.Math.min;
import static java.lang.Math.max;

public class FinneNestStørsteTall {
    public static void main(String[] args) {
        int[] a = {3, 9, 11, 5, 2, 17, 4, 14};

        System.out.println("Det minst største tallet i arrayet a er: " + nestMaks(a));
    }

    static int nestMaks(int[] a) {
        int nest_maks = min(a[0], a[1]);
        int maks = max(a[0], a[1]);

        for (int i = 2; i < a.length; i++) {
            if (a[i] > nest_maks) {
                if (a[i] > maks) {
                    nest_maks = maks;
                    maks = a[i];
                }
                else {
                    nest_maks = a[i];
                }
            }
        }
        return nest_maks;
    }
}
