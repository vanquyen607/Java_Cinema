
package qlyrapphim.DTO;

public class TheLoai {
    String id, tenTheLoai, moTa;

    public TheLoai(String id, String tenTheLoai, String moTa) {
        this.id = id;
        this.tenTheLoai = tenTheLoai;
        this.moTa = moTa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    
}
