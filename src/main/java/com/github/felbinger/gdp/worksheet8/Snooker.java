package com.github.felbinger.gdp.worksheet8;

import com.github.felbinger.gdp.worksheet7.Position;

import java.awt.Color;

public class Snooker extends Circle {
    private double a;
    private double b;

    @SuppressWarnings("checkstyle:HiddenField")
    public Snooker(double x, double y, double r, Color c, double a, double b) {
        super(x, y, r, c);
        this.a = a;
        this.b = b;
    }

    /**
     * move the position in the configured direction
     */
    public void move() {
        double curX = super.getPosition().getX();
        if (curX == Position.X_MAX || curX == 0) {
            this.a = -a;
        }
        double curY = super.getPosition().getY();
        if (curY + (this.a > 0 ? this.a : -this.a) > Position.Y_MAX || curY == 0) {
            this.b = -b;
        }
        super.getPosition().setX(curX + this.a);
        super.getPosition().setY(curY + this.b);
    }
}
