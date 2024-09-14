package com.example.w03;

public class Bai07 {
    public static void main(String[] args) {
        int a[] = {4, 7, 9, 12, 7};
        output(a, 10);
    }

    static int getPos(int i, int a[]) {
        return a[i];
    }

    static void output(int a[], int n) {
        try {
            for (int i = 0; i < n; i++)
                System.out.println(getPos(i, a));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Vượt quá chỉ số mảng.");
        }
    }
}
