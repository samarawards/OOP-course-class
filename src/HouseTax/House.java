package HouseTax;

public class House {
    private int type;
    private double price, PBB;

    public House (int tp, double prc){
        if (tp != 36 && tp != 45 && tp < 45) {
            System.out.println("Your House Type is not valid!");
            return;
        }

        this.type = tp;
        this.price = prc;
        setPBB(tp);
    }

    public void setType(int tp){
        this.type = tp;
        setPBB(tp);
    }

    public int getType(){
        return this.type;
    }

    public void setPrice(int prc){
        this.price = prc;
    }
    
    public double getPrice(){
        return this.price;
    }

    public double getPBB (){
        return PBB;
    }

    private void setPBB (int tp){
        if (tp == 36) {
            PBB = 0.04;
        }else if (tp == 45) {
            PBB = 0.06;
        }else if (tp > 45) {
            PBB = 0.09;
        }else{
            PBB = 0;
        }
    }

    public double calculatePBB(){
        setPBB(this.type);
        return price * PBB;
    }


}

