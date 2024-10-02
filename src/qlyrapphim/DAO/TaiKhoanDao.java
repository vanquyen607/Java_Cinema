
package qlyrapphim.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TaiKhoanDao {
    
    
    public boolean loadTableData(JTable table) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("""
                                        select tk.UserName,tk.LoaiTK,nv.id,nv.HoTen
                                        from NhanVien as nv,TaiKhoan as tk
                                        where nv.id=tk.idNV""");
            rs = stm.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = new Object[4]; // Số cột trong bảng
                row[0] = rs.getString("UserName");
                row[1] = rs.getString("LoaiTK");
                row[2] = rs.getString("id");
                row[3] = rs.getString("HoTen");
                
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        return true;
    }
    
    public boolean loadCboxMaNV(JComboBox comboBox){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = KetNoiCSDL.getConnection();
            ps = con.prepareStatement("""
                                      select NhanVien.id
                                      from NhanVien""");
            rs=ps.executeQuery();
            // Xóa tất cả các mục hiện có trong JComboBox
             comboBox.removeAllItems();
            
            while (rs.next()) {                
                String manv = rs.getString("id");
                comboBox.addItem(manv);
            }
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(con);
        }
        
    }
    
    public boolean themDuLieu(String userName, String loaiTK, String id, String hoTen) {
        Connection conn = null;
        PreparedStatement stmNhanVien = null;
        PreparedStatement stmTaiKhoan = null;
        try {
            conn = KetNoiCSDL.getConnection();
//            // Thêm dữ liệu vào bảng NhanVien
//            String sqlNhanVien = "INSERT INTO NhanVien (id, HoTen) VALUES (?, ?)";
//            stmNhanVien = conn.prepareStatement(sqlNhanVien);
//            stmNhanVien.setString(1, id);
//            stmNhanVien.setString(2, hoTen);
//            stmNhanVien.executeUpdate();

            // Thêm dữ liệu vào bảng TaiKhoan
            String sqlTaiKhoan = "INSERT INTO TaiKhoan (UserName, LoaiTK, idNV) VALUES (?, ?, ?)";
            stmTaiKhoan = conn.prepareStatement(sqlTaiKhoan);
            stmTaiKhoan.setString(1, userName);
            stmTaiKhoan.setString(2, loaiTK);
            stmTaiKhoan.setString(3, id);
            stmTaiKhoan.executeUpdate();

            // Nếu thêm thành công vào cả hai bảng, trả về true
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDao.class.getName()).log(Level.SEVERE, "Lỗi khi thêm dữ liệu", ex);
        } finally {
            try {
                if (stmNhanVien != null) stmNhanVien.close();
                if (stmTaiKhoan != null) stmTaiKhoan.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TaiKhoanDao.class.getName()).log(Level.SEVERE, "Lỗi khi đóng các tài nguyên", ex);
            }
        }
        // Trả về false nếu có lỗi xảy ra hoặc không thể thêm vào cả hai bảng
        return false;
}


    public boolean suaDuLieu(String userName, String loaiTK, String id, String hoTen) {
        Connection conn = null;
        PreparedStatement stmNhanVien = null;
        PreparedStatement stmTaiKhoan = null;
        try {
            conn = KetNoiCSDL.getConnection();
//            // Sửa dữ liệu trong bảng NhanVien
//            String sqlNhanVien = "UPDATE NhanVien SET HoTen = ? WHERE id = ?";
//            stmNhanVien = conn.prepareStatement(sqlNhanVien);
//            stmNhanVien.setString(1, hoTen);
//            stmNhanVien.setString(2, id);
//            stmNhanVien.executeUpdate();

            // Sửa dữ liệu trong bảng TaiKhoan
            String sqlTaiKhoan = "UPDATE TaiKhoan SET UserName = ?, LoaiTK = ? WHERE idNV = ?";
            stmTaiKhoan = conn.prepareStatement(sqlTaiKhoan);
            stmTaiKhoan.setString(1, userName);
            stmTaiKhoan.setString(2, loaiTK);
            stmTaiKhoan.setString(3, id);
            stmTaiKhoan.executeUpdate();

            // Nếu sửa thành công trong cả hai bảng, trả về true
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDao.class.getName()).log(Level.SEVERE, "Lỗi khi sửa dữ liệu", ex);
        } finally {
            try {
                if (stmNhanVien != null) stmNhanVien.close();
                if (stmTaiKhoan != null) stmTaiKhoan.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TaiKhoanDao.class.getName()).log(Level.SEVERE, "Lỗi khi đóng các tài nguyên", ex);
            }
        }
        // Trả về false nếu có lỗi xảy ra hoặc không thể sửa trong cả hai bảng
        return false;
    }


    public boolean xoaDuLieu(String id) {
        Connection conn = null;
        PreparedStatement stmNhanVien = null;
        PreparedStatement stmTaiKhoan = null;
        try {
            conn = KetNoiCSDL.getConnection();
            // Xóa dữ liệu trong bảng TaiKhoan
            String sqlTaiKhoan = "DELETE FROM TaiKhoan WHERE idNV = ?";
            stmTaiKhoan = conn.prepareStatement(sqlTaiKhoan);
            stmTaiKhoan.setString(1, id);
            stmTaiKhoan.executeUpdate();

//            // Xóa dữ liệu trong bảng NhanVien
//            String sqlNhanVien = "DELETE FROM NhanVien WHERE id = ?";
//            stmNhanVien = conn.prepareStatement(sqlNhanVien);
//            stmNhanVien.setString(1, id);
//            stmNhanVien.executeUpdate();

            // Nếu xóa thành công trong cả hai bảng, trả về true
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDao.class.getName()).log(Level.SEVERE, "Lỗi khi xóa dữ liệu", ex);
        } finally {
            try {
                if (stmTaiKhoan != null) stmTaiKhoan.close();
                if (stmNhanVien != null) stmNhanVien.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TaiKhoanDao.class.getName()).log(Level.SEVERE, "Lỗi khi đóng các tài nguyên", ex);
            }
        }
        // Trả về false nếu có lỗi xảy ra hoặc không thể xóa trong cả hai bảng
        return false;
    }
    
    public boolean searchTaiKhoan(JTable table, String tenCanTim) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String query = "SELECT tk.UserName, tk.LoaiTK, nv.id, nv.HoTen " +
                           "FROM NhanVien AS nv, TaiKhoan AS tk " +
                           "WHERE nv.id = tk.idNV AND nv.HoTen LIKE ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + tenCanTim + "%");
            rs = pstmt.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Xóa hết dữ liệu cũ

            while (rs.next()) {
                Object[] row = new Object[4];
                row[0] = rs.getString("UserName");
                row[1] = rs.getString("LoaiTK");
                row[2] = rs.getString("id");
                row[3] = rs.getString("HoTen");
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
    
    public String getTenNhanVien(String maNV) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String tenNV = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String query = "SELECT HoTen FROM NhanVien WHERE id = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, maNV);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                tenNV = rs.getString("HoTen");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        return tenNV;
    }

    
    public boolean daTonTaiTenDangNhap(String username) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String sql = "SELECT * FROM TaiKhoan WHERE UserName = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            rs = stm.executeQuery();
            return rs.next(); // Trả về true nếu có bản ghi tồn tại, ngược lại trả về false
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDao.class.getName()).log(Level.SEVERE, "Lỗi khi kiểm tra tên đăng nhập", ex);
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TaiKhoanDao.class.getName()).log(Level.SEVERE, "Lỗi khi đóng các tài nguyên", ex);
            }
        }
    }

    public boolean daTonTaiMaNhanVien(String maNV) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String sql = "SELECT * FROM NhanVien WHERE id = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, maNV);
            rs = stm.executeQuery();
            return rs.next(); // Trả về true nếu có bản ghi tồn tại, ngược lại trả về false
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDao.class.getName()).log(Level.SEVERE, "Lỗi khi kiểm tra mã nhân viên", ex);
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TaiKhoanDao.class.getName()).log(Level.SEVERE, "Lỗi khi đóng các tài nguyên", ex);
            }
        }
    }
    
    // Phương thức cài đặt mật khẩu cho tài khoản
    public boolean setMatKhau(String username, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = KetNoiCSDL.getConnection();
            String query = "UPDATE TaiKhoan SET Pass = ? WHERE Username = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, password);
            ps.setString(2, username);
            int result = ps.executeUpdate();
            
            // Kiểm tra xem có bản ghi nào được cập nhật không
            if (result > 0) {
                return true; // Cập nhật mật khẩu thành công
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            KetNoiCSDL.Closeconnection(con);
        }
        
        return false; // Cập nhật mật khẩu thất bại
    }



    
}
