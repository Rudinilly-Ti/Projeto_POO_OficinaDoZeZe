package Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.VO.UsuarioVO;

public class UsuarioDAO extends BaseDAO {
  //Inserção
  public void inserir(UsuarioVO vo) {
    conn = getConnection();
    String sql = "INSERT INTO usuario (login,senha,cargo) VALUES (?,?,?)";
    PreparedStatement pdst;

    try {
      pdst = conn.prepareStatement(sql);
      pdst.setString(1, vo.getLogin());
      pdst.setString(2, vo.getSenha());
      pdst.setString(3, vo.getCargo());
      pdst.execute();

    } catch (SQLException e) {
      //TODO: handle exception
      e.printStackTrace();
    }
  }

    //Remoção
    public void removerById(UsuarioVO vo) {
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
  
    public void removerByLogin(UsuarioVO vo) {
      conn = getConnection();
      String sql = "DELETE FROM usuario WHERE login = ?";
      PreparedStatement pdst;
     
      try {
        pdst = conn.prepareStatement(sql);
        pdst.setString(1, vo.getLogin());
        pdst.executeUpdate();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  
    public void removerBySenha(UsuarioVO vo) {
      conn = getConnection();
      String sql = "DELETE FROM usuario WHERE senha = ?";
      PreparedStatement pdst;
     
      try {
        pdst = conn.prepareStatement(sql);
        pdst.setString(1, vo.getSenha());
        pdst.executeUpdate();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  
    public void removerByCargo(UsuarioVO vo) {
      conn = getConnection();
      String sql = "DELETE FROM usuario WHERE cargo = ?";
      PreparedStatement pdst;
     
      try {
        pdst = conn.prepareStatement(sql);
        pdst.setString(1, vo.getCargo());
        pdst.executeUpdate();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } 
    }
  
    //Listagem
  public List<UsuarioVO> listar() {
    conn = getConnection();
    String sql = "SELECT * FROM usuario";
    Statement st;
    ResultSet rs;
    List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
    try {
      st = conn.createStatement();
      rs = st.executeQuery(sql);

      while (rs.next()) {
        UsuarioVO uvo = new UsuarioVO();
        uvo.setId(rs.getLong("id"));
        uvo.setLogin(rs.getString("login"));
        uvo.setSenha(rs.getString("senha"));
        uvo.setCargo(rs.getString("cargo"));
        usuarios.add(uvo);

      }
    } catch (SQLException e) {
      //TODO: handle exception
      e.printStackTrace();
    }

    return usuarios;
  }

  //Alteração
  public void editarByLogin(UsuarioVO vo) {
    conn = getConnection();
    String sql = "UPDATE usuario SET login = ? WHERE id = ?";
    PreparedStatement pdst;
    try {
      pdst = conn.prepareStatement(sql);
      pdst.setString(1, vo.getLogin());
      pdst.setLong(2, vo.getId());
    } catch ( SQLException e) {
      //TODO: handle exception
      e.printStackTrace();
    }
  }

  public void editarBySenha(UsuarioVO vo) {
    conn = getConnection();
    String sql = "UPDATE usuario SET senha = ? WHERE id = ?";
    PreparedStatement pdst;
    try {
      pdst = conn.prepareStatement(sql);
      pdst.setString(1, vo.getSenha());
      pdst.setLong(2, vo.getId());
    } catch ( SQLException e) {
      //TODO: handle exception
      e.printStackTrace();
    }
  }

  public void editarByCargo(UsuarioVO vo) {
    conn = getConnection();
    String sql = "UPDATE usuario SET cargo = ? WHERE id = ?";
    PreparedStatement pdst;
    try {
      pdst = conn.prepareStatement(sql);
      pdst.setString(1, vo.getCargo());
      pdst.setLong(2, vo.getId());
    } catch ( SQLException e) {
      //TODO: handle exception
      e.printStackTrace();
    }
  }
}
