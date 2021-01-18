package com.github.felbinger.gdp;

import com.github.felbinger.gdp.V01.Flower;
import com.github.felbinger.gdp.V01.Task1;

import java.awt.Color;

public final class App {

    private App() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        System.out.print("Task 1.1: Math vs Strict Math:\t");
        Task1.main();
        System.out.println("Task 1.2: Rhombus / Flower");
        Flower.drawRhombus(Color.BLACK, 50, 10, 50, 100);
        Flower.drawFlower(Color.BLACK, 200, 40, 400, 100);
    }
}
