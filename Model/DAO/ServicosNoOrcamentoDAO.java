package Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.VO.ServicosNoOrcamentoVO;

public class ServicosNoOrcamentoDAO extends BaseDAO{
    
    //Inserção
    public void inserir(ServicosNoOrcamentoVO vo){
        conn = getConnection();
        String sql = "insert into ServicosNoOrcamento (id_servico,id_orcamento,valor,quantidade) values (?,?,?,?)";
        PreparedStatement pdst;
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setLong(1, vo.getServico().getId());
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
    public void removerByValor(ServicosNoOrcamentoVO vo){
        conn = getConnection();
        String sql = "delete from ServicosNoOrcamento where valor = ?";
        PreparedStatement pdst;
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setDouble(1, vo.getValor());
            pdst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void removerByQuantidade(ServicosNoOrcamentoVO vo){
        conn = getConnection();
        String sql = "delete from ServicosNoOrcamento where quantidade = ?";
        PreparedStatement pdst;
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setInt(1, vo.getQuantidade());
            pdst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //Listagem
    public List<ServicosNoOrcamentoVO> listar(){
        conn = getConnection();
        String sql = "select * from ServicosNoOrcamento";
        Statement st;
        ResultSet rs;
        List<ServicosNoOrcamentoVO> servicos = new ArrayList<ServicosNoOrcamentoVO>();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                ServicosNoOrcamentoVO svo = new ServicosNoOrcamentoVO();
                svo.setValor(rs.getDouble("valor"));
                svo.setQuantidade(rs.getInt("quantidade"));
                svo.getServico().setId(rs.getLong("id_servico"));
                svo.getOrcamento().setId(rs.getLong("id_orcamento"));
                svo.setId(rs.getLong("id"));
                servicos.add(svo);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return servicos;
    }

    public List<ServicosNoOrcamentoVO> findByValor(ServicosNoOrcamentoVO vo){
        conn = getConnection();
        String sql = "select * from ServicosNoOrcamento where valor = ?";
        PreparedStatement pdst;
        ResultSet rs;
        List<ServicosNoOrcamentoVO> servicos = new ArrayList<ServicosNoOrcamentoVO>();
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setDouble(1, vo.getValor());
            rs = pdst.executeQuery();
            while (rs.next()) {
                ServicosNoOrcamentoVO svo = new ServicosNoOrcamentoVO();
                svo.setValor(rs.getDouble("valor"));
                svo.setQuantidade(rs.getInt("quantidade"));
                svo.getServico().setId(rs.getLong("id_servico"));
                svo.getOrcamento().setId(rs.getLong("id_orcamento"));
                svo.setId(rs.getLong("id"));
                servicos.add(svo);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return servicos;
    }

    public List<ServicosNoOrcamentoVO> findByQuantidade(ServicosNoOrcamentoVO vo){
        conn = getConnection();
        String sql = "select * from ServicosNoOrcamento where quantidade = ?";
        PreparedStatement pdst;
        ResultSet rs;
        List<ServicosNoOrcamentoVO> servicos = new ArrayList<ServicosNoOrcamentoVO>();
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setInt(1, vo.getQuantidade());
            rs = pdst.executeQuery();
            while (rs.next()) {
                ServicosNoOrcamentoVO svo = new ServicosNoOrcamentoVO();
                svo.setValor(rs.getDouble("valor"));
                svo.setQuantidade(rs.getInt("quantidade"));
                svo.getServico().setId(rs.getLong("id_servico"));
                svo.getOrcamento().setId(rs.getLong("id_orcamento"));
                svo.setId(rs.getLong("id"));
                servicos.add(svo);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return servicos;
    }

    public List<ServicosNoOrcamentoVO> findByServicoId(ServicosNoOrcamentoVO vo){
        conn = getConnection();
        String sql = "select * from ServicosNoOrcamento where id_servico = ?";
        PreparedStatement pdst;
        ResultSet rs;
        List<ServicosNoOrcamentoVO> servicos = new ArrayList<ServicosNoOrcamentoVO>();
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setLong(1, vo.getServico().getId());
            rs = pdst.executeQuery();
            while (rs.next()) {
                ServicosNoOrcamentoVO svo = new ServicosNoOrcamentoVO();
                svo.setValor(rs.getDouble("valor"));
                svo.setQuantidade(rs.getInt("quantidade"));
                svo.getServico().setId(rs.getLong("id_servico"));
                svo.getOrcamento().setId(rs.getLong("id_orcamento"));
                svo.setId(rs.getLong("id"));
                servicos.add(svo);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return servicos;
    }

    public List<ServicosNoOrcamentoVO> findByOrcamentoId(ServicosNoOrcamentoVO vo){
        conn = getConnection();
        String sql = "select * from ServicosNoOrcamento where id_orcamento = ?";
        PreparedStatement pdst;
        ResultSet rs;
        List<ServicosNoOrcamentoVO> servicos = new ArrayList<ServicosNoOrcamentoVO>();
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setLong(1, vo.getOrcamento().getId());
            rs = pdst.executeQuery();
            while (rs.next()) {
                ServicosNoOrcamentoVO svo = new ServicosNoOrcamentoVO();
                svo.setValor(rs.getDouble("valor"));
                svo.setQuantidade(rs.getInt("quantidade"));
                svo.getServico().setId(rs.getLong("id_servico"));
                svo.getOrcamento().setId(rs.getLong("id_orcamento"));
                svo.setId(rs.getLong("id"));
                servicos.add(svo);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return servicos;
    }

    public List<ServicosNoOrcamentoVO> findById(ServicosNoOrcamentoVO vo){
        conn = getConnection();
        String sql = "select * from ServicosNoOrcamento where id = ?";
        PreparedStatement pdst;
        ResultSet rs;
        List<ServicosNoOrcamentoVO> servicos = new ArrayList<ServicosNoOrcamentoVO>();
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setLong(1, vo.getId());
            rs = pdst.executeQuery();
            while (rs.next()) {
                ServicosNoOrcamentoVO svo = new ServicosNoOrcamentoVO();
                svo.setValor(rs.getDouble("valor"));
                svo.setQuantidade(rs.getInt("quantidade"));
                svo.getServico().setId(rs.getLong("id_servico"));
                svo.getOrcamento().setId(rs.getLong("id_orcamento"));
                svo.setId(rs.getLong("id"));
                servicos.add(svo);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return servicos;
    }

    //Alteração
    public void editarValor(ServicosNoOrcamentoVO vo){
        conn = getConnection();
        String sql = "update ServicosNoOrcamento set valor = ? where id = ?";
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
    public void editarQuantidade(ServicosNoOrcamentoVO vo){
        conn = getConnection();
        String sql = "update ServicosNoOrcamento set quantidade = ? where id = ?";
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
    public void editarServicoId(ServicosNoOrcamentoVO vo){
        conn = getConnection();
        String sql = "update ServicosNoOrcamento set id_servico = ? where id = ?";
        PreparedStatement pdst;
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setLong(1, vo.getServico().getId());
            pdst.setLong(2, vo.getId());
            pdst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void editarOrcamentoId(ServicosNoOrcamentoVO vo){
        conn = getConnection();
        String sql = "update ServicosNoOrcamento set id_orcamento = ? where id = ?";
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
