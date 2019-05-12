/*Michael Kestenbaum
  Project 4
  Lab Section 11C
  */


public class CarNode {

  // Declare protected variables
  protected Car data;
  protected CarNode next;

  // Create a default node that has only null
  public CarNode(){
    data = null;
    next = null;
  }

  // Create the one parameter constructor that takes in a Car
  public CarNode(Car c){
    data = c;
    next = null;
  }
}
