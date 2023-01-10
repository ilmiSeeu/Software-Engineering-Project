public abstract class Drug {

    protected String name;
    public static int drugID;
    protected int idd;
    protected int price;
    protected double active_ingredient;


    public Drug(String name, int price, double active_ingredient) {
        this.name = name;
        this.price = price;
        this.active_ingredient = active_ingredient;
        drugID++;
        idd += drugID;
    }

    public String getType(){
        if(this instanceof Addictive){
            return "Addictive";
        }else if(this instanceof Narcotic){
            return "Narcotic";
        }else{return "Regular";}
    }
    
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public double getActive_ingredient() {
        return active_ingredient;
    }
    public int getStrength(){
        return 0;
    }

    @Override
    public abstract String toString();
    
}