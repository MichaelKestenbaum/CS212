/*Michael Kestenbaum
  Project 2
  Lab Section 11C
  */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Project2{

  public static void main(String[] args) throws FileNotFoundException {

    File myInput = new File("Cars.txt");

    // create 2 linked lists that will hold the Cars
    UnsortedCarList Unsorted = new UnsortedCarList();
    SortedCarList Sorted = new SortedCarList();

    //use scanner to read myInput
    Scanner newCar = new Scanner(myInput);
    int indexOfArray = 0;

    // Cycle through the file to read the Cars
    while(newCar.hasNextLine()){
      String s1 = newCar.nextLine();
      StringTokenizer st1 = new StringTokenizer(s1, ",");


      // If the line doesn't have 4 tokens, print that line out
      if (st1.countTokens() < 4){
        System.out.println(s1);
      }

      if (st1.countTokens() > 4){
        System.out.print(s1);
      }


      // Place the tokens into their respective variables in the car class
      if (st1.countTokens() == 4){

        s1 =  st1.nextToken();

        String s2 = st1.nextToken();
        int s3 = Integer.parseInt(st1.nextToken());
        int s4 = Integer.parseInt(st1.nextToken());

        // Put the Cars into the linked lists
        Car drive = new Car(s1, s2, s3, s4);
        Unsorted.add(drive);
        Sorted.add(drive);
      }


    }
    // Close the scanner
    newCar.close();

    // Call the GUI function to create the GUI
    CarGUI.CreateCarGUI(Unsorted, Sorted);
  }
}
