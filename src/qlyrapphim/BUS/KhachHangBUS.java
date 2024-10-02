
package qlyrapphim.BUS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import qlyrapphim.DAO.KetNoiCSDL;
import qlyrapphim.DAO.KhachHangDao;
import qlyrapphim.DTO.KhachHang;

public class KhachHangBUS {
    KhachHangDao khachHangDao = new KhachHangDao();
    public boolean themKhachHang(KhachHang KH) {
        return khachHangDao.themKhachHang(KH.getMaKH(), KH.getHoten(), KH.getNgaySinh(), KH.getDiaChi(), KH.getSDT(), KH.getCMND(), KH.getDiemtichluy());
    }
    
    public boolean isMaKHTaken(String maKH) {
        return khachHangDao.isMaKHTaken(maKH);
    }

    public boolean isSdtTaken(String sdt) {
        return khachHangDao.isSdtTaken(sdt);
    }

    public boolean isCmndTaken(String cmnd) {
        return khachHangDao.isCmndTaken(cmnd);
    }

    public boolean suaKhachHang(KhachHang KH) {
        return khachHangDao.suaKhachHang(KH.getMaKH(), KH.getHoten(), KH.getNgaySinh(), KH.getDiaChi(), KH.getSDT(), KH.getCMND(), KH.getDiemtichluy());
    }

    public boolean xoaKhachHang(String id) {
        return khachHangDao.xoaKhachHang(id);
    }
    
//    public boolean searchKhachHang(JTable table, String tenCanTim) {
//        return khachHangDao.searchKhachHang(table, tenCanTim);
//    }
    
    public boolean loadTableData(JTable table) {
        return khachHangDao.loadTableData(table);
    }
    
    public boolean searchKhachHangByOption(JTable table, String searchText, String searchOption) {
        return khachHangDao.searchKhachHangByOption(table, searchText, searchOption);
    }
    
}
