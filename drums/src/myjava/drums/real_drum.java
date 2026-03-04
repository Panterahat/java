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
    JButton kick1, kick2, snare, tom1, tom2, tom3, crash, crash2, splash, ride, openhh, closehh, floor, modeBtn,
            settings, play,
            buttonkey, elementchangeb;
    JLabel buttonmapping, elementchangel;
    JTextField[] elements = new JTextField[12];
    JTextField[] keys = new JTextField[12];

    String[] drumNames = {
            "KICK", "SNARE", "CLOSE HH", "FLOOR",
            "OPEN HH", "TOM1", "TOM2", "TOM3",
            "CRASH", "SPLASH", "RIDE", "KICK2",
            "CRASH 2"
    };

    @SuppressWarnings("unchecked")
    JComboBox<String>[] equipmentBoxes = new JComboBox[12];

    String[] defaultKeys = {
            "A", "S", "D", "F",
            "Z", "Q", "W", "E",
            "R", "T", "Y", "U"
    };

    String[] BPMTYPES = {
            "1", "2", "3", "4"
    };

    Color buttColor = new Color(156, 213, 255);

    HashMap<Integer, String> keyMap = new HashMap<>();
    {
        keyMap.put(KeyEvent.VK_Z, "KICK.wav");
        keyMap.put(KeyEvent.VK_A, "KICK.wav");
        keyMap.put(KeyEvent.VK_S, "SNARE 2.wav");
        keyMap.put(KeyEvent.VK_D, "CLOSE HH.wav");
        keyMap.put(KeyEvent.VK_F, "FLOOR2.wav");
        keyMap.put(KeyEvent.VK_G, "OPEN HH.wav");
        keyMap.put(KeyEvent.VK_H, "RIDE.wav");
        keyMap.put(KeyEvent.VK_J, "CRASH 2.wav");
        keyMap.put(KeyEvent.VK_R, "TOM 1.wav");
        keyMap.put(KeyEvent.VK_T, "TOM 2.wav");
        keyMap.put(KeyEvent.VK_Y, "TOM 3.wav");
        keyMap.put(KeyEvent.VK_U, "CRASH.wav");
        keyMap.put(KeyEvent.VK_I, "SPLASH.wav");

    }

    boolean keyboardMode = false;
    boolean playing = false;
    Timer beatTimer;

    int bpm, beatDelay, beattype, step = 0;

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

        // TOP CONTROL PANEL
        JPanel topPanel = new JPanel();
        topPanel.setBounds(0, 0, 1000, 45);
        topPanel.setLayout(null);
        topPanel.setBackground(new Color(45, 45, 45)); // optional dark header
        mainc.add(topPanel);

        // kick drum
        kick1 = new JButton("KICK");
        kick1.setBounds(250, 300, 200, 100);
        kick1.setFocusable(false);
        kick1.setBackground(buttColor);
        mainc.add(kick1);
        kick1.addActionListener(this);

        kick2 = new JButton("KICK");
        kick2.setBounds(500, 300, 200, 100);
        kick2.setFocusable(false);
        kick2.setBackground(buttColor);
        mainc.add(kick2);
        kick2.addActionListener(this);

        // snare drum
        snare = new JButton("SNARE");
        snare.setBounds(375, 170, 200, 100);
        snare.setFocusable(false);
        snare.setBackground(buttColor);
        mainc.add(snare);
        snare.addActionListener(this);

        // floor drum
        floor = new JButton("FLOOR");
        floor.setBounds(30, 300, 200, 100);
        floor.setFocusable(false);
        floor.setBackground(buttColor);
        mainc.add(floor);
        floor.addActionListener(this);

        // closehh drum
        closehh = new JButton("CLOSE HH");
        closehh.setBounds(730, 170, 200, 110);
        closehh.setFocusable(false);
        closehh.setBackground(buttColor);
        mainc.add(closehh);
        closehh.addActionListener(this);

        // openhh drum
        openhh = new JButton("OPEN HH");
        openhh.setBounds(730, 290, 200, 110);
        openhh.setFocusable(false);
        openhh.setBackground(buttColor);
        mainc.add(openhh);
        openhh.addActionListener(this);

        // ride drum
        ride = new JButton("RIDE");
        ride.setBounds(730, 50, 200, 100);
        ride.setFocusable(false);
        ride.setBackground(buttColor);
        mainc.add(ride);
        ride.addActionListener(this);

        // crash drum
        crash = new JButton("CRASH");
        crash.setBounds(30, 50, 200, 100);
        crash.setFocusable(false);
        crash.setBackground(buttColor);
        mainc.add(crash);
        crash.addActionListener(this);

        // crash drum
        crash2 = new JButton("CRASH 2");
        crash2.setBounds(30, 170, 200, 100);
        crash2.setFocusable(false);
        crash2.setBackground(buttColor);
        mainc.add(crash2);
        crash2.addActionListener(this);

        // splash drum
        splash = new JButton("SPLASH");
        splash.setBounds(250, 50, 200, 100);
        splash.setFocusable(false);
        splash.setBackground(buttColor);
        mainc.add(splash);
        splash.addActionListener(this);

        // tom1 drum
        tom1 = new JButton("TOM1");
        tom1.setBounds(460, 50, 115, 100);
        tom1.setFocusable(false);
        tom1.setBackground(buttColor);
        mainc.add(tom1);
        tom1.addActionListener(this);

        // tom2 drum
        tom2 = new JButton("TOM2");
        tom2.setBounds(590, 50, 115, 100);
        tom2.setFocusable(false);
        tom2.setBackground(buttColor);
        mainc.add(tom2);
        tom2.addActionListener(this);

        // tom3 drum
        tom3 = new JButton("TOM3");
        tom3.setBounds(590, 170, 115, 100);
        tom3.setFocusable(false);
        tom3.setBackground(buttColor);
        mainc.add(tom3);
        tom3.addActionListener(this);

        // settings button
        settings = new JButton("SETTINGS");
        settings.setBounds(30, 10, 200, 30);
        settings.setFocusable(false);
        settings.setBackground(buttColor);
        topPanel.add(settings);
        settings.addActionListener(e -> {
            Point p1 = mainf.getLocation();
            settingsf.setLocation(p1);
            settingsf.setVisible(true);
            mainf.setVisible(false);
        });

        // mode button
        modeBtn = new JButton("MODE: MOUSE");
        modeBtn.setBounds(730, 10, 200, 30);
        modeBtn.setFocusable(false);
        modeBtn.setBackground(buttColor);
        topPanel.add(modeBtn);

        modeBtn.addActionListener(e -> {
            keyboardMode = !keyboardMode;

            if (keyboardMode) {
                modeBtn.setText("MODE: KEYBOARD");
                mainf.requestFocus(); // keyboard needs focus
            } else {
                modeBtn.setText("MODE: MOUSE");
            }
        });

        // text field for BPM speed
        JTextField BPM = new JTextField();
        BPM.setBounds(295, 10, 53, 30);
        BPM.setText("120");
        topPanel.add(BPM);

        // speed down button
        JButton speeddown = new JButton("-");
        speeddown.setBounds(250, 10, 45, 30);
        speeddown.setFocusable(false);
        speeddown.setBackground(buttColor);
        topPanel.add(speeddown);

        speeddown.addActionListener(e -> {
            bpm = Integer.parseInt(BPM.getText());
            bpm = bpm - 5;
            if (bpm < 0)
                bpm = 0; // prevents negative BPM
            BPM.setText(String.valueOf(bpm));
        });

        // speed up button
        JButton speedup = new JButton("+");
        speedup.setBounds(345, 10, 45, 30);
        speedup.setFocusable(false);
        speedup.setBackground(buttColor);
        topPanel.add(speedup);

        speedup.addActionListener(e -> {
            bpm = Integer.parseInt(BPM.getText());
            bpm = bpm + 5;
            BPM.setText(String.valueOf(bpm));
        });

        mainf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // drop down menu for BPM types
        JComboBox<String> BPMTYPE = new JComboBox<>(BPMTYPES);
        BPMTYPE.setBounds(390, 10, 105, 30);
        topPanel.add(BPMTYPE);

        mainf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // play button
        play = new JButton("▶️");
        play.setBounds(495, 10, 80, 30);
        play.setFocusable(false);
        play.setBackground(buttColor);
        topPanel.add(play);
        play.addActionListener(e -> {
            bpm = Integer.parseInt((String) BPM.getText());
            beattype = Integer.parseInt((String) BPMTYPE.getSelectedItem());
            beatDelay = 60000 / bpm;

            beatTimer.setDelay(beatDelay);

            playing = !playing;

            if (playing) {
                play.setText("⏸️");
                step = 0;
                beatTimer.start();
                mainf.requestFocus();
            } else {
                play.setText("▶️");
                beatTimer.stop();
            }
        });

        beatTimer = new Timer(0, e -> {
            if (!playing)
                return;

            switch (beattype) {
                case 1:
                    playSound("KICK.wav"); // metronome
                    break;

                case 2:
                    if (step % 2 == 0)
                        playSound("KICK.wav");
                    if (step % 2 == 1)
                        playSound("CLOSE HH.wav");
                    step++;
                    break;
                case 3:
                    if (step % 4 == 0)
                        playSound("KICK.wav");
                    if (step % 4 == 1)
                        playSound("CLOSE HH.wav");
                    if (step % 4 == 2)
                        playSound("SNARE 2.wav");
                    if (step % 4 == 3)
                        playSound("CLOSE HH.wav");
                    step++;
                    break;
            }
        });

        // button hit animation

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
        // backBtn.addActionListener(this);
        backBtn.addActionListener(e -> {
            Point p2 = settingsf.getLocation();
            mainf.setLocation(p2);
            settingsf.setVisible(false);
            mainf.setVisible(true);
        });
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

        // eqipment change map
        int u = 70, v = 70;

        // drop down menu for equipment

        for (int i = 0; i < 12; i++) {
            if (i < 6) {
                elements[i] = new JTextField(drumNames[i]);
                elements[i].setBounds(150, u, 120, 30);
                elements[i].setEditable(false);
                elementchangec.add(elements[i]);
                equipmentBoxes[i] = new JComboBox<>(drumNames);
                equipmentBoxes[i].setBounds(280, u, 100, 30);
                equipmentBoxes[i].setSelectedItem(elements[i].getText());
                elementchangec.add(equipmentBoxes[i]);
                u += 40;
            } else {
                elements[i] = new JTextField(drumNames[i]);
                elements[i].setBounds(630, v, 120, 30);
                elements[i].setEditable(false);
                elementchangec.add(elements[i]);
                equipmentBoxes[i] = new JComboBox<>(drumNames);
                equipmentBoxes[i].setBounds(760, v, 100, 30);
                equipmentBoxes[i].setSelectedItem(elements[i].getText());
                elementchangec.add(equipmentBoxes[i]);
                v += 40;
            }
        }
        // confirm button
        JButton confirmEquipBtn = new JButton("CONFIRM");
        confirmEquipBtn.setBounds(460, 400, 100, 30);
        confirmEquipBtn.setFocusable(false);
        confirmEquipBtn.addActionListener(this);
        elementchangec.add(confirmEquipBtn);

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
                animateButton(kick1);
                animateButton(kick2);
                break;
            case "SNARE":
                playSound("SNARE 2.wav");
                animateButton(snare);
                break;
            case "CLOSE HH":
                playSound("CLOSE HH.wav");
                animateButton(closehh);
                break;
            case "OPEN HH":
                playSound("OPEN HH.wav");
                animateButton(openhh);
                break;
            case "TOM1":
                playSound("TOM 1.wav");
                animateButton(tom1);
                break;
            case "TOM2":
                playSound("TOM 2.wav");
                animateButton(tom2);
                break;
            case "TOM3":
                playSound("TOM 3.wav");
                animateButton(tom3);
                break;
            case "CRASH 2":
                playSound("CRASH 2.wav");
                animateButton(crash2);
                break;
            case "FLOOR":
                playSound("FLOOR2.wav");
                animateButton(floor);
                break;
            case "CRASH":
                playSound("CRASH.wav");
                animateButton(crash);
                break;
            case "SPLASH":
                playSound("SPLASH.wav");
                animateButton(splash);
                break;
            case "RIDE":
                playSound("RIDE.wav");
                animateButton(ride);
                break;
            // case "SETTINGS":
            // Point p1 = mainf.getLocation();
            // settingsf.setLocation(p1);
            // settingsf.setVisible(true);
            // mainf.setVisible(false);
            // break;
            // case "← Back":
            // Point p2 = settingsf.getLocation();
            // mainf.setLocation(p2);
            // settingsf.setVisible(false);
            // mainf.setVisible(true);
            // break;
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
            case "CONFIRM":
                saveEquipmentChanges();
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
            String sound = keyMap.get(keyCode);
            playSound(sound);
            animateBySound(sound);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    void saveEquipmentChanges() {

        // 1️⃣ Read selections from combo boxes → drumNames
        for (int i = 0; i < 12; i++) {
            String selected = (String) equipmentBoxes[i].getSelectedItem();

            if (selected == null || selected.isEmpty()) {
                JOptionPane.showMessageDialog(
                        elementchangef,
                        "Invalid selection at position " + (i + 1));
                return;
            }

            drumNames[i] = selected;
        }

        // 2️⃣ Update MAIN SCREEN buttons
        kick1.setText(drumNames[0]);
        snare.setText(drumNames[1]);
        closehh.setText(drumNames[2]);
        floor.setText(drumNames[3]);
        openhh.setText(drumNames[4]);
        tom1.setText(drumNames[5]);
        tom2.setText(drumNames[6]);
        tom3.setText(drumNames[7]);
        crash.setText(drumNames[8]);
        splash.setText(drumNames[9]);
        ride.setText(drumNames[10]);
        kick2.setText(drumNames[11]);
        crash2.setText(drumNames[12]);

        // 3️⃣ Update BUTTON-KEY CHANGE FRAME labels
        for (int i = 0; i < 12; i++) {
            elements[i].setText(drumNames[i]);
        }

        // 4️⃣ Sync equipment screen again (combo + textfield)
        for (int i = 0; i < 12; i++) {
            equipmentBoxes[i].setSelectedItem(drumNames[i]);
        }

        JOptionPane.showMessageDialog(
                elementchangef,
                "Equipment changes saved successfully!");
    }

    void animateBySound(String sound) {
        switch (sound) {
            case "KICK.wav":
                animateButton(kick1);
                animateButton(kick2);
                break;

            case "SNARE 2.wav":
                animateButton(snare);
                break;

            case "CLOSE HH.wav":
                animateButton(closehh);
                break;

            case "FLOOR2.wav":
                animateButton(floor);
                break;

            case "OPEN HH.wav":
                animateButton(openhh);
                break;

            case "CRASH.wav":
                animateButton(crash);
                break;

            case "CRASH 2.wav":
                animateButton(crash2);
                break;

            case "SPLASH.wav":
                animateButton(splash);
                break;

            case "RIDE.wav":
                animateButton(ride);
                break;

            case "TOM 1.wav":
                animateButton(tom1);
                break;

            case "TOM 2.wav":
                animateButton(tom2);
                break;

            case "TOM 3.wav":
                animateButton(tom3);
                break;
        }
    }

    void animateButton(JButton btn) {
        btn.setBackground(Color.ORANGE); // hit color

        Timer t = new Timer(80, e -> {
            btn.setBackground(buttColor);
        });
        t.setRepeats(false);
        t.start();
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
                    getClass().getResource("/sounds/" + fileName));
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
