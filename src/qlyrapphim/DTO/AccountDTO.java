
package qlyrapphim.DTO;

import java.util.Date;

public class AccountDTO {
    private String UserName;
    private String Pass;
    private int LoaiTK;
    private String idNV;
    private int CMND;
    private String HoTen; // Thêm trường HoTen
    private Date NgaySinh;

    public AccountDTO(String username, String password, int loaiTK, String idNV, int CMND, String HoTen1, Date NgaySinh1) {
        this.UserName = username;
        this.Pass = password;
        this.LoaiTK = loaiTK;
        this.idNV = idNV;
        this.CMND = CMND;
        this.HoTen = HoTen1; // Khởi tạo HoTen
        this.NgaySinh = NgaySinh1; // Khởi tạo NgaySinh
    }

    public String getUsername() {
        return UserName;
    }

    public void setUsername(String username) {
        this.UserName = username;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String password) {
        this.Pass = password;
    }

    public int getloaiTK() {
        return LoaiTK;
    }

    public void setType(int loaiTK) {
        this.LoaiTK = loaiTK;
    }

    public String getidNV() {
        return idNV;
    }

    public void setEmployeeId(String idNV) {
        this.idNV = idNV ;
    }
    
    public int getCMND() {
        return CMND;
    }

    public void setCMND(int CMND) {
        this.CMND = CMND;
    }
    
    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }
}


