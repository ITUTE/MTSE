package com.example.w03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Bai10 {
    public static void main(String[] args) throws FileNotFoundException {
        String filename = "";
        File f = new File("");
        filename = f.getAbsolutePath() + "\\src\\data.txt";
        f = new File(filename);
        if (f.exists()) {
            System.out.println("File đã tồn tại.");
            System.exit(0);
        }

        PrintWriter pw = new PrintWriter(f);
        pw.print("(c) tiennhm");
        pw.print(2021);
        pw.close();
        System.out.println("Đã ghi xong");
    }

}
