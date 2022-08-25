package algData;

public class Ukeoppgave2b {
    public static void main(String[] args) {
        int n = 100;
        System.out.println(fak(n));

    }

    public static long fak(int n) {
        long fak = 1;

        for (int i = 2; i <= n; i++) {
            fak *= i;
        }
        return fak;
    }
}
