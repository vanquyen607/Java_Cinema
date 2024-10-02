
package qlyrapphim.BUS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import qlyrapphim.DAO.DalNhanVien;
import qlyrapphim.DAO.KetNoiCSDL;
import qlyrapphim.DAO.NhanVienDao;
import qlyrapphim.DTO.NhanVien1;

public class NhanVienBUS {
    DalNhanVien nhanVienDao = new DalNhanVien();
    
    public List<NhanVien1> getAll() {
        return nhanVienDao.getAll();
    }
    
     public int insert(NhanVien1 nv) throws ParseException {
        return nhanVienDao.insert(nv);
    }

   
   public void delete(NhanVien1 nv) {
         nhanVienDao.delete(nv);
    }
   
   public void update(NhanVien1 nv) throws ParseException {
         nhanVienDao.update(nv);
    }
   
   public List<NhanVien1> finCustomersByName(NhanVien1 nv) {
       return nhanVienDao.finCustomersByName(nv);
    }
   public String automatiid(){
       return nhanVienDao.automatiid();
   }
   public boolean containsLetters(String id){
       return nhanVienDao.containsLetters(id);
   }
   
   // Kiểm tra tính duy nhất của ID
//    public boolean isIdUnique(String id) {
//        return nhanVienDao.isIdUnique(id);
//    }
//    
//    // Kiểm tra tính duy nhất của SĐT
//    public boolean isSdtUnique(String sdt) {
//        return nhanVienDao.isSdtUnique(sdt);
//    }
//    
//    // Kiểm tra tính duy nhất của CMND
//    public boolean isCmndUnique(String cmnd) {
//        return nhanVienDao.isCmndUnique(cmnd);
//    }
}
