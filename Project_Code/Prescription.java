public abstract class Prescription {

    protected Drug drug;
    protected Doctor doctor;
    public static int prescriptionID;
    protected int id_count;
    protected int reit;
    protected Patient patient;
  
    public Prescription(Drug drug, Doctor doctor, Patient patient, int reit){
      this.drug = drug;
      this.doctor = doctor;
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
  
    public Doctor getDoctor(){
      return doctor;
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
                return "White Prescription";
            }else if(this instanceof BluePrescriptions ){
                return "Blue Prescription";
            }else if(this instanceof MilitaryPrescriptions){
                return "Military Prescription";
            }else{
              return "P Resept";
            }
        }
    }
  
  //------------------------------------------------WhitePrescriptions------------------------------------------------
  
  
  class WhitePrescriptions extends Prescription{
  
    public WhitePrescriptions(Drug drug, Doctor doctor, Patient patient, int reit) {
        super(drug, doctor, patient, reit);
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
             "Doctor: " + doctor + "\n" +
             "Patient: " + patient + "\n" +
             "Re-it: " + reit);
    }
  }
  
  
  //------------------------------------------------START-KLASSE-MILITÆR-RESEPT------------------------------------------------
  
  
  class MilitaryPrescriptions extends WhitePrescriptions{
  
    protected static int reit = 3;
  
  
    public MilitaryPrescriptions(Drug drug, Doctor doctor, Patient patient) {
        super(drug, doctor, patient, reit);
    }
  
    protected int priceToPay(){
      return 0;
    }
  
    @Override
    public String toString(){
      return ("Prescription ID: " + prescriptionID + "\n" +
             "Color of prescription: " + color() + "\n"  +
             "Price(100% discount): " + priceToPay() + "\n" +
             "Doctor: " + doctor + "\n" +
             "Patient: " + patient + "\n" +
             "Re-it: " + reit);
    }
  }
  
  
  //------------------------------------------------START-KLASSE-P-RESEPT------------------------------------------------
  
  
  class pPrescription extends WhitePrescriptions{
  
    public pPrescription(Drug drug, Doctor doctor, Patient patient, int reit) {
        super(drug, doctor, patient, reit);
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
               "Doctor: " + doctor + "\n" +
               "Patient: " + patient + "\n" +
               "Re-it: " + reit);
      }
  }
  
  
  //------------------------------------------------BluePrescriptions------------------------------------------------
  
  
  class BluePrescriptions extends Prescription{
  
    public BluePrescriptions(Drug drug, Doctor doctor, Patient patient, int reit) {
        super(drug, doctor, patient, reit);
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
               "Doctor: " + doctor + "\n" +
               "Patient: " + patient + "\n" +
               "Re-it: " + reit);
      }
  }
  
  
  //------------------------------------------------END-OF-CODE------------------------------------------------
  