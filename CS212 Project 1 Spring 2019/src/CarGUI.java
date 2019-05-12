/*Michael Kestenbaum
  Project 1
  Lab Section 11C
  */


// Create the Car Gui
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;


class CarGUI extends JFrame {


  public static void CreateCarGUI(Car[] unsorted, Car[] sorted, int index){

    // Create the JFrame with the correct amount of columns
    JFrame frame = new JFrame("Project 1");
    frame.setSize(400, 400);// width, height);
    frame.setLocation(200, 200);// x, y);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(1,2));

    // Create 2 text areas for the sorted and unsorted matrices
    TextArea unsortedTextArea = new TextArea();
    TextArea sortedTextArea = new TextArea();
    unsortedTextArea.setText("Unsorted:\n");
    sortedTextArea.setText("Sorted:\n");

    for(int i = 0; i < index; i++){
      //Break out of loop if we reach a car that hasn't been assigned a Model
      if(unsorted[i] == null || sorted [i] == null) break;

      unsortedTextArea.append(unsorted[i].toString()+"\n");
      sortedTextArea.append(sorted[i].toString()+"\n");
    }

    // Add the TextArea's to the content pane
    frame.getContentPane().add(unsortedTextArea);
    frame.getContentPane().add(sortedTextArea);

    //Display the window.
    frame.pack();
    frame.setVisible(true);



  }



}
