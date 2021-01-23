package com.github.felbinger.gdp;

import com.github.felbinger.gdp.V01.Flower;
import com.github.felbinger.gdp.V01.Task1;
import com.github.felbinger.gdp.V02.Task2;
import com.github.felbinger.gdp.V02.Tree;

import java.awt.Color;

public final class App {

    private App() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        System.out.print("Task 1.1: Math vs Strict Math:\t\t");
        Task1.main();
        System.out.println("Task 1.2: Rhombus / Flower");
        Flower.drawRhombus(Color.BLACK, 50, 10, 50, 100);
        Flower.drawFlower(Color.BLACK, 200, 40, 400, 100);

        System.out.println("Task 2.1: digitSum(1293404):\t\t" + Task2.digitSum(1293404));
        System.out.println("Task 2.2: countNumber(1, 1213414):\t" + Task2.countDigitInNumber(1, 1213414));
        System.out.println("Task 2.3: FlowerTree");
        Tree.drawTree(6, 1000, 60, 1300, 50, 0.6);
    }
}
