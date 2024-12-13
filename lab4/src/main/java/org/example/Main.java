package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        ShapeDAO shapeDAO = new ShapeDAO(sessionFactory);


        Color green = new Color(0, 255, 0);

        Shape rectangle = new Rectangle(5, 4, green);
        Shape triangle = new Triangle(3, 4, 5, new Color(255,0,0));

        shapeDAO.saveShape(rectangle);
        shapeDAO.saveShape(triangle);

        List<Rectangle> rectangles = shapeDAO.getAllRectangles();
        List<Triangle> triangles = shapeDAO.getAllTriangles();

        ShapeDescriber describer = new ShapeDescriber();

        describer.describe(rectangles.getFirst());
        describer.describe(triangles.getFirst());
        

    }
}