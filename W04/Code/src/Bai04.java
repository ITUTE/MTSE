import javax.swing.*;
import java.awt.*;

public class Bai04 extends JFrame{
    public Bai04(String title){
        setTitle(title);
        JPanel pnBox = new JPanel();
        pnBox.setLayout(new FlowLayout());
        pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.X_AXIS));
        JButton btn1 = new JButton("BoxLayout");
        btn1.setForeground(Color.red);
        Font font = new Font("Arial", Font.BOLD | Font.ITALIC, 25);
        btn1.setFont(font);
        JButton btn2 = new JButton("X_AXIS");
        btn2.setForeground(Color.blue);
        btn2.setFont(font);
        JButton btn3 = new JButton("Y_AXIS");
        btn3.setForeground(Color.orange);
        btn3.setFont(font);
        pnBox.add(btn1);
        pnBox.add(btn2);
        pnBox.add(btn3);

        Container con = getContentPane();
        con.add(pnBox);
    }

    public static void main(String[] args) {
        Bai04 myUI = new Bai04("Demo BoxLayout");
        myUI.setSize(600,100);
        myUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myUI.setVisible(true);
    }
}
