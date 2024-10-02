
package qlyrapphim.DTO;

/**
 *
 * @author vanqu
 */
public class DoanhThu {
    
    private String tenphim,ngaychieu,giochieu,vedaban,tongtienbanve;

    public DoanhThu(String tenphim, String ngaychieu, String giochieu, String vedaban, String tongtienbanve) {
        this.tenphim = tenphim;
        this.ngaychieu = ngaychieu;
        this.giochieu = giochieu;
        this.vedaban = vedaban;
        this.tongtienbanve = tongtienbanve;
    }

    public String getTenphim() {
        return tenphim;
    }

    public void setTenphim(String tenphim) {
        this.tenphim = tenphim;
    }

    public String getNgaychieu() {
        return ngaychieu;
    }

    public void setNgaychieu(String ngaychieu) {
        this.ngaychieu = ngaychieu;
    }

    public String getGiochieu() {
        return giochieu;
    }

    public void setGiochieu(String giochieu) {
        this.giochieu = giochieu;
    }

    public String getVedaban() {
        return vedaban;
    }

    public void setVedaban(String vedaban) {
        this.vedaban = vedaban;
    }

    public String getTongtienbanve() {
        return tongtienbanve;
    }

    public void setTongtienbanve(String tongtienbanve) {
        this.tongtienbanve = tongtienbanve;
    }
    
    
}
