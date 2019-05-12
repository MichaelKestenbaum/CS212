/*Michael Kestenbaum
  Project 1
  Lab Section 11C
  */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Project1{

  public static void main(String[] args) throws FileNotFoundException {

    File myInput = new File("Cars.txt");

    // create 2 arrays that will hold the Cars
    Car[] unSorted = new Car[9999];
    Car[] Sorted = new Car[9999];

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


      // use a while loop to go through all of the tokens until there are no more tokens
      else while (st1.hasMoreTokens()) {
          s1 =  st1.nextToken();

          String s2 = st1.nextToken();
          int s3 = Integer.parseInt(st1.nextToken());
          int s4 = Integer.parseInt(st1.nextToken());


          // Put the Cars into the arrays
          Car drive = new Car(s1, s2, s3, s4);
          unSorted[indexOfArray] = drive;
          Sorted[indexOfArray] = drive;
          indexOfArray++;

      }
    }
    // Close the scanner
    newCar.close();

    // Call the selectionSort function on the Sorted array
    selectionSort(Sorted, indexOfArray);

    // Call the GUI function to create the GUI
    CarGUI.CreateCarGUI(unSorted, Sorted, indexOfArray);


  }

  // Create the selection sort function
  public static void selectionSort(Car[] other, int index){
    for(int i = 0; i < index; i++){
      Car min = other[i];
      int place = i;
      for (int j = i +1; j < index; j++){
        if(min.getMake().compareTo(other[j].getMake()) > 0){
          min = other[j];
          place = j;
        }
      }
      swap(other, i, place);
    }
  }

  // Create a swap function 
  private static void swap(Car[] input, int i, int j)
    {
        Car temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
