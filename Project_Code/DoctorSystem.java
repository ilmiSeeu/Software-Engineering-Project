import java.util.*;
import javax.print.Doc;
import javax.print.attribute.standard.MediaSize.NA;
import java.io.*;

public class DoctorSystem {

  public static void main (String[] args){
       StartSystem();
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
            // Enter Selection
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

}
