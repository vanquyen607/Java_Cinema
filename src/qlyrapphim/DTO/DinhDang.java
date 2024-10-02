
package qlyrapphim.DTO;

public class DinhDang {
    String madinhdang , maphim , tenphim , maMH, tenMH;

    public DinhDang(String madinhdang, String maphim, String tenphim, String maMH, String tenMH) {
        this.madinhdang = madinhdang;
        this.maphim = maphim;
        this.tenphim = tenphim;
        this.maMH = maMH;
        this.tenMH = tenMH;
    }

    public String getMadinhdang() {
        return madinhdang;
    }

    public void setMadinhdang(String madinhdang) {
        this.madinhdang = madinhdang;
    }

    public String getMaphim() {
        return maphim;
    }

    public void setMaphim(String maphim) {
        this.maphim = maphim;
    }

    public String getTenphim() {
        return tenphim;
    }

    public void setTenphim(String tenphim) {
        this.tenphim = tenphim;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }
    
    
}
