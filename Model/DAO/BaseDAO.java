package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDAO<VO> implements BaseInterDAO<VO>{
    Connection conn = null;
    String url = "jdbc:postgresql://localhost:5432/oficina";
    String user = "Zeze2021";
    String senha = "oficina2021";
    
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

    public void closeConnection() {
        if (conn != null) {
            try {
               conn.close(); 
            } catch (SQLException e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }
    }

    public abstract void inserir(VO entity) throws SQLException;
    public abstract void removerById(VO entity) throws SQLException;
    public abstract ResultSet listar() throws SQLException;
    public abstract ResultSet findById(VO entity)  throws SQLException;

}

