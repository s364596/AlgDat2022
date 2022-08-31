package program;

import hjelpeKlasser.*;

public class Program {
    public static void main(String[] args) {
        int[] a = Tabell.randPerm(20);
        int[] b = Tabell.nestMaks(a);

        int m = b[0], nm = b[1];

        Tabell.skrivIn(a);
        System.out.print("Størst (" + a[m] + ") har posisjon " + m);
        System.out.println(", nest størst (" + a[nm] + ") har posisjon " + nm);
    }
}
