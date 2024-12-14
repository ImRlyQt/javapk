package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShapeRendererTest {
    @Test
    public void testRenderSquare() {
        Color color = new Color(0, 255, 0, 128);
        Rectangle square = new Rectangle(5, 5, color);

        String expectedOutput =
                "\033[38;2;0;255;0m*****\r\n" +
                        "*****\r\n" +
                        "*****\r\n" +
                        "*****\r\n" +
                        "*****\r\n" +
                        "\033[0m";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            ShapeRenderer.render(square);

            assertEquals(expectedOutput, outputStream.toString());
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void testRenderPyramid() {
        Color color = new Color(0, 0, 255, 255);
        Triangle pyramid = new Triangle(3, 4, 5, color);

        String expectedOutput =
                "\033[38;2;0;0;255m   *\r\n" +
                        "  ***\r\n" +
                        " *****\r\n" +
                        "*******\r\n" +
                        "\033[0m";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            ShapeRenderer.render(pyramid);

            assertEquals(expectedOutput, outputStream.toString());
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void testRenderingUnknownShape() {
        Shape unknownShape = new Shape(null) {

            @Override
            public double getArea() {
                return 0;
            }

            @Override
            public double getPerimeter() {
                return 0;
            }
        };

        assertThrows(UnsupportedOperationException.class, () -> {
            ShapeRenderer.render(unknownShape);
        });
    }
}
