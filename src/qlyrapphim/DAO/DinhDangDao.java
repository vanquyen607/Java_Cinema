
package qlyrapphim.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DinhDangDao {
    
   public boolean loadTableData(JTable table) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("""
                                        select ddp.id, ddp.idPhim ,p.TenPhim,ddp.idLoaiManHinh,lmh.TenMH
                                        from Phim p, LoaiManHinh lmh , DinhDangPhim ddp
                                        where p.id = ddp.idPhim and lmh.id = ddp.idLoaiManHinh""");
            rs = stm.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = new Object[5]; // Số cột trong bảng
                row[0] = rs.getString("id");
                row[1] = rs.getString("idPhim");
                row[2] = rs.getString("TenPhim");
                row[3] = rs.getString("idLoaiManHinh");
                row[4] = rs.getString("TenMH");
                
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DinhDangDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        return true;
    }
   
   public boolean loadcboxMaPhim (JComboBox comboBox){
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = KetNoiCSDL.getConnection();
            stm = con.prepareStatement("""
                                       select Phim.id
                                       from Phim""");
            rs = stm.executeQuery();
            comboBox.removeAllItems();
            comboBox.addItem(null);

            while(rs.next()){
                String idphim = rs.getString("id");
                comboBox.addItem(idphim);
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace(); // In ra thông tin lỗi để dễ dàng gỡ lỗi
            return false;
        }finally{
            KetNoiCSDL.Closeconnection(con);
        }
    }

    public boolean loadcboxMaMH (JComboBox comboBox){
       Connection con = null;
       PreparedStatement stm = null;
       ResultSet rs = null;

       try {
           con = KetNoiCSDL.getConnection();
           stm = con.prepareStatement("""
                                      select lmh.id 
                                      from LoaiManHinh lmh""");
           rs = stm.executeQuery();
           comboBox.removeAllItems();
           comboBox.addItem(null);

           while(rs.next()){
               String idMH = rs.getString("id");
               comboBox.addItem(idMH);
           }
           return true;

       } catch (Exception e) {
           e.printStackTrace(); // In ra thông tin lỗi để dễ dàng gỡ lỗi
           return false;
       }finally{
           KetNoiCSDL.Closeconnection(con);
       }
    }
    
    public boolean kiemTraMaDinhDangTonTai(String maDinhDang) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = KetNoiCSDL.getConnection();
            String query = "SELECT COUNT(*) AS count FROM DinhDangPhim WHERE id = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, maDinhDang);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                // Nếu số lượng bản ghi trả về lớn hơn 0, tức là mã định dạng đã tồn tại
                return count > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Đóng kết nối và giải phóng tài nguyên
            KetNoiCSDL.Closeconnection(conn);
        }
        return false; // Trả về false nếu có lỗi xảy ra hoặc không có kết quả trả về
    }
    
    public boolean choiceinCboxMaPhim(JTextField textField, String idPhim){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = KetNoiCSDL.getConnection();
            ps = con.prepareStatement("""
                                      select Phim.TenPhim
                                      from Phim
                                      where Phim.id=? """);
            ps.setString(1, idPhim);
            rs=ps.executeQuery();

            while (rs.next()) {                
                String tenphim =rs.getString("TenPhim");
                textField.setText(tenphim);
            }
            return true;
        } catch (Exception e) {
            return false;
        } finally {
        }
    }
    
    public boolean choiceinCboxMaMH(JTextField textField, String idMH){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = KetNoiCSDL.getConnection();
            ps = con.prepareStatement("""
                                      select mh.TenMH
                                      from LoaiManHinh mh
                                      where mh.id = ? """);
            ps.setString(1, idMH);
            rs=ps.executeQuery();

            while (rs.next()) {                
                String tenMH =rs.getString("TenMH");
                textField.setText(tenMH);
            }
            return true;
        } catch (Exception e) {
            return false;
        } finally {
        }
    }
    
   public boolean loadDataToTable(String selectedPhimId, String selectedMHId, JTable table) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("""
                                        SELECT ddp.id, ddp.idPhim, p.TenPhim, ddp.idLoaiManHinh, lmh.TenMH
                                        FROM Phim p, LoaiManHinh lmh, DinhDangPhim ddp
                                        WHERE p.id = ddp.idPhim AND lmh.id = ddp.idLoaiManHinh 
                                        AND ddp.idPhim = ? AND ddp.idLoaiManHinh = ?
                                        """);
            stm.setString(1, selectedPhimId);
            stm.setString(2, selectedMHId);
            rs = stm.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = new Object[5]; // Số cột trong bảng
                row[0] = rs.getString("id");
                row[1] = rs.getString("idPhim");
                row[2] = rs.getString("TenPhim");
                row[3] = rs.getString("idLoaiManHinh");
                row[4] = rs.getString("TenMH");

                model.addRow(row);
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DinhDangDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        return false;
    }
   
   public boolean themDuLieu(String idDinhDang, String idPhim, String tenPhim, String idLoaiManHinh, String tenMH) {
        Connection conn = null;
        PreparedStatement stmDinhDangPhim = null;
        PreparedStatement stmPhim = null;
        PreparedStatement stmLoaiManHinh = null;
        boolean success = false;

        try {
            conn = KetNoiCSDL.getConnection();
            conn.setAutoCommit(false); // Bắt đầu một giao dịch

            // Thêm dữ liệu vào bảng DinhDangPhim
            String sqlDinhDangPhim = "INSERT INTO DinhDangPhim (id, idPhim, idLoaiManHinh) VALUES (?, ?, ?)";
            stmDinhDangPhim = conn.prepareStatement(sqlDinhDangPhim);
            stmDinhDangPhim.setString(1, idDinhDang);
            stmDinhDangPhim.setString(2, idPhim);
            stmDinhDangPhim.setString(3, idLoaiManHinh);
            stmDinhDangPhim.executeUpdate();

//            // Thêm dữ liệu vào bảng Phim
//            String sqlPhim = "INSERT INTO Phim ( TenPhim) VALUES ( ?)";
//            stmPhim = conn.prepareStatement(sqlPhim);
////            stmPhim.setString(1, idPhim);
//            stmPhim.setString(1, tenPhim);
//            stmPhim.executeUpdate();
//
//            // Thêm dữ liệu vào bảng LoaiManHinh
//            String sqlLoaiManHinh = "INSERT INTO LoaiManHinh ( TenMH) VALUES ( ?)";
//            stmLoaiManHinh = conn.prepareStatement(sqlLoaiManHinh);
////            stmLoaiManHinh.setString(1, idLoaiManHinh);
//            stmLoaiManHinh.setString(1, tenMH);
//            stmLoaiManHinh.executeUpdate();

            // Nếu không có lỗi, commit giao dịch
            conn.commit();
            success = true;
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDao.class.getName()).log(Level.SEVERE, "Lỗi khi thêm dữ liệu", ex);
            // Nếu có lỗi, rollback giao dịch
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException exRollback) {
                Logger.getLogger(DinhDangDao.class.getName()).log(Level.SEVERE, "Lỗi khi rollback giao dịch", exRollback);
            }
        } finally {
            try {
                if (stmDinhDangPhim != null) stmDinhDangPhim.close();
                if (stmPhim != null) stmPhim.close();
                if (stmLoaiManHinh != null) stmLoaiManHinh.close();
                if (conn != null) {
                    conn.setAutoCommit(true); // Trả lại chế độ tự động commit mặc định
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DinhDangDao.class.getName()).log(Level.SEVERE, "Lỗi khi đóng các tài nguyên", ex);
            }
        }
        return success;
    }
   
   public boolean suaDuLieu(String idDinhDang, String idPhim, String tenPhim, String idLoaiManHinh, String tenMH) {
        Connection conn = null;
        PreparedStatement stmDinhDangPhim = null;
        PreparedStatement stmPhim = null;
        PreparedStatement stmLoaiManHinh = null;
        boolean success = false;

        try {
            conn = KetNoiCSDL.getConnection();
            conn.setAutoCommit(false); // Bắt đầu một giao dịch

            // Sửa dữ liệu trong bảng DinhDangPhim
            String sqlDinhDangPhim = "UPDATE DinhDangPhim SET idPhim = ?, idLoaiManHinh = ? WHERE id = ?";
            stmDinhDangPhim = conn.prepareStatement(sqlDinhDangPhim);
            stmDinhDangPhim.setString(1, idPhim);
            stmDinhDangPhim.setString(2, idLoaiManHinh);
            stmDinhDangPhim.setString(3, idDinhDang);
            stmDinhDangPhim.executeUpdate();

//            // Sửa dữ liệu trong bảng Phim
//            String sqlPhim = "UPDATE Phim SET TenPhim = ? WHERE id = ?";
//            stmPhim = conn.prepareStatement(sqlPhim);
//            stmPhim.setString(1, tenPhim);
//            stmPhim.setString(2, idPhim);
//            stmPhim.executeUpdate();
//
//            // Sửa dữ liệu trong bảng LoaiManHinh
//            String sqlLoaiManHinh = "UPDATE LoaiManHinh SET TenMH = ? WHERE id = ?";
//            stmLoaiManHinh = conn.prepareStatement(sqlLoaiManHinh);
//            stmLoaiManHinh.setString(1, tenMH);
//            stmLoaiManHinh.setString(2, idLoaiManHinh);
//            stmLoaiManHinh.executeUpdate();

            // Nếu không có lỗi, commit giao dịch
            conn.commit();
            success = true;
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDao.class.getName()).log(Level.SEVERE, "Lỗi khi sửa dữ liệu", ex);
            // Nếu có lỗi, rollback giao dịch
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException exRollback) {
                Logger.getLogger(DinhDangDao.class.getName()).log(Level.SEVERE, "Lỗi khi rollback giao dịch", exRollback);
            }
        } finally {
            try {
                if (stmDinhDangPhim != null) stmDinhDangPhim.close();
                if (stmPhim != null) stmPhim.close();
                if (stmLoaiManHinh != null) stmLoaiManHinh.close();
                if (conn != null) {
                    conn.setAutoCommit(true); // Trả lại chế độ tự động commit mặc định
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DinhDangDao.class.getName()).log(Level.SEVERE, "Lỗi khi đóng các tài nguyên", ex);
            }
        }
        return success;
    }

   public boolean xoaDuLieu(String idDinhDang, String idPhim, String idLoaiManHinh) {
        Connection conn = null;
        PreparedStatement stmDinhDangPhim = null;
        PreparedStatement stmPhim = null;
        PreparedStatement stmLoaiManHinh = null;
        boolean success = false;

        try {
            conn = KetNoiCSDL.getConnection();
            conn.setAutoCommit(false); // Bắt đầu một giao dịch

            // Xóa dữ liệu từ bảng DinhDangPhim
            String sqlDinhDangPhim = "DELETE FROM DinhDangPhim WHERE id = ?";
            stmDinhDangPhim = conn.prepareStatement(sqlDinhDangPhim);
            stmDinhDangPhim.setString(1, idDinhDang);
            stmDinhDangPhim.executeUpdate();

//            // Xóa dữ liệu từ bảng Phim
//            String sqlPhim = "DELETE FROM Phim WHERE id = ?";
//            stmPhim = conn.prepareStatement(sqlPhim);
//            stmPhim.setString(1, idPhim);
//            stmPhim.executeUpdate();
//
//            // Xóa dữ liệu từ bảng LoaiManHinh
//            String sqlLoaiManHinh = "DELETE FROM LoaiManHinh WHERE id = ?";
//            stmLoaiManHinh = conn.prepareStatement(sqlLoaiManHinh);
//            stmLoaiManHinh.setString(1, idLoaiManHinh);
//            stmLoaiManHinh.executeUpdate();

            // Nếu không có lỗi, commit giao dịch
            conn.commit();
            success = true;
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDao.class.getName()).log(Level.SEVERE, "Lỗi khi xóa dữ liệu", ex);
            // Nếu có lỗi, rollback giao dịch
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException exRollback) {
                Logger.getLogger(DinhDangDao.class.getName()).log(Level.SEVERE, "Lỗi khi rollback giao dịch", exRollback);
            }
        } finally {
            try {
                if (stmDinhDangPhim != null) stmDinhDangPhim.close();
                if (stmPhim != null) stmPhim.close();
                if (stmLoaiManHinh != null) stmLoaiManHinh.close();
                if (conn != null) {
                    conn.setAutoCommit(true); // Trả lại chế độ tự động commit mặc định
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DinhDangDao.class.getName()).log(Level.SEVERE, "Lỗi khi đóng các tài nguyên", ex);
            }
        }
        return success;
    }




}
