package Model.DAO;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
  public ResultSet findByIdUsuario(ChefeVO vo){
    conn = getConnection();
    String sql = "select * from chefe where id_usuario = ?";
    PreparedStatement pdst;
    ResultSet rs = null;
    try {
        pdst = conn.prepareStatement(sql);
        pdst.setLong(1, vo.getId());
        rs = pdst.executeQuery();
        
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return rs;
  }
  
}
