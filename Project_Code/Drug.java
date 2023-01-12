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

//------------------------------------------------Narcotic------------------------------------------------

class Narcotic extends Drug{

    private int strength;

    public Narcotic(String name, int price, double active_ingredient, int strength){
        super(name, price, active_ingredient);
        this.strength = strength;
    }

    public int getStrength(){
        return strength;
    }

    public String toString(){
        return ("DrugID: " + idd + "\n" +
                "Class: Narcotic" + "\n" +
                "name: " + name + "\n" +
                "price: " + price + "mkd." + "\n" +
                "active_ingredient: " + active_ingredient + "mg." + "\n" +
                "strength: " + strength);
    }

}

//------------------------------------------------Addictive------------------------------------------------

class Addictive extends Drug{

    private int strength;

    public Addictive(String name, int price, double active_ingredient, int strength){
        super(name, price, active_ingredient);
        this.strength = strength;
    }

    public int getStrength(){
        return strength;
    }

    public String toString(){
        return ("DrugID: " + idd + "\n" +
                "Class: Narcotic" + "\n" +
                "name: " + name + "\n" +
                "price: " + price + "mkd." + "\n" +
                "active_ingredient: " + active_ingredient + "mg." + "\n" +
                "strength: " + strength);
    }


}

//------------------------------------------------Regular------------------------------------------------

class Regular extends Drug{

    public Regular(String name, int price, double active_ingredient){
        super(name, price, active_ingredient);

    }


    public String toString(){
        return ("DrugID: " + idd + "\n" +
                "Class: Narcotic" + "\n" +
                "name: " + name + "\n" +
                "price: " + price + "mkd." + "\n" +
                "active_ingredient: " + active_ingredient + "mg." + "\n"
                );
    }


}
