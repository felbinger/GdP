package com.github.felbinger.gdp.worksheet7;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends GeometricShape {
    private double radius;

    public Circle(double x, double y, Color c, boolean f, double r) {
        this(new Position(x, y), c, f, r);
    }

    public Circle(Position pos, Color c, boolean f, double r) {
        super(pos, c, f);
        this.radius = r;
    }

    /**
     * Get radius of the circle.
     * @return radius of the circle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Set radius of the circle.
     * @param r radius of the circle
     */
    public void setRadius(double r) {
        this.radius = r;
    }

    /**
     * draw a circle on a graphic panel
     * @param g graphics panel on which the circle should be drawn
     */
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        DrawableOval drawable = this.isFill() ? g::fillOval : g::drawOval;
        drawable.draw(
                (int) this.getPosition().getX(),
                (int) this.getPosition().getY(),
                (int) this.radius,
                (int) this.radius
        );
    }

    /**
     * Get a string of all attributes of the geometric shape and the radius of the circle.
     * @return string of all attributes
     */
    @Override
    public String toString() {
        return String.format("%s, radius=%.1f", super.toString(), radius);
    }

    private interface DrawableOval {
        void draw(int x, int y, int width, int height);
    }
}
