
package qlyrapphim.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import qlyrapphim.DTO.LichChieuDTO;
import qlyrapphim.DTO.PhongChieu;
import qlyrapphim.DTO.Ticket;

public class TicketDAO {
    
    public boolean loadTableData(JTable table) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("""
                                        SELECT pc.TenPhong, p.TenPhim, lc.ThoiGianChieu, CASE WHEN lc.TrangThai = 1 THEN 'Created' ELSE 'Not created' END AS TrangThai, lc.id as IdLChieu
                                                                                FROM PhongChieu pc, Phim p, LichChieu lc, DinhDangPhim ddp
                                                                                WHERE pc.id = lc.idPhong AND p.id = ddp.idPhim AND lc.idDinhDang = ddp.id;""");
            rs = stm.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = new Object[5]; // Số cột trong bảng
                row[0] = rs.getString("TenPhong");
                row[1] = rs.getString("TenPhim");
                row[2] = rs.getString("ThoiGianChieu");
                row[3] = rs.getString("TrangThai");
                row[4] = rs.getString("IdLChieu");
                
                model.addRow(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        return true;
    }
    
    public boolean loadTableDataNotCreate(JTable table) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("""
                                        SELECT pc.TenPhong, p.TenPhim, lc.ThoiGianChieu, 'Not created' AS TrangThai, lc.id AS IdLChieu
                                        FROM PhongChieu pc, Phim p, LichChieu lc, DinhDangPhim ddp
                                        WHERE pc.id = lc.idPhong AND p.id = ddp.idPhim AND lc.idDinhDang = ddp.id AND lc.TrangThai = 0;""");
            rs = stm.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = new Object[5]; // Số cột trong bảng
                row[0] = rs.getString("TenPhong");
                row[1] = rs.getString("TenPhim");
                row[2] = rs.getString("ThoiGianChieu");
                row[3] = rs.getString("TrangThai");
                row[4] = rs.getString("IdLChieu");
                
                model.addRow(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        return true;
    }
    
    public static List<Ticket> getListTicketsByShowTimes(String showTimesID) {
        List<Ticket> listTicket = new ArrayList<>();
        String query = "select * from Ve where idLichChieu = ?";
        try (Connection conn = KetNoiCSDL.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, showTimesID);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Ticket ticket = new Ticket(rs);
                    listTicket.add(ticket);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listTicket;
    }

    public static List<Ticket> getListTicketsBoughtByShowTimes(String showTimesID) {
        List<Ticket> listTicket = new ArrayList<>();
        String query = "select * from Ve where idLichChieu = ? and TrangThai = 1";
        try (Connection conn = KetNoiCSDL.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, showTimesID);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Ticket ticket = new Ticket(rs);
                    listTicket.add(ticket);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listTicket;
    }

    public static int countTotalTicketByShowTime(String showTimesID) {
        String query = "Select count (id) from Ve where idLichChieu = ?";
        try (Connection conn = KetNoiCSDL.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, showTimesID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static int countTheNumberOfTicketsSoldByShowTime(String showTimesID) {
        String query = "Select count (id) from Ve where idLichChieu = ? and TrangThai = 1";
        try (Connection conn = KetNoiCSDL.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, showTimesID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static int buyTicket(String ticketID, int type, float price) {
        String query = "Update dbo.Ve set TrangThai = 1, LoaiVe = ?, TienBanVe = ? where id = ?";
        try (Connection conn = KetNoiCSDL.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, type);
            pstmt.setFloat(2, price);
            pstmt.setString(3, ticketID);
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    public static int buyTicket(String ticketID, float price) {
        String query = "UPDATE dbo.Ve SET TrangThai = 1, TienBanVe = ? WHERE id = ?";
        try (Connection conn = KetNoiCSDL.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setFloat(1, price);
            pstmt.setString(2, ticketID);
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }


    public static int buyTicket(String ticketID, int type, String customerID, float price) {
        String query = "Update dbo.Ve set TrangThai = 1, LoaiVe = ?, idKhachHang = ?, TienBanVe = ? where id = ?";
        try (Connection conn = KetNoiCSDL.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, type);
            pstmt.setString(2, customerID);
            pstmt.setFloat(3, price);
            pstmt.setString(4, ticketID);
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static int insertTicketByShowTimes(String showTimesID, String seatName) {
        String query = "USP_InsertTicketByShowTimes ?, ?";
        try (Connection conn = KetNoiCSDL.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, showTimesID);
            pstmt.setString(2, seatName);
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static int deleteTicketsByShowTimesAction(String showTimesID) {
        String query = "USP_DeleteTicketsByShowTimes ?";
        try (Connection conn = KetNoiCSDL.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, showTimesID);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                // Thông báo nếu xóa thành công
                JOptionPane.showMessageDialog(null, "Xóa vé thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Thông báo nếu không có bản ghi nào được xóa
                JOptionPane.showMessageDialog(null, "Không có vé nào được xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
            return rowsAffected;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    public boolean deleteTicketsByShowTimes(String showTimesID) {
        int rowsAffected = TicketDAO.deleteTicketsByShowTimesAction(showTimesID);
        if (rowsAffected > 0) {
            int ret = LichChieuDAO.updateStatusShowTimes(showTimesID, 0); // Cập nhật trạng thái về 0 sau khi xóa vé
            if (ret > 0) {
                return true;
            }
        }
        return false;
    }

    
    public boolean autoCreateTicketsByShowTimes(LichChieuDTO showTimes) {
        int result = 0;
        PhongChieu cinema = PhongChieuDao.getCinemaByid(showTimes.getIdPhong());
        int row = cinema.getSohangghe();
        int column = cinema.getSoghemothang();
        for (int i = 0; i < row; i++) {
            int temp = i + 65; // ASCII code của ký tự 'A' là 65
            char nameRow = (char)(temp);
            for (int j = 1; j <= column; j++) {
                String seatName = String.valueOf(nameRow) + j;
                result += TicketDAO.insertTicketByShowTimes(showTimes.getId(), seatName);
            }
        }
        if (result == row * column) {
            int ret = LichChieuDAO.updateStatusShowTimes(showTimes.getId(), 1);
            if (ret > 0) {
                JOptionPane.showMessageDialog(null, "TẠO VÉ TỰ ĐỘNG THÀNH CÔNG!", "THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "TẠO VÉ TỰ ĐỘNG THẤT BẠI!", "THÔNG BÁO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }
    
}
