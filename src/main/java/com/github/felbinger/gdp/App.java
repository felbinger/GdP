package com.github.felbinger.gdp;

import com.github.felbinger.gdp.V01.Flower;
import com.github.felbinger.gdp.V01.Task1;
import com.github.felbinger.gdp.V02.Task2;
import com.github.felbinger.gdp.V02.Tree;
import com.github.felbinger.gdp.V03.Task3;
import com.github.felbinger.gdp.V03.Triangle;

import java.awt.Color;

public final class App {

    private App() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        System.out.print("Task 1.1: Math vs Strict Math:\t\t");
        Task1.main();
        System.out.println("Task 1.2: Rhombus / Flower");
        Flower.drawRhombus(Color.BLACK, 50, 150, 50, 250);
        Flower.drawFlower(Color.BLACK, 200, 190, 400, 250);

        System.out.println("Task 2.1: digitSum(1293404):\t\t" + Task2.digitSum(1293404));
        System.out.println("Task 2.2: countNumber(1, 1213414):\t" + Task2.countDigitInNumber(1, 1213414));
        System.out.println("Task 2.3: FlowerTree");
        Tree.drawTree(6, 1000, 210, 1300, 200, 0.6);

        System.out.println("Task 3.1: fac(12):\t\t\t\t\t" + Task3.fac(12));
        System.out.println("Task 3.1: fac(13):\t\t\t\t\t" + Task3.fac(13));
        System.out.println("Task 3.2: gcd(12, 15):\t\t\t\t" + Task3.gcd(12, 15));
        System.out.println("Task 3.3: Triangle");
        Triangle.draw(Color.BLACK, 10, 10, 150, 150);
        Triangle.draw(Color.BLACK, 170.0, 10.0, 150.0, 75.0);
        Triangle.draw(Color.BLACK, 330.0, 10.0, 150.0, 37.5);
        Triangle.draw(Color.BLACK, 490.0, 10.0, 150.0, 18.75);
        Triangle.draw(Color.BLACK, 650.0, 10.0, 150.0, 9.375);
        Triangle.draw(Color.BLACK, 810.0, 10.0, 150.0, 4.6875);

    }
}
