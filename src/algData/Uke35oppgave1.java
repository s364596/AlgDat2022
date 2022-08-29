package algData;

public class Uke35oppgave1 {
    public static void main(String[] args) {
        int[] a = {3, 5, 9, 10 ,2, 90};

        System.out.print(min(a));
    }


    public static int min(int[] a, int fra, int til) {
        if (fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Illegalt intervall!");
        }

        int m = fra;
        int minverdi = a[fra];

        for (int i = fra + 1; i < til; i++) {
            if (a[i] < minverdi) {
                m = i;
                minverdi = a[m];
            }
        }
        return m;
    }
    public static int min(int[] a) {
        return min(a,0,a.length);
    }
}
