
package qlyrapphim.BUS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import qlyrapphim.DAO.KetNoiCSDL;
import qlyrapphim.DAO.LichChieuDAO;
import qlyrapphim.DAO.PhongChieuDao;
import qlyrapphim.DAO.TicketDAO;
import qlyrapphim.DTO.LichChieuDTO;
import qlyrapphim.DTO.PhongChieu;
import qlyrapphim.DTO.Ticket;

public class TicketBUS {
    TicketDAO ticketDAO = new TicketDAO();
    LichChieuDAO lcdao = new LichChieuDAO();
    public boolean loadTableData(JTable table) {
        return ticketDAO.loadTableData(table);
    }
    
    public LichChieuDTO getLichChieuById(String idLichChieu) {
        return lcdao.getLichChieuById(idLichChieu);
    }
    
    public boolean loadTableDataNotCreate(JTable table) {
        return ticketDAO.loadTableDataNotCreate(table);
    }
    
    public boolean autoCreateTicketsByShowTimes(LichChieuDTO showTimes) {
        return ticketDAO.autoCreateTicketsByShowTimes(showTimes);
    }
    
    public static List<Ticket> getListTicketsByShowTimes(String showTimesID) {
        return TicketDAO.getListTicketsByShowTimes(showTimesID);
    }

    public static List<Ticket> getListTicketsBoughtByShowTimes(String showTimesID) {
        return TicketDAO.getListTicketsBoughtByShowTimes(showTimesID);
    }

    public static int countTotalTicketByShowTime(String showTimesID) {
        return TicketDAO.countTotalTicketByShowTime(showTimesID);
    }

    public static int countTheNumberOfTicketsSoldByShowTime(String showTimesID) {
        return TicketDAO.countTheNumberOfTicketsSoldByShowTime(showTimesID);
    }

    public static int buyTicket(String ticketID, int type, float price) {
        return TicketDAO.buyTicket(ticketID, type, price);
    }

    public static int buyTicket(String ticketID, int type, String customerID, float price) {
        return TicketDAO.buyTicket(ticketID, type, customerID, price);
    }

    public static int insertTicketByShowTimes(String showTimesID, String seatName) {
        return TicketDAO.insertTicketByShowTimes(showTimesID, seatName);
    }

    public static int deleteTicketsByShowTimesAction(String showTimesID) {
        return TicketDAO.deleteTicketsByShowTimesAction(showTimesID);
    }
    
    public boolean deleteTicketsByShowTimes(String showTimesID) {
        return ticketDAO.deleteTicketsByShowTimes(showTimesID);
    }
}