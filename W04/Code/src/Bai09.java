import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class Bai09 extends JFrame {
    JTextField txtInput;
    JTextField txtResult;

    public Bai09(){
        setTitle("String Processing");
        JPanel pnContainer = new JPanel();
        pnContainer.setLayout(new BoxLayout(pnContainer, BoxLayout.Y_AXIS));
        pnContainer.setBorder(new EmptyBorder(10, 10, 10, 10));

        txtInput = new JTextField(JTextField.RIGHT);
        txtResult = new JTextField(JTextField.RIGHT);
        JPanel pn1 = initInput();
        JPanel pn2 = initResult();
        JPanel pnOperators = Operators();

        pnContainer.add(pn1);
        pnContainer.add(pn2);
        pnContainer.add(pnOperators);

        getContentPane().add(pnContainer);
    }

    public JPanel initInput(){
        JPanel pn1 = new JPanel();
        pn1.setLayout(new BoxLayout(pn1, BoxLayout.X_AXIS));
        JLabel lb1 = new JLabel("Input: ");
        lb1.setPreferredSize(new Dimension(50, 10));
        txtInput.setColumns(10);
        pn1.add(lb1);
        pn1.add(txtInput);
        pn1.setBorder(new EmptyBorder(2, 0, 2, 0));
        return pn1;
    }

    public JPanel initResult(){
        JPanel pn2 = new JPanel();
        pn2.setLayout(new BoxLayout(pn2, BoxLayout.X_AXIS));
        JLabel lb2 = new JLabel("Result: ");
        lb2.setPreferredSize(new Dimension(50, 10));
        txtResult.setColumns(10);
        txtResult.setEnabled(false);
        pn2.add(lb2);
        pn2.add(txtResult);
        pn2.setBorder(new EmptyBorder(2, 0, 2, 0));
        return pn2;
    }

    public JPanel Operators(){
        JPanel pnOperators = new JPanel();
        JButton btnUpperCase = new JButton("UpperCase");
        btnUpperCase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResult.setText(txtInput.getText().toUpperCase(Locale.ROOT));
            }
        });
        pnOperators.add(btnUpperCase);

        /////////////////////////////////////////////////////////
        JButton btnLowerCase = new JButton("LowerCase");
        btnLowerCase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResult.setText(txtInput.getText().toLowerCase(Locale.ROOT));
            }
        });
        pnOperators.add(btnLowerCase);

        /////////////////////////////////////////////////////////
        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResult.setText("");
                txtInput.setText("");
            }
        });
        pnOperators.add(btnClear);

        /////////////////////////////////////////////////////////
        JButton btnCancel = new JButton("Exit");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int re = JOptionPane.showConfirmDialog(Bai09.this, "Bạn muốn thoát khỏi ứng dụng?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (re == JOptionPane.YES_OPTION)
                    dispose();
            }
        });
        pnOperators.add(btnCancel);

        /////////////////////////////////////////////////////////
        pnOperators.setBorder(new EmptyBorder(5, 0, 5, 0));
        return pnOperators;
    }

    public void showDialog(String msg){
        JOptionPane.showMessageDialog(this, msg);
    }

    public static void main(String[] args) {
        Bai09 frm = new Bai09();
        frm.setSize(400,170);
        frm.setVisible(true);
    }
}
