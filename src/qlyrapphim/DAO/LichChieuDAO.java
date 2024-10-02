/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlyrapphim.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.lang.model.util.Types;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import qlyrapphim.DTO.LichChieuDTO;
/**
 *
 * @author ADMIN
 */
public class LichChieuDAO {
    
     public boolean loadTableData(JTable table) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("""
                                        select lc.id as idLichChieu, ddp.id as idDinhDang , pc.id as idPhong, lc.ThoiGianChieu as TgianChieu, lc.GiaVe as GiaVe, p.TenPhim , lmh.TenMH
                                        from Phim p , LoaiManHinh lmh, LichChieu lc , DinhDangPhim ddp, PhongChieu pc
                                        where p.id = ddp.idPhim and ddp.idLoaiManHinh = lmh.id and lc.idDinhDang = ddp.id and lc.idPhong= pc.id""");
            rs = stm.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = new Object[7]; // Số cột trong bảng
                row[0] = rs.getString("idLichChieu");
                row[1] = rs.getString("idDinhDang");
                row[2] = rs.getString("idPhong");
                row[3] = rs.getString("TgianChieu");
                row[4] = rs.getString("GiaVe");
                row[5] = rs.getString("TenPhim");
                row[6] = rs.getString("TenMH");
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LichChieuDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        return true;
    }
     
     public static int updateStatusShowTimes(String idLichChieu, int status) {
        Connection conn = null;
        PreparedStatement stm = null;
        int result = 0;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("UPDATE LichChieu SET TrangThai = ? WHERE id = ?");
            stm.setInt(1, status);
            stm.setString(2, idLichChieu);
            result = stm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        return result;
    }
     
     // Phương thức để lấy thông tin lịch chiếu từ ID lịch chiếu
    public LichChieuDTO getLichChieuById(String idLichChieu) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        LichChieuDTO lichChieu = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String query = "SELECT * FROM LichChieu WHERE id = ?";
            stm = conn.prepareStatement(query);
            stm.setString(1, idLichChieu);
            rs = stm.executeQuery();

            if (rs.next()) {
                // Lấy thông tin từ ResultSet và tạo đối tượng Lịch chiếu
                String id = rs.getString("id");
                String idDinhDang = rs.getString("idDinhDang");
                String idPhong = rs.getString("idPhong");
                Date tGianChieu = rs.getDate("ThoiGianChieu");
                String giaVe = rs.getString("GiaVe");
                
                lichChieu = new LichChieuDTO(id, idDinhDang, idPhong, tGianChieu, giaVe);
            }
        } catch (SQLException ex) {
            // Xử lý ngoại lệ khi truy vấn cơ sở dữ liệu
            ex.printStackTrace();
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        return lichChieu;
    }
    
    public static LichChieuDTO getLichChieuByIdPhong(String idPhong) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        LichChieuDTO lichChieu = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String query = "SELECT * FROM LichChieu WHERE idPhong = ?";
            stm = conn.prepareStatement(query);
            stm.setString(1, idPhong);
            rs = stm.executeQuery();

            if (rs.next()) {
                // Lấy thông tin từ ResultSet và tạo đối tượng Lịch chiếu
                String id = rs.getString("id");
                String idDinhDang = rs.getString("idDinhDang");
                Date tGianChieu = rs.getDate("ThoiGianChieu");
                String giaVe = rs.getString("GiaVe");

                lichChieu = new LichChieuDTO(id, idDinhDang, idPhong, tGianChieu, giaVe);
            }
        } catch (SQLException ex) {
            // Xử lý ngoại lệ khi truy vấn cơ sở dữ liệu
            ex.printStackTrace();
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        return lichChieu;
    }


    public boolean isIdTaken(String id) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("SELECT COUNT(*) AS count FROM LichChieu WHERE id = ?");
            stm.setString(1, id);
            rs = stm.executeQuery();
            rs.next();
            int count = rs.getInt("count");
            return count > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }
    }
    
     public boolean loadCxIdPhong(JComboBox comboBox) {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    try {
        con = KetNoiCSDL.getConnection();
        ps = con.prepareStatement("""
                                  select pc.id
                                  from PhongChieu pc 
                                  """);
        rs = ps.executeQuery();
        
        // Xóa tất cả các mục hiện có trong JComboBox
        comboBox.removeAllItems();
        
        while (rs.next()) {                
            String idPhong = rs.getString("id");
            comboBox.addItem(idPhong);
        }
        return true;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    } finally {
        KetNoiCSDL.Closeconnection(con);
    }
}
     
    public boolean loadCxIdDinhDang(JComboBox comboBox) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = KetNoiCSDL.getConnection();
            ps = con.prepareStatement("""
                                      select ddp.id
                                      from DinhDangPhim ddp
                                      """);
            rs = ps.executeQuery();

            // Xóa tất cả các mục hiện có trong JComboBox
            comboBox.removeAllItems();

            while (rs.next()) {                
                String idDinhDang = rs.getString("id");
                comboBox.addItem(idDinhDang);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(con);
        }
    }
     
    public boolean loadCxTenPhim(JComboBox comboBox) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = KetNoiCSDL.getConnection();
            ps = con.prepareStatement("""
                                      select p.TenPhim
                                      from Phim p
                                      """);
            rs = ps.executeQuery();

            // Xóa tất cả các mục hiện có trong JComboBox
            comboBox.removeAllItems();

            while (rs.next()) {                
                String tenPhim = rs.getString("TenPhim");
                comboBox.addItem(tenPhim);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(con);
        }
    }

    // Phương thức loadCboxTenMH để tải dữ liệu vào ComboBox cxTenMH
    public boolean loadCxTenMH(JComboBox comboBox) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = KetNoiCSDL.getConnection();
            ps = con.prepareStatement("""
                                      select lmh.TenMH
                                      FROM LoaiManHinh lmh
                                      """);
            rs = ps.executeQuery();
            comboBox.removeAllItems();

            while (rs.next()) {                
                String tenMH = rs.getString("TenMH");
                comboBox.addItem(tenMH);
            }
            return true;
        } catch (Exception e) {
                return false;
            } finally {
                KetNoiCSDL.Closeconnection(con);
            }
    }
    
    // Phương thức để tìm tên phim theo idDinhDang
    public String timTenPhimTheoIDDinhDang(String idDinhDang) {
    String tenPhim = null;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        con = KetNoiCSDL.getConnection();
        ps = con.prepareStatement("""
                                  SELECT p.TenPhim
                                  FROM DinhDangPhim ddp
                                  JOIN Phim p ON ddp.idPhim = p.id
                                  WHERE ddp.id = ?""");
        ps.setString(1, idDinhDang);
        rs = ps.executeQuery();
        
        if (rs.next()) {
            tenPhim = rs.getString("TenPhim");
        }
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        // Đóng connection, preparedStatement và resultSet ở đây
        // Đảm bảo bạn luôn đóng các tài nguyên này để tránh rò rỉ bộ nhớ và lỗi kết nối
        // Nếu không, sử dụng try-with-resources để tự động đóng chúng
        KetNoiCSDL.Closeconnection(con);
    }
    return tenPhim;
}

    
    public String timTenManHinhTheoIDDinhDang(String idDinhDang) {
    String tenMH = null;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        con = KetNoiCSDL.getConnection();
        ps = con.prepareStatement("""
                                  SELECT lmh.TenMH
                                  FROM DinhDangPhim ddp
                                  JOIN LoaiManHinh lmh ON ddp.idLoaiManHinh = lmh.id
                                  WHERE ddp.id = ?""");
        ps.setString(1, idDinhDang);
        rs = ps.executeQuery();
        
        if (rs.next()) {
            tenMH = rs.getString("TenMH");
        }
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        // Đóng connection, preparedStatement và resultSet ở đây
        KetNoiCSDL.Closeconnection(con);
    }
    return tenMH;
}


    public void themLichChieu(LichChieuDTO lichChieu) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String sql = "INSERT INTO LichChieu (id, idDinhDang, idPhong, ThoiGianChieu, GiaVe) VALUES (?, ?, ?, ?, ?)";
            stm = conn.prepareStatement(sql);
            stm.setString(1, lichChieu.getId());
            stm.setString(2, lichChieu.getIdDinhDang());
            stm.setString(3, lichChieu.getIdPhong());
            
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String strDate = sdf.format(lichChieu.getTGianChieu());
             
             stm.setString(4, strDate); // Sử dụng chuỗi thay vì đối tượng Date
            
            stm.setString(5, lichChieu.getGiaVe());
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm lịch chiếu thành công");
        } catch (SQLException ex) {
            Logger.getLogger(LichChieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(LichChieuDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void suaLichChieu(LichChieuDTO lichChieu) {
    Connection conn = null;
    PreparedStatement stm = null;
    try {
        conn = KetNoiCSDL.getConnection();
        String sql = "UPDATE LichChieu SET idDinhDang = ?, idPhong = ?, ThoiGianChieu = ?, GiaVe = ? WHERE id = ?";
        stm = conn.prepareStatement(sql);
        stm.setString(1, lichChieu.getIdDinhDang());
        stm.setString(2, lichChieu.getIdPhong());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sdf.format(lichChieu.getTGianChieu());

        stm.setString(3, strDate); // Sử dụng chuỗi thay vì đối tượng Date

        stm.setString(4, lichChieu.getGiaVe());
        stm.setString(5, lichChieu.getId());
        
        int rowsUpdated = stm.executeUpdate();
        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(null, "Sửa lịch chiếu thành công");
        } else {
            JOptionPane.showMessageDialog(null, "Không có lịch chiếu nào được sửa đổi");
        }
    } catch (SQLException ex) {
        Logger.getLogger(LichChieuDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (stm != null) stm.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(LichChieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
    public void xoaLichChieu(String id) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String sql = "DELETE FROM LichChieu WHERE id = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, id);
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa lịch chiếu thành công");
        } catch (SQLException ex) {
            Logger.getLogger(LichChieuDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Lỗi khi xóa lịch chiếu: " + ex.getMessage());
        } finally {
            try {
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(LichChieuDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean timLichChieu(JTable lichChieu, String tenCanTim) {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
        conn = KetNoiCSDL.getConnection();
        String query = """
                       SELECT lc.id AS idLichChieu, ddp.id AS idDinhDang, pc.id AS idPhong, lc.ThoiGianChieu AS TgianChieu, lc.GiaVe AS GiaVe, p.TenPhim, lmh.TenMH
                       FROM Phim p, LoaiManHinh lmh, LichChieu lc, DinhDangPhim ddp, PhongChieu pc
                       WHERE p.id = ddp.idPhim AND ddp.idLoaiManHinh = lmh.id AND lc.idDinhDang = ddp.id AND lc.idPhong = pc.id AND (p.TenPhim LIKE ? OR lc.ThoiGianChieu LIKE ?)""";
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, "%" + tenCanTim + "%");

        var sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date = null;
        try {
            date = sdf.parse(tenCanTim);
        } catch (ParseException e) {
            // Nếu không thể chuyển đổi thành ngày tháng, tiếp tục tìm kiếm bằng tên phim
        }

        if (date != null) {
            pstmt.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
        } else {
            pstmt.setString(2, "%" + tenCanTim + "%"); // Tiếp tục tìm kiếm bằng tên phim
        }

        rs = pstmt.executeQuery();

        DefaultTableModel model = (DefaultTableModel) lichChieu.getModel();
        model.setRowCount(0); // Xóa hết dữ liệu cũ
        
        if (!rs.next()) {
            // Không tìm thấy kết quả, hiển thị thông báo và trả về giao diện chính
            JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả");
            return false;
        }

        while (rs.next()) {
            Object[] row = new Object[7];
            row[0] = rs.getString("idLichChieu");
            row[1] = rs.getString("idDinhDang");
            row[2] = rs.getString("idPhong");
            row[3] = rs.getString("TgianChieu");
            row[4] = rs.getString("GiaVe");
            row[5] = rs.getString("TenPhim");
            row[6] = rs.getString("TenMH");
            model.addRow(row);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    } finally {
        KetNoiCSDL.Closeconnection(conn);
    }
    return true;
}



}
