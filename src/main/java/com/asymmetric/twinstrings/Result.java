package com.asymmetric.twinstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Aturan:
 * - karakter pada indeks genap hanya boleh ditukar dengan indeks genap
 * - karakter indeks ganjil hanya boleh ditukar dengan indeks ganjil
 */

public class Result {

    /*
     * Complete the 'twins' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY firstString
     *  2. STRING_ARRAY secondString
     */

    public static List<String> twins(
            List<String> firstString,
            List<String> secondString) {

        // Menyimpan hasil "Yes" atau "No"
        // untuk setiap pasangan string
        List<String> result = new ArrayList<>();

        // Loop setiap pasangan string
        for (int i = 0; i < firstString.size(); i++) {

            String first = firstString.get(i);
            String second = secondString.get(i);

            // Jika panjang string berbeda,
            // kedua string tidak mungkin menjadi twins
            if (first.length() != second.length()) {
                result.add("No");
                continue;
            }

            /*
             * Karena karakter hanya boleh ditukar:
             * - indeks genap dengan indeks genap
             * - indeks ganjil dengan indeks ganjil
             *
             * Maka kita menghitung frekuensi karakter
             * pada posisi genap dan ganjil secara terpisah.
             *
             * Array ukuran 26 karena karakter hanya a-z.
             */
            int[] firstEven = new int[26];
            int[] firstOdd = new int[26];

            int[] secondEven = new int[26];
            int[] secondOdd = new int[26];

            // Memeriksa setiap karakter
            for (int j = 0; j < first.length(); j++) {

                char firstChar = first.charAt(j);
                char secondChar = second.charAt(j);

                // Jika index genap
                if (j % 2 == 0) {

                    // Menghitung frekuensi karakter
                    // contoh 'a' - 'a' = 0
                    // contoh 'b' - 'a' = 1
                    firstEven[firstChar - 'a']++;
                    secondEven[secondChar - 'a']++;

                } else {

                    // Jika index ganjil
                    firstOdd[firstChar - 'a']++;
                    secondOdd[secondChar - 'a']++;
                }
            }

            /*
             * Kedua string adalah twins jika:
             *
             * 1. Frekuensi karakter di indeks genap sama
             * 2. Frekuensi karakter di indeks ganjil sama
             */
            if (Arrays.equals(firstEven, secondEven)
                    && Arrays.equals(firstOdd, secondOdd)) {

                result.add("Yes");

            } else {

                result.add("No");
            }
        }

        // Mengembalikan semua hasil
        return result;
    }
}
