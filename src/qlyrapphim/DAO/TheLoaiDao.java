
package qlyrapphim.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TheLoaiDao {
    
    public boolean loadTableData(JTable table) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("SELECT * FROM TheLoai");
            rs = stm.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = new Object[3]; // Số cột trong bảng
                row[0] = rs.getString("id");
                row[1] = rs.getString("TenTheLoai");
                row[2] = rs.getString("MoTa");
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        return true;
    }
    
    public boolean insertTheLoai(String id, String tenTheLoai, String moTa) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("INSERT INTO TheLoai (id, TenTheLoai, MoTa) VALUES (?, ?, ?)");
            stm.setString(1, id);
            stm.setString(2, tenTheLoai);
            stm.setString(3, moTa);
            int rowsAffected = stm.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }

    public boolean updateTheLoai(String id, String tenTheLoai, String moTa) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("UPDATE TheLoai SET TenTheLoai=?, MoTa=? WHERE id=?");
            stm.setString(1, tenTheLoai);
            stm.setString(2, moTa);
            stm.setString(3, id);
            int rowsAffected = stm.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }

    public boolean deleteTheLoai(String id) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("DELETE FROM TheLoai WHERE id=?");
            stm.setString(1, id);
            int rowsAffected = stm.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }
    
    public boolean checkMaTheLoai(String maTheLoai) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String query = "SELECT COUNT(*) FROM TheLoai WHERE id=?";
            stm = conn.prepareStatement(query);
            stm.setString(1, maTheLoai);
            rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Trả về true nếu count > 0, tức là mã thể loại đã tồn tại
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Đóng kết nối và các tài nguyên
            KetNoiCSDL.Closeconnection(conn);
        }
        return false; // Trả về false mặc định nếu có lỗi xảy ra
    }
    



}
