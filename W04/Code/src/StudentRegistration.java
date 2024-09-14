import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegistration extends JFrame {
    JLabel lbTitle;
    JTextField txtFirstName;
    JTextField txtLastName;
    JTextField txtContact;
    JTextArea txtAddress;
    JTextField txtHighestQualification;
    JTextField txtSpecification;
    JTextField txtEnrolledFor;
    JTextField txtHobbies;
    JTextField txtSports;
    JButton btnSave;
    JButton btnReset;
    JButton btnExit;

    public static void main(String[] args) {
        StudentRegistration frm = new StudentRegistration();
        frm.setVisible(true);
        frm.setSize(450, 470);
    }

    public StudentRegistration(){
        JPanel pnContainer = new JPanel();
        pnContainer.setLayout(new BoxLayout(pnContainer, BoxLayout.Y_AXIS));
        pnContainer.setBorder(new EmptyBorder(5, 5, 5, 5));
        setTitle("Student Registration");

        lbTitle = new JLabel("Student Registration");
        JPanel pnTitle = new JPanel();
        pnTitle.add(lbTitle);
        pnContainer.add(pnTitle);

        /// Personal Details
        JPanel pnPersonalDetails = initPersonalDetails();
        pnContainer.add(pnPersonalDetails);

        ///Academic Details
        JPanel pnAcademicDetails = initAcademicDetails();
        pnContainer.add(pnAcademicDetails);

        ///Extracurricular Details
        JPanel pnExtracurricularDetails = initExtracurricularDetails();
        pnContainer.add(pnExtracurricularDetails);

        ///Options
        JPanel pnOptions = initOptions();
        pnContainer.add(pnOptions);

        getContentPane().add(pnContainer);
    }

    private JPanel initPersonalDetails(){
        JPanel pnPersonalDetails = new JPanel();
        pnPersonalDetails.setBorder(new EmptyBorder(2,10,2,10));
        JPanel pn = new JPanel();
        pn.setLayout(new BoxLayout(pn, BoxLayout.Y_AXIS));
        pn.setBorder(new LineBorder(Color.GRAY));

        JPanel pnFirstName = new JPanel();
        JLabel lbFirstName = new JLabel("First Name: ");
        lbFirstName.setPreferredSize(new Dimension(70,15));
        txtFirstName = new JTextField(JTextField.RIGHT);
        txtFirstName.setColumns(30);
        pnFirstName.add(lbFirstName);
        pnFirstName.add(txtFirstName);

        JPanel pnLastName = new JPanel();
        JLabel lbLastName = new JLabel("Last Name: ");
        lbLastName.setPreferredSize(new Dimension(70,15));
        txtLastName = new JTextField(JTextField.RIGHT);
        txtLastName.setColumns(30);
        pnLastName.add(lbLastName);
        pnLastName.add(txtLastName);

        JPanel pnContact = new JPanel();
        JLabel lbContact = new JLabel("Contact: ");
        lbContact.setPreferredSize(new Dimension(70,15));
        txtContact = new JTextField(JTextField.RIGHT);
        txtContact.setColumns(30);
        pnContact.add(lbContact);
        pnContact.add(txtContact);

        JPanel pnAddress = new JPanel();
        JLabel lbAddress = new JLabel("Address: ");
        lbAddress.setPreferredSize(new Dimension(70,15));
        txtAddress = new JTextArea(4, 30);
        txtAddress.setColumns(30);
        txtAddress.setLineWrap(true);
        txtAddress.setAutoscrolls(true);
        txtAddress.setBorder(new LineBorder(Color.GRAY));
        pnAddress.add(lbAddress);
        pnAddress.add(txtAddress);

        pn.add(pnFirstName);
        pn.add(pnLastName);
        pn.add(pnContact);
        pn.add(pnAddress);
        pnPersonalDetails.add(pn);
        return pnPersonalDetails;
    }

    private JPanel initAcademicDetails() {
        JPanel pnAcademicDetails = new JPanel();

        pnAcademicDetails.setBorder(new EmptyBorder(2,10,2,10));
        JPanel pn = new JPanel();
        pn.setLayout(new BoxLayout(pn, BoxLayout.Y_AXIS));
        pn.setBorder(new LineBorder(Color.GRAY));

        JPanel pnHighestQualification = new JPanel();
        JLabel lbHighestQualification = new JLabel("Highest Qualification: ");
        lbHighestQualification.setPreferredSize(new Dimension(130,15));
        txtHighestQualification = new JTextField(JTextField.RIGHT);
        txtHighestQualification.setColumns(24);
        pnHighestQualification.add(lbHighestQualification);
        pnHighestQualification.add(txtHighestQualification);

        JPanel pnSpecification = new JPanel();
        JLabel lbSpecification = new JLabel("Specification: ");
        lbSpecification.setPreferredSize(new Dimension(130,15));
        txtSpecification = new JTextField(JTextField.RIGHT);
        txtSpecification.setColumns(24);
        pnSpecification.add(lbSpecification);
        pnSpecification.add(txtSpecification);

        JPanel pnEnrolledFor = new JPanel();
        JLabel lbEnrolledFor = new JLabel("Enrolled For: ");
        lbEnrolledFor.setPreferredSize(new Dimension(130,15));
        txtEnrolledFor = new JTextField(JTextField.RIGHT);
        txtEnrolledFor.setColumns(24);
        pnEnrolledFor.add(lbEnrolledFor);
        pnEnrolledFor.add(txtEnrolledFor);

        pn.add(pnHighestQualification);
        pn.add(pnSpecification);
        pn.add(pnEnrolledFor);
        pnAcademicDetails.add(pn);
        return pnAcademicDetails;
    }

    private JPanel initExtracurricularDetails(){
        JPanel pnExtracurricularDetails = new JPanel();
        pnExtracurricularDetails.setBorder(new EmptyBorder(2,10,2,10));

        JPanel pn = new JPanel();
        pn.setLayout(new BoxLayout(pn, BoxLayout.Y_AXIS));
        pn.setBorder(new LineBorder(Color.GRAY));

        JPanel pnHobbies = new JPanel();
        JLabel lbHobbies = new JLabel("Hobbies: ");
        lbHobbies.setPreferredSize(new Dimension(70, 15));
        txtHobbies = new JTextField(JTextField.RIGHT);
        txtHobbies.setColumns(30);
        pnHobbies.add(lbHobbies);
        pnHobbies.add(txtHobbies);

        JPanel pnSports = new JPanel();
        JLabel lbSports = new JLabel("Sports: ");
        lbSports.setPreferredSize(new Dimension(70, 15));
        txtSports = new JTextField(JTextField.RIGHT);
        txtSports.setColumns(30);
        pnSports.add(lbSports);
        pnSports.add(txtSports);

        pn.add(pnHobbies);
        pn.add(pnSports);
        pnExtracurricularDetails.add(pn);
        return pnExtracurricularDetails;
    }

    private JPanel initOptions(){
        JPanel pnOptions = new JPanel();
        pnOptions.setBorder(new EmptyBorder(2,10,2,10));
        JPanel pn = new JPanel();
        pn.setLayout(new BoxLayout(pn, BoxLayout.X_AXIS));

        btnSave = new JButton();
        btnSave.setText("Save");
        btnSave.addActionListener(e -> check());

        btnReset = new JButton();
        btnReset.setText("Reset");
        btnReset.addActionListener(e -> resetText());

        btnExit = new JButton();
        btnExit.setText("Exit");
        btnExit.addActionListener(e -> confirmExit());

        pn.add(btnSave);
        pn.add(Box.createRigidArea(new Dimension(5, 0)));
        pn.add(btnReset);
        pn.add(Box.createRigidArea(new Dimension(5, 0)));
        pn.add(btnExit);
        pnOptions.add(pn);
        return pnOptions;
    }

    private void resetText(){
        txtFirstName.setText("");
        txtLastName.setText("");
        txtContact.setText("");
        txtAddress.setText("");

        txtHighestQualification.setText("");
        txtSpecification.setText("");
        txtEnrolledFor.setText("");

        txtHobbies.setText("");
        txtSports.setText("");
    }

    private void check(){
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String contact = txtContact.getText();
        String address = txtAddress.getText();
        String highestQual = txtHighestQualification.getText();
        String specification = txtSpecification.getText();
        String enroll = txtEnrolledFor.getText();
        String hobbies = txtHobbies.getText();
        String sports = txtSports.getText();

        if (firstName.equals("")) showMsg("First Name is missing!");
        else if (lastName.equals("")) showMsg("Last Name is missing!");
        else if (contact.equals("")) showMsg("Contact is missing!");
        else if (address.equals("")) showMsg("Address is missing!");
        else if (highestQual.equals("")) showMsg("Highest Qualification is missing!");
        else if (specification.equals("")) showMsg("Specification is missing!");
        else if (enroll.equals("")) showMsg("Enrolled for is missing!");
        else if (hobbies.equals("")) showMsg("Hobbies is missing!");
        else if (sports.equals("")) showMsg("Sports is missing!");
        else showMsg("Saved!");
    }

    private void confirmExit()
    {
        int re = JOptionPane.showConfirmDialog(this, "Do you want to exit?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (re == JOptionPane.YES_OPTION)
            dispose();;
    }

    private void showMsg(String msg)
    {
        JOptionPane.showMessageDialog(this, msg);
    }
}
