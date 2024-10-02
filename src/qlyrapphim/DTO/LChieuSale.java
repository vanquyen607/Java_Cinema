
package qlyrapphim.DTO;

/**
 *
 * @author vanqu
 */
public class LChieuSale {
    
    private String id,tenphong,tenphim,giochieu,tinhtrang;

    public LChieuSale(String id, String tenphong, String tenphim, String giochieu, String tinhtrang) {
        this.id = id;
        this.tenphong = tenphong;
        this.tenphim = tenphim;
        this.giochieu = giochieu;
        this.tinhtrang = tinhtrang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenphong() {
        return tenphong;
    }

    public void setTenphong(String tenphong) {
        this.tenphong = tenphong;
    }

    public String getTenphim() {
        return tenphim;
    }

    public void setTenphim(String tenphim) {
        this.tenphim = tenphim;
    }

    public String getGiochieu() {
        return giochieu;
    }

    public void setGiochieu(String giochieu) {
        this.giochieu = giochieu;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    

    
}
