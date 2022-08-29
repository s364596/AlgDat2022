package program;

import hjelpeKlasser.*;

public class Program {
    public static void main(String[] args) {
        int[] a = Tabell.randPerm(20);

        for (int k : a) {
            System.out.print(k + " ");
        }

        int m = Tabell.maks(a);
        System.out.println("\nStørste verdi ligger på " + m);

    }
}
