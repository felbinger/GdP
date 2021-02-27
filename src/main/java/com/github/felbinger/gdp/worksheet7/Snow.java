package com.github.felbinger.gdp.worksheet7;

import java.awt.Color;
import java.awt.Graphics;

public class Snow {
    private transient double radius;
    private transient Graphics graphics;

    public Snow(double r, Graphics g) {
        this(5000, r, g);
    }

    public Snow(int amount, double r, Graphics g) {
        this.radius = r;
        this.graphics = g;
        for (int i = 0; i < amount; i++) {
            Circle c = new Circle(
                    (int) (Math.random() * (Position.X_MAX + 1)),
                    (int) (Math.random() * (Position.Y_MAX + 1)),
                    Color.WHITE, true, r);
//            System.out.println(c.toString());
            c.draw(g);
        }
    }
}
