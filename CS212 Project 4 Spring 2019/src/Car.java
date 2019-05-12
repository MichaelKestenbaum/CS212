/*Michael Kestenbaum
  Project 4
  Lab Section 11C
  */

// Create a class called Car
public class Car {

  // create private instance variables
  private String make;
  private String model;
  private int year;
  private int mileage;

  public Car (String mk, String md, int yr, int mlg){
    this.make = mk;
    this.model = md;
    this.year = yr;
    this.mileage = mlg;
  }

  public void setMake(String mk){
    make = mk;
  }

  public void setModel(String md){
    model = md;
  }

  public void setYear(int yr){
    year = yr;
  }

  public void setMileage(int mlg){
    mileage = mlg;
  }

  public String getMake(){
    return make;
  }

  public String getModel(){
    return model;
  }

  public int getYear(){
    return year;
  }

  public int getMileage(){
    return mileage;
  }

  // Override the toString function
  public String toString(){
    return this.make + "," + this.model + "," + this.year + "," + this.mileage;
  }

  /*public static void selectionSort(Car[] other){
    for(i = 0; i < other.length; i++){
      String min = other[i].make;
      int index = i;
      for (int j = i +1; j < other.length; j++){
        if(min.compareTo(other[j].make) < 0){
          min = object[j].make;
          index = j;
        }
      }
      swap(input, i, index);
    }
  }*/

}
