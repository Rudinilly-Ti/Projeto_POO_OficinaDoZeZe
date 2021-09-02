package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
    Connection conn = null;
    String url = "jdbc:postgresql://localhost:5432/oficina";
    String user = "postgres";
    String senha = "pedro2356";
    
    public Connection getConnection(){
        if(conn == null){
            try {
                conn = DriverManager.getConnection(url, user, senha);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return conn;
        }
        else return conn;
    }
}
