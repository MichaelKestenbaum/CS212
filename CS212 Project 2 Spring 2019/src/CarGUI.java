/*Michael Kestenbaum
  Project 2
  Lab Section 11C
  */


// Create the Car Gui
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;


class CarGUI extends JFrame {


  public static void CreateCarGUI(CarList Unsorted, CarList Sorted){

    // Create the JFrame with the correct amount of columns
    JFrame frame = new JFrame("Project 1");
    frame.setSize(400, 400);// width, height);
    frame.setLocation(200, 200);// x, y);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(1,2));

    // Create 2 text areas for the sorted and unsorted lists
    TextArea unsortedTextArea = new TextArea();
    TextArea sortedTextArea = new TextArea();
    unsortedTextArea.setText("Unsorted:\n");
    sortedTextArea.setText("Sorted:\n");

    // Add the linked lists to the TextAreas
    for(CarNode i = Unsorted.head.next; i != null; i = i.next){
      unsortedTextArea.append(i.data.toString()+"\n");
    }
    for(CarNode i = Sorted.head.next; i != null; i = i.next){
      sortedTextArea.append(i.data.toString()+"\n");
    }

    // Add the TextAreas to the content pane
    frame.getContentPane().add(unsortedTextArea);
    frame.getContentPane().add(sortedTextArea);

    //Display the window.
    frame.pack();
    frame.setVisible(true);



  }



}
