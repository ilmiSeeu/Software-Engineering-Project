import java.util.*;

public class Patient {

    private String name;
    private String birthDate;
    private static int counter;
    private int patientID;
    private List<Prescriptions> prescriptions;


    public Patient(String name, String birthDate){
         this.name = name;
         this.birthDate = birthDate;
         patientID = counter++;
         prescriptions = new ArrayList<Prescriptions>();

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

    public List<Prescriptions> getPatientPrescriptions(){
         return prescriptions;
    }


    public void addPrescription(Prescriptions r){
        prescriptions.add(r);
    }


    public String toString(){
         return ("Name: " + name  + "\n" +
                "BirthDate: " + birthDate + "\n" +
                "ID: " + patientID);
    }

}
