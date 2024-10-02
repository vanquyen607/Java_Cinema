
package qlyrapphim.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Ticket {
     private String ID;
    private int Type;
    private String ShowTimesID;
    private String SeatName;
    private String CustomerID;
    private float Price;
    private int Status;

    public Ticket() {
    }

    public Ticket(String ID, int Type, String ShowTimesID, String SeatName, String CustomerID, float Price, int Status) {
        this.ID = ID;
        this.Type = Type;
        this.ShowTimesID = ShowTimesID;
        this.SeatName = SeatName;
        this.CustomerID = CustomerID;
        this.Price = Price;
        this.Status = Status;
    }

    public Ticket(ResultSet rs) throws SQLException {
        this.ID = rs.getString("id");
        this.Type = rs.getInt("LoaiVe");
        this.ShowTimesID = rs.getString("idLichChieu");
        this.SeatName = rs.getString("MaGheNgoi");
        this.CustomerID = rs.getString("idKhachHang");
        this.Status = rs.getInt("TrangThai");
        if (rs.getString("TienBanVe") == null || rs.getString("TienBanVe").isEmpty()) {
            this.Price = 0;
        } else {
            this.Price = Float.parseFloat(rs.getString("TienBanVe"));
        }
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }

    public String getShowTimesID() {
        return ShowTimesID;
    }

    public void setShowTimesID(String ShowTimesID) {
        this.ShowTimesID = ShowTimesID;
    }

    public String getSeatName() {
        return SeatName;
    }

    public void setSeatName(String SeatName) {
        this.SeatName = SeatName;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }
    
    

}
