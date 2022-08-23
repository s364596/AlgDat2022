package algData;

public class Ukeoppgave1 {
    public static void main(String[] args) {
        int[] a = {8, 4, 17, 10, 6, 20, 1, 11, 15, 3, 18, 9, 2, 7, 19};

        int min_indeks = min(a);

        System.out.println(min_indeks);
        System.out.println(a[min_indeks]);
    }

    static int min(int[] a) {
        // Initialiser med første element
        int min_value = a[0];
        int min_indeks = 0;

        // Loop over alle resterende elementer og sjekk om vi finner et mindre tall
        for (int i = 1; i < a.length; i++) {
            int value = a[i];
            int indeks = i;


            // Sjekk om verdien er mindre enn det vi har sett tidligere
            if (value < min_value) {
                min_value = value;
                min_indeks = indeks;
            }
        }

        // Returnerer indeks til minste verdi
        return min_indeks;
    }
}
