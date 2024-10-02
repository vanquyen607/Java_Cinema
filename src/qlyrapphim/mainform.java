package qlyrapphim;

import GUI.QlyDinhDang;
import GUI.QlyLoaiManHinh;
import VIEW.QlyDoanhThu;


import java.awt.CardLayout;
import java.awt.Color;
import qlyrapphim.GUI.QlyKhachHang;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ColorModel;
import qlyrapphim.Account;
import qlyrapphim.GUI.NhanVienJPanel;
import qlyrapphim.GUI.QlyPhim;
import qlyrapphim.GUI.QlyTheLoai;
import qlyrapphim.GUI.QlyTaiKhoan;
import qlyrapphim.GUI.PanelNull;
import qlyrapphim.GUI.PanelNull;
import qlyrapphim.GUI.QLVe;
import qlyrapphim.GUI.QLVe;
import qlyrapphim.GUI.QlyKhachHang;
import qlyrapphim.GUI.QlyLichChieu;
import qlyrapphim.GUI.QlyPhim;
import qlyrapphim.GUI.QlyPhongChieu;
import qlyrapphim.GUI.QlyPhongChieu;
import qlyrapphim.GUI.QlyTaiKhoan;
import qlyrapphim.GUI.QlyTheLoai;
//import com.toedter.calendar.JDateChooser;


public class mainform extends javax.swing.JFrame {
    CardLayout CrLayout;
    
    public mainform() {
        initComponents();
        setLocationRelativeTo(null);
        CrLayout = (CardLayout) pnContent.getLayout(); //biến cardlayout lấy kiểu layout của pnContent
        //Tạo các panel con:
        QlyKhachHang pnKhachHang = new QlyKhachHang();
        NhanVienJPanel pnNhanVien = new NhanVienJPanel();
        QlyTaiKhoan pnTaiKhoan = new QlyTaiKhoan();
        QlyLoaiManHinh pnManHinh = new QlyLoaiManHinh();
        QlyPhim pnPhim = new QlyPhim();
        QlyTheLoai pnTheLoai = new QlyTheLoai();
        QlyLichChieu pnLichChieu = new QlyLichChieu();
        QLVe pnVe = new QLVe();
        QlyPhongChieu pnPhongChieu = new QlyPhongChieu();
        QlyDinhDang pnDinhDang = new QlyDinhDang();
        PanelNull pnnull = new PanelNull();
        QlyDoanhThu pnDoanhThu = new QlyDoanhThu();
        
        //Thêm các panel vào pnContent:
        pnContent.add(pnKhachHang,"pnkhachhang");
        pnContent.add(pnNhanVien,"pnnhanvien");
        pnContent.add(pnTaiKhoan, "pntaikhoan");
        pnContent.add(pnnull,"pnnull");
        pnContent.add(pnManHinh,"pnmanhinh");
        pnContent.add(pnPhim,"pnphim");
        pnContent.add(pnTheLoai,"pntheloai");
        pnContent.add(pnLichChieu,"pnlichchieu");
        pnContent.add(pnVe,"pnve");
        pnContent.add(pnPhongChieu,"pnphongchieu");
        pnContent.add(pnDoanhThu,"pndoanhthu");
        pnContent.add(pnDinhDang,"pndinhdang");
        
        CrLayout.show(pnContent, "pnnull"); //panel xuất hiện mặc định khi chương trình khởi chạy !
        
        btnVe.setVisible(false);
        btnLoaiMH.setVisible(false);
        btnPhongChieu.setVisible(false);
        btnTheloai.setVisible(false);
        btnPhim.setVisible(false);
        btnDinhDang.setVisible(false);
        btnLichChieu.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        pnMenuDulieu = new javax.swing.JPanel();
        btnLoaiMH = new javax.swing.JButton();
        btnPhongChieu = new javax.swing.JButton();
        btnTheloai = new javax.swing.JButton();
        btnPhim = new javax.swing.JButton();
        btnDinhDang = new javax.swing.JButton();
        btnLichChieu = new javax.swing.JButton();
        btnVe = new javax.swing.JButton();
        pnContent = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnDoanhthu = new javax.swing.JButton();
        btnDulieu = new javax.swing.JButton();
        btnNhanvien = new javax.swing.JButton();
        btnTaikhoan = new javax.swing.JButton();
        btnKhachhang = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 770));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        pnMenuDulieu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        pnMenuDulieu.setPreferredSize(new java.awt.Dimension(200, 502));

        btnLoaiMH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLoaiMH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Untitled-2_0001_Layer-8.png"))); // NOI18N
        btnLoaiMH.setText("Loại màn hình");
        btnLoaiMH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoaiMHActionPerformed(evt);
            }
        });

        btnPhongChieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPhongChieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Closed door.png"))); // NOI18N
        btnPhongChieu.setText("Phòng chiếu");
        btnPhongChieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhongChieuActionPerformed(evt);
            }
        });

        btnTheloai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTheloai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Favourites.png"))); // NOI18N
        btnTheloai.setText("Thể loại");
        btnTheloai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTheloaiActionPerformed(evt);
            }
        });

        btnPhim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPhim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Untitled-2_0003_Layer-6.png"))); // NOI18N
        btnPhim.setText("Phim");
        btnPhim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhimActionPerformed(evt);
            }
        });

        btnDinhDang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDinhDang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Notes.png"))); // NOI18N
        btnDinhDang.setText("Định dạng");
        btnDinhDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDinhDangActionPerformed(evt);
            }
        });

        btnLichChieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLichChieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Calendar.png"))); // NOI18N
        btnLichChieu.setText("Lịch chiếu");
        btnLichChieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichChieuActionPerformed(evt);
            }
        });

        btnVe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ticket.png"))); // NOI18N
        btnVe.setText("Vé");
        btnVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnMenuDulieuLayout = new javax.swing.GroupLayout(pnMenuDulieu);
        pnMenuDulieu.setLayout(pnMenuDulieuLayout);
        pnMenuDulieuLayout.setHorizontalGroup(
            pnMenuDulieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuDulieuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnMenuDulieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLoaiMH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPhongChieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTheloai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPhim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDinhDang, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(btnLichChieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnMenuDulieuLayout.setVerticalGroup(
            pnMenuDulieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuDulieuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnLoaiMH, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnPhongChieu, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnTheloai, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnPhim, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnDinhDang, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnLichChieu, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnVe, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel1.add(pnMenuDulieu);

        pnContent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        pnContent.setPreferredSize(new java.awt.Dimension(600, 504));
        pnContent.setLayout(new java.awt.CardLayout());
        jPanel1.add(pnContent);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(799, 120));

        btnDoanhthu.setBackground(new java.awt.Color(255, 0, 0));
        btnDoanhthu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDoanhthu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Bar chart.png"))); // NOI18N
        btnDoanhthu.setText("Doanh Thu");
        buttonGroup1.add(btnDoanhthu);
        btnDoanhthu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoanhthuActionPerformed(evt);
            }
        });

        btnDulieu.setBackground(new java.awt.Color(255, 0, 0));
        btnDulieu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDulieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Documents.png"))); // NOI18N
        btnDulieu.setText("Dữ Liệu ");
        buttonGroup1.add(btnDulieu);
        btnDulieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDulieuActionPerformed(evt);
            }
        });

        btnNhanvien.setBackground(new java.awt.Color(255, 0, 0));
        btnNhanvien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNhanvien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/employee-office-staff-3d735bc691173bb5-256x256.png"))); // NOI18N
        btnNhanvien.setText("Nhân Viên");
        buttonGroup1.add(btnNhanvien);
        btnNhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanvienActionPerformed(evt);
            }
        });

        btnTaikhoan.setBackground(new java.awt.Color(255, 0, 0));
        btnTaikhoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTaikhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Open door.png"))); // NOI18N
        btnTaikhoan.setText("Tài Khoản");
        buttonGroup1.add(btnTaikhoan);
        btnTaikhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaikhoanActionPerformed(evt);
            }
        });

        btnKhachhang.setBackground(new java.awt.Color(255, 0, 0));
        btnKhachhang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKhachhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/User.png"))); // NOI18N
        btnKhachhang.setText("Khách Hàng");
        buttonGroup1.add(btnKhachhang);
        btnKhachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachhangActionPerformed(evt);
            }
        });

        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dangxuat_icon.png"))); // NOI18N
        btnDangXuat.setText("Đăng Xuất");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnDoanhthu)
                .addGap(15, 15, 15)
                .addComponent(btnKhachhang)
                .addGap(15, 15, 15)
                .addComponent(btnDulieu)
                .addGap(15, 15, 15)
                .addComponent(btnNhanvien)
                .addGap(15, 15, 15)
                .addComponent(btnTaikhoan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnDangXuat)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDoanhthu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDulieu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    //Btn Menu main
    private void btnDoanhthuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoanhthuActionPerformed
        // TODO add your handling code here:
        btnDoanhthu.setBackground(Color.yellow); //Đổi màu khi click
        //Các đối tượng khác về màu mặc định
        btnKhachhang.setBackground(Color.red);
        btnDulieu.setBackground(Color.red);
        btnNhanvien.setBackground(Color.red);
        btnTaikhoan.setBackground(Color.red);
        
        //ẩn menu Dữ liệu
        
        pnMenuDulieu.setVisible(false);
        
        CrLayout.show(pnContent,"pndoanhthu");
        
        btnVe.setVisible(false);
        btnLoaiMH.setVisible(false);
        btnPhongChieu.setVisible(false);
        btnTheloai.setVisible(false);
        btnPhim.setVisible(false);
        btnDinhDang.setVisible(false);
        btnLichChieu.setVisible(false);
    }//GEN-LAST:event_btnDoanhthuActionPerformed

    private void btnKhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachhangActionPerformed
        // TODO add your handling code here:
        btnKhachhang.setBackground(Color.yellow);
        //Các đối tượng khác về màu mặc định
        btnDoanhthu.setBackground(Color.red);
        btnDulieu.setBackground(Color.red);
        btnNhanvien.setBackground(Color.red);
        btnTaikhoan.setBackground(Color.red);
        
        //ẩn menu Dữ liệu
        
        pnMenuDulieu.setVisible(false);
        
        CrLayout.show(pnContent,"pnkhachhang");
        btnVe.setVisible(false);
        btnLoaiMH.setVisible(false);
        btnPhongChieu.setVisible(false);
        btnTheloai.setVisible(false);
        btnPhim.setVisible(false);
        btnDinhDang.setVisible(false);
        btnLichChieu.setVisible(false);
        
    }//GEN-LAST:event_btnKhachhangActionPerformed

    private void btnNhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanvienActionPerformed
        // TODO add your handling code here:
        btnNhanvien.setBackground(Color.yellow);
        //Các đối tượng khác về màu mặc định
        btnDoanhthu.setBackground(Color.red);
        btnDulieu.setBackground(Color.red);
        btnKhachhang.setBackground(Color.red);
        btnTaikhoan.setBackground(Color.red);
        
        //ẩn menu Dữ liệu
        
        pnMenuDulieu.setVisible(false);
        
        CrLayout.show(pnContent, "pnnhanvien");
        btnVe.setVisible(false);
        btnLoaiMH.setVisible(false);
        btnPhongChieu.setVisible(false);
        btnTheloai.setVisible(false);
        btnPhim.setVisible(false);
        btnDinhDang.setVisible(false);
        btnLichChieu.setVisible(false);
    }//GEN-LAST:event_btnNhanvienActionPerformed

    private void btnTaikhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaikhoanActionPerformed
        // TODO add your handling code here:
        btnTaikhoan.setBackground(Color.yellow);
        //Các đối tượng khác về màu mặc định
        btnDoanhthu.setBackground(Color.red);
        btnDulieu.setBackground(Color.red);
        btnKhachhang.setBackground(Color.red);
        btnNhanvien.setBackground(Color.red);
        
        //ẩn menu Dữ liệu
        
        pnMenuDulieu.setVisible(false);
        
        CrLayout.show(pnContent, "pntaikhoan");
        btnVe.setVisible(false);
        btnLoaiMH.setVisible(false);
        btnPhongChieu.setVisible(false);
        btnTheloai.setVisible(false);
        btnPhim.setVisible(false);
        btnDinhDang.setVisible(false);
        btnLichChieu.setVisible(false);
    }//GEN-LAST:event_btnTaikhoanActionPerformed
    //Btn menu Dữ liệu
            
    private void btnLoaiMHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoaiMHActionPerformed
        // TODO add your handling code here:
        btnLoaiMH.setBackground(Color.red);
        CrLayout.show(pnContent,"pnmanhinh");
        
        btnPhongChieu.setBackground(null);
        btnTheloai.setBackground(null);
        btnPhim.setBackground(null);
        btnDinhDang.setBackground(null);
        btnLichChieu.setBackground(null);
        btnVe.setBackground(null);
        
   
    }//GEN-LAST:event_btnLoaiMHActionPerformed

    private void btnPhongChieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhongChieuActionPerformed
        // TODO add your handling code here:
        btnPhongChieu.setBackground(Color.red);
        CrLayout.show(pnContent,"pnphongchieu");
        btnTheloai.setBackground(null);
        btnPhim.setBackground(null);
        btnDinhDang.setBackground(null);
        btnLichChieu.setBackground(null);
        btnVe.setBackground(null);
        btnLoaiMH.setBackground(null);

    }//GEN-LAST:event_btnPhongChieuActionPerformed

    private void btnTheloaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTheloaiActionPerformed
        // TODO add your handling code here:
        btnTheloai.setBackground(Color.red);
        CrLayout.show(pnContent,"pntheloai");
        btnLoaiMH.setBackground(null);       
        btnPhongChieu.setBackground(null);
        btnPhim.setBackground(null);
        btnDinhDang.setBackground(null);
        btnLichChieu.setBackground(null);
        btnVe.setBackground(null);
    }//GEN-LAST:event_btnTheloaiActionPerformed

    private void btnPhimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhimActionPerformed
        // TODO add your handling code here:
        btnPhim.setBackground(Color.red);
        CrLayout.show(pnContent, "pnphim");
        btnLoaiMH.setBackground(null);
        btnPhongChieu.setBackground(null);
        btnTheloai.setBackground(null);
        btnDinhDang.setBackground(null);
        btnLichChieu.setBackground(null);
        btnVe.setBackground(null);
    }//GEN-LAST:event_btnPhimActionPerformed

    private void btnDinhDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDinhDangActionPerformed
        // TODO add your handling code here:
        btnDinhDang.setBackground(Color.red);
        
        CrLayout.show(pnContent,"pndinhdang");
        
        btnLoaiMH.setBackground(null);       
        btnPhongChieu.setBackground(null);
        btnTheloai.setBackground(null);
        btnPhim.setBackground(null);
        btnLichChieu.setBackground(null);
        btnVe.setBackground(null);
    }//GEN-LAST:event_btnDinhDangActionPerformed

    private void btnLichChieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLichChieuActionPerformed
        // TODO add your handling code here:
        btnLichChieu.setBackground(Color.red);
        CrLayout.show(pnContent,"pnlichchieu");
        btnLoaiMH.setBackground(null);        
        btnPhongChieu.setBackground(null);
        btnTheloai.setBackground(null);
        btnPhim.setBackground(null);
        btnDinhDang.setBackground(null);
        btnVe.setBackground(null);
    }//GEN-LAST:event_btnLichChieuActionPerformed

    private void btnVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVeActionPerformed
        // TODO add your handling code here:
        btnVe.setBackground(Color.red);
        CrLayout.show(pnContent,"pnve");
        btnLoaiMH.setBackground(null);
        btnPhongChieu.setBackground(null);
        btnTheloai.setBackground(null);
        btnPhim.setBackground(null);
        btnDinhDang.setBackground(null);
        btnLichChieu.setBackground(null);
    }//GEN-LAST:event_btnVeActionPerformed

    private void btnDulieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDulieuActionPerformed
        // TODO add your handling code here:
        btnDulieu.setBackground(Color.yellow);
        
        btnDoanhthu.setBackground(Color.red);
        btnTaikhoan.setBackground(Color.red);
        btnKhachhang.setBackground(Color.red);
        btnNhanvien.setBackground(Color.red);
        
        //Hiện menu Dữ liệu
        
        pnMenuDulieu.setVisible(true);
        
        btnVe.setVisible(true);
        btnLoaiMH.setVisible(true);
        btnPhongChieu.setVisible(true);
        btnTheloai.setVisible(true);
        btnPhim.setVisible(true);
        btnDinhDang.setVisible(true);
        btnLichChieu.setVisible(true);
        
        CrLayout.show(pnContent,"pnnull");
        
    }//GEN-LAST:event_btnDulieuActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:
        dispose();
        Account newaccform = new Account();
        newaccform.setVisible(true);
    }//GEN-LAST:event_btnDangXuatActionPerformed

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
            java.util.logging.Logger.getLogger(mainform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDinhDang;
    private javax.swing.JButton btnDoanhthu;
    private javax.swing.JButton btnDulieu;
    private javax.swing.JButton btnKhachhang;
    private javax.swing.JButton btnLichChieu;
    private javax.swing.JButton btnLoaiMH;
    private javax.swing.JButton btnNhanvien;
    private javax.swing.JButton btnPhim;
    private javax.swing.JButton btnPhongChieu;
    private javax.swing.JButton btnTaikhoan;
    private javax.swing.JButton btnTheloai;
    private javax.swing.JButton btnVe;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnContent;
    private javax.swing.JPanel pnMenuDulieu;
    // End of variables declaration//GEN-END:variables
}
