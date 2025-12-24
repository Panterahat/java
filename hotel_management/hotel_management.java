

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class hotel_management implements ActionListener {

    JFrame loginframe, homeframe, addroomframe, viewroomframe, bookinFrame, viewclientframe, checkoutframe, billframe;
    Container logincon, homecon, addcon, viewcon, bookcon, viewclientcon, checkoutcon, billcon;
    JLabel name, pass, error, contactdev, wellcome, roomtype, roomprice, roomno, actype, balconytype, guestname,
            guestage, divLabel, distLabel, phoneno, nidno, bookroomno, checkoutroomlabel;
    JTextField namef, roompricee, roomnoo, guestnamee, guestagee, phonenoo, nidnoo, bookroomnoo, checkoutroomfield;
    JPasswordField passf;
    JTextArea roomDisplay;
    JButton login, addroom, viewrooms, booking, saveRoom, addguest, CANCEL, HISTORY, CHECKOUT, GENERATEBILL;
    JPanel roomListPanel, card, clientListPanel;

    int count;
    int roomnum = 0;

    String[] roomTypes = { "Single", "Double", "Deluxe", "Suite" };
    String[] acstatus = { "AC", "NON-AC" };
    String[] balconystatus = { "AVAILABLE", "NOT AVAILABLE" };

    String[] Division = { "Barishal", "Chattogram", "Dhaka", "Khulna", "Mymensingh", "Rajshahi", "Rangpur", "Sylhet" };

    String[] Barishal = { "Barguna", "Barisal", "Bhola", "Jhalokati", "Patuakhali", "Pirojpur" };
    String[] Chattogram = { "Bandarban", "Brahmanbaria", "Chandpur", "Chittagong", "Comilla", " Cox's Bazar", "Feni",
            "Khagrachhari", "Lakshmipur", "Noakhali", "Rangamati" };
    String[] Dhaka = { "Dhaka", "Faridpur", "Gazipur", "Gopalganj", "Kishoreganj", " Madaripur", "Manikganj",
            "Munshiganj", "Narayanganj", "Narsingdi", "Rajbari", "Shariatpur", "Tangail" };
    String[] Khulna = { "Bagerhat", "Chuadanga", "Jessore", "Jhenaidah", "Khulna", "Kushtia", "Magura", "Meherpur",
            "Narail", "Satkhira" };
    String[] Mymensingh = { "Jamalpur", "Mymensingh", "Netrakona", "Sherpur" };
    String[] Rajshahi = { "Bogra", "Chapainawabganj", "Joypurhat", "Naogaon", "Natore", "Pabna", "Rajshahi",
            "Sirajganj" };
    String[] Rangpur = { "Dinajpur", "Gaibandha", "Kurigram", "Lalmonirhat", "Nilphamari", "Panchagarh", "Rangpur",
            "Thakurgaon" };
    String[] Sylhet = { "Habiganj", "Maulvibazar", "Sunamganj", "Sylhet" };

    JComboBox<String> roomTypeBox = new JComboBox<>(roomTypes);
    JComboBox<String> acstatusbox = new JComboBox<>(acstatus);
    JComboBox<String> balconystatusbox = new JComboBox<>(balconystatus);
    JComboBox<String> Divisionbox = new JComboBox<>(Division);
    JComboBox<String> districtBox = new JComboBox<>();

    HashMap<String, String[]> divisionDistrictMap = new HashMap<>();

    {
        divisionDistrictMap.put("Barishal", Barishal);
        divisionDistrictMap.put("Chattogram", Chattogram);
        divisionDistrictMap.put("Dhaka", Dhaka);
        divisionDistrictMap.put("Khulna", Khulna);
        divisionDistrictMap.put("Mymensingh", Mymensingh);
        divisionDistrictMap.put("Rajshahi", Rajshahi);
        divisionDistrictMap.put("Rangpur", Rangpur);
        divisionDistrictMap.put("Sylhet", Sylhet);
    }

    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<client> clients = new ArrayList<>();

    boolean devMode = false; // ✅ set this to false before final release

    hotel_management() {

        Color frameColor = Color.decode("#598392");
        Color buttoncColor = Color.decode("#eff6e0");
        // login page
        loginframe = new JFrame("LOG IN");
        loginframe.setBounds(800, 300, 300, 400);
        logincon = loginframe.getContentPane();
        logincon.setBackground(frameColor);

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
        login.setBackground(buttoncColor);

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
        homecon.setBackground(frameColor);
        homecon.setLayout(null);

        // greetings
        wellcome = new JLabel("welcome sir");
        wellcome.setBounds(100, 10, 100, 20);
        homecon.add(wellcome);

        // add rooms button;
        addroom = new JButton("ADD ROOM");
        addroom.setBounds(30, 40, 100, 20);
        addroom.addActionListener(this);
        addroom.setBackground(buttoncColor);
        homecon.add(addroom);

        // view rooms button;
        viewrooms = new JButton("VIEW ROOM");
        viewrooms.setBounds(140, 40, 110, 20);
        viewrooms.addActionListener(this);
        viewrooms.setBackground(buttoncColor);

        homecon.add(viewrooms);

        // booking button;
        booking = new JButton("BOOK");
        booking.setBounds(30, 70, 220, 20);
        booking.addActionListener(this);
        booking.setBackground(buttoncColor);

        homecon.add(booking);

        // CHECKOUT BUTTON
        CHECKOUT = new JButton("CHECKOUT");
        CHECKOUT.setBounds(30, 100, 220, 20);
        CHECKOUT.addActionListener(this);
        CHECKOUT.setBackground(buttoncColor);

        homecon.add(CHECKOUT);

        // view clients button
        HISTORY = new JButton("HISTORY");
        HISTORY.setBounds(30, 130, 220, 20);
        HISTORY.addActionListener(this);
        HISTORY.setBackground(buttoncColor);

        homecon.add(HISTORY);

        // ************************************************************************************
        // add room frame
        addroomframe = new JFrame("ALL ROOMS");
        addroomframe.setBounds(800, 300, 300, 400);
        addcon = addroomframe.getContentPane();
        addcon.setLayout(null);
        addcon.setBackground(frameColor);

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
        saveRoom.setBackground(buttoncColor);
        addcon.add(saveRoom);
        saveRoom.addActionListener(this);

        // cancel button
        CANCEL = new JButton("CANCEL");
        CANCEL.setBounds(10, 310, 100, 30);
        CANCEL.setBackground(buttoncColor);

        addcon.add(CANCEL);
        CANCEL.addActionListener(this);

        // ************************************************************************************
        // view rooms frame
        viewroomframe = new JFrame("ALL SAVED ROOMS");
        viewroomframe.setBounds(800, 300, 300, 400);

        viewcon = viewroomframe.getContentPane();
        viewcon.setBackground(frameColor);
        viewcon.setLayout(new BorderLayout());

        // panel area to show rooms
        roomListPanel = new JPanel();
        roomListPanel.setLayout(new BoxLayout(roomListPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(roomListPanel);
        viewcon.add(scrollPane, BorderLayout.CENTER);

        // ************************************************************************************
        // view clients frame
        viewclientframe = new JFrame("ALL BOOKED CLIENTS");
        viewclientframe.setBounds(800, 300, 350, 400); // slightly wider for client info
        viewclientcon = viewclientframe.getContentPane();
        viewclientcon.setBackground(frameColor);

        viewclientcon.setLayout(new BorderLayout());

        // panel area to show clients
        clientListPanel = new JPanel();
        clientListPanel.setLayout(new BoxLayout(clientListPanel, BoxLayout.Y_AXIS));

        JScrollPane clientScrollPane = new JScrollPane(clientListPanel);
        viewclientcon.add(clientScrollPane, BorderLayout.CENTER);
        // ************************************************************************************
        // checkout frame
        checkoutframe = new JFrame("CHECKOUT GUEST");
        checkoutframe.setBounds(800, 300, 300, 200);
        checkoutcon = checkoutframe.getContentPane();
        checkoutcon.setBackground(frameColor);
        checkoutcon.setLayout(null);

        // room number label
        checkoutroomlabel = new JLabel("ENTER ROOM NUMBER:");
        checkoutroomlabel.setBounds(10, 10, 200, 20);
        checkoutcon.add(checkoutroomlabel);

        // room number field
        checkoutroomfield = new JTextField();
        checkoutroomfield.setBounds(10, 35, 250, 25);
        checkoutcon.add(checkoutroomfield);

        // generate bill button
        GENERATEBILL = new JButton("GENERATE BILL");
        GENERATEBILL.setBounds(150, 80, 100, 30);
        GENERATEBILL.setBackground(buttoncColor);
        checkoutcon.add(GENERATEBILL);
        GENERATEBILL.addActionListener(this);

        // cancel button
        JButton checkoutCancel = new JButton("CANCEL");
        checkoutCancel.setBounds(10, 80, 100, 30);
        checkoutCancel.setBackground(buttoncColor);

        checkoutcon.add(checkoutCancel);
        checkoutCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkoutframe.setVisible(false);
                homeframe.setVisible(true);
                checkoutroomfield.setText(""); // clear field
            }
        });

        // ************************************************************************************
        // bill display frame
        billframe = new JFrame("BILLING DETAILS");
        billframe.setBounds(800, 300, 400, 300);
        billcon = billframe.getContentPane();
        billcon.setLayout(null);

        // ************************************************************************************
        // booking frame
        bookinFrame = new JFrame("INSERT GUEST DETAILS");
        bookinFrame.setBounds(800, 300, 300, 400);
        bookcon = bookinFrame.getContentPane();
        bookcon.setLayout(null);

        // guest names
        guestname = new JLabel("ENTER NAMES:");
        guestname.setBounds(10, 10, 200, 20);
        bookcon.add(guestname);

        guestnamee = new JTextField();
        guestnamee.setBounds(10, 35, 250, 25);
        bookcon.add(guestnamee);

        // guest age
        guestage = new JLabel("ENTER AGE:");
        guestage.setBounds(10, 65, 200, 20);
        bookcon.add(guestage);

        guestagee = new JTextField();
        guestagee.setBounds(10, 90, 250, 25);
        bookcon.add(guestagee);

        // Division selection
        JLabel divLabel = new JLabel("SELECT DIVISION:");
        divLabel.setBounds(10, 125, 200, 20);
        bookcon.add(divLabel);

        Divisionbox.setBounds(10, 150, 250, 25);
        bookcon.add(Divisionbox);

        // District selection
        JLabel distLabel = new JLabel("SELECT DISTRICT:");
        distLabel.setBounds(10, 185, 200, 20);
        bookcon.add(distLabel);

        districtBox.setBounds(10, 210, 250, 25);
        bookcon.add(districtBox);

        // guest phone number
        phoneno = new JLabel("ENTER PHONE NUMBER:");
        phoneno.setBounds(10, 240, 200, 20);
        bookcon.add(phoneno);

        phonenoo = new JTextField();
        phonenoo.setBounds(10, 265, 250, 25);
        bookcon.add(phonenoo);

        // guest nid number
        nidno = new JLabel("ENTER NID NUMBER:");
        nidno.setBounds(10, 295, 200, 20);
        bookcon.add(nidno);

        nidnoo = new JTextField();
        nidnoo.setBounds(10, 320, 250, 25);
        bookcon.add(nidnoo);

        // booked room number
        bookroomno = new JLabel("SELECTED ROOM NUMBER:");
        bookroomno.setBounds(10, 350, 200, 20);
        bookcon.add(bookroomno);

        bookroomnoo = new JTextField();
        bookroomnoo.setBounds(10, 375, 250, 25);
        bookcon.add(bookroomnoo);

        // save guest data button
        addguest = new JButton("DONE");
        addguest.setBounds(150, 410, 100, 30);
        bookcon.add(addguest);
        addguest.addActionListener(this);

        // cancel button
        CANCEL = new JButton("CANCEL");
        CANCEL.setBounds(10, 410, 100, 30);
        bookcon.add(CANCEL);
        CANCEL.addActionListener(this);

        // make bookcon report a taller preferred size so JScrollPane knows it should
        // scroll
        bookcon.setPreferredSize(new Dimension(320, 450)); // <- increase height until scroll works for you

        JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // put the content pane into the viewport
        scrollPane2.setViewportView(bookcon);

        // replace the frame content pane with the scroll pane
        bookinFrame.setContentPane(scrollPane2);

        // refresh frame
        bookinFrame.revalidate();
        bookinFrame.repaint();

        // When a division is selected, update the district list
        Divisionbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDivision = (String) Divisionbox.getSelectedItem();
                String[] districts = divisionDistrictMap.get(selectedDivision);

                districtBox.removeAllItems(); // clear previous districts

                if (districts != null) {
                    for (String d : districts) {
                        districtBox.addItem(d);
                    }
                }
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        String key = ((JButton) e.getSource()).getText(); // get button text
        switch (key) {
            case "Log in":
                if (namef.getText().equals("admin") && String.valueOf(passf.getPassword()).equals("0000")) {

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
            case "CHECKOUT":
                Point p5 = homeframe.getLocation();
                checkoutframe.setLocation(p5);

                homeframe.setVisible(false);
                checkoutframe.setVisible(true);
                break;

            case "GENERATE BILL":
                try {
                    int checkoutRoomNum = Integer.parseInt(checkoutroomfield.getText());

                    // Find the client who is currently checked in
                    client clientToCheckout = null;
                    for (client c : clients) {
                        if (c.roomNumber == checkoutRoomNum && c.status.equals("CHECKED IN ✅")) {
                            clientToCheckout = c;
                            break;
                        }
                    }

                    // Validate client exists
                    if (clientToCheckout == null) {
                        JOptionPane.showMessageDialog(checkoutframe,
                                "❌ No active booking found for room " + checkoutRoomNum,
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Calculate days stayed
                    LocalDate checkoutDate = LocalDate.now();
                    long daysStayed = ChronoUnit.DAYS.between(clientToCheckout.checkInDate, checkoutDate);

                    // Handle same-day checkout (minimum 1 day charge)
                    if (daysStayed == 0) {
                        daysStayed = 1;
                    }

                    // Find room to get price
                    Room bookedRoom = null;
                    for (Room r : rooms) {
                        if (r.roomNumber == checkoutRoomNum) {
                            bookedRoom = r;
                            break;
                        }
                    }

                    // Calculate total bill
                    double totalBill = daysStayed * bookedRoom.price;

                    // Update client status
                    clientToCheckout.status = "CHECKED OUT ⚪";
                    clientToCheckout.days = (int) daysStayed; // update actual days stayed

                    // Make room available
                    bookedRoom.AVAILABILITY = "AVAILABLE ✅";

                    // Display bill
                    billcon.removeAll(); // clear previous bill

                    JLabel billTitle = new JLabel("═══════ CHECKOUT BILL ═══════");
                    billTitle.setFont(new Font("Monospaced", Font.BOLD, 16));
                    billTitle.setBounds(60, 10, 300, 30);
                    billcon.add(billTitle);

                    JLabel guestNameLabel = new JLabel("Guest Name: " + clientToCheckout.name);
                    guestNameLabel.setBounds(20, 50, 350, 25);
                    billcon.add(guestNameLabel);

                    JLabel roomNumLabel = new JLabel("Room Number: " + checkoutRoomNum);
                    roomNumLabel.setBounds(20, 80, 350, 25);
                    billcon.add(roomNumLabel);

                    JLabel checkInLabel = new JLabel("Check-In Date: " + clientToCheckout.checkInDate);
                    checkInLabel.setBounds(20, 110, 350, 25);
                    billcon.add(checkInLabel);

                    JLabel checkOutLabel = new JLabel("Check-Out Date: " + checkoutDate);
                    checkOutLabel.setBounds(20, 140, 350, 25);
                    billcon.add(checkOutLabel);

                    JLabel daysLabel = new JLabel("Days Stayed: " + daysStayed + " day(s)");
                    daysLabel.setBounds(20, 170, 350, 25);
                    billcon.add(daysLabel);

                    JLabel rateLabel = new JLabel("Rate per Day: " + bookedRoom.price + " ৳");
                    rateLabel.setBounds(20, 200, 350, 25);
                    billcon.add(rateLabel);

                    JLabel totalLabel = new JLabel("TOTAL BILL: " + totalBill + " ৳");
                    totalLabel.setFont(new Font("Arial", Font.BOLD, 18));
                    totalLabel.setForeground(new Color(0, 128, 0)); // green color
                    totalLabel.setBounds(20, 230, 350, 30);
                    billcon.add(totalLabel);

                    JButton closeButton = new JButton("CLOSE");
                    closeButton.setBounds(140, 270, 100, 30);
                    closeButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            billframe.setVisible(false);
                            homeframe.setVisible(true);
                            checkoutroomfield.setText(""); // clear checkout field
                        }
                    });
                    billcon.add(closeButton);

                    billcon.revalidate();
                    billcon.repaint();

                    // Hide checkout frame and show bill
                    checkoutframe.setVisible(false);
                    homeframe.setVisible(true);
                    Point p6 = checkoutframe.getLocation();
                    billframe.setLocation(p6);
                    billframe.setVisible(true);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(checkoutframe,
                            "❌ Please enter a valid room number!",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(checkoutframe,
                            "❌ Error: " + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "VIEW ROOM":
                if (rooms.isEmpty()) {
                    JOptionPane.showMessageDialog(homeframe, "No rooms have been added yet.");
                } else {
                    roomListPanel.removeAll(); // clear old content

                    for (Room r : rooms) {
                        card = new JPanel();
                        card.setLayout(new GridLayout(6, 1));
                        card.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
                        card.setBackground(new Color(230, 240, 255)); // light blue background
                        card.add(new JLabel("Room No: " + r.roomNumber));
                        card.add(new JLabel("Type: " + r.type));
                        card.add(new JLabel("AC: " + r.acStatus));
                        card.add(new JLabel("Balcony: " + r.balconyStatus));
                        card.add(new JLabel("Price: " + r.price + " ৳"));
                        card.add(new JLabel("Status: " + r.AVAILABILITY));
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
            case "BOOK":
                Point p3 = homeframe.getLocation();
                bookinFrame.setLocation(p3);

                homeframe.setVisible(false); // hide login window
                bookinFrame.setVisible(true); // makes the frame visible
                break;
            case "HISTORY":
                if (clients.isEmpty()) {
                    JOptionPane.showMessageDialog(homeframe, "No clients have been booked yet.");
                } else {
                    clientListPanel.removeAll(); // clear old content

                    for (client c : clients) {
                        JPanel clientCard = new JPanel();
                        clientCard.setLayout(new GridLayout(9, 1)); // 8 rows for all info
                        clientCard.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
                        clientCard.setBackground(new Color(255, 240, 230)); // light orange background

                        if (c.status.equals("CHECKED IN ✅")) {
                            clientCard.setBackground(new Color(200, 255, 200)); // Green = Active
                        } else {
                            clientCard.setBackground(new Color(220, 220, 220)); // Gray = Checked out
                        }

                        clientCard.add(new JLabel(" 👤 Guest: " + c.name));
                        clientCard.add(new JLabel(" 🎂 Age: " + c.age));
                        clientCard.add(new JLabel(" 📍 Location: " + c.district + ", " + c.division));
                        clientCard.add(new JLabel(" 📞 Phone: " + c.phone));
                        clientCard.add(new JLabel(" 🆔 NID: " + c.nid));
                        clientCard.add(new JLabel(" 🏠 Room No: " + c.roomNumber));
                        clientCard.add(new JLabel(" 📊 Status: " + c.status));
                        clientListPanel.add(clientCard);
                        clientListPanel.add(Box.createVerticalStrut(10)); // space between cards
                    }

                    clientListPanel.revalidate();
                    clientListPanel.repaint();

                    // position the frame nicely
                    Point p4 = homeframe.getLocation();
                    viewclientframe.setLocation(p4);
                    viewclientframe.setVisible(true);
                }
                break;
            case "DONE":
                try {
                    String name = guestnamee.getText();
                    int age = Integer.parseInt(guestagee.getText());
                    String div = (String) Divisionbox.getSelectedItem();
                    String dist = (String) districtBox.getSelectedItem();
                    String phnum = phonenoo.getText();
                    String nidnum = nidnoo.getText();
                    int roomnum = Integer.parseInt(bookroomnoo.getText());

                    // searching by room number
                    Room selectedRoom = null;
                    for (Room r : rooms) {
                        if (r.roomNumber == roomnum) {
                            selectedRoom = r;
                            break; // room found
                        }
                    }

                    // room not found error
                    if (selectedRoom == null) {
                        JOptionPane.showMessageDialog(bookinFrame,
                                "❌ Room number " + roomnum + " does not exist!",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // 🔍 STEP 3: Check if room is already booked
                    if (!selectedRoom.AVAILABILITY.equals("AVAILABLE ✅")) {
                        JOptionPane.showMessageDialog(bookinFrame,
                                "❌ Room " + roomnum + " is already booked!",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Update room availability
                    selectedRoom.AVAILABILITY = "NOT AVAILABLE ❌";

                    // Create client and add to list
                    client newclient = new client(name, age, div, dist, phnum, nidnum, roomnum);
                    clients.add(newclient);

                    JOptionPane.showMessageDialog(bookinFrame,
                            "✅ Room " + roomnum + " booked successfully for " + name + "!");

                    // clear fields
                    guestnamee.setText("");
                    guestagee.setText("");
                    phonenoo.setText("");
                    nidnoo.setText("");
                    bookroomnoo.setText("");

                    homeframe.setVisible(true);
                    bookinFrame.setVisible(false);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(bookinFrame,
                            "❌ Please enter valid inputs!",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(bookinFrame,
                            "❌ Error booking room: " + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
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

    // room details store class
    public class Room {
        String type;
        String acStatus;
        String balconyStatus;
        double price;
        int roomNumber;
        String AVAILABILITY = "AVAILABLE ✅";

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

    // clients details store class
    public class client {
        String name, district, division, phone, nid;
        int age;
        int roomNumber;
        String status; // ← ADD THIS
        LocalDate checkInDate;
        int days;

        client(String name, int age, String division, String district, String phone, String nid, int roomNumber) {
            this.name = name;
            this.age = age;
            this.division = division;
            this.district = district;
            this.phone = phone;
            this.nid = nid;
            this.roomNumber = roomNumber;
            this.status = "CHECKED IN ✅";
            this.checkInDate = LocalDate.now();
        }

        @Override
        public String toString() {
            return "client: " + name + " | Phone: " + phone + " | Room: " + roomNumber + " | Status: " + status;
        }
    }

}