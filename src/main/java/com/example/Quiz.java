package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import java.util.ArrayList;

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][3];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    ArrayList<Integer> questionOrder = new ArrayList<>();
    JLabel qno, question;
    JRadioButton opt1, opt2;
    ButtonGroup groupoptions;
    JButton next, submit;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    String name;

    Quiz(String name) {
        this.name = name;
        setBounds(50, 60, 1200, 800);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        qno = new JLabel();
        qno.setBounds(100, 100, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 100, 1000, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);


        questions[0][0] = "What is the color of BANANA?";
        questions[0][1] = "YELLOW";
        questions[0][2] = "RED";

        questions[1][0] = "What is 2+2 equal?";
        questions[1][1] = "4";
        questions[1][2] = "5";

        questions[2][0] = "Is the Earth flat?";
        questions[2][1] = "No";
        questions[2][2] = "Yes";

        questions[3][0] = "What is the capital of France?";
        questions[3][1] = "Paris";
        questions[3][2] = "Berlin";

        questions[4][0] = "Is fire cold?";
        questions[4][1] = "No";
        questions[4][2] = "Yes";

        questions[5][0] = "Which is bigger, the sun or the moon?";
        questions[5][1] = "The sun";
        questions[5][2] = "The moon";

        questions[6][0] = "Which planet is known as the Red Planet?";
        questions[6][1] = "Mars";
        questions[6][2] = "Earth";

        questions[7][0] = "What is the freezing point of water?";
        questions[7][1] = "0 degrees Celsius";
        questions[7][2] = "100 degrees Celsius";

        questions[8][0] = "Which is heavier, 1kg of feathers or 1kg of bricks?";
        questions[8][1] = "They are the same weight";
        questions[8][2] = "1kg of bricks";

        questions[9][0] = "What is the largest ocean on Earth?";
        questions[9][1] = "Pacific";
        questions[9][2] = "Atlantic";

        
        for (int i = 0; i < questions.length; i++) {
            questionOrder.add(i);
        }
        Collections.shuffle(questionOrder);

        opt1 = new JRadioButton();
        opt1.setBounds(150, 200, 1000, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt1.addActionListener(this);
        opt1.setFocusPainted(false);
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(150, 250, 1000, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt2.addActionListener(this);
        opt2.setFocusPainted(false);
        add(opt2);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);

        next = new JButton("Next");
        next.setBounds(435, 340, 120, 25);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(255, 87, 34));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        next.setEnabled(false);
        next.setFocusPainted(false);

        add(next);

        submit = new JButton("Submit");
        submit.setBounds(635, 340, 120, 25);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(255, 87, 34));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        submit.setFocusPainted(false);
        submit.setVisible(false);

        add(submit);

        start(count);
        setSize(1200, 500);
        setLocation(110, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);

            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            count++;
            if (count == 9) {
                next.setVisible(false);
                submit.setEnabled(true);
                submit.setVisible(true);
            } else {
                start(count);
            }
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            int correctAnswers = 0;
            int wrongAnswers = 0;

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(questions[questionOrder.get(i)][1])) {
                    correctAnswers++;
                } else {
                    wrongAnswers++;
                    score += 10;
                }
            }

            setVisible(false);
            new Score(name, score, correctAnswers, wrongAnswers);
        } else if (ae.getSource() == opt1 || ae.getSource() == opt2) {
            next.setEnabled(true);
        }
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[questionOrder.get(count)][0]);
        opt1.setText(questions[questionOrder.get(count)][1]);
        opt1.setActionCommand(questions[questionOrder.get(count)][1]);

        opt2.setText(questions[questionOrder.get(count)][2]);
        opt2.setActionCommand(questions[questionOrder.get(count)][2]);

        groupoptions.clearSelection();
        next.setEnabled(false);
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}
