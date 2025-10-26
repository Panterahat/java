package myjava.calculator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class calculator implements ActionListener { // implemented actionlistener class and added the neccessary
                                                    // variables
    int init = 1;
    double num1, num2, result;
    String operator = "";
    JFrame f;
    Container c;
    JLabel lb1, lb2, lb3;
    JTextField tf1, tf2;
    JPanel p;
    JButton[] btn;
    String[] ch = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "%", ".", "+",
            "=", "clear", "ctn", "del"
    };

    // created the constructor to build the interface
    calculator() {

        // this part sets the programs body
        f = new JFrame("my first java program");
        f.setBounds(800, 300, 300, 400);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // this part takes interface of program into c
        c = f.getContentPane();
        c.setBackground(new Color(33, 33, 33)); // #212121
        // c.setBackground(new Color(38, 50, 56)); // #263238
        // c.setBackground(new Color(0, 0, 0)); // #915aaaff
        // c.setBackground(new Color(224, 224, 224)); // #E0E0E0

        c.setLayout(null); // tells compiler that i will decide where components go

        // adds the first number section
        lb1 = new JLabel("number 1");
        lb1.setBounds(10, 10, 100, 30);
        lb1.setForeground(Color.WHITE);

        c.add(lb1);

        tf1 = new JTextField();
        tf1.setBounds(70, 10, 200, 30);
        c.add(tf1);

        // adds the second number section
        lb2 = new JLabel("number 2");
        lb2.setBounds(10, 50, 100, 30);
        lb2.setForeground(Color.WHITE);

        c.add(lb2);

        tf2 = new JTextField();
        tf2.setBounds(70, 50, 200, 30);
        c.add(tf2);

        // adds the results section
        lb3 = new JLabel("Result = ");
        lb3.setBounds(10, 90, 100, 30);
        lb3.setForeground(Color.WHITE);

        c.add(lb3);

        // added the buttons grid
        p = new JPanel();
        p.setLayout(new GridLayout(5, 4, 2, 2));
        p.setBounds(10, 130, 265, 200);
        p.setBackground(Color.BLACK);
        c.add(p);

        // using loop to initialize the buttons
        btn = new JButton[20];
        for (int i = 0; i < 20; i++) {
            btn[i] = new JButton();
            btn[i].setText(ch[i]);
            btn[i].addActionListener(this);
            if (i == 3 || i == 7 || i == 11 || i == 13 || i == 14 || i == 15) {
                btn[i].setBackground(new Color(0, 121, 107));
                btn[i].setForeground(Color.WHITE);
            } else if (i == 16 || i == 17 || i == 18 || i == 19) {
                btn[i].setBackground(new Color(0, 150, 136));
                btn[i].setForeground(Color.WHITE);

            } else {
                btn[i].setBackground(Color.WHITE);
                btn[i].setForeground(Color.BLACK);

            }
            p.add(btn[i]);
        }

        f.setVisible(true); // makes the frame visible

    }

    public void actionPerformed(ActionEvent e) { // adds the action of every button

        String key = ((JButton) e.getSource()).getText(); // get button text
        if (init == 1) {
            switch (key) {
                // digit part
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                    tf1.setText(tf1.getText() + key);
                    break;
                // operator part
                case "+":
                case "-":
                case "*":
                case "/":
                    operator = key;
                    lb3.setText("Operator: " + key);
                    tf2.requestFocusInWindow();
                    init++;
                    break;
                case "%":
                    operator = "%"; // store the operator correctly
                    lb3.setText("Operator: " + key);
                    tf2.requestFocusInWindow();
                    init++;
                    break;

                // point part
                case ".":
                    tf1.setText(tf1.getText() + key);
                    break;
                // clear part
                case "clear":
                    tf1.setText("");
                    tf2.setText("");
                    tf1.requestFocusInWindow();
                    init = 1;
                    lb3.setText("");
                    break;
                // continue part
                case "ctn":
                    tf1.setText("" + result);
                    tf2.setText("");

                    tf2.requestFocusInWindow();
                    break;
                // delete part
                case "del":
                    if (init == 1) {
                        String text = tf1.getText();
                        if (text.length() > 0) {
                            tf1.setText(text.substring(0, text.length() - 1));
                        }
                    } else {
                        String text = tf2.getText();
                        if (text.length() > 0) {
                            tf2.setText(text.substring(0, text.length() - 1));
                        }
                    }
                    break;
                // equal part
                case "=":
                    try {
                        num1 = Double.parseDouble(tf1.getText());
                        num2 = Double.parseDouble(tf2.getText());

                        result = 0;

                        switch (operator) {
                            case "+":

                                result = num1 + num2;
                                break;
                            case "-":
                                result = num1 - num2;
                                break;
                            case "*":
                                result = num1 * num2;
                                break;
                            case "/":
                                result = num2 != 0 ? num1 / num2 : 0;
                                break;
                            case "%":
                                result = num2 != 0 ? num1 % num2 : 0;
                                break;

                        }

                        if (result == Math.floor(result)) {
                            lb3.setText("Result: " + (long) result);
                        } else {
                            lb3.setText("Result: " + result);
                        }
                    } catch (NumberFormatException ex) {
                        lb3.setText("Invalid input!");
                    }
                    break;

            }
        }

        else {
            switch (key) {
                // Number part
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                    tf2.setText(tf2.getText() + key);
                    break;

                // Operator part
                case "+":
                case "-":
                case "*":
                case "/":
                    operator = key;
                    lb3.setText("Operator: " + key);
                    tf2.requestFocusInWindow();
                    init++;
                    break;
                case "%":
                    operator = "%";
                    lb3.setText("Operator: " + key);
                    tf2.requestFocusInWindow();
                    init++;
                    break;

                // point part
                case ".":
                    tf2.setText(tf2.getText() + key);
                    break;
                // cleart part
                case "clear":
                    tf1.setText("");
                    tf2.setText("");
                    tf1.requestFocusInWindow();
                    init = 1;
                    lb3.setText("");
                    break;
                // continue part
                case "ctn":
                    tf1.setText("" + result);
                    tf2.setText("");

                    tf2.requestFocusInWindow();
                    break;
                // delete part
                case "del":
                    if (init == 1) {
                        String text = tf1.getText();
                        if (text.length() > 0) {
                            tf1.setText(text.substring(0, text.length() - 1));
                        }
                    } else {
                        String text = tf2.getText();
                        if (text.length() > 0) {
                            tf2.setText(text.substring(0, text.length() - 1));
                        }
                    }
                    break;
                // equal part
                case "=":
                    try {
                        num1 = Double.parseDouble(tf1.getText());
                        num2 = Double.parseDouble(tf2.getText());

                        result = 0;

                        switch (operator) {
                            case "+":
                                result = num1 + num2;
                                break;
                            case "-":
                                result = num1 - num2;
                                break;
                            case "*":
                                result = num1 * num2;
                                break;
                            case "/":
                                result = num2 != 0 ? num1 / num2 : 0;
                                break;
                            case "%":
                                result = num2 != 0 ? num1 % num2 : 0;
                                break;

                        }

                        if (result == Math.floor(result)) {
                            lb3.setText("Result: " + (long) result);
                        } else {
                            lb3.setText("Result: " + result);
                        }
                    } catch (NumberFormatException ex) {
                        lb3.setText("Invalid input!");
                    }
                    break;

            }
        }

    }

    public static void main(String[] args) {
        new calculator();
    }
}
