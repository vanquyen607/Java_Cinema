
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
import qlyrapphim.DAO.KhachHangDao;
import qlyrapphim.DAO.TheLoaiDao;
import qlyrapphim.DTO.TheLoai;

public class TheLoaiBUS {
    TheLoaiDao theLoaiDao = new TheLoaiDao();
    
    public boolean loadTableData(JTable table) {
        return theLoaiDao.loadTableData(table);
    }
     
    public boolean insertTheLoai(TheLoai TL) {
        return theLoaiDao.insertTheLoai(TL.getId(), TL.getTenTheLoai(), TL.getMoTa());
    }

    public boolean updateTheLoai(TheLoai TL) {
       return theLoaiDao.updateTheLoai(TL.getId(), TL.getTenTheLoai(), TL.getMoTa());
    }

    public boolean deleteTheLoai(String id) {
        return theLoaiDao.deleteTheLoai(id);
    }
    
    public boolean checkMaTheLoai(String maTheLoai) {
        return theLoaiDao.checkMaTheLoai(maTheLoai);
    }
    
    
}
