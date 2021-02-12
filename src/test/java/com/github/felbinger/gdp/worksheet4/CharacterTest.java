package com.github.felbinger.gdp.worksheet4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTest {

    private final transient ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final transient PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(out, false, StandardCharsets.UTF_8));
    }


    @Test
    public void characterTest() {
        Characters.main();
        assertEquals(
                String.format("Input: [K, a, s, s, e]%sOutput: [T, a, s, s, e]%1$s", System.lineSeparator()),
                out.toString(StandardCharsets.UTF_8)
        );
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
