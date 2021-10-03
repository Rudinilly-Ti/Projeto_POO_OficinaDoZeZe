package Model.BO;

import java.sql.SQLException;
import java.util.List;

public interface baseInterBO<VO> {
  public void criar(VO entity) throws SQLException;
  public VO buscar (VO entity) throws SQLException;
  public List<VO> listar(VO entity) throws SQLException;
  public void deletar(VO entity) throws SQLException;
}
