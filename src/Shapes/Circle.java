package Shapes;

public class Circle extends Shape {
    protected double radius;
    public static final double PI = 3.14;

    public Circle(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double area() {
        return PI * radius * radius;
    }

    @Override
    public void printInfo() {
        System.out.println("Circle " + color + ", area = " + area());
    }
}
