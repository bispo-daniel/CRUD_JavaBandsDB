import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Connect {
    static String dbUrl = "jdbc:mysql://localhost:3306/bandsdb";
    static String user = "root";
    static String pass = "1234";
    static Connection connection;

    static void connect(){
        try {
            connection = DriverManager.getConnection(dbUrl, user, pass);

            if (connection != null){
                JOptionPane.showMessageDialog(null, "Database has been connected!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}