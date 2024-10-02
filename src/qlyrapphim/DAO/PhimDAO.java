/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlyrapphim.DAO;
import java.sql.*;
import java.util.UUID;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import qlyrapphim.DAO.KetNoiCSDL;
import qlyrapphim.DTO.Phim;
/**
 *
 * @author ADMIN
 */
public class PhimDAO {
    public boolean loadTableData(JTable table) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
           String sql = "SELECT p.id, p.TenPhim, p.MoTa, p.ThoiLuong, p.NgayKhoiChieu, p.NgayKetThuc, p.SanXuat, p.DaoDien, p.NamSX, p.ApPhich, p.TenTheLoai \n" +
"             FROM Phim p";
//            stm = conn.prepareStatement("""
//                                        select p.id,p.TenPhim,p.MoTa,p.ThoiLuong,p.NgayKhoiChieu,p.NgayKetThuc,p.SanXuat,p.DaoDien,p.NamSX,p.ApPhich,tl.TenTheLoai
//                                        from Phim p , TheLoai tl , PhanLoaiPhim plp
//                                        where p.id = plp.idPhim and tl.id = plp.idTheLoai""");
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);


            while (rs.next()) {
                 Vector row = new Vector(); // Number of columns in the table
                    row.add(rs.getString("id"));
                    row.add(rs.getString("TenPhim"));
                    row.add(rs.getString("MoTa"));
                    row.add(rs.getString("ThoiLuong"));
                    row.add(rs.getDate("NgayKhoiChieu")); // Sử dụng rs.getDate() thay vì rs.getString()
                    row.add(rs.getDate("NgayKetThuc")); 
                    row.add(rs.getString("SanXuat"));
                    row.add(rs.getString("DaoDien"));
                    row.add(rs.getString("NamSX"));
                    row.add(rs.getBytes("ApPhich"));
                    row.add(rs.getString("TenTheLoai"));             
                    model.addRow(row);           
//                row[0] = rs.getString("id");
//                row[1] = rs.getString("TenPhim");
//                row[2] = rs.getString("MoTa");
//                row[3] = rs.getString("ThoiLuong");
//                row[4] = rs.getString("NgayKhoiChieu");
//                row[5] = rs.getString("NgayKetThuc");
//                row[6] = rs.getString("SanXuat");
//                row[7] = rs.getString("DaoDien");
//                row[8] = rs.getString("NamSX");
//                row[9] = rs.getString("ApPhich");
//                row[10] = rs.getString("TenTheLoai");               
//                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        return true;
    }
    
    
   public boolean isIdTaken(String id) {
    // Logic để kiểm tra xem ID đã tồn tại trong cơ sở dữ liệu chưa
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    try {
        conn = KetNoiCSDL.getConnection();
        ps = conn.prepareStatement("""
                                   select count(*)
                                   from Phim p 
                                   where p.id = ?""");
        ps.setString(1, id);
        rs = ps.executeQuery();
        
        if (rs.next()) {
            return rs.getInt(1) > 0; // Nếu giá trị đếm > 0, ID đã được sử dụng
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return false; // Giả sử ID chưa được sử dụng
}

    
    public boolean checkIdExists(String idNV) {
    Connection connection = KetNoiCSDL.getConnection();
    try {
        // Chuẩn bị truy vấn SQL
        String sql = "SELECT * FROM NhanVien WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, idNV);

        // Thực thi truy vấn
        ResultSet rs = ps.executeQuery();

        // Kiểm tra xem kết quả có tồn tại không
        return rs.next();
    } catch (SQLException e) {
        e.printStackTrace();
        return false; // Trả về false nếu có lỗi xảy ra
    }
}

    public void themPhim(Phim phim, JTable table) {
    Connection conn = null;
    PreparedStatement stmPhim = null;
    PreparedStatement stmDinhDangPhim = null;
    try {
        conn = KetNoiCSDL.getConnection();
        
        // Thêm dữ liệu vào bảng Phim
        String sqlPhim = "INSERT INTO Phim (id, TenPhim, MoTa, ThoiLuong, NgayKhoiChieu, NgayKetThuc, SanXuat, DaoDien, NamSX, ApPhich, TenTheLoai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        stmPhim = conn.prepareStatement(sqlPhim);
        stmPhim.setString(1, phim.getId());
        stmPhim.setString(2, phim.getTenPhim());
        stmPhim.setString(3, phim.getMoTa());
        stmPhim.setFloat(4, phim.getThoiLuong());
        stmPhim.setDate(5, new java.sql.Date(phim.getNgayKhoiChieu().getTime())); // Sử dụng java.sql.Date
        stmPhim.setDate(6, new java.sql.Date(phim.getNgayKetThuc().getTime()));
        stmPhim.setString(7, phim.getSanXuat());
        stmPhim.setString(8, phim.getDaoDien());
        stmPhim.setInt(9, phim.getNamSX());
        stmPhim.setBytes(10, phim.getApPhich());
        stmPhim.setString(11, phim.getTenTheLoai());
        stmPhim.executeUpdate();
        
        String idDinhDangPhim = UUID.randomUUID().toString();
        
        // Thêm dữ liệu vào bảng DinhDangPhim
        String sqlDinhDangPhim = "INSERT INTO DinhDangPhim (id, idPhim) VALUES (?, ?)";
          stmDinhDangPhim = conn.prepareStatement(sqlDinhDangPhim);
          stmDinhDangPhim.setString(1, idDinhDangPhim);
          stmDinhDangPhim.setString(2, phim.getId());
          stmDinhDangPhim.executeUpdate();
          
          
        
        loadTableData(table);
        
        JOptionPane.showMessageDialog(null, "Thêm phim thành công");
    } catch (SQLException ex) {
        Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (stmPhim != null) stmPhim.close();
            if (stmDinhDangPhim != null) stmDinhDangPhim.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

    public void suaPhim(Phim phim) {
        Connection conn = null;
    PreparedStatement stm = null;
    try {
        conn = KetNoiCSDL.getConnection();
        String sql = "UPDATE Phim SET TenPhim=?, MoTa=?, ThoiLuong=?, NgayKhoiChieu=?, NgayKetThuc=?, SanXuat=?, DaoDien=?, NamSX=?, ApPhich=?, TenTheLoai=? WHERE id=?";
        stm = conn.prepareStatement(sql);
        stm.setString(1, phim.getTenPhim());
        stm.setString(2, phim.getMoTa());
        stm.setFloat(3, phim.getThoiLuong());
        stm.setDate(4, new java.sql.Date(phim.getNgayKhoiChieu().getTime())); // Sử dụng java.sql.Date
        stm.setDate(5, new java.sql.Date(phim.getNgayKetThuc().getTime()));
        stm.setString(6, phim.getSanXuat());
        stm.setString(7, phim.getDaoDien());
        stm.setInt(8, phim.getNamSX());
        stm.setBytes(9, phim.getApPhich());
        stm.setString(10, phim.getTenTheLoai());
        stm.setString(11, phim.getId());
        int rowsAffected = stm.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Sửa phim thành công");
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy phim để sửa");
        }
    } catch (SQLException ex) {
        Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (stm != null) stm.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    } // Logic để cập nhật thông tin của một bộ phim trong cơ sở dữ liệu
    }

    public void xoaPhim(String id) {
        // Logic để xóa một bộ phim từ cơ sở dữ liệu
         Connection conn = null;
    PreparedStatement stmPhanLoaiPhim = null;
    PreparedStatement stmPhim = null;
    try {
        conn = KetNoiCSDL.getConnection();
        
        // Xóa các hàng trong bảng PhanLoaiPhim mà tham chiếu đến bộ phim cần xóa
        String sqlXoaPhanLoaiPhim = "DELETE FROM PhanLoaiPhim WHERE idPhim = ?";
        stmPhanLoaiPhim = conn.prepareStatement(sqlXoaPhanLoaiPhim);
        stmPhanLoaiPhim.setString(1, id);
        stmPhanLoaiPhim.executeUpdate();
        
        // Sau khi xóa các hàng trong bảng PhanLoaiPhim, bạn có thể tiến hành xóa bộ phim từ bảng Phim
        String sqlXoaPhim = "DELETE FROM Phim WHERE id = ?";
        stmPhim = conn.prepareStatement(sqlXoaPhim);
        stmPhim.setString(1, id);
        stmPhim.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Xóa phim thành công");
    } catch (SQLException ex) {
        Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Lỗi khi xóa phim: " + ex.getMessage());
    } finally {
        try {
            if (stmPhanLoaiPhim != null) stmPhanLoaiPhim.close();
            if (stmPhim != null) stmPhim.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
public boolean timPhim(JTable phim, String tenCanTim) {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
        conn = KetNoiCSDL.getConnection();
        String query = "SELECT * FROM Phim WHERE Phim.TenPhim LIKE ?";
        pstmt = conn.prepareStatement(query); 
        pstmt.setString(1, "%" + tenCanTim + "%");

        rs = pstmt.executeQuery();

        DefaultTableModel model = (DefaultTableModel) phim.getModel();
        model.setRowCount(0); // Xóa hết dữ liệu cũ

        if (!rs.next()) {
            // Không tìm thấy kết quả, hiển thị thông báo và trả về false
            JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả");
            return false;
        }

        do {
            Object[] row = new Object[11]; // Số cột phù hợp với số trường của Phim
            row[0] = rs.getString("id");
            row[1] = rs.getString("TenPhim");
            row[2] = rs.getString("MoTa");
            row[3] = rs.getFloat("ThoiLuong");
            row[4] = rs.getString("NgayKhoiChieu");
            row[5] = rs.getString("NgayKetThuc");
            row[6] = rs.getString("SanXuat");
            row[7] = rs.getString("DaoDien");
            row[8] = rs.getInt("NamSX");
            row[9] = rs.getBytes("ApPhich");
            row[10] = rs.getString("TenTheLoai");
            model.addRow(row);
        } while (rs.next());
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    } finally {
        KetNoiCSDL.Closeconnection(conn);
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return true;
}





}    
