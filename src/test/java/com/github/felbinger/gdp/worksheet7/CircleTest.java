package com.github.felbinger.gdp.worksheet7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.awt.Color;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircleTest {
    @ParameterizedTest(name = "{index}: toString (exp: {0}, inp: {2},{3})")
    @MethodSource("provideToStringTestArgs")
    public void toStringTest(String expected, Position pos, Color c, boolean f, double radius) {
        assertEquals(expected, new Circle(pos, c, f, radius).toString());
    }

    static Stream<Arguments> provideToStringTestArgs() {
        return Stream.of(
                Arguments.of("Circle: (580.0|399.0), java.awt.Color[r=0,g=0,b=0] (filled), radius=5.0",
                        new Position(-20, -1), Color.BLACK, true, 5),
                Arguments.of("Circle: (0.0|0.0), java.awt.Color[r=255,g=0,b=0], radius=15.0",
                        new Position(0, 0), Color.RED, false, 15)
        );
    }
}
