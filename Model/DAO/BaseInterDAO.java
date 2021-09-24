package Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BaseInterDAO <VO>{
  public void inserir(VO entity) throws SQLException;
  public void removerById(VO entity) throws SQLException;
  public ResultSet listar() throws SQLException;
  public ResultSet findById(VO entity)  throws SQLException;
}
