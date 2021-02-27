package com.github.felbinger.gdp.worksheet7;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends GeometricShape {

    private double base;
    private double height;

    @SuppressWarnings("checkstyle:HiddenField")
    public Triangle(double x, double y, Color c, boolean f, double base, double length) {
        this(new Position(x, y), c, f, base, length);
    }

    @SuppressWarnings("checkstyle:HiddenField")
    public Triangle(Position pos, Color c, boolean f, double base, double length) {
        super(pos, c, f);
        this.base = base;
        this.height = length;
    }

    /**
     * Get base of the triangle.
     * @return base of the triangle
     */
    public double getBase() {
        return base;
    }

    /**
     * Set base of the triangle.
     * @param b base of the triangle
     */
    public void setBase(double b) {
        this.base = b;
    }

    /**
     * Get height of the triangle.
     * @return height of the triangle
     */
    public double getHeight() {
        return height;
    }

    /**
     * Set height of the triangle.
     * @param l height of the triangle
     */
    public void setHeight(double l) {
        this.height = l;
    }

    /**
     * draw a triangle on a graphic panel
     * @param g graphics panel on which the triangle should be drawn
     */
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        int y2 = (int) (getPosition().getY() + height);
        double halfBase = base / 2;
        DrawablePolygon drawable = this.isFill() ? g::fillPolygon : g::drawPolygon;
        drawable.draw(
                new int[] {
                        (int) (getPosition().getX() - halfBase),
                        (int) (getPosition().getX()),
                        (int) (getPosition().getX() + halfBase)
                },
                new int[] {
                        y2, (int) getPosition().getY(), y2
                },
                3
        );
    }

    /**
     * Get a string of all attributes of the geometric shape and the width and height of the rectangle.
     * @return string of all attributes
     */
    @Override
    public String toString() {
        return String.format("%s, length=%.1f, base=%.1f", super.toString(), height, base);
    }

    private interface DrawablePolygon {
        void draw(int[] xPoints, int[] yPoints, int nPoints);
    }
}
