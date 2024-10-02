
package qlyrapphim.BUS;

import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import qlyrapphim.DAO.ManChieuDao;
import qlyrapphim.DTO.Ticket;


/**
 *
 * @author vanqu
 */
public class ManChieuBUS {
    
    private ManChieuDao manChieuDao;

    public ManChieuBUS(List<Ticket> seatSelected) {
        this.manChieuDao = new ManChieuDao(seatSelected);
    }

    public void updateTicketPrice(BigDecimal giaVe, JRadioButton rdNguoiLon, JRadioButton rdSinhVien, JRadioButton rdTreEm, JTextField txtGiaVe, JTextField txtTongTien, JTextField txtGiaGiam, JTextField txtTienPhaiThanhToan) {
        manChieuDao.updateTicketPrice(giaVe, rdNguoiLon, rdSinhVien, rdTreEm, txtGiaVe, txtTongTien, txtGiaGiam, txtTienPhaiThanhToan);
    }
    
   
    
}
