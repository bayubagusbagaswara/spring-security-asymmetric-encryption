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

    // Method twins adalah method untuk mengecek pasangan twin strings
    // firstString = list string pertama
    // secondString = list string kedua
    public static List<String> twins(List<String> firstString, List<String> secondString) {

        // Menyimpan hasil "Yes" atau "No"
        List<String> result = new ArrayList<>();

        // Loop setiap pasangan string
        for (int i = 0; i < firstString.size(); i++) {

            String first = firstString.get(i); // ambil string pertama pada index i
            String second = secondString.get(i); // ambil string kedua pada index i


            // Cek apakah panjang kedua string berbeda
            if (first.length() != second.length()) {
                result.add("No"); // Jika berbeda, kedua string pasti bukan twins. Jadi kita cek panjang string dulu
                continue; // Lanjut ke looping pasangan string berikutnya selanjutnya i+1
            }

            int[] firstEven = new int[26]; // Frekuensi huruf pada index genap string pertama
            int[] firstOdd = new int[26]; // Frekuensi huruf pada index ganjil string pertama
            int[] secondEven = new int[26]; // Frekuensi huruf pada index genap string kedua
            int[] secondOdd = new int[26]; // Frekuensi huruf pada index ganjil string kedua

            // Memeriksa setiap karakter, loop setiap karakter pada string
            for (int j = 0; j < first.length(); j++) {

                char firstChar = first.charAt(j); // Ambil karakter string pertama pada index j
                char secondChar = second.charAt(j); // Ambil karakter string kedua pada index j

                // Cek apakah index j adalah index genap
                if (j % 2 == 0) {
                    firstEven[firstChar - 'a']++;
                    // Hitung frekuensi karakter pada index genap string pertama
                    // Contoh: 'a' - 'a' = 0
                    //          'b' - 'a' = 1
                    //          'c' - 'a' = 2
                    secondEven[secondChar - 'a']++;
                    // Hitung frekuensi karakter pada index genap string kedua
                } else {
                    firstOdd[firstChar - 'a']++;
                    // Hitung frekuensi karakter pada index ganjil string pertama
                    secondOdd[secondChar - 'a']++;
                    // Hitung frekuensi karakter pada index ganjil string kedua
                }
            }

            // Membandingkan frekuensi karakter pada index genap
            boolean evenSame = Arrays.equals(firstEven, secondEven);

            // Membandingkan frekuensi karakter pada index ganjil
            boolean oddSame = Arrays.equals(firstOdd, secondOdd);

            // Jika kelompok genap dan ganjil sama
            if (evenSame && oddSame) {
                // Maka kedua string adalah twins
                result.add("Yes");
            } else { // Jika salah satu kelompok berbeda
                // Maka kedua string bukan twins
                result.add("No");
            }
        }
        // Mengembalikan semua hasil
        return result;
    }

}
