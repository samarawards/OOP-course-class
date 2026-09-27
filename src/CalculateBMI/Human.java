package CalculateBMI;
public class Human {
    public String name;
    private int age;
    private double height;
    private double weight;
    private double BMI;
    private String status;

    public Human (String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setAge (int a){
        this.age = a;
    }

    public double getAge (){
        return this.age;
    }

    public void setHeight (double h){
        this.height = h/100;
    }

    public double getHeight (){
        return this.height;
    }

    public void setWeight (double w){
        this.weight = w;
    }

    public double getWeight (){
        return this.weight;
    }

    public String getResult (){
        resultStatus();
        return this.status;
    }

    private void countBMI (){
        BMI = weight/(height*height);
    }

    private void resultStatus(){
        countBMI();
        if (BMI < 18.5) {
            status = "Berat badan kurang";
        }else if (BMI >= 18.5 && BMI <= 22.9) {
            status = "Berat badan normal";
        }else if (BMI >= 23 && BMI <= 29.9) {
            status = "Kelebihan berat badan (overweight)";
        }else if (BMI >= 30) {
            status = "Obesitas ";
        }
    }


}
