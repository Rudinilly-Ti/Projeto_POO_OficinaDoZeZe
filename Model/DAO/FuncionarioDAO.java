package Model.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import Model.VO.FuncionarioVO;

public class FuncionarioDAO extends UsuarioDAO<FuncionarioVO>{
 
  public void inserir(FuncionarioVO vo) {
    try {
      super.inserir(vo);
      String sql = "INSERT INTO funcionario (id_usuario, salario, data_admissao) VALUES (?, ?, ?)";
      PreparedStatement pdst;
      Date admissao = new Date(vo.getDataDeAdmissao().getTimeInMillis());
      pdst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      pdst.setLong(1, vo.getId());
      pdst.setDouble(2, vo.getSalario());
      pdst.setDate(3, admissao);
      int affectedRows = pdst.executeUpdate();

      if (affectedRows == 0 ) {
        throw new SQLException("A inserção falhou. Nenhuma linha alterada.");
      }
    } catch (Exception e) {
      //TODO: handle exception
    }
  }
}
