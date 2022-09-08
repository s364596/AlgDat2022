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

        int[] a = {3,8,10,12,14,16,21,24,27,30,32,33,34,37,40};  // Figur 1.3.5 a)
        System.out.println(Tabell.lineærsøk(a,32));              // utskrift: 10
        System.out.println(Tabell.lineærsøk(a,31));

    }
}
