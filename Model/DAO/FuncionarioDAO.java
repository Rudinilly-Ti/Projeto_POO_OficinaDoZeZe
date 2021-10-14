package Model.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

  //Listagem
  public ResultSet findByDataAdmissao(FuncionarioVO vo){
    conn = getConnection();
    String sql = "select * from funcionario where data_admissao = ?";
    PreparedStatement pdst;
    ResultSet rs = null;
    java.sql.Date DateAdm = new java.sql.Date(vo.getDataDeAdmissao().getTimeInMillis());
    try {
        pdst = conn.prepareStatement(sql);
        pdst.setDate(1, DateAdm);
        rs = pdst.executeQuery();
        
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return rs;
  }

  public ResultSet findBySalario(FuncionarioVO vo){
    conn = getConnection();
    String sql = "select * from funcionario where salario = ?";
    PreparedStatement pdst;
    ResultSet rs = null;
    try {
        super.findById(vo);
        pdst = conn.prepareStatement(sql);
        pdst.setDouble(1, vo.getSalario());
        rs = pdst.executeQuery();
        
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return rs;
  }

  public ResultSet findByIdUsuario(FuncionarioVO vo){
    conn = getConnection();
    String sql = "select * from funcionario where id_usuario = ?";
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

  //Alteração
  public void editarSalario(FuncionarioVO vo)  {
    conn = getConnection();
    String sql = "UPDATE funcionario SET salario = ? WHERE id_usuario = ?";
    PreparedStatement pdst;
    try {
      pdst = conn.prepareStatement(sql);
      pdst.setDouble(1, vo.getSalario());
      pdst.setLong(2, vo.getId());
      pdst.executeUpdate();
    } catch ( SQLException e) {
      //TODO: handle exception
      e.printStackTrace();
    }
  }
  public void editarDataAdmissao(FuncionarioVO vo) {
    conn = getConnection();
    String sql = "UPDATE funcionario SET data_admissao = ? WHERE id_usuario = ?";
    PreparedStatement pdst;
    java.sql.Date DataAdm = new java.sql.Date(vo.getDataDeAdmissao().getTimeInMillis());
    try {
      pdst = conn.prepareStatement(sql);
      pdst.setDate(1, DataAdm);
      pdst.setLong(2, vo.getId());
      pdst.executeUpdate();
    } catch ( SQLException e) {
      //TODO: handle exception
      e.printStackTrace();
    }
  }
}
