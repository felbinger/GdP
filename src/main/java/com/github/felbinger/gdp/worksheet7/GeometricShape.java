package com.github.felbinger.gdp.worksheet7;

import java.awt.Color;
import java.awt.Graphics;

public abstract class GeometricShape {
    private Position position;
    private Color color;
    private boolean fill;

    public GeometricShape(Position pos, Color c, boolean f) {
        this.position = pos;
        this.color = c;
        this.fill = f;
    }

    /**
     * Get the position of your geometric shape.
     * @return pos position of the geometric shape
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Set the position of your geometric shape.
     * @param pos set the position of your geometric shape
     */
    public void setPosition(Position pos) {
        this.position = pos;
    }

    /**
     * Get the color of your geometric shape.
     * @return c color of the geometric shape
     */
    public Color getColor() {
        return color;
    }

    /**
     * Set a color for your geometric shape.
     * @param c color
     */
    public void setColor(Color c) {
        this.color = c;
    }

    /**
     * whether the geometric shape is filled or not
     * @return whether the geometric shape is filled or not
     */
    public boolean isFill() {
        return fill;
    }

    /**
     * set whether the geometric shape is filled or not
     * @param f whether the geometric shape is filled or not
     */
    public void setFill(boolean f) {
        this.fill = f;
    }

    public abstract void draw(Graphics g);

    /**
     * Get a string of the position in polar coordinate representation,
     * color and whether the shape should be filled with the color.
     * @return a string of all attributes.
     */
    @Override
    public String toString() {
        return String.format(
                "%s: %s, %s", this.getClass().getSimpleName(), position, color
        ) + (fill ? " (filled)" : "");
    }
}
