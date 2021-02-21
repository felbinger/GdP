package com.github.felbinger.gdp.worksheet6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SeqByDLLOperationTest {
    @ParameterizedTest(name = "{index}: getString (exp: {0}, inp: {1},{2})")
    @MethodSource("provideGetStringTestArgs")
    public void getStringTest(String expected, SeqByDLL input, boolean inverted) {
        assertEquals(expected, SeqByDLLOperation.getString(input, inverted));
    }

    static Stream<Arguments> provideGetStringTestArgs() {
        DLLInt a = new DLLInt(null, 1, null);
        DLLInt b = new DLLInt(a, 2, null);
        a.next = b;
        DLLInt c = new DLLInt(b, 3, null);
        b.next = c;
        return Stream.of(
                Arguments.of("1", new SeqByDLL(
                        new DLLInt(null, 1, null),
                        new DLLInt(null, 1, null)
                ), false),
                Arguments.of("1:2:3", new SeqByDLL(a, c), false),
                Arguments.of("3:2:1", new SeqByDLL(a, c), true)
        );
    }

    @Test
    public void getStringIllegalTest() {
        assertThrows(IllegalArgumentException.class, () -> SeqByDLLOperation.getString(null, false));
    }

    @ParameterizedTest(name = "{index}: insert (exp: {0}, inp: {2},{1})")
    @MethodSource("provideInsertTestArgs")
    public void insertTest(String expected, int value, SeqByDLL input) {
        assertEquals(expected, SeqByDLLOperation.getString(SeqByDLLOperation.insert(value, input), false));
    }

    static Stream<Arguments> provideInsertTestArgs() {
        DLLInt bHead = new DLLInt(null, 2, null);
        DLLInt cHead = new DLLInt(bHead, 3, null);
        bHead.next = cHead;

        DLLInt aTail = new DLLInt(null, 1, null);
        DLLInt bTail = new DLLInt(aTail, 2, null);
        aTail.next = bTail;

        DLLInt aMid = new DLLInt(null, 1, null);
        DLLInt bMid = new DLLInt(aMid, 2, null);
        aMid.next = bMid;
        DLLInt cMid = new DLLInt(bMid, 3, null);
        bMid.next = cMid;
        return Stream.of(
                Arguments.of("1:2:3", 1, new SeqByDLL(bHead, cHead)),
                Arguments.of("1:2:4", 4, new SeqByDLL(aTail, bTail)),
                Arguments.of("1:2:2:3", 2, new SeqByDLL(aMid, cMid))
        );
    }

    @Test
    public void insertIllegalTest() {
        assertThrows(IllegalArgumentException.class, () -> SLLIntOperation.insert(0, null));
    }
}
