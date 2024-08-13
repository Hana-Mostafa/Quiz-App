package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class login extends JFrame implements ActionListener {

    JButton rules, back;
    JTextField tfname;

    login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Quizy Beazy");
        heading.setBounds(450, 60, 400, 49);
        heading.setFont(new Font("Cooper Black", Font.BOLD, 45));
        heading.setForeground(new Color(255, 87, 34));
        add(heading);

        JLabel name = new JLabel("Enter your name");
        name.setBounds(520 ,150, 300, 18);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(new Color(255, 87, 34));
        add(name);

        tfname = new JTextField();
        tfname.setBounds(435, 200, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);

        rules = new JButton("Next");
        rules.setBounds(535, 270, 120, 25);
        rules.setBackground(new Color(255, 87, 34));
        rules.setForeground(Color.WHITE);
        rules.setEnabled(false);
        rules.addActionListener(this);
        rules.setFocusPainted(false);
        add(rules);

        // Add DocumentListener to tfname
        tfname.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                enableButton();
            }
            public void removeUpdate(DocumentEvent e) {
                enableButton();
            }
            public void insertUpdate(DocumentEvent e) {
                enableButton();
            }

            public void enableButton() {
                if (tfname.getText().trim().length() > 0) {
                    rules.setEnabled(true);
                } else {
                    rules.setEnabled(false);
                }
            }
        });

        setSize(1200, 500);
        setLocation(110, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rules) {
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);
        }
    }

    public static void main(String[] args) {
        new login();
    }

    public JButton getRules() {
        return rules;
    }

    public void setRules(JButton rules) {
        this.rules = rules;
    }

    public JTextField getTfname() {
        return tfname;
    }

    public void setTfname(JTextField tfname) {
        this.tfname = tfname;
    }
}
