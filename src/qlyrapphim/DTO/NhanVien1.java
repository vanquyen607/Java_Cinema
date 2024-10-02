/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlyrapphim.DTO;

import java.util.Date;

/**
 *
 * @author CUONG
 */
public class NhanVien1 {
//    id VARCHAR(50) PRIMARY KEY,
//	HoTen NVARCHAR(100) NOT NULL,
//	NgaySinh DATE NOT NULL,
//	DiaChi NVARCHAR(100),
//	SDT VARCHAR(100),
//	CMND INT NOT NULL Unique
   
    private String CMND;
    private String HoTen,diachi,sdt,ngaysinh,id;
  
    
    

    public NhanVien1() {
    }

    public NhanVien1(String id, String HoTen, String ngaysinh, String diachi, String sdt, String cmnd) {
        this.id = id;
        this.HoTen = HoTen;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.CMND = cmnd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getCmnd() {
        return CMND;
    }

    public void setCmnd(String cmnd) {
        this.CMND = cmnd;
    }
    
    
}
