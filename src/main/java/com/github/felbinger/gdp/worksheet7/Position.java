package com.github.felbinger.gdp.worksheet7;

@SuppressWarnings("checkstyle:HiddenField")
public class Position {
    private double x;
    private double y;
    public static final int X_MAX = 600;
    public static final int Y_MAX = 400;

    public Position(double x, double y) {
        setX(x);
        setY(y);
    }

    /**
     * Get the y value.
     * @return the y value of the 2d graphic
     */
    public double getY() {
        return y;
    }

    /**
     * Get the x value.
     * @return the x value of the 2d graphic
     */
    public double getX() {
        return x;
    }

    /**
     * Set the x value, make sure it's between 0 and the configured X_MAX.
     * @param x value for the 2D graphic
     */
    public final void setX(double x) {
        this.x = x < 0 ? x % X_MAX + X_MAX : x % X_MAX;
    }

    /**
     * Set the y value, make sure it's between 0 and the configured Y_MAX.
     * @param y value for the 2D graphic
     */
    public final void setY(double y) {
        this.y = y < 0 ? y % Y_MAX + Y_MAX : y % Y_MAX;
    }

    /**
     * Get the position in polar coordinate representation.
     * @return x and y value of the position in polar coordinate representation
     */
    @Override
    public String toString() {
        return String.format("(%.1f|%.1f)", x, y);
    }
}
