package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ShapeDAO {
    private final SessionFactory sessionFactory;

    public ShapeDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveShape(Shape shape) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(shape);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Rectangle> getAllRectangles() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Rectangle", Rectangle.class).list();
        }
    }

    public List<Triangle> getAllTriangles() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Triangle", Triangle.class).list();
        }
    }
}