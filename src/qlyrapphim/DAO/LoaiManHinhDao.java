
package qlyrapphim.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LoaiManHinhDao {
    
    public boolean loadTableData(JTable table) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("SELECT * FROM LoaiManHinh");
            rs = stm.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = new Object[2]; // Số cột trong bảng
                row[0] = rs.getString("id");
                row[1] = rs.getString("TenMH");
                
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoaiManHinhDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        return true;
    }
    
    public boolean insertLoaiManHinh(String id, String tenMH) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String query = "INSERT INTO LoaiManHinh (id, TenMH) VALUES (?, ?)";
            stm = conn.prepareStatement(query);
            stm.setString(1, id);
            stm.setString(2, tenMH);
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LoaiManHinhDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }
    
    public boolean deleteLoaiManHinh(String id) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String query = "DELETE FROM LoaiManHinh WHERE id = ?";
            stm = conn.prepareStatement(query);
            stm.setString(1, id);
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LoaiManHinhDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }

    public boolean updateLoaiManHinh(String id, String tenMH) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String query = "UPDATE LoaiManHinh SET TenMH = ? WHERE id = ?";
            stm = conn.prepareStatement(query);
            stm.setString(1, tenMH);
            stm.setString(2, id);
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LoaiManHinhDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }
    
    public boolean isMaMHExists(String maMH) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            conn = KetNoiCSDL.getConnection();
            String query = "SELECT COUNT(*) FROM LoaiManHinh WHERE MaMH = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, maMH);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                result = count > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoaiManHinhDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        return result;
    }

}
