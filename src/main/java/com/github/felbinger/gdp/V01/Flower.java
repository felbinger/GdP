package com.github.felbinger.gdp.V01;

import edu.unibw.etti.SimpleGraphicPanel;

import java.awt.Color;

public final class Flower {

    private Flower() {
        throw new UnsupportedOperationException();
    }

    public static double cx(double ay, double bx, double by) {
        return bx + ay - by;
    }

    public static double cy(double ax, double bx, double by) {
        return by + bx - ax;
    }

    public static double dx(double ax, double ay, double by) {
        return ax + ay - by;
    }

    public static double dy(double ax, double ay, double bx) {
        return ay + bx - ax;
    }

    public static double mx(double ax, double ay, double bx, double by) {
        return ax + (bx - ax) / 2.0 + (ay - by) / 2.0;
    }

    public static double my(double ax, double ay, double bx, double by) {
        return ay + (by - ay) / 2.0 + (bx - ax) / 2.0;
    }

    public static double t(double ex, double ey, double fx, double fy) {
        return Math.hypot(fy - ey, fx - ex);
    }

    public static double s(double ex, double ey, double fx, double fy) {
        return t(ex, ey, fx, fy) / Math.sqrt(3.0);
    }

    public static double gx(double ex, double ey, double fx, double fy) {
        return ex + (fx - ex) / 2 + s(ex, ey, fx, fy) / (2 * t(ex, ey, fx, fy)) * (fy - ey);
    }

    public static double gy(double ex, double ey, double fx, double fy) {
        return ey + (fy - ey) / 2 + s(ex, ey, fx, fy) / (2 * t(ex, ey, fx, fy)) * (ex - fx);
    }

    public static double hx(double ex, double ey, double fx, double fy) {
        return ex + (fx - ex) / 2 - s(ex, ey, fx, fy) / (2 * t(ex, ey, fx, fy)) * (fy - ey);
    }

    public static double hy(double ex, double ey, double fx, double fy) {
        return ey + (fy - ey) / 2 - s(ex, ey, fx, fy) / (2 * t(ex, ey, fx, fy)) * (ex - fx);
    }

    /**
     * Use the simple graphic panel library to draw a rhombus.
     * @param c  color of the rhombus
     * @param ex x coordinate for the lower corner
     * @param ey y coordinate for the lower corner
     * @param fx x coordinate for the diagonal corner
     * @param fy y coordinate for the diagonal corner
     * @return whether the rhombus has been successfully drawn or not
     */
    public static boolean drawRhombus(Color c, double ex, double ey, double fx, double fy) {
        return SimpleGraphicPanel.drawQuadrilateral(c, true,
                ex,
                ey,
                gx(ex, ey, fx, fy),
                gy(ex, ey, fx, fy),
                fx,
                fy,
                hx(ex, ey, fx, fy),
                hy(ex, ey, fx, fy)
        );
    }

    /**
     * Use the simple graphic panel library to draw four rhombus that look like a flower.
     * @return whether the flower has been successfully drawn or not
     */
    public static boolean drawFlower(Color c, double ax, double ay, double bx, double by) {
        return drawRhombus(c, ax, ay, mx(ax, ay, bx, by), my(ax, ay, bx, by))
                | drawRhombus(c, bx, by, mx(ax, ay, bx, by), my(ax, ay, bx, by))
                | drawRhombus(c, cx(ay, bx, by), cy(ax, bx, by), mx(ax, ay, bx, by), my(ax, ay, bx, by))
                | drawRhombus(c, dx(ax, ay, by), dy(ax, ay, bx), mx(ax, ay, bx, by), my(ax, ay, bx, by));
    }
}
