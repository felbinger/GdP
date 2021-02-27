package com.github.felbinger.gdp.worksheet7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.awt.Color;
import java.awt.Graphics;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeometricShapeTest {
    @ParameterizedTest(name = "{index}: create Shape (exp==inp: position={0}, color={1}, fill={2})")
    @MethodSource("provideCreateTestArgs")
    public void createTest(Position pos, Color color, boolean fill) {
        GeometricShape shape = new GeometricShape(pos, color, fill) {
            @Override
            public void draw(Graphics g) {
            }
        };
        assertEquals(pos.toString(), shape.getPosition().toString());
        assertEquals(color, shape.getColor());
        assertEquals(fill, shape.isFill());
    }

    static Stream<Arguments> provideCreateTestArgs() {
        return Stream.of(
                Arguments.of(new Position(1, 2), Color.BLACK, true),
                Arguments.of(new Position(2, 3), Color.WHITE, false)
        );
    }

    @ParameterizedTest(name = "{index}: toString (exp: {0}, inp: {2},{3})")
    @MethodSource("provideToStringTestArgs")
    public void toStringTest(String expected, Position pos, Color c, boolean f) {
        assertEquals(expected, new GeometricShape(pos, c, f) {
            @Override
            public void draw(Graphics g) {

            }
        }.toString());
    }

    static Stream<Arguments> provideToStringTestArgs() {
        return Stream.of(
                Arguments.of(": (580.0|399.0), java.awt.Color[r=0,g=0,b=0] (filled)",
                        new Position(-20, -1), Color.BLACK, true),
                Arguments.of(": (0.0|0.0), java.awt.Color[r=255,g=0,b=0]",
                        new Position(0, 0), Color.RED, false)
        );
    }
}
