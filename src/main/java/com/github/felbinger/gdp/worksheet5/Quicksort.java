package com.github.felbinger.gdp.worksheet5;

import java.util.Arrays;

public final class Quicksort {
    private Quicksort() {
        throw new UnsupportedOperationException();
    }

    public static void quickSort(double[] a, int i, int j) {
        if (a == null || a.length == 0 || j <= i) {
            return;
        }

        double pivot = a[i];
        int left = i;
        int right = j;
        while (left <= right) {
            while (a[left] > pivot) {
                left++;
                if (left > j) {
                    break;
                }
            }
            while (a[right] <= pivot) {
                right--;
                if (right < i) {
                    break;
                }
            }
            if (left < right) {
                double tmp = a[left];
                a[left] = a[right];
                a[right] = tmp;
            }
        }
        if (right < i) {
            quickSort(a, i, i);
            quickSort(a, i + 1, j);
        } else {
            quickSort(a, i, right);
            quickSort(a, left, j);
        }
    }

    public static void main(String... args) {
        double[] x = {1.0, 3.0, 4.5, 2.3, 7.1, 1.2, 1.5, 3.0};
        quickSort(x, 0, x.length - 1);
        System.out.println("[7.1, 4.5, 3.0, 3.0, 2.3, 1.5, 1.2, 1.0]==" + Arrays.toString(x));
    }
}
