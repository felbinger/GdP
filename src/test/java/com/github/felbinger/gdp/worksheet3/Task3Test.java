package com.github.felbinger.gdp.worksheet3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Task3Test {

    @ParameterizedTest(name = "{index}: facTest (exp: {0}, inp: {1})")
    @MethodSource("provideFacTestArgs")
    public void facTest(int expected, int input) {
        assertEquals(expected, Task3.fac(input));
    }

    static Stream<Arguments> provideFacTestArgs() {
        return Stream.of(
                Arguments.of(-1, Integer.MIN_VALUE),
                Arguments.of(-1, -1),
                Arguments.of(1, 0),
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(6, 3),
                Arguments.of(24, 4),
                Arguments.of(120, 5),
                Arguments.of(720, 6),
                Arguments.of(5040, 7),
                Arguments.of(40320, 8),
                Arguments.of(362880, 9),
                Arguments.of(3628800, 10),
                Arguments.of(39916800, 11),
                Arguments.of(479001600, 12),
                Arguments.of(-1, 13),
                Arguments.of(-1, 25),
                Arguments.of(-1, Integer.MAX_VALUE)
        );
    }

    @ParameterizedTest(name = "{index}: ggtTest (exp: {0}, a: {1}, b: {2})")
    @MethodSource("provideGgtTestArgs")
    public void ggtTest(int expected, int a, int b) {
        assertEquals(expected, Task3.gcd(a, b));
    }

    static Stream<Arguments> provideGgtTestArgs() {
        return Stream.of(
            Arguments.of(6, 18, 24),
            Arguments.of(3, 12, 15),
            Arguments.of(-1, 1, 0),
            Arguments.of(-1, 0, 1),
            Arguments.of(-1, 0, 0),
            Arguments.of(-1, 1, -1),
            Arguments.of(-1, -1, 1),
            Arguments.of(-1, -1, -1)
        );
    }
}
