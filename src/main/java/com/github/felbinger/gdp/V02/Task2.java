package com.github.felbinger.gdp.V02;

public final class Task2 {

    private Task2() {
        throw new UnsupportedOperationException();
    }

    public static int digitSum(int x) {
        if (x < 0) {
            return -1;
        }
        if (x == 0) {
            return 0;
        }
        if ((x % 10) == x) {
            return x;
        }
        return (x % 10) + digitSum((x - (x % 10)) / 10);
    }

    // FIXME 0, 0
    public static int countDigitInNumber(int digit, int number) {
        if (number < 0 || digit < 0 || digit > 9) {
            return -1;
        }

        if (number % 10 == number) {
            return ((number % 10) != digit) ? 0 : 1;
        }

        if (number % 10 == digit) {
            return 1 + countDigitInNumber(digit, (number - (number % 10)) / 10);
        } else {
            return countDigitInNumber(digit, (number - (number % 10)) / 10);
        }
    }
}
