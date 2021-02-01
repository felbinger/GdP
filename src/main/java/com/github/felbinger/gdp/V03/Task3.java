package com.github.felbinger.gdp.V03;

public final class Task3 {

    private Task3() {
        throw new UnsupportedOperationException();
    }

    /**
     * method to calculate the faculty of n.
     * rules:
     * - no recursion
     * @param n number for which the faculty should be calculated
     * @return the faculty of n
     */
    public static int fac(int n) {
        if (n < 0) {
            return -1;
        }

        int ret = 1;
        for (int i = 0; i < n; i++) {
            if (ret > Integer.MAX_VALUE / (i + 1)) {
                return -1;
            }
            ret *= i + 1;
        }

        return ret;
    }

    /**
     * method to calculate the greatest common divisor of the two passed.
     * rules:
     * - no recursion, can be solved using while loops
     * - math operations %, /, and * are not allowed
     * @param a first number
     * @param b second number
     * @return greatest common divisor of a and b
     */
    public static int gcd(int a, int b) {
        if (a <= 0 || b <= 0) {
            return -1;
        }
        while (a > b) {
            a = a - b;
        }

        while (b > a) {
            b = b - a;
        }

        return b;
    }
}
