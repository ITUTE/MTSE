package Interface;

import Proccess.LoaiSP;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class frmCapnhatLoaiSP extends JFrame {
    private JTextField txtMaloai;
    private JTextField txtTenloai;
    private JButton btThem;
    private JButton btXoa;
    private JButton btSua;
    private JButton btLuu;
    private JButton btKLuu;
    private JButton btThoat;
    private JTable jTableLoaiSP;
    private JPanel pnMain;

    private final LoaiSP lsp = new LoaiSP();
    private boolean cothem = true;

    private final DefaultTableModel tableModel = new DefaultTableModel();

    //Ham do du lieu vao tableModel
    public void ShowData() throws SQLException {
        ResultSet result = lsp.ShowLoaiSP();
        try {
            while (result.next()) { // nếu còn đọc tiếp được một dòng dữ liệu
                String rows[] = new String[2];
                rows[0] = result.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
                rows[1] = result.getString(2); // lấy dữ liệu tai cột số 2 ứng với tên hàng
                tableModel.addRow(rows); // đưa dòng dữ liệu vào tableModel
                //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update
            }
        } catch (SQLException e) {
        }
    }

    //Ham xoa du lieu trong tableModel
    public void ClearData() throws SQLException {
        //Lay chi so dong cuoi cung
        int n = tableModel.getRowCount() - 1;
        for (int i = n; i >= 0; i--)
            tableModel.removeRow(i);//Remove tung dong
    }

    //Ham xoa cac TextField
    private void setNull() {
        //Xoa trang cac JtextField
        this.txtMaloai.setText(null);
        this.txtTenloai.setText(null);
        this.txtMaloai.requestFocus();
    }

    //Ham khoa cac TextField
    private void setKhoa(boolean a) {
        //Khoa hoac mo khoa cho Cac JTextField
        this.txtMaloai.setEnabled(!a);
        this.txtTenloai.setEnabled(!a);
    }

    //Ham khoa cac Button
    private void setButton(boolean a) {
        //Vo hieu hoac co hieu luc cho cac JButton
        this.btThem.setEnabled(a);
        this.btXoa.setEnabled(a);
        this.btSua.setEnabled(a);
        this.btLuu.setEnabled(!a);
        this.btKLuu.setEnabled(!a);
        this.btThoat.setEnabled(a);
    }

    public frmCapnhatLoaiSP() throws SQLException {
        //initComponents(); // Khởi tạo các components trên JFrame
        String[] colsName = {"Mã Loai", "Tên loai"};
        // đặt tiêu đề cột cho tableModel
        tableModel.setColumnIdentifiers(colsName);
        // kết nối jtable với tableModel
        jTableLoaiSP.setModel(tableModel);
        //gọi hàm ShowData để đưa dữ liệu vào tableModel
        ShowData();
        //goi Ham xoa trang cac TextField
        setNull();
        //Goi ham Khoa cac TextField
        setKhoa(true);
        //Goi vo hieu 2 button Luu, K.Luu. Mo khoa 4 button con lao
        setButton(true);
        jTableLoaiSP.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //Hien thi du lieu len cac JTextField khi Click chuot vao JTable
                try {
                    //Lay chi so dong dang chon
                    int row = jTableLoaiSP.getSelectedRow();
                    String ml = (jTableLoaiSP.getModel().getValueAt(row, 0)).toString();
                    ResultSet rs = lsp.ShowLoaiSP(ml);//Goi ham lay du lieu theo ma loai
                    if (rs.next())//Neu co du lieu
                    {
                        txtMaloai.setText(rs.getString("Maloai"));
                        txtTenloai.setText(rs.getString("Tenloai"));
                    }
                } catch (SQLException ex) {
                }
            }
        });
        btThoat.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dispose();
            }
        });
        btXoa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String ml = txtMaloai.getText();
                try {
                    if (ml.length() == 0)
                        JOptionPane.showMessageDialog(null, "Chon 1 loai SP de xoa",
                                "Thong bao", 1);
                    else {
                        if (JOptionPane.showConfirmDialog(null, "Ban muon xoa loai " + ml + " nay hay khong ? ", " Thong bao", 2) == 0) {
                            lsp.DeleteData(ml);//goi ham xoa du lieu theo ma loai
                            ClearData();//Xoa du lieu trong tableModel
                            ShowData();//Do du lieu vao table Model
                            setNull();//Xoa trang Textfield
                        }
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại", "Thong bao", 1);
                }
            }
        });
        btThem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setNull();//Xoa trang TextField
                setKhoa(false);//Mo khoa TextField
                setButton(false);//Goi ham khoa cac Button
                cothem = true;//Gan cothem = true de ghi nhan trang thai them moi
            }
        });
        btSua.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String ml = txtMaloai.getText();
                if (ml.length() == 0) //Chua chon Ma loai
                    JOptionPane.showMessageDialog(null, "Vui long chon loi can sua", "Thong bao", 1);
                else {
                    setKhoa(false);//Mo khoa cac TextField
                    txtMaloai.enable(false);
                    setButton(false); //Khoa cac Button
                    cothem = false; //Gan cothem=false de ghi nhan trang thai la sua
                }
            }
        });
        btLuu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String ml = txtMaloai.getText();
                String tl = txtTenloai.getText();
                if (ml.length() == 0 || tl.length() == 0)
                    JOptionPane.showMessageDialog(null,
                            "Vui long nhap Ma loai va ten loai", "Thong bao", 1);
                else if (ml.length() > 2 || tl.length() > 30)
                    JOptionPane.showMessageDialog(null,
                            "Ma loai chi 2 ky tu, ten loai la 20", "Thong bao", 1);
                else {
                    try {
                        if (cothem == true) //Luu cho tthem moi
                            lsp.InsertData(ml, tl);
                        else //Luu cho sua
                            lsp.EditData(ml, tl);
                        ClearData(); //goi ham xoa du lieu tron tableModel
                        ShowData(); //Do lai du lieu vao Table Model
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Cap nhat that bai", "Thong bao", 1);
                    }
                    setKhoa(false);
                    setButton(true);
                }
            }
        });
        btKLuu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setNull();
                setKhoa(true);
                setButton(true);
            }
        });
    }

    //Code tu sinh khi thiet ke giao dien va cac code khac ở đây…….
    public static void main(String args[]) throws SQLException {
        JFrame frame = new JFrame("18110377 - Nguyen Huynh Minh Tien");
        frame.setContentPane(new frmCapnhatLoaiSP().pnMain);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        pnMain = new JPanel();
        pnMain.setLayout(new GridLayoutManager(5, 2, new Insets(0, 0, 0, 0), -1, -1));
        pnMain.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$(null, Font.BOLD, 20, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setHorizontalAlignment(0);
        label1.setHorizontalTextPosition(0);
        label1.setText("DANH MỤC LOẠI SẢN PHẨM");
        pnMain.add(label1, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        pnMain.add(panel1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Mã loại");
        panel1.add(label2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(50, -1), null, 0, false));
        txtMaloai = new JTextField();
        panel1.add(txtMaloai, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        pnMain.add(panel2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Tên loại");
        panel2.add(label3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(50, -1), null, 0, false));
        txtTenloai = new JTextField();
        panel2.add(txtTenloai, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(1, 6, new Insets(0, 0, 0, 0), -1, -1));
        pnMain.add(panel3, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        btThem = new JButton();
        btThem.setText("Thêm");
        panel3.add(btThem, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btXoa = new JButton();
        btXoa.setText("Xóa");
        panel3.add(btXoa, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btSua = new JButton();
        btSua.setText("Sửa");
        panel3.add(btSua, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btLuu = new JButton();
        btLuu.setText("Lưu");
        panel3.add(btLuu, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btKLuu = new JButton();
        btKLuu.setText("Ko lưu");
        panel3.add(btKLuu, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btThoat = new JButton();
        btThoat.setText("Thoát");
        panel3.add(btThoat, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        pnMain.add(scrollPane1, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        jTableLoaiSP = new JTable();
        scrollPane1.setViewportView(jTableLoaiSP);
        label2.setLabelFor(txtMaloai);
        label3.setLabelFor(txtTenloai);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return pnMain;
    }

}
