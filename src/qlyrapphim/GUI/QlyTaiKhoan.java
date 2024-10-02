
package qlyrapphim.GUI;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import qlyrapphim.BUS.TaiKhoanBUS;
import qlyrapphim.DTO.TaiKhoan;

public class QlyTaiKhoan extends javax.swing.JPanel {

    TaiKhoanBUS taiKhoanBUS = new TaiKhoanBUS();
    
    public QlyTaiKhoan() {
        initComponents();
        taiKhoanBUS.loadTableData(jTable2);
        taiKhoanBUS.loadCboxMaNV(cboxMaNV);
        
        // Thêm sự kiện lắng nghe khi người dùng chọn một dòng từ bảng
        jTable2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Kiểm tra xem sự kiện có phải là kết thúc việc chọn không
                if (!e.getValueIsAdjusting()) {
                    // Lấy chỉ số của dòng được chọn
                    int selectedRow = jTable2.getSelectedRow();
                    if (selectedRow != -1) { // Kiểm tra xem có dòng nào được chọn không
                        // Lấy thông tin từ dòng được chọn
                        String username = jTable2.getValueAt(selectedRow, 0).toString();
                        String loaitk = jTable2.getValueAt(selectedRow, 1).toString();
                        String manv = jTable2.getValueAt(selectedRow, 2).toString();
                        String tennv = jTable2.getValueAt(selectedRow, 3).toString();

                        // Hiển thị thông tin lên các ô nhập liệu
                        txtUsername.setText(username);
                        cboxMaNV.setSelectedItem(manv);
                        txtTenNV.setText(tennv);
                        
//                        spLoaiNV.setToolTipText(loaitk);
//                        // Chọn loại tài khoản tương ứng trong JComboBox
//                        if (loaitk.equals("1")) {
//                           spLoaiNV.setValue("1"); // Chọn loại tài khoản "1"
//                        } else if (loaitk.equals("2")) {
//                            spLoaiNV.setValue("2"); // Chọn loại tài khoản "2"
//                        }
                    }
                }
            }
        });

    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnResetPass = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnXem = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txtTim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblMaNV = new javax.swing.JLabel();
        cboxMaNV = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        lblLoaiNV = new javax.swing.JLabel();
        lblTenNV = new javax.swing.JLabel();
        spLoaiNV = new javax.swing.JSpinner();
        txtTenNV = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(687, 180));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel7.setPreferredSize(new java.awt.Dimension(180, 130));

        btnResetPass.setText("Reset mật khẩu");
        btnResetPass.setPreferredSize(new java.awt.Dimension(111, 30));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnResetPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(btnResetPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel7, java.awt.BorderLayout.LINE_END);

        jPanel8.setPreferredSize(new java.awt.Dimension(687, 40));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel4.setPreferredSize(new java.awt.Dimension(130, 50));

        btnXem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/showall.png"))); // NOI18N
        btnXem.setText("Xem");
        btnXem.setPreferredSize(new java.awt.Dimension(88, 31));
        btnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemActionPerformed(evt);
            }
        });
        jPanel4.add(btnXem);

        jPanel8.add(jPanel4, java.awt.BorderLayout.LINE_START);

        jPanel5.setPreferredSize(new java.awt.Dimension(230, 50));

        txtTim.setPreferredSize(new java.awt.Dimension(125, 30));
        jPanel5.add(txtTim);

        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.png"))); // NOI18N
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });
        jPanel5.add(btnTim);

        jPanel8.add(jPanel5, java.awt.BorderLayout.LINE_END);

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel6.add(btnThem);

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel6.add(btnSua);

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel6.add(btnXoa);

        jPanel8.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel8, java.awt.BorderLayout.PAGE_END);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin tài khoản"));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setPreferredSize(new java.awt.Dimension(203, 107));

        lblUsername.setText("Username");

        txtUsername.setPreferredSize(new java.awt.Dimension(64, 30));

        lblMaNV.setText("Mã NV");

        cboxMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxMaNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsername)
                    .addComponent(lblMaNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cboxMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaNV)
                    .addComponent(cboxMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel1);

        jPanel3.setPreferredSize(new java.awt.Dimension(203, 107));

        lblLoaiNV.setText("Loại TK");

        lblTenNV.setText("Tên NV");

        spLoaiNV.setModel(new javax.swing.SpinnerNumberModel(1, 1, 2, 1));
        spLoaiNV.setPreferredSize(new java.awt.Dimension(64, 30));

        txtTenNV.setPreferredSize(new java.awt.Dimension(64, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblLoaiNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addComponent(spLoaiNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLoaiNV)
                    .addComponent(spLoaiNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenNV)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel3);

        jPanel2.add(jPanel9, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Username", "Loại TK", "Mã NV", "Tên NV"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        String username = txtUsername.getText();
        String manv = (String)cboxMaNV.getSelectedItem();
        String tennv = txtTenNV.getText();

        // Lấy giá trị từ spinner thay vì lấy văn bản gợi ý
        int loaitkValue = (int) spLoaiNV.getValue();
        String loaitk = String.valueOf(loaitkValue);


        // Kiểm tra trường rỗng
        if (username.isEmpty() || manv.isEmpty() || tennv.isEmpty() || loaitk.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin");
            return;
        }
        
        // Kiểm tra xem nhân viên đã có tài khoản chưa
        if (taiKhoanBUS.daTonTaiMaNhanVien(manv)) {
            JOptionPane.showMessageDialog(this, "Nhân viên này đã có tài khoản.");
            return;
        }

        // Kiểm tra định dạng loaitk
        if (!loaitk.matches("[12]")) {
                JOptionPane.showMessageDialog(this, "Loại tài khoản phải là 1 hoặc 2");
                return;
        }

        // Kiểm tra username đã tồn tại
        if (taiKhoanBUS.daTonTaiTenDangNhap(username)) {
                JOptionPane.showMessageDialog(this, "Tên đăng nhập đã tồn tại. Vui lòng chọn tên khác");
                return;
        }
        
        // Yêu cầu người dùng nhập mật khẩu
        String password = JOptionPane.showInputDialog(this, "Nhập mật khẩu:");
        // Kiểm tra xem người dùng đã nhập mật khẩu hay chưa
        if (password == null || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn phải nhập mật khẩu");
            return;
        }
        TaiKhoan TK = new TaiKhoan(manv, tennv, username, loaitk);
        
        boolean success = taiKhoanBUS.themDuLieu(TK);

        // Nếu thêm dữ liệu thành công, thực hiện cài đặt mật khẩu
        if (success) {
            // Thực hiện cài đặt mật khẩu trong cơ sở dữ liệu
            boolean setPasswordSuccess = taiKhoanBUS.setMatKhau(username, password);
            if (setPasswordSuccess) {
                JOptionPane.showMessageDialog(this, "Thêm dữ liệu và cài đặt mật khẩu thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm dữ liệu thành công, nhưng cài đặt mật khẩu thất bại");
            }
            taiKhoanBUS.loadTableData(jTable2);
            
        txtUsername.setText("");
        txtTenNV.setText("");
        spLoaiNV.setValue(1);
            
        } else {
            JOptionPane.showMessageDialog(this, "Thêm dữ liệu thất bại");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        // Lấy thông tin từ các trường nhập liệu
        String username = txtUsername.getText();
        String manv = (String) cboxMaNV.getSelectedItem();
        String tennv = txtTenNV.getText();
        String loaitk = spLoaiNV.getToolTipText();

        // Kiểm tra trường rỗng
        if (username.isEmpty() || manv.isEmpty() || tennv.isEmpty() || loaitk.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin");
            return;
        }

        // Kiểm tra định dạng loaitk
        if (!loaitk.matches("[12]")) {
            JOptionPane.showMessageDialog(this, "Loại tài khoản phải là 1 hoặc 2");
            return;
        }

        TaiKhoan TK = new TaiKhoan(manv, tennv, username, loaitk);
        // Thực hiện sửa dữ liệu
        boolean success = taiKhoanBUS.suaDuLieu(TK);

        // Hiển thị kết quả sửa dữ liệu
        if (success) {
            JOptionPane.showMessageDialog(this, "Sửa dữ liệu thành công");
            taiKhoanBUS.loadTableData(jTable2);
        } else {
            JOptionPane.showMessageDialog(this, "Sửa dữ liệu thất bại");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        // Lấy mã nhân viên từ trường nhập liệu
        String manv = (String) cboxMaNV.getSelectedItem();

        // Kiểm tra trường rỗng
        if (manv.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên cần xóa");
            return;
        }

        // Thực hiện xóa dữ liệu
        boolean success = taiKhoanBUS.xoaDuLieu(manv);

        // Hiển thị kết quả xóa dữ liệu
        if (success) {
            JOptionPane.showMessageDialog(this, "Xóa dữ liệu thành công");
            taiKhoanBUS.loadTableData(jTable2);
        } else {
            JOptionPane.showMessageDialog(this, "Xóa dữ liệu thất bại");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemActionPerformed
        // TODO add your handling code here:
        taiKhoanBUS.loadTableData(jTable2);
        taiKhoanBUS.loadCboxMaNV(cboxMaNV);
    }//GEN-LAST:event_btnXemActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        // Lấy từ khóa tìm kiếm từ ô nhập liệu
        String tenCanTim = txtTim.getText().trim();

        // Kiểm tra xem từ khóa tìm kiếm có rỗng không
        if (tenCanTim.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa tìm kiếm");
            return;
        }

        // Thực hiện tìm kiếm và cập nhật bảng hiển thị
        boolean result = taiKhoanBUS.searchTaiKhoan(jTable2, tenCanTim);

        // Kiểm tra kết quả tìm kiếm và hiển thị thông báo tương ứng
        if (result) {
            
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả");
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void cboxMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxMaNVActionPerformed
        // TODO add your handling code here:
        // Lấy mã nhân viên đã chọn từ JComboBox
        String selectedMaNV = (String) cboxMaNV.getSelectedItem();

        // Tìm tên nhân viên tương ứng với mã nhân viên đã chọn
        String tenNV = taiKhoanBUS.getTenNhanVien(selectedMaNV);

        // Hiển thị tên nhân viên trong JTextField
        txtTenNV.setText(tenNV);
    }//GEN-LAST:event_cboxMaNVActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton btnResetPass;
    javax.swing.JButton btnSua;
    javax.swing.JButton btnThem;
    javax.swing.JButton btnTim;
    javax.swing.JButton btnXem;
    javax.swing.JButton btnXoa;
    javax.swing.JComboBox<String> cboxMaNV;
    javax.swing.JPanel jPanel1;
    javax.swing.JPanel jPanel2;
    javax.swing.JPanel jPanel3;
    javax.swing.JPanel jPanel4;
    javax.swing.JPanel jPanel5;
    javax.swing.JPanel jPanel6;
    javax.swing.JPanel jPanel7;
    javax.swing.JPanel jPanel8;
    javax.swing.JPanel jPanel9;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JTable jTable2;
    javax.swing.JLabel lblLoaiNV;
    javax.swing.JLabel lblMaNV;
    javax.swing.JLabel lblTenNV;
    javax.swing.JLabel lblUsername;
    javax.swing.JSpinner spLoaiNV;
    javax.swing.JTextField txtTenNV;
    javax.swing.JTextField txtTim;
    javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
