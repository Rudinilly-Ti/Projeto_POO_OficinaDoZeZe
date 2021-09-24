package Model.DAO;

import Model.VO.PecaVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PecaDAO extends BaseDAO<PecaVO>{
    
    //Inserção
    public void inserir(PecaVO vo){
        conn = getConnection();
        String sql = "insert into Peca (nome,preco,fabricante) values (?,?,?)";
        PreparedStatement pdst;
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setString(1, vo.getNome());
            pdst.setDouble(2, vo.getPreco());
            pdst.setString(3, vo.getFabricante());
            pdst.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //Remoção
    public void removerById(PecaVO vo){
        conn = getConnection();
        String sql = "delete from Peca where id = ?";
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
    // public void removerByNome(PecaVO vo){
    //     conn = getConnection();
    //     String sql = "delete from Peca where nome = ?";
    //     PreparedStatement pdst;
    //     try {
    //         pdst = conn.prepareStatement(sql);
    //         pdst.setString(1, vo.getNome());
    //         pdst.executeUpdate();
    //     } catch (SQLException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }
    // }

    // public void removerByPreco(PecaVO vo){
    //     conn = getConnection();
    //     String sql = "delete from Peca where preco = ?";
    //     PreparedStatement pdst;
    //     try {
    //         pdst = conn.prepareStatement(sql);
    //         pdst.setDouble(1, vo.getPreco());
    //         pdst.executeUpdate();
    //     } catch (SQLException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }
    // }
    // public void removerByFabricante(PecaVO vo){
    //     conn = getConnection();
    //     String sql = "delete from Peca where fabricante = ?";
    //     PreparedStatement pdst;
    //     try {
    //         pdst = conn.prepareStatement(sql);
    //         pdst.setString(1, vo.getFabricante());
    //         pdst.executeUpdate();
    //     } catch (SQLException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }
    // }

    //Listagem
    public ResultSet listar(){
        conn = getConnection();
        String sql = "select * from Peca";
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

    public ResultSet findById(PecaVO vo){
        conn = getConnection();
        String sql = "select * from Peca where id = ?";
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

    public ResultSet findByNome(PecaVO vo){
        conn = getConnection();
        String sql = "select * from Peca where nome = ?";
        PreparedStatement pdst;
        ResultSet rs = null;
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setString(1, vo.getNome());
            rs = pdst.executeQuery();
           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet findByFabricante(PecaVO vo){
        conn = getConnection();
        String sql = "select * from Peca where fabricante = ?";
        PreparedStatement pdst;
        ResultSet rs = null;
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setString(1, vo.getFabricante());
            rs = pdst.executeQuery();
           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet findByPreco(PecaVO vo){
        conn = getConnection();
        String sql = "select * from Peca where preco = ?";
        PreparedStatement pdst;
        ResultSet rs = null;
        
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setDouble(1, vo.getPreco());
            rs = pdst.executeQuery();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }

    //Alteração
    public void editarNome(PecaVO vo){
        conn = getConnection();
        String sql = "update Peca set nome = ? where id = ?";
        PreparedStatement pdst;
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setString(1, vo.getNome());
            pdst.setLong(2, vo.getId());
            pdst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void editarPreco(PecaVO vo){
        conn = getConnection();
        String sql = "update Peca set preco = ? where id = ?";
        PreparedStatement pdst;
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setDouble(1, vo.getPreco());
            pdst.setLong(2, vo.getId());
            pdst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void editarFabricante(PecaVO vo){
        conn = getConnection();
        String sql = "update Peca set fabricante = ? where id = ?";
        PreparedStatement pdst;
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setString(1, vo.getFabricante());
            pdst.setLong(2, vo.getId());
            pdst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
