package com.github.felbinger.gdp.worksheet6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SLLIntOperationTest {

    @ParameterizedTest(name = "{index}: getLength (exp: {0}, inp: {1})")
    @MethodSource("provideGetLengthTestArgs")
    public void getLengthTest(int expected, SLLInt input) {
        assertEquals(expected, SLLIntOperation.getLength(input));
    }

    static Stream<Arguments> provideGetStringTestArgs() {
        return Stream.of(
                Arguments.of("1:2:3", new SLLInt(1, new SLLInt(2, new SLLInt(3)))),
                Arguments.of("1", new SLLInt(1))
        );
    }

    @ParameterizedTest(name = "{index}: getString (exp: {0}, inp: {1})")
    @MethodSource("provideGetStringTestArgs")
    public void getStringTest(String expected, SLLInt input) {
        assertEquals(expected, SLLIntOperation.getString(input));
    }

    static Stream<Arguments> provideGetLengthTestArgs() {
        return Stream.of(
                Arguments.of(3, new SLLInt(1, new SLLInt(2, new SLLInt(3)))),
                Arguments.of(0, null)
        );
    }

    @Test
    public void getStringIllegalTest() {
        assertThrows(IllegalArgumentException.class, () -> SLLIntOperation.getString(null));
    }

    @ParameterizedTest(name = "{index}: isSorted (exp: {0}, inp: {1})")
    @MethodSource("provideIsSortedTestArgs")
    public void isSortedTest(boolean expected, SLLInt input) {
        assertEquals(expected, SLLIntOperation.isSorted(input));
    }

    static Stream<Arguments> provideIsSortedTestArgs() {
        return Stream.of(
                Arguments.of(true, new SLLInt(1, new SLLInt(2, new SLLInt(3)))),
                Arguments.of(false, new SLLInt(3, new SLLInt(2, new SLLInt(1))))
        );
    }

    @Test
    public void isSortedIllegalTest() {
        assertThrows(IllegalArgumentException.class, () -> SLLIntOperation.isSorted(null));
    }

    @ParameterizedTest(name = "{index}: insert (exp: {0}, inp: {1})")
    @MethodSource("provideInsertTestArgs")
    public void insertTest(String expected, int value, SLLInt input) {
        assertEquals(expected, SLLIntOperation.getString(SLLIntOperation.insert(value, input)));
    }

    static Stream<Arguments> provideInsertTestArgs() {
        return Stream.of(
                Arguments.of("1:2:3:4", 3, new SLLInt(1, new SLLInt(2, new SLLInt(4)))),
                Arguments.of("1:2:3:4", 4, new SLLInt(1, new SLLInt(2, new SLLInt(3)))),
                Arguments.of("0:1:2:3", 0, new SLLInt(1, new SLLInt(2, new SLLInt(3)))),
                Arguments.of("1:2:2:3", 2, new SLLInt(1, new SLLInt(2, new SLLInt(3))))
        );
    }

    @Test
    public void insertIllegalTest() {
        assertThrows(IllegalArgumentException.class, () -> SLLIntOperation.insert(0, null));
        assertThrows(IllegalArgumentException.class, () -> SLLIntOperation.insert(0,
                new SLLInt(3, new SLLInt(2, new SLLInt(1))))
        );
    }

    @ParameterizedTest(name = "{index}: isEqual (exp: {0}, inp: {1})")
    @MethodSource("provideIsEqualTestArgs")
    public void isEqualTest(boolean expected, SLLInt seq1, SLLInt seq2) {
        assertEquals(expected, SLLIntOperation.isEqualRekursiv(seq1, seq2));
        assertEquals(expected, SLLIntOperation.isEqualIterativ(seq1, seq2));
    }

    static Stream<Arguments> provideIsEqualTestArgs() {
        return Stream.of(
                Arguments.of(
                        true,
                        new SLLInt(1, new SLLInt(2, new SLLInt(4))),
                        new SLLInt(1, new SLLInt(2, new SLLInt(4)))
                ),
                Arguments.of(
                        true,
                        new SLLInt(1, new SLLInt(2, new SLLInt(4))),
                        new SLLInt(1, new SLLInt(2, new SLLInt(4)))
                ),
                Arguments.of(
                        false,
                        new SLLInt(1, new SLLInt(2)),
                        new SLLInt(1, new SLLInt(2, new SLLInt(4)))
                )
        );
    }

    @Test
    public void isEqualIllegalTest() {
        assertThrows(IllegalArgumentException.class, () -> SLLIntOperation.isEqualIterativ(null, null));
        assertThrows(IllegalArgumentException.class, () -> SLLIntOperation.isEqualIterativ(null, new SLLInt(1)));
        assertThrows(IllegalArgumentException.class, () -> SLLIntOperation.isEqualIterativ(new SLLInt(1), null));
        assertThrows(IllegalArgumentException.class, () -> SLLIntOperation.isEqualRekursiv(null, null));
        assertThrows(IllegalArgumentException.class, () -> SLLIntOperation.isEqualRekursiv(null, new SLLInt(1)));
        assertThrows(IllegalArgumentException.class, () -> SLLIntOperation.isEqualRekursiv(new SLLInt(1), null));
    }

    @ParameterizedTest(name = "{index}: concat (exp: {0}, inp: {1})")
    @MethodSource("provideConcatTestArgs")
    public void concatTest(String expected, SLLInt seq1, SLLInt seq2) {
        assertEquals(expected, SLLIntOperation.getString(SLLIntOperation.concat(seq1, seq2)));
    }

    static Stream<Arguments> provideConcatTestArgs() {
        return Stream.of(
                Arguments.of(
                        "1:2:4:3:4:5",
                        new SLLInt(1, new SLLInt(2, new SLLInt(4))),
                        new SLLInt(3, new SLLInt(4, new SLLInt(5)))
                ),
                Arguments.of(
                        "1:2:4",
                        new SLLInt(1, new SLLInt(2, new SLLInt(4))),
                        null
                )
        );
    }

    @Test
    public void concatIllegalTest() {
        assertThrows(IllegalArgumentException.class, () -> SLLIntOperation.concat(null, new SLLInt(1)));
        assertThrows(IllegalArgumentException.class, () -> SLLIntOperation.concat(null, null));
    }

}
