import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Random;

public class RandomApp extends JFrame {
    public static void main(String[] args) {
        String str1 = JOptionPane.showInputDialog("Nhập số thứ nhất: ");
        String str2 = JOptionPane.showInputDialog("Nhập số thứ hai: ");

        Integer num1 = Integer.parseInt(str1);
        Integer num2 = Integer.parseInt(str2);

        Random rnd = new Random();
        Integer res = rnd.nextInt(Math.abs(num2 - num1) + 1) + Math.min(num1, num2);
        JOptionPane.showMessageDialog(null, "Số ngẫu nhiên: " + res);
    }
}
