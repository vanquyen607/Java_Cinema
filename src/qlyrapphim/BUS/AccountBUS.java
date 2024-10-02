/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlyrapphim.BUS;
import qlyrapphim.DAO.AccountDAO;
import qlyrapphim.DTO.AccountDTO;
/**
 *
 * @author ADMIN
 */
public class AccountBUS {
     private AccountDAO accountDAO;

    public AccountBUS() {
        this.accountDAO = new AccountDAO();
    }

    public boolean addAccount(AccountDTO account) {
        return accountDAO.addAccount(account);
    }

    public boolean checkLogin(String username, String password) {
        return accountDAO.checkLogin(username, password);
    }

    public int getLoaiTaiKhoan(String username) {
        return accountDAO.getLoaiTaiKhoan(username);
    }
}
