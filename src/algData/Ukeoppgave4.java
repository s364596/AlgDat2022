package algData;

import java.util.*;

import static algData.Ukeoppgave4.Program.antallMaks;

public class Ukeoppgave4 {
    public static void main(String[] args) {
        int n = 200_000;  // tabellstørrelse
        System.out.println(antallMaks(Program.randPerm(n)));
    }

    static class Program
    {
        public static void bytt(int[] a, int i, int j)
        {
            int temp = a[i]; a[i] = a[j]; a[j] = temp;
        }

        static int[] randPerm(int n)  // en effektiv versjon
        {
            Random r = new Random();         // en randomgenerator
            int[] a = new int[n];            // en tabell med plass til n tall

            Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

            for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
            {
                int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
                bytt(a,k,i);                   // bytter om
            }

            return a;                        // permutasjonen returneres
        }
        static int antallMaks(int[] a)    // teller opp i a
        {
            int antall = 0;            // antall tall
            int maksverdi = a[0];

            for (int i = 1; i < a.length; i++)    // går gjennom tabellen a
            {
                if (a[i] > maksverdi)    // a[i] er større enn største foran
                {
                    antall++;              // har funnet et nytt tall
                    maksverdi = a[i];      // oppdaterer maksverdi
                }
            }

            return antall;    // de som er større enn det største foran
        }



    }
}
