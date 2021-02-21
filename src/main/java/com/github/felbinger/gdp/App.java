package com.github.felbinger.gdp;

import com.github.felbinger.gdp.worksheet1.Flower;
import com.github.felbinger.gdp.worksheet1.Task1;
import com.github.felbinger.gdp.worksheet2.Task2;
import com.github.felbinger.gdp.worksheet2.Tree;
import com.github.felbinger.gdp.worksheet3.Task3;
import com.github.felbinger.gdp.worksheet3.Triangle;
import com.github.felbinger.gdp.worksheet4.Characters;
import com.github.felbinger.gdp.worksheet4.Matrix;
import com.github.felbinger.gdp.worksheet4.Task4;
import com.github.felbinger.gdp.worksheet5.Quicksort;
import com.github.felbinger.gdp.worksheet5.Task5;

import java.awt.Color;
import java.util.Arrays;

public final class App {

    private App() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        System.out.print("Task 1.1: Math vs Strict Math:\t\t\t");
        Task1.main();
        System.out.println("Task 1.2: Rhombus / Flower");
        Flower.drawRhombus(Color.BLACK, 50, 150, 50, 250);
        Flower.drawFlower(Color.BLACK, 200, 190, 400, 250);

        System.out.println("Task 2.1: digitSum(1293404):\t\t\t" + Task2.digitSum(1293404));
        System.out.println("Task 2.2: countNumber(1, 1213414):\t\t" + Task2.countDigitInNumber(1, 1213414));
        System.out.println("Task 2.3: FlowerTree");
        Tree.drawTree(6, 1000, 210, 1300, 200, 0.6);

        System.out.println("Task 3.1: fac(12):\t\t\t\t\t\t" + Task3.fac(12));
        System.out.println("Task 3.1: fac(13):\t\t\t\t\t\t" + Task3.fac(13));
        System.out.println("Task 3.2: gcd(12, 15):\t\t\t\t\t" + Task3.gcd(12, 15));
        System.out.println("Task 3.3: Triangle");
        Triangle.draw(Color.BLACK, 10, 10, 150, 150);
        Triangle.draw(Color.BLACK, 170.0, 10.0, 150.0, 75.0);
        Triangle.draw(Color.BLACK, 330.0, 10.0, 150.0, 37.5);
        Triangle.draw(Color.BLACK, 490.0, 10.0, 150.0, 18.75);
        Triangle.draw(Color.BLACK, 650.0, 10.0, 150.0, 9.375);
        Triangle.draw(Color.BLACK, 810.0, 10.0, 150.0, 4.6875);

        System.out.println("Task 4.1: Debugging");
        Characters.main();
        System.out.println("Task 4.2b: max(6,5,4,3,2,1,0):\t\t\t"
                + Task4.getMax(new double[]{6, 5, 4, 3, 2, 1, 0}));
        System.out.println("Task 4.2c: evenAvg(6,5,4,3,2,1,0):\t\t"
                + Task4.getEvenAvg(new int[]{6, 5, 4, 3, 2, 1, 0}));
        System.out.println("Task 4.2d: reverse(J,a,v,a):\t\t\t"
                + Arrays.toString(Task4.reverse(new char[]{'J', 'a', 'v', 'a'})));
        System.out.println("Task 4.2e: isSorted(1,2,5,4):\t\t\t"
                + Task4.isSorted(new long[]{'1', '2', '3', '4'}));
        System.out.println("Task 4.2e: isSorted(1,2,5,4):\t\t\t"
                + Task4.isSorted(new long[]{'1', '2', '5', '4'}));

        System.out.println("Task 4.3a: isMatrix({{1,2,3},{2,3,4}}):\t"
                + Matrix.isMatrix(new double[][] {{1, 2, 3}, {2, 3, 4}}, 2, 3));
        System.out.println("Task 4.3a: isMatrix({{1,2,3},{2},{}}):\t"
                + Matrix.isMatrix(new double[][] {{1, 2, 3}, {2}, {0, 0, 0}}, 3, 3));
        System.out.println("Task 4.3b: printMatrix:");
        Matrix.printMatrix(new double[][] {{1, 2, 3}, {2, 3, 4}});

        System.out.println("Task 4.3c: ");
        Matrix.printMatrix(Matrix.mul(new double[][] {{1, 2}, {3, 4}}, new double[][] {{1, 2}, {3, 4}}));

        System.out.println("Task 5.1 + 5.2:");
        Task5.main();
        System.out.println("Task 5.3:");
        Quicksort.main();

        System.out.println("Task 6: checkout tests");
    }
}
