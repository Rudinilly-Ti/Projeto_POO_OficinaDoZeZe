package Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.VO.PecasNoOrcamentoVO;

public class PecasNoOrcamentoDAO extends BaseDAO<PecasNoOrcamentoVO>{
    
    //Inserção
    public void inserir(PecasNoOrcamentoVO vo) throws SQLException{
        conn = getConnection();
        String sql = "insert into PecasNoOrcamento (id_peca,id_orcamento,valor,quantidade) values (?,?,?,?)";
        PreparedStatement pdst;

        pdst = conn.prepareStatement(sql);
        pdst.setLong(1, vo.getPeca().getId());
        pdst.setLong(2, vo.getOrcamento().getId());
        pdst.setDouble(3, vo.getValor());
        pdst.setInt(4, vo.getQuantidade());
        pdst.execute();
    }

    //Remoção
    public void removerById(PecasNoOrcamentoVO vo) throws SQLException{
        conn = getConnection();
        String sql = "delete from PecasNoOrcamento where id = ?";
        PreparedStatement pdst;

        pdst = conn.prepareStatement(sql);
        pdst.setLong(1, vo.getId());
        pdst.executeUpdate();
    }

    public void removerByOrcamentoId(PecasNoOrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "delete from PecasNoOrcamento where id_orcamento = ?";
        PreparedStatement pdst;

        pdst = conn.prepareStatement(sql);
        pdst.setLong(1, vo.getOrcamento().getId());
        pdst.executeUpdate();
    }

    //Listagem
    public ResultSet listar() throws SQLException{
        conn = getConnection();
        String sql = "select * from PecasNoOrcamento";
        Statement st;
        ResultSet rs = null;
        st = conn.createStatement();
        rs = st.executeQuery(sql);
         
        return rs;
    }

    public ResultSet findByValor(PecasNoOrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "select * from PecasNoOrcamento where valor = ?";
        PreparedStatement pdst;
        ResultSet rs = null;

        pdst = conn.prepareStatement(sql);
        pdst.setDouble(1, vo.getValor());
        rs = pdst.executeQuery();
       
        return rs;
    }

    public ResultSet findByQuantidade(PecasNoOrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "select * from PecasNoOrcamento where quantidade = ?";
        PreparedStatement pdst;
        ResultSet rs = null;

        pdst = conn.prepareStatement(sql);
        pdst.setInt(1, vo.getQuantidade());
        rs = pdst.executeQuery();
           
        return rs;
    }

    public ResultSet findByPecaId(PecasNoOrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "select * from PecasNoOrcamento where id_peca = ?";
        PreparedStatement pdst;
        ResultSet rs = null;

        pdst = conn.prepareStatement(sql);
        pdst.setLong(1, vo.getPeca().getId());
        rs = pdst.executeQuery();
        
        return rs;
    }

    public ResultSet findByOrcamentoId(PecasNoOrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "select * from PecasNoOrcamento where id_orcamento = ?";
        PreparedStatement pdst;
        ResultSet rs = null;

        pdst = conn.prepareStatement(sql);
        pdst.setLong(1, vo.getOrcamento().getId());
        rs = pdst.executeQuery();
        
        return rs;
    }

    public ResultSet findById(PecasNoOrcamentoVO vo) throws SQLException{
        conn = getConnection();
        String sql = "select * from PecasNoOrcamento where id = ?";
        PreparedStatement pdst;
        ResultSet rs = null;

        pdst = conn.prepareStatement(sql);
        pdst.setLong(1, vo.getId());
        rs = pdst.executeQuery();
           
        return rs;
    }

    //Alteração
    public void editarValor(PecasNoOrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "update PecasNoOrcamento set valor = ? where id = ?";
        PreparedStatement pdst;

        pdst = conn.prepareStatement(sql);
        pdst.setDouble(1, vo.getValor());
        pdst.setLong(2, vo.getId());
        pdst.executeUpdate();
    }

    public void editarQuantidade(PecasNoOrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "update PecasNoOrcamento set quantidade = ? where id = ?";
        PreparedStatement pdst;

        pdst = conn.prepareStatement(sql);
        pdst.setInt(1, vo.getQuantidade());
        pdst.setLong(2, vo.getId());
        pdst.executeUpdate();
    }

    public void editarPecaId(PecasNoOrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "update PecasNoOrcamento set id_peca = ? where id = ?";
        PreparedStatement pdst;
        
        pdst = conn.prepareStatement(sql);
        pdst.setLong(1, vo.getPeca().getId());
        pdst.setLong(2, vo.getId());
        pdst.executeUpdate();
    }

    public void editarOrcamentoId(PecasNoOrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "update PecasNoOrcamento set id_orcamento = ? where id = ?";
        PreparedStatement pdst;
 
        pdst = conn.prepareStatement(sql);
        pdst.setLong(1, vo.getOrcamento().getId());
        pdst.setLong(2, vo.getId());
        pdst.executeUpdate();

    }
}
