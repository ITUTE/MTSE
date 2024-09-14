package com.example.w03;

import java.io.*;

public class Bai09 {
    public static void main(String[] args) {
        try {
            FileOutputStream os = new FileOutputStream("abc.txt");
            String s = "Chao cac ban den voi chuong trinh doc xuat file.";
            for (int i = 0; i < s.length(); i++)
                os.write(s.charAt(i));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream is = new FileInputStream("abc.txt");
            int ibyts = is.available();
            System.out.println("File có tất cả " + ibyts + " ký tự.");
            byte[] ibuf = new byte[ibyts];
            int byrd = is.read(ibuf, 0, ibyts);
            System.out.println("Tổng số ký tự đọc được là: " + byrd);
            System.out.println("Chuỗi ký tự là: " + new String(ibuf));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File f1 = new File("abc.txt");
        f1.delete();
    }
}
