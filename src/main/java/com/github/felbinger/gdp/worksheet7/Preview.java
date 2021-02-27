package com.github.felbinger.gdp.worksheet7;

import com.github.felbinger.gdp.worksheet7.utils.GraphicsPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.List;

public final class Preview {
    private Preview() {
        throw new UnsupportedOperationException();
    }

    public static void main(String... args) {
        GraphicsPanel panel = new GraphicsPanel(
                "github.com/felbinger/gdp: worksheet7", Position.X_MAX, Position.Y_MAX
        );

        Graphics g = panel.createGraphics();

        while (true) {
            Rectangle background = new Rectangle(0, 0, new Color(107, 112, 236), true, Position.Y_MAX, Position.X_MAX);
            background.draw(g);

            double treeShiftX = 250;
            Color treeColor = new Color(35, 102, 35);
            List<GeometricShape> tree = Arrays.asList(
                    new Rectangle(treeShiftX + 40, 280, new Color(101, 81, 48, 255), true, 60, 20),
                    new Triangle(treeShiftX + 50, 100, treeColor, true, 100, 50),
                    new Triangle(treeShiftX + 50, 130, treeColor, true, 130, 60),
                    new Triangle(treeShiftX + 50, 170, treeColor, true, 150, 60),
                    new Triangle(treeShiftX + 50, 210, treeColor, true, 180, 80)
            );

            for (GeometricShape shape : tree) {
                shape.draw(g);
//                System.out.println(shape);
            }

            double snowmanShiftX = 400;
            List<GeometricShape> snowman = Arrays.asList(
                    new Circle(snowmanShiftX + 50, 250, Color.WHITE, true, 100),
                    new Circle(snowmanShiftX + 62.5, 200, Color.WHITE, true, 75),
                    new Circle(snowmanShiftX + 75, 155, Color.WHITE, true, 50),
                    new Rectangle(snowmanShiftX + 70, 150, Color.BLACK, true, 10, 60),
                    new Rectangle(snowmanShiftX + 85, 130, Color.BLACK, true, 20, 30)
            );

            for (GeometricShape shape : snowman) {
                shape.draw(g);
//                System.out.println(shape);
            }

            double houseShiftX = 50;
            List<GeometricShape> house = Arrays.asList(
                    new Triangle(houseShiftX + 50, 180, Color.RED, true, 100, 60),
                    new Rectangle(houseShiftX, 240, Color.YELLOW, true, 100, 100),
                    new Rectangle(houseShiftX + 10, 310, Color.BLUE, true, 30, 15),
                    new Rectangle(houseShiftX + 60, 315, Color.BLUE, true, 15, 30),
                    new Rectangle(houseShiftX + 60, 275, Color.BLUE, true, 15, 30),
                    new Rectangle(houseShiftX + 10, 275, Color.BLUE, true, 15, 30)
            );

            for (GeometricShape shape : house) {
                shape.draw(g);
//                System.out.println(shape);
            }

            new Snow(2, g);
            panel.updateGraphics();
            GraphicsPanel.sleep(1000);
        }
    }
}
