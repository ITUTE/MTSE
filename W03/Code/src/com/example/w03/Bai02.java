package com.example.w03;

import java.util.Random;
import java.util.Scanner;

public class Bai02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        int[] A = new int[n];
        genRandomArr(A, n);
        showArr(A, n);
        System.out.println();
        showPrimes(A, n);
    }

    public static void genRandomArr(int[] A, int n) {
        Random random = new Random();
        for (int i = 0; i < n; i++)
            A[i] = random.nextInt(1000);
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2 || n == 3 || n == 5 || n == 7) return true;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    public static void showArr(int[] A, int n) {
        System.out.print("Các phần từ trong mảng: ");
        for (int i = 0; i < n; i++)
            System.out.printf("%d ", A[i]);
    }

    public static void showPrimes(int[] A, int n) {
        System.out.print("Các số nguyên tố có trong mảng: ");
        for (int i = 0; i < n; i++)
            if (isPrime(A[i]))
                System.out.printf("%d ", A[i]);
    }
}
