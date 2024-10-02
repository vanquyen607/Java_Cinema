
package qlyrapphim.BUS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import qlyrapphim.DAO.KetNoiCSDL;
import qlyrapphim.DAO.LoaiManHinhDao;
import qlyrapphim.DTO.LoaiManHinh;

public class LoaiManHinhBUS {
    
    LoaiManHinhDao loaiManHinhDao = new  LoaiManHinhDao();
    public boolean loadTableData(JTable table) {
        return loaiManHinhDao.loadTableData(table);
    }
    
    public boolean insertLoaiManHinh(LoaiManHinh manHinh) {
        return loaiManHinhDao.insertLoaiManHinh(manHinh.getMaMH(), manHinh.getTenMH());
    }
    
    public boolean deleteLoaiManHinh(String id) {
       return loaiManHinhDao.deleteLoaiManHinh(id);
    }

    public boolean updateLoaiManHinh(LoaiManHinh manHinh) {
        return loaiManHinhDao.updateLoaiManHinh(manHinh.getMaMH(), manHinh.getTenMH());
    }
    
    public boolean isMaMHExists(String maMH) {
        return loaiManHinhDao.isMaMHExists(maMH);
    }

    
}
