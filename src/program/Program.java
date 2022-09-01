package program;

import hjelpeKlasser.*;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {

        /*
        int[] a = Tabell.randPerm(20);
        int m = Tabell.maks(a);
        Tabell.bytt(a,0,m);
        int nestM = Tabell.maks(a,1,a.length);

        Tabell.skrivIn(a);
        System.out.print("Indeksen til maks er: " + m);
        System.out.println(" Indeksen til nest-maks er: " + nestM);

        int[] b = Tabell.randPerm(20);
        int maks = Tabell.maks(b);
        Tabell.bytt(b,19,maks);
        int nestMaks = Tabell.maks(a,0,a.length-1);

        Tabell.skrivIn(b);
        System.out.println("\n " + maks);
        System.out.println("\n " + nestMaks);
        */

        int[] a = {7, 5, 21, 15, 27, 23, 13, 31, 8, 9, 18, 14, 3};
        int[] b = nestMaks(a);

        System.out.println(Arrays.toString(b));

    }

    public static int[] nestMaks(int[] a) {
        int n = a.length;

        if (n < 2) {
            throw new IllegalArgumentException("a.length " + n + " < 2!");
        }

        int[] b = new int[2*n];
        System.arraycopy(a,0,b,n,n);

        for (int k = 2*n-2; k > 1; k -= 2) {
            b[k/2] = Math.max(b[k], b[k+1]);
        }

        int maksverdi = b[1];
        int nestmaksverdi = Integer.MIN_VALUE;

        for (int m = 2*n - 1, k = 2; k < m; k *= 2) {
            int tempverdi = b[k+1];
            if (maksverdi != b[k]) {
                tempverdi = b[k];
                k++;
            }
            if (tempverdi > nestmaksverdi) {
                nestmaksverdi = tempverdi;
            }
        }
        return new int[] {maksverdi,nestmaksverdi};
    }
}
