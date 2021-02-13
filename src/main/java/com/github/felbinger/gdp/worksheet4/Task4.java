package com.github.felbinger.gdp.worksheet4;

public final class Task4 {
    private Task4() {
        throw new UnsupportedOperationException();
    }

    public static double getMax(double[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException();
        }
        double max = -Double.MIN_VALUE;
        for (double v : a) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    @SuppressWarnings("PMD.DataflowAnomalyAnalysis")
    public static double getEvenAvg(int[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException();
        }
        long sum = 0;
        int counter = 0;
        for (int v : a) {
            if (v != 0 && v % 2 == 0) {
                sum += v;
                counter++;
            }
        }
        return (counter == 0) ? 0.0 : (double) sum / counter;
    }

    public static char[] reverse(char[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException();
        }
        char[] ret = new char[a.length];
        for (int i = 0; i < ret.length; i++) {
            ret[ret.length - 1 - i] = a[i];
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
