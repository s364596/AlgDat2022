package hjelpeKlasser;

import java.util.*;

public class Tabell {
    private Tabell() {
    }

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
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] randPerm(int n) {
        Random r = new Random();
        int[] a = new int[n];

        Arrays.setAll(a, i -> i + 1);

        for (int k = n - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);
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
        return maks(a, 0, a.length);
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
        return min(a, 0, a.length);
    }

    public static int[] nestMaks(int[] a) {
        int n = a.length;

        if (n < 2) {
            throw new NoSuchElementException("a.length (" + n + ") < 2!");
        }

        int m = 0;
        int nm = 1;

        if (a[1] > a[0]) {
            m = 1;
            nm = 0;
        }

        int maksverdi = a[m];
        int nestmaksverdi = a[nm];

        for (int i = 2; i < n; i++) {
            if (a[i] > nestmaksverdi) {

                if (a[i] > maksverdi) {

                    nm = m;
                    nestmaksverdi = maksverdi;

                    m = i;
                    maksverdi = a[m];
                } else {
                    nm = i;
                    nestmaksverdi = a[nm];
                }
            }
        }
        return new int[]{m, nm};
    }

    public static void bytt(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
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
        skriv(a, 0, a.length);

    }

    public static void skrivIn(int[] a, int fra, int til) {
        fratilKontroll(a.length, fra, til);

        skriv(a, fra, til);
        System.out.println();
    }

    public static void skrivIn(int[] a) {
        skrivIn(a, 0, a.length);
    }

    public static void sortering(int[] a) {
        for (int i = a.length; i > 1; i--) {
            int m = maks(a, 0, i);
            bytt(a, i - 1, m);

        }
    }

    public static void kopier(int[] a, int i, int[] b, int j, int ant) {
        for (int n = i + ant; i < n; ) {
            b[j++] = a[i++];
        }
    }

    public static void snu(int[] a, int v, int h) {
        while (v < h) {
            bytt(a, v++, h--);
        }
    }

    public static void snu(int[] a, int v) {
        snu(a, v, a.length - 1);
    }

    public static void snu(int[] a) {
        snu(a, 0, a.length - 1);
    }

    public static boolean nestePermutasjon(int[] a) {
        int i = a.length - 2;
        while (i >= 0 && a[i] > a[i + 1]) {
            i--;
        }

        if (i < 0) {
            return false;
        }

        int j = a.length - 1;
        while (a[j] < a[i]) {
            j--;
        }
        bytt(a, i, j);
        snu(a, i + 1);

        return true;
    }

    public static int inversjoner(int[] a) {
        int antall = 0;

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    antall++;
                }
            }
        }
        return antall;
    }

    public static boolean erSortert(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                return false;
            }
        }
        return true;
    }

    public static void utvalgssortering(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            bytt(a, i, min(a, i, a.length));
        }
    }

    public static void utvalgssortering(int[] a, int fra, int til) {
        fratilKontroll(a.length, fra, til);

        for (int i = fra; i < til - 1; i++) {
            bytt(a, i, min(a, i, til));
        }
    }

    public static int usorterts??k(int[] a, int verdi) {
        for (int i = 0; i < a.length; i++) {
            if (verdi == a[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int line??rs??k(int[] a, int verdi) {
        if (a.length == 0 || verdi > a[a.length - 1]) {
            return -(a.length + 1);
        }

        int i = 0;
        for (; a[i] < verdi; i++) ;
        return verdi == a[i] ? i : -(i + 1);
    }

    public static int bin??rs??k(int[] a, int fra, int til, int verdi) {
        Tabell.fratilKontroll(a.length, fra, til);
        int v = fra, h = til - 1;

        while (v < h) {
            int m = (v + h / 2);

            if (verdi > a[m]) {
                v = m + 1;
            } else {
                h = m;
            }
        }
        if (h < v || verdi < a[v]) {
            return -(v + 1);
        } else if (verdi == a[v]) {
            return v;
        } else {
            return -(v + 2);
        }
    }
    public static int bin??rs??k(int[] a, int verdi) {
        return bin??rs??k(a,0,a.length,verdi);
    }

    public static int maks(double[] a) {
        int m = 0;
        double maksverdi = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] > maksverdi) {
                maksverdi = a[i];
                m = i;
            }
        }
        return m;
    }

    public static int maks(String[] a) {
        int m = 0;
        String maksverdi = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(maksverdi) > 0) {
                maksverdi = a[i];
                m = i;
            }
        }
        return m;
    }

        public static int maks(char[] a) {
            int m = 0;
            char maksverdi = a[0];

            for (int i = 1; i < a.length; i++) {
                if (a[i] > maksverdi) {
                    maksverdi = a[i];
                    m = i;
                }
            }
            return m;
    }


    public static int maks(Integer[] a){
        int m = 0;
        Integer maksverdi = a[0];

        for (int i = 1; i < a.length; i++) {
            if(a[i].compareTo(maksverdi) > 0) {
                maksverdi = a[i];
                m = i;
            }
        }
        return m;
    }

    public static <T extends Comparable<? super T>> int maks(T[] a) {
        int m = 0;
        T maksverdi = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(maksverdi) > 0) {
                maksverdi = a[i];
                m = i;
            }

        }
        return m;
    }

    public static <T extends Comparable<? super T>> void innsettingssortering(T[] a) {
        for (int i = 1; i < a.length; i++) {
            T verdi = a[i];
            int j = i-1;

            for (; j >= 0 && verdi.compareTo(a[j]) < 0 ; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = verdi;
        }
    }
}



