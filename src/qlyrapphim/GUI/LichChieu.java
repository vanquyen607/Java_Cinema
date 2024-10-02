
package qlyrapphim.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import javax.swing.JOptionPane;
import qlyrapphim.Account;
import qlyrapphim.BUS.LChieuSaleBUS;

public class LichChieu extends javax.swing.JFrame {

    LChieuSaleBUS lcsbus = new LChieuSaleBUS();
    public LichChieu() {
        initComponents();
        setLocationRelativeTo(null);
        lcsbus.loadCboxPhim(cbPhim);
        lcsbus.loadCboxSuatChieu(cbLichChieu);
        lcsbus.loadtotable(jTable1);
        
        jTable1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int selectedRow = jTable1.getSelectedRow();
                        if (selectedRow != -1) { // Đảm bảo có hàng được chọn
                            String idPhong = jTable1.getValueAt(selectedRow, 0).toString();
                            String tenPhong = jTable1.getValueAt(selectedRow, 1).toString();
                            String tenPhim = jTable1.getValueAt(selectedRow, 2).toString();
                            String gioChieu = jTable1.getValueAt(selectedRow, 3).toString();
                            String tinhTrang = jTable1.getValueAt(selectedRow, 4).toString();

                            // Tạo một instance mới của form ChiTietLichChieu và truyền dữ liệu vào
                            ManChieuGUI chiTietForm = new ManChieuGUI(idPhong,tenPhong, tenPhim, gioChieu, tinhTrang);
                            chiTietForm.setVisible(true); // Hiển thị form ChiTietLichChieu
                            
                            setVisible(false);
                        }
                    }
                });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        lblLichChieu = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblThoiGian = new javax.swing.JLabel();
        datechooserLCphim = new com.toedter.calendar.JDateChooser();
        lblPhim = new javax.swing.JLabel();
        cbPhim = new javax.swing.JComboBox<>();
        lblSuatChieu = new javax.swing.JLabel();
        cbLichChieu = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 204));
        setMinimumSize(new java.awt.Dimension(1000, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setLayout(new java.awt.BorderLayout());

        lblLichChieu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblLichChieu.setForeground(new java.awt.Color(0, 0, 153));
        lblLichChieu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLichChieu.setText("Lịch chiếu phim");
        lblLichChieu.setPreferredSize(new java.awt.Dimension(169, 60));
        jPanel3.add(lblLichChieu, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(230, 349));

        lblThoiGian.setForeground(new java.awt.Color(255, 0, 0));
        lblThoiGian.setText("Thời gian");

        lblPhim.setForeground(new java.awt.Color(255, 0, 0));
        lblPhim.setText("Phim");

        cbPhim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPhimActionPerformed(evt);
            }
        });

        lblSuatChieu.setForeground(new java.awt.Color(255, 0, 0));
        lblSuatChieu.setText("Suất chiếu");

        cbLichChieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLichChieuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datechooserLCphim, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(cbPhim, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblThoiGian)
                            .addComponent(lblPhim)
                            .addComponent(lblSuatChieu))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cbLichChieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThoiGian)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datechooserLCphim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPhim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPhim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSuatChieu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbLichChieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1, java.awt.BorderLayout.LINE_START);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id Phòng", "Tên phòng", "Tên phim", "Ngày chiếu", "Giờ chiếu", "Tình trạng"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbPhimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPhimActionPerformed
        // TODO add your handling code here:
        updateTableData();
    }//GEN-LAST:event_cbPhimActionPerformed

    private void cbLichChieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLichChieuActionPerformed
        // TODO add your handling code here:
        updateTableData();
    }//GEN-LAST:event_cbLichChieuActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Account ac = new Account();
        ac.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void updateTableData() {
    // Lấy thông tin từ các ComboBox và DateChooser
    String selectedShowtime = (cbLichChieu.getSelectedItem() != null) ? cbLichChieu.getSelectedItem().toString() : "";
    String selectedMovie = (cbPhim.getSelectedItem() != null) ? cbPhim.getSelectedItem().toString() : "";
    Date selectedDate = datechooserLCphim.getDate();
    
//    if(selectedDate == null){
//        JOptionPane.showMessageDialog(null,"Vui lòng chọn ngày !");
//        return; // Trả về ngay sau khi hiển thị thông báo để không tiếp tục thực hiện phương thức
//    }

    // Gọi phương thức để cập nhật dữ liệu trên bảng
    lcsbus.getDataByDateTimeAndMovie(jTable1, selectedDate, selectedMovie, selectedShowtime);
}


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
            java.util.logging.Logger.getLogger(LichChieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LichChieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LichChieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LichChieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LichChieu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JComboBox<String> cbLichChieu;
    javax.swing.JComboBox<String> cbPhim;
    com.toedter.calendar.JDateChooser datechooserLCphim;
    javax.swing.JPanel jPanel1;
    javax.swing.JPanel jPanel3;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JTable jTable1;
    javax.swing.JLabel lblLichChieu;
    javax.swing.JLabel lblPhim;
    javax.swing.JLabel lblSuatChieu;
    javax.swing.JLabel lblThoiGian;
    // End of variables declaration//GEN-END:variables
}
