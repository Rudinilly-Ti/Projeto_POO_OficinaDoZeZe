package Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.VO.UsuarioVO;

public class UsuarioDAO<VO extends UsuarioVO> extends BaseDAO<VO> {
  //Inserção
  public void inserir(VO vo) throws SQLException {
    conn = getConnection();
    String sql = "INSERT INTO usuario (login,senha) VALUES (?,?)";
    PreparedStatement pdst;

    try {
      pdst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      pdst.setString(1, vo.getLogin());
      pdst.setString(2, vo.getSenha());
      int affectedRows = pdst.executeUpdate();

      if (affectedRows == 0 ) {
        throw new SQLException("A inserção falhou. Nenhuma linha alterada.");
      }
      ResultSet generatedKeys = pdst.getGeneratedKeys();
      if (generatedKeys.next()) {
          vo.setId(generatedKeys.getLong(1));
      } else {
        throw new SQLException("A inserção falhou. Nenhum id retornado.");
      } 

    } catch (SQLException e) {
      //TODO: handle exception
      e.printStackTrace();
    }
  }

    //Remoção
    public void removerById(VO vo) {
      conn = getConnection();
      String sql = "DELETE FROM usuario WHERE id = ?";
      PreparedStatement pdst;
     
      try {
        pdst = conn.prepareStatement(sql);
        pdst.setLong(1, vo.getId());
        pdst.executeUpdate();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  
    // public void removerByLogin(UsuarioVO vo) {
    //   conn = getConnection();
    //   String sql = "DELETE FROM usuario WHERE login = ?";
    //   PreparedStatement pdst;
     
    //   try {
    //     pdst = conn.prepareStatement(sql);
    //     pdst.setString(1, vo.getLogin());
    //     pdst.executeUpdate();
    //   } catch (SQLException e) {
    //     // TODO Auto-generated catch block
    //     e.printStackTrace();
    //   }
    // }
  
    // public void removerBySenha(UsuarioVO vo) {
    //   conn = getConnection();
    //   String sql = "DELETE FROM usuario WHERE senha = ?";
    //   PreparedStatement pdst;
     
    //   try {
    //     pdst = conn.prepareStatement(sql);
    //     pdst.setString(1, vo.getSenha());
    //     pdst.executeUpdate();
    //   } catch (SQLException e) {
    //     // TODO Auto-generated catch block
    //     e.printStackTrace();
    //   }
    // }
  
    // public void removerByCargo(UsuarioVO vo) {
    //   conn = getConnection();
    //   String sql = "DELETE FROM usuario WHERE cargo = ?";
    //   PreparedStatement pdst;
     
    //   try {
    //     pdst = conn.prepareStatement(sql);
    //     pdst.setString(1, vo.getCargo());
    //     pdst.executeUpdate();
    //   } catch (SQLException e) {
    //     // TODO Auto-generated catch block
    //     e.printStackTrace();
    //   } 
    // }
  
    //Listagem
  public ResultSet listar() {
    conn = getConnection();
    String sql = "SELECT * FROM usuario";
    Statement st;
    ResultSet rs = null;
    try {
      st = conn.createStatement();
      rs = st.executeQuery(sql);

    } catch (SQLException e) {
      //TODO: handle exception
      e.printStackTrace();
    }

    return rs;
  }

  public ResultSet findById(VO vo) {
    conn = getConnection();
    String sql = "SELECT * FROM usuario WHERE id = ?";
    PreparedStatement pdst;
    ResultSet rs = null;
    try {
      pdst = conn.prepareStatement(sql);
      pdst.setLong(1, vo.getId());
      rs = pdst.executeQuery();
      
    } catch (SQLException e) {
      //TODO: handle exception
      e.printStackTrace();
    }

    return rs;
  }

  public ResultSet findByLogin(VO vo) {
    conn = getConnection();
    String sql = "SELECT * FROM usuario WHERE login = ?";
    PreparedStatement pdst;
    ResultSet rs = null;
    try {
      pdst = conn.prepareStatement(sql);
      pdst.setString(1, vo.getLogin());
      rs = pdst.executeQuery();
     
    } catch (SQLException e) {
      //TODO: handle exception
      e.printStackTrace();
    }

    return rs;
  }

  //Alteração
  public void editarLogin(VO vo) {
    conn = getConnection();
    String sql = "UPDATE usuario SET login = ? WHERE id = ?";
    PreparedStatement pdst;
    try {
      pdst = conn.prepareStatement(sql);
      pdst.setString(1, vo.getLogin());
      pdst.setLong(2, vo.getId());
      pdst.executeUpdate();
    } catch ( SQLException e) {
      //TODO: handle exception
      e.printStackTrace();
    }
  }

  public void editarSenha(VO vo) {
    conn = getConnection();
    String sql = "UPDATE usuario SET senha = ? WHERE id = ?";
    PreparedStatement pdst;
    try {
      pdst = conn.prepareStatement(sql);
      pdst.setString(1, vo.getSenha());
      pdst.setLong(2, vo.getId());
      pdst.executeUpdate();
    } catch ( SQLException e) {
      //TODO: handle exception
      e.printStackTrace();
    }
  }
}
