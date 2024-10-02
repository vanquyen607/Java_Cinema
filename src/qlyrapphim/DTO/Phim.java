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
public class Phim {
    private String Id;
    private String TenPhim;
    private String MoTa;
    private float ThoiLuong;
    private Date NgayKhoiChieu; // Thay đổi kiểu dữ liệu thành Date
    private Date NgayKetThuc;
    private String SanXuat;
    private String DaoDien;
    private int NamSX;
    private byte[] ApPhich;
    private String TenTheLoai;

    public Phim(String id, String tenPhim, String moTa, float thoiLuong, Date ngayKhoiChieu, Date ngayKetThuc, String sanXuat, String daoDien, int namSX, byte[] apPhich, String tenTheLoai) {
        this.Id = id;
        this.TenPhim = tenPhim;
        this.MoTa = moTa;
        this.ThoiLuong = thoiLuong;
        this.NgayKhoiChieu = ngayKhoiChieu;
        this.NgayKetThuc = ngayKetThuc;
        this.SanXuat = sanXuat;
        this.DaoDien = daoDien;
        this.NamSX = namSX;
        this.ApPhich= apPhich;
        this.TenTheLoai= tenTheLoai;
    }

    // Getters và Setters
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getTenPhim() {
        return TenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.TenPhim = tenPhim;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        this.MoTa = moTa;
    }

    public float getThoiLuong() {
        return ThoiLuong;
    }

    public void setThoiLuong(float thoiLuong) {
        this.ThoiLuong = thoiLuong;
    }

     public Date getNgayKhoiChieu() {
        return NgayKhoiChieu;
    }

    public void setNgayKhoiChieu(Date ngayKhoiChieu) {
        this.NgayKhoiChieu = ngayKhoiChieu;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.NgayKetThuc = ngayKetThuc;
    }

    public String getSanXuat() {
        return SanXuat;
    }

    public void setSanXuat(String sanXuat) {
        this.SanXuat = sanXuat;
    }

    public String getDaoDien() {
        return DaoDien;
    }

    public void setDaoDien(String daoDien) {
        this.DaoDien = daoDien;
    }

    public int getNamSX() {
        return NamSX;
    }

    public void setNamSX(int namSX) {
        this.NamSX = namSX;
    }
    
     public byte[] getApPhich() {
        return ApPhich;
    }

    public void setApPhich(byte[] apPhich) {
        this.ApPhich = apPhich;
    }
    
    public String getTenTheLoai() {
        return TenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.TenTheLoai = tenTheLoai;
    
    }
}
