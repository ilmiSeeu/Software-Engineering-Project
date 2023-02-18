import java.util.*;

public class Patient {

    private String name;
    private String birthDate;
    private static int counter;
    private int patientID;
    private List<Prescription> Prescription;


    public Patient(String name, String birthDate){
         this.name = name;
         this.birthDate = birthDate;
         patientID = counter++;
         Prescription = new ArrayList<Prescription>();

    }

    public String getName(){
         return name;
    }

    public String getBirthDATE(){
         return birthDate;
    }

    public int getPatientID(){
         return patientID;
    }

    public List<Prescription> getPatientPrescriptions(){
         return Prescription;
    }


    public void addPrescription(Prescription r){
        Prescription.add(r);
    }


    public String toString(){
         return ("Name: " + name  + "\n" +
                "BirthDate: " + birthDate + "\n" +
                "ID: " + patientID);
    }

}
