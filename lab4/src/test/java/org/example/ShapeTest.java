package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeTest {
    @Test
    public void testSquarePerimeter() {
        Color color = new Color(0, 255, 0, 255);
        Rectangle square = new Rectangle(6, 6, color);
        float expected = 24f;

        assertEquals(expected, square.getPerimeter(), 0.01f);
    }

    @Test
    public void testSquareArea() {
        Color color = new Color(0, 255, 0, 255);
        Rectangle square = new Rectangle(6, 6, color);
        float expected = 36f;

        assertEquals(expected, square.getArea(), 0.01f);
    }

    @Test
    public void testPyramidPerimeter() {
        Color color = new Color(0, 0, 255, 255);
        Triangle pyramid = new Triangle(5, 7, 8, color);
        float expected = 20f;

        assertEquals(expected, pyramid.getPerimeter(), 0.01f);
    }

    @Test
    public void testPyramidArea() {
        Color color = new Color(0, 0, 255, 255);
        Triangle pyramid = new Triangle(5, 7, 8, color);
        float expected = 17.32f;

        assertEquals(expected, pyramid.getArea(), 0.01f);
    }

    @Test
    public void testColorDescription() {
        Rectangle rect = new Rectangle(2, 4, new Color(0, 255, 255));
        String expected = "Red: 0, Green: 255, Blue: 255, Alpha: 0";

        assertEquals(expected, rect.getColorDescription());
    }
}
