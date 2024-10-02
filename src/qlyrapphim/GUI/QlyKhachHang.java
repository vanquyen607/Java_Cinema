
package qlyrapphim.GUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import qlyrapphim.BUS.KhachHangBUS;
import qlyrapphim.DTO.KhachHang;
import qlyrapphim.DAO.KhachHangDao;

public class QlyKhachHang extends javax.swing.JPanel {

    KhachHangBUS khachHangBUS;
    public QlyKhachHang() {
        initComponents();
        loadTableData();
        tbKhachHang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                updateTextFieldFromSelectedRow();
            }
        });
        cboxSearch.setSelectedIndex(1);
    }
    
    public JTable Mytable(){
        return tbKhachHang;
    }
    
    private void loadTableData() {
        khachHangBUS = new KhachHangBUS();
        khachHangBUS.loadTableData(tbKhachHang); // Truyền bảng vào để cập nhật dữ liệu
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnXemKH = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnThemKH = new javax.swing.JButton();
        btnSuaKH = new javax.swing.JButton();
        btnXoaKH = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        cboxSearch = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnTimKH = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtHoTenKH = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        txtCmnd = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jSpDiemtichluy = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbKhachHang = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(700, 600));
        setPreferredSize(new java.awt.Dimension(700, 600));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(808, 300));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setMinimumSize(new java.awt.Dimension(492, 80));
        jPanel3.setPreferredSize(new java.awt.Dimension(832, 50));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.X_AXIS));

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));

        btnXemKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/showall.png"))); // NOI18N
        btnXemKH.setText("Xem");
        btnXemKH.setPreferredSize(new java.awt.Dimension(88, 35));
        btnXemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemKHActionPerformed(evt);
            }
        });
        jPanel5.add(btnXemKH);

        jPanel3.add(jPanel5);

        jPanel6.setPreferredSize(new java.awt.Dimension(300, 0));
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 10));

        btnThemKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnThemKH.setText("Thêm");
        btnThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKHActionPerformed(evt);
            }
        });
        jPanel6.add(btnThemKH);

        btnSuaKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        btnSuaKH.setText("Sửa");
        btnSuaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaKHActionPerformed(evt);
            }
        });
        jPanel6.add(btnSuaKH);

        btnXoaKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnXoaKH.setText("Xóa");
        btnXoaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKHActionPerformed(evt);
            }
        });
        jPanel6.add(btnXoaKH);

        jPanel3.add(jPanel6);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 10));

        cboxSearch.setBackground(new java.awt.Color(0, 255, 255));
        cboxSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã KH", "Tên KH", "SĐT", "CMND" }));
        jPanel7.add(cboxSearch);

        txtSearch.setPreferredSize(new java.awt.Dimension(200, 30));
        txtSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchCaretUpdate(evt);
            }
        });
        jPanel7.add(txtSearch);

        btnTimKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.png"))); // NOI18N
        btnTimKH.setText("Tìm");
        btnTimKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKHActionPerformed(evt);
            }
        });
        jPanel7.add(btnTimKH);

        jPanel3.add(jPanel7);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(813, 250));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mã KH:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Họ Tên:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Ngày Sinh:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHoTenKH))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgaySinh)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtHoTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(txtNgaySinh))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel8);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("SĐT:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("CMND:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Địa Chỉ:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(txtSdt)
                    .addComponent(txtCmnd))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel9);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Điểm Tích Lũy:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("*Note: Mã KH là duy nhất và không được điều chỉnh");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpDiemtichluy, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpDiemtichluy, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jLabel8)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel10);

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        tbKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Khách Hàng", "Họ Tên", "Ngày Sinh", "Địa Chỉ", "SĐT", "CMND", "Điểm Tích Lũy"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbKhachHang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void updateTextFieldFromSelectedRow() {
    int selectedRow = tbKhachHang.getSelectedRow();
    if (selectedRow != -1) {
        // Lấy dữ liệu từ bảng và cập nhật lên các ô văn bản tương ứng
        txtMaKH.setText(tbKhachHang.getValueAt(selectedRow, 0).toString());
        txtHoTenKH.setText(tbKhachHang.getValueAt(selectedRow, 1).toString());
        txtNgaySinh.setText(tbKhachHang.getValueAt(selectedRow, 2).toString());
        txtDiaChi.setText(tbKhachHang.getValueAt(selectedRow, 3).toString());
        txtSdt.setText(tbKhachHang.getValueAt(selectedRow, 4).toString());
        txtCmnd.setText(tbKhachHang.getValueAt(selectedRow, 5).toString());
        jSpDiemtichluy.setValue(Integer.parseInt(tbKhachHang.getValueAt(selectedRow, 6).toString()));
    }
}
    
    private void btnThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKHActionPerformed
        // TODO add your handling code here:
        // Lấy thông tin từ các trường nhập liệu
        String MaKH = txtMaKH.getText().trim();
        String hoTen = txtHoTenKH.getText().trim();
        String ngaySinh = txtNgaySinh.getText().trim();
        String diaChi = txtDiaChi.getText().trim();
        String sdt = txtSdt.getText().trim();
        String cmnd = txtCmnd.getText().trim();
        int diemTichLuy = (int) jSpDiemtichluy.getValue();

        // Kiểm tra trống
        if (MaKH.isEmpty() || hoTen.isEmpty() || ngaySinh.isEmpty() || diaChi.isEmpty() || sdt.isEmpty() || cmnd.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.");
            return;
        }
        
        // Kiểm tra trùng lặp mã khách hàng
        if (khachHangBUS.isMaKHTaken(MaKH)) {
            JOptionPane.showMessageDialog(this, "Mã khách hàng đã tồn tại. Vui lòng chọn mã khác.");
            txtMaKH.requestFocus();
            return;
        }
        
        // Kiểm tra định dạng ngày sinh
        try {
            java.sql.Date.valueOf(ngaySinh); // Nếu không đúng định dạng sẽ throw IllegalArgumentException
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
            return;
        }

        // Kiểm tra định dạng số điện thoại
        if (!sdt.matches("^09\\d{8}$")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ.");
            txtSdt.requestFocus();
            return;
        }
        
        // Kiểm tra trùng lặp số điện thoại
        if (khachHangBUS.isSdtTaken(sdt)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại. Vui lòng nhập số điện thoại khác.");
            txtSdt.requestFocus();
            return;
        }
        

        // Kiểm tra định dạng CMND
        if (!cmnd.matches("\\d{9}")) {
            JOptionPane.showMessageDialog(this, "Số CMND không hợp lệ. Vui lòng nhập 9 chữ số.");
            txtCmnd.requestFocus();
            return;
        }
        
        // Kiểm tra trùng lặp số CMND
        if (khachHangBUS.isCmndTaken(cmnd)) {
            JOptionPane.showMessageDialog(this, "Số CMND đã tồn tại. Vui lòng nhập số CMND khác.");
            txtCmnd.requestFocus();
            return;
        }
        
        // Kiểm tra điểm tích lũy không được là số âm
        if (diemTichLuy < 0) {
            JOptionPane.showMessageDialog(this, "Điểm tích lũy không được là số âm.");
            return;
        }


        KhachHang KH = new KhachHang(MaKH, hoTen, diaChi, sdt, ngaySinh, cmnd, diemTichLuy);
        
        // Sau khi kiểm tra, thêm khách hàng vào cơ sở dữ liệu và cập nhật bảng
        khachHangBUS.themKhachHang(KH);
        khachHangBUS.loadTableData(tbKhachHang);
        
    txtMaKH.setText("");
    txtHoTenKH.setText("");
    txtNgaySinh.setText("");
    txtDiaChi.setText("");
    txtSdt.setText("");
    txtCmnd.setText("");
    jSpDiemtichluy.setValue(0);
    }//GEN-LAST:event_btnThemKHActionPerformed

    private void btnSuaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaKHActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbKhachHang.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một khách hàng để sửa!");
            return;
        }
        txtMaKH.setEnabled(false);
        String id = (String) tbKhachHang.getValueAt(selectedRow, 0);
        String hoTen = txtHoTenKH.getText();
        String ngaySinh = txtNgaySinh.getText();
        String diaChi = txtDiaChi.getText();
        String sdt = txtSdt.getText();
        String cmnd = txtCmnd.getText();
        int diemTichLuy = (int) jSpDiemtichluy.getValue();

        // Kiểm tra trống
        if ( hoTen.isEmpty() || ngaySinh.isEmpty() || diaChi.isEmpty() || sdt.isEmpty() || cmnd.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.");
            return;
        }
               
        // Kiểm tra định dạng ngày sinh
        try {
            java.sql.Date.valueOf(ngaySinh); // Nếu không đúng định dạng sẽ throw IllegalArgumentException
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
            return;
        }

        // Kiểm tra định dạng số điện thoại
        if (!sdt.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ. Vui lòng nhập 10 chữ số.");
            txtSdt.requestFocus();
            return;
        }
        
        // Kiểm tra trùng lặp số điện thoại
        if (khachHangBUS.isSdtTaken(sdt)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại. Vui lòng nhập số điện thoại khác.");
            txtSdt.requestFocus();
            return;
        }
        

        // Kiểm tra định dạng CMND
        if (!cmnd.matches("\\d{9}")) {
            JOptionPane.showMessageDialog(this, "Số CMND không hợp lệ. Vui lòng nhập 9 chữ số.");
            txtCmnd.requestFocus();
            return;
        }
        
        // Kiểm tra trùng lặp số CMND
        if (khachHangBUS.isCmndTaken(cmnd)) {
            JOptionPane.showMessageDialog(this, "Số CMND đã tồn tại. Vui lòng nhập số CMND khác.");
            txtCmnd.requestFocus();
            return;
        }
        
        // Kiểm tra điểm tích lũy không được là số âm
        if (diemTichLuy < 0) {
            JOptionPane.showMessageDialog(this, "Điểm tích lũy không được là số âm.");
            return;
        }
        

        KhachHang KH = new KhachHang(id, hoTen, diaChi, sdt, ngaySinh, cmnd, diemTichLuy);
        
        khachHangBUS.suaKhachHang(KH);
        txtMaKH.setEnabled(true);
        khachHangBUS.loadTableData(tbKhachHang);
        
    txtMaKH.setText("");
    txtHoTenKH.setText("");
    txtNgaySinh.setText("");
    txtDiaChi.setText("");
    txtSdt.setText("");
    txtCmnd.setText("");
    jSpDiemtichluy.setValue(0);
    }//GEN-LAST:event_btnSuaKHActionPerformed

    private void btnXoaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKHActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbKhachHang.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một khách hàng để xóa!");
            return;
        }

        String id = (String) tbKhachHang.getValueAt(selectedRow, 0);
        
        khachHangBUS.xoaKhachHang(id);
        khachHangBUS.loadTableData(tbKhachHang);
    }//GEN-LAST:event_btnXoaKHActionPerformed

    private void btnXemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemKHActionPerformed
        // TODO add your handling code here:
        khachHangBUS.loadTableData(tbKhachHang);
        txtMaKH.setEnabled(true);

    }//GEN-LAST:event_btnXemKHActionPerformed

    private void btnTimKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKHActionPerformed
        // TODO add your handling code here:
        String valuecantim = txtSearch.getText().trim();
        if(valuecantim.isEmpty() || valuecantim.equals("") ){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập nội dung cần tìm !");
            return;
        }
        String optionsearch = (String)cboxSearch.getSelectedItem();
            // Gọi phương thức tìm kiếm khách hàng từ lớp BUS
            khachHangBUS.searchKhachHangByOption(tbKhachHang, valuecantim, optionsearch);               
    }//GEN-LAST:event_btnTimKHActionPerformed

    private void txtSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchCaretUpdate
        // TODO add your handling code here:
        if (txtSearch.getText().equals("")) {
            khachHangBUS.loadTableData(tbKhachHang);
        }
    }//GEN-LAST:event_txtSearchCaretUpdate

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaKH;
    private javax.swing.JButton btnThemKH;
    private javax.swing.JButton btnTimKH;
    private javax.swing.JButton btnXemKH;
    private javax.swing.JButton btnXoaKH;
    private javax.swing.JComboBox<String> cboxSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpDiemtichluy;
    private javax.swing.JTable tbKhachHang;
    private javax.swing.JTextField txtCmnd;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoTenKH;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
