/*Michael Kestenbaum
  Project 4
  Lab Section 11C
  */

  public class SortedCarList extends CarList{

    // Create the default constructor that just creates the "dummy" node
    public SortedCarList(){
      super();
    }

    // Create the sort add
    public void add(Car c){

      // 1) Create a new CarNode
      CarNode n = new CarNode(c);

      // 2) Create an iterator to go through all the CarNodes
      CarNode i = this.head;

      // 3) While there are still nodes in the linked list and the car in
      //    the iterated node is smaller than the new car, increment the node
      while(i.next != null && i.next.data.getMake().compareTo(n.data.getMake()) < 0){
        i = i.next;
      }

      // 4) attach the remainder of the list to the end of the new node
      n.next = i.next;

      // 5) attach the new node to the end of the i'th node
      i.next = n;

      // 6) if the new car is the last one, make it the tail
      if(i == this.tail) this.tail = n;

      // 7) increment the length by one
      this.length++;
    }
  }
