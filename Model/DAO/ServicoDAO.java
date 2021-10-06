package Model.DAO;

import Model.VO.ServicoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServicoDAO extends BaseDAO<ServicoVO>{
    
    // ----- Inserir ------
    public void inserir(ServicoVO servico){

        Connection conn = getConnection();
        String sql = "insert into Servico (nome, preco) values (?, ?)";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setString(1, servico.getNome());
            ptst.setDouble(2, servico.getPreco());
            ptst.execute();
        } catch (SQLException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    // ---- Remover -----
    public void removerById(ServicoVO servico){

        Connection conn = getConnection();
        String sql = "delete from Servico where id = ?";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setLong(1, servico.getId());
            ptst.executeUpdate();
        } catch (SQLException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    // public void removerByName(ServicoVO servico){
        
    //     Connection conn = getConnection();
    //     String sql = "delete from Servico where nome = ?";
    //     PreparedStatement ptst;

    //     try{
            
    //         ptst = conn.prepareStatement(sql);
    //         ptst.setString(1, servico.getNome());
    //         ptst.executeUpdate();
    //     } catch (SQLException e){
    //         e.printStackTrace();
    //     }
    // }

    // public void removerByPrice(ServicoVO servico){

    //     Connection conn = getConnection();
    //     String sql = "delete from Servico where preco = ?";
    //     PreparedStatement ptst;

    //     try {
    //         ptst = conn.prepareStatement(sql);
    //         ptst.setDouble(1, servico.getPreco());
    //         ptst.executeUpdate();
    //     } catch (SQLException e) {
    //         //TODO: handle exception
    //         e.printStackTrace();
    //     }
    // }

    // ----- Listar ------
    public ResultSet listar(){
        Connection conn = getConnection();
        String sql = "select * from Servico";
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

    public ResultSet findById(ServicoVO vo){
        Connection conn = getConnection();
        String sql = "select * from Servico where id = ?";
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

    public ResultSet findByNome(ServicoVO vo){
        Connection conn = getConnection();
        String sql = "select * from Servico where nome = ?";
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

    public ResultSet findByPreco(ServicoVO vo){
        Connection conn = getConnection();
        String sql = "select * from Servico where preco = ?";
        PreparedStatement pdst;
        ResultSet rs = null;
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setDouble(1, vo.getPreco());
            rs = pdst.executeQuery();
        } catch (SQLException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        return rs;
    }

    // ------ editar -------
    public void editarNomeById(ServicoVO servico){

        Connection conn = getConnection();
        String sql = "update Servico set nome = ? where id = ?";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setString(1, servico.getNome());
            ptst.setLong(2, servico.getId());
            ptst.executeUpdate();
        } catch (SQLException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
    
    public void editarPrecoById(ServicoVO servico){
        
        Connection conn = getConnection();
        String sql = "update Servico set preco = ? where id = ?";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setDouble(1, servico.getPreco());
            ptst.setLong(2, servico.getId());
            ptst.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
