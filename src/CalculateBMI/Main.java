package CalculateBMI;
public class Main {
    public static void main(String[] args) throws Exception {
        Human orang1 = new Human("Mark Lee", 26);

        orang1.setHeight(159);
        orang1.setWeight(60);
        System.out.println( orang1.getResult());

        
    }
}
