package Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.VO.ClienteVO;

public class ClienteDAO extends BaseDAO<ClienteVO> {
  
  //Inserção
  public void inserir(ClienteVO vo) {
    conn = getConnection();
    String sql = "INSERT INTO cliente (nome,endereco,cpf) VALUES (?,?,?)";
    PreparedStatement pdst;

    try {
      pdst = conn.prepareStatement(sql);
      pdst.setString(1, vo.getNome());
      pdst.setString(2, vo.getEndereco());
      pdst.setString(3, vo.getCPF());
      int affectedRows = pdst.executeUpdate();

      if (affectedRows == 0) {
        throw new SQLException("A inserção falhou, nenhuma linha foi alterada");
      }
    } catch (SQLException e) {
      //TODO: handle exception
      e.printStackTrace();
    }
  }

  //Remoção
  public void removerById(ClienteVO vo) {
    conn = getConnection();
    String sql = "DELETE FROM cliente WHERE id = ?";
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

  // public void removerByNome(ClienteVO vo) {
  //   conn = getConnection();
  //   String sql = "DELETE FROM cliente WHERE nome = ?";
  //   PreparedStatement pdst;
   
  //   try {
  //     pdst = conn.prepareStatement(sql);
  //     pdst.setString(1, vo.getNome());
  //     pdst.executeUpdate();
  //   } catch (SQLException e) {
  //     // TODO Auto-generated catch block
  //     e.printStackTrace();
  //   }
  // }

  // public void removerByEndereco(ClienteVO vo) {
  //   conn = getConnection();
  //   String sql = "DELETE FROM cliente WHERE endereco = ?";
  //   PreparedStatement pdst;
   
  //   try {
  //     pdst = conn.prepareStatement(sql);
  //     pdst.setString(1, vo.getEndereco());
  //     pdst.executeUpdate();
  //   } catch (SQLException e) {
  //     // TODO Auto-generated catch block
  //     e.printStackTrace();
  //   }
  // }

  // public void removerByCPF(ClienteVO vo) {
  //   conn = getConnection();
  //   String sql = "DELETE FROM cliente WHERE cpf = ?";
  //   PreparedStatement pdst;
   
  //   try {
  //     pdst = conn.prepareStatement(sql);
  //     pdst.setString(1, vo.getCPF());
  //     pdst.executeUpdate();
  //   } catch (SQLException e) {
  //     // TODO Auto-generated catch block
  //     e.printStackTrace();
  //   } 
  // }

  //Listagem
  public ResultSet listar() {
    conn = getConnection();
    String sql = "SELECT * FROM cliente";
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

  public ResultSet findById(ClienteVO vo) {
    conn = getConnection();
    String sql = "SELECT * FROM cliente WHERE id = ?";
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

  public ResultSet findByNome(ClienteVO vo) {
    conn = getConnection();
    String sql = "SELECT * FROM cliente WHERE nome = ?";
    PreparedStatement pdst;
    ResultSet rs = null;
    try {
      pdst = conn.prepareStatement(sql);
      pdst.setString(1, vo.getNome());
      rs = pdst.executeQuery();
    } catch (SQLException e) {
      //TODO: handle exception
      e.printStackTrace();
    }

    return rs;
  }

  public ResultSet findByEndereco(ClienteVO vo) {
    conn = getConnection();
    String sql = "SELECT * FROM cliente WHERE endereco = ?";
    PreparedStatement pdst;
    ResultSet rs = null;
    try {
      pdst = conn.prepareStatement(sql);
      pdst.setString(1, vo.getEndereco());
      rs = pdst.executeQuery();

    } catch (SQLException e) {
      //TODO: handle exception
      e.printStackTrace();
    }

    return rs;
  }

  public ResultSet findByCPF(ClienteVO vo) {
    conn = getConnection();
    String sql = "SELECT * FROM cliente WHERE cpf = ?";
    PreparedStatement pdst;
    ResultSet rs = null;
    try {
      pdst = conn.prepareStatement(sql);
      pdst.setString(1, vo.getCPF());
      rs = pdst.executeQuery();

    } catch (SQLException e) {
      //TODO: handle exception
      e.printStackTrace();
    }

    return rs;
  }

  //Alteração
  public void editarNome(ClienteVO vo) {
    conn = getConnection();
    String sql = "UPDATE cliente SET nome = ? WHERE id = ?";
    PreparedStatement pdst;
    try {
      pdst = conn.prepareStatement(sql);
      pdst.setString(1, vo.getNome());
      pdst.setLong(2, vo.getId());
    } catch ( SQLException e) {
      //TODO: handle exception
      e.printStackTrace();
    }
  }

  public void editarEndereco(ClienteVO vo) {
    conn = getConnection();
    String sql = "UPDATE cliente SET endereco = ? WHERE id = ?";
    PreparedStatement pdst;
    try {
      pdst = conn.prepareStatement(sql);
      pdst.setString(1, vo.getEndereco());
      pdst.setLong(2, vo.getId());
    } catch ( SQLException e) {
      //TODO: handle exception
      e.printStackTrace();
    }
  }

  public void editarCPF(ClienteVO vo) {
    conn = getConnection();
    String sql = "UPDATE cliente SET cpf = ? WHERE id = ?";
    PreparedStatement pdst;
    try {
      pdst = conn.prepareStatement(sql);
      pdst.setString(1, vo.getCPF());
      pdst.setLong(2, vo.getId());
    } catch ( SQLException e) {
      //TODO: handle exception
      e.printStackTrace();
    }
  }
}
