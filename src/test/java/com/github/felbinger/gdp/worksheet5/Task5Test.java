package com.github.felbinger.gdp.worksheet5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public final class Task5Test {

    @ParameterizedTest(name = "{index}: selectionSort (exp: {0}, inp: {1})")
    @MethodSource("provideSelectionSortTestArgs")
    public void selectionSortTest(double[] expected, double[] input) {
        Task5.selectionSort(input);
        assertArrayEquals(expected, input);
    }

    static Stream<Arguments> provideSelectionSortTestArgs() {
        return Stream.of(
                Arguments.of(new double[]{1.0, 2.0, 3.0, 4.0}, new double[]{1.0, 2.0, 3.0, 4.0}),
                Arguments.of(new double[]{1.0, 2.0, 3.0, 4.0}, new double[]{4.0, 3.0, 2.0, 1.0}),
                Arguments.of(new double[]{1.0, 1.0, 1.0, 1.0}, new double[]{1.0, 1.0, 1.0, 1.0}),
                Arguments.of(new double[]{-1.0, 0.0, 1.0}, new double[]{-1.0, 1.0, 0.0}),
                Arguments.of(new double[]{-1.0, 0.0, 1.0}, new double[]{0.0, 1.0, -1.0})
        );
    }

    @Test
    public void selectionSortIllegalTest() {
        assertThrows(IllegalArgumentException.class, () -> Task5.selectionSort(null));
        assertThrows(IllegalArgumentException.class, () -> Task5.selectionSort(new double[]{}));
    }

    @ParameterizedTest(name = "{index}: bubbleSort (exp: {0}, inp: {1})")
    @MethodSource("provideBubbleSortTestArgs")
    public void bubbleSortTest(int[] expected, int[] input) {
        Task5.bubbleSort(input);
        assertArrayEquals(expected, input);
    }

    static Stream<Arguments> provideBubbleSortTestArgs() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}),
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{4, 3, 2, 1}),
                Arguments.of(new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 1}),
                Arguments.of(new int[]{-1, 0, 1}, new int[]{-1, 1, 0}),
                Arguments.of(new int[]{-1, 0, 1}, new int[]{1, 0, -1})
        );
    }

    @Test
    public void bubbleSortIllegalTest() {
        assertThrows(IllegalArgumentException.class, () -> Task5.bubbleSort(null));
        assertThrows(IllegalArgumentException.class, () -> Task5.bubbleSort(new int[]{}));
    }
}
