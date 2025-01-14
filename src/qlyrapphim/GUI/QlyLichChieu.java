package qlyrapphim.GUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import qlyrapphim.BUS.LichChieuBUS;
import qlyrapphim.BUS.PhimBUS;
import qlyrapphim.DTO.LichChieuDTO;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import qlyrapphim.DAO.LichChieuDAO;



/**
 *
 * @author CUONG
 */
public class QlyLichChieu extends javax.swing.JPanel {
    private LichChieuBUS lichChieuBUS;

    /**
     * Creates new form LichChieuJPanel
     */
    public QlyLichChieu() {
        initComponents();
        loadTableData();
        tbLichChieu.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                updateTextFieldFromSelectedRow();
                updateComboBoxesFromSelectedRow();
            }
        });
    }

    public JTable getMytable() {
        return tbLichChieu;
    }

    private void loadTableData() {
        lichChieuBUS = new LichChieuBUS();
        lichChieuBUS.loadTableData(tbLichChieu);
        lichChieuBUS.loadCxTenMH(cxTenMH);
        lichChieuBUS.loadCxTenPhim(cxTenPhim);
        lichChieuBUS.loadCxIdPhong(cxidPhong); 
        lichChieuBUS.loadCxIdDinhDang(cxidDinhDang);// Truyền bảng vào để cập nhật dữ liệu
    }

    private void updateTextFieldFromSelectedRow() {
    int selectedRow = tbLichChieu.getSelectedRow();
    if (selectedRow != -1) {
        txtThoiGianChieu.setText(tbLichChieu.getValueAt(selectedRow, 3).toString()); // Thời gian chiếu
        txtGiaVe.setText(tbLichChieu.getValueAt(selectedRow, 4).toString());
        txtid.setText(tbLichChieu.getValueAt(selectedRow, 0).toString());
    }
}
    
     private void updateComboBoxesFromSelectedRow() {
        int selectedRow = tbLichChieu.getSelectedRow();
        if (selectedRow != -1) {
            cxidDinhDang.setSelectedItem(tbLichChieu.getValueAt(selectedRow, 1).toString());
            cxidPhong.setSelectedItem(tbLichChieu.getValueAt(selectedRow, 2).toString());
            cxTenPhim.setSelectedItem(tbLichChieu.getValueAt(selectedRow, 5).toString()); // Phim
            cxTenMH.setSelectedItem(tbLichChieu.getValueAt(selectedRow, 6).toString()); // Màn hình        
        }        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLichChieu = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btnThemLichChieu = new javax.swing.JButton();
        btnSuaLichChieu = new javax.swing.JButton();
        btnXoaLichChieu = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        txtTim = new javax.swing.JTextField();
        btnTimLichChieu = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtThoiGianChieu = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtGiaVe = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        cxidDinhDang = new javax.swing.JComboBox<>();
        cxTenPhim = new javax.swing.JComboBox<>();
        cxTenMH = new javax.swing.JComboBox<>();
        cxidPhong = new javax.swing.JComboBox<>();
        txtid = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        tbLichChieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Lịch Chiếu", "Mã Định Dạng", "Mã Phòng", "Thời Gian Chiếu", "Giá Vé", "Phim", "Màn Hình "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbLichChieu);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 5));

        btnThemLichChieu.setText("Thêm");
        btnThemLichChieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLichChieuActionPerformed(evt);
            }
        });
        jPanel6.add(btnThemLichChieu);

        btnSuaLichChieu.setText("Sửa");
        btnSuaLichChieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaLichChieuActionPerformed(evt);
            }
        });
        jPanel6.add(btnSuaLichChieu);

        btnXoaLichChieu.setText("Xóa");
        btnXoaLichChieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaLichChieuActionPerformed(evt);
            }
        });
        jPanel6.add(btnXoaLichChieu);

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        jPanel6.add(btnLamMoi);

        txtTim.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel6.add(txtTim);

        btnTimLichChieu.setText("Tìm Kiếm");
        btnTimLichChieu.setPreferredSize(new java.awt.Dimension(61, 62));
        btnTimLichChieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimLichChieuActionPerformed(evt);
            }
        });
        jPanel6.add(btnTimLichChieu);

        add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jPanel8.setPreferredSize(new java.awt.Dimension(250, 430));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mã Lịch Chiếu");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mã Định Dạng");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Phim");

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Màn Hình");

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Phòng Chiếu");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thời Gian Chiếu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(txtThoiGianChieu)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtThoiGianChieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Giá");

        txtGiaVe.setBackground(new java.awt.Color(255, 204, 204));
        txtGiaVe.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        cxidDinhDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxidDinhDangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGiaVe)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2)
                            .addComponent(jLabel4)
                            .addComponent(jSeparator3)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cxidDinhDang, 0, 215, Short.MAX_VALUE)
                            .addComponent(cxTenPhim, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cxTenMH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cxidPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtid))
                        .addGap(0, 23, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cxidDinhDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cxTenPhim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(2, 2, 2)
                .addComponent(cxTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(9, 9, 9)
                .addComponent(cxidPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGiaVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel3, java.awt.BorderLayout.CENTER);

        add(jPanel8, java.awt.BorderLayout.LINE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaLichChieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaLichChieuActionPerformed
        // TODO add your handling code here:
        try {
        // Kiểm tra các trường dữ liệu rỗng
        if (txtid.getText().isEmpty() || cxidDinhDang.getSelectedItem() == null || cxidPhong.getSelectedItem() == null || txtThoiGianChieu.getText().isEmpty() || txtGiaVe.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin");
            return;
        }
        
        // Chuyển dữ liệu về kiểu phù hợp
        String id = txtid.getText().trim();
        String idDinhDang = cxidDinhDang.getSelectedItem().toString().trim();
        String idPhong = cxidPhong.getSelectedItem().toString().trim();
        Date ThoiGianChieu = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(txtThoiGianChieu.getText().trim());
        String GiaVe = txtGiaVe.getText().trim();
        
        // Tạo đối tượng LichChieuDTO từ dữ liệu đã nhập
        LichChieuDTO lichChieu = new LichChieuDTO(id, idDinhDang, idPhong, ThoiGianChieu, GiaVe);
        
        // Gọi phương thức suaLichChieu từ DAO hoặc BUS
        LichChieuDAO lichChieuDAO = new LichChieuDAO();
        lichChieuDAO.suaLichChieu(lichChieu);
        
        // Load lại dữ liệu lên bảng lịch chiếu sau khi sửa
        lichChieuDAO.loadTableData(tbLichChieu);
        
        txtid.setText("");
        txtThoiGianChieu.setText("");
        txtGiaVe.setText("");
        cxidDinhDang.setSelectedIndex(-1);
        cxidPhong.setSelectedIndex(-1);
        
    } catch (ParseException ex) {
        JOptionPane.showMessageDialog(this, "Lỗi khi sửa lịch chiếu: " + ex.getMessage());
    }
    }//GEN-LAST:event_btnSuaLichChieuActionPerformed

    private void btnThemLichChieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLichChieuActionPerformed
        // Kiểm tra các trường dữ liệu rỗng
         try {   
        // Kiểm tra các trường dữ liệu rỗng
        if (txtid.getText().isEmpty() || cxidDinhDang.getSelectedItem() == null || cxidPhong.getSelectedItem() == null || txtThoiGianChieu.getText().isEmpty() || txtGiaVe.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin");
            return;
        }
        
        // Chuyển dữ liệu về kiểu phù hợp
        String id = txtid.getText().trim();
        String idDinhDang = cxidDinhDang.getSelectedItem().toString().trim();
        String idPhong = cxidPhong.getSelectedItem().toString().trim();
        String thoiGianChieuText = txtThoiGianChieu.getText().trim();
        Date ThoiGianChieu = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(txtThoiGianChieu.getText().trim());
        String GiaVe = txtGiaVe.getText().trim();       
        
        if (!id.matches("^LC(0*[1-9][0-9]?|100)$")) {
        JOptionPane.showMessageDialog(this, "Mã lịch chiếu phải có định dạng LC + số từ 1 đến 100");
        return;
        }
        
        LichChieuBUS lichChieuBUS = new LichChieuBUS();
        if (lichChieuBUS.isIdTaken(id)) {
            JOptionPane.showMessageDialog(this, "Mã lịch chiếu đã tồn tại trong cơ sở dữ liệu");
            return;
        } 
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setLenient(false); // Tắt tính linh hoạt của SimpleDateFormat
        try {
        sdf.parse(thoiGianChieuText);
            } catch (ParseException e) {
        JOptionPane.showMessageDialog(this, "Định dạng thời gian không chính xác. Vui lòng nhập theo định dạng yyyy-MM-dd HH:mm:ss");
        return;
        }
        
        float giaVe = Float.parseFloat(GiaVe);
        if (giaVe < 0) {
        JOptionPane.showMessageDialog(this, "Giá vé không được âm");
        return;
        }
        
        // Tạo đối tượng LichChieuDTO từ dữ liệu đã nhập
        LichChieuDTO lichChieu = new LichChieuDTO(id, idDinhDang, idPhong, ThoiGianChieu, GiaVe);
        
        // Gọi phương thức themLichChieu từ DAO hoặc BUS
        LichChieuDAO lichChieuDAO = new LichChieuDAO();
        lichChieuDAO.themLichChieu(lichChieu);
        
        // Load lại dữ liệu lên bảng lịch chiếu sau khi thêm
        lichChieuDAO.loadTableData(tbLichChieu);   
        
        txtid.setText("");
        txtThoiGianChieu.setText("");
        txtGiaVe.setText("");
        cxidDinhDang.setSelectedIndex(-1);
        cxidPhong.setSelectedIndex(-1);
        
    } catch (ParseException ex) {
        JOptionPane.showMessageDialog(this, "Lỗi khi thêm lịch chiếu: " + ex.getMessage());
    }   
    }//GEN-LAST:event_btnThemLichChieuActionPerformed

    private void btnXoaLichChieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaLichChieuActionPerformed
        // TODO add your handling code here:
        String id = txtid.getText().trim();
    if (id.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập ID của lịch chiếu cần xóa");
        return;
    } 
     try {
        // Hiển thị hộp thoại xác nhận xóa
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa lịch chiếu này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) { // Nếu người dùng đồng ý xóa
            // Gọi phương thức xoaLichChieu từ DAO hoặc BUS
            LichChieuDAO lichChieuDAO = new LichChieuDAO();
            lichChieuDAO.xoaLichChieu(id);
            
            // Load lại dữ liệu lên bảng lịch chiếu sau khi xóa
            lichChieuDAO.loadTableData(tbLichChieu);
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Lỗi khi xóa lịch chiếu: " + ex.getMessage());
    }
    }//GEN-LAST:event_btnXoaLichChieuActionPerformed

    private void btnTimLichChieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimLichChieuActionPerformed
    String tenCanTim = txtTim.getText().trim();

    // Kiểm tra xem từ khóa tìm kiếm có rỗng không
    if (tenCanTim.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa tìm kiếm");
        return;
    }

    // Thực hiện tìm kiếm và cập nhật bảng hiển thị
    LichChieuBUS lichChieuBUS = new LichChieuBUS(); // Khởi tạo đối tượng LichChieuBUS
    boolean result = lichChieuBUS.timLichChieu(tbLichChieu, tenCanTim);

    // Kiểm tra kết quả tìm kiếm và hiển thị thông báo tương ứng
    if (result) {
        // Tìm thấy kết quả
    } else {
        JOptionPane.showMessageDialog(this, "Đã thực hiện tìm");
    }

    }//GEN-LAST:event_btnTimLichChieuActionPerformed

    private void cxidDinhDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxidDinhDangActionPerformed
        // TODO add your handling code here:
        // Lấy idDinhDang được chọn từ combobox cxidDinhDang
        String idDinhDang = cxidDinhDang.getSelectedItem().toString().trim();
        
        // Tìm Tên Phim và Tên Màn Hình dựa trên idDinhDang
        String tenPhim = lichChieuBUS.timTenPhimTheoIDDinhDang(idDinhDang);
        String tenMH = lichChieuBUS.timTenManHinhTheoIDDinhDang(idDinhDang);
        
        // Thực hiện truy vấn hoặc tìm kiếm tên phim và tên màn hình dựa vào idDinhDang
        // Ví dụ: Phương thức tìm kiếm trong lớp DAO hoặc BUS và cập nhật giá trị tenPhim và tenMH
        
        // Set giá trị tìm được cho combobox cxTenPhim và cxTenMH
        cxTenPhim.setSelectedItem(tenPhim);
        cxTenMH.setSelectedItem(tenMH);
    }//GEN-LAST:event_cxidDinhDangActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        lichChieuBUS.loadCxIdDinhDang(cxidDinhDang);
        lichChieuBUS.loadCxIdPhong(cxidPhong);
        lichChieuBUS.loadCxTenMH(cxTenMH);
        lichChieuBUS.loadCxTenPhim(cxTenPhim);
        lichChieuBUS.loadTableData(tbLichChieu);
    }//GEN-LAST:event_btnLamMoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSuaLichChieu;
    private javax.swing.JButton btnThemLichChieu;
    private javax.swing.JButton btnTimLichChieu;
    private javax.swing.JButton btnXoaLichChieu;
    private javax.swing.JComboBox<String> cxTenMH;
    private javax.swing.JComboBox<String> cxTenPhim;
    private javax.swing.JComboBox<String> cxidDinhDang;
    private javax.swing.JComboBox<String> cxidPhong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable tbLichChieu;
    private javax.swing.JTextField txtGiaVe;
    private javax.swing.JTextField txtThoiGianChieu;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
