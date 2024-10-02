
package qlyrapphim.DTO;

public class TaiKhoan {
    String  manv , tennv, username ;
    String loaiTK;

    public TaiKhoan(String manv, String tennv, String username, String loaiTK) {
        this.manv = manv;
        this.tennv = tennv;
        this.username = username;
        this.loaiTK = loaiTK;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoaiTK() {
        return loaiTK;
    }

    public void setLoaiTK(String loaiTK) {
        this.loaiTK = loaiTK;
    }
    
    
}
