/*Michael Kestenbaum
  Project 4
  Lab Section 11C
  */


  import javax.swing.*;
  import javax.swing.JFileChooser;
  import javax.swing.JOptionPane;
  import java.awt.event.ActionEvent;
  import java.awt.event.ActionListener;
  import java.io.File;
  import java.io.FileNotFoundException;


  class EditMenuHandler implements ActionListener{

    protected CarGUI frame;

    public EditMenuHandler(CarGUI frame){
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent event){

      // Get the command name from the event
      String menuName = event.getActionCommand();

      // Check if button clicked was the search button
      if(menuName.equals("Search")){
        // Create a new string for user input
        String makeName = JOptionPane.showInputDialog("What make car should be displayed?");
        // Create 2 new linked lists to place the chosen cars in
        UnsortedCarList ucl = new UnsortedCarList();
        SortedCarList sl = new SortedCarList();
        // Search through the old linked lists to find carrs with that make and
        // insert them in the new linked lists
        for(CarNode i = frame.Unsorted.head.next; i != null; i = i.next){
          if (i.data.getMake().equals(makeName)) ucl.add(i.data);
        }
        for(CarNode i = frame.Sorted.head.next; i != null; i = i.next){
          if (i.data.getMake().equals(makeName)) sl.add(i.data);
        }
        // Clear the text areas
        frame.unsortedTextArea.setText("");
        frame.sortedTextArea.setText("");

        frame.unsortedTextArea.setText("Unsorted:\n");
        frame.sortedTextArea.setText("Sorted:\n");

        // Add the linked lists to the TextAreas
        for(CarNode i = ucl.head.next; i != null; i = i.next){
          frame.unsortedTextArea.append(i.data.toString()+"\n");
        }
        for(CarNode i = sl.head.next; i != null; i = i.next){
          frame.sortedTextArea.append(i.data.toString()+"\n");
        }
      }



  }
}
