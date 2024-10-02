
package qlyrapphim.BUS;

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
import qlyrapphim.DAO.DinhDangDao;
import qlyrapphim.DAO.KetNoiCSDL;
import qlyrapphim.DAO.TaiKhoanDao;
import qlyrapphim.DTO.DinhDang;

public class DinhDangBUS {
    DinhDangDao dinhDangDao = new DinhDangDao();
    
    public boolean loadTableData(JTable table) {
        return dinhDangDao.loadTableData(table);
    }
    
    public boolean kiemTraMaDinhDangTonTai(String maDinhDang) {
        return dinhDangDao.kiemTraMaDinhDangTonTai(maDinhDang);
    }
    
    public boolean loadcboxMaPhim (JComboBox comboBox){
       return dinhDangDao.loadcboxMaPhim(comboBox);
   }
   
   public boolean loadcboxMaMH (JComboBox comboBox){
       return dinhDangDao.loadcboxMaMH(comboBox);
   }
   
   public boolean loadDataToTable(String selectedPhimId, String selectedMHId, JTable table) {
       return dinhDangDao.loadDataToTable(selectedPhimId, selectedMHId, table);
    }
   
    public boolean themDuLieu(DinhDang dd) {
        return dinhDangDao.themDuLieu(dd.getMadinhdang(), dd.getMaphim(), dd.getTenphim(), dd.getMaMH(), dd.getTenMH());
    }
   
   public boolean suaDuLieu(DinhDang dd) {
        return dinhDangDao.suaDuLieu(dd.getMadinhdang(), dd.getMaphim(), dd.getTenphim(), dd.getMaMH(), dd.getTenMH());
    }

   public boolean xoaDuLieu(String idDinhDang, String idPhim, String idLoaiManHinh) {
        return dinhDangDao.xoaDuLieu(idDinhDang, idPhim, idLoaiManHinh);
    }
   
   public boolean choiceinCboxMaPhim(JTextField textField, String idPhim){
        return dinhDangDao.choiceinCboxMaPhim(textField, idPhim);
    }
    
    public boolean choiceinCboxMaMH(JTextField textField, String idMH){
        return dinhDangDao.choiceinCboxMaMH(textField, idMH);
    }

}
