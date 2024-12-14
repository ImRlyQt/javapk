package org.example;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShapeService {
    private final RectangleRepository rectRepo;
    private final TriangleRepository triRepo;

    public ShapeService(RectangleRepository rectRepo, TriangleRepository triRepo) {
        this.rectRepo = rectRepo;
        this.triRepo = triRepo;
    }

    public List<Shape> retrieveAllShapes() {
        List<Shape> shapes = new ArrayList<>();
        shapes.addAll(retrieveAllRectangles());
        shapes.addAll(retrieveAllTriangles());
        return shapes;
    }

    public List<Rectangle> retrieveAllRectangles() {
        return rectRepo.findAll();
    }

    public List<Triangle> retrieveAllTriangles() {
        return triRepo.findAll();
    }

    public Rectangle findRectangle(Long id) {
        return rectRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Rectangle not found"));
    }

    public Triangle findTriangle(Long id) {
        return triRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Triangle not found"));
    }

    public Long saveRectangle(Rectangle rectangle) {
        return rectRepo.save(rectangle).getId();
    }

    public Long saveTriangle(Triangle triangle) {
        return triRepo.save(triangle).getId();
    }

    public boolean rectangleExists(Long id) {
        return rectRepo.existsById(id);
    }

    public boolean triangleExists(Long id) {
        return triRepo.existsById(id);
    }

    public void removeRectangle(Long id) {
        rectRepo.deleteById(id);
    }

    public void removeTriangle(Long id) {
        triRepo.deleteById(id);
    }
}