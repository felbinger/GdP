package com.github.felbinger.gdp.worksheet4;

import java.util.Arrays;

public final class Matrix {
    private Matrix() {
        throw new UnsupportedOperationException();
    }

    public static boolean isMatrix(double[][] a) {
        return isMatrix(a, a.length, a[0].length);
    }

    public static boolean isMatrix(double[][] a, int l, int m) {
        if (l <= 0 || m <= 0 || a == null || a.length != l) {
            return false;
        }

        for (double[] v : a) {
            if (v == null || v.length != m) {
                return false;
            }
            for (double w : v) {
                if (!Double.isFinite(w)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printMatrix(double[][] a) {
        if (a == null || a.length == 0 || a[0] == null
                || !isMatrix(a, a.length, a[0].length)) {
            return;
        }
        for (double[] v : a) {
            System.out.println(Arrays.toString(v));
        }
    }

    public static double[][] mul(double[][] a, double[][] b) {
        if (a == null || a.length == 0 || a[0] == null || !isMatrix(a)
                || b == null || b.length == 0 || b[0] == null || !isMatrix(b)
                || a.length != b[0].length) {
            throw new IllegalArgumentException();
        }

        double[][] ret = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                ret[i][j] = 0;
                for (int k = 0; k < a[0].length; k++) {
                    ret[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return ret;
    }
}
