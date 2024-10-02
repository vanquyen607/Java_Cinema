/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlyrapphim.BUS;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import qlyrapphim.DAO.PhimDAO;
import qlyrapphim.DTO.Phim;

/**
 *
 * @author ADMIN
 */
public class PhimBUS {
    private final PhimDAO phimDAO;
    

    public PhimBUS() {
        this.phimDAO = new PhimDAO();
    }

    public void loadTableData(JTable table) {
        phimDAO.loadTableData(table);
    }

    public boolean isIdTaken(String id) {
        return phimDAO.isIdTaken(id);
    }

    public void themPhim(Phim phim, JTable tbPhim) {
        phimDAO.themPhim(phim, tbPhim);
        phimDAO.loadTableData(tbPhim);// Thêm phim vào cơ sở dữ liệu
        
    }
    

    public void suaPhim(Phim phim) {
        phimDAO.suaPhim(phim);
    }

    public void xoaPhim(String id) {
        phimDAO.xoaPhim(id);
    }
    
    public boolean timPhim(JTable phim, String tenCanTim) {
       phimDAO.timPhim(phim, tenCanTim);
        return false;
    }
}
