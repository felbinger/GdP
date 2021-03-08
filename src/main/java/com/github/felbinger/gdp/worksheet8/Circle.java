package com.github.felbinger.gdp.worksheet8;

import com.github.felbinger.gdp.worksheet7.Position;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Circle {
    private final Position pos;
    private double radius;
    private Color color;

    public Circle(double x, double y, double r, Color c) {
        this.pos = new Position(x, y);
        this.radius = r;
        this.color = c;
    }

    /**
     * draw the circle on a graphic panel.
     * @param graphics graphic panel on which the circle should be drawn
     */
    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillOval((int) pos.getX(), (int) pos.getY(), (int) radius, (int) radius);
    }

    public abstract void move();

    /**
     * get current position.
     * @return the current position
     */
    protected Position getPosition() {
        return pos;
    }

    /**
     * get the current radius of the circle.
     * @return current radius of the circle
     */
    protected double getRadius() {
        return radius;
    }

    /**
     * set a new radius.
     * @param r radius which should be set
     */
    public void setRadius(double r) {
        this.radius = r;
    }

    /**
     * setter for color
     * @param c color
     */
    public void setColor(Color c) {
        this.color = c;
    }

    public static boolean collide(Circle k1, Circle k2) {
        return Math.hypot(
                k1.pos.getX() + k2.pos.getX(),
                k1.pos.getY() + k2.pos.getY()
        ) < k1.radius + k2.radius;
    }

    public static void mixColor(Circle k1, Circle k2) {
        Color c1 = k1.color;
        Color c2 = k2.color;
        float[] f1 = c1.getComponents(null);
        float[] f2 = c2.getComponents(null);
        float[] fm = new float[f1.length];
        for (int c = 0; c < fm.length; c++) {
            fm[c] = (f1[c] * 0.5f) + (f2[c] * 0.5f);
        }
        Color c = new Color(fm[0], fm[1], fm[2], fm[3]);
        k1.setColor(c);
        k2.setColor(c);
    }
}
