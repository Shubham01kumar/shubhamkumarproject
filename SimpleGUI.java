package task2;
import javax.swing.*;

//import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUI {
    // Constructor to set up the GUI components and event handling
    public SimpleGUI() {
        // Create a new JFrame container
        JFrame frame = new JFrame("Simple GUI Example");
        // Specify FlowLayout for the layout manager
       // frame.setLayout(new FlowLayout());
        // Give the frame an initial size
        frame.setSize(300, 200);
        // Terminate the program when the user closes the application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a label
        JLabel label = new JLabel("Hello, welcome to the simple GUI!");
        frame.add(label);

        // Create a button
        JButton button = new JButton("Click Me");
        frame.add(button);

        // Add an action listener to the button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Button clicked!");
            }
        });

        // Display the frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Create the frame on the event dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SimpleGUI();
            }
        });
    }
}

