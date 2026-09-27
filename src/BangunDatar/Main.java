package BangunDatar;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BangunDatar square = new BangunDatar(24);

        BangunDatar rectangle_1 = new BangunDatar();
        rectangle_1.setLength(100);
        rectangle_1.setWidth(25);

        BangunDatar rectangle_2 = new BangunDatar(12.1, 7);

        // Square
        square.calculateSquareArea();
        square.calculateSquarePerimeter();
        System.out.println("Area of Square with side " + square.getSide() + " = " + square.getArea());
        System.out.println("Perimeter of Square with side " + square.getSide() + " = " + square.getPerimeter());

        // Rectangle_1
        rectangle_1.calculateRectangleArea();
        rectangle_1.calculateRectanglPerimeter();
        System.out.println("Area of Rectangle_1 with length " + rectangle_1.getLength() + " and width " + rectangle_1.getWidth() + " = " + rectangle_1.getArea());
        System.out.println("Perimeter of Rectangle_1 with length " + rectangle_1.getLength() + " and width " + rectangle_1.getWidth() + " = " + rectangle_1.getPerimeter());

        // Rectangle_2
        rectangle_2.calculateRectangleArea();
        rectangle_2.calculateRectanglPerimeter();
        System.out.println("Area of Rectangle_2 with length " + rectangle_2.getLength() + " and width " + rectangle_2.getWidth() + " = " + rectangle_2.getArea());
        System.out.println("Perimeter of Rectangle_2 with length " + rectangle_2.getLength() + " and width " + rectangle_2.getWidth() + " = " + rectangle_2.getPerimeter());

        ArrayList<String> arr = new ArrayList<>();
        arr.add(4, "Samara");
        for (String string : arr) {
            System.out.println(string);
            System.out.println();
        }

    }
}
