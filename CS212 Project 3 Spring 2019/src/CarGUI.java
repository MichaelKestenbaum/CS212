/*Michael Kestenbaum
  Project 3
  Lab Section 11C
  */


// Create the Car Gui
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;



class CarGUI extends JFrame {
  public static JFrame frame;
  public static Scanner reader = null;
  TextArea unsortedTextArea = new TextArea();
  TextArea sortedTextArea = new TextArea();
  
  public CarGUI(){}

  public void CreateCarGUI() {

    // Create the JFrame with the correct amount of columns
    this.frame = new JFrame("Project 3");
    this.frame.setSize(400, 400);// width, height);
    this.frame.setLocation(200, 200);// x, y);
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frame.setLayout(new GridLayout(1,2));

    //Create the JMenu
    JMenuItem open = new JMenuItem("Open");
    JMenuItem quit = new JMenuItem("Quit");
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    FileMenuHandler fmh = new FileMenuHandler(this);

    // Add the action listener to the menu items
    open.addActionListener(fmh);
    quit.addActionListener(fmh);

    // Add the menu items to the file menu
    fileMenu.add(open);
    fileMenu.addSeparator();
    fileMenu.add(quit);

    // Add file menu to the menu bar, and set this gui's
    // menu bar to the menuBar we created above
    menuBar.add(fileMenu);
    this.frame.setJMenuBar(menuBar);

  // Display the window.
    this.frame.pack();
    this.frame.setVisible(true);
  }



  // Create a function to read the selected file
  public void readFile(File file)
  {
     // If there is a file, scan it
     try
     {
       reader = new Scanner(file);
       while (reader.hasNextInt())
       {
           System.out.println(reader.nextInt());
       }
     }
     catch (FileNotFoundException e)
     {
       e.printStackTrace();
     }

     // Create 2 text areas for the sorted and unsorted lists

     unsortedTextArea.setText("Unsorted:\n");
     sortedTextArea.setText("Sorted:\n");

     // create 2 linked lists that will hold the Cars
     UnsortedCarList Unsorted = new UnsortedCarList();
     SortedCarList Sorted = new SortedCarList();

     // Use scanner to read the Reader
     int indexOfArray = 0;

     // Cycle through the file to read the Cars
     while(reader.hasNextLine()){
       String s1 = reader.nextLine();
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
     reader.close();

     // Add the linked lists to the TextAreas
     for(CarNode i = Unsorted.head.next; i != null; i = i.next){
       unsortedTextArea.append(i.data.toString()+"\n");
     }
     for(CarNode i = Sorted.head.next; i != null; i = i.next){
       sortedTextArea.append(i.data.toString()+"\n");
     }

     // Add the TextAreas to the content pane
     this.frame.getContentPane().add(unsortedTextArea);
     this.frame.getContentPane().add(sortedTextArea);

     // Display the window.
     this.frame.pack();

 }



}
