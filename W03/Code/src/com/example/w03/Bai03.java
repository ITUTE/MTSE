package com.example.w03;

import java.util.Random;
import java.util.Scanner;

public class Bai03 {
    private static final int MAX = 50;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số dòng m = ");
        int m = sc.nextInt();
        System.out.print("Nhập số cột n = ");
        int n = sc.nextInt();
        System.out.print("Nhập k = ");
        int k = sc.nextInt();
        int[][] A = new int[m][n];
        genRandomArr(A, m, n);
        showArr(A, m, n);
        System.out.printf("Tổng các phần tử ở hàng %d là: %d", k, sumRow(A,k,n));
    }

    public static void genRandomArr(int[][] A, int m, int n) {
        Random random = new Random();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                A[i][j] = random.nextInt(MAX);
    }

    public static void showArr(int[][] A, int m, int n) {
        System.out.println("Các phần từ trong mảng: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                System.out.printf("%d ", A[i][j]);
            System.out.println();
        }
    }

    public static int sumRow(int[][] A, int k, int col) {
        int sum = 0;
        for (int i = 0; i < col; i++)
            sum += A[k][i];
        return sum;
    }
}
