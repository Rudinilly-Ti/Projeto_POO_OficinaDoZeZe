package Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Model.VO.ServicosNoOrcamentoVO;

public class ServicosNoOrcamentoDAO extends BaseDAO<ServicosNoOrcamentoVO>{
    
    //Inserção
    public void inserir(ServicosNoOrcamentoVO vo) throws SQLException{
        conn = getConnection();
        String sql = "insert into ServicosNoOrcamento (id_servico,id_orcamento,valor,quantidade) values (?,?,?,?)";
        PreparedStatement pdst;

        pdst = conn.prepareStatement(sql);
        pdst.setLong(1, vo.getServico().getId());
        pdst.setLong(2, vo.getOrcamento().getId());
        pdst.setDouble(3, vo.getValor());
        pdst.setInt(4, vo.getQuantidade());
        pdst.execute();
    }

    //Remoção
    public void removerById(ServicosNoOrcamentoVO vo) throws SQLException{
        conn = getConnection();
        String sql = "delete from ServicosNoOrcamento where id = ?";
        PreparedStatement pdst;
     
        pdst = conn.prepareStatement(sql);
        pdst.setLong(1, vo.getId());
        pdst.executeUpdate();
    }

    public void removerByOrcamentoId(ServicosNoOrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "delete from ServicosNoOrcamento where id_orcamento = ?";
        PreparedStatement pdst;
 
        pdst = conn.prepareStatement(sql);
        pdst.setLong(1, vo.getOrcamento().getId());
        pdst.executeUpdate();
    }

    //Listagem
    public ResultSet listar() throws SQLException{
        conn = getConnection();
        String sql = "select * from ServicosNoOrcamento";
        Statement st;
        ResultSet rs = null;
      
        st = conn.createStatement();
        rs = st.executeQuery(sql);
           
        return rs;
    }

    public ResultSet findByValor(ServicosNoOrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "select * from ServicosNoOrcamento where valor = ?";
        PreparedStatement pdst;
        ResultSet rs = null;

        pdst = conn.prepareStatement(sql);
        pdst.setDouble(1, vo.getValor());
        rs = pdst.executeQuery();
        
        return rs;
    }

    public ResultSet findByQuantidade(ServicosNoOrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "select * from ServicosNoOrcamento where quantidade = ?";
        PreparedStatement pdst;
        ResultSet rs = null;
      
        pdst = conn.prepareStatement(sql);
        pdst.setInt(1, vo.getQuantidade());
        rs = pdst.executeQuery();
         
        return rs;
    }

    public ResultSet findByServicoId(ServicosNoOrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "select * from ServicosNoOrcamento where id_servico = ?";
        PreparedStatement pdst;
        ResultSet rs = null;
        
        pdst = conn.prepareStatement(sql);
        pdst.setLong(1, vo.getServico().getId());
        rs = pdst.executeQuery();
        
        return rs;
    }

    public ResultSet findByOrcamentoId(ServicosNoOrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "select * from ServicosNoOrcamento where id_orcamento = ?";
        PreparedStatement pdst;
        ResultSet rs = null;
        
        pdst = conn.prepareStatement(sql);
        pdst.setLong(1, vo.getOrcamento().getId());
        rs = pdst.executeQuery();

        return rs;
    }

    public ResultSet findById(ServicosNoOrcamentoVO vo) throws SQLException{
        conn = getConnection();
        String sql = "select * from ServicosNoOrcamento where id = ?";
        PreparedStatement pdst;
        ResultSet rs = null;
     
        pdst = conn.prepareStatement(sql);
        pdst.setLong(1, vo.getId());
        rs = pdst.executeQuery();
       
        return rs;
    }

    //Alteração
    public void editarValor(ServicosNoOrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "update ServicosNoOrcamento set valor = ? where id = ?";
        PreparedStatement pdst;
      
        pdst = conn.prepareStatement(sql);
        pdst.setDouble(1, vo.getValor());
        pdst.setLong(2, vo.getId());
        pdst.executeUpdate();
        
    }
    public void editarQuantidade(ServicosNoOrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "update ServicosNoOrcamento set quantidade = ? where id = ?";
        PreparedStatement pdst;
      
        pdst = conn.prepareStatement(sql);
        pdst.setInt(1, vo.getQuantidade());
        pdst.setLong(2, vo.getId());
        pdst.executeUpdate();
    }
    public void editarServicoId(ServicosNoOrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "update ServicosNoOrcamento set id_servico = ? where id = ?";
        PreparedStatement pdst;
     
        pdst = conn.prepareStatement(sql);
        pdst.setLong(1, vo.getServico().getId());
        pdst.setLong(2, vo.getId());
        pdst.executeUpdate();
    }

    public void editarOrcamentoId(ServicosNoOrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "update ServicosNoOrcamento set id_orcamento = ? where id = ?";
        PreparedStatement pdst;
       
        pdst = conn.prepareStatement(sql);
        pdst.setLong(1, vo.getOrcamento().getId());
        pdst.setLong(2, vo.getId());
        pdst.executeUpdate();
    }
}
