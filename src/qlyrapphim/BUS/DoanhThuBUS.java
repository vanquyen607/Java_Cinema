
package qlyrapphim.BUS;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
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
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import qlyrapphim.DAO.DoanhThuDao;
import qlyrapphim.DAO.KetNoiCSDL;

public class DoanhThuBUS {
    DoanhThuDao dtd = new DoanhThuDao();
    
    public boolean loadCboxPhim(JComboBox comboBox){
        return dtd.loadCboxPhim(comboBox);
    }
    
    public boolean loadTableData(JTable table) {
        return dtd.loadTableData(table);
    }
    
    public boolean thongKeDoanhThu(JTable tbDoanhThu, String tenPhim, Date startDate, Date endDate) {
        return dtd.thongKeDoanhThu(tbDoanhThu, tenPhim, startDate, endDate);
    }
    
    public double tinhTongDoanhThu(JTable tbDoanhThu) {
        return dtd.tinhTongDoanhThu(tbDoanhThu);
    }
    
    public boolean thongKeTheoPhim(JTable tbDoanhThu, String tenPhim) {
        return dtd.thongKeTheoPhim(tbDoanhThu, tenPhim);
    }
    
    public boolean xuatExcel(JTable table) {
        return dtd.xuatExcel(table);
    }
    
    public boolean xuatPDF(JTable table) {
        return dtd.xuatPDF(table);
    }
    
}
