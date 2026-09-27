package BangunDatar;

public class BangunDatar {
    private double side, length, width, area, perimeter;

    public BangunDatar (){
        side = 0;
        length = 0;
        width = 0;
    }

    public BangunDatar (double s){
        side = s;
    }

    public BangunDatar (double l, double w){
        length = l;
        width = w;
    }

    public void setSide (double s){
        side = s;
    }

    public double getSide (){
        return side;
    }

    public void setLength (double l){
        length = l;
    }

    public double getLength (){
        return length;
    }

    public void setWidth (double w){
        width = w;
    }

    public double getWidth (){
        return width;
    }

    public double getArea (){
        return area;
    }

    public double getPerimeter (){
        return perimeter;
    }

    public void calculateSquareArea (){
        area = side*side;
        
    }

    public void calculateRectangleArea (){
        area = length*width;
        
    }

    public void calculateSquarePerimeter (){
        perimeter = 4*side;
    }

    public void calculateRectanglPerimeter (){
        perimeter = 2*(length+width);
    }

}
