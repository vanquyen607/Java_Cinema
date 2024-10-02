package qlyrapphim.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KetNoiCSDL {
    private static String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLRP;user=sa;password=123;encrypt=false;";
    
    public static Connection getConnection() {
            Connection conn = null;
        try {
            conn = DriverManager.getConnection(connectionUrl);
//            System.out.println("Connected to the database!");
        } catch (SQLException ex) {
            Logger.getLogger(KetNoiCSDL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    
    public static void Closeconnection (Connection conn){
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
