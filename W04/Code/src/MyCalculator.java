import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCalculator extends JFrame {
    public MyCalculator(){
        setTitle("Calculator");
        JPanel pnContainer = new JPanel();
        pnContainer.setLayout(new BoxLayout(pnContainer, BoxLayout.Y_AXIS));
        pnContainer.setBorder(new EmptyBorder(10, 10, 10, 10));

        JTextField txt1 = new JTextField(JTextField.RIGHT);
        JTextField txt2 = new JTextField(JTextField.RIGHT);
        JTextField txtResult = new JTextField(JTextField.RIGHT);
        JPanel pn1 = FirstNumber(txt1);
        JPanel pn2 = SecondNumber(txt2);
        JPanel pnResult = Result(txtResult);
        JPanel pnOperators = Operators(txt1, txt2, txtResult);

        pnContainer.add(pn1);
        pnContainer.add(pn2);
        pnContainer.add(pnResult);
        pnContainer.add(pnOperators);

        getContentPane().add(pnContainer);
    }

    public JPanel FirstNumber(JTextField txt1){
        JPanel pn1 = new JPanel();
        pn1.setLayout(new GridLayout());
        JLabel lb1 = new JLabel("First number: ");
        txt1.setColumns(10);
        pn1.add(lb1);
        pn1.add(txt1);
        pn1.setBorder(new EmptyBorder(2, 0, 2, 0));
        return pn1;
    }

    public JPanel SecondNumber(JTextField txt2){
        JPanel pn2 = new JPanel();
        pn2.setLayout(new GridLayout());
        JLabel lb2 = new JLabel("Second number: ");
        txt2.setColumns(10);
        pn2.add(lb2);
        pn2.add(txt2);
        pn2.setBorder(new EmptyBorder(2, 0, 2, 0));
        return pn2;
    }

    public JPanel Result(JTextField txtResult){
        JPanel pnResult = new JPanel();
        pnResult.setLayout(new GridLayout());
        JLabel lbResult = new JLabel("Result: ");
        txtResult.setColumns(10);
        txtResult.setEnabled(false);
        pnResult.add(lbResult);
        pnResult.add(txtResult);
        pnResult.setBorder(new EmptyBorder(2, 0, 2, 0));
        return pnResult;
    }

    public JPanel Operators(JTextField txt1, JTextField txt2, JTextField txtResult){
        JPanel pnOperators = new JPanel();
        JButton btnAdd = new JButton("+");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n1 = txt1.getText();
                String n2 = txt2.getText();
                if (n1.equals("") || n2.equals(""))
                {
                    showDialog("Vui lòng nhập đầy đủ num1 và num2.");
                }
                else
                {
                    try {
                        double num1 = Double.parseDouble(n1);
                        double num2 = Double.parseDouble(n2);
                        txtResult.setText(String.valueOf(num1+num2));
                    }
                    catch (NumberFormatException ex)
                    {
                        showDialog("Dữ liệu đầu vào sai định dạng. Vui lòng nhập lại!");
                    }
                }
            }
        });
        pnOperators.add(btnAdd);

        /////////////////////////////////////////////////////////
        JButton btnSub = new JButton("-");
        btnSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n1 = txt1.getText();
                String n2 = txt2.getText();
                if (n1.equals("") || n2.equals(""))
                {
                    showDialog("Vui lòng nhập đầy đủ num1 và num2.");
                }
                else
                {
                    try {
                        double num1 = Double.parseDouble(n1);
                        double num2 = Double.parseDouble(n2);
                        txtResult.setText(String.valueOf(num1-num2));
                    }
                    catch (NumberFormatException ex)
                    {
                        showDialog("Dữ liệu đầu vào sai định dạng. Vui lòng nhập lại!");
                    }
                }
            }
        });
        pnOperators.add(btnSub);

        /////////////////////////////////////////////////////////
        JButton btnMul = new JButton("*");
        btnMul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n1 = txt1.getText();
                String n2 = txt2.getText();
                if (n1.equals("") || n2.equals(""))
                {
                    showDialog("Vui lòng nhập đầy đủ num1 và num2.");
                }
                else
                {
                    try {
                        double num1 = Double.parseDouble(n1);
                        double num2 = Double.parseDouble(n2);
                        txtResult.setText(String.valueOf(num1*num2));
                    }
                    catch (NumberFormatException ex)
                    {
                        showDialog("Dữ liệu đầu vào sai định dạng. Vui lòng nhập lại!");
                    }
                }
            }
        });
        pnOperators.add(btnMul);

        /////////////////////////////////////////////////////////
        JButton btnDiv = new JButton("/");
        btnDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n1 = txt1.getText();
                String n2 = txt2.getText();
                if (n1.equals("") || n2.equals(""))
                {
                    showDialog("Vui lòng nhập đầy đủ num1 và num2.");
                }
                else
                {
                    try {
                        double num1 = Double.parseDouble(n1);
                        double num2 = Double.parseDouble(n2);
                        txtResult.setText(String.valueOf(num1/num2));
                    }
                    catch (NumberFormatException ex)
                    {
                        showDialog("Dữ liệu đầu vào sai định dạng. Vui lòng nhập lại!");
                    }
                }
            }
        });
        pnOperators.add(btnDiv);

        /////////////////////////////////////////////////////////
        pnOperators.setBorder(new EmptyBorder(5, 0, 5, 0));
        return pnOperators;
    }

    public void showDialog(String msg){
        JOptionPane.showMessageDialog(this, msg);
    }

    public static void main(String[] args) {
        MyCalculator calc = new MyCalculator();
        calc.setSize(300,170);
        calc.setVisible(true);
    }
}
