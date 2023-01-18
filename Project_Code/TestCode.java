public class TestCode{


    public static void main(String[] args) {


       // Test for Patient class
       Patient patient1 = new Patient("John Doe", "01.01.2000");
       System.out.println("Patient 1: " + patient1.toString());
       assert (patient1.getName().equals("John Doe"));
       assert (patient1.getBirthDATE().equals("01.01.2000"));

       // Test for Doctor class
       Doctor doctor1 = new Doctor("Dr. Smith");
       System.out.println("Doctor 1: " + doctor1.toString());
       assert (doctor1.getName().equals("Dr. Smith"));

       // Test for Drug class
       Drug drug1 = new Regular("Aspirin", 50, 10);
       System.out.println("Drug 1: " + drug1.toString());
       assert (drug1.getName().equals("Aspirin"));
       assert (drug1.getPrice() == 50);
       assert (drug1.getActive_ingredient() == 10);

       // Test for Prescription class
       WhitePrescriptions prescription1 = new WhitePrescriptions(drug1, doctor1, patient1, 2);
       System.out.println("Prescription 1: " + prescription1.toString());
       assert (prescription1.getId() == 1);
       assert (prescription1.getDrug().equals(drug1));
       assert (prescription1.getDoctor().equals(doctor1));
       assert (prescription1.getPatient().equals(patient1));
       assert (prescription1.getReit() == 2);
       assert (prescription1.use());
       assert (prescription1.getReit() == 1);
       assert (!prescription1.use());

        // Test for DoctorSystem class
        DoctorSystem system = new DoctorSystem();
        // Test for creating and adding new objects to the system
        Patient patient2 = new Patient("John Doe", "01.01.2000");
        system.listOfPatient.add(patient2);
        Patient patient3 = new Patient("Jane Smith", "01.01.2001");
        system.listOfPatient.add(patient3);
        Drug drug2 = new Regular("Aspirin", 50, 10);
        system.listOfDrug.add(drug2);
        Drug drug3 = new Narcotic("Morphine", 100, 20, 30);
        system.listOfDrug.add(drug3);

        Doctor doctor2 = new Doctor("Dr. Smith");
        system.listOfDoctor.add(doctor2);
        Doctor doctor3 = new Doctor("Dr. Jones");
        system.listOfDoctor.add(doctor3);

        WhitePrescriptions prescription2 = new WhitePrescriptions(drug1, doctor1, patient1, 2);
        system.listOfPrescriptions.add(prescription2);
        WhitePrescriptions prescription3 = new WhitePrescriptions(drug2, doctor2, patient2, 3);
        system.listOfPrescriptions.add(prescription3);

        // Test for printOverview method
        system.printOverview();

        // Test for usePrescription method
        system.usePrescription();


        // Test for printStat method
        system.printStat();

        // Test for writeToFile method
        system.writeToFile();
    }




    }
