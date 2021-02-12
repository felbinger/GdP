package com.github.felbinger.gdp.worksheet2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Task2Test {

    @ParameterizedTest(name = "{index}: digitSumTest (exp: {0}, inp: {1})")
    @MethodSource("provideDigitSumTestArgs")
    public void digitSumTest(int expected, int input) {
        assertEquals(expected, Task2.digitSum(input));
    }

    static Stream<Arguments> provideDigitSumTestArgs() {
        return Stream.of(
                Arguments.of(-1, Integer.MIN_VALUE),
                Arguments.of(0, 0),
                Arguments.of(4, 13),
                Arguments.of(10, 28),
                Arguments.of(11, 29),
                Arguments.of(23, 1293404),
                Arguments.of(46, Integer.MAX_VALUE)
        );
    }

    @ParameterizedTest(name = "{index}: countNumber (exp: {0}, digit: {1}, number: {2})")
    @MethodSource("provideCountNumberTestArgs")
    public void countNumberTest(int expected, int digit, int number) {
        assertEquals(expected, Task2.countDigitInNumber(digit, number));
    }

    static Stream<Arguments> provideCountNumberTestArgs() {
        return Stream.of(
                Arguments.of(-1, -1, -125),
                Arguments.of(-1, 8, Integer.MIN_VALUE),
                Arguments.of(-1, 12, 125123512),
                Arguments.of(1, 0, 0),
                Arguments.of(2, 1, 125612),
                Arguments.of(3, 1, 1213414),
                Arguments.of(3, 4, Integer.MAX_VALUE)
        );
    }
}
