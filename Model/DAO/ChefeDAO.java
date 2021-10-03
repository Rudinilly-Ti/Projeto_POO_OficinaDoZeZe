package Model.DAO;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.VO.ChefeVO;

public class ChefeDAO extends UsuarioDAO<ChefeVO> {
  
  public void inserir(ChefeVO vo) {
    try {
      super.inserir(vo);
      String sql = "INSERT INTO chefe (id_usuario) VALUES (?)";
      PreparedStatement pdst;
      pdst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      pdst.setLong(1, vo.getId());
      int affectedRows = pdst.executeUpdate();

      if (affectedRows == 0 ) {
        throw new SQLException("A inserção falhou. Nenhuma linha alterada.");
      }
    } catch (Exception e) {
      //TODO: handle exception
    }
  }
  
}
