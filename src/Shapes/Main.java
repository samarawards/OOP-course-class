package Shapes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("            PROGRAM PERHITUNGAN SHAPES            ");
        System.out.println("==================================================");

        // 1. Input untuk Square
        System.out.println("\n--- Input Square ---");
        System.out.print("Masukkan sisi (side): ");
        double squareSide = Double.parseDouble(scanner.nextLine().replace("\uFEFF", "").trim().replace(",", "."));
        System.out.print("Masukkan warna (color): ");
        String squareColor = scanner.nextLine().trim();
        Square square = new Square(squareSide, squareColor);

        // 2. Input untuk Circle
        System.out.println("\n--- Input Circle ---");
        System.out.print("Masukkan jari-jari (radius): ");
        double circleRadius = Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
        System.out.print("Masukkan warna (color): ");
        String circleColor = scanner.nextLine().trim();
        Circle circle = new Circle(circleRadius, circleColor);

        // 3. Input untuk Cylinder
        System.out.println("\n--- Input Cylinder ---");
        System.out.print("Masukkan tinggi (height): ");
        double cylinderHeight = Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
        System.out.print("Masukkan jari-jari (radius): ");
        double cylinderRadius = Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
        System.out.print("Masukkan warna (color): ");
        String cylinderColor = scanner.nextLine().trim();
        Cylinder cylinder = new Cylinder(cylinderHeight, cylinderRadius, cylinderColor);

        // 4. Menampilkan hasil printInfo()
        System.out.println("\n==================================================");
        System.out.println("                 HASIL PERHITUNGAN                ");
        System.out.println("==================================================");
        square.printInfo();
        circle.printInfo();
        cylinder.printInfo();

        scanner.close();
    }
}
