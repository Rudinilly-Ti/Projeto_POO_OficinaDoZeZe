package Model.DAO;

import Model.VO.OrcamentoVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OrcamentoDAO extends BaseDAO{
    
    //Inserção
    public void inserir(OrcamentoVO vo){
        conn = getConnection();
        String sql = "insert into Orcamento (id_cliente,id_automovel,valor,data_inicio,data_fim) values (?,?,?,?,?)";
        PreparedStatement pdst;
        java.sql.Date DateSqlIni = new java.sql.Date(vo.getDataInicio().getTimeInMillis());
        java.sql.Date DateSqlFim = new java.sql.Date(vo.getDataFim().getTimeInMillis());
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setLong(1, vo.getCliente().getId());
            pdst.setLong(2, vo.getCarro().getID());
            pdst.setDouble(3, vo.getValor());
            pdst.setDate(4, DateSqlIni);
            pdst.setDate(5, DateSqlFim);
            pdst.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //Remoção
    public void removerById(OrcamentoVO vo){
        conn = getConnection();
        String sql = "delete from Orcamento where id = ?";
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
    public void removerByValor(OrcamentoVO vo){
        conn = getConnection();
        String sql = "delete from Orcamento where valor = ?";
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
    public void removerByDataInicial(OrcamentoVO vo){
        conn = getConnection();
        String sql = "delete from Orcamento where data_inicio = ?";
        PreparedStatement pdst;
        java.sql.Date DateSqlIni = new java.sql.Date(vo.getDataInicio().getTimeInMillis());
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setDate(1, DateSqlIni);
            pdst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void removerByDataFinal(OrcamentoVO vo){
        conn = getConnection();
        String sql = "delete from Orcamento where data_fim = ?";
        PreparedStatement pdst;
        java.sql.Date DateSqlFim = new java.sql.Date(vo.getDataFim().getTimeInMillis());
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setDate(1, DateSqlFim);
            pdst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //Listagem
    public List<OrcamentoVO> listar(){
        conn = getConnection();
        String sql = "select * from Orcamento";
        Statement st;
        ResultSet rs;
        List<OrcamentoVO> orcamentos = new ArrayList<OrcamentoVO>();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                OrcamentoVO orcVo = new OrcamentoVO();
                Calendar dataIni = Calendar.getInstance();
                Calendar dataFim = Calendar.getInstance();

                orcVo.setId(rs.getLong("Id"));
                orcVo.getCliente().setId(rs.getLong("Id_cliente"));
                orcVo.getCarro().setID(rs.getLong("Id_automovel"));
                orcVo.setValor(rs.getDouble("valor"));
                
                dataIni.setTimeInMillis(rs.getDate("data_inicio").getTime());
                orcVo.setDataInicio(dataIni);
                
                dataFim.setTimeInMillis(rs.getDate("data_fim").getTime());
                orcVo.setDataFim(dataFim);
                
                orcamentos.add(orcVo);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return orcamentos;
    }

    public List<OrcamentoVO> findById(OrcamentoVO vo){
        conn = getConnection();
        String sql = "select * from Orcamento where id = ?";
        PreparedStatement pdst;
        ResultSet rs;
        List<OrcamentoVO> orcamentos = new ArrayList<OrcamentoVO>();
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setLong(1, vo.getId());
            rs = pdst.executeQuery();
            while (rs.next()) {
                OrcamentoVO orcVo = new OrcamentoVO();
                Calendar dataIni = Calendar.getInstance();
                Calendar dataFim = Calendar.getInstance();

                orcVo.setId(rs.getLong("Id"));
                orcVo.getCliente().setId(rs.getLong("Id_cliente"));
                orcVo.getCarro().setID(rs.getLong("Id_automovel"));
                orcVo.setValor(rs.getDouble("valor"));
                
                dataIni.setTimeInMillis(rs.getDate("data_inicio").getTime());
                orcVo.setDataInicio(dataIni);
                
                dataFim.setTimeInMillis(rs.getDate("data_fim").getTime());
                orcVo.setDataFim(dataFim);
                
                orcamentos.add(orcVo);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return orcamentos;
    }

    public List<OrcamentoVO> findByClienteId(OrcamentoVO vo){
        conn = getConnection();
        String sql = "select * from Orcamento where id_cliente = ?";
        PreparedStatement pdst;
        ResultSet rs;
        List<OrcamentoVO> orcamentos = new ArrayList<OrcamentoVO>();
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setLong(1, vo.getCliente().getId());
            rs = pdst.executeQuery();
            while (rs.next()) {
                OrcamentoVO orcVo = new OrcamentoVO();
                Calendar dataIni = Calendar.getInstance();
                Calendar dataFim = Calendar.getInstance();

                orcVo.setId(rs.getLong("Id"));
                orcVo.getCliente().setId(rs.getLong("Id_cliente"));
                orcVo.getCarro().setID(rs.getLong("Id_automovel"));
                orcVo.setValor(rs.getDouble("valor"));
                
                dataIni.setTimeInMillis(rs.getDate("data_inicio").getTime());
                orcVo.setDataInicio(dataIni);
                
                dataFim.setTimeInMillis(rs.getDate("data_fim").getTime());
                orcVo.setDataFim(dataFim);
                
                orcamentos.add(orcVo);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return orcamentos;
    }

    public List<OrcamentoVO> findByAutomovelId(OrcamentoVO vo){
        conn = getConnection();
        String sql = "select * from Orcamento where id_automovel = ?";
        PreparedStatement pdst;
        ResultSet rs;
        List<OrcamentoVO> orcamentos = new ArrayList<OrcamentoVO>();
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setLong(1, vo.getCarro().getID());
            rs = pdst.executeQuery();
            while (rs.next()) {
                OrcamentoVO orcVo = new OrcamentoVO();
                Calendar dataIni = Calendar.getInstance();
                Calendar dataFim = Calendar.getInstance();

                orcVo.setId(rs.getLong("Id"));
                orcVo.getCliente().setId(rs.getLong("Id_cliente"));
                orcVo.getCarro().setID(rs.getLong("Id_automovel"));
                orcVo.setValor(rs.getDouble("valor"));
                
                dataIni.setTimeInMillis(rs.getDate("data_inicio").getTime());
                orcVo.setDataInicio(dataIni);
                
                dataFim.setTimeInMillis(rs.getDate("data_fim").getTime());
                orcVo.setDataFim(dataFim);
                
                orcamentos.add(orcVo);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return orcamentos;
    }

    public List<OrcamentoVO> findByValor(OrcamentoVO vo){
        conn = getConnection();
        String sql = "select * from Orcamento where valor = ?";
        PreparedStatement pdst;
        ResultSet rs;
        List<OrcamentoVO> orcamentos = new ArrayList<OrcamentoVO>();
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setDouble(1, vo.getValor());
            rs = pdst.executeQuery();
            while (rs.next()) {
                OrcamentoVO orcVo = new OrcamentoVO();
                Calendar dataIni = Calendar.getInstance();
                Calendar dataFim = Calendar.getInstance();

                orcVo.setId(rs.getLong("Id"));
                orcVo.getCliente().setId(rs.getLong("Id_cliente"));
                orcVo.getCarro().setID(rs.getLong("Id_automovel"));
                orcVo.setValor(rs.getDouble("valor"));
                
                dataIni.setTimeInMillis(rs.getDate("data_inicio").getTime());
                orcVo.setDataInicio(dataIni);
                
                dataFim.setTimeInMillis(rs.getDate("data_fim").getTime());
                orcVo.setDataFim(dataFim);
                
                orcamentos.add(orcVo);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return orcamentos;
    }

    public List<OrcamentoVO> findByDataInicio(OrcamentoVO vo){
        conn = getConnection();
        String sql = "select * from Orcamento where data_inicio = ?";
        PreparedStatement pdst;
        ResultSet rs;
        List<OrcamentoVO> orcamentos = new ArrayList<OrcamentoVO>();
        java.sql.Date DateSqlIni = new java.sql.Date(vo.getDataInicio().getTimeInMillis());
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setDate(1, DateSqlIni);
            rs = pdst.executeQuery();
            while (rs.next()) {
                OrcamentoVO orcVo = new OrcamentoVO();
                Calendar dataIni = Calendar.getInstance();
                Calendar dataFim = Calendar.getInstance();

                orcVo.setId(rs.getLong("Id"));
                orcVo.getCliente().setId(rs.getLong("Id_cliente"));
                orcVo.getCarro().setID(rs.getLong("Id_automovel"));
                orcVo.setValor(rs.getDouble("valor"));
                
                dataIni.setTimeInMillis(rs.getDate("data_inicio").getTime());
                orcVo.setDataInicio(dataIni);
                
                dataFim.setTimeInMillis(rs.getDate("data_fim").getTime());
                orcVo.setDataFim(dataFim);
                
                orcamentos.add(orcVo);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return orcamentos;
    }

    public List<OrcamentoVO> findByDataFinal(OrcamentoVO vo){
        conn = getConnection();
        String sql = "select * from Orcamento where data_fim = ?";
        PreparedStatement pdst;
        ResultSet rs;
        List<OrcamentoVO> orcamentos = new ArrayList<OrcamentoVO>();
        java.sql.Date DateSqlFim = new java.sql.Date(vo.getDataFim().getTimeInMillis());
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setDate(1, DateSqlFim);
            rs = pdst.executeQuery();
            while (rs.next()) {
                OrcamentoVO orcVo = new OrcamentoVO();
                Calendar dataIni = Calendar.getInstance();
                Calendar dataFim = Calendar.getInstance();

                orcVo.setId(rs.getLong("Id"));
                orcVo.getCliente().setId(rs.getLong("Id_cliente"));
                orcVo.getCarro().setID(rs.getLong("Id_automovel"));
                orcVo.setValor(rs.getDouble("valor"));
                
                dataIni.setTimeInMillis(rs.getDate("data_inicio").getTime());
                orcVo.setDataInicio(dataIni);
                
                dataFim.setTimeInMillis(rs.getDate("data_fim").getTime());
                orcVo.setDataFim(dataFim);
                
                orcamentos.add(orcVo);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return orcamentos;
    }

    //Alteração
    public void editarValor(OrcamentoVO vo){
        conn = getConnection();
        String sql = "update Orcamento set valor = ? where id = ?";
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

    public void editarDataInicial(OrcamentoVO vo){
        conn = getConnection();
        String sql = "update Orcamento set data_inicio = ? where id = ?";
        PreparedStatement pdst;
        java.sql.Date DateSqlIni = new java.sql.Date(vo.getDataInicio().getTimeInMillis());
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setDate(1, DateSqlIni);
            pdst.setLong(2, vo.getId());
            pdst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void editarDataFinal(OrcamentoVO vo){
        conn = getConnection();
        String sql = "update Orcamento set data_fim = ? where id = ?";
        PreparedStatement pdst;
        java.sql.Date DateSqlFim = new java.sql.Date(vo.getDataFim().getTimeInMillis());
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setDate(1, DateSqlFim);
            pdst.setLong(2, vo.getId());
            pdst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void editarClienteId(OrcamentoVO vo){
        conn = getConnection();
        String sql = "update Orcamento set id_cliente = ? where id = ?";
        PreparedStatement pdst;
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setLong(1, vo.getCliente().getId());
            pdst.setLong(2, vo.getId());
            pdst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void editarAutomovelId(OrcamentoVO vo){
        conn = getConnection();
        String sql = "update Orcamento set id_automovel = ? where id = ?";
        PreparedStatement pdst;
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setLong(1, vo.getCarro().getID());
            pdst.setLong(2, vo.getId());
            pdst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
