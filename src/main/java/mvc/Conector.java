package mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {

    public static Connection conectar() throws SQLException {
        Connection conn = null;

        String url="jdbc:mysql://localhost:3306/quiz";
        String password = "root";
        String username = "root";

        conn = DriverManager.getConnection(url, username, password);
        System.out.println("Conectado com sucesso!");
        return conn;
    }
    
}
