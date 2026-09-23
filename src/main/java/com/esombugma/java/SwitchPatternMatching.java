package com.esombugma.java;

import com.esombugma.java.util.Message;

public class SwitchPatternMatching {

    static void main() {
        Shape rectangle = new Rectangle(5.0, 10.0);
        Shape square = new Square(7.0);
        Shape circle = new Circle(3.0);

        before(rectangle);
        before(square);
        before(circle);

        afterExpression(rectangle);
        afterExpression(square);
        afterExpression(circle);

        afterStatement(rectangle);
        afterStatement(square);
        afterStatement(circle);
    }

    private static void before(Shape shape) {
        if (shape instanceof Rectangle r) {
            Message.displayMessage(String.format("[BEFORE] Area: %.2f", r.computeArea()));
        } else if (shape instanceof Square s) {
            Message.displayMessage(String.format("[BEFORE] Area: %.2f", s.computeArea()));
        } else if (shape instanceof Circle c) {
            Message.displayMessage(String.format("[BEFORE] Area: %.2f", c.computeArea()));
        } else {
            throw new IllegalArgumentException(String.format("Unknown shape: %s", shape));
        }
    }

    private static void afterExpression(Shape shape) {
        double area = switch (shape) {
            case Rectangle r -> r.computeArea();
            case Square s -> s.computeArea();
            case Circle c -> c.computeArea();
            default -> throw new IllegalArgumentException(String.format("Unknown shape: %s", shape));
        };
        Message.displayMessage(String.format("[AFTER] Area: %.2f", area));

    }

    private static double afterStatement(Shape shape) {
        switch (shape) {
            case Rectangle r: return r.computeArea();
            case Square s: return s.computeArea();
            case Circle c: return c.computeArea();
            default: throw new IllegalArgumentException(String.format("Unknown shape: %s", shape));
        }
    }

    interface Shape {
        double computeArea();
    }

    static class Rectangle implements Shape {
        private final double width;
        private final double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public double computeArea() {
            return width * height;
        }
    }

    static class Square implements Shape {
        private final double side;

        public Square(double side) {
            this.side = side;
        }

        @Override
        public double computeArea() {
            return side * side;
        }
    }

    static class Circle implements Shape {
        private final double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double computeArea() {
            return Math.PI * radius * radius;
        }
    }
}
