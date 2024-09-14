package com.example.w03;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Bai11 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Double> A = new ArrayList<>();
        Load("data.txt", A);
        solve(A);
    }

    public static void Load(String filename, ArrayList<Double> A){
        File f = new File("");
        f = new File(f.getAbsolutePath() + "\\src\\" + filename);
        try {
            Scanner sc = new Scanner(f).useDelimiter(" ");
            while (sc.hasNextDouble()){
                A.add(sc.nextDouble());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void solve(ArrayList<Double> A){
        Double sum = 0.0;
        for (int i=0; i<A.size(); i++){
            sum+=A.get(i);
        }
        System.out.println("Tổng: " + sum);
        System.out.print("TB cộng: " + sum/A.size());
    }
}
