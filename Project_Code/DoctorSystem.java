import java.util.*;

import javax.print.Doc;
import javax.print.attribute.standard.MediaSize.NA;

import java.io.*;

public class DoctorSystem {


     static private List<Patient> listOfPatient;
     static private List<Drug> listOfDrug;
     static private List<Doctor> listOfDoctor;
     static private List<Prescriptions> listOfPrescriptions;

     public DoctorSystem(){

       listOfPatient = new ArrayList<Patient>();
       listOfDrug = new ArrayList<Drug>();
       listOfDoctor = new ArrayList<Doctor>();
       listOfPrescriptions = new ArrayList<Prescriptions>();
     }


     public static void main (String[] args){
          StartSystem();
     }

     //Code for making objects
     public static void readFromFile(String filnavn){
          try {

               //storing the file with name myFile
             File myFile = new File(filnavn);

               //Scanning the file and storing it in myReader
             Scanner myReader = new Scanner(myFile);

             String object = "null";
               //My reader will now read
             while (myReader.hasNextLine()) {
               String data = myReader.nextLine();

               if(data.contains("#")){

                 String[] bits = data.split(" ");
                 object = bits[1];

               }else{

                 String[] bits1 = data.split(",");

                 //If pasient object
                 if(object.equals("Patient")){
                    Patient newPatient = new Patient(bits1[0],bits1[1]);
                   listOfPatient.add(newPatient);

                  }

                  //If Drug object
                 if(object.equals("Drug")) {

                       if(bits1[1].equals("narcotic")){
                         Narcotic newNarcotick = new Narcotic(bits1[0],Integer.parseInt(bits1[2]),Double.parseDouble(bits1[3]),Integer.parseInt(bits1[4]));
                          listOfDrug.add(newNarcotick);
                       }

                       if(bits1[1].equals("addictive")){
                         Addictive newAddictive= new Addictive(bits1[0],Integer.parseInt(bits1[2]),Double.parseDouble(bits1[3]),Integer.parseInt(bits1[4]));
                         listOfDrug.add(newAddictive);
                    }

                       if(bits1[1].equals("regular")){
                         Regular newRegular = new Regular(bits1[0],Integer.parseInt(bits1[2]),Double.parseDouble(bits1[3]));
                          listOfDrug.add(newRegular);
                       }
                 }

                 //If Doctor object
                 if(object.equals("Doctor")) {

                     if(!bits1[1].equals("0")){
                       Specialist newSpec = new Specialist(bits1[0],bits1[1]);
                       listOfDoctor.add(newSpec);
                     }else{
                     Doctor newDoc = new Doctor(bits1[0]);
                      listOfDoctor.add(newDoc);
                     }

                  //Hvis det skal bli resept objekter
                 }
                 if(object.equals("Prescriptions")) {

                   int drugNum = Integer.parseInt(bits1[0]);
                   String doctroName = bits1[1];
                   int patientID = Integer.parseInt(bits1[2]);
                   String type = bits1[3];
                   int reit = Integer.parseInt(bits1[4]);


                   for(Doctor doctor : listOfDoctor ){
                     try{
                     if(doctor.getName().equals(doctroName)){

                       if(type.equals("white")){

                         doctor.writeWhitePrescriptions(listOfDrug.get(drugNum),listOfPatient.get(patientID),reit);
                       }
                       if(type.equals("blue")){
                         doctor.writepBluePrescriptions(listOfDrug.get(drugNum),listOfPatient.get(patientID), reit);
                       }
                       if(type.equals("military")){
                         doctor.writeMilitaryPrescriptions( listOfDrug.get(drugNum),listOfPatient.get(patientID));
                       }
                       if(type.equals("p")){
                         doctor.writepPrescription( listOfDrug.get(drugNum),listOfPatient.get(patientID),reit);
                       }
                     }

                   }catch(illegalPrescription l){
                     System.out.println("Something went wrong");
                   }
                 }}}}

           myReader.close();

         } catch (FileNotFoundException e) {
             System.out.println("An error occurred.");
             e.printStackTrace();
           }
           }

     //Interface
     public static void StartSystem(){
          Scanner sc = new Scanner(System.in);
          int selection = 0;


          System.out.println("Welcome to our Doctor-system");
          System.out.println("You have 5 choices. Enter: 1/2/3/4/5:");

          while (selection != -1){
               System.out.println("1: Print a complete overview of patients, doctors, drugs and prescriptions");
               System.out.println("2: Creating and adding new objects to the system");
               System.out.println("3: Use a given prescription from the list to a patient (reit -1)");
               System.out.println("4: Print various forms of statistics");
               System.out.println("5: Write all data to a new file");
               System.out.println("-1: End Program");
               // This will repeat until -1
               System.out.println();
               // Skriv inn inputten din her.
               selection = sc.nextInt();

               switch(selection){
                    case 1:
                    printOverview();
                         break;
                    case 2:
                    creatObject();
                         break;
                    case 3:
                         usePrescription();
                         break;
                    case 4:
                         printStat();
                         break;
                    case 5:
                         writeToFile();
                         break;
                    case -1:
                         System.out.println("Thank you for using our system!");
                         break;
               }
          }
     }

     public static void printOverview(){
          System.out.println("You selected 1 - print complete overview.");
          System.out.println("Doctors:");

          // Prints all Doctors
          if (listOfDoctor.size() == 0){
               // Check if there are any
               System.out.println("No existing Doctors");
          } else {
               for (Doctor l : listOfDoctor){
                    System.out.println(l.toString());
                    System.out.println("The prescription list for the same doctor:");
                    // Check if empty
                    if (l.getWrittenPrescriptions().size() != 0){
                         System.out.println("No prescription");
                    } else{
                         for (Prescriptions r : l.getWrittenPrescriptions()){
                              System.out.println(r.toString());
                         }
                    }
                    // Space between doctors
                    System.out.println();
               }
          }

          // Prints all Patients
          System.out.println("Patients");
          // Check if empty
          if (listOfPatient.size() == 0){
               System.out.println("No existing Patients");

               for (Patient p : listOfPatient){
                    System.out.println(p.toString());
                    System.out.println("The patient's prescription list:");
                    // Check if empty
                    if (p.getPatientPrescriptions().size() == 0){
                         System.out.println("No prescription");
                    } else {
                         for (Prescriptions r : p.getPatientPrescriptions()){
                              System.out.println(r.toString());
                         }
                    }
                     // Space between patients
                    System.out.println();
               }
          }

          // Prints all drugs
          System.out.println("Drugs");
          if (listOfDrug.size() == 0){
               System.out.println("No existing Drugs");
          } else {
               for (Drug lm : listOfDrug){
                    System.out.println(lm.toString());
               }
               // Space between patients
               System.out.println();
          }
     }


     public static void creatObject(){
          System.out.println("You chose 2 - create and add new object to the system");
          System.out.println("Start by choosing which object you want to create first:");
          System.out.println("1 = Drug");
          System.out.println("2 = Patient");
          System.out.println("3 = Prescription");
          System.out.println("4 = Doctor");
          Scanner sc = new Scanner(System.in);
          int selection = 0;
          selection = sc.nextInt();
          sc.close();

          // Create doctor
          if (selection == 1){
               Scanner scanner = new Scanner(System.in);
               System.out.println("The doctor's name is:");
               String name = scanner.nextLine();
               System.out.println("Specify more deeply.");
               System.out.println("Enter 0 for doctor, or enter 1 for specialist:");

               int specify = scanner.nextInt();

               if (specify == 0){
                    Doctor newDoc = new Doctor(name);
                    listOfDoctor.add(newDoc);

               } else if (specify == 1){
                    System.out.println("The doctor's control ID is:");
                    String id = scanner.nextLine();
                    Specialist nySpec = new Specialist(name, id);
                    listOfDoctor.add(nySpec);

               } else {
                    System.out.println("Enter either 0 or 1!");
               }
          }

          // Create patient
          if (selection == 2){
               Scanner scanner = new Scanner(System.in);
               System.out.println("The patients's name is:");
               String name = scanner.nextLine();
               System.out.println("The patients birth date is:");
               String date = scanner.nextLine();
               Patient newPat = new Patient(name, date);
               listOfPatient.add(newPat);
          }

          // Create prescription
          if (selection == 3){
               Scanner scanner = new Scanner(System.in);

               // Prescriptions can only be given if patients exist
               if (listOfPatient.size() == 0){
                    System.out.println("No existing patient");
                    System.out.println("Start by creating a patient first");
                    return;
               }
               System.out.println("Start by specifiying patient");
               for (Patient p : listOfPatient){
                    System.out.println(p.getPatientID() + ": " + p.getName() + " " + p.getBirthDATE());
               }

               Patient thisPatient = null;
               int patId = scanner.nextInt();
               scanner.nextLine();

               for (Patient p : listOfPatient){
                    if (p.getPatientID() == patId){
                         thisPatient = p;
                    } else {
                         System.out.println("Patient with the ID you have given does not exist");
                    }
               }

               if (listOfDoctor.size() == 0){
                    System.out.println("No existing doctor, start by creating a doctor");
               }
               System.out.println("This Doctor will write me a prescription:");
               for (Doctor l : listOfDoctor){
                    System.out.println(l.getName());
               }
               Doctor thisDoc = null;
               String nameOfDoc = scanner.nextLine();

               for (Doctor l : listOfDoctor){
                    if (l.getName().equals(nameOfDoc)){
                         thisDoc = l;
                    } else {
                         System.out.println("This doctor does not exist");
                    }
               }

               if (listOfDrug.size() == 0){
                    System.out.println("No existing drug, start by creating drug");
               }
               System.out.println("Which drug do you want to use");
               for (Drug l : listOfDrug){
                    System.out.println(l.getName());
               }

               Drug thisDrug = null;
               String nameOfDrug = scanner.nextLine();
               for (Drug l : listOfDrug){
                    if (l.getName().equals(nameOfDrug)){
                         thisDrug = l;
                    } else {
                         System.out.println("The drug you have written does not exit.");
                    }
               }

               System.out.println("Choose number of reit:");
               int reit = scanner.nextInt();
               scanner.nextLine();
               System.out.println("Write type of reit");
               System.out.println("Write number for drug type:");
               System.out.println("1 - Military, 2 - P, 3 - Blue");
               int type = scanner.nextInt();

               if (type == 1){
                    MilitaryPrescriptions newMil = new MilitaryPrescriptions(thisDrug, thisDoc, thisPatient);
                    listOfPrescriptions.add(newMil);
                    thisPatient.addPrescription(newMil);
                    thisDoc.addPrescription(newMil);
               }

               if (type == 2){
                    pPrescription newP = new pPrescription(thisDrug, thisDoc, thisPatient, reit);
                    listOfPrescriptions.add(newP);
                    thisPatient.addPrescription(newP);
                    thisDoc.addPrescription(newP);
               }

               if (type == 3){
                    BluePrescriptions newBlue = new BluePrescriptions(thisDrug, thisDoc, thisPatient, reit);
                    listOfPrescriptions.add(newBlue);
                    thisPatient.addPrescription(newBlue);
                    thisDoc.addPrescription(newBlue);
               }
          }

          // Create new Drug
          if (selection == 4){
               Scanner scanner = new Scanner(System.in);
               System.out.println("Enter number for drug type:");
               System.out.println("1 - Narcotic, 2 - Addictive, 3 - Regular");
               int type = scanner.nextInt();

               if (type == 1){
                    System.out.println("You choose narcotic");
                    System.out.println("Name of drug:");
                    String name = scanner.nextLine();

                    System.out.println("Price of drug:");
                    int price = scanner.nextInt();

                    System.out.println("Active ingredient in drug:");
                    double active_ingredient = scanner.nextDouble();

                    System.out.println("Drug strength:");
                    int strength = scanner.nextInt();

                    Narcotic newNar = new Narcotic(name, price, active_ingredient, strength);
                    listOfDrug.add(newNar);
               }

               if (type == 2){
                    System.out.println("You choose addictive");
                    System.out.println("Name of drug:");
                    String name = scanner.nextLine();

                    System.out.println("Price of drug:");
                    int price = scanner.nextInt();

                    System.out.println("Active ingredient in drug:");
                    double active_ingredient = scanner.nextDouble();

                    System.out.println("Drug strength:");
                    int strength = scanner.nextInt();

                    Addictive newAdd = new Addictive(name, price, active_ingredient, strength);
                    listOfDrug.add(newAdd);
               }

               if (type == 3){
                    System.out.println("You choose regular");
                    System.out.println("Name of drug:");
                    String name = scanner.nextLine();

                    System.out.println("Price of drug:");
                    int price = scanner.nextInt();

                    System.out.println("Active ingredient in drug:");
                    double active_ingredient = scanner.nextDouble();

                    Regular newReg = new Regular(name, price, active_ingredient);
                    listOfDrug.add(newReg);;
               }
          }
     }

     public static void usePrescription(){
          Scanner scanner = new Scanner(System.in);

          if (listOfPatient.size() == 0){
               System.out.println("No existing patient");
          } else {
               for (Patient p : listOfPatient){
                    System.out.println(p.getPatientID() + ": " + p.getName() + " " + ("B-Data " + p.getBirthDATE()));
               }
               System.out.println("Write patient ID to get.");
               int patId = scanner.nextInt();
               scanner.nextLine();

               Patient thisPat = null;
               for (Patient p : listOfPatient){
                    if (p.getPatientID() == patId){
                         thisPat = p;
                         for (Prescriptions r : thisPat.getPatientPrescriptions()){
                              System.out.println(r);
                         }
                    }
               }
               // If patient has prescription
               if (thisPat != null || thisPat.getPatientPrescriptions().size() > 0){
                    System.out.println("Write prescription ID:");
                    int presID = scanner.nextInt();
                    scanner.nextLine();

                    for (Prescriptions r : thisPat.getPatientPrescriptions()){
                         // Sjekker om resepten har flere reit
                         if (r.getId() == presID){
                              if (r.getReit() > 0){
                                   // reit -1
                                   r.use();
                                   System.out.println("You have " + r.getReit() + " reit's left.");
                              } else {
                                   System.out.println("You dont have any reit's left");
                              }
                         } else {
                              System.out.println("Prescription you entered does not exist");
                         }
                    }
               } else {
                    System.out.println("Patient you entered does not exist");
               }
          }
     }


     public static void printStat(){
          if (listOfPrescriptions.size() == 0){
               System.out.println("No existing prescriptions");
          }

          // increments values
          int totNarDrugs = 0;
          int totAddDrugs = 0;
          int totRegDrugs = 0;

          // Narcotic
          for (Prescriptions r : listOfPrescriptions){
               if (r.getDrug() instanceof Narcotic){
                    totNarDrugs += 1;
               }
          }
          if (totNarDrugs == 0){
               System.out.println("No Narcotic Drugs");
          } else {
               System.out.println("There are " + totNarDrugs + " narcotic drugs");
          }

          // Addictive
          for (Prescriptions r : listOfPrescriptions){
               if (r.getDrug() instanceof Addictive){
                    totAddDrugs += 1;
               }
          }
          if (totAddDrugs == 0){
               System.out.println("No addictive Drugs");
          } else {
               System.out.println("There are " + totAddDrugs + " Addictive drugs");
          }

          for (Prescriptions r : listOfPrescriptions){
               if (r.getDrug() instanceof Regular){
                    totRegDrugs += 1;
               }
          }
          if (totRegDrugs == 0){
               System.out.println("No regular drugs");
          } else {
               System.out.println("There are " + totRegDrugs + " regular drugs");
          }

          //Stat piece

          for(Doctor n : listOfDoctor){
               int count = 0;

               if(!(n instanceof Specialist)){
                    continue;
               }

               for(Prescriptions k : n.getWrittenPrescriptions()){
                    if(k.getDrug() instanceof Narcotic){
                         count++;
                    }}

               if(count != 0 ){
                   System.out.println(n.getName() + " number of prescription: "+ count);
               }


          }

     }

     public static void writeToFile(){
          try{
               //We get the file
               String navn = "fNav.txt";
               File myFile = new File(navn);


               //Create a new file if myFile does not exists
               if( myFile.createNewFile() ){
               FileWriter myW = new FileWriter(navn);
                    System.out.println("We have created a file with the name: " + myFile.getName() );

               myW.write("Patient information (name, BDate) ");
               for(Patient n : listOfPatient){
                    myW.write(n.getName() + "," + n.getBirthDATE());
               }


               myW.write("Drug information (name,type,price,active_ingerdiens,evt.strengt)");
               for(Drug n : listOfDrug){
                    myW.write(n.getName() + "," + n.getType() + "," + n.getPrice() +
                    "," + n.getActive_ingredient() + "," + n.getStrength());
               }



              myW.write("Doctor information (name,controlID,(1 if specialist, 0 if not))");
              for (Doctor n : listOfDoctor){
               if (n instanceof Specialist){

                     Specialist k = (Specialist) n;
                      myW.write(k.getName() + "," +k.getID());

                }else{
                      myW.write(n.getName() + ", 0");}}


               myW.write("Prescription infomration (drugID,doctroName,patientID,type,evt.reit)");

               for (Prescriptions n : listOfPrescriptions){
                    Drug drug = n.getDrug();
                    int drugID = n.getId();
                    Doctor doctor = n.getDoctor();
                    String doctorName = doctor.getName();
                    Patient patient = n.getPatient();
                    int patID = patient.getPatientID();
                    String type = n.getType();

                    if(type.equals("MilitaryPrescriptions")){

                    myW.write(drugID+","+doctorName+","+patID+","+type);

                    }else{
                         int reit = n.getReit();
                         myW.write(drugID+","+doctorName+","+patID+","+type+","+reit);

                    }
               }
               myW.close();
          }else{
               System.out.println("You have a file with the name: "+ navn);
          }
          }catch(IOException e){
               System.out.println("Error");
               e.printStackTrace();       }
     }

}
