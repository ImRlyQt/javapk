package org.example;

import jakarta.persistence.*;

@MappedSuperclass

public abstract class Shape {
    @Embedded
    private Color color;

    public Shape() {
        color = new Color(0, 0, 0);
    }

    public Shape(Color color) {
        this.color = color;
    }

    public String getColorDescription() {
        return "Red: %d, Green: %d, Blue: %d, Alpha: %d".formatted(color.red(), color.green(), color.blue(), color.alpha());
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}