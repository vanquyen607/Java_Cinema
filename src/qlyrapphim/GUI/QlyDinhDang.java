
package GUI;

import java.util.ArrayList;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import qlyrapphim.BUS.DinhDangBUS;
import qlyrapphim.DTO.DinhDang;
public class QlyDinhDang extends javax.swing.JPanel {

    DinhDangBUS dinhDangBUS = new DinhDangBUS();
    
    public QlyDinhDang() {
        initComponents();
        dinhDangBUS.loadTableData(tbDinhDang);
        dinhDangBUS.loadcboxMaMH(cboxMaMH);
        cboxMaMH.setSelectedItem(null);
        dinhDangBUS.loadcboxMaPhim(cboxMaPhim);
        cboxMaPhim.setSelectedItem(null);
        
        // Lắng nghe sự kiện của bảng jTable1
        tbDinhDang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Xử lý sự kiện khi có sự thay đổi trong lựa chọn của bảng
                if (!e.getValueIsAdjusting()) { // Kiểm tra xem sự kiện có phải do người dùng chọn dòng hay không
                    int selectedRow = tbDinhDang.getSelectedRow(); // Lấy chỉ số của dòng được chọn
                    if (selectedRow != -1) { // Kiểm tra xem đã chọn dòng hợp lệ chưa
                        // Lấy thông tin từ dòng được chọn và hiển thị lên các ô nhập liệu
                        Object idObj = tbDinhDang.getValueAt(selectedRow, 0);
                        Object idPhimObj = tbDinhDang.getValueAt(selectedRow, 1);
                        Object tenPhimObj = tbDinhDang.getValueAt(selectedRow, 2);
                        Object idLoaiManHinhObj = tbDinhDang.getValueAt(selectedRow, 3);
                        Object tenLoaiManHinhObj = tbDinhDang.getValueAt(selectedRow, 4);

                        // Kiểm tra xem giá trị từ bảng có null không trước khi chuyển đổi sang chuỗi
                        if (idObj != null && idPhimObj != null && tenPhimObj != null && idLoaiManHinhObj != null && tenLoaiManHinhObj != null) {
                            String id = idObj.toString();
                            String idPhim = idPhimObj.toString();
                            String tenPhim = tenPhimObj.toString();
                            String idLoaiManHinh = idLoaiManHinhObj.toString();
                            String tenLoaiManHinh = tenLoaiManHinhObj.toString();

                            // Hiển thị thông tin lên các ô nhập liệu
                            txtMaDinhDang.setText(id);
                            cboxMaPhim.setSelectedItem(idPhim);
                            txtTenphim.setText(tenPhim);
                            cboxMaMH.setSelectedItem(idLoaiManHinh);
                            txtTenMH.setText(tenLoaiManHinh);
                        }
                    }
                }
            }
        });

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDinhDang = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        txtMaDinhDang = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        cboxMaPhim = new javax.swing.JComboBox<>();
        jPanel13 = new javax.swing.JPanel();
        txtTenphim = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        cboxMaMH = new javax.swing.JComboBox<>();
        jPanel15 = new javax.swing.JPanel();
        txtTenMH = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXem = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jPanel7.setPreferredSize(new java.awt.Dimension(500, 427));

        tbDinhDang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã định dạng", "Mã phim", "Tên phim", "Mã MH", "Tên MH"
            }
        ));
        jScrollPane2.setViewportView(tbDinhDang);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.add(jPanel7);

        jPanel8.setPreferredSize(new java.awt.Dimension(250, 427));

        jLabel6.setText("Mã định dạng");

        jLabel7.setText("Mã phim");

        jLabel8.setText("Tên phim");

        jLabel9.setText("Mã MH");

        jLabel10.setText("Tên MH");

        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMaDinhDang, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(txtMaDinhDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.add(jPanel11);

        cboxMaPhim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxMaPhimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboxMaPhim, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(cboxMaPhim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.add(jPanel12);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTenphim, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(txtTenphim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.add(jPanel13);

        cboxMaMH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxMaMHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboxMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(cboxMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.add(jPanel14);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTenMH, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(txtTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.add(jPanel15);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(207, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel8);

        add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel6.setPreferredSize(new java.awt.Dimension(868, 100));
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 35, 35));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnThem.setText("Thêm ");
        buttonGroup1.add(btnThem);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel6.add(btnThem);

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        buttonGroup1.add(btnXoa);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel6.add(btnXoa);

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        buttonGroup1.add(btnSua);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel6.add(btnSua);

        btnXem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/showall.png"))); // NOI18N
        btnXem.setText("Xem");
        buttonGroup1.add(btnXem);
        btnXem.setPreferredSize(new java.awt.Dimension(88, 31));
        btnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemActionPerformed(evt);
            }
        });
        jPanel6.add(btnXem);

        add(jPanel6, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void cboxMaPhimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxMaPhimActionPerformed
        // TODO add your handling code here:
        // Lấy mục được chọn trong cả hai JComboBox
        String selectedPhimId = (String) cboxMaPhim.getSelectedItem();
        String selectedMHId = (String) cboxMaMH.getSelectedItem();
        
        dinhDangBUS.choiceinCboxMaPhim(txtTenphim, selectedPhimId);
        dinhDangBUS.choiceinCboxMaMH(txtTenMH, selectedMHId);
//        if(selectedPhimId == null && selectedMHId == null){
//            dinhDangBUS.loadTableData(tbDinhDang);
//        }else{
//            dinhDangBUS.loadDataToTable(selectedPhimId, selectedMHId, tbDinhDang);
//        }
    }//GEN-LAST:event_cboxMaPhimActionPerformed

    private void cboxMaMHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxMaMHActionPerformed
        // TODO add your handling code here:
        // Lấy mục được chọn trong cả hai JComboBox
        String selectedPhimId = (String) cboxMaPhim.getSelectedItem();
        String selectedMHId = (String) cboxMaMH.getSelectedItem();
        dinhDangBUS.choiceinCboxMaPhim(txtTenphim, selectedPhimId);
        dinhDangBUS.choiceinCboxMaMH(txtTenMH, selectedMHId);
        
//        if(selectedPhimId == null && selectedMHId == null){
//            dinhDangBUS.loadTableData(tbDinhDang);
//        }else{
//            dinhDangBUS.loadDataToTable(selectedPhimId, selectedMHId, tbDinhDang);
//        }

    }//GEN-LAST:event_cboxMaMHActionPerformed

    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemActionPerformed
        // TODO add your handling code here:
        dinhDangBUS.loadTableData(tbDinhDang);
        dinhDangBUS.loadcboxMaMH(cboxMaMH);
        cboxMaMH.setSelectedItem(null);
        dinhDangBUS.loadcboxMaPhim(cboxMaPhim);
        cboxMaPhim.setSelectedItem(null);
    }//GEN-LAST:event_btnXemActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        String idDinhDang = txtMaDinhDang.getText();
        String idPhim = (String)cboxMaPhim.getSelectedItem();
        String tenPhim = txtTenphim.getText();
        String idLoaiManHinh = (String) cboxMaMH.getSelectedItem();
        String tenMH = txtTenMH.getText();
        
        
        // Kiểm tra xem mã định dạng đã tồn tại hay chưa
        if (dinhDangBUS.kiemTraMaDinhDangTonTai(idDinhDang)) {
            // Nếu mã định dạng đã tồn tại, hiển thị thông báo cảnh báo và không thêm dữ liệu mới
            JOptionPane.showMessageDialog(this, "Mã định dạng đã tồn tại");
            
        }
        else{
            DinhDang dd = new DinhDang(idDinhDang, idPhim, tenPhim, idLoaiManHinh, tenMH);
        
            boolean success = dinhDangBUS.themDuLieu(dd);

            if (success) {
            // Xóa nội dung trên các trường nhập liệu sau khi thêm thành công
            txtMaDinhDang.setText("");
            txtTenphim.setText("");
            txtTenMH.setText("");
            cboxMaPhim.setSelectedItem(null);
            cboxMaMH.setSelectedItem(null);

            // Nếu thêm thành công, tải lại dữ liệu trong bảng
            dinhDangBUS.loadTableData(tbDinhDang);

            // Thông báo thành công
            JOptionPane.showMessageDialog(this, "Thêm dữ liệu thành công");
            } else {
                // Thông báo thất bại
                JOptionPane.showMessageDialog(this, "Thêm dữ liệu thất bại");
            }

            dinhDangBUS.themDuLieu(dd);
            dinhDangBUS.loadTableData(tbDinhDang);
        }
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        String idDinhDang = txtMaDinhDang.getText();
        String idPhim = (String)cboxMaPhim.getSelectedItem();
        String idLoaiManHinh = (String) cboxMaMH.getSelectedItem();
        
        dinhDangBUS.xoaDuLieu(idDinhDang, idPhim, idLoaiManHinh);
        dinhDangBUS.loadTableData(tbDinhDang);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        String idDinhDang = txtMaDinhDang.getText();
        String idPhim = (String)cboxMaPhim.getSelectedItem();
        String tenPhim = txtTenphim.getText();
        String idLoaiManHinh = (String) cboxMaMH.getSelectedItem();
        String tenMH = txtTenMH.getText();
        
        DinhDang dd = new DinhDang(idDinhDang, idPhim, tenPhim, idLoaiManHinh, tenMH);
        
        boolean success = dinhDangBUS.suaDuLieu(dd);
        
        if (success) {
        // Nếu sửa thành công, tải lại dữ liệu trong bảng
        dinhDangBUS.loadTableData(tbDinhDang);
        
        // Xóa nội dung trên các trường nhập liệu sau khi sửa thành công
        txtMaDinhDang.setText("");
        txtTenphim.setText("");
        txtTenMH.setText("");
        cboxMaPhim.setSelectedItem(null);
        cboxMaMH.setSelectedItem(null);
        
        // Thông báo thành công
        JOptionPane.showMessageDialog(this, "Sửa dữ liệu thành công");
    } else {
        // Thông báo thất bại
        JOptionPane.showMessageDialog(this, "Sửa dữ liệu thất bại");
    }
        
        dinhDangBUS.suaDuLieu(dd);
        dinhDangBUS.loadTableData(tbDinhDang);
    }//GEN-LAST:event_btnSuaActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboxMaMH;
    private javax.swing.JComboBox<String> cboxMaPhim;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbDinhDang;
    private javax.swing.JTextField txtMaDinhDang;
    private javax.swing.JTextField txtTenMH;
    private javax.swing.JTextField txtTenphim;
    // End of variables declaration//GEN-END:variables
}
