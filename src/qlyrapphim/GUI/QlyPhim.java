
package qlyrapphim.GUI;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import qlyrapphim.BUS.PhimBUS;
import qlyrapphim.DTO.Phim;

public class QlyPhim extends javax.swing.JPanel {
    
    PhimBUS phimBUS;
    boolean hanhDong, phieuLuu, hoatHinh, giaDinh, tinhCam, tamLy, vienTuong, hai;
    
    JDateChooser dateChooserKhoiChieu;
    JDateChooser dateChooserKetThuc;

    public QlyPhim() {
        initComponents();
        loadTableData();
        tbPhim.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                updateTextFieldFromSelectedRow();
            }
        });
        
        dateChooserKhoiChieu = jDateChooserNgayKhoiChieu;
        dateChooserKetThuc = jDateChooserNgayKetThuc;
        
        chxHanhdong.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            chxHanhdongActionPerformed(evt);
        }
    });
        chxPhieuluu.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            chxPhieuluuActionPerformed(evt);
        }
    });
        
        chxGiadinh.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            chxGiadinhActionPerformed(evt);  
        }
    });
        
        chxHai.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            chxHaiActionPerformed(evt);  
        }
    });
        
        chxHoathinh.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            chxHoathinhActionPerformed(evt);  
        }
    });
    
        chxTamly.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            chxTamlyActionPerformed(evt);  
        }
    });
        
        chxTinhcam.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            chxTinhcamActionPerformed(evt);  
        }
        
    });
        chxVientuong.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            chxVientuongActionPerformed(evt);  
        }

    });
    
        } 
    
    
    public JTable Mytable() {
        return tbPhim;
    }

    private void loadTableData() {
        phimBUS = new PhimBUS();
        phimBUS.loadTableData(tbPhim); // Truyền bảng vào để cập nhật dữ liệu
    }
    
    private void chxActionPerformed(ActionEvent evt, String genre) {
        String command = evt.getActionCommand();
        switch (genre) {
            case "Hành Động":
                hanhDong = chxHanhdong.isSelected();
                break;
            case "Phiêu lưu":
                phieuLuu = chxPhieuluu.isSelected();
                break;
            case "Hoạt Hình":
                hoatHinh = chxHoathinh.isSelected();
                break;
            case "Gia Đình":
                giaDinh = chxGiadinh.isSelected();    
                break;
            case "Tình Cảm":
                tinhCam = chxTinhcam.isSelected();    
                break;
            case "Tâm lý":
                tamLy = chxTamly.isSelected();    
                break;  
            case "Viễn Tưởng":
                vienTuong = chxVientuong.isSelected();    
                break; 
            case "Hài":
                hai = chxHai.isSelected();    
                break;
        }
    }
    
     
    private void updateTextFieldFromSelectedRow() {
    int selectedRow = tbPhim.getSelectedRow();
    if (selectedRow != -1) {
        for (int col = 0; col < tbPhim.getColumnCount(); col++) {
            Object cellValue = tbPhim.getValueAt(selectedRow, col);
            JTextField textField = null;
            JDateChooser dateChooser = null;

            // Chọn ô văn bản tương ứng với từng cột
            switch (col) {
                case 0:
                    textField = txtId;
                    break;
                case 1:
                    textField = txtTenPhim;
                    break;
                case 2:
                    textField = txtMoTa;
                    break;
                case 3:
                    textField = txtThoiLuong;
                    break;
                case 4: // Cột chứa Ngày Khởi Chiếu
                    if (cellValue instanceof Date) {
                    dateChooserKhoiChieu.setDate((Date) cellValue);
                      }
                    break;
                case 5: // Cột chứa Ngày Kết Thúc
                    if (cellValue instanceof Date) {
                    dateChooserKetThuc.setDate((Date) cellValue);
                    }
                    break;
 
                case 6:
                    textField = txtSanXuat;
                    break;
                case 7:
                    textField = txtDaoDien;
                    break;
                case 8:
                    textField = txtNamSX;
                    break;
                // Thêm các case khác tương ứng với số cột trong bảng
                default:
                    break;
            }

            // Cập nhật dữ liệu vào ô văn bản tương ứng nếu có
            if (textField != null && cellValue != null) {
                textField.setText(cellValue.toString());
            }
        }
        
        String genreString = (String) tbPhim.getValueAt(selectedRow, 10); // Giả sử cột thể loại ở vị trí 10
        updateCheckboxFromGenreString(genreString);

        //Cập nhật ảnh
        byte[] imageBytes = (byte[]) tbPhim.getValueAt(selectedRow, 9);
        if (imageBytes != null) {
            ImageIcon imageIcon = new ImageIcon(imageBytes);
            lblApPhich.setIcon(imageIcon);
        } else {
            lblApPhich.setIcon(null);
        }
    }
}
    
    private void updateCheckboxFromGenreString(String genreString) {
    chxHanhdong.setSelected(genreString.contains("Hành Động"));
    chxPhieuluu.setSelected(genreString.contains("Phiêu lưu"));
    chxHoathinh.setSelected(genreString.contains("Hoạt Hình"));
    chxGiadinh.setSelected(genreString.contains("Gia đình"));
    chxTinhcam.setSelected(genreString.contains("Tình Cảm"));
    chxTamly.setSelected(genreString.contains("Tâm lý"));
    chxVientuong.setSelected(genreString.contains("Viễn Tưởng"));
    chxHai.setSelected(genreString.contains("Hài"));
}



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        txtTenPhim = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtMoTa = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        chxHanhdong = new javax.swing.JCheckBox();
        chxPhieuluu = new javax.swing.JCheckBox();
        chxHoathinh = new javax.swing.JCheckBox();
        chxGiadinh = new javax.swing.JCheckBox();
        chxTinhcam = new javax.swing.JCheckBox();
        chxTamly = new javax.swing.JCheckBox();
        chxVientuong = new javax.swing.JCheckBox();
        chxHai = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        txtThoiLuong = new javax.swing.JTextField();
        jDateChooserNgayKhoiChieu = new com.toedter.calendar.JDateChooser();
        jDateChooserNgayKetThuc = new com.toedter.calendar.JDateChooser();
        txtSanXuat = new javax.swing.JTextField();
        txtDaoDien = new javax.swing.JTextField();
        txtNamSX = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btnThemPhim = new javax.swing.JButton();
        btnSuaPhim = new javax.swing.JButton();
        btnXoaPhim = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        btnthemanh = new javax.swing.JButton();
        lblApPhich = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPhim = new javax.swing.JTable();

        jTextField1.setText("jTextField1");

        setLayout(new java.awt.BorderLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(500, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(798, 260));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setLayout(new java.awt.GridLayout(3, 1));

        jLabel3.setText("Tên phim:");
        jPanel11.add(jLabel3);

        jLabel1.setText("Mã phim:");
        jPanel11.add(jLabel1);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Mô tả:");
        jPanel11.add(jLabel2);

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 90));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new java.awt.GridLayout(3, 1, 0, 5));
        jPanel12.add(txtTenPhim);
        jPanel12.add(txtId);

        txtMoTa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMoTaActionPerformed(evt);
            }
        });
        jPanel12.add(txtMoTa);

        jPanel3.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 180, 90));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(39, 43, 0, 0);
        jPanel1.add(jPanel3, gridBagConstraints);

        chxHanhdong.setText("Hành động");
        chxHanhdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chxHanhdongActionPerformed(evt);
            }
        });
        jPanel2.add(chxHanhdong);

        chxPhieuluu.setText("Phiêu lưu");
        chxPhieuluu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chxPhieuluuActionPerformed(evt);
            }
        });
        jPanel2.add(chxPhieuluu);

        chxHoathinh.setText("Hoạt hình");
        chxHoathinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chxHoathinhActionPerformed(evt);
            }
        });
        jPanel2.add(chxHoathinh);

        chxGiadinh.setText("Gia đình");
        chxGiadinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chxGiadinhActionPerformed(evt);
            }
        });
        jPanel2.add(chxGiadinh);

        chxTinhcam.setText("Tình cảm");
        chxTinhcam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chxTinhcamActionPerformed(evt);
            }
        });
        jPanel2.add(chxTinhcam);

        chxTamly.setText("Tâm lý");
        chxTamly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chxTamlyActionPerformed(evt);
            }
        });
        jPanel2.add(chxTamly);

        chxVientuong.setText("Viễn tưởng");
        chxVientuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chxVientuongActionPerformed(evt);
            }
        });
        jPanel2.add(chxVientuong);

        chxHai.setText("Hài");
        chxHai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chxHaiActionPerformed(evt);
            }
        });
        jPanel2.add(chxHai);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.ipadx = -345;
        gridBagConstraints.ipady = 49;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 43, 0, 0);
        jPanel1.add(jPanel2, gridBagConstraints);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        jLabel4.setText("Thể loại:");
        jPanel4.add(jLabel4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = -1;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 43, 0, 0);
        jPanel1.add(jPanel4, gridBagConstraints);

        jPanel8.setLayout(new java.awt.GridLayout(6, 1, 0, 3));

        jLabel5.setText("Thời lượng");
        jPanel8.add(jLabel5);

        jLabel6.setText("Ngày KC:");
        jPanel8.add(jLabel6);

        jLabel7.setText("Ngày KT:");
        jPanel8.add(jLabel7);

        jLabel8.setText("Sản xuất:");
        jPanel8.add(jLabel8);

        jLabel9.setText("Đạo diễn:");
        jPanel8.add(jLabel9);

        jLabel10.setText("Năm SX:");
        jPanel8.add(jLabel10);

        jPanel10.setLayout(new java.awt.GridLayout(6, 1, 0, 5));
        jPanel10.add(txtThoiLuong);
        jPanel10.add(jDateChooserNgayKhoiChieu);
        jPanel10.add(jDateChooserNgayKetThuc);

        txtSanXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSanXuatActionPerformed(evt);
            }
        });
        jPanel10.add(txtSanXuat);
        jPanel10.add(txtDaoDien);
        jPanel10.add(txtNamSX);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 242;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(43, 12, 0, 0);
        jPanel1.add(jPanel5, gridBagConstraints);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        btnThemPhim.setText("Thêm");
        btnThemPhim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemPhimActionPerformed(evt);
            }
        });
        jPanel6.add(btnThemPhim);

        btnSuaPhim.setText("Sửa");
        btnSuaPhim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaPhimActionPerformed(evt);
            }
        });
        jPanel6.add(btnSuaPhim);

        btnXoaPhim.setText("Xóa");
        btnXoaPhim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaPhimActionPerformed(evt);
            }
        });
        jPanel6.add(btnXoaPhim);

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        jPanel6.add(btnLamMoi);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 59, 54, 0);
        jPanel1.add(jPanel6, gridBagConstraints);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setLayout(new java.awt.BorderLayout());

        btnthemanh.setText("Chọn hình ảnh");
        btnthemanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemanhActionPerformed(evt);
            }
        });
        jPanel13.add(btnthemanh);

        jPanel14.add(jPanel13, java.awt.BorderLayout.PAGE_END);

        lblApPhich.setText("hình ảnh");
        jPanel14.add(lblApPhich, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(43, 6, 0, 94);
        jPanel1.add(jPanel7, gridBagConstraints);

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem)
                    .addComponent(btnTimKiem)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 18, 54, 0);
        jPanel1.add(jPanel15, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel9.setBackground(new java.awt.Color(255, 204, 204));
        jPanel9.setPreferredSize(new java.awt.Dimension(550, 313));
        jPanel9.setLayout(new java.awt.BorderLayout());

        tbPhim.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã phim", "Tên phim", "Mô tả", "Thời lượng", "Ngày KC", "Ngày KT", "Sản xuất", "Đạo diễn", "Năm SX", "Áp phích", "Thể loại"
            }
        ));
        jScrollPane1.setViewportView(tbPhim);

        jPanel9.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel9, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void txtMoTaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMoTaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMoTaActionPerformed

    private void txtSanXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSanXuatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSanXuatActionPerformed

    private void chxHanhdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chxHanhdongActionPerformed
        // TODO add your handling code here:
        hanhDong = chxHanhdong.isSelected();
    }//GEN-LAST:event_chxHanhdongActionPerformed

    private void chxPhieuluuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chxPhieuluuActionPerformed
        // TODO add your handling code here:
        phieuLuu = chxPhieuluu.isSelected();
    }//GEN-LAST:event_chxPhieuluuActionPerformed

    private void chxTamlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chxTamlyActionPerformed
        // TODO add your handling code here:
        tamLy = chxTamly.isSelected();
    }//GEN-LAST:event_chxTamlyActionPerformed

    private void chxHaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chxHaiActionPerformed
        // TODO add your handling code here:
         hai = chxHai.isSelected();
    }//GEN-LAST:event_chxHaiActionPerformed

    private void chxGiadinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chxGiadinhActionPerformed
        // TODO add your handling code here:
         giaDinh = chxGiadinh.isSelected();
    }//GEN-LAST:event_chxGiadinhActionPerformed

    
    private byte[] apPhich;
    
    private void btnthemanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemanhActionPerformed
        // TODO add your handling code here:
    JFileChooser chooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "png", "gif", "jpeg");
    chooser.setFileFilter(filter);
    int result = chooser.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = chooser.getSelectedFile();
        try {
            FileInputStream fis = new FileInputStream(selectedFile);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
            apPhich = bos.toByteArray(); // Lưu trữ ảnh vào biến apPhich
            ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
            lblApPhich.setIcon(imageIcon);
        } catch (IOException ex) {
            System.err.println("Error reading image file: " + ex.getMessage());
        }
    }
    }//GEN-LAST:event_btnthemanhActionPerformed

    private void btnThemPhimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemPhimActionPerformed

if (!hanhDong && !phieuLuu && !giaDinh && !hai && !hoatHinh && !tamLy && !tinhCam && !vienTuong) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn ít nhất một thể loại");
        return;
    }

    // Kiểm tra xem đã chọn ảnh cho phim hay chưa
    if (apPhich == null) {
        JOptionPane.showMessageDialog(this, "Vui lòng thêm hình ảnh");
        return;
    }

    // Kiểm tra các trường dữ liệu rỗng
    if (txtId.getText().isEmpty() || txtTenPhim.getText().isEmpty() || txtMoTa.getText().isEmpty() || txtThoiLuong.getText().isEmpty() ||
            jDateChooserNgayKhoiChieu.getDate() == null || jDateChooserNgayKetThuc.getDate() == null || txtSanXuat.getText().isEmpty() ||
            txtDaoDien.getText().isEmpty() || txtNamSX.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin");
        return;
    }
    
    
     try {
        // Chuyển dữ liệu về kiểu phù hợp
        String id = txtId.getText().trim();
        String TenPhim = txtTenPhim.getText().trim();
        String MoTa = txtMoTa.getText().trim();
        float ThoiLuong = Float.parseFloat(txtThoiLuong.getText().trim());
        Date NgayKhoiChieu = jDateChooserNgayKhoiChieu.getDate();
        Date NgayKetThuc = jDateChooserNgayKetThuc.getDate();
        String SanXuat = txtSanXuat.getText().trim();
        String DaoDien = txtDaoDien.getText().trim();
        int NamSX = Integer.parseInt(txtNamSX.getText().trim());
         
        // Chuyển dữ liệu về kiểu phù hợp
        if (!id.matches("^P([1-9][0-9]?|0[1-9])$")) {
        JOptionPane.showMessageDialog(this, "Mã phim phải có định dạng P + số từ 1 đến 99");
        return;
         }
        
        if (ThoiLuong <= 0) {
            JOptionPane.showMessageDialog(this, "Thời lượng không được âm");
            return;
        }
        
        PhimBUS phimBUS = new PhimBUS();
        if (phimBUS.isIdTaken(id)) {
            JOptionPane.showMessageDialog(this, "Mã phim đã tồn tại trong cơ sở dữ liệu");
            return;
        }
        
        if (NgayKhoiChieu.compareTo(NgayKetThuc) > 0) {
        JOptionPane.showMessageDialog(this, "Ngày Khởi Chiếu phải nhỏ hơn hoặc bằng Ngày Kết Thúc");
        return;
}
        
        int yearKhoiChieu = jDateChooserNgayKhoiChieu.getDate().getYear() + 1900; // Lấy năm từ 1900
        int yearKetThuc = jDateChooserNgayKetThuc.getDate().getYear() + 1900;

        // Kiểm tra xem năm sản xuất có lớn hơn năm trong ngày khởi chiếu hoặc ngày kết thúc không
        if (NamSX > yearKhoiChieu || NamSX > yearKetThuc) {
            JOptionPane.showMessageDialog(this, "Năm sản xuất không được lớn hơn năm trong ngày khởi chiếu hoặc ngày kết thúc");
            return;
        }

        // Tạo chuỗi thể loại từ các biến đã chọn
        StringBuilder tenTheLoaiBuilder = new StringBuilder();
    
    if (hanhDong) {
        tenTheLoaiBuilder.append("Hành Động, ");
    }
    if (phieuLuu) {
        tenTheLoaiBuilder.append("Phiêu lưu, ");
    }
    if (giaDinh) {
        tenTheLoaiBuilder.append("Gia đình, ");
    }
    
    if (hai) {
        tenTheLoaiBuilder.append("Hài, ");
    }
    
    if (hoatHinh) {
        tenTheLoaiBuilder.append("Hoạt Hình, ");
    }
    
    if (tamLy) {
        tenTheLoaiBuilder.append("Tâm lý, ");
    }
    
    if (tinhCam) {
        tenTheLoaiBuilder.append("Tình cảm, ");
    }
    
    if (vienTuong){
        tenTheLoaiBuilder.append("Viễn Tưởng, ");
    }
    
         if (tenTheLoaiBuilder.length() == 0) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn ít nhất một thể loại");
        return;
    }
    
    String tenTheLoai = tenTheLoaiBuilder.toString().trim();
    if (!tenTheLoai.isEmpty()) {
            tenTheLoai = tenTheLoai.substring(0, tenTheLoai.length() - 2);
        }

        // Tạo đối tượng Phim từ dữ liệu đã thu thập
        Phim phim = new Phim(id, TenPhim, MoTa, ThoiLuong, NgayKhoiChieu, NgayKetThuc, SanXuat, DaoDien, NamSX, apPhich, tenTheLoai);

        // Thêm phim vào cơ sở dữ liệu và cập nhật bảng       
        phimBUS.themPhim(phim, tbPhim);
        phimBUS.loadTableData(tbPhim);
        
        txtId.setText("");
        txtTenPhim.setText("");
        txtMoTa.setText("");
        txtThoiLuong.setText("");
        jDateChooserNgayKhoiChieu.setDate(null);
        jDateChooserNgayKetThuc.setDate(null);
        txtSanXuat.setText("");
        txtDaoDien.setText("");
        txtNamSX.setText("");
        apPhich = null;

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Lỗi khi thêm phim: " + ex.getMessage());
    }
    
    chxHanhdong.setSelected(false);
    chxPhieuluu.setSelected(false);
    chxHoathinh.setSelected(false);
    chxGiadinh.setSelected(false);
    chxTinhcam.setSelected(false);
    chxTamly.setSelected(false);
    chxVientuong.setSelected(false);
    chxHai.setSelected(false);
    
    }//GEN-LAST:event_btnThemPhimActionPerformed

    private void btnSuaPhimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaPhimActionPerformed
      String tenTheLoai = ""; // Khởi tạo biến lưu tên thể loại
    
    // Kiểm tra các thể loại được chọn và cập nhật tên thể loại
    if (hanhDong) {
        tenTheLoai += "Hành Động, ";
    }
    if (phieuLuu) {
        tenTheLoai += "Phiêu Lưu, ";
    }
    if (giaDinh) {
        tenTheLoai += "Gia đình, ";
    }
    if (hai) {
        tenTheLoai += "Hài, ";
    }
    if (hoatHinh) {
        tenTheLoai += "Hoạt Hình, ";
    }
    if (tamLy) {
        tenTheLoai += "Tâm lý, ";
    }
    if (tinhCam) {
        tenTheLoai += "Tình cảm, ";
    }
    if (vienTuong){
        tenTheLoai += "Viễn Tưởng, ";
    }
    
    // Kiểm tra các trường dữ liệu rỗng
    if (txtId.getText().isEmpty() || txtTenPhim.getText().isEmpty() || txtMoTa.getText().isEmpty() || txtThoiLuong.getText().isEmpty() ||
        jDateChooserNgayKhoiChieu.getDate() == null || jDateChooserNgayKetThuc.getDate() == null || txtSanXuat.getText().isEmpty() ||
        txtDaoDien.getText().isEmpty() || txtNamSX.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin");
        return;
    }
    
    try {
        // Chuyển dữ liệu về kiểu phù hợp
        String id = txtId.getText().trim();
        String TenPhim = txtTenPhim.getText().trim();
        String MoTa = txtMoTa.getText().trim();
        float ThoiLuong = Float.parseFloat(txtThoiLuong.getText().trim());
        Date NgayKhoiChieu = jDateChooserNgayKhoiChieu.getDate();
        Date NgayKetThuc = jDateChooserNgayKetThuc.getDate();
        String SanXuat = txtSanXuat.getText().trim();
        String DaoDien = txtDaoDien.getText().trim();
        int NamSX = Integer.parseInt(txtNamSX.getText().trim());    
        
        
        if (!id.matches("^P([1-9]|[1-9][0-9])$")) {
            JOptionPane.showMessageDialog(this, "Mã phim phải có định dạng P + số từ 1 đến 99");
            return;
        }
        
        if (ThoiLuong <= 0) {
            JOptionPane.showMessageDialog(this, "Thời lượng không được âm");
            return;
        }
        
        if (NgayKhoiChieu.compareTo(NgayKetThuc) > 0) {
            JOptionPane.showMessageDialog(this, "Ngày Khởi Chiếu phải nhỏ hơn hoặc bằng Ngày Kết Thúc");
            return;
        }
        
        int yearKhoiChieu = jDateChooserNgayKhoiChieu.getDate().getYear() + 1900;
        int yearKetThuc = jDateChooserNgayKetThuc.getDate().getYear() + 1900;
        if (NamSX > yearKhoiChieu || NamSX > yearKetThuc) {
            JOptionPane.showMessageDialog(this, "Năm sản xuất không được lớn hơn năm trong ngày khởi chiếu hoặc ngày kết thúc");
            return;
        }
        
        Phim phim = new Phim(id, TenPhim, MoTa, ThoiLuong, NgayKhoiChieu, NgayKetThuc, SanXuat, DaoDien, NamSX, apPhich, tenTheLoai);
        phimBUS.suaPhim(phim); // Gọi phương thức sửa phim từ BUS hoặc DAO
        phimBUS.loadTableData(tbPhim);
        
        txtId.setText("");
        txtTenPhim.setText("");
        txtMoTa.setText("");
        txtThoiLuong.setText("");
        jDateChooserNgayKhoiChieu.setDate(null);
        jDateChooserNgayKetThuc.setDate(null);
        txtSanXuat.setText("");
        txtDaoDien.setText("");
        txtNamSX.setText("");
        apPhich = null;

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Lỗi khi sửa phim: " + ex.getMessage());
    }  
    }//GEN-LAST:event_btnSuaPhimActionPerformed

    private void btnXoaPhimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaPhimActionPerformed
           String id = txtId.getText().trim();

    // Kiểm tra xem ID có được cung cấp không
    if (id.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập ID của phim cần xóa");
        return;
    }

    try {
        // Hiển thị hộp thoại xác nhận xóa
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa phim này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) { // Nếu người dùng đồng ý xóa
            phimBUS.xoaPhim(id); // Gọi phương thức xóa phim từ BUS hoặc DAO
            phimBUS.loadTableData(tbPhim); // Load lại dữ liệu lên bảng phim sau khi xóa
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Lỗi khi xóa phim: " + ex.getMessage());
    }
    loadTableData();

    }//GEN-LAST:event_btnXoaPhimActionPerformed

    private void chxHoathinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chxHoathinhActionPerformed
        // TODO add your handling code here:
        hoatHinh = chxHoathinh.isSelected();
    }//GEN-LAST:event_chxHoathinhActionPerformed

    private void chxTinhcamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chxTinhcamActionPerformed
        // TODO add your handling code here:
        tinhCam = chxTinhcam.isSelected();
    }//GEN-LAST:event_chxTinhcamActionPerformed

    private void chxVientuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chxVientuongActionPerformed
        // TODO add your handling code here:
        vienTuong = chxVientuong.isSelected();
    }//GEN-LAST:event_chxVientuongActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        phimBUS.loadTableData(tbPhim);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        String tenCanTim = txtTimKiem.getText().trim();

    // Kiểm tra xem từ khóa tìm kiếm có rỗng không
    if (tenCanTim.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Vui lòng nhập từ khóa tìm kiếm");
        return;
    }

    // Thực hiện tìm kiếm và cập nhật bảng hiển thị
    PhimBUS phimBUS = new PhimBUS(); // Khởi tạo đối tượng PhimBUS
    boolean result = phimBUS.timPhim(tbPhim, tenCanTim);

    // Kiểm tra kết quả tìm kiếm và hiển thị thông báo tương ứng
    if (!result) {
        JOptionPane.showMessageDialog(null, "Đã thực hiện tìm !");
    }
    }//GEN-LAST:event_btnTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSuaPhim;
    private javax.swing.JButton btnThemPhim;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoaPhim;
    private javax.swing.JButton btnthemanh;
    private javax.swing.JCheckBox chxGiadinh;
    private javax.swing.JCheckBox chxHai;
    private javax.swing.JCheckBox chxHanhdong;
    private javax.swing.JCheckBox chxHoathinh;
    private javax.swing.JCheckBox chxPhieuluu;
    private javax.swing.JCheckBox chxTamly;
    private javax.swing.JCheckBox chxTinhcam;
    private javax.swing.JCheckBox chxVientuong;
    private com.toedter.calendar.JDateChooser jDateChooserNgayKetThuc;
    private com.toedter.calendar.JDateChooser jDateChooserNgayKhoiChieu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblApPhich;
    private javax.swing.JTable tbPhim;
    private javax.swing.JTextField txtDaoDien;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtNamSX;
    private javax.swing.JTextField txtSanXuat;
    private javax.swing.JTextField txtTenPhim;
    private javax.swing.JTextField txtThoiLuong;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

   
}
