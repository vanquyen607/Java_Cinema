
package qlyrapphim.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import qlyrapphim.BUS.ManChieuBUS;
import qlyrapphim.DAO.LichChieuDAO;
import qlyrapphim.DAO.ManChieuDao;
import qlyrapphim.DAO.PhongChieuDao;
import qlyrapphim.DAO.TicketDAO;
import qlyrapphim.DTO.LichChieuDTO;
import qlyrapphim.DTO.PhongChieu;
import qlyrapphim.DTO.Ticket;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.JTable;
import java.io.FileOutputStream;
import java.io.IOException;

public class ManChieuGUI extends javax.swing.JFrame {
    private BigDecimal giave = null;
    private List<Ticket> seatSelected; // Danh sách các vé đã chọn
    private PhongChieu pc = null;
    List<Ticket> listTicket = null;
    String loaive = null;
    String tenphim = null;
    String giochieu =null;
    public List<Ticket> getListSelectedVe(){
        return seatSelected;
    }
    
    public ManChieuGUI(String idPhong,String tenPhong, String tenPhim, String gioChieu, String tinhTrang) {
        initComponents();
        lblTenPhong.setText(tenPhong);
        lblTenPhim.setText(tenPhim);
        lblGioChieu.setText(gioChieu);
        setLocationRelativeTo(null);
        
        tenphim = tenPhim;
        giochieu = gioChieu;
        
        pc = PhongChieuDao.getCinemaByid(idPhong);
        LichChieuDTO lc = LichChieuDAO.getLichChieuByIdPhong(idPhong);
        listTicket = TicketDAO.getListTicketsByShowTimes(lc.getId());
        giave = new BigDecimal(lc.getGiaVe());
        // Tạo ghế ngồi từ danh sách vé đã chọn
        
        createSeats(listTicket, pc);
        
        // Khởi tạo danh sách vé đã chọn
        seatSelected = new ArrayList<>();
        
        // Thêm mã xử lý cho các RadioButton
        rdNguoiLon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNguoiLonActionPerformed(evt);
                loaive ="Nguoi lon";
            }
        });
        rdSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdSinhVienActionPerformed(evt);
                loaive = "Sinh vien";
            }
        });
        rdTreEm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdTreEmActionPerformed(evt);
                loaive = "Tre em";
            }
        });  
    }
    
    public void createSeats(List<Ticket> listTicket, PhongChieu phongChieu) {
        int soHangGhe = phongChieu.getSohangghe();
        int soGheMoiHang = phongChieu.getSoghemothang();

        panelGhe.setLayout(new GridLayout(soHangGhe, soGheMoiHang)); // Sử dụng GridLayout

        for (int i = 0; i < soHangGhe; i++) {
            for (int j = 0; j < soGheMoiHang; j++) {
                int index = i * soGheMoiHang + j;
                if (index < listTicket.size()) {
                    Ticket ticket = listTicket.get(index);
                    JButton seat = new JButton(ticket.getSeatName());
                    seat.setPreferredSize(new Dimension(30, 10)); // Đặt kích thước cho ghế ngồi

                    // Thiết lập màu cho ghế ngồi dựa trên trạng thái vé
                    if (ticket.getStatus() == 1) {
                        seat.setBackground(Color.RED); // Ghế đã bán
                        seat.setEnabled(false); // Không thể chọn ghế đã bán
                    } else {
                        seat.setBackground(Color.WHITE); // Ghế chưa bán
                        // Thêm sự kiện cho ghế ngồi
                        seat.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Lưu vé vào danh sách seatSelected khi người dùng chọn ghế
                                seatSelected.add(ticket);
                                seat.setBackground(Color.BLUE); // Màu xanh cho ghế đã chọn
                                // Hiển thị thông tin ghế đã chọn
                                JOptionPane.showMessageDialog(null, "Bạn đã chọn ghế " + ticket.getSeatName());
                            }
                        });
                    }
                    panelGhe.add(seat); // Thêm ghế vào panelGhe
                }
            }
        }
        // Cập nhật lại giao diện
        panelGhe.revalidate();
        panelGhe.repaint();
    }
    
    public void refreshGUI() {
        // Xóa các ghế ngồi hiện tại trên giao diện
        panelGhe.removeAll();

        // Tải lại danh sách ghế ngồi
        createSeats(listTicket,pc);

        // Cập nhật lại giao diện
        panelGhe.revalidate();
        panelGhe.repaint();
    }

    public boolean xuatHD(String tenPhong, String tenPhim, String gioChieu, List<Ticket> seatSelected, String loaive, String giaveString, String tongtienString, String giagiamString, String tienthanhtoanString) {
        boolean thanhCong = false;

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream("HoaDon.pdf"));
            document.open();

            // Tạo nội dung cho hoá đơn
            document.add(createReceiptContent(tenPhong, tenPhim, gioChieu, seatSelected, loaive, giaveString, tongtienString, giagiamString, tienthanhtoanString));

            thanhCong = true;
        } catch (DocumentException | IOException ex) {
            ex.printStackTrace();
        } finally {
            if (document != null) {
                document.close();
            }
        }

        return thanhCong;
    }

    private PdfPTable createReceiptContent(String tenPhong, String tenPhim, String gioChieu, List<Ticket> seatSelected, String loaive, String giaveString, String tongtienString, String giagiamString, String tienthanhtoanString) throws DocumentException {
        PdfPTable table = new PdfPTable(2); // 2 cột

        // Tiêu đề
        Font fontTieuDe = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        Paragraph paragraph = new Paragraph("-----Payment-----", fontTieuDe);
        PdfPCell cellHeader = new PdfPCell(paragraph);
        cellHeader.setColspan(2);
        cellHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellHeader.setBorder(Rectangle.NO_BORDER);
        table.addCell(cellHeader);

        // Thông tin phòng chiếu
        table.addCell(createCell("Room:", Element.ALIGN_LEFT));
        table.addCell(createCell(tenPhong, Element.ALIGN_RIGHT));

        // Thông tin tên phim
        table.addCell(createCell("Name Film:", Element.ALIGN_LEFT));
        table.addCell(createCell(tenPhim, Element.ALIGN_RIGHT));

        // Thông tin giờ chiếu
        table.addCell(createCell("Time:", Element.ALIGN_LEFT));
        table.addCell(createCell(gioChieu, Element.ALIGN_RIGHT));

        // Thêm thông tin từ danh sách vé đã chọn vào bảng
        for (Ticket ticket : seatSelected) {
            table.addCell(createCell("Ticket " + ticket.getSeatName(), Element.ALIGN_LEFT));
            table.addCell(createCell(String.valueOf(ticket.getPrice()), Element.ALIGN_RIGHT));
        }

        // Thêm thông tin khác của hoá đơn vào bảng
        table.addCell(createCell("Type:", Element.ALIGN_LEFT));
        table.addCell(createCell(loaive, Element.ALIGN_RIGHT));
        table.addCell(createCell("Ticket Price:", Element.ALIGN_LEFT));
        table.addCell(createCell(giaveString, Element.ALIGN_RIGHT));
        table.addCell(createCell("Total price:", Element.ALIGN_LEFT));
        table.addCell(createCell(tongtienString, Element.ALIGN_RIGHT));
        table.addCell(createCell("Disscount:", Element.ALIGN_LEFT));
        table.addCell(createCell(giagiamString, Element.ALIGN_RIGHT));
        table.addCell(createCell("Total:", Element.ALIGN_LEFT));
        table.addCell(createCell(tienthanhtoanString, Element.ALIGN_RIGHT));

        return table;
    }

    private PdfPCell createCell(String content, int alignment) {
        Font fontDuLieu = new Font(Font.FontFamily.TIMES_ROMAN, 10);
        PdfPCell cell = new PdfPCell(new Phrase(content, fontDuLieu));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(alignment);
        return cell;
    }
    
    public void handlePayment() {
        // Kiểm tra xem có ghế nào được chọn không
        if (!seatSelected.isEmpty()) {
            // Lưu trạng thái của các vé đã được bán
            for (Ticket ticket : seatSelected) {
                // Cập nhật trạng thái của vé trong cơ sở dữ liệu
                int updatedRows = TicketDAO.buyTicket(ticket.getID(), ticket.getPrice());
                if (updatedRows > 0) {
                    ticket.setStatus(1); // Cập nhật trạng thái thành đã bán
                } else {
                    // Xử lý trường hợp cập nhật không thành công (nếu cần)
                    // Ví dụ: thông báo lỗi
                    JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật trạng thái của vé " + ticket.getID());
                }
            }

            String giaveString = txtGiaVe.getText();
            String tongtienString = txtTongTien.getText();
            String giagiamString = txtGiaGiam.getText();
            String tienthanhtoanString = txtTienPhaiThanhToan.getText();
            // Hiển thị thông báo xác nhận thanh toán
            JOptionPane.showMessageDialog(null, "Thanh toán thành công!");

            //Xuat hoa don 
            xuatHD(pc.getTenphong(),tenphim,giochieu,seatSelected,loaive,giaveString,tongtienString,giagiamString,tienthanhtoanString);
            
            // Cập nhật lại giao diện hoặc chuyển hướng người dùng đến trang cần thiết (nếu cần)
            // Ví dụ: clear danh sách ghế đã chọn, cập nhật giao diện về trạng thái ban đầu
            clearSelectedSeats();
            // Cập nhật lại giao diện
            refreshGUI();
            
        } else {
            // Thông báo cho người dùng chưa chọn ghế nào để thanh toán
            JOptionPane.showMessageDialog(null, "Vui lòng chọn ghế trước khi thanh toán.");
        }
    }


    // Phương thức để xóa danh sách ghế đã chọn sau khi thanh toán
    public void clearSelectedSeats() {
        seatSelected.clear(); // Xóa danh sách ghế đã chọn
    }
    
//    public void updateTicketPrice(BigDecimal giaVe) {
//        BigDecimal giamGia = BigDecimal.ZERO; // Khởi tạo giảm giá ban đầu là 0
//        BigDecimal tongTien = BigDecimal.ZERO; // Khởi tạo tổng tiền ban đầu là 0
//        BigDecimal tienThanhToan = BigDecimal.ZERO; // Khởi tạo tiền thanh toán ban đầu là 0
//        BigDecimal giaVeGiamGia = BigDecimal.ZERO; // Khởi tạo giá vé sau khi giảm giá
//        BigDecimal giamGiaKhuyenMai = BigDecimal.ZERO;
//
//        // Kiểm tra xem RadioButton nào được chọn và cập nhật giảm giá
//        if (rdNguoiLon.isSelected()) {
//            // Không có giảm giá cho người lớn
//            giaVeGiamGia = giaVe; // Giá vé giữ nguyên
//        } else if (rdSinhVien.isSelected()) {
//            // Giảm giá 20% cho sinh viên
//            giamGia = giaVe.multiply(new BigDecimal("0.2"));
//            giaVeGiamGia = giaVe.subtract(giamGia); // Giá vé sau khi giảm giá
//        } else if (rdTreEm.isSelected()) {
//            // Giảm giá 50% cho trẻ em
//            giamGia = giaVe.multiply(new BigDecimal("0.5"));
//            giaVeGiamGia = giaVe.subtract(giamGia); // Giá vé sau khi giảm giá
//        }
//        
//        for(Ticket TK : seatSelected){
//            TK.setPrice(giaVeGiamGia.floatValue());
//        }
//
//        // Tính tổng tiền dựa trên số lượng ghế đã chọn và giá vé
//        tongTien = giaVeGiamGia.multiply(new BigDecimal(String.valueOf(seatSelected.size())));
//
//        // Tính tiền thanh toán
//        tienThanhToan = tongTien.subtract(giamGiaKhuyenMai); // Tiền thanh toán = Tổng tiền - Giảm giá KM
//
//        // Hiển thị giá vé, tổng tiền, giảm giá và tiền thanh toán trên giao diện
//        txtGiaVe.setText(giaVeGiamGia.toString());
//        txtTongTien.setText(tongTien.toString());
//        txtGiaGiam.setText(giamGiaKhuyenMai.toString());
//        txtTienPhaiThanhToan.setText(tienThanhToan.toString());
//    }

    public void handleCancel() {
        // Xóa các ghế đã chọn khỏi danh sách seatSelected
        seatSelected.clear();

        // Cập nhật lại giao diện cho các ghế đã chọn
        Component[] components = panelGhe.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                if (button.getBackground().equals(Color.BLUE)) {
                    button.setBackground(Color.WHITE); // Đổi màu về trạng thái ban đầu
                }
            }
        }

        // Hiển thị thông báo hoặc thực hiện các hành động khác nếu cần
        JOptionPane.showMessageDialog(null, "Đã hủy bỏ chọn ghế.");
    }

    // Tạo một phương thức khởi chạy mới và gọi nó từ phương thức main
    public static void startGUI(String tenPhong, String tenPhim, String gioChieu, String tinhTrang) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManChieuGUI(tenPhong, tenPhim, gioChieu, tinhTrang, tinhTrang).setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        lblTenPhong = new javax.swing.JLabel();
        lblTenPhim = new javax.swing.JLabel();
        lblGioChieu = new javax.swing.JLabel();
        TenPhong = new javax.swing.JLabel();
        TenPhim = new javax.swing.JLabel();
        GioChieu = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Rap = new javax.swing.JLabel();
        tieudeTenRap = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelGhe = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        rdNguoiLon = new javax.swing.JRadioButton();
        rdSinhVien = new javax.swing.JRadioButton();
        rdTreEm = new javax.swing.JRadioButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        txtGiaVe = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        btnHuy = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        txtTongTien = new javax.swing.JTextField();
        txtGiaGiam = new javax.swing.JTextField();
        txtTienPhaiThanhToan = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel22.setPreferredSize(new java.awt.Dimension(440, 100));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTenPhong.setBackground(new java.awt.Color(102, 255, 102));
        jPanel22.add(lblTenPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 210, 20));
        jPanel22.add(lblTenPhim, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 210, 20));

        lblGioChieu.setBackground(new java.awt.Color(255, 153, 0));
        jPanel22.add(lblGioChieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 210, 20));

        TenPhong.setBackground(new java.awt.Color(102, 255, 102));
        TenPhong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TenPhong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TenPhong.setText("PHÒNG:");
        jPanel22.add(TenPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 50, 20));

        TenPhim.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TenPhim.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TenPhim.setText("PHIM:");
        jPanel22.add(TenPhim, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 40, 20));

        GioChieu.setBackground(new java.awt.Color(255, 153, 0));
        GioChieu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        GioChieu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        GioChieu.setText("GIỜ CHIẾU:");
        jPanel22.add(GioChieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 70, 20));

        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        Rap.setBackground(new java.awt.Color(102, 204, 0));
        Rap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Rap.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Rap.setText("Rạp");
        Rap.setToolTipText("");
        Rap.setInheritsPopupMenu(false);
        Rap.setPreferredSize(new java.awt.Dimension(141, 100));
        jPanel5.add(Rap);

        tieudeTenRap.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        tieudeTenRap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tieudeTenRap.setText("RGV A");
        jPanel5.add(tieudeTenRap);

        jPanel22.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 40));

        jPanel2.add(jPanel22, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MÀN CHIẾU");
        jPanel4.add(jLabel1);

        panelGhe.setLayout(new java.awt.GridLayout(5, 10, 3, 3));

        jPanel6.setPreferredSize(new java.awt.Dimension(100, 112));
        jPanel6.setLayout(new java.awt.BorderLayout());
        jPanel6.add(jLabel37, java.awt.BorderLayout.CENTER);

        jTextField5.setBackground(new java.awt.Color(204, 204, 204));

        jTextField7.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel44.setText("Đã mua");

        jLabel46.setText("Đang chọn");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addComponent(jLabel46))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel44)
                .addGap(40, 40, 40)
                .addComponent(jLabel46)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel17, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelGhe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addComponent(panelGhe, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        jPanel8.setPreferredSize(new java.awt.Dimension(131, 65));
        jPanel8.setLayout(new java.awt.GridLayout(1, 0));

        jPanel9.setPreferredSize(new java.awt.Dimension(200, 79));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.Y_AXIS));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel38.setText("Loại vé");
        jPanel9.add(jLabel38);

        buttonGroup1.add(rdNguoiLon);
        rdNguoiLon.setText("Người lớn");
        rdNguoiLon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNguoiLonActionPerformed(evt);
            }
        });
        jPanel9.add(rdNguoiLon);

        buttonGroup1.add(rdSinhVien);
        rdSinhVien.setText("Sinh viên ");
        rdSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdSinhVienActionPerformed(evt);
            }
        });
        jPanel9.add(rdSinhVien);

        buttonGroup1.add(rdTreEm);
        rdTreEm.setSelected(true);
        rdTreEm.setText("Trẻ em (dưới 12 tuổi)");
        rdTreEm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdTreEmActionPerformed(evt);
            }
        });
        jPanel9.add(rdTreEm);

        jPanel8.add(jPanel9);

        jPanel7.add(jPanel8);

        jPanel12.setPreferredSize(new java.awt.Dimension(236, 115));
        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.LINE_AXIS));

        jPanel13.setPreferredSize(new java.awt.Dimension(150, 115));

        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.LINE_AXIS));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel39.setText("Giá vé:");
        jLabel39.setPreferredSize(new java.awt.Dimension(40, 16));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtGiaVe, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(txtGiaVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel12.add(jPanel13);

        jPanel7.add(jPanel12);

        jPanel14.setPreferredSize(new java.awt.Dimension(300, 115));

        jPanel15.setLayout(new java.awt.GridLayout(3, 1));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel41.setText("Tổng tiền:");
        jPanel15.add(jLabel41);

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel42.setText("Giá giảm:");
        jPanel15.add(jLabel42);

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel43.setText("Tiền thanh toán:");
        jPanel15.add(jLabel43);

        jPanel16.setLayout(new java.awt.BorderLayout());

        jPanel21.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThanhToan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHuy)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuy)
                    .addComponent(btnThanhToan))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jPanel21.add(jPanel10);

        jPanel16.add(jPanel21, java.awt.BorderLayout.CENTER);

        jPanel23.setLayout(new java.awt.GridLayout(3, 1, 0, 5));
        jPanel23.add(txtTongTien);
        jPanel23.add(txtGiaGiam);
        jPanel23.add(txtTienPhaiThanhToan);

        jPanel16.add(jPanel23, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 57, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel14);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdNguoiLonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNguoiLonActionPerformed
        // TODO add your handling code here:
        ManChieuBUS manChieuBUS = new ManChieuBUS(seatSelected);
        manChieuBUS.updateTicketPrice(giave, rdNguoiLon, rdSinhVien, rdTreEm, txtGiaVe, txtTongTien, txtGiaGiam, txtTienPhaiThanhToan);
    }//GEN-LAST:event_rdNguoiLonActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        handleCancel();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void rdSinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdSinhVienActionPerformed
        // TODO add your handling code here:
        ManChieuBUS manChieuBUS = new ManChieuBUS(seatSelected);
        manChieuBUS.updateTicketPrice(giave, rdNguoiLon, rdSinhVien, rdTreEm, txtGiaVe, txtTongTien, txtGiaGiam, txtTienPhaiThanhToan);
    }//GEN-LAST:event_rdSinhVienActionPerformed

    private void rdTreEmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdTreEmActionPerformed
        // TODO add your handling code here:
        ManChieuBUS manChieuBUS = new ManChieuBUS(seatSelected);
        manChieuBUS.updateTicketPrice(giave, rdNguoiLon, rdSinhVien, rdTreEm, txtGiaVe, txtTongTien, txtGiaGiam, txtTienPhaiThanhToan);
    }//GEN-LAST:event_rdTreEmActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        handlePayment();
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        LichChieu lc = new LichChieu();
        lc.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

   
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
            java.util.logging.Logger.getLogger(ManChieuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManChieuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManChieuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManChieuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        startGUI(args[0], args[1], args[2], args[3]);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GioChieu;
    private javax.swing.JLabel Rap;
    private javax.swing.JLabel TenPhim;
    private javax.swing.JLabel TenPhong;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel lblGioChieu;
    private javax.swing.JLabel lblTenPhim;
    private javax.swing.JLabel lblTenPhong;
    private javax.swing.JPanel panelGhe;
    private javax.swing.JRadioButton rdNguoiLon;
    private javax.swing.JRadioButton rdSinhVien;
    private javax.swing.JRadioButton rdTreEm;
    private javax.swing.JLabel tieudeTenRap;
    private javax.swing.JTextField txtGiaGiam;
    private javax.swing.JTextField txtGiaVe;
    private javax.swing.JTextField txtTienPhaiThanhToan;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
