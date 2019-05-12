/*Michael Kestenbaum
  Project 3
  Lab Section 11C
  */

import javax.swing.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;


public class FileMenuHandler implements ActionListener
{

    // Save the reference to the gui object this FileMenuHandler is
    // associated with
    private CarGUI frame;

    // Constructor that takes as its paramaeter the gui associated
    // with this FileMenuHandler
    public FileMenuHandler(CarGUI frame)
    {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        // Get the command name from the event
        String menuName = event.getActionCommand();


        if (menuName.equals("Open"))
        {
            // Create the object that will choose the file
            JFileChooser fc = new JFileChooser();

            // Attempt to open the file
            int returnVal = fc.showOpenDialog(null);

            //If a file is chosen, pass the file to the GUI's reader
            if (returnVal == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                this.frame.readFile(file);

            }
            //If the user cancels instead of selecting a file
            else if (returnVal == JFileChooser.CANCEL_OPTION)
            {
                System.out.println("Open command cancelled by user.");
            }
        }
        else if (menuName.equals("Quit"))
        {
            System.exit(1);
        }

    }
}
