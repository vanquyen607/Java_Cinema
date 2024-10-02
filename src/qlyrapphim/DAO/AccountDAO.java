
package qlyrapphim.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import qlyrapphim.DAO.KetNoiCSDL;
import qlyrapphim.DTO.AccountDTO;

public class AccountDAO {
    private Connection connection;
    
    private boolean addEmployee(String idNV, int CMND, String HoTen, Date NgaySinh) {
    try {
        if (idNV.isEmpty() || HoTen.isEmpty() || NgaySinh == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập ID nhân viên, họ tên và ngày sinh!");
            return false;
        }
        
        String checkSql = "SELECT * FROM NhanVien WHERE id = ?";
        PreparedStatement checkPs = connection.prepareStatement(checkSql);
        checkPs.setString(1, idNV);
        ResultSet checkRs = checkPs.executeQuery();
        if (checkRs.next()) {
            // ID nhân viên đã tồn tại, xử lý lỗi ở đây
            JOptionPane.showMessageDialog(null, "ID nhân viên đã tồn tại!");
            return false;
        }


        // Thực hiện câu lệnh INSERT INTO để thêm một bản ghi mới vào bảng "NhanVien"
        String sql = "INSERT INTO NhanVien (id, CMND, HoTen, NgaySinh) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, idNV);
        ps.setInt(2, CMND);
        ps.setString(3, HoTen);
        ps.setDate(4, new java.sql.Date(NgaySinh.getTime()));
        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    public AccountDAO() {
        connection = KetNoiCSDL.getConnection();
    }

    public boolean addAccount(AccountDTO account) {
        
        if (connection == null) {
            // Xử lý khi kết nối chưa được thiết lập
            System.err.println("Kết nối đến cơ sở dữ liệu chưa được thiết lập!");
            return false;
        }
        
        try {
        
        if (account.getUsername() == null || account.getUsername().isEmpty() || 
            account.getPass() == null || account.getPass().isEmpty() || 
            account.getidNV() == null || account.getidNV().isEmpty() ||
            account.getHoTen() == null || account.getHoTen().isEmpty() ||
            account.getNgaySinh() == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin tài khoản!");
            return false;
        }
        
        
            if (!addEmployee(account.getidNV(), account.getCMND(), account.getHoTen(), account.getNgaySinh())) {
            JOptionPane.showMessageDialog(null, "Thêm nhân viên thất bại!");
            return false; 
            }
            
            String sql = "INSERT INTO TaiKhoan (UserName, PASS, LoaiTK, idNV) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPass());
            ps.setInt(3, account.getloaiTK());
            ps.setString(4, account.getidNV());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Thêm tài khoản thành công!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Thêm tài khoản thất bại!");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkLogin(String username, String password) {
        try {
            String sql = "SELECT * FROM TaiKhoan WHERE UserName = ? AND PASS = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public int getLoaiTaiKhoan(String username) {
        try {
            // Chuẩn bị truy vấn SQL
            String sql = "SELECT LoaiTK FROM TaiKhoan WHERE UserName = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);

            // Thực thi truy vấn
            ResultSet rs = ps.executeQuery();

            // Kiểm tra xem kết quả có tồn tại không
            if (rs.next()) {
                // Nếu có, trả về loại tài khoản
                return rs.getInt("LoaiTK");
            } else {
                // Nếu không tìm thấy tài khoản, trả về giá trị mặc định hoặc throw một Exception
                // Tùy thuộc vào logic ứng dụng của bạn
                return -1; // Ví dụ: -1 để biểu thị rằng không tìm thấy tài khoản
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; // Trả về giá trị mặc định nếu có lỗi xảy ra
        }
    }

}




