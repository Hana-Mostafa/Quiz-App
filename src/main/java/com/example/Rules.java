package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener  {

    String name;
    JButton start, back;

    Rules(String name) {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Welcome " + name + "");
        heading.setBounds(456, 20, 800, 40);
        heading.setFont(new Font("Cooper Black", Font.BOLD, 40));
        heading.setForeground(new Color(255, 87, 34));
        add(heading);

        JLabel rules = new JLabel("Mistakes are Celebrated Here Choose Wrong and Shine!");
        rules.setBounds(235 ,150, 800, 99);
        rules.setFont(new Font("Cooper Black", Font.BOLD, 25));
        rules.setForeground(new Color(34, 139, 34));
        add(rules);


        back = new JButton("Back");
        back.setBounds(435, 340, 120, 25);
        back.setBackground(new Color(255, 87, 34));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFocusPainted(false);
        add(back);

        start = new JButton("Start");
        start.setBounds(635, 340, 120, 25);
        start.setBackground(new Color(255, 87, 34));
        start.setForeground(Color.WHITE);
        start.setFocusPainted(false);
        start.addActionListener(this);
        add(start);

        setSize(1200, 500);
        setLocation(110, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);
        } else {
            setVisible(false);
            new login();
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}
