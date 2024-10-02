
package qlyrapphim.GUI;

import javax.swing.JOptionPane;
import qlyrapphim.BUS.PhongChieuBUS;
import qlyrapphim.DTO.PhongChieu;

public class QlyPhongChieu extends javax.swing.JPanel {

    PhongChieuBUS phongChieuBUS = new PhongChieuBUS();
    public QlyPhongChieu() {
        initComponents();
        phongChieuBUS.loadTableData(jTable1);
        phongChieuBUS.loadCboxidMH(cbManhinh);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jTable1.rowAtPoint(evt.getPoint());
                // Lấy dữ liệu từ dòng được chọn và hiển thị lên các ô nhập liệu
                if (row >= 0) {
                    txtMaphong.setText(jTable1.getModel().getValueAt(row, 0).toString());
                    txtTenphong.setText(jTable1.getModel().getValueAt(row, 1).toString());
                    cbManhinh.setSelectedItem(jTable1.getModel().getValueAt(row, 2).toString());
                    txtSochongoi.setText(jTable1.getModel().getValueAt(row, 3).toString());
                    txtTinhtrang.setText(jTable1.getModel().getValueAt(row, 4).toString());
                    txtSohangghe.setText(jTable1.getModel().getValueAt(row, 5).toString());
                    txtSoghemoihang.setText(jTable1.getModel().getValueAt(row, 6).toString());
                }
            }
        });

    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtMaphong = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        txtTenphong = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        cbManhinh = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        txtSochongoi = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        txtTinhtrang = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        txtSohangghe = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        txtSoghemoihang = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXem = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(900, 611));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 496));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã phòng", "Tên phòng", "id màn hình", "Số chỗ ngồi", "Tình trạng ", "Số hàng ghế", "Ghế mỗi hàng"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);

        jPanel4.setPreferredSize(new java.awt.Dimension(250, 531));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mã phòng");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tên phòng");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Màn hình");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Số chỗ ngồi");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Tình trạng");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Số hàng ghế");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Số ghế mỗi hàng");

        jPanel5.setPreferredSize(new java.awt.Dimension(165, 332));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMaphong, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMaphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel6);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTenphong, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTenphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel7);

        cbManhinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbManhinh, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbManhinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.add(jPanel8);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSochongoi, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSochongoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.add(jPanel9);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTinhtrang, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTinhtrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel5.add(jPanel10);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSohangghe, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSohangghe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.add(jPanel11);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSoghemoihang, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSoghemoihang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.add(jPanel12);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(10, 10, 10)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(175, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setPreferredSize(new java.awt.Dimension(758, 80));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 30));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnThem.setText("Thêm ");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel2.add(btnThem);

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel2.add(btnXoa);

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel2.add(btnSua);

        btnXem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/showall.png"))); // NOI18N
        btnXem.setText("Xem");
        btnXem.setPreferredSize(new java.awt.Dimension(88, 31));
        btnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemActionPerformed(evt);
            }
        });
        jPanel2.add(btnXem);

        add(jPanel2, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemActionPerformed
        // TODO add your handling code here:
        phongChieuBUS.loadTableData(jTable1);
    }//GEN-LAST:event_btnXemActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        // Lấy thông tin từ các ô nhập liệu
        String maphong = txtMaphong.getText();
        String tenphong = txtTenphong.getText();
        String manhinh = cbManhinh.getSelectedItem().toString();
        String sochongoiText = txtSochongoi.getText();
        String tinhtrangText = txtTinhtrang.getText();
        String sohanggheText = txtSohangghe.getText();
        String soghemoihangText = txtSoghemoihang.getText();

        // Kiểm tra xem các ô nhập liệu có được nhập hay không
        if (maphong.isEmpty() || tenphong.isEmpty() || manhinh.isEmpty() || sochongoiText.isEmpty() || tinhtrangText.isEmpty() || sohanggheText.isEmpty() || soghemoihangText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.");
            return;
        }

        // Kiểm tra xem mã phòng đã tồn tại chưa
        PhongChieuBUS phongChieuBUS = new PhongChieuBUS();
        
        if (phongChieuBUS.checkMaPhong(maphong)) {
            JOptionPane.showMessageDialog(this, "Mã phòng đã tồn tại. Vui lòng chọn mã khác.");
            return;
        }
        
        if (phongChieuBUS.checkTenPhong(tenphong)) {
            JOptionPane.showMessageDialog(this, "Tên phòng đã tồn tại. Vui lòng chọn mã khác.");
            return;
        }
        
        int sochongoi =Integer.parseInt(sochongoiText);
        int sohangghe =Integer.parseInt(sohanggheText);
        int soghemoihang =Integer.parseInt(soghemoihangText);
        int tinhtrang =Integer.parseInt(tinhtrangText);
        
        // Kiểm tra tính hợp lệ của dữ liệu đầu vào
        if (sochongoi <= 0 || sohangghe <= 0 || soghemoihang <= 0) {
            JOptionPane.showMessageDialog(this, "Số chỗ ngồi, số hàng ghế, số ghế mỗi hàng phải là số nguyên dương và lớn hơn 0.");
            return;
        }
        
        // Kiểm tra tình trạng hợp lệ
        if (tinhtrang != 1 && tinhtrang !=0) {
            JOptionPane.showMessageDialog(null,"Tình trạng không hợp lệ ! Vui lòng nhập đúng định dạng ");
            return;
        }

        PhongChieu PChieu = new PhongChieu(maphong, tenphong, manhinh, sochongoi, tinhtrang, sohangghe, soghemoihang);
        
        // Thêm phòng chiếu vào cơ sở dữ liệu
        boolean result = phongChieuBUS.themPhongChieu(PChieu);

        // Hiển thị thông báo kết quả cho người dùng
        if (result) {
            JOptionPane.showMessageDialog(this, "Thêm phòng chiếu thành công.");
            // Sau khi thêm thành công, có thể cập nhật lại bảng hoặc làm các thao tác khác
            phongChieuBUS.loadTableData(jTable1);
            
        txtMaphong.setText("");
        txtTenphong.setText("");
        cbManhinh.setSelectedItem(null);
        txtSochongoi.setText("");
        txtTinhtrang.setText("");
        txtSohangghe.setText("");
        txtSoghemoihang.setText("");
            
        } else {
            JOptionPane.showMessageDialog(this, "Thêm phòng chiếu thất bại. Vui lòng thử lại.");
        }
        
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        String maphong = txtMaphong.getText();

        // Kiểm tra xem mã phòng đã được nhập hay chưa
        if (maphong.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng chiếu cần xóa.");
            return;
        }

        // Xác nhận xóa phòng chiếu
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa phòng chiếu này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Thực hiện xóa phòng chiếu
            PhongChieuBUS phongChieuBUS = new PhongChieuBUS();
            boolean result = phongChieuBUS.xoaPhongChieu(maphong);

            if (result) {
                JOptionPane.showMessageDialog(this, "Xóa phòng chiếu thành công.");
                // Sau khi xóa thành công, có thể làm các thao tác khác như là cập nhật lại bảng dữ liệu
                phongChieuBUS.loadTableData(jTable1);
            } else {
                JOptionPane.showMessageDialog(this, "Xóa phòng chiếu thất bại. Vui lòng thử lại.");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        String maphong = txtMaphong.getText();
        String tenphong = txtTenphong.getText();
        String manhinh = cbManhinh.getSelectedItem().toString();
        String sochongoiText = txtSochongoi.getText();
        String tinhtrangText = txtTinhtrang.getText();
        String sohanggheText = txtSohangghe.getText();
        String soghemoihangText = txtSoghemoihang.getText();

        // Kiểm tra xem các ô nhập liệu có được nhập hay không
        if (maphong.isEmpty() || tenphong.isEmpty() || manhinh.isEmpty() || sochongoiText.isEmpty() || tinhtrangText.isEmpty() || sohanggheText.isEmpty() || soghemoihangText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.");
            return;
        }

        int sochongoi = Integer.parseInt(sochongoiText);
        int sohangghe = Integer.parseInt(sohanggheText);
        int soghemoihang = Integer.parseInt(soghemoihangText);
        int tinhtrang = Integer.parseInt(tinhtrangText);

        // Kiểm tra tính hợp lệ của dữ liệu đầu vào
        if (sochongoi <= 0 || sohangghe <= 0 || soghemoihang <= 0) {
            JOptionPane.showMessageDialog(this, "Số chỗ ngồi, số hàng ghế, số ghế mỗi hàng phải là số nguyên dương và lớn hơn 0.");
            return;
        }
        
        // Kiểm tra tình trạng hợp lệ
        if (tinhtrang != 1 && tinhtrang !=0) {
            JOptionPane.showMessageDialog(null,"Tình trạng không hợp lệ ! Vui lòng nhập đúng định dạng ");
            return;
        }

        // Thực hiện cập nhật thông tin phòng chiếu
        PhongChieuBUS phongChieuBUS = new PhongChieuBUS();
        PhongChieu PChieu = new PhongChieu(maphong, tenphong, manhinh, sochongoi, tinhtrang, sohangghe, soghemoihang);
        boolean result = phongChieuBUS.suaPhongChieu(PChieu);

        if (result) {
            JOptionPane.showMessageDialog(this, "Cập nhật thông tin phòng chiếu thành công.");
            // Có thể thực hiện các thao tác khác sau khi cập nhật thành công
            phongChieuBUS.loadTableData(jTable1);
            
        txtMaphong.setText("");
        txtTenphong.setText("");
        cbManhinh.setSelectedItem(null);
        txtSochongoi.setText("");
        txtTinhtrang.setText("");
        txtSohangghe.setText("");
        txtSoghemoihang.setText("");
            
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thông tin phòng chiếu thất bại. Vui lòng thử lại.");
        }
    }//GEN-LAST:event_btnSuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbManhinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtMaphong;
    private javax.swing.JTextField txtSochongoi;
    private javax.swing.JTextField txtSoghemoihang;
    private javax.swing.JTextField txtSohangghe;
    private javax.swing.JTextField txtTenphong;
    private javax.swing.JTextField txtTinhtrang;
    // End of variables declaration//GEN-END:variables
}
