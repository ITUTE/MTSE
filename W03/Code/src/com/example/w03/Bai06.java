package com.example.w03;

import javax.swing.*;

public class Bai06 {
    public static void main(String[] args) {
        int n;
        try {
            n = Integer.parseInt(JOptionPane.showInputDialog(null, "Nhập số nguyên n = ", ""));
        }
        catch (NumberFormatException e)
        {
            System.out.println(e.toString());
        }
        finally {
            System.out.println("Have good fun!");
        }
    }
}
