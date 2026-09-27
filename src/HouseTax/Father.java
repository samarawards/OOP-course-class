package HouseTax;

public class Father {
    public String name;
    public House myHouse;

    public Father (String nm, int tp, double prc){
        this.name = nm;
        myHouse = new House(tp, prc);
    }

    public Father (String nm, House house){
        this.name = nm;
        this.myHouse = house;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public House getMyHouse() {
        return myHouse;
    }

    public void setMyHouse(House myHouse) {
        this.myHouse = myHouse;
    }

}
