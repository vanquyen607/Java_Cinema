
package qlyrapphim.BUS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import qlyrapphim.DAO.KetNoiCSDL;
import qlyrapphim.DAO.LChieuSaleDao;

public class LChieuSaleBUS {
    
    LChieuSaleDao lcsd = new LChieuSaleDao();
    public boolean loadCboxPhim(JComboBox comboBox){
        return lcsd.loadCboxPhim(comboBox);
    }
    
    public boolean loadCboxSuatChieu(JComboBox comboBox){
        return lcsd.loadCboxSuatChieu(comboBox);
    }
    
    public boolean loadtotable(JTable table){
        return lcsd.loadtotable(table);
    }
    
    public boolean getDataByDateTimeAndMovie(JTable table,Date selectedDate, String selectedMovie, String selectedShowtime) {
        return lcsd.getDataByDateTimeAndMovie(table, selectedDate, selectedMovie, selectedShowtime);
    }
    
}
