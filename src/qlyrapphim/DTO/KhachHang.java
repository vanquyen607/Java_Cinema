
package qlyrapphim.DTO;

public class KhachHang {

    private String MaKH,Hoten,DiaChi,SDT,CMND;
    private String NgaySinh;
    private int Diemtichluy;

    public KhachHang(String MaKH, String Hoten, String DiaChi, String SDT, String NgaySinh, String CMND, int Diemtichluy) {
        this.MaKH = MaKH;
        this.Hoten = Hoten;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.NgaySinh = NgaySinh;
        this.CMND = CMND;
        this.Diemtichluy = Diemtichluy;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public int getDiemtichluy() {
        return Diemtichluy;
    }

    public void setDiemtichluy(int Diemtichluy) {
        this.Diemtichluy = Diemtichluy;
    }
     
}
