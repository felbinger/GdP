package com.github.felbinger.gdp.worksheet3;

import edu.unibw.etti.SimpleGraphicPanel;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalMatchers;
import org.mockito.MockedStatic;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

public class TriangleTest {

    @Test
    public void testFlowerTree() {
        try (MockedStatic<SimpleGraphicPanel> mocked = mockStatic(SimpleGraphicPanel.class, CALLS_REAL_METHODS)) {
            mocked.when(() -> SimpleGraphicPanel.drawTriangle(
                    any(Color.class), anyBoolean(), anyDouble(), anyDouble(), anyDouble(),
                    anyDouble(), anyDouble(), anyDouble()
            )).thenReturn(false);

            assertFalse(Triangle.draw(Color.BLACK, 170.0, 10.0, 150.0, 75.0));

            mocked.verify(() -> SimpleGraphicPanel.drawTriangle(
                    any(Color.class),
                    eq(true),
                    eq(170.0),
                    eq(10.0),
                    eq(245.0),
                    eq(10.0),
                    AdditionalMatchers.eq(207.5, 0.1),
                    AdditionalMatchers.eq(74.9, 0.1)
            ));

            mocked.verify(() -> SimpleGraphicPanel.drawTriangle(
                    any(Color.class),
                    eq(true),
                    eq(245.0),
                    eq(10.0),
                    eq(320.0),
                    eq(10.0),
                    AdditionalMatchers.eq(282.5, 0.1),
                    AdditionalMatchers.eq(74.9, 0.1)
            ));

            mocked.verify(() -> SimpleGraphicPanel.drawTriangle(
                    any(Color.class),
                    eq(true),
                    AdditionalMatchers.eq(207.5, 0.1),
                    AdditionalMatchers.eq(74.9, 0.1),
                    AdditionalMatchers.eq(282.5, 0.1),
                    AdditionalMatchers.eq(74.9, 0.1),
                    AdditionalMatchers.eq(245.0, 0.1),
                    AdditionalMatchers.eq(139.9, 0.1)
            ));
        }
    }
}
