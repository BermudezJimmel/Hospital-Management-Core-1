package SystemInstance;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ariannikko
 */
import java.sql.*;
import javax.swing.*;

public class MysqlConnect {

    Connection con = null;

    public static Connection ConnectDB() {
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=HMSdb;user=asd;password=123");
         //   Connection con = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-KH0FM0UH:1433;databaseName=HMSdb;user=sa;password=admin123");
             //      Connection con = DriverManager.getConnection("jdbc:sqlserver://JOSE-PC:1433;databaseName=HMSdb;user=sa;password=admin123");
            // Connection con = DriverManager.getConnection("jdbc:sqlserver://JIMMELBERMUDEZ:1433;databaseName=HMS4109;user=sa;password=admin123");
            return con;
        } //jdbc:sqlserver://localhost:1433;databaseName=rms;user=Server;password=123456
        catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
            return null;

        }

    }

    public static ResultSet getData(String sq) throws Exception {
        return MysqlConnect.ConnectDB().createStatement().executeQuery(sq);
    }

}
