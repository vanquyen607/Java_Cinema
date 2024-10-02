/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlyrapphim.DTO;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class LichChieuDTO {
  private String Id;
    private String IdDinhDang;
    private String IdPhong;
    private Date TGianChieu; // Thay đổi kiểu dữ liệu từ ThoiGianChieu thành Date
    private String GiaVe;
    
    public LichChieuDTO(String id, String idDinhDang, String idPhong, Date tGianChieu, String giaVe) {
        this.Id = id;
        this.IdDinhDang = idDinhDang;
        this.IdPhong = idPhong;
        this.TGianChieu = tGianChieu;
        this.GiaVe = giaVe;
    }

    // Getters và Setters
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getIdDinhDang() {
        return IdDinhDang;
    }

    public void setIdDinhDang(String idDinhDang) {
        this.IdDinhDang = idDinhDang;
    }
    
    public String getIdPhong() {
        return IdPhong;
    }

    public void setIdPhong(String idPhong) {
        this.IdPhong = idPhong;
    }

    public Date getTGianChieu() {
        return TGianChieu;
    }

    public void setTGianChieu(Date tGianChieu) {
        this.TGianChieu = tGianChieu;
    }

    public String getGiaVe() {
        return GiaVe;
    }

    public void setGiaVe(String giaVe) {
        this.GiaVe = giaVe;
    }
}
