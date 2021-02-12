package com.github.felbinger.gdp.worksheet3;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import edu.unibw.etti.SimpleGraphicPanel;

import java.awt.Color;

public final class Triangle {

    private Triangle() {
        throw new UnsupportedOperationException();
    }

    public static double bx(double ax, double s) {
        return ax + s;
    }

    public static double cx(double ax, double bx) {
        return (ax + bx) / 2.0;
    }

    public static double cy(double ax, double ay, double bx) {
        return ay + Math.sqrt(3.0) * (bx - ax) / 2.0;
    }

    public static double px(double ax, double cx) {
        return (ax + cx) / 2.0;
    }

    public static double py(double ay, double cy) {
        return (ay + cy) / 2.0;
    }

    public static double rx(double ax, double bx) {
        return (ax + bx) / 2.0;
    }

    public static double ry(double ay, double by) {
        return (ay + by) / 2.0;
    }

    /**
     * Draw triangles.
     * @return whether the tree has been drawn successfully
     */
    @SuppressFBWarnings("NS_DANGEROUS_NON_SHORT_CIRCUIT")
    public static boolean draw(Color c, double ax, double ay, double s, double t) {
        if (s <= t) {
            return SimpleGraphicPanel.drawTriangle(
                    c, true,
                    ax, ay,
                    bx(ax, s), ay,
                    cx(ax, bx(ax, s)), cy(ax, ay, bx(ax, s))
            );
        } else {
            return draw(c, ax, ay, s / 2.0, t)
                & draw(c, rx(ax, bx(ax, s)), ry(ay, ay), s / 2.0, t)
                & draw(c, px(ax, cx(ax, bx(ax, s))), py(ay, cy(ax, ay, bx(ax, s))), s / 2.0, t);
        }
    }
}
