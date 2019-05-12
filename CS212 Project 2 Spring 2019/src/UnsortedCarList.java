/*Michael Kestenbaum
  Project 2
  Lab Section 11C
  */

  public class UnsortedCarList extends CarList{

    // default constructor creates a "dummy" link as the head
    public UnsortedCarList(){
      super();
    }

    // create an add function that calls the append function from the super class
    public void add(Car c){
      this.append(c);
    }
  }
