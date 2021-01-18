package com.github.felbinger.gdp.V01;

import edu.unibw.etti.SimpleGraphicPanel;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalMatchers;
import org.mockito.MockedStatic;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FlowerTest {

    @Test
    public void testRhombus() {
        try (MockedStatic<SimpleGraphicPanel> mocked = mockStatic(SimpleGraphicPanel.class)) {
            mocked.when(() -> SimpleGraphicPanel.drawQuadrilateral(
                    any(Color.class), anyBoolean(), anyDouble(), anyDouble(), anyDouble(),
                    anyDouble(), anyDouble(), anyDouble(), anyDouble(), anyDouble()
            )).thenReturn(false);

            assertFalse(Flower.drawRhombus(Color.BLACK, 50, 10, 50, 100));

            mocked.verify(() -> SimpleGraphicPanel.drawQuadrilateral(
                    eq(Color.BLACK),
                    eq(true),
                    eq(50.0),
                    eq(10.0),
                    AdditionalMatchers.eq(75.9, 0.1),
                    eq(55.0),
                    eq(50.0),
                    eq(100.0),
                    AdditionalMatchers.eq(24.0, 0.1),
                    eq(55.0)
            ));
        }
    }

    @Test
    public void testFlower() {
        try (MockedStatic<SimpleGraphicPanel> mocked = mockStatic(SimpleGraphicPanel.class)) {
            mocked.when(() -> SimpleGraphicPanel.drawQuadrilateral(
                    any(Color.class), anyBoolean(), anyDouble(), anyDouble(), anyDouble(),
                    anyDouble(), anyDouble(), anyDouble(), anyDouble(), anyDouble()
            )).thenReturn(false);

            assertFalse(Flower.drawFlower(Color.BLACK, 100, 40, 300, 100));

            mocked.verify(() -> SimpleGraphicPanel.drawQuadrilateral(
                    eq(Color.BLACK),
                    eq(true),
                    eq(100.0),
                    eq(40.0),
                    AdditionalMatchers.eq(172.5, 0.1),
                    AdditionalMatchers.eq(84.7, 0.1),
                    eq(170.0),
                    eq(170.0),
                    AdditionalMatchers.eq(97.4, 0.1),
                    AdditionalMatchers.eq(125.2, 0.1)
                    ));
            mocked.verify(() -> SimpleGraphicPanel.drawQuadrilateral(
                    eq(Color.BLACK),
                    eq(true),
                    eq(300.0),
                    eq(100.0),
                    AdditionalMatchers.eq(255.2, 0.1),
                    AdditionalMatchers.eq(172.5, 0.1),
                    eq(170.0),
                    eq(170.0),
                    AdditionalMatchers.eq(214.7, 0.1),
                    AdditionalMatchers.eq(97.4, 0.1)
            ));
            mocked.verify(() -> SimpleGraphicPanel.drawQuadrilateral(
                    eq(Color.BLACK),
                    eq(true),
                    eq(240.0),
                    eq(300.0),
                    AdditionalMatchers.eq(167.4, 0.1),
                    AdditionalMatchers.eq(255.2, 0.1),
                    eq(170.0),
                    eq(170.0),
                    AdditionalMatchers.eq(242.5, 0.1),
                    AdditionalMatchers.eq(214.7, 0.1)
            ));
            mocked.verify(() -> SimpleGraphicPanel.drawQuadrilateral(
                    eq(Color.BLACK),
                    eq(true),
                    eq(40.0),
                    eq(240.0),
                    AdditionalMatchers.eq(84.7, 0.1),
                    AdditionalMatchers.eq(167.4, 0.1),
                    eq(170.0),
                    eq(170.0),
                    AdditionalMatchers.eq(125.2, 0.1),
                    AdditionalMatchers.eq(242.5, 0.1)
            ));
        }
    }
}
