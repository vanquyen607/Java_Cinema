
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
import qlyrapphim.DAO.TaiKhoanDao;
import qlyrapphim.DTO.TaiKhoan;

public class TaiKhoanBUS {
    
    TaiKhoanDao taiKhoanDao = new TaiKhoanDao();
    
    public boolean loadTableData(JTable table) {
        return taiKhoanDao.loadTableData(table);
    }
    
    public boolean loadCboxMaNV(JComboBox comboBox){
        return taiKhoanDao.loadCboxMaNV(comboBox);
    }
    
    public boolean themDuLieu(TaiKhoan TK) {
        return taiKhoanDao.themDuLieu(TK.getUsername(), TK.getLoaiTK(), TK.getManv(), TK.getTennv());
    }


    public boolean suaDuLieu(TaiKhoan TK) {
        return taiKhoanDao.suaDuLieu(TK.getUsername(), TK.getLoaiTK(), TK.getManv(), TK.getTennv());
    }

    public boolean xoaDuLieu(String id) {
        return taiKhoanDao.xoaDuLieu(id);
    }
    
    public boolean daTonTaiTenDangNhap(String username) {
        return taiKhoanDao.daTonTaiTenDangNhap(username);
    }

    public boolean daTonTaiMaNhanVien(String maNV) {
        return taiKhoanDao.daTonTaiMaNhanVien(maNV);
    }
    
    public boolean searchTaiKhoan(JTable table, String tenCanTim) {
        return taiKhoanDao.searchTaiKhoan(table, tenCanTim);
    }
    
    // Phương thức cài đặt mật khẩu cho tài khoản
    public boolean setMatKhau(String username, String password) {
        return taiKhoanDao.setMatKhau(username, password);
    }
    
    public String getTenNhanVien(String maNV) {
        return taiKhoanDao.getTenNhanVien(maNV);
    }
}
