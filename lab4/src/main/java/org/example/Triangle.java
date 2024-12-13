package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "triangle")
public class Triangle extends Shape {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private double sideA;
    @Column
    private double sideB;
    @Column
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC, Color color) {
        super(color);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public Triangle() { }

    @Override
    public double getArea() {
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }
    public double getSideA() {
        return sideA;
    }
    public double getSideB() {
        return sideB;
    }
    public double getSideC() {
        return sideC;
    }
}