package hjelpeKlasser;

import java.util.*;

public class Tabell {
    private Tabell() {}

    public static void fratilKontroll(int tablengde, int fra, int til) {
        if (fra < 0) {
            throw new ArrayIndexOutOfBoundsException("fra(" + fra + ") er negativ!");
        }

        if (til > tablengde) {
            throw new ArrayIndexOutOfBoundsException("til (" + til + ") > tabelengde(" + tablengde + ")");
        }

        if (fra > til) {
            throw new IllegalArgumentException("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
        }

        if (fra == til) {
            throw new NoSuchElementException("fra (" + fra + ") til (" + til + ") - tomt tabellintervall!");
        }
    }

    public static void vhKontroll(int tablengde, int v, int h) {
        if (v < 0) {
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");
        }

        if (h >= tablengde) {
            throw new ArrayIndexOutOfBoundsException("h(" + h + ") >= tablengde(" + tablengde + ")");
        }

        if (v > h + 1) {
            throw new IllegalArgumentException("v = " + v + ", h = " + h);
        }
    }

    public static void aKontroll(int tablengde) {
        if (tablengde < 0) {
            throw new ArrayIndexOutOfBoundsException("tablengde (" + tablengde + ") er negativ!");
        }

        if (tablengde == 0) {
            throw new NullPointerException("tablengde (" + tablengde + ") er null!");
        }
    }

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static int[] randPerm(int n) {
        Random r = new Random();
        int[] a = new int[n];

        Arrays.setAll(a, i -> i + 1);

        for (int k = n - 1; k > 0; k--) {
            int i = r.nextInt(k+1);
            bytt(a, k, i);
        }

        return a;
    }

    public static void randPerm(int[] a) {
        Random r = new Random();

        for (int k = a.length - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);
            bytt(a, k, i);
        }
    }

    public static int maks(int[] a, int fra, int til) {

        fratilKontroll(a.length, fra, til);

        int m = fra;
        int maksverdi = a[fra];

        for (int i = fra + 1; i < til; i++) {
            if (a[i] > maksverdi) {
                m = i;
                maksverdi = a[m];
            }
        }
        return m;
    }

    public static int maks(int[] a) {
        return maks(a,0,a.length);
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

    public static int[] nestMaks(int[] a) {
        int n = a.length;

        if (n < 2) {
            throw new NoSuchElementException("a.length (" + n + ") < 2!");
        }

        int m = maks(a);
        int nm;

        if (m == 0) {
            nm = maks(a, 1, n);
        }

        else if (m == n - 1) {
            nm = maks(a,0,n-1);
        }

        else {
            int mv = maks(a,0,m);
            int mh = maks(a, m+1, n);
            nm = a[mh] > a[mh] ? mh : mv;
        }

        return new int[] {m,nm};
    }

    public static void bytt(char[] a, int i, int j) {
        char temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static void skriv(int[] a, int fra, int til) {
        fratilKontroll(a.length, fra, til);

        if (til - fra > 0) {
            System.out.print(a[fra]);
        }

        for (int i = fra + 1; i < til; i++) {
            System.out.print(" " + a[i]);
        }
    }
    public static void skriv(int[] a) {
        skriv(a,0,a.length);

    }

    public static void skrivIn(int[] a, int fra, int til) {
        fratilKontroll(a.length, fra, til);

        skriv(a, fra, til);
        System.out.println();
    }

        public static void skrivIn(int[] a) {
        skrivIn(a,0,a.length);
    }

}

