package com.example.w03;

import java.util.Scanner;

public class Bai01 {
    public static void main(String[] args) {
        double a, b, c;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập a, b, c: ");
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
        solve(a, b, c);
    }

    public static void solve(double a, double b, double c) {
        if (a == 0) {
            if (b == 0) {
                if (c == 0)
                    System.out.print("Phương trình vô số nghiệm");
                else
                    System.out.print("Phương trình vô nghiệm");
            } else System.out.printf("Nghiệm đơn: x = %f", -c / b);
        } else {
            double delta = b * b - 4 * a * c;
            if (delta == 0)
                System.out.printf("Phương trình có nghiệm kép: x = %f", -b / (2 * a));
            else if (delta > 0) {
                System.out.printf("Nghiệm x1 = %f \n", (-b - Math.sqrt(delta)) / (2 * a));
                System.out.printf("Nghiệm x2 = %f \n", (-b + Math.sqrt(delta)) / (2 * a));
            } else
                System.out.print("Phương trình vô nghiệm");
        }
    }
}
