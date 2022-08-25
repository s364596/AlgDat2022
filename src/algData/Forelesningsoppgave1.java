package algData;

public class Forelesningsoppgave1 {
    public static void main(String[] args) {
        int[] a = {1, 3, 7, 0, 20, 12};
        int fra = 0;
        int til = 6;

        System.out.println(maks(a, fra, til));

    }

    static int maks(int [] a, int fra, int til) {
        int mix = fra;
        int maksverdi = a[mix];

        for (int i = fra + 1; i < til; i++) {
            if (a[i] > maksverdi) {
                maksverdi = a[i];
                mix = i;
            }
        }
        return mix;
    }
}
