package com.asymmetric.twinstrings;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Data testing
        List<String> firstString = Arrays.asList(
                "abcd",
                "abcd",
                "abc",
                "aabb"
        );

        List<String> secondString = Arrays.asList(
                "cbad",
                "adbc",
                "abc",
                "bbaa"
        );

        // Panggil method twins
        List<String> result = Result.twins(
                firstString,
                secondString
        );

        // Tampilkan hasil
        for (String value : result) {
            System.out.println(value);
        }
    }

}
