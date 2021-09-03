package Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.VO.ClienteVO;

public class ClienteDAO extends BaseDAO {
  
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
      pdst.execute();

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

  public void removerByNome(ClienteVO vo) {
    conn = getConnection();
    String sql = "DELETE FROM cliente WHERE nome = ?";
    PreparedStatement pdst;
   
    try {
      pdst = conn.prepareStatement(sql);
      pdst.setString(1, vo.getNome());
      pdst.executeUpdate();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void removerByEndereco(ClienteVO vo) {
    conn = getConnection();
    String sql = "DELETE FROM cliente WHERE endereco = ?";
    PreparedStatement pdst;
   
    try {
      pdst = conn.prepareStatement(sql);
      pdst.setString(1, vo.getEndereco());
      pdst.executeUpdate();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void removerByCPF(ClienteVO vo) {
    conn = getConnection();
    String sql = "DELETE FROM cliente WHERE cpf = ?";
    PreparedStatement pdst;
   
    try {
      pdst = conn.prepareStatement(sql);
      pdst.setString(1, vo.getCPF());
      pdst.executeUpdate();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } 
  }

  //Listagem
  public List<ClienteVO> listar() {
    conn = getConnection();
    String sql = "SELECT * FROM cliente";
    Statement st;
    ResultSet rs;
    List<ClienteVO> clientes = new ArrayList<ClienteVO>();
    try {
      st = conn.createStatement();
      rs = st.executeQuery(sql);

      while (rs.next()) {
        ClienteVO cvo = new ClienteVO();
        cvo.setId(rs.getLong("id"));
        cvo.setNome(rs.getString("nome"));
        cvo.setEndereco(rs.getString("endereco"));
        cvo.setCPF(rs.getString("cpf"));
        clientes.add(cvo);

      }
    } catch (SQLException e) {
      //TODO: handle exception
      e.printStackTrace();
    }

    return clientes;
  }

  //Alteração
  public void editarByNome(ClienteVO vo) {
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

  public void editarByEndereco(ClienteVO vo) {
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

  public void editarByCPF(ClienteVO vo) {
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
