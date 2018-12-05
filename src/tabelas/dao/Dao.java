
package tabelas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao{
    private static Connection connection = null;
    
     public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/sigea", "root", "");
            connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        return connection;
    }
     
     public static void disconnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }

    
}
