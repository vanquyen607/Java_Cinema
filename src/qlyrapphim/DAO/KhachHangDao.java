package qlyrapphim.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.time.LocalDate;
public class KhachHangDao{

    public boolean loadTableData(JTable table) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("SELECT * FROM KhachHang");
            rs = stm.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = new Object[7]; // Số cột trong bảng
                row[0] = rs.getString("id");
                row[1] = rs.getString("HoTen");
                row[2] = rs.getString("NgaySinh");
                row[3] = rs.getString("DiaChi");
                row[4] = rs.getString("SDT");
                row[5] = rs.getString("CMND");
                row[6] = rs.getString("DiemTichLuy");
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        return true;
    }

    public boolean themKhachHang(String id,String hoTen, String ngaySinh, String diaChi, String sdt, String cmnd, int diemTichLuy) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("INSERT INTO KhachHang (id,HoTen, NgaySinh, DiaChi, SDT, CMND, DiemTichLuy) VALUES (?,?,?,?,?,?,?)");
            stm.setString(1, id);
            stm.setString(2, hoTen);
            stm.setDate(3,Date.valueOf(ngaySinh));
            stm.setString(4, diaChi);
            stm.setString(5, sdt);
            stm.setString(6, cmnd);
            stm.setInt(7, diemTichLuy);

            int rowsAffected = stm.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Thêm khách hàng thất bại!");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }
    
    public boolean isMaKHTaken(String maKH) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        conn = KetNoiCSDL.getConnection();
        String query = "SELECT COUNT(*) FROM KhachHang WHERE id = ?";
        ps = conn.prepareStatement(query);
        ps.setString(1, maKH);
        rs = ps.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0; // Trả về true nếu có ít nhất một bản ghi với maKH đã cho
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        KetNoiCSDL.Closeconnection(conn);
    }
    return false;
}

public boolean isSdtTaken(String sdt) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = KetNoiCSDL.getConnection();
        String query = "SELECT COUNT(*) FROM KhachHang WHERE Sdt = ?";
        ps = conn.prepareStatement(query);
        ps.setString(1, sdt);
        rs = ps.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        KetNoiCSDL.Closeconnection(conn);
    }
    return false;
}

public boolean isCmndTaken(String cmnd) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = KetNoiCSDL.getConnection();
        String query = "SELECT COUNT(*) FROM KhachHang WHERE CMND = ?";
        ps = conn.prepareStatement(query);
        ps.setString(1, cmnd);
        rs = ps.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        KetNoiCSDL.Closeconnection(conn);
    }
    return false;
}


    public boolean suaKhachHang(String id, String hoTen, String ngaySinh, String diaChi, String sdt, String cmnd, int diemTichLuy) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = KetNoiCSDL.getConnection();
                        
            stm = conn.prepareStatement("UPDATE KhachHang SET HoTen=?, NgaySinh=?, DiaChi=?, SDT=?, CMND=?, DiemTichLuy=? WHERE id=?");
            stm.setString(1, hoTen);
            stm.setDate(2,Date.valueOf(ngaySinh));
            stm.setString(3, diaChi);
            stm.setString(4, sdt);
            stm.setString(5, cmnd);
            stm.setInt(6, diemTichLuy);
            stm.setString(7, id);
            
            int rowsAffected = stm.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Sửa thông tin khách hàng thành công!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Sửa thông tin khách hàng thất bại!");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }

    public boolean xoaKhachHang(String id) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("DELETE FROM KhachHang WHERE id=?");
            stm.setString(1, id);

            int rowsAffected = stm.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Xóa khách hàng thành công!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Xóa khách hàng thất bại!");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }
    

    
    public boolean searchKhachHangByOption(JTable table, String searchText, String searchOption) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String query = "";
            if (searchOption.equals("Tên KH")) {
                query = "SELECT * FROM KhachHang WHERE HoTen LIKE ?";
            } else if (searchOption.equals("Mã KH")) {
                query = "SELECT * FROM KhachHang WHERE id LIKE ?";
            } else if (searchOption.equals("SĐT")) {
                query = "SELECT * FROM KhachHang WHERE SDT LIKE ?";
            } else if (searchOption.equals("CMND")) {
                query = "SELECT * FROM KhachHang WHERE CMND LIKE ?";
            } else {
                // Không có lựa chọn hợp lệ
                return false;
            }

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + searchText + "%");
            rs = pstmt.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Xóa hết dữ liệu cũ

            boolean foundData = false; // Biến để kiểm tra xem có dữ liệu được tìm thấy không

            while (rs.next()) {
                foundData = true; // Đã tìm thấy dữ liệu
                Object[] row = new Object[7];
                row[0] = rs.getString("id");
                row[1] = rs.getString("HoTen");
                row[2] = rs.getString("NgaySinh");
                row[3] = rs.getString("DiaChi");
                row[4] = rs.getString("SDT");
                row[5] = rs.getString("CMND");
                row[6] = rs.getString("DiemTichLuy");
                model.addRow(row);
            }

            if (!foundData) {
                // Hiển thị thông báo khi không tìm thấy dữ liệu
                JOptionPane.showMessageDialog(null, "Không tìm thấy dữ liệu phù hợp.");
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
