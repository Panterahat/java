package myjava.drums;

import javax.sound.sampled.*;
import java.io.File;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;

public class real_drum implements ActionListener, KeyListener {
    JFrame mainf, settingsf, buttonchangef, elementchangef;
    Container mainc, settingsc, buttonchangec, elementchangec;
    JButton kick1, kick2, snare, tom1, tom2, tom3, crash, splash, ride, openhh, closehh, floor, modeBtn, settings,
            buttonkey, elementchangeb;
    JLabel buttonmapping, elementchangel;
    JTextField[] elements = new JTextField[12];
    JTextField[] keys = new JTextField[12];

    String[] drumNames = {
            "KICK", "SNARE", "CLOSE HH", "FLOOR",
            "OPEN HH", "TOM1", "TOM2", "TOM3",
            "CRASH", "SPLASH", "RIDE", "KICK2"
    };

    String[] defaultKeys = {
            "A", "S", "D", "F",
            "Z", "Q", "W", "E",
            "R", "T", "Y", "U"
    };

    HashMap<Integer, String> keyMap = new HashMap<>();
    {
        keyMap.put(KeyEvent.VK_A, "KICK.wav");
        keyMap.put(KeyEvent.VK_Z, "KICK.wav");
        keyMap.put(KeyEvent.VK_S, "SNARE.wav");
        keyMap.put(KeyEvent.VK_D, "CLOSE HH.wav");
        keyMap.put(KeyEvent.VK_F, "FLOOR.wav");
    }

    boolean keyboardMode = false;

    real_drum() {
        // main
        // interface*******************************************************************************
        mainf = new JFrame("REAL DRUM");
        mainf.setBounds(400, 300, 1000, 500);
        mainf.setResizable(false);
        mainc = mainf.getContentPane();

        mainc.setLayout(null); // tells compiler that i will decide where components go
        mainf.setVisible(true);
        mainf.addKeyListener(this);
        mainf.setFocusable(true);
        mainf.requestFocus();

        // kick drum
        kick1 = new JButton("KICK");
        kick1.setBounds(250, 300, 200, 100);
        kick1.setFocusable(false);
        mainc.add(kick1);
        kick1.addActionListener(this);

        kick2 = new JButton("KICK");
        kick2.setBounds(500, 300, 200, 100);
        kick2.setFocusable(false);
        mainc.add(kick2);
        kick2.addActionListener(this);

        // snare drum
        snare = new JButton("SNARE");
        snare.setBounds(375, 170, 200, 100);
        snare.setFocusable(false);
        mainc.add(snare);
        snare.addActionListener(this);

        // floor drum
        floor = new JButton("FLOOR");
        floor.setBounds(30, 300, 200, 100);
        floor.setFocusable(false);
        mainc.add(floor);
        floor.addActionListener(this);

        // closehh drum
        closehh = new JButton("CLOSE HH");
        closehh.setBounds(730, 170, 200, 110);
        closehh.setFocusable(false);
        mainc.add(closehh);
        closehh.addActionListener(this);

        // openhh drum
        openhh = new JButton("OPEN HH");
        openhh.setBounds(730, 290, 200, 110);
        openhh.setFocusable(false);
        mainc.add(openhh);
        openhh.addActionListener(this);

        // ride drum
        ride = new JButton("RIDE");
        ride.setBounds(730, 50, 200, 100);
        ride.setFocusable(false);
        mainc.add(ride);
        ride.addActionListener(this);

        // crash drum
        crash = new JButton("CRASH");
        crash.setBounds(30, 50, 200, 100);
        crash.setFocusable(false);
        mainc.add(crash);
        crash.addActionListener(this);

        // splash drum
        splash = new JButton("SPLASH");
        splash.setBounds(250, 50, 200, 100);
        splash.setFocusable(false);
        mainc.add(splash);
        splash.addActionListener(this);

        // tom1 drum
        tom1 = new JButton("TOM1");
        tom1.setBounds(460, 50, 115, 100);
        tom1.setFocusable(false);
        mainc.add(tom1);
        tom1.addActionListener(this);

        // tom2 drum
        tom2 = new JButton("TOM2");
        tom2.setBounds(590, 50, 115, 100);
        tom2.setFocusable(false);
        mainc.add(tom2);
        tom2.addActionListener(this);

        // tom3 drum
        tom3 = new JButton("TOM3");
        tom3.setBounds(590, 170, 115, 100);
        tom3.setFocusable(false);
        mainc.add(tom3);
        tom3.addActionListener(this);

        // settings button
        settings = new JButton("SETTINGS");
        settings.setBounds(30, 10, 200, 30);
        settings.setFocusable(false);
        mainc.add(settings);
        settings.addActionListener(this);

        // mode button
        modeBtn = new JButton("MODE: MOUSE");
        modeBtn.setBounds(730, 10, 200, 30);
        modeBtn.setFocusable(false);
        mainc.add(modeBtn);

        modeBtn.addActionListener(e -> {
            keyboardMode = !keyboardMode;

            if (keyboardMode) {
                modeBtn.setText("MODE: KEYBOARD");
                mainf.requestFocus(); // keyboard needs focus
            } else {
                modeBtn.setText("MODE: MOUSE");
            }
        });

        mainf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // settings
        // interface*****************************************************************************************
        settingsf = new JFrame("SETTINGS");
        settingsf.setBounds(400, 300, 1000, 500);
        settingsf.setResizable(false);
        settingsc = settingsf.getContentPane();

        settingsc.setLayout(null); // tells compiler that i will decide where components go
        // settingsf.setVisible(true);

        // HEADER PANEL
        JPanel header1 = new JPanel();
        header1.setBounds(0, 0, 1000, 60);
        header1.setLayout(null);
        header1.setBackground(new Color(45, 45, 45)); // dark header
        settingsc.add(header1);

        // back buttom
        JButton backBtn = new JButton("← Back");
        backBtn.setBounds(10, 15, 90, 30);
        // backBtn.setFocusable(false);
        backBtn.addActionListener(this);
        backBtn.setBackground(Color.WHITE);
        backBtn.setForeground(Color.black);
        backBtn.setBorder(BorderFactory.createLineBorder(new Color(90, 90, 90)));
        backBtn.setFocusPainted(false);
        header1.add(backBtn);

        // changing buttons lebel
        buttonmapping = new JLabel("BUTTON KEY MAPPING :");
        buttonmapping.setBounds(10, 80, 180, 25);
        settingsc.add(buttonmapping);

        // BUTTON KEY MAPPER button
        buttonkey = new JButton("CHANGE");
        buttonkey.setBounds(160, 80, 200, 25);
        buttonkey.setFocusable(false);
        settingsc.add(buttonkey);
        buttonkey.addActionListener(this);

        // changing equipment lebel
        elementchangel = new JLabel("CHANGE EQUIPMENTS :");
        elementchangel.setBounds(10, 110, 180, 25);
        settingsc.add(elementchangel);

        // changing equipment button
        elementchangeb = new JButton("CHANGE ");
        elementchangeb.setBounds(160, 110, 200, 25);
        elementchangeb.setFocusable(false);
        settingsc.add(elementchangeb);
        elementchangeb.addActionListener(this);

        settingsf.addKeyListener(this);
        // settingsf.setFocusable(true);
        // settingsf.requestFocus();

        // BUTTON CHANGE
        // INTERFACE********************************************************************************************
        buttonchangef = new JFrame("BUTTON KEY SET");
        buttonchangef.setBounds(400, 300, 1000, 500);
        buttonchangef.setResizable(false);
        buttonchangec = buttonchangef.getContentPane();

        buttonchangec.setLayout(null); // tells compiler that i will decide where components go
        buttonchangef.setVisible(false);
        buttonchangef.addKeyListener(this);
        buttonchangef.setFocusable(true);
        buttonchangef.requestFocus();

        // HEADER PANEL
        JPanel header2 = new JPanel();
        header2.setBounds(0, 0, 1000, 60);
        header2.setLayout(null);
        header2.setBackground(new Color(45, 45, 45)); // dark header
        buttonchangec.add(header2);

        // back to settings buttom
        JButton back2settingsBtn = new JButton("← Settings");
        back2settingsBtn.setBounds(10, 15, 90, 30);
        // backBtn.setFocusable(false);
        back2settingsBtn.addActionListener(this);
        back2settingsBtn.setBackground(Color.WHITE);
        back2settingsBtn.setForeground(Color.black);
        back2settingsBtn.setBorder(BorderFactory.createLineBorder(new Color(90, 90, 90)));
        back2settingsBtn.setFocusPainted(false);
        header2.add(back2settingsBtn);

        // button change
        // map*************************************************************************

        int y = 70, z = 70;

        for (int i = 0; i < 12; i++) {
            if (i < 6) {
                elements[i] = new JTextField(drumNames[i]);
                elements[i].setBounds(150, y, 120, 30);
                elements[i].setEditable(false);
                buttonchangec.add(elements[i]);

                keys[i] = new JTextField(defaultKeys[i]);
                keys[i].setBounds(290, y, 50, 30);
                buttonchangec.add(keys[i]);

                y += 40;
            } else {
                elements[i] = new JTextField(drumNames[i]);
                elements[i].setBounds(630, z, 120, 30);
                elements[i].setEditable(false);
                buttonchangec.add(elements[i]);

                keys[i] = new JTextField(defaultKeys[i]);
                keys[i].setBounds(770, z, 50, 30);
                buttonchangec.add(keys[i]);

                z += 40;
            }
        }

        JButton saveBtn = new JButton("SAVE");
        saveBtn.setBounds(460, 400, 80, 30);
        saveBtn.addActionListener(this);
        buttonchangec.add(saveBtn);

        // EQUIPMENTS CHANGE
        // INTERFACE*********************************************************************************
        elementchangef = new JFrame("EQUIPMENT CHANGE");
        elementchangef.setBounds(400, 300, 1000, 500);
        elementchangef.setResizable(false);
        elementchangec = elementchangef.getContentPane();

        elementchangec.setLayout(null); // tells compiler that i will decide where components go
        elementchangef.setVisible(false);
        elementchangef.addKeyListener(this);
        elementchangef.setFocusable(true);
        elementchangef.requestFocus();

        // HEADER PANEL
        JPanel header3 = new JPanel();
        header3.setBounds(0, 0, 1000, 60);
        header3.setLayout(null);
        header3.setBackground(new Color(45, 45, 45)); // dark header
        elementchangec.add(header3);

        // back to settings buttom
        JButton back2settingsBtn2 = new JButton("← Settings");
        back2settingsBtn2.setBounds(10, 15, 90, 30);
        back2settingsBtn2.addActionListener(this);
        back2settingsBtn2.setBackground(Color.WHITE);
        back2settingsBtn2.setForeground(Color.black);
        back2settingsBtn2.setBorder(BorderFactory.createLineBorder(new Color(90, 90, 90)));
        back2settingsBtn2.setFocusPainted(false);

        header3.add(back2settingsBtn2);

        // // back buttom
        // back = new JButton("<=");
        // back.setBounds(10, 10, 50, 30);
        // back.setFocusable(false);
        // settingsc.add(back);
        // back.addActionListener(this);

        // // BUTTON KEY MAPPER
        // btk = new JButton("SET KEY");
        // btk.setBounds(250, 300, 200, 100);
        // btk.setFocusable(false);
        // settingsc.add(btk);
        // btk.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (keyboardMode)
            return; // ignore mouse clicks

        String key = ((JButton) e.getSource()).getText();

        switch (key) {
            case "KICK":
                playSound("KICK.wav");
                break;
            case "SNARE":
                playSound("SNARE.wav");
                break;
            case "CLOSE HH":
                playSound("CLOSE HH.wav");
                break;
            case "FLOOR":
                playSound("FLOOR.wav");
                break;
            case "SETTINGS":
                Point p1 = mainf.getLocation();
                settingsf.setLocation(p1);
                settingsf.setVisible(true);
                mainf.setVisible(false);
                break;
            case "← Back":
                Point p2 = settingsf.getLocation();
                mainf.setLocation(p2);
                settingsf.setVisible(false);
                mainf.setVisible(true);
                break;
            case "CHANGE":
                Point p3 = settingsf.getLocation();
                buttonchangef.setLocation(p3);
                settingsf.setVisible(false);
                buttonchangef.setVisible(true);
                break;
            case "CHANGE ":
                p3 = settingsf.getLocation();
                elementchangef.setLocation(p3);
                settingsf.setVisible(false);
                elementchangef.setVisible(true);
                break;
            case "← Settings":
                Point p4;
                if (buttonchangef.isVisible()) {
                    p4 = buttonchangef.getLocation();
                    buttonchangef.setVisible(false);
                } else {
                    p4 = elementchangef.getLocation();
                    elementchangef.setVisible(false);
                }
                settingsf.setLocation(p4);
                settingsf.setVisible(true);
                break;
            case "SAVE":
                for (int i = 0; i < 12; i++) {
                    String text = keys[i].getText().toUpperCase();

                    if (text.length() != 1) {
                        JOptionPane.showMessageDialog(
                                buttonchangef,
                                "Enter only ONE key in " + drumNames[i]);
                        return; // stop saving completely
                    }

                    int newKey = KeyEvent.getExtendedKeyCodeForChar(text.charAt(0));
                    if (newKey == KeyEvent.VK_UNDEFINED) {
                        JOptionPane.showMessageDialog(
                                buttonchangef,
                                "Invalid key for " + drumNames[i]);
                        return;
                    }

                    updateKey(drumNames[i], newKey);
                }

                JOptionPane.showMessageDialog(buttonchangef, "All keys updated!");
                break;

        }

    }

    // mainf.requestFocus(); // 👈 keeps keyboard alive

    @Override
    public void keyPressed(KeyEvent e) {
        if (!keyboardMode)
            return;

        int keyCode = e.getKeyCode();

        if (keyMap.containsKey(keyCode)) {
            playSound(keyMap.get(keyCode));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    void updateKey(String drum, int newKey) {
        // Remove any existing key that maps to this drum
        keyMap.entrySet().removeIf(entry -> entry.getValue().equals(drum + ".wav"));

        // Add new key mapping
        keyMap.put(newKey, drum + ".wav");
    }

    void playSound(String fileName) {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(
                    new File("sounds/" + fileName));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new real_drum();
    }

}
