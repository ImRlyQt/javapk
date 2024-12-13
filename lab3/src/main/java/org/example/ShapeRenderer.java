package org.example;

public class ShapeRenderer {
    public static void render(Shape... shapes) {
        for (Shape shape : shapes) {
            if (shape instanceof Rectangle) {
                renderRectangle((Rectangle) shape);
            } else if (shape instanceof Triangle) {
                renderTriangle((Triangle) shape);
            } else {
                throw new UnsupportedOperationException("Rendering of this shape is not implemented.");
            }
        }
    }

    private static void renderRectangle(Rectangle rect) {
        setTextColor(rect.getColor());
        int width = (int) rect.getWidth();
        int height = (int) rect.getHeight();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        resetTextColor();
    }

    private static void renderTriangle(Triangle triangle) {
        setTextColor(triangle.getColor());
        int height = getTriangleHeight(triangle);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        resetTextColor();
    }

    private static void setTextColor(Color color) {
        System.out.printf("\033[38;2;%d;%d;%dm", color.red(), color.green(), color.blue());
    }

    private static void resetTextColor() {
        System.out.print("\033[0m");
    }

    private static int getTriangleHeight(Triangle triangle) {
        double a = triangle.getSideA();
        double b = triangle.getSideB();
        double c = triangle.getSideC();
        double semiPerimeter = (a + b + c) / 2.0;

        double area = Math.sqrt(semiPerimeter
                * (semiPerimeter - a)
                * (semiPerimeter - b)
                * (semiPerimeter - c));

        return (int) ((2 * area) / a);
    }
}