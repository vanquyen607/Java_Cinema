
package qlyrapphim;

import java.util.Date;
import javax.swing.JOptionPane;
import qlyrapphim.DAO.AccountDAO;
import qlyrapphim.DTO.AccountDTO;
import qlyrapphim.GUI.LichChieu;
import qlyrapphim.GUI.LichChieu;

public class Account extends javax.swing.JFrame {
     private AccountDAO accountDAO;

    public Account() {
        initComponents();
        setLocationRelativeTo(null);
        accountDAO = new AccountDAO();
        jTabbedPane1.setSelectedIndex(1);
    }

    private void initComponentsGUI() {
        // Khởi tạo các thành phần giao diện
        // Thiết lập cấu trúc giao diện
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pndangky = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btndk = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtuser = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        txttype = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        txtCMND = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        pndangnhap = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        txtuserdn = new javax.swing.JTextField();
        txtpassdn = new javax.swing.JPasswordField();
        jPanel11 = new javax.swing.JPanel();
        btnlogin = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(575, 400));

        jTabbedPane1.setBackground(new java.awt.Color(102, 255, 0));

        pndangky.setBackground(new java.awt.Color(204, 204, 255));
        pndangky.setPreferredSize(new java.awt.Dimension(436, 312));
        pndangky.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 110, 15));

        btndk.setText("Đăng ký");
        btndk.setPreferredSize(new java.awt.Dimension(75, 30));
        btndk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndkActionPerformed(evt);
            }
        });
        jPanel3.add(btndk);

        pndangky.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel6.setMinimumSize(new java.awt.Dimension(386, 253));
        jPanel6.setPreferredSize(new java.awt.Dimension(391, 363));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jPanel5.setMinimumSize(new java.awt.Dimension(303, 66));
        jPanel5.setPreferredSize(new java.awt.Dimension(310, 40));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 13));

        jLabel1.setText("USERNAME:");
        jPanel5.add(jLabel1);

        jLabel3.setText("PASS:");
        jPanel5.add(jLabel3);

        jLabel4.setText("TYPE:");
        jPanel5.add(jLabel4);

        jLabel5.setText("ID_NV:");
        jPanel5.add(jLabel5);

        jLabel6.setText("CMND:");
        jPanel5.add(jLabel6);

        jLabel7.setText("NAME:");
        jPanel5.add(jLabel7);

        jLabel8.setText("DATE:");
        jPanel5.add(jLabel8);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = -237;
        gridBagConstraints.ipady = 170;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 73, 12, 0);
        jPanel6.add(jPanel5, gridBagConstraints);

        jPanel7.setMinimumSize(new java.awt.Dimension(84, 202));
        jPanel7.setPreferredSize(new java.awt.Dimension(100, 245));
        jPanel7.setLayout(new java.awt.GridLayout(7, 1, 0, 3));
        jPanel7.add(txtuser);
        jPanel7.add(txtpass);
        jPanel7.add(txttype);
        jPanel7.add(txtid);
        jPanel7.add(txtCMND);

        txtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenActionPerformed(evt);
            }
        });
        jPanel7.add(txtHoTen);
        jPanel7.add(txtNgaySinh);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 90;
        gridBagConstraints.ipady = -2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 12, 0);
        jPanel6.add(jPanel7, gridBagConstraints);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("ĐĂNG KÝ");
        jPanel12.add(jLabel12);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 282;
        gridBagConstraints.ipady = -2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 6);
        jPanel6.add(jPanel12, gridBagConstraints);

        pndangky.add(jPanel6, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Đăng ký", pndangky);

        pndangnhap.setLayout(new java.awt.BorderLayout());

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel10.setText("USERNAME:");
        jPanel9.add(jLabel10);

        jLabel11.setText("PASS:");
        jPanel9.add(jLabel11);

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 107, 70, 74));

        jPanel10.setLayout(new java.awt.GridLayout(2, 1, 0, 15));
        jPanel10.add(txtuserdn);
        jPanel10.add(txtpassdn);

        jPanel8.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 113, 168, -1));

        btnlogin.setText("Đăng nhập");
        btnlogin.setPreferredSize(new java.awt.Dimension(88, 30));
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        jPanel11.add(btnlogin);

        jPanel8.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 151, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("ĐĂNG NHẬP");
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 40, 563, 61));

        pndangnhap.add(jPanel8, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("Đăng nhập", pndangnhap);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenActionPerformed

    private void btndkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndkActionPerformed
        // TODO add your handling code here:
       String UserName = txtuser.getText();
       String Pass = new String(txtpass.getPassword());
       int LoaiTK = 0;
       int CMND = 0;
       String idNV = "";
       String HoTen = "";
       Date NgaySinh = null;

       // Kiểm tra và chuyển đổi kiểu dữ liệu của trường txttype
       try {
    LoaiTK = Integer.parseInt(txttype.getText());
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Loại tài khoản không hợp lệ!");
    return; // Ngăn việc thêm tài khoản nếu loại tài khoản không hợp lệ
}

if (LoaiTK != 1 && LoaiTK != 2) {
    JOptionPane.showMessageDialog(this, "Loại tài khoản không hợp lệ! Chỉ chấp nhận giá trị 1 hoặc 2.");
    return; // Ngăn việc thêm tài khoản nếu loại tài khoản không hợp lệ
}

// Kiểm tra ngày sinh
NgaySinh = txtNgaySinh.getDate();
if (NgaySinh == null) {
    JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày sinh!");
    return; // Ngăn việc thêm tài khoản nếu ngày sinh không được chọn
}

// Lấy giá trị từ trường nhập liệu
idNV = txtid.getText();
HoTen = txtHoTen.getText();

// Kiểm tra và chuyển đổi kiểu dữ liệu của trường txtCMND
String cmndString = txtCMND.getText();
if (!cmndString.matches("^0\\d{8}$")) {
    JOptionPane.showMessageDialog(this, "CMND không hợp lệ! Phải bắt đầu từ số 0 và có đúng 8 chữ số.");
    return; // Ngăn việc thêm tài khoản nếu CMND không hợp lệ
}

try {
    CMND = Integer.parseInt(cmndString);
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "CMND không hợp lệ!");
    return; // Ngăn việc thêm tài khoản nếu CMND không hợp lệ
}

if (!idNV.matches("^NV(0\\d{1}|[1-9]\\d?)$")) {
    JOptionPane.showMessageDialog(this, "ID nhân viên không hợp lệ! Định dạng phải là NV + số từ 01 đến 100.");
    return; // Ngăn việc thêm tài khoản nếu idNV không hợp lệ
}

// Tạo một đối tượng AccountDTO từ dữ liệu người dùng nhập vào
AccountDTO account = new AccountDTO(UserName, Pass, LoaiTK, idNV, CMND, HoTen, NgaySinh);

// Thêm tài khoản vào cơ sở dữ liệu
boolean success = accountDAO.addAccount(account);

// Hiển thị thông báo
if (success) {
    JOptionPane.showMessageDialog(this, "Thêm tài khoản thành công!");
} else {
    JOptionPane.showMessageDialog(this, "Thêm tài khoản thất bại!");
}
           
           txtuser.setText("");
            txtpass.setText("");
            txttype.setText("");
            txtCMND.setText("");
            txtid.setText("");
            txtHoTen.setText("");
            txtNgaySinh.setDate(null);

    // Biến lưu trữ thông tin kết nối cơ sở dữ liệu
    }//GEN-LAST:event_btndkActionPerformed

    
    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        // TODO add your handling code here:
        String UserName = txtuserdn.getText();
        String Pass = new String(txtpassdn.getPassword());

        // Kiểm tra đăng nhập
        boolean loginSuccess = accountDAO.checkLogin(UserName, Pass);

        // Nếu đăng nhập thành công
        if (loginSuccess) {
            // Lấy loại tài khoản của người dùng
            int loaiTK = accountDAO.getLoaiTaiKhoan(UserName); 

            // Hiển thị thông báo đăng nhập thành công
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");

            // Kiểm tra và hiển thị form phù hợp
            if (loaiTK == 1) { // Loại tài khoản là admin
            // Hiển thị form quản lý
                mainform quanLyForm = new mainform();
                quanLyForm.setVisible(true);
                this.dispose(); // Đóng form đăng nhập sau khi đăng nhập thành công
            } else if (loaiTK == 2) { // Loại tài khoản là nhân viên
                // Hiển thị form bán vé
                LichChieu banVeForm = new LichChieu();
                banVeForm.setVisible(true);
                this.dispose(); // Đóng form đăng nhập sau khi đăng nhập thành công
            }
            } else {
            // Hiển thị thông báo đăng nhập thất bại
            JOptionPane.showMessageDialog(this, "Đăng nhập thất bại!");
        }
            txtuserdn.setText("");
            txtpassdn.setText("");
    }//GEN-LAST:event_btnloginActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Account().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndk;
    private javax.swing.JButton btnlogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pndangky;
    private javax.swing.JPanel pndangnhap;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtHoTen;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JTextField txtid;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JPasswordField txtpassdn;
    private javax.swing.JTextField txttype;
    private javax.swing.JTextField txtuser;
    private javax.swing.JTextField txtuserdn;
    // End of variables declaration//GEN-END:variables
}
