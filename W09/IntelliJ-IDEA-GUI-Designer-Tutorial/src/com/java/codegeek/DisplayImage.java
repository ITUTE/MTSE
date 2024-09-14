package com.java.codegeek;

import javax.swing.*;
import java.awt.*;

public class DisplayImage extends JFrame {
    private JPanel panel;
    private JLabel lable01;
    private JLabel lable02;
    private ImageIcon icon01;
    private ImageIcon icon02;

    public DisplayImage() {

        setLayout(new FlowLayout());
        setSize(50,50);

        //label01
        icon01 = new ImageIcon(getClass().getResource("image01.jpg"));

        lable01.setIcon(icon01);
        panel.add(lable01);

        //label02
        icon02 = new ImageIcon(getClass().getResource("image02.jpg"));

        lable02.setIcon(icon02);
        panel.add(lable02);

        add(panel);
        validate();
    }

    public static void main(String[] args) {
        DisplayImage gui = new DisplayImage();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(50, 50);
        gui.setVisible(true);
        gui.pack();
        gui.setTitle("Image");
    }
}
