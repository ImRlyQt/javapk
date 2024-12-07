

public class Main {
    public static void main(String[] args) {

        String javaVersion = System.getProperty("java.version");
        System.out.println("Java Version: " + javaVersion);

        Shape rectangle = new Rectangle(5, 10);
        Shape triangle = new Triangle(3, 4, 5);

        ShapeDescriber describer = new ShapeDescriber();

        System.out.println("Rectangle:");
        describer.describe(rectangle);

        System.out.println("Triangle:");
        describer.describe(triangle);

    }
}
