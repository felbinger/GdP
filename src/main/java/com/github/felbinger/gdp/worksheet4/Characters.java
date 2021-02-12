package com.github.felbinger.gdp.worksheet4;

import java.util.Arrays;

public final class Characters {

    private Characters() {
        throw new UnsupportedOperationException();
    }

    public static void main(String... args) {
        char[] input = new char[]{'K', 'a', 's', 's', 'e'};
        char[] output = replace(input, 'K', 'T');
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Output: " + Arrays.toString(output));
    }

    public static char[] replace(char[] a, char search, char replacement) {
        // copied a into local array b
        char[] b = new char[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] == search) {
                // write replacement to array b
                b[i] = replacement;
            } else {
                b[i] = a[i];
            }
        }
        // returned b instead of a
        return b;
    }
}
