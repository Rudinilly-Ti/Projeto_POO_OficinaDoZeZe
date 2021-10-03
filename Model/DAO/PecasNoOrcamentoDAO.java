package Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.VO.PecasNoOrcamentoVO;

public class PecasNoOrcamentoDAO extends BaseDAO<PecasNoOrcamentoVO>{
    
    //Inserção
    public void inserir(PecasNoOrcamentoVO vo){
        conn = getConnection();
        String sql = "insert into PecasNoOrcamento (id_peca,id_orcamento,valor,quantidade) values (?,?,?,?)";
        PreparedStatement pdst;
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setLong(1, vo.getPeca().getId());
            pdst.setLong(2, vo.getOrcamento().getId());
            pdst.setDouble(3, vo.getValor());
            pdst.setInt(4, vo.getQuantidade());
            pdst.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //Remoção
    public void removerById(PecasNoOrcamentoVO vo){
        conn = getConnection();
        String sql = "delete from PecasNoOrcamento where id = ?";
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

    public void removerByOrcamentoId(PecasNoOrcamentoVO vo){
        conn = getConnection();
        String sql = "delete from PecasNoOrcamento where id_orcamento = ?";
        PreparedStatement pdst;
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setLong(1, vo.getOrcamento().getId());
            pdst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //Listagem
    public ResultSet listar(){
        conn = getConnection();
        String sql = "select * from PecasNoOrcamento";
        Statement st;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet findByValor(PecasNoOrcamentoVO vo){
        conn = getConnection();
        String sql = "select * from PecasNoOrcamento where valor = ?";
        PreparedStatement pdst;
        ResultSet rs = null;
        
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setDouble(1, vo.getValor());
            rs = pdst.executeQuery();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet findByQuantidade(PecasNoOrcamentoVO vo){
        conn = getConnection();
        String sql = "select * from PecasNoOrcamento where quantidade = ?";
        PreparedStatement pdst;
        ResultSet rs = null;
        
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setInt(1, vo.getQuantidade());
            rs = pdst.executeQuery();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet findByPecaId(PecasNoOrcamentoVO vo){
        conn = getConnection();
        String sql = "select * from PecasNoOrcamento where id_peca = ?";
        PreparedStatement pdst;
        ResultSet rs = null;
        
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setLong(1, vo.getPeca().getId());
            rs = pdst.executeQuery();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet findByOrcamentoId(PecasNoOrcamentoVO vo){
        conn = getConnection();
        String sql = "select * from PecasNoOrcamento where id_orcamento = ?";
        PreparedStatement pdst;
        ResultSet rs = null;
        
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setLong(1, vo.getOrcamento().getId());
            rs = pdst.executeQuery();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet findById(PecasNoOrcamentoVO vo){
        conn = getConnection();
        String sql = "select * from PecasNoOrcamento where id = ?";
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
    public void editarValor(PecasNoOrcamentoVO vo){
        conn = getConnection();
        String sql = "update PecasNoOrcamento set valor = ? where id = ?";
        PreparedStatement pdst;
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setDouble(1, vo.getValor());
            pdst.setLong(2, vo.getId());
            pdst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void editarQuantidade(PecasNoOrcamentoVO vo){
        conn = getConnection();
        String sql = "update PecasNoOrcamento set quantidade = ? where id = ?";
        PreparedStatement pdst;
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setInt(1, vo.getQuantidade());
            pdst.setLong(2, vo.getId());
            pdst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void editarPecaId(PecasNoOrcamentoVO vo){
        conn = getConnection();
        String sql = "update PecasNoOrcamento set id_peca = ? where id = ?";
        PreparedStatement pdst;
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setLong(1, vo.getPeca().getId());
            pdst.setLong(2, vo.getId());
            pdst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void editarOrcamentoId(PecasNoOrcamentoVO vo){
        conn = getConnection();
        String sql = "update PecasNoOrcamento set id_orcamento = ? where id = ?";
        PreparedStatement pdst;
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setLong(1, vo.getOrcamento().getId());
            pdst.setLong(2, vo.getId());
            pdst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
