package myjava.hotel_management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class hotel_management implements ActionListener {

    JFrame loginframe, homeframe;
    Container logincon, homecon;
    JLabel name, pass, error, contactdev, wellcome;
    JTextField namef, passf;
    JButton login, addroom;
    int count;

    boolean devMode = true; // ✅ set this to false before final release

    hotel_management() {
        // login page
        loginframe = new JFrame("Wellcome to Hotel-X");
        loginframe.setBounds(800, 300, 300, 400);
        logincon = loginframe.getContentPane();
        logincon.setLayout(null); // tells compiler that i will decide where components go

        // Username
        name = new JLabel("Username:");
        name.setBounds(10, 10, 100, 20);
        logincon.add(name);

        namef = new JTextField();
        namef.setBounds(10, 40, 270, 30);
        logincon.add(namef);

        // Password
        pass = new JLabel("Password:");
        pass.setBounds(10, 80, 100, 20);
        logincon.add(pass);

        passf = new JPasswordField();
        passf.setBounds(10, 110, 270, 30);
        logincon.add(passf);

        // buttons
        login = new JButton("Log in");
        login.setBounds(100, 150, 75, 20);
        logincon.add(login);
        login.addActionListener(this);

        // error part
        error = new JLabel("Password or Username doesn't match");
        error.setBounds(30, 180, 250, 20);

        // contact dev part
        contactdev = new JLabel(
                "<html>Too Many Invalid Attempts<br>&nbsp;&nbsp;&nbsp;Contact developer At<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+8801892246346</html>");
        contactdev.setBounds(70, 280, 250, 50);

        loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginframe.setVisible(true); // makes the frame visible

        // home page
        homeframe = new JFrame("HELLO SIR");
        homeframe.setBounds(800, 300, 300, 400);
        homecon = homeframe.getContentPane();
        homecon.setLayout(null);

        // greetings
        wellcome = new JLabel("wellcome sir");
        wellcome.setBounds(100, 10, 100, 20);
        homecon.add(wellcome);

        // add rooms button;
        addroom = new JButton("ADD ROOM");
        addroom.setBounds(30, 40, 100, 20);
        addroom.addActionListener(this);

        homecon.add(addroom);

    }

    public void actionPerformed(ActionEvent e) {
        String key = ((JButton) e.getSource()).getText(); // get button text
        switch (key) {
            case "Log in":
                if (namef.getText().equals("admin") && passf.getText().equals("0000")) {

                    loginframe.setVisible(false); // hide login window
                    homeframe.setVisible(true); // makes the frame visible

                } else {
                    passf.setText("");
                    namef.setText("");

                    logincon.add(error);
                    count++;

                    if (count > 2) {
                        logincon.add(contactdev);
                    }

                    logincon.revalidate();
                    logincon.repaint();
                }

        }

    }

    // public static void main(String[] args) {
    // new hotel_management();
    // }

    public static void main(String[] args) {
        hotel_management app = new hotel_management();

        if (app.devMode) {
            app.loginframe.setVisible(false);
            app.homeframe.setVisible(true);
        }
    }

}
