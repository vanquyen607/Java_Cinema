
package qlyrapphim.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NhanVienDao {
    
    public boolean loadTableData(JTable table) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("SELECT * FROM NhanVien");
            rs = stm.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = new Object[6]; // Số cột trong bảng
                row[0] = rs.getString("id");
                row[1] = rs.getString("HoTen");
                row[2] = rs.getString("NgaySinh");
                row[3] = rs.getString("DiaChi");
                row[4] = rs.getString("SDT");
                row[5] = rs.getString("CMND");
                
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        return true;
    }
    
   public boolean insertNhanVien(String id, String hoTen, String ngaySinh, String diaChi, String sdt, String cmnd) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String query = "INSERT INTO NhanVien (id, HoTen, NgaySinh, DiaChi, SDT, CMND) VALUES (?, ?, ?, ?, ?, ?)";
            stm = conn.prepareStatement(query);
            stm.setString(1, id);
            stm.setString(2, hoTen);
            stm.setString(3, ngaySinh);
            stm.setString(4, diaChi);
            stm.setString(5, sdt);
            stm.setString(6, cmnd);
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }

   
   public boolean deleteNhanVien(String id) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String query = "DELETE FROM NhanVien WHERE id = ?";
            stm = conn.prepareStatement(query);
            stm.setString(1, id);
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }
   
   public boolean updateNhanVien(String id, String hoTen, String ngaySinh, String diaChi, String sdt, String cmnd) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String query = "UPDATE NhanVien SET HoTen = ?, NgaySinh = ?, DiaChi = ?, SDT = ?, CMND = ? WHERE id = ?";
            stm = conn.prepareStatement(query);
            stm.setString(1, hoTen);
            stm.setString(2, ngaySinh);
            stm.setString(3, diaChi);
            stm.setString(4, sdt);
            stm.setString(5, cmnd);
            stm.setString(6, id);
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }
   
   public boolean searchNhanVien(JTable table, String tenCanTim) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String query = "SELECT * FROM NhanVien WHERE HoTen LIKE ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + tenCanTim + "%");
            rs = pstmt.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Xóa hết dữ liệu cũ

            while (rs.next()) {
                Object[] row = new Object[6]; // Số cột trong bảng
                row[0] = rs.getString("id");
                row[1] = rs.getString("HoTen");
                row[2] = rs.getString("NgaySinh");
                row[3] = rs.getString("DiaChi");
                row[4] = rs.getString("SDT");
                row[5] = rs.getString("CMND");
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
   
   // Kiểm tra tính duy nhất của ID
    public boolean isIdUnique(String id) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String query = "SELECT COUNT(*) FROM NhanVien WHERE id = ?";
            stm = conn.prepareStatement(query);
            stm.setString(1, id);
            rs = stm.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            return count == 0; // Trả về true nếu không có bản ghi nào có cùng ID
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
            return false; // Trả về false nếu có lỗi xảy ra
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }
    
    // Kiểm tra tính duy nhất của SĐT
    public boolean isSdtUnique(String sdt) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String query = "SELECT COUNT(*) FROM NhanVien WHERE SDT = ?";
            stm = conn.prepareStatement(query);
            stm.setString(1, sdt);
            rs = stm.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            return count == 0; // Trả về true nếu không có bản ghi nào có cùng SĐT
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
            return false; // Trả về false nếu có lỗi xảy ra
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }
    
    // Kiểm tra tính duy nhất của CMND
    public boolean isCmndUnique(String cmnd) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String query = "SELECT COUNT(*) FROM NhanVien WHERE CMND = ?";
            stm = conn.prepareStatement(query);
            stm.setString(1, cmnd);
            rs = stm.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            return count == 0; // Trả về true nếu không có bản ghi nào có cùng CMND
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
            return false; // Trả về false nếu có lỗi xảy ra
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }



    
}
