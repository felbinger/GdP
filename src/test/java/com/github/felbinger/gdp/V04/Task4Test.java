package com.github.felbinger.gdp.V04;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class Task4Test {

    @ParameterizedTest(name = "{index}: getMaxTest (exp: {0}, inp: {1})")
    @MethodSource("provideGetMaxTestArgs")
    public void getMaxTest(int expected, double[] input) {
        assertEquals(expected, Task4.getMax(input));
    }

    static Stream<Arguments> provideGetMaxTestArgs() {
        return Stream.of(
                Arguments.of(7, new double[]{5,1,2,7,6,3}),
                Arguments.of(5, new double[]{1,5,-2}),
                Arguments.of(Integer.MAX_VALUE, new double[]{1, Integer.MAX_VALUE, 2})
        );
    }

    @Test
    public void isGetMaxIllegalTest() {
        assertThrows(IllegalArgumentException.class, () -> Task4.getMax(new double[]{}));
        assertThrows(IllegalArgumentException.class, () -> Task4.getMax(null));
    }

    @ParameterizedTest(name = "{index}: getEvenTest (exp: {0}, inp: {1})")
    @MethodSource("provideGetEvenTestArgs")
    public void getAvgEvenTest(int expected, int[] input) {
        assertEquals(expected, Task4.getEvenAvg(input));
    }

    static Stream<Arguments> provideGetEvenTestArgs() {
        return Stream.of(
                Arguments.of(4, new int[]{1,2,3,4,5,6}),
                Arguments.of(2, new int[]{1, Integer.MAX_VALUE, 2})
        );
    }

    @Test
    public void getAvgEvenIllegalTest() {
        assertThrows(IllegalArgumentException.class, () -> Task4.getEvenAvg(new int[]{}));
        assertThrows(IllegalArgumentException.class, () -> Task4.getEvenAvg(null));
    }

    @ParameterizedTest(name = "{index}: reverseTest (exp: {0}, inp: {1})")
    @MethodSource("provideReverseTestArgs")
    public void reverseTest(char[] expected, char[] input) {
        assertArrayEquals(expected, Task4.reverse(input));
    }

    static Stream<Arguments> provideReverseTestArgs() {
        return Stream.of(
                Arguments.of(new char[]{'o', 'l', 'l', 'e', 'H'}, new char[]{'H', 'e', 'l', 'l', 'o'})
        );
    }

    @Test
    public void isReverseIllegalTest() {
        assertThrows(IllegalArgumentException.class, () -> Task4.reverse(new char[]{}));
        assertThrows(IllegalArgumentException.class, () -> Task4.reverse(null));
    }

    @ParameterizedTest(name = "{index}: isSortedTest (exp: {0}, inp: {1})")
    @MethodSource("provideIsSortedTestArgs")
    public void isSortedTest(boolean expected, long[] input) {
        assertEquals(expected, Task4.isSorted(input));
    }

    static Stream<Arguments> provideIsSortedTestArgs() {
        return Stream.of(
                Arguments.of(true, new long[]{1,2,3}),
                Arguments.of(false, new long[]{3,2,1}),
                Arguments.of(true, new long[]{-23,-16,-5}),
                Arguments.of(false, new long[]{-5,5,-1})
        );
    }

    @Test
    public void isSortedIllegalTest() {
        assertThrows(IllegalArgumentException.class, () -> Task4.isSorted(new long[]{}));
        assertThrows(IllegalArgumentException.class, () -> Task4.isSorted(null));
    }
}
