package com.github.felbinger.gdp.worksheet7;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends GeometricShape {

    private double height;
    private double width;

    public Rectangle(double x, double y, Color c, boolean f, double a, double b) {
        this(new Position(x, y), c, f, a, b);
    }

    public Rectangle(Position pos, Color c, boolean f, double a, double b) {
        super(pos, c, f);
        this.height = a;
        this.width = b;
    }

    /**
     * Get height of the rectangle.
     * @return height of the rectangle
     */
    public double getHeight() {
        return height;
    }

    /**
     * Set height of the rectangle.
     * @param h height of the rectangle
     */
    public void setHeight(double h) {
        this.height = h;
    }

    /**
     * Get width of the rectangle.
     * @return width of the rectangle
     */
    public double getWidth() {
        return width;
    }

    /**
     * Set width of the rectangle.
     * @param w width of the rectangle
     */
    public void setWidth(double w) {
        this.width = w;
    }

    /**
     * draw a rectangle on a graphic panel
     * @param g graphics panel on which the rectangle should be drawn
     */
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        DrawableRect drawable = this.isFill() ? g::fillRect : g::drawRect;
        drawable.draw(
                (int) this.getPosition().getX(),
                (int) this.getPosition().getY(),
                (int) this.width,
                (int) this.height
        );
    }

    /**
     * Get a string of all attributes of the geometric shape and the width and height of the rectangle.
     * @return string of all attributes
     */
    @Override
    public String toString() {
        return String.format("%s, width=%.1f, height=%.1f", super.toString(), width, height);
    }

    private interface DrawableRect {
        void draw(int x, int y, int width, int height);
    }
}
