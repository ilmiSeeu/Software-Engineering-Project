public abstract class Prescriptions {
  
  protected Drug drug;
  public static int prescriptionID;
  protected int id_count;
  protected int reit;
  protected Patient patient;
    
  public Prescriptions(Drug drug, Patient patient, int reit){
    this.drug = drug;
    this.patient = patient;
    this.reit = reit;
    prescriptionID++;
    id_count += id_count;
  }

  protected abstract String color();
  protected abstract int priceToPay();
  public abstract String toString();

  public int getId(){
    return id_count;
  }

  public Drug getDrug(){
    return drug;
  }

  public Patient getPatient(){
    return patient;
  }

  public int getReit(){
    return reit;
  }

  public boolean use(){
    if (getReit() > 0){
      reit--;
      return true;
    } else {
      return false;
    }
  }


  public String getType(){
          if(this instanceof WhitePrescriptions){
              return "White Prescriptions";
          }else if(this instanceof BluePrescriptions ){
              return "Blue Prescriptions";
          }else if(this instanceof MilitaryPrescriptions){
              return "Military Prescriptions";
          }else{
            return "P Resept";
          }
      }
  }

//------------------------------------------------WhitePrescriptions------------------------------------------------


class WhitePrescriptions extends Prescriptions{
   
  public WhitePrescriptions(Drug drug, Patient patient, int reit) {
      super(drug, patient, reit);
  }

  protected String color(){
    return "The prescription is white";
  }

  protected int priceToPay(){
    int price = getDrug().getPrice();
    return price;
  }

  @Override 
  public String toString(){
    return ("Prescription ID: " + prescriptionID + "\n" +
           "Color of prescription: " + color() + "\n"  +
           "Price: " + priceToPay() + "\n" +
           "Patient: " + patient + "\n" +
           "Re-it: " + reit);
  }
}


//------------------------------------------------START-KLASSE-MILITÆR-RESEPT------------------------------------------------


class MilitaryPrescriptions extends WhitePrescriptions{

  protected static int reit = 3;


  public MilitaryPrescriptions(Drug drug, Patient patient) {
      super(drug, patient, reit);
  }

  protected int priceToPay(){
    return 0;
  }

  @Override 
  public String toString(){
    return ("Prescription ID: " + prescriptionID + "\n" +
           "Color of prescription: " + color() + "\n"  +
           "Price(100% discount): " + priceToPay() + "\n" +
           "Patient: " + patient + "\n" +
           "Re-it: " + reit);
  }
}


//------------------------------------------------START-KLASSE-P-RESEPT------------------------------------------------


class pPrescription extends WhitePrescriptions{

  public pPrescription(Drug drug, Patient patient, int reit) {
      super(drug, patient, reit);
  }

 
  //if price more that 108 get 108 discount
  protected int priceToPay(){
    int sum = (getDrug().getPrice());
    if (sum - 108 > 0){
      return sum-108;
    } else {
      return 0;
    }
  }

  @Override 
  public String toString(){
      return ("Prescription ID: " + prescriptionID + "\n" +
             "Color of prescription: " + color() + "\n"  +
             "Price((-108mkd): " + priceToPay() + "\n" +
             "Patient: " + patient + "\n" +
             "Re-it: " + reit);
    }
}


//------------------------------------------------BluePrescriptions------------------------------------------------


class BluePrescriptions extends Prescriptions{

  public BluePrescriptions(Drug drug, Patient patient, int reit) {
      super(drug,  patient, reit);
  }

  protected String color(){
      return "The prescription is blue";
    }
  
    protected int priceToPay(){
      int price = getDrug().getPrice();
      return ((price/100)*25);
    }
  
    @Override 
    public String toString(){
      return ("Prescription ID: " + prescriptionID + "\n" +
             "Color of prescription: " + color() + "\n"  +
             "Price(75% discount): " + priceToPay() + "\n" +
             "Patient: " + patient + "\n" +
             "Re-it: " + reit);
    }
}


//------------------------------------------------END-OF-CODE------------------------------------------------
