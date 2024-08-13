package com.example;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    Score(String name, int score, int correctAnswers, int wrongAnswers) {
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Thank you " + name + " for playing Quizy Beazy");
        heading.setBounds(130, 30, 700, 30);
        heading.setForeground(new Color(255, 87, 34));
        heading.setFont(new Font("Cooper Black", Font.BOLD, 26));
        add(heading);

        JLabel lblscore = new JLabel("Your score is " + score);
        lblscore.setBounds(300, 200, 300, 30);
        lblscore.setFont(new Font("Cooper Black", Font.PLAIN, 26));
        add(lblscore);

        JLabel lblcorrect = new JLabel("Correct Answers: " + correctAnswers);
        lblcorrect.setBounds(300, 250, 300, 30);
        lblcorrect.setFont(new Font("Cooper Black", Font.PLAIN, 26));
        lblcorrect.setForeground(new Color(255, 87, 34));
        add(lblcorrect);

        JLabel lblwrong = new JLabel("Wrong Answers: " + wrongAnswers);
        lblwrong.setBounds(300, 300, 300, 30);
        lblwrong.setFont(new Font("Cooper Black", Font.PLAIN, 26));
        lblwrong.setForeground(new Color(34, 139, 34));
        add(lblwrong);

        JButton submit = new JButton("Play Again");
        submit.setBounds(320, 370, 150, 40);
        submit.setBackground(new Color(255, 87, 34));
        submit.setForeground(Color.WHITE);
        submit.setFocusPainted(false);
        submit.addActionListener(this);
        add(submit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new login();
    }

    public static void main(String[] args) {
        new Score("User", 0, 0, 0);
    }
}
