package com.example.w03;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Bai04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào 1 xâu: ");
        String str = sc.nextLine();
        System.out.println("Xâu sau khi chuẩn hóa: " + chuanHoa(str));
    }

    public static String chuyenInHoa(String str) {
        String s, strOutput;
        s = str.substring(0, 1);
        strOutput = str.replaceFirst(s, s.toUpperCase());
        return (strOutput);
    }

    public static String chuanHoa(String strInput) {
        String strOutput = "";
        StringTokenizer strToken = new StringTokenizer(strInput, " ,\t,\r");
        strOutput += "" + chuyenInHoa(strToken.nextToken());
        while (strToken.hasMoreTokens()) {
            strOutput += " " + chuyenInHoa(strToken.nextToken());
        }
        return (strOutput);
    }
}
