package com.github.felbinger.gdp.V02;

import com.github.felbinger.gdp.V01.Flower;
import edu.unibw.etti.SimpleGraphicPanel;

public final class Tree {

    private Tree() {
        throw new UnsupportedOperationException();
    }

    public static double sx(double ax, double ay, double by) {
        return ax + (ay - by);
    }

    public static double sy(double ax, double ay, double bx) {
        return ay + (bx - ax);
    }

    public static double tx(double ax, double ay, double bx, double by, double r) {
        return ax + (ay - by) + r * (bx - ax) + Math.sqrt(r * (1.0 - r)) * (ay - by);
    }

    public static double ty(double ax, double ay, double bx, double by, double r) {
        return ay + (bx - ax) + r * (by - ay) + Math.sqrt(r * (1.0 - r)) * (bx - ax);
    }

    public static double ux(double ay, double bx, double by) {
        return bx + (ay - by);
    }

    public static double uy(double ax, double bx, double by) {
        return by + (bx - ax);
    }

    /**
     * Draw a tree using the Flower.drawFlower() method from the last worksheet.
     * @return whether the tree has been drawn successfully
     */
    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings("NS_DANGEROUS_NON_SHORT_CIRCUIT")
    public static boolean drawTree(int depth, double ax, double ay, double bx, double by, double r) {
        if (depth < 0) {
            return false;
        }

        if (r < 0 || r > 1) {
            throw new IllegalArgumentException("r has to be between 0 and 1");
        }

        return Flower.drawFlower(
                SimpleGraphicPanel.getRandomColor(), ax, ay, bx, by)
                & drawTree(
                    depth - 1,
                    sx(ax, ay, by),
                    sy(ax, ay, bx),
                    tx(ax, ay, bx, by, r),
                    ty(ax, ay, bx, by, r), r)
                & drawTree(
                    depth - 1,
                    tx(ax, ay, bx, by, r),
                    ty(ax, ay, bx, by, r),
                    ux(ay, bx, by),
                    uy(ax, bx, by), r);
    }
}
