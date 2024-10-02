
package GUI;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import qlyrapphim.BUS.LoaiManHinhBUS;
import qlyrapphim.DTO.LoaiManHinh;
public class QlyLoaiManHinh extends javax.swing.JPanel {

    LoaiManHinhBUS lmhbus = new LoaiManHinhBUS();
    public QlyLoaiManHinh() {
        initComponents();
        lmhbus.loadTableData(table);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });

    }

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {                                          
        // Lấy chỉ số của dòng được chọn
        int selectedRow = table.getSelectedRow();

        // Kiểm tra xem có dòng nào được chọn không
        if (selectedRow != -1) {
            // Lấy dữ liệu từ dòng được chọn
            String maMH = table.getValueAt(selectedRow, 0).toString();
            String tenMH = table.getValueAt(selectedRow, 1).toString();

            // Hiển thị dữ liệu lên các ô nhập liệu
            txtMaMH.setText(maMH);
            txtTenMH.setText(tenMH);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnXem = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        txtMaMH = new javax.swing.JTextField();
        txtTenMH = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(847, 700));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 40, 50));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel1.add(btnThem);

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Notes.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSua);

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoa);

        btnXem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/showall.png"))); // NOI18N
        btnXem.setText("Xem");
        btnXem.setPreferredSize(new java.awt.Dimension(88, 31));
        btnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemActionPerformed(evt);
            }
        });
        jPanel1.add(btnXem);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel4.setPreferredSize(new java.awt.Dimension(10, 500));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã loại màn hình", "Tên màn hình"
            }
        ));
        jScrollPane1.setViewportView(table);

        jPanel4.add(jScrollPane1);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(250, 500));

        label1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        label1.setText("Mã loại màn hình");
        label1.setInheritsPopupMenu(false);

        label2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        label2.setText("Tên màn hình");

        txtMaMH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaMHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenMH)
                    .addComponent(txtMaMH, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel3);

        add(jPanel4, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        String maMH = txtMaMH.getText();
        String tenMH = txtTenMH.getText();

        // Kiểm tra xem các trường đầu vào có rỗng hay không
        if (maMH.isEmpty() || tenMH.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
            return;
        }

        // Kiểm tra xem mã màn hình đã tồn tại trong cơ sở dữ liệu hay chưa
        if (lmhbus.isMaMHExists(maMH)) {
            JOptionPane.showMessageDialog(this, "Mã màn hình đã tồn tại");
            return;
        }

        LoaiManHinh manHinh = new LoaiManHinh(maMH, tenMH);
        // Nếu dữ liệu nhập vào đều hợp lệ, tiến hành thêm loại màn hình mới
        boolean result = lmhbus.insertLoaiManHinh(manHinh);

        if (result) {
            JOptionPane.showMessageDialog(this, "Thêm loại màn hình thành công");
            // Load lại dữ liệu lên bảng nếu cần
            lmhbus.loadTableData(table);
        } else {
            JOptionPane.showMessageDialog(this, "Thêm loại màn hình thất bại");
        }
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
            // Lấy mã loại màn hình và tên màn hình từ các ô nhập liệu
        String maMH = txtMaMH.getText();
        String tenMH = txtTenMH.getText();

        // Kiểm tra xem các trường đầu vào có rỗng hay không
        if (maMH.isEmpty() || tenMH.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng từ bảng để sửa");
            return;
        }

                LoaiManHinh manHinh = new LoaiManHinh(maMH, tenMH);

        // Tiến hành sửa thông tin loại màn hình trong cơ sở dữ liệu
        boolean result = lmhbus.updateLoaiManHinh(manHinh);

        if (result) {
            JOptionPane.showMessageDialog(this, "Sửa loại màn hình thành công");
            // Load lại dữ liệu lên bảng nếu cần
            lmhbus.loadTableData(table);
        } else {
            JOptionPane.showMessageDialog(this, "Sửa loại màn hình thất bại");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // Lấy mã loại màn hình từ ô nhập liệu
        String maMH = txtMaMH.getText();

        // Kiểm tra xem mã loại màn hình có rỗng hay không
        if (maMH.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng từ bảng để xóa");
            return;
        }

        // Tiến hành xóa loại màn hình khỏi cơ sở dữ liệu
        boolean result = lmhbus.deleteLoaiManHinh(maMH);

        if (result) {
            JOptionPane.showMessageDialog(this, "Xóa loại màn hình thành công");
            // Load lại dữ liệu lên bảng nếu cần
            lmhbus.loadTableData(table);
        } else {
            JOptionPane.showMessageDialog(this, "Xóa loại màn hình thất bại");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtMaMHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaMHActionPerformed
       
    }//GEN-LAST:event_txtMaMHActionPerformed

    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemActionPerformed
        // TODO add your handling code here:
        lmhbus.loadTableData(table);
    }//GEN-LAST:event_btnXemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtMaMH;
    private javax.swing.JTextField txtTenMH;
    // End of variables declaration//GEN-END:variables
}
