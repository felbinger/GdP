package com.github.felbinger.gdp.V04;

import java.util.Arrays;

public final class Matrix {
    private Matrix() {
        throw new UnsupportedOperationException();
    }

    public static boolean isMatrix(double[][] a, int l, int m) {
        if (l <= 0 || m <= 0 || a.length != l) {
            return false;
        }
        for (double[] v : a) {
            if (v.length != m) {
                return false;
            }
        }
        return true;
    }

    public static void printMatrix(double[][] a) {
        if (!isMatrix(a, a.length, a[0].length)) {
            return;
        }
        for (double[] v : a) {
            System.out.println(Arrays.toString(v));
        }
    }

    public static double[][] mul(double[][] a, double[][] b) {
        if (a == null || b == null
                || a.length == 0 || b.length == 0
                || !isMatrix(a, a.length, a[0].length)
                || !isMatrix(b, b.length, b[0].length)) {
            throw new IllegalArgumentException();
        }

        // check if the matrices can be multiplied
        for (double[] v : b) {
            if (a.length != v.length) {
                throw new IllegalArgumentException();
            }
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
