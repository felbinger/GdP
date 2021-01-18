package com.github.felbinger.gdp.V01;

public final class Task1 {

    private Task1() {
        throw new UnsupportedOperationException();
    }

    public static void main(String... args) {
        double a = 100;
        double b = 75;
        System.out.printf("sqrt(%.1f^2 + %.1f^2) = %.1f%n", a, b, Math.hypot(a, b));
    }
}
