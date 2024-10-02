
package qlyrapphim.GUI;

import javax.swing.JOptionPane;
import qlyrapphim.BUS.TheLoaiBUS;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import qlyrapphim.DTO.TheLoai;

public class QlyTheLoai extends javax.swing.JPanel {

    TheLoaiBUS theLoaiBUS = new TheLoaiBUS();
    public QlyTheLoai() {
        initComponents();
        theLoaiBUS.loadTableData(jTable1);
        
        // Lắng nghe sự kiện của bảng jTable1
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Xử lý sự kiện khi có sự thay đổi trong lựa chọn của bảng
                if (!e.getValueIsAdjusting()) { // Kiểm tra xem sự kiện có phải do người dùng chọn dòng hay không
                    int selectedRow = jTable1.getSelectedRow(); // Lấy chỉ số của dòng được chọn
                    if (selectedRow != -1) { // Kiểm tra xem đã chọn dòng hợp lệ chưa
                        // Lấy thông tin từ dòng được chọn và hiển thị lên các ô nhập liệu
                        Object matheloaiObj = jTable1.getValueAt(selectedRow, 0);
                        Object tentheloaiObj = jTable1.getValueAt(selectedRow, 1);
                        Object motaObj = jTable1.getValueAt(selectedRow, 2);

                        // Kiểm tra xem giá trị từ bảng có null không trước khi chuyển đổi sang chuỗi
                        if (matheloaiObj != null && tentheloaiObj != null && motaObj != null) {
                            String matheloai = matheloaiObj.toString();
                            String tentheloai = tentheloaiObj.toString();
                            String mota = motaObj.toString();

                            // Hiển thị thông tin lên các ô nhập liệu
                            txtMatheloai.setText(matheloai);
                            txtTentheloai.setText(tentheloai);
                            txtMota.setText(mota);
                        }
                    }
                }
            }
        }); 

    }

    public void loadTableData(){
        theLoaiBUS.loadTableData(jTable1);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtMatheloai = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        txtTentheloai = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMota = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnXem = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setPreferredSize(new java.awt.Dimension(500, 314));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã thể loại", "Tên thể loại", "Mô tả"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mã Thể loại");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tên thể loại");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Mô tả");

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtMatheloai, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(txtMatheloai, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        jPanel5.add(jPanel6);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtTentheloai, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(txtTentheloai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel7);

        txtMota.setColumns(20);
        txtMota.setRows(5);
        jScrollPane2.setViewportView(txtMota);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel8);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("*Lưu ý: Mã TL là duy nhất , không thay đổi");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(3, 3, 3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(2, 2, 2))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setPreferredSize(new java.awt.Dimension(733, 80));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 30));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        buttonGroup1.add(btnThem);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel2.add(btnThem);

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        buttonGroup1.add(btnSua);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel2.add(btnSua);

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        buttonGroup1.add(btnXoa);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel2.add(btnXoa);

        btnXem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/showall.png"))); // NOI18N
        btnXem.setText("Xem");
        buttonGroup1.add(btnXem);
        btnXem.setPreferredSize(new java.awt.Dimension(88, 30));
        btnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemActionPerformed(evt);
            }
        });
        jPanel2.add(btnXem);

        add(jPanel2, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        // Lấy thông tin từ các trường nhập liệu
    String matheloai = txtMatheloai.getText();
    String tentheloai = txtTentheloai.getText();
    String mota = txtMota.getText();
    
    // Kiểm tra xem các trường nhập liệu có được điền đầy đủ không
    if (matheloai.isEmpty() || tentheloai.isEmpty() || mota.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin");
        return; // Không thực hiện thêm nếu thiếu thông tin
    }
    
    // Kiểm tra xem mã thể loại đã tồn tại trong cơ sở dữ liệu chưa
    if (theLoaiBUS.checkMaTheLoai(matheloai)) {
        JOptionPane.showMessageDialog(this, "Mã Thể loại đã tồn tại. Vui lòng chọn mã khác.");
        return; // Không thực hiện thêm nếu mã thể loại đã tồn tại
    }
    
    TheLoai TL = new TheLoai(matheloai, tentheloai, mota);
    
    // Gọi phương thức backend để thêm một mục mới
    boolean success = theLoaiBUS.insertTheLoai(TL);
    
    // Kiểm tra xem thêm mục mới có thành công hay không và cập nhật giao diện
    if (success) {
        // Nạp lại dữ liệu vào bảng sau khi thêm mục mới
        theLoaiBUS.loadTableData(jTable1);
        
        // Xóa nội dung trên các trường nhập liệu sau khi thêm thành công
        txtTentheloai.setText("");
        txtMatheloai.setText("");
        txtMota.setText("");
        
        JOptionPane.showMessageDialog(this, "Thêm Thể loại thành công");
    } else {
        JOptionPane.showMessageDialog(this, "Thêm Thể loại thất bại");
    }
        
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemActionPerformed
        // TODO add your handling code here:
        theLoaiBUS.loadTableData(jTable1);
        cleartxt();
        
    }//GEN-LAST:event_btnXemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        // Lấy thông tin từ các trường nhập liệu
    String matheloai = txtMatheloai.getText();
    String tentheloai = txtTentheloai.getText();
    String mota = txtMota.getText();
    
    // Kiểm tra xem các trường nhập liệu có được điền đầy đủ không
    if (matheloai.isEmpty() || tentheloai.isEmpty() || mota.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin");
        return; // Không thực hiện sửa nếu thiếu thông tin
    }
    
    // Kiểm tra xem mã thể loại đã tồn tại trong cơ sở dữ liệu hay không
    if (!theLoaiBUS.checkMaTheLoai(matheloai)) {
        JOptionPane.showMessageDialog(this, "Mã Thể loại không tồn tại. Vui lòng kiểm tra lại.");
        return; // Không thực hiện sửa nếu mã thể loại không tồn tại
    }
    
    TheLoai TL = new TheLoai(mota, tentheloai, mota);
    // Gọi phương thức backend để cập nhật thông tin của mục "Thể loại"
    boolean success = theLoaiBUS.updateTheLoai(TL);
    
    // Kiểm tra xem cập nhật có thành công hay không và cập nhật giao diện
    if (success) {
        // Nạp lại dữ liệu vào bảng sau khi cập nhật mục "Thể loại"
        theLoaiBUS.loadTableData(jTable1);
        
        // Xóa nội dung trên các trường nhập liệu sau khi sửa thành công
        txtMatheloai.setText("");
        txtTentheloai.setText("");
        txtMota.setText("");
        
        JOptionPane.showMessageDialog(this, "Cập nhật Thể loại thành công");
        cleartxt();
    } else {
        JOptionPane.showMessageDialog(this, "Cập nhật Thể loại thất bại");
    }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        // Lấy chỉ số của dòng được chọn
        int selectedRow = jTable1.getSelectedRow();

        // Kiểm tra xem đã chọn dòng hợp lệ chưa
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa");
            return;
        }

        // Lấy giá trị của cột "Mã thể loại" từ dòng được chọn
        String matheloai = jTable1.getValueAt(selectedRow, 0).toString();

        // Gọi phương thức backend để xóa thể loại dựa trên mã thể loại
        boolean success = theLoaiBUS.deleteTheLoai(matheloai);

        // Kiểm tra xem xóa có thành công hay không và cập nhật giao diện
        if (success) {
            
            theLoaiBUS.loadTableData(jTable1);

            JOptionPane.showMessageDialog(this, "Xóa Thể loại thành công");
            cleartxt();
        } else {
            JOptionPane.showMessageDialog(this, "Xóa Thể loại thất bại");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    public void cleartxt(){
        txtTentheloai.setText("");
        txtMatheloai.setText("");
        txtMota.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtMatheloai;
    private javax.swing.JTextArea txtMota;
    private javax.swing.JTextField txtTentheloai;
    // End of variables declaration//GEN-END:variables
}
