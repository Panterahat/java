package myjava.drums;

import javax.sound.sampled.*;
import java.io.File;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class real_drum implements ActionListener {
    JFrame mainf;
    Container mainc;
    JButton kick, snare, tom1, tom2, tom3, crash, splash, ride, openhh, closehh, floor;

    real_drum() {
        // main interface
        mainf = new JFrame("REAL DRUM");
        mainf.setBounds(400, 300, 1000, 500);
        mainf.setResizable(false);
        mainc = mainf.getContentPane();

        mainc.setLayout(null); // tells compiler that i will decide where components go
        mainf.setVisible(true);

        // kick drum
        kick = new JButton("KICK");
        kick.setBounds(250, 300, 200, 100);
        mainc.add(kick);
        kick.addActionListener(this);

        kick = new JButton("KICK");
        kick.setBounds(500, 300, 200, 100);
        mainc.add(kick);
        kick.addActionListener(this);

        // snare drum
        snare = new JButton("SNARE");
        snare.setBounds(375, 170, 200, 100);
        mainc.add(snare);
        snare.addActionListener(this);

        // floor drum
        floor = new JButton("FLOOR");
        floor.setBounds(30, 300, 200, 100);
        mainc.add(floor);
        floor.addActionListener(this);

        // closehh drum
        closehh = new JButton("CLOSE HH");
        closehh.setBounds(730, 170, 200, 110);
        mainc.add(closehh);
        closehh.addActionListener(this);

        // openhh drum
        openhh = new JButton("OPEN HH");
        openhh.setBounds(730, 290, 200, 110);
        mainc.add(openhh);
        openhh.addActionListener(this);

        // ride drum
        ride = new JButton("RIDE");
        ride.setBounds(730, 50, 200, 100);
        mainc.add(ride);
        ride.addActionListener(this);

        // crash drum
        crash = new JButton("CRASH");
        crash.setBounds(30, 50, 200, 100);
        mainc.add(crash);
        crash.addActionListener(this);

        // splash drum
        splash = new JButton("SPLASH");
        splash.setBounds(250, 50, 200, 100);
        mainc.add(splash);
        splash.addActionListener(this);

        // tom1 drum
        tom1 = new JButton("TOM1");
        tom1.setBounds(460, 50, 115, 100);
        mainc.add(tom1);
        tom1.addActionListener(this);

        // tom2 drum
        tom2 = new JButton("TOM2");
        tom2.setBounds(590, 50, 115, 100);
        mainc.add(tom2);
        tom2.addActionListener(this);

        // tom3 drum
        tom3 = new JButton("TOM3");
        tom3.setBounds(590, 170, 115, 100);
        mainc.add(tom3);
        tom3.addActionListener(this);

        mainf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {
        String key = ((JButton) e.getSource()).getText(); // get button text
        switch (key) {
            case "KICK":
                playSound("Kick.wav");
            case "CLOSE HH":
                playSound("Hats.wav");
            case "SNARE":
                playSound("Snare.wav");
            case "FLOOR":
                playSound("Clap.wav");

        }
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
