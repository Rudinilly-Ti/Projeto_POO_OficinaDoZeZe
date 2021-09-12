package Model.DAO;

import Model.VO.PecaVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PecaDAO extends BaseDAO{
    
    //Inserção
    public void inserir(PecaVO vo){
        conn = getConnection();
        String sql = "insert into Peca (nome,preco,fabricante,id) values (?,?,?,?)";
        PreparedStatement pdst;
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setString(1, vo.getNome());
            pdst.setDouble(2, vo.getPreco());
            pdst.setString(3, vo.getFabricante());
            pdst.setLong(4, vo.getId());
            pdst.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //Remoção
    public void removerByNome(PecaVO vo){
        conn = getConnection();
        String sql = "delete from Peca where nome = ?";
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
    public void removerByPreco(PecaVO vo){
        conn = getConnection();
        String sql = "delete from Peca where preco = ?";
        PreparedStatement pdst;
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setDouble(1, vo.getPreco());
            pdst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void removerByFabricante(PecaVO vo){
        conn = getConnection();
        String sql = "delete from Peca where fabricante = ?";
        PreparedStatement pdst;
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setString(1, vo.getFabricante());
            pdst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //Listagem
    public List<PecaVO> listar(){
        conn = getConnection();
        String sql = "select * from Peca";
        Statement st;
        ResultSet rs;
        List<PecaVO> pecas = new ArrayList<PecaVO>();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                PecaVO pvo = new PecaVO();
                pvo.setNome(rs.getString("nome"));
                pvo.setPreco(rs.getDouble("preco"));
                pvo.setFabricante(rs.getString("fabricante"));
                pvo.setId(rs.getLong("id"));
                pecas.add(pvo);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return pecas;
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
