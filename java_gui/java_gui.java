// java -version
// javac -version
// Extension Pack for Java
// Create your Java project folder
// right click and run java
// or do it manually,,go one folder back and 
// javac foldername\filename.java
// java foldername.filename

package myjava.java_gui;

import javax.swing.*;
import java.awt.*;

public class java_gui extends JFrame {

    private JButton clickButton, cancelButton, resetButton;
    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public java_gui() {
        // Window settings
        setTitle("Demo App");
        setSize(400, 500);
        setLocation(400, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setBackground(new Color(100, 150, 170));

        // Username
        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(10, 10, 100, 20);
        c.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(10, 40, 360, 30);
        c.add(usernameField);

        // Password
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 80, 100, 20);
        c.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(10, 110, 360, 30);
        c.add(passwordField);

        // Buttons
        clickButton = new JButton("Click");
        clickButton.setBounds(40, 170, 80, 40);
        c.add(clickButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(150, 170, 80, 40);
        c.add(cancelButton);

        resetButton = new JButton("Reset");
        resetButton.setBounds(260, 170, 80, 40);
        c.add(resetButton);

        // Show window
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new java_gui());
    }
}
