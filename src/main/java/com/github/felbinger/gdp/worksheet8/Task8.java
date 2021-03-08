package com.github.felbinger.gdp.worksheet8;

import com.github.felbinger.gdp.worksheet7.Position;
import com.github.felbinger.gdp.worksheet7.utils.GraphicsPanel;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.awt.Color;
import java.awt.Graphics;

public final class Task8 {

    private Task8() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        GraphicsPanel panel = new GraphicsPanel(
                "github.com/felbinger/gdp: worksheet8", Position.X_MAX, Position.Y_MAX);
        Graphics graphics = panel.createGraphics();

//        Circle k = new Circle(175.5, 210.5, 75.5, Color.red);
//        k.draw(graphics);
//        panel.updateGraphics();

//        Snooker k2 = new Snooker(175.5, 210.5, 25.0, Color.orange, 0.5, -0.3);
//        while (true) {
//            graphics.setColor(Color.white);
//            graphics.fillRect(0, 0, Position.X_MAX, Position.Y_MAX);
//            k2.draw(graphics);
//            panel.updateGraphics();
//            k2.move();
//        }

//        Balloon k3 = new Balloon(150.0, 210.5, Color.cyan, 0.5);
//        while (true) {
//            graphics.setColor(Color.white);
//            graphics.fillRect(0, 0, Position.X_MAX, Position.Y_MAX);
//            k3.draw(graphics);
//            panel.updateGraphics();
//            k3.move();
//        }

        providedCode(graphics, panel);
    }

    @SuppressWarnings("checkstyle:MissingSwitchDefault")
    @SuppressFBWarnings("SF_SWITCH_NO_DEFAULT")
    public static void providedCode(Graphics graphics, GraphicsPanel panel) {
        int v = 3;
        int count = 5 * v;
        Circle[] circles = new Circle[count];
        for (int i = 0; i < circles.length; i++) {
            double x = Math.random() * Position.X_MAX;
            double y = Math.random() * Position.Y_MAX;
            switch (i % v) {
                case 0:
                    circles[i] = new Snooker(x, y, 25.0, Color.red, 1.0, 1.0);
                    break;
                case 1:
                    circles[i] = new Balloon(x, y, Color.blue, 1.0);
                    break;
                case 2:
                    circles[i] = new Dominant(x, y, GraphicsPanel.getRandomColor());
                    break;
            }
        }
        while (true) {
            graphics.setColor(Color.white);
            graphics.fillRect(0, 0, Position.X_MAX, Position.Y_MAX);
            for (Circle k : circles) {
                k.draw(graphics);
            }
            panel.updateGraphics();
            for (Circle k : circles) {
                k.move();
            }
            for (int i = 0; i < circles.length; i++) {
                for (int j = i + 1; j < circles.length; j++) {
                    if (Circle.collide(circles[i], circles[j])) {
                        Circle.mixColor(circles[i], circles[j]);
                    }
                }
            }
            GraphicsPanel.sleep(2);
        }
    }

}
