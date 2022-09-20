package algData;

import hjelpeKlasser.Tabell;

import java.util.Arrays;
import java.util.Optional;

public class Kapittel4 {
    public static void main(String[] args) {
        /*
        //1.4.1 c)
        int[] a = {5,2,7,3,9,1,8,4,6};
        double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        String[] s = {"Shoil", "Per", "Thanh", "Fatima", "Kari", "Jasmin"};
        char[] f = {'a', 'j', 'd', 'l', 'w'};

        int k = Tabell.maks(a);
        int l = Tabell.maks(d);
        int m = Tabell.maks(s);
        int n = Tabell.maks(f);

        System.out.println(a[k] + " " + d[l] + " " + s[m] + " " + f[n]);
        */

        //Oppgave 3, 1.4.1
        /*
        Integer[] a = {5,2,7,3,9,1,8,4,6};
        int b = Tabell.maks(a);
        System.out.println(a[b]);
         */

        //Oppgave 4, 1.4.1
        /*
        Integer a = 1002;
        Integer b = 100;
        Sy stem.out.println(a.compareTo(b));
         */

        String[] s = {"Sohil", "Per", "Thanh", "Fatima", "Kari", "Jasmin"};
        Tabell.innsettingssortering(s);
        System.out.println(Arrays.toString(s));

    }
}
