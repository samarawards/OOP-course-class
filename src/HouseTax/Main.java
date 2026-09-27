package HouseTax;

public class Main {
    public static void main(String[] args) {
        Father akbar = new Father("Akbar", 36, 100000);
        Father bambang = new Father("Bambang", 45, 150000);
        Father charlie = new Father("Charlie", 90, 200000);
        
        System.out.println("The amount of PBB Tax of pak " + akbar.name + " = " + akbar.myHouse.calculatePBB());
        System.out.println("The amount of PBB Tax of pak " + bambang.name + " = " + bambang.myHouse.calculatePBB());
        System.out.println("The amount of PBB Tax of pak " + charlie.name + " = " + charlie.myHouse.calculatePBB());
    }
}
