package com.github.felbinger.gdp.V04;

public final class Task4 {
    private Task4() {
        throw new UnsupportedOperationException();
    }

    public static double getMax(double[] a) {
        double max = 0.0;
        if (a == null) {
            throw new IllegalArgumentException();
        }
        for (double v : a) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    public static double getEvenAvg(int[] a) {
        int sum = 0;
        int counter = 0;
        for (int v : a) {
            if (v != 0 && v % 2 == 0) {
                sum += v;
                counter++;
            }
        }
        return (double) sum / counter;
    }

    public static char[] reverse(char[] a) {
        if (a == null) {
            throw new IllegalArgumentException();
        }
        if (a.length == 0) {
            return a;
        }
        char[] ret = new char[a.length];
        for (int i = 0; i < a.length; i++) {
            ret[a.length - 1 - i] = a[i];
        }
        return ret;
    }

    public static boolean isSorted(long[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i + 1 < a.length; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
