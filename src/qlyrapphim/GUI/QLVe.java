
package qlyrapphim.GUI;

import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import qlyrapphim.BUS.TicketBUS;
import qlyrapphim.DAO.KetNoiCSDL;
import qlyrapphim.DAO.TicketDAO;
import qlyrapphim.DTO.LichChieuDTO;
import qlyrapphim.DTO.Ticket;

public class QLVe extends javax.swing.JPanel {

    TicketBUS tbus = new TicketBUS();
    public String selectedIdLichChieu = null;
    public QLVe() {
        initComponents();
        tbus.loadTableData(tableLC);
        
        // Thêm lắng nghe sự kiện cho JTable
        tableLC.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent event) {
            // Kiểm tra xem người dùng đã chọn dòng nào chưa
            if (!event.getValueIsAdjusting() && tableLC.getSelectedRow() != -1) {
                int selectedRow = tableLC.getSelectedRow();
                // Lấy giá trị của cột idLichChieu từ dòng được chọn
                selectedIdLichChieu = (String) tableLC.getValueAt(selectedRow, 4);
                // Tiếp tục xử lý tại đây
                List<Ticket> listTicket = new ArrayList<>();
                listTicket = tbus.getListTicketsByShowTimes(selectedIdLichChieu);
                DefaultTableModel model = (DefaultTableModel) tableVe.getModel();
                model.setRowCount(0);
                // Duyệt qua danh sách vé và thêm từng vé vào bảng tableVe
                for(Ticket tk : listTicket){
                    // Tạo một mảng chứa thông tin của một hàng trong bảng
                    Object[] row = new Object[7]; // Số cột trong bảng tableVe

                    // Thiết lập giá trị của các cột cho vé hiện tại
                    row[0] = tk.getID(); 
                    row[1] = tk.getType();
                    row[2] = tk.getShowTimesID();
                    row[3] = tk.getSeatName();
                    row[4] = tk.getCustomerID();
                    row[5] = tk.getStatus();
                    row[6] = tk.getPrice();
                    // Thêm hàng mới vào bảng tableVe
                    model.addRow(row);
                }
            }
        }
      });

    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnThemVeTheoLC = new javax.swing.JButton();
        btnXoaVeTheoLC = new javax.swing.JButton();
        btnXemVeBanTheoLC = new javax.swing.JButton();
        btnXemAllVeTheoLC = new javax.swing.JButton();
        btnXemLCChuaCoVe = new javax.swing.JButton();
        btnXemAllLC = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableVe = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLC = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(577, 70));

        btnThemVeTheoLC.setText("<html><center>Tự động thêm vé<br>theo lịch chiếu</center></html>");
        btnThemVeTheoLC.setPreferredSize(new java.awt.Dimension(120, 46));
        btnThemVeTheoLC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVeTheoLCActionPerformed(evt);
            }
        });
        jPanel1.add(btnThemVeTheoLC);

        btnXoaVeTheoLC.setText("<html><center>Xoá vé theo<br>lịch chiếu</center></html>");
        btnXoaVeTheoLC.setPreferredSize(new java.awt.Dimension(120, 46));
        btnXoaVeTheoLC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaVeTheoLCActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoaVeTheoLC);

        btnXemVeBanTheoLC.setText("<html><center>Xem các vé được<br>bán theo lịch chiếu</center></html>");
        btnXemVeBanTheoLC.setPreferredSize(new java.awt.Dimension(135, 46));
        btnXemVeBanTheoLC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemVeBanTheoLCActionPerformed(evt);
            }
        });
        jPanel1.add(btnXemVeBanTheoLC);

        btnXemAllVeTheoLC.setText("<html><center>Xem tất cả các vé<br>theo lịch chiếu</center></html>");
        btnXemAllVeTheoLC.setPreferredSize(new java.awt.Dimension(135, 46));
        btnXemAllVeTheoLC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemAllVeTheoLCActionPerformed(evt);
            }
        });
        jPanel1.add(btnXemAllVeTheoLC);

        btnXemLCChuaCoVe.setText("<html><center>Xem lịch chiếu<br>chưa được tạo vé</center></html>");
        btnXemLCChuaCoVe.setPreferredSize(new java.awt.Dimension(130, 46));
        btnXemLCChuaCoVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemLCChuaCoVeActionPerformed(evt);
            }
        });
        jPanel1.add(btnXemLCChuaCoVe);

        btnXemAllLC.setText("<html><center>Xem tất cả lịch<br>chiếu</center></html>");
        btnXemAllLC.setPreferredSize(new java.awt.Dimension(120, 46));
        btnXemAllLC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemAllLCActionPerformed(evt);
            }
        });
        jPanel1.add(btnXemAllLC);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 264));

        tableVe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Loại vé", "Id lịch chiếu", "Mã ghế ngồi", "Id khách hàng", "Trạng thái", "Tiền bán vé"
            }
        ));
        jScrollPane2.setViewportView(tableVe);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
        );

        add(jPanel2, java.awt.BorderLayout.LINE_START);

        tableLC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tên phòng chiếu", "Tên phim", "Thời gian", "Trạng thái", "Id lịch chiếu"
            }
        ));
        jScrollPane1.setViewportView(tableLC);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemVeTheoLCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVeTheoLCActionPerformed
        // TODO add your handling code here:
        String idlc = selectedIdLichChieu;
        LichChieuDTO lichchieu = tbus.getLichChieuById(idlc);
        tbus.autoCreateTicketsByShowTimes(lichchieu);
        tbus.loadTableData(tableLC);
        
    }//GEN-LAST:event_btnThemVeTheoLCActionPerformed

    private void btnXoaVeTheoLCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaVeTheoLCActionPerformed
        // TODO add your handling code here:
        tbus.deleteTicketsByShowTimes(selectedIdLichChieu);
        tbus.loadTableData(tableLC);
    }//GEN-LAST:event_btnXoaVeTheoLCActionPerformed

    private void btnXemVeBanTheoLCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemVeBanTheoLCActionPerformed
        // TODO add your handling code here:
        // Lấy danh sách các vé đã bán dựa trên lịch chiếu được chọn
        List<Ticket> listTickets = tbus.getListTicketsBoughtByShowTimes(selectedIdLichChieu);

        // Hiển thị danh sách vé đã bán lên bảng tableVe
        DefaultTableModel model = (DefaultTableModel) tableVe.getModel();
        model.setRowCount(0); // Xóa tất cả các dòng hiện tại trong bảng
        for (Ticket ticket : listTickets) {
            // Thêm thông tin của vé vào một hàng mới trong bảng
            Object[] rowData = {ticket.getID(), ticket.getType(), ticket.getShowTimesID(), ticket.getSeatName(), ticket.getCustomerID(), ticket.getStatus(), ticket.getPrice()};
            model.addRow(rowData);
        }
    }//GEN-LAST:event_btnXemVeBanTheoLCActionPerformed

    private void btnXemAllVeTheoLCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemAllVeTheoLCActionPerformed
        // TODO add your handling code here:
        List<Ticket> listTicket = new ArrayList<>();
        listTicket = tbus.getListTicketsByShowTimes(selectedIdLichChieu);
        DefaultTableModel model = (DefaultTableModel) tableVe.getModel();
        model.setRowCount(0);
        // Duyệt qua danh sách vé và thêm từng vé vào bảng tableVe
        for(Ticket tk : listTicket){
            Object [] row = {tk.getID(),tk.getType(),tk.getShowTimesID(),tk.getSeatName(),tk.getCustomerID(),tk.getStatus(),tk.getPrice()};
            model.addRow(row);
        }                                
    }//GEN-LAST:event_btnXemAllVeTheoLCActionPerformed

    private void btnXemLCChuaCoVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemLCChuaCoVeActionPerformed
        // TODO add your handling code here:
        tbus.loadTableDataNotCreate(tableLC);
    }//GEN-LAST:event_btnXemLCChuaCoVeActionPerformed

    private void btnXemAllLCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemAllLCActionPerformed
        // TODO add your handling code here:
        tbus.loadTableData(tableLC);
    }//GEN-LAST:event_btnXemAllLCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton btnThemVeTheoLC;
    javax.swing.JButton btnXemAllLC;
    javax.swing.JButton btnXemAllVeTheoLC;
    javax.swing.JButton btnXemLCChuaCoVe;
    javax.swing.JButton btnXemVeBanTheoLC;
    javax.swing.JButton btnXoaVeTheoLC;
    javax.swing.JPanel jPanel1;
    javax.swing.JPanel jPanel2;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JTable tableLC;
    javax.swing.JTable tableVe;
    // End of variables declaration//GEN-END:variables
}
