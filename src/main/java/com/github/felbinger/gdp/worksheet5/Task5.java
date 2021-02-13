package com.github.felbinger.gdp.worksheet5;

import edu.unibw.etti.array.ArrayGenerator;
import edu.unibw.etti.array.ArrayVisualizer;

import java.util.Arrays;

public final class Task5 {

    private Task5() {
        throw new UnsupportedOperationException();
    }

    private static int swapCount = 0;
    private static int compareCount = 0;
    private static boolean enableVisualisation = false;

    public static void selectionSort(double[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException();
        }

        swapCount = 0;
        compareCount = 0;

        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                compareCount++;
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            if (min != i) {
                double tmp = a[min];
                a[min] = a[i];
                a[i] = tmp;
                swapCount++;
            }
        }
    }

    public static void bubbleSort(int[] x) {
        if (x == null || x.length == 0) {
            throw new IllegalArgumentException();
        }

        swapCount = 0;
        compareCount = 0;

        if (enableVisualisation) {
            ArrayVisualizer.add(x);
        }

        boolean abort;
        for (int i = 0; i < x.length - 1; i++) {
            abort = false;
            for (int j = 0; j < x.length - i - 1; j++) {
                compareCount++;
                if (x[j] < x[j + 1]) {
                    if (!abort) {
                        abort = true;
                    }
                    continue;
                }
                ArrayVisualizer.update();
                int tmp = x[j];
                x[j] = x[j + 1];
                x[j + 1] = tmp;
                ArrayVisualizer.update();
                swapCount++;
            }
            if (abort) {
                return;
            }
        }
    }

    public static void main(String... args) {
        double[][] provided = new double[][] {
                {1.0, 2.0, 3.0, 4.0, 5.0},
                {5.0, 4.0, 3.0, 2.0, 1.0}
        };

        for (double[] v : provided) {
            System.out.printf("%s: ", Arrays.toString(v));
            selectionSort(v);
            System.out.printf("%s, %d compared, %d swapped%n",
                    Arrays.toString(v), compareCount, swapCount);
        }

        int[][] bubbleProvided = new int[][] {
                ArrayGenerator.generateDescendingArray(10),
                ArrayGenerator.generateAscendingArray(10)
        };

        for (int[] v : bubbleProvided) {
            System.out.printf("%s: ", Arrays.toString(v));
            bubbleSort(v);
            System.out.printf("%s, %d compared, %d swapped%n",
                    Arrays.toString(v), compareCount, swapCount);
        }
    }
}
