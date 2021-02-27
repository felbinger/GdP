package com.github.felbinger.gdp.worksheet7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.awt.Color;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {
    @ParameterizedTest(name = "{index}: toString (exp: {0}, inp: {2},{3})")
    @MethodSource("provideToStringTestArgs")
    public void toStringTest(String expected, Position pos, Color c, boolean f, double height, double width) {
        assertEquals(expected, new Rectangle(pos, c, f, width, height).toString());
    }

    static Stream<Arguments> provideToStringTestArgs() {
        return Stream.of(
                Arguments.of("Rectangle: (580.0|399.0), java.awt.Color[r=0,g=0,b=0] (filled), width=5.0, height=2.3",
                        new Position(-20, -1), Color.BLACK, true, 5, 2.3),
                Arguments.of("Rectangle: (0.0|0.0), java.awt.Color[r=255,g=0,b=0], width=15.0, height=20.0",
                        new Position(0, 0), Color.RED, false, 15, 20)
        );
    }
}
