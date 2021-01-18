package com.github.felbinger.gdp.V01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {

    private final transient ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final transient PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(out, false, StandardCharsets.UTF_8));
    }


    @Test
    public void testMain() {
        Task1.main();
        String[] content = out.toString(StandardCharsets.UTF_8).split("=", 2);
        assertEquals(content.length, 2);
        assertEquals("125.0", content[1].strip());
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
