/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlyrapphim.BUS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import qlyrapphim.DAO.KetNoiCSDL;
import qlyrapphim.DAO.LichChieuDAO;
import qlyrapphim.DTO.LichChieuDTO;

/**
 *
 * @author ADMIN
 */
public class LichChieuBUS {
    private final LichChieuDAO lichChieuDAO;

    public LichChieuBUS() {
        this.lichChieuDAO = new LichChieuDAO();
    }

    public void loadTableData(JTable table) {
        lichChieuDAO.loadTableData(table);
    }
    
    public boolean loadCxTenPhim(JComboBox comboBox){
        return lichChieuDAO.loadCxTenPhim(comboBox);
    }
    
    public boolean loadCxIdPhong(JComboBox comboBox){
        return lichChieuDAO.loadCxIdPhong(comboBox);
    }
    
    public boolean loadCxIdDinhDang(JComboBox comboBox){
        return lichChieuDAO.loadCxIdDinhDang(comboBox);
    }
    
     public boolean loadCxTenMH(JComboBox comboBox){
        return lichChieuDAO.loadCxTenMH(comboBox);
    }

    public boolean isIdTaken(String id) {
        return lichChieuDAO.isIdTaken(id);
    }

    public void themLichChieu(LichChieuDTO lichChieu) {
        lichChieuDAO.themLichChieu(lichChieu);
    }

    public void suaLichChieu(LichChieuDTO lichChieu) {
        lichChieuDAO.suaLichChieu(lichChieu);
    }

    public void xoaLichChieu(String id) {
        lichChieuDAO.xoaLichChieu(id);
    }
    
    public boolean timLichChieu(JTable lichChieu, String tenCanTim) {
       lichChieuDAO.timLichChieu(lichChieu, tenCanTim);
        return false;
    }
    
    public String timTenPhimTheoIDDinhDang(String idDinhDang) {
        return  lichChieuDAO.timTenPhimTheoIDDinhDang(idDinhDang);
    }

    
    public String timTenManHinhTheoIDDinhDang(String idDinhDang) {
        return lichChieuDAO.timTenManHinhTheoIDDinhDang(idDinhDang);
    }

}
