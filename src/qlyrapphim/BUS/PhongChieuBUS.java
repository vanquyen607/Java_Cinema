
package qlyrapphim.BUS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import qlyrapphim.DAO.KetNoiCSDL;
import qlyrapphim.DAO.PhongChieuDao;
import qlyrapphim.DAO.TheLoaiDao;
import qlyrapphim.DTO.PhongChieu;

public class PhongChieuBUS {
    
    PhongChieuDao phongChieuDao = new PhongChieuDao();
    
    public boolean loadTableData(JTable table) {
        return phongChieuDao.loadTableData(table);
    }
    
    public boolean themPhongChieu(PhongChieu phongChieu) {
       return phongChieuDao.themPhongChieu(phongChieu.getMaphong(), phongChieu.getTenphong(), phongChieu.getManhinh(), phongChieu.getSochongoi(), phongChieu.getTinhtrang(), phongChieu.getSohangghe(), phongChieu.getSoghemothang());
    }

    public boolean suaPhongChieu(PhongChieu phongChieu) {
        return phongChieuDao.suaPhongChieu(phongChieu.getMaphong(), phongChieu.getTenphong(), phongChieu.getManhinh(), phongChieu.getSochongoi(), phongChieu.getTinhtrang(), phongChieu.getSohangghe(), phongChieu.getSoghemothang());
    }

    public boolean xoaPhongChieu(String id) {
        return phongChieuDao.xoaPhongChieu(id);
    }
    
    public boolean checkMaPhong(String maPhong) {
       return phongChieuDao.checkMaPhong(maPhong);
    }
    
    public boolean loadCboxidMH(JComboBox<String> comboBox){
        return phongChieuDao.loadCboxidMH(comboBox);
    }
    
    public boolean checkTenPhong(String tenphong){
       return phongChieuDao.checkTenPhong(tenphong);
    }
    
}
