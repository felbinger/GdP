package com.github.felbinger.gdp.worksheet8;

import com.github.felbinger.gdp.worksheet7.Position;

import java.awt.Color;

public class Balloon extends Circle {
    private double factor;

    public Balloon(double x, double y, Color c, double f) {
        super(x, y, 10, c);
        this.factor = f;
    }

    /**
     *
     */
    public void move() {
        double curRadius = super.getRadius();
        if (curRadius <= 1) {
            this.factor = -factor;
        }
        if (getPosition().getX() + curRadius > Position.X_MAX
                || getPosition().getX() + curRadius < 0
                || getPosition().getY() + curRadius > Position.Y_MAX
                || getPosition().getY() + curRadius < 0) {
            this.factor = -factor;
        }
        super.setRadius(curRadius + factor);
    }
}
