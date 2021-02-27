package com.github.felbinger.gdp.worksheet7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {
    @ParameterizedTest(name = "{index}: create Position (exp: x={0}, y={1}, inp: x={2}, y={3})")
    @MethodSource("provideCreateTestArgs")
    public void createTest(double expectedX, double expectedY, double x, double y) {
        Position pos = new Position(x, y);
        assertEquals(expectedX, pos.getX());
        assertEquals(expectedY, pos.getY());
    }

    static Stream<Arguments> provideCreateTestArgs() {
        return Stream.of(
                Arguments.of(580, 399, -20, -1),
                Arguments.of(0, 0, 0, 0),
                Arguments.of(20, 60, 20, 60),
                Arguments.of(50, 100, 650, 100),
                Arguments.of(0, 0, 600, 400)
        );
    }

    @ParameterizedTest(name = "{index}: toString (exp: {0}, inp: {2},{3})")
    @MethodSource("provideToStringTestArgs")
    public void toStringTest(String expected, double x, double y) {
        assertEquals(expected, new Position(x, y).toString());
    }

    static Stream<Arguments> provideToStringTestArgs() {
        return Stream.of(
                Arguments.of("(580.0|399.0)", -20, -1),
                Arguments.of("(0.0|0.0)", 0, 0),
                Arguments.of("(20.0|60.0)", 20, 60),
                Arguments.of("(50.0|100.0)", 650, 100),
                Arguments.of("(0.0|0.0)", 600, 400)
        );
    }
}
