package com.github.felbinger.gdp.V04;

import com.github.felbinger.gdp.V01.Task1;
import com.github.felbinger.gdp.V03.Task3;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixTest {
    private final transient ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final transient PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(out, false, StandardCharsets.UTF_8));
    }

    @ParameterizedTest(name = "{index}: isMatrixTest (exp: {0}, a: {1}, b: {2})")
    @MethodSource("provideIsMatrixTestArgs")
    public void isMatrixTest(boolean expected, double[][] input, int a, int b) {
        assertEquals(expected, Matrix.isMatrix(input, a, b));
    }

    static Stream<Arguments> provideIsMatrixTestArgs() {
        return Stream.of(
                Arguments.of(true, new double[][]{{1, 2}, {3, 4}}, 2, 2),
                Arguments.of(true, new double[][]{{1, 2, 3}, {4, 5, 6}}, 2, 3),
                Arguments.of(false, new double[][]{{1, 2, 3, 4}, {5, 6, 7}, {8, 9, 10}}, 2, 2),
                Arguments.of(false, new double[][]{{1, 2, 3}, {5, 6, 7}, {8, 9, 10}}, 2, 2),
                Arguments.of(true, new double[][]{{1, 2, 3}, {5, 6, 7}, {8, 9, 10}}, 3, 3)
        );
    }

    @Test
    public void printMatrixTest() {
        double[][] matrix = new double[][]{{1, 2}, {3, 4}};
        Matrix.printMatrix(matrix);
        String content = out.toString(StandardCharsets.UTF_8);
        System.out.println(content);
        assertEquals(String.format("[1.0, 2.0]%s[3.0, 4.0]%1$s", System.lineSeparator()), content);
    }

    @ParameterizedTest(name = "{index}: mulMatrixTest (exp: {0}, a: {1}, b: {2})")
    @MethodSource("provideMulMatrixTestArgs")
    public void mulMatrixTest(double[][] expected, double[][] a, double[][] b) {
        assertArrayEquals(expected, Matrix.mul(a, b));
    }

    static Stream<Arguments> provideMulMatrixTestArgs() {
        return Stream.of(
            Arguments.of(
                    new double[][]{{7, 10}, {15, 22}},
                    new double[][]{{1, 2}, {3, 4}},
                    new double[][]{{1, 2}, {3, 4}}
            )
        );
    }

    @Test
    public void mulMatrixIllegalTest() {
        assertThrows(IllegalArgumentException.class, () -> Matrix.mul(
                new double[][]{},
                new double[][]{})
        );
        assertThrows(IllegalArgumentException.class, () -> Matrix.mul(
                new double[][]{{1,2},{3,4,5}},
                new double[][]{{1,2}, {1,2}})
        );
        assertThrows(IllegalArgumentException.class, () -> Matrix.mul(
                new double[][]{{1,2},{3,4}},
                new double[][]{{1}, {1}, {1}})
        );
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
