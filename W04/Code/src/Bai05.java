import javax.swing.*;
import java.awt.*;

public class Bai05 extends JFrame {
    public Bai05(String title){
        setTitle(title);
        JPanel pnBorder = new JPanel();
        pnBorder.setLayout(new BorderLayout());
        JPanel pnNorth = new JPanel();
        pnNorth.setBackground(Color.RED);
        pnBorder.add(pnNorth, BorderLayout.NORTH);
        JPanel pnSouth = new JPanel();
        pnSouth.setBackground(Color.RED);
        pnBorder.add(pnSouth, BorderLayout.SOUTH);
        JPanel pnWest = new JPanel();
        pnWest.setBackground(Color.BLUE);
        pnBorder.add(pnWest, BorderLayout.WEST);
        JPanel pnEast = new JPanel();
        pnEast.setBackground(Color.BLUE);
        pnBorder.add(pnEast, BorderLayout.EAST);
        JPanel pnCenter = new JPanel();
        pnCenter.setBackground(Color.YELLOW);
        pnBorder.add(pnCenter, BorderLayout.CENTER);
        getContentPane().add(pnBorder);
    }

    public static void main(String[] args) {
        Bai05 myUI = new Bai05("Demo");
        myUI.setSize(600,200);
        myUI.setVisible(true);
    }
}
