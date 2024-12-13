package org.example;

public class Main {
    public static void main(String[] args) {

        String javaVersion = System.getProperty("java.version");
        System.out.println("Java Version: " + javaVersion);

        Color green = new Color(0, 255, 0);

        Shape rectangle = new Rectangle(5, 4, green);
        Shape triangle = new Triangle(3, 4, 5, new Color(255,0,0));

        ShapeDescriber describer = new ShapeDescriber();

        describer.describe(rectangle);

        describer.describe(triangle);

        ShapeRenderer.render(rectangle);
        ShapeRenderer.render(triangle);


    }
}