package org.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api")
public class ShapeController {
    private final ShapeService shapeService;

    public ShapeController(ShapeService shapeService) {
        this.shapeService = shapeService;
    }

    @GetMapping("/shapes")
    public List<Shape> fetchAll() {
        return shapeService.retrieveAllShapes();
    }

    @GetMapping("/rectangles/{id}")
    public Rectangle fetchRectangleById(@PathVariable Long id) {
        return shapeService.findRectangle(id);
    }

    @GetMapping("/triangles/{id}")
    public Triangle fetchTriangleById(@PathVariable Long id) {
        return shapeService.findTriangle(id);
    }

    @PostMapping("/rectangles")
    public Long createRectangle(@RequestBody Rectangle rectangle) {
        return shapeService.saveRectangle(rectangle);
    }

    @PostMapping("/triangles")
    public Long createTriangle(@RequestBody Triangle triangle) {
        return shapeService.saveTriangle(triangle);
    }

    @DeleteMapping("/rectangles/{id}")
    public void deleteRectangle(@PathVariable Long id) {
        if (!shapeService.rectangleExists(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Rectangle with id " + id + " not found"
            );
        }
        shapeService.removeRectangle(id);
    }

    @DeleteMapping("/triangles/{id}")
    public void deleteTriangle(@PathVariable Long id) {
        if (!shapeService.triangleExists(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Triangle with id " + id + " not found"
            );
        }
        shapeService.removeTriangle(id);
    }
}