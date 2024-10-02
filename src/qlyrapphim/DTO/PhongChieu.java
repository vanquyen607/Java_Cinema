
package qlyrapphim.DTO;

public class PhongChieu {
    String maphong, tenphong, manhinh;
    int sochongoi,tinhtrang,sohangghe,soghemothang;

    public PhongChieu(String maphong, String tenphong, String manhinh, int sochongoi, int tinhtrang, int sohangghe, int soghemothang) {
        this.maphong = maphong;
        this.tenphong = tenphong;
        this.manhinh = manhinh;
        this.sochongoi = sochongoi;
        this.tinhtrang = tinhtrang;
        this.sohangghe = sohangghe;
        this.soghemothang = soghemothang;
    }

    public String getMaphong() {
        return maphong;
    }

    public void setMaphong(String maphong) {
        this.maphong = maphong;
    }

    public String getTenphong() {
        return tenphong;
    }

    public void setTenphong(String tenphong) {
        this.tenphong = tenphong;
    }

    public String getManhinh() {
        return manhinh;
    }

    public void setManhinh(String manhinh) {
        this.manhinh = manhinh;
    }

    public int getSochongoi() {
        return sochongoi;
    }

    public void setSochongoi(int sochongoi) {
        this.sochongoi = sochongoi;
    }

    public int getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(int tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public int getSohangghe() {
        return sohangghe;
    }

    public void setSohangghe(int sohangghe) {
        this.sohangghe = sohangghe;
    }

    public int getSoghemothang() {
        return soghemothang;
    }

    public void setSoghemothang(int soghemothang) {
        this.soghemothang = soghemothang;
    }
    
    
}
