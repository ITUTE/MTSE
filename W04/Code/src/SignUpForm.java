import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpForm extends JFrame {
    public SignUpForm(){
        setTitle("Sign Up Form");
        JPanel pnContainer = new JPanel();
        pnContainer.setLayout(new BoxLayout(pnContainer, BoxLayout.Y_AXIS));
        pnContainer.setBorder(new EmptyBorder(10, 10, 10, 10));

        JTextField txtUsername = new JTextField(JTextField.RIGHT);
        JPasswordField txtPassword = new JPasswordField(JTextField.RIGHT);
        JPasswordField txtConfirm = new JPasswordField(JTextField.RIGHT);
        JPanel pn1 = Username(txtUsername);
        JPanel pn2 = Password(txtPassword);
        JPanel pnConfirm = Confirm(txtConfirm);
        JPanel pnOperators = Operators(txtUsername, txtPassword, txtConfirm);

        pnContainer.add(pn1);
        pnContainer.add(pn2);
        pnContainer.add(pnConfirm);
        pnContainer.add(pnOperators);

        getContentPane().add(pnContainer);
    }

    public JPanel Username(JTextField txtUsername){
        JPanel pn1 = new JPanel();
        pn1.setLayout(new GridLayout());
        JLabel lb1 = new JLabel("Username: ");
        txtUsername.setColumns(10);
        pn1.add(lb1);
        pn1.add(txtUsername);
        pn1.setBorder(new EmptyBorder(2, 0, 2, 0));
        return pn1;
    }

    public JPanel Password(JPasswordField txtPassword){
        JPanel pn2 = new JPanel();
        pn2.setLayout(new GridLayout());
        JLabel lb2 = new JLabel("Password: ");
        txtPassword.setColumns(10);
        pn2.add(lb2);
        pn2.add(txtPassword);
        pn2.setBorder(new EmptyBorder(2, 0, 2, 0));
        return pn2;
    }

    public JPanel Confirm(JPasswordField txtConfirm){
        JPanel pnConfirm = new JPanel();
        pnConfirm.setLayout(new GridLayout());
        JLabel lbConfirm = new JLabel("Confirm: ");
        txtConfirm.setColumns(10);
        pnConfirm.add(lbConfirm);
        pnConfirm.add(txtConfirm);
        pnConfirm.setBorder(new EmptyBorder(2, 0, 2, 0));
        return pnConfirm;
    }

    public JPanel Operators(JTextField txtUsername, JPasswordField txtPassword, JPasswordField txtConfirm){
        JPanel pnOperators = new JPanel();
        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = txtPassword.getText();
                String confirm = txtConfirm.getText();
                if (username.equals("") || password.equals("") || confirm.equals(""))
                {
                    showDialog("Vui lòng nhập đầy đủ thông tin!");
                }
                else
                {
                    if (password.equals(confirm))
                    {
                        showDialog("Đăng ký thành công");
                    }
                    else
                    {
                        showDialog("Vui lòng nhập lại mật khẩu!");
                    }
                }
            }
        });
        pnOperators.add(btnSignUp);

        /////////////////////////////////////////////////////////
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        SignUpForm frm = new SignUpForm();
        frm.setSize(300,170);
        frm.setVisible(true);
    }
}
