package qlyrapphim.DAO;

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
import qlyrapphim.DTO.PhongChieu;
import qlyrapphim.DTO.Ticket;
import qlyrapphim.GUI.ManChieuGUI;

public class ManChieuDao {

    List<Ticket> seatSelected = null;

    public ManChieuDao(List<Ticket> seatSelected) {
        this.seatSelected = seatSelected;
    }
 
    public void updateTicketPrice(BigDecimal giaVe, JRadioButton rdNguoiLon, JRadioButton rdSinhVien, JRadioButton rdTreEm, JTextField txtGiaVe, JTextField txtTongTien, JTextField txtGiaGiam, JTextField txtTienPhaiThanhToan) {
        BigDecimal giamGia = BigDecimal.ZERO; // Khởi tạo giảm giá ban đầu là 0
        BigDecimal tongTien = BigDecimal.ZERO; // Khởi tạo tổng tiền ban đầu là 0
        BigDecimal tienThanhToan = BigDecimal.ZERO; // Khởi tạo tiền thanh toán ban đầu là 0
        BigDecimal giaVeGiamGia = BigDecimal.ZERO; // Khởi tạo giá vé sau khi giảm giá
        BigDecimal giamGiaKhuyenMai = BigDecimal.ZERO;

        // Kiểm tra xem RadioButton nào được chọn và cập nhật giảm giá
        if (rdNguoiLon.isSelected()) {
            // Không có giảm giá cho người lớn
            giaVeGiamGia = giaVe; // Giá vé giữ nguyên
        } else if (rdSinhVien.isSelected()) {
            // Giảm giá 20% cho sinh viên
            giamGia = giaVe.multiply(new BigDecimal("0.2"));
            giaVeGiamGia = giaVe.subtract(giamGia); // Giá vé sau khi giảm giá
        } else if (rdTreEm.isSelected()) {
            // Giảm giá 50% cho trẻ em
            giamGia = giaVe.multiply(new BigDecimal("0.5"));
            giaVeGiamGia = giaVe.subtract(giamGia); // Giá vé sau khi giảm giá
        }
        
        for(Ticket TK : seatSelected){
            TK.setPrice(giaVeGiamGia.floatValue());
        }

        // Tính tổng tiền dựa trên số lượng ghế đã chọn và giá vé
        tongTien = giaVeGiamGia.multiply(new BigDecimal(String.valueOf(seatSelected.size())));

        // Tính tiền thanh toán
        tienThanhToan = tongTien.subtract(giamGiaKhuyenMai); // Tiền thanh toán = Tổng tiền - Giảm giá KM

        // Hiển thị giá vé, tổng tiền, giảm giá và tiền thanh toán trên giao diện
        txtGiaVe.setText(giaVeGiamGia.toString());
        txtTongTien.setText(tongTien.toString());
        txtGiaGiam.setText(giamGiaKhuyenMai.toString());
        txtTienPhaiThanhToan.setText(tienThanhToan.toString());
    }


}

