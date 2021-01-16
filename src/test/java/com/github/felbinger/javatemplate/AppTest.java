package com.github.felbinger.javatemplate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class AppTest {

    private final transient ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final transient PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(out, false, StandardCharsets.UTF_8));
    }

    @Test
    public void testMain() {
        App.main();
        assertEquals(String.format("Hello World%s", System.lineSeparator()), out.toString(StandardCharsets.UTF_8));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
