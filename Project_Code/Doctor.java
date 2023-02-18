import java.util.*;

public class Doctor implements Comparable<Doctor> {

    public String name;
    protected List<Prescription> writtenPrescriptions;

    public Doctor(String name){
        this.name = name;
        writtenPrescriptions = new ArrayList<Prescription>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Prescription> getWrittenPrescriptions() {
        return writtenPrescriptions;
    }

    public void addPrescription(Prescription r) {
        writtenPrescriptions.add(r);
    }


    @Override
        public int compareTo(Doctor anotherDoctor){
        return this.name.compareTo(anotherDoctor.getName());
    }

    public WhitePrescriptions writeWhitePrescriptions(Drug drug, Patient patient, int reit)
        throws illegalPrescription {
        if( !(this instanceof Specialist) && drug instanceof Narcotic){
            throw new illegalPrescription(this, drug);
        } else {

            WhitePrescriptions newWhite = new WhitePrescriptions(drug, this, patient, reit);
                writtenPrescriptions.add(newWhite);
                return newWhite;
        }
    }
    public MilitaryPrescriptions writeMilitaryPrescriptions(Drug drug, Patient patient)
        throws illegalPrescription {
        if( !(this instanceof Specialist) && drug instanceof Narcotic){
            throw new illegalPrescription(this, drug);
        } else {
            //
            MilitaryPrescriptions newMil = new MilitaryPrescriptions(drug, this, patient);
            writtenPrescriptions.add(newMil);
                return newMil;
        }
    }

    public pPrescription writepPrescription(Drug drug, Patient patient, int reit)
        throws illegalPrescription {
        if( !(this instanceof Specialist) && drug instanceof Narcotic){
            throw new illegalPrescription(this, drug);
        } else {
            //
            pPrescription newP = new pPrescription(drug, this, patient, reit);
            writtenPrescriptions.add(newP);
                return newP;
        }
    }

        public BluePrescriptions writepBluePrescriptions(Drug drug, Patient patient, int reit)
        throws illegalPrescription {
        if( !(this instanceof Specialist) && drug instanceof Narcotic){
            throw new illegalPrescription(this, drug);
        } else {
            //
            BluePrescriptions newBlue = new BluePrescriptions(drug, this, patient, reit);
                writtenPrescriptions.add(newBlue);
                return newBlue;
        }
    }


}


//------------------------------------------------Specialist------------------------------------------------


class Specialist extends Doctor{

    protected String controlID;

    public Specialist(String name, String controlID){
        super(name);
        this.controlID = controlID;
        writtenPrescriptions = new ArrayList<Prescription>();

    }

    public String getName(){
        return name;
    }

    public String getID(){
        return controlID;
    }

    public String toString(){
        return (name + "\n" +
                "ID: " + controlID);
    }
}
