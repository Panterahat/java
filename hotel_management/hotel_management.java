package myjava.hotel_management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class hotel_management implements ActionListener {

    JFrame loginframe, homeframe, addroomframe, viewroomframe;
    Container logincon, homecon, addcon, viewcon;
    JLabel name, pass, error, contactdev, wellcome, roomtype, roomprice, roomno, actype, balconytype;
    JTextField namef, passf, roompricee, roomnoo;
    JTextArea roomDisplay;
    JButton login, addroom, viewrooms, booking, saveRoom, CANCEL;
    JPanel roomListPanel, card;

    int count;
    int roomnum = 0;

    String[] roomTypes = { "Single", "Double", "Deluxe", "Suite" };
    String[] acstatus = { "AC", "NON-AC" };
    String[] balconystatus = { "AVAILABLE", "NOT AVAILABLE" };

    JComboBox<String> roomTypeBox = new JComboBox<>(roomTypes);
    JComboBox<String> acstatusbox = new JComboBox<>(acstatus);
    JComboBox<String> balconystatusbox = new JComboBox<>(balconystatus);
    ArrayList<Room> rooms = new ArrayList<>();

    boolean devMode = true; // ✅ set this to false before final release

    hotel_management() {
        // login page
        loginframe = new JFrame("LOG IN");
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

        // log in button
        login = new JButton("Log in");
        login.setBounds(100, 150, 75, 20);
        logincon.add(login);
        login.addActionListener(this);

        // error lebel
        error = new JLabel("Password or Username doesn't match");
        error.setBounds(30, 180, 250, 20);

        // contact dev lebel
        contactdev = new JLabel(
                "<html>Too Many Invalid Attempts<br>&nbsp;&nbsp;&nbsp;Contact developer At<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+8801892246346</html>");
        contactdev.setBounds(70, 280, 250, 50);

        loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginframe.setVisible(true); // makes the frame visible

        // ************************************************************************************
        // home page
        homeframe = new JFrame("HOME");
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

        // view rooms button;
        viewrooms = new JButton("VIEW ROOM");
        viewrooms.setBounds(140, 40, 110, 20);
        viewrooms.addActionListener(this);
        homecon.add(viewrooms);

        // booking button;
        booking = new JButton("BOOK");
        booking.setBounds(30, 70, 220, 20);
        booking.addActionListener(this);
        homecon.add(booking);

        // ************************************************************************************
        // add room frame
        addroomframe = new JFrame("ALL ROOMS");
        addroomframe.setBounds(800, 300, 300, 400);
        addcon = addroomframe.getContentPane();
        addcon.setLayout(null);

        // roomtype selection
        roomtype = new JLabel("SELECT ROOM CATAGORY :");
        roomtype.setBounds(10, 10, 200, 20);
        addcon.add(roomtype);

        // room type menu
        roomTypeBox.setBounds(10, 35, 250, 25);
        addcon.add(roomTypeBox);

        // pricing
        roomprice = new JLabel("ROOM BILLING:");
        roomprice.setBounds(10, 70, 200, 20);
        addcon.add(roomprice);

        roompricee = new JTextField();
        roompricee.setBounds(10, 95, 250, 25);
        addcon.add(roompricee);

        // ac selection
        actype = new JLabel("SELECT AC CATAGORY :");
        actype.setBounds(10, 130, 200, 20);
        addcon.add(actype);

        // ac menu
        acstatusbox.setBounds(10, 155, 250, 25);
        addcon.add(acstatusbox);

        // balcony selection
        balconytype = new JLabel("SELECT BALCONY CATAGORY :");
        balconytype.setBounds(10, 190, 220, 20);
        addcon.add(balconytype);

        // balcony menu
        balconystatusbox.setBounds(10, 215, 250, 25);
        addcon.add(balconystatusbox);

        // room no
        roomno = new JLabel("ROOM NUMBER:");
        roomno.setBounds(10, 250, 200, 20);
        addcon.add(roomno);

        roomnoo = new JTextField();
        roomnoo.setBounds(10, 275, 250, 25);
        addcon.add(roomnoo);

        // saveroom button
        saveRoom = new JButton("SAVE");
        saveRoom.setBounds(150, 310, 100, 30);
        addcon.add(saveRoom);
        saveRoom.addActionListener(this);

        // cancel button
        CANCEL = new JButton("CANCEL");
        CANCEL.setBounds(10, 310, 100, 30);
        addcon.add(CANCEL);
        CANCEL.addActionListener(this);

        // ************************************************************************************
        // view rooms frame
        viewroomframe = new JFrame("ALL SAVED ROOMS");
        viewroomframe.setBounds(800, 300, 300, 400);
        viewcon = viewroomframe.getContentPane();
        viewcon.setLayout(new BorderLayout());

        // panel area to show rooms
        roomListPanel = new JPanel();
        roomListPanel.setLayout(new BoxLayout(roomListPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(roomListPanel);
        viewcon.add(scrollPane, BorderLayout.CENTER);

    }

    public void actionPerformed(ActionEvent e) {
        String key = ((JButton) e.getSource()).getText(); // get button text
        switch (key) {
            case "Log in":
                if (namef.getText().equals("admin") && passf.getText().equals("0000")) {

                    Point p = loginframe.getLocation();

                    homeframe.setLocation(p);

                    loginframe.setVisible(false);
                    homeframe.setVisible(true);

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
                break;
            case "ADD ROOM":
                Point p = homeframe.getLocation();
                addroomframe.setLocation(p);

                homeframe.setVisible(false); // hide login window
                addroomframe.setVisible(true); // makes the frame visible
                break;
            case "SAVE":
                try {
                    String type = (String) roomTypeBox.getSelectedItem();
                    String ac = (String) acstatusbox.getSelectedItem();
                    String balcony = (String) balconystatusbox.getSelectedItem();
                    double price = Double.parseDouble(roompricee.getText());
                    int number = Integer.parseInt(roomnoo.getText());

                    Room newRoom = new Room(type, ac, balcony, price, number);
                    rooms.add(newRoom);

                    JOptionPane.showMessageDialog(addroomframe, "✅ Room added successfully!");

                    // clear fields
                    roompricee.setText("");
                    roomnoo.setText("");
                    homeframe.setVisible(true);
                    addroomframe.setVisible(false);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(addroomframe, "❌ Error adding room: " + ex.getMessage());
                }
                break;
            case "VIEW ROOM":
                if (rooms.isEmpty()) {
                    JOptionPane.showMessageDialog(homeframe, "No rooms have been added yet.");
                } else {
                    roomListPanel.removeAll(); // clear old content

                    for (Room r : rooms) {
                        card = new JPanel();
                        card.setLayout(new GridLayout(5, 1));
                        card.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
                        card.setBackground(new Color(230, 240, 255)); // light blue background
                        card.add(new JLabel("Room No: " + r.roomNumber));
                        card.add(new JLabel("Type: " + r.type));
                        card.add(new JLabel("AC: " + r.acStatus));
                        card.add(new JLabel("Balcony: " + r.balconyStatus));
                        card.add(new JLabel("Price: " + r.price + " ৳"));
                        roomListPanel.add(card);
                        roomListPanel.add(Box.createVerticalStrut(10)); // space between cards
                    }

                    roomListPanel.revalidate();
                    roomListPanel.repaint();

                    // position the frame nicely
                    Point p2 = homeframe.getLocation();
                    viewroomframe.setLocation(p2);
                    viewroomframe.setVisible(true);
                }
                break;
            case "CANCEL":
                addroomframe.setVisible(false);
                homeframe.setVisible(true);

                break;

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

    public class Room {
        String type;
        String acStatus;
        String balconyStatus;
        double price;
        int roomNumber;

        Room(String type, String acStatus, String balconyStatus, double price, int roomNumber) {
            this.type = type;
            this.acStatus = acStatus;
            this.balconyStatus = balconyStatus;
            this.price = price;
            this.roomNumber = roomNumber;
        }

        @Override
        public String toString() {
            return "Room No: " + roomNumber + " | Type: " + type + " | AC: " + acStatus +
                    " | Balcony: " + balconyStatus + " | Price: " + price;
        }
    }

}
// add a option to set the 2nd frame at exactly where the first frame was last
// at
