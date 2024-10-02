
package qlyrapphim.DAO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.pdf.BaseFont;

import qlyrapphim.BUS.DoanhThuBUS;
import qlyrapphim.DTO.DoanhThu;

public class DoanhThuDao {

    // Phương thức xuất PDF
    public boolean xuatPDF(JTable table) {
        boolean thanhCong = false; // Mặc định là thất bại

        com.itextpdf.text.Document document = new com.itextpdf.text.Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream("Doanhthu.pdf"));
            document.open();

            // Tạo font cho tiêu đề cột
            Font fontTieuDe = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());

            // Thêm tiêu đề của các cột với font đã tạo
            for (int i = 0; i < table.getColumnCount(); i++) {
                PdfPCell cell = new PdfPCell(new Phrase(table.getColumnName(i), fontTieuDe));
                pdfTable.addCell(cell);
            }

            // Tạo font cho dữ liệu
            Font fontDuLieu = new Font(Font.FontFamily.TIMES_ROMAN, 10);

            // Thêm dữ liệu từ JTable vào bảng PDF với font đã tạo
            for (int row = 0; row < table.getRowCount(); row++) {
                for (int column = 0; column < table.getColumnCount(); column++) {
                    PdfPCell cell = new PdfPCell(new Phrase(table.getModel().getValueAt(row, column).toString(), fontDuLieu));
                    pdfTable.addCell(cell);
                }
            }

            document.add(pdfTable);

            thanhCong = true; // Nếu không có ngoại lệ, quá trình xuất thành công
        } catch (IOException | DocumentException ex) {
            ex.printStackTrace(); // In ra lỗi nếu có
        } finally {
            // Đảm bảo rằng tài liệu được đóng sau khi hoàn thành
            if (document != null) {
                document.close();
            }
        }

        return thanhCong; // Trả về trạng thái của quá trình xuất (true nếu thành công, false nếu thất bại)
    }

    // Phương thức xuất Excel
    public boolean xuatExcel(JTable table) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("DoanhThu");

            // Lấy số lượng hàng và cột từ JTable
            int rowCount = table.getRowCount();
            int columnCount = table.getColumnCount();

            // Tạo header cho Excel
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < columnCount; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(table.getColumnName(col));
            }

            // Lưu dữ liệu từ JTable vào Excel
            for (int row = 0; row < rowCount; row++) {
                Row excelRow = sheet.createRow(row + 1);
                for (int col = 0; col < columnCount; col++) {
                    Cell cell = excelRow.createCell(col);
                    cell.setCellValue(table.getValueAt(row, col).toString());
                }
            }

            // Ghi vào file Excel
            try (FileOutputStream outputStream = new FileOutputStream("DoanhThu.xlsx")) {
                workbook.write(outputStream);
            }
            workbook.close();
            return true; // Trả về true nếu xuất Excel thành công
        } catch (IOException ex) {
            ex.printStackTrace();
            return false; // Trả về false nếu có lỗi xảy ra
        }
    }
    
    public boolean loadCboxPhim(JComboBox comboBox){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = KetNoiCSDL.getConnection();
            ps = con.prepareStatement("""
                                      select p.TenPhim
                                      from Phim p """);
            rs=ps.executeQuery();
            // Xóa tất cả các mục hiện có trong JComboBox
             comboBox.removeAllItems();
            
            while (rs.next()) {                
                String tenphim = rs.getString("TenPhim");
                comboBox.addItem(tenphim);
            }
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(con);
        }
        
    }
    
    public boolean loadTableData(JTable table) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("""
                                        SELECT 
                                            p.TenPhim,
                                            CONVERT(date, lc.ThoiGianChieu) AS NgayChieu,
                                            CONVERT(time, lc.ThoiGianChieu) AS GioChieu,
                                            COUNT(CASE WHEN v.TrangThai = 1 THEN 1 ELSE NULL END) AS VeDaBan,
                                            SUM(v.TienBanVe) AS TongTienBanVe
                                        FROM 
                                            Phim p, LichChieu lc, Ve v, DinhDangPhim ddp
                                        WHERE 
                                            v.idLichChieu = lc.id AND ddp.idPhim = p.id AND lc.idDinhDang = ddp.id
                                        GROUP BY 
                                            p.TenPhim, CONVERT(date, lc.ThoiGianChieu), CONVERT(time, lc.ThoiGianChieu);""");
            rs = stm.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                
                Object[] row = new Object[5]; // Số cột trong bảng
                String tenphim = rs.getString("TenPhim");
                String ngaychieu = rs.getString("NgayChieu");
                String giochieu = rs.getString("GioChieu");
                String vedaban = rs.getString("VeDaBan");
                String tongtienbanve = rs.getString("TongTienBanVe");
                
                DoanhThu dt = new DoanhThu(tenphim, ngaychieu, giochieu, vedaban, tongtienbanve);
                
                row[0] = dt.getTenphim();
                row[1] = dt.getNgaychieu();
                row[2] = dt.getGiochieu();
                row[3] = dt.getVedaban();
                row[4] = dt.getTongtienbanve();
                
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoanhThuDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        return true;
    }
    
    public boolean thongKeDoanhThu(JTable tbDoanhThu, String tenPhim, Date startDate, Date endDate) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("""
                                        SELECT 
                                            p.TenPhim,
                                            CONVERT(date, lc.ThoiGianChieu) AS NgayChieu,
                                            CONVERT(time, lc.ThoiGianChieu) AS GioChieu,
                                            COUNT(CASE WHEN v.TrangThai = 1 THEN 1 ELSE NULL END) AS VeDaBan,
                                            SUM(v.TienBanVe) AS TongTienBanVe
                                        FROM 
                                            Phim p, LichChieu lc, Ve v, DinhDangPhim ddp
                                        WHERE 
                                            v.idLichChieu = lc.id AND ddp.idPhim = p.id AND lc.idDinhDang = ddp.id
                                            AND p.TenPhim = ? AND lc.ThoiGianChieu >= ? AND lc.ThoiGianChieu <= ?
                                        GROUP BY 
                                            p.TenPhim, CONVERT(date, lc.ThoiGianChieu), CONVERT(time, lc.ThoiGianChieu);""");
            stm.setString(1, tenPhim);
            stm.setDate(2, new java.sql.Date(startDate.getTime()));
            stm.setDate(3, new java.sql.Date(endDate.getTime()));

            rs = stm.executeQuery();

            DefaultTableModel model = (DefaultTableModel) tbDoanhThu.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = new Object[5]; // Số cột trong bảng
                String tenphim = rs.getString("TenPhim");
                String ngaychieu = rs.getString("NgayChieu");
                String giochieu = rs.getString("GioChieu");
                String vedaban = rs.getString("VeDaBan");
                String tongtienbanve = rs.getString("TongTienBanVe");
                
                DoanhThu dt = new DoanhThu(tenphim, ngaychieu, giochieu, vedaban, tongtienbanve);
                
                row[0] = dt.getTenphim();
                row[1] = dt.getNgaychieu();
                row[2] = dt.getGiochieu();
                row[3] = dt.getVedaban();
                row[4] = dt.getTongtienbanve();
                
                model.addRow(row);
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DoanhThuDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }
    
    public double tinhTongDoanhThu(JTable tbDoanhThu) {
        double tongDoanhThu = 0.0;
        for (int i = 0; i < tbDoanhThu.getRowCount(); i++) {
            // Lấy giá trị tiền vé từ cột cuối cùng của mỗi dòng và cộng vào tổng doanh thu
            tongDoanhThu += Double.parseDouble(tbDoanhThu.getValueAt(i, tbDoanhThu.getColumnCount() - 1).toString());
        }
        return tongDoanhThu;
    }

    public boolean thongKeTheoPhim(JTable tbDoanhThu, String tenPhim) {
        try {
            Connection conn = KetNoiCSDL.getConnection();
            PreparedStatement stm = conn.prepareStatement("""
                SELECT 
                    p.TenPhim,
                    CONVERT(date, lc.ThoiGianChieu) AS NgayChieu,
                    CONVERT(time, lc.ThoiGianChieu) AS GioChieu,
                    COUNT(CASE WHEN v.TrangThai = 1 THEN 1 ELSE NULL END) AS VeDaBan,
                    SUM(v.TienBanVe) AS TongTienBanVe
                FROM 
                    Phim p, LichChieu lc, Ve v, DinhDangPhim ddp
                WHERE 
                    v.idLichChieu = lc.id AND ddp.idPhim = p.id AND lc.idDinhDang = ddp.id
                    AND p.TenPhim = ?
                GROUP BY 
                    p.TenPhim, CONVERT(date, lc.ThoiGianChieu), CONVERT(time, lc.ThoiGianChieu);
            """);
            stm.setString(1, tenPhim);

            ResultSet rs = stm.executeQuery();

            DefaultTableModel model = (DefaultTableModel) tbDoanhThu.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = new Object[5]; // Số cột trong bảng
                row[0] = rs.getString("TenPhim");
                row[1] = rs.getString("NgayChieu");
                row[2] = rs.getString("GioChieu");
                row[3] = rs.getString("VeDaBan");
                row[4] = rs.getString("TongTienBanVe");

                model.addRow(row);
            }
            KetNoiCSDL.Closeconnection(conn);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DoanhThuDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
