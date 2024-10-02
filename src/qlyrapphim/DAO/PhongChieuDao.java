
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
import qlyrapphim.DTO.PhongChieu;

public class PhongChieuDao {
    
    public boolean loadTableData(JTable table) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("SELECT * FROM PhongChieu");
            rs = stm.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = new Object[7]; // Số cột trong bảng
                row[0] = rs.getString("id");
                row[1] = rs.getString("TenPhong");
                row[2] = rs.getString("idManHinh");
                row[3] = rs.getString("SoChoNgoi");
                row[4] = rs.getString("TinhTrang");
                row[5] = rs.getString("SoHangGhe");
                row[6] = rs.getString("SoGheMotHang");

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
    
    public boolean loadCboxidMH(JComboBox<String> comboBox){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        comboBox.removeAllItems();
        try {
            con = KetNoiCSDL.getConnection();
            ps = con.prepareStatement("""
                                      select lmh.id
                                      from LoaiManHinh lmh""");
            rs = ps.executeQuery();

            while (rs.next()) {
                String TenMH = rs.getString("id");
                comboBox.addItem(TenMH); 
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace(); // In ra stack trace để debug
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(con);
        }
    }

    
    public static PhongChieu getCinemaByid(String idPhong) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        PhongChieu cinema = null;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("SELECT * FROM PhongChieu WHERE id = ?");
            stm.setString(1, idPhong);
            rs = stm.executeQuery();
            if (rs.next()) {
                String maphong = rs.getString("id");
                String tenphong = rs.getString("TenPhong");
                String manhinh = rs.getString("idManHinh");
                int sochongoi = rs.getInt("SoChoNgoi");
                int tinhtrang = rs.getInt("TinhTrang");
                int sohangghe = rs.getInt("SoHangGhe");
                int soghemothang = rs.getInt("SoGheMotHang");
                cinema = new PhongChieu(maphong, tenphong, manhinh, sochongoi, tinhtrang, sohangghe, soghemothang);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        return cinema;
    }
    
   public boolean themPhongChieu(String id, String tenPhong, String idManHinh, int soChoNgoi, int tinhTrang, int soHangGhe, int soGheMotHang) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String sql = "INSERT INTO PhongChieu (id, TenPhong, idManHinh, SoChoNgoi, TinhTrang, SoHangGhe, SoGheMotHang) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stm = conn.prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, tenPhong);
            stm.setString(3, idManHinh);
            stm.setInt(4, soChoNgoi);
            stm.setInt(5, tinhTrang);
            stm.setInt(6, soHangGhe);
            stm.setInt(7, soGheMotHang);

            int rowsAffected = stm.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }


    public boolean suaPhongChieu(String id, String tenPhong, String idManHinh, int soChoNgoi, int tinhTrang, int soHangGhe, int soGheMotHang) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String sql = "UPDATE PhongChieu SET TenPhong = ?, idManHinh = ?, SoChoNgoi = ?, TinhTrang = ?, SoHangGhe = ?, SoGheMotHang = ? WHERE id = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, tenPhong);
            stm.setString(2, idManHinh);
            stm.setInt(3, soChoNgoi);
            stm.setInt(4, tinhTrang);
            stm.setInt(5, soHangGhe);
            stm.setInt(6, soGheMotHang);
            stm.setString(7, id);

            int rowsAffected = stm.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }

    public boolean xoaPhongChieu(String id) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String sql = "DELETE FROM PhongChieu WHERE id = ?";
            stm = conn.prepareStatement(sql);
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
    
    public boolean checkMaPhong(String maPhong) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("SELECT COUNT(*) FROM PhongChieu WHERE id = ?");
            stm.setString(1, maPhong);
            rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Trả về true nếu mã phòng đã tồn tại
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongChieuDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        return false; // Mã phòng không tồn tại hoặc có lỗi xảy ra
    }
    
    public boolean checkTenPhong(String tenphong){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = KetNoiCSDL.getConnection();
            ps = con.prepareStatement("SELECT COUNT(*) FROM PhongChieu WHERE TenPhong = ?");
            ps.setString(1, tenphong);
            rs = ps.executeQuery();

            if (rs.next()) {                
                int count = rs.getInt(1);
                return count > 0; // Trả về true nếu có ít nhất một bản ghi tồn tại
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có lỗi xảy ra
        } finally {
            KetNoiCSDL.Closeconnection(con);
        }
        return false;
    }


    
    
    
}
