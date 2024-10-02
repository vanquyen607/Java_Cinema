
package qlyrapphim.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import qlyrapphim.DTO.LChieuSale;

public class LChieuSaleDao {
    
    public boolean loadCboxPhim(JComboBox comboBox){
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = KetNoiCSDL.getConnection();
            stm = con.prepareStatement("""
                                       select p.TenPhim
                                       from Phim p""");
            rs = stm.executeQuery();
            comboBox.removeAllItems();

            while(rs.next()){
                String TenPhim = rs.getString("TenPhim");
                comboBox.addItem(TenPhim);
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace(); // In ra thông tin lỗi để dễ dàng gỡ lỗi
            return false;
        }finally{
            KetNoiCSDL.Closeconnection(con);
        }
    }
    
    public boolean loadCboxSuatChieu(JComboBox comboBox){
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = KetNoiCSDL.getConnection();
            stm = con.prepareStatement("""
                                       SELECT FORMAT(lc.ThoiGianChieu, 'HH:mm:ss') AS Time
                                       FROM LichChieu lc;""");
            rs = stm.executeQuery();
            comboBox.removeAllItems();

            while(rs.next()){
                String Time = rs.getString("Time");
                comboBox.addItem(Time);
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace(); // In ra thông tin lỗi để dễ dàng gỡ lỗi
            return false;
        }finally{
            KetNoiCSDL.Closeconnection(con);
        }
    }
    
    public boolean loadtotable(JTable table){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = KetNoiCSDL.getConnection();
            ps = con.prepareStatement("""
                                      SELECT 
                                                                                                  pc.id,
                                                                                                  pc.TenPhong, 
                                                                                                  p.TenPhim,
                                                                                                  FORMAT(lc.ThoiGianChieu, 'yyyy/MM/dd') AS NgayChieu,
                                                                                                  FORMAT(lc.ThoiGianChieu, 'HH:mm:ss') AS GioChieu, 
                                                                                                  CONCAT(
                                                                                                  COALESCE(SUM(CASE WHEN v.TrangThai = 1 THEN 1 END), 0), 
                                                                                                  '/', 
                                                                                                      pc.SoChoNgoi
                                                                                                  ) AS Tinhtrang
                                                                                                  FROM 
                                                                                                  PhongChieu pc
                                                                                                  LEFT JOIN 
                                                                                        	      LichChieu lc ON pc.id = lc.idPhong
                                                                                                  LEFT JOIN 
                                                                                                  DinhDangPhim ddp ON ddp.id = lc.idDinhDang
                                                                                                  LEFT JOIN 
                                                                                                  Ve v ON lc.id = v.idLichChieu
                                                                                                  LEFT JOIN
                                                                                                  Phim p ON p.id = ddp.idPhim
                                                                                                  WHERE 
                                                                                                  NgayKetThuc >= GETDATE()
                                                                                                  GROUP BY 
                                                                                                  pc.id, 
                                                                                                  pc.TenPhong, 
                                                                                                  p.TenPhim, 
                                                                                                  FORMAT(lc.ThoiGianChieu, 'yyyy/MM/dd'), 
                                                                                                  FORMAT(lc.ThoiGianChieu, 'HH:mm:ss'), 
                                                                                                  pc.SoChoNgoi;""");
            rs=ps.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            
            while(rs.next()){
                Object [] row = new Object[6];
                
                String id =rs.getString("id");
                String tenphong =rs.getString("TenPhong");
                String tenphim =rs.getString("TenPhim");
                String ngaychieu=rs.getString("NgayChieu");
                String giochieu =rs.getString("GioChieu");
                String tinhtrang =rs.getString("Tinhtrang");
                
//                LChieuSale lcsale = new LChieuSale(id, tenphong, tenphim, giochieu, tinhtrang);
                
                row[0]= id;
                row[1]= tenphong;
                row[2]= tenphim;
                row[3]= ngaychieu;
                row[4]= giochieu;
                row[5]= tinhtrang;
                
                model.addRow(row);
            }
            
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(con);
        }
    }
    
    public boolean getDataByDateTimeAndMovie(JTable table, Date selectedDate, String selectedMovie, String selectedShowtime) {
        if (selectedDate == null) {
            System.out.println("Vui lòng chọn một ngày");
            return false;
        }

        String sql = "SELECT pc.id,pc.TenPhong, p.TenPhim, FORMAT(lc.ThoiGianChieu, 'hh:mm:ss') AS GioChieu, "
           + "CONCAT(COALESCE(COUNT(CASE WHEN v.TrangThai = 1 THEN 1 END), 0), '/', pc.SoChoNgoi) AS Tinhtrang "
           + "FROM PhongChieu pc "
           + "LEFT JOIN LichChieu lc ON pc.id = lc.idPhong "
           + "LEFT JOIN DinhDangPhim ddp ON ddp.id = lc.idDinhDang "
           + "LEFT JOIN Ve v ON lc.id = v.idLichChieu "
           + "LEFT JOIN Phim p ON p.id = ddp.idPhim "
           + "WHERE CONVERT(date, lc.ThoiGianChieu) = CONVERT(date, ?) " // So sánh ngày
           + "AND CONVERT(time, lc.ThoiGianChieu) = CONVERT(time, ?) " // So sánh giờ
           + "AND p.TenPhim = ? " //So sanh ten phim
           + "GROUP BY pc.id, pc.TenPhong, p.TenPhim, FORMAT(lc.ThoiGianChieu, 'hh:mm:ss'), pc.SoChoNgoi";


        try (Connection conn = KetNoiCSDL.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDate(1, new java.sql.Date(selectedDate.getTime()));
            pstmt.setString(2, selectedShowtime);
            pstmt.setString(3, selectedMovie);
            

            ResultSet rs = pstmt.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Thiết lập lại số dòng của bảng về 0

            // Kiểm tra nếu ResultSet không null
            if (rs != null) {
                while (rs.next()) {
                    Object [] row = new Object[5];
                
                    String id =rs.getString("id");
                    String tenphong =rs.getString("TenPhong");
                    String tenphim =rs.getString("TenPhim");
                    String giochieu =rs.getString("GioChieu");
                    String tinhtrang =rs.getString("Tinhtrang");

                    LChieuSale lcsale = new LChieuSale(id, tenphong, tenphim, giochieu, tinhtrang);

                    row[0]=lcsale.getId();
                    row[1]=lcsale.getTenphong();
                    row[2]=lcsale.getTenphim();
                    row[3]=lcsale.getGiochieu();
                    row[4]=lcsale.getTinhtrang();

                    model.addRow(row);
                }
                rs.close(); // Đóng ResultSet sau khi sử dụng xong
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    
}
