/*Michael Kestenbaum
  Project 4
  Lab Section 11C
  */

  public abstract class CarList{
    protected CarNode head;
    protected CarNode tail;
    protected int length;

    // create the default constructor which is just two null nodes of length 0
    public CarList(){
      this.head = new CarNode();
      this.tail = this.head;
      length = 0;
    }

    // create the append function which adds the next car to the end of the list
    public void append(Car c){

      // create the new CarNode
      CarNode n = new CarNode(c);

      // link the last link to the new one
      tail.next = n;

      // set the new node to be the tail
      tail = n;

      // increment the length by one
      length++;
    }
  }
