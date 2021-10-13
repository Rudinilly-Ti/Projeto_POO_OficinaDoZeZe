package Model.DAO;

import Model.VO.OrcamentoVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrcamentoDAO extends BaseDAO<OrcamentoVO>{
    
    //Inserção
    public void inserir(OrcamentoVO vo) throws SQLException{
        conn = getConnection();
        String sql = "insert into Orcamento (id_cliente,id_automovel,valor,data_inicio,data_fim) values (?,?,?,?,?)";
        PreparedStatement pdst;
        java.sql.Date DateSqlIni = new java.sql.Date(vo.getDataInicio().getTimeInMillis());
        java.sql.Date DateSqlFim = new java.sql.Date(vo.getDataFim().getTimeInMillis());

        pdst = conn.prepareStatement(sql);
        pdst.setLong(1, vo.getCliente().getId());
        pdst.setLong(2, vo.getCarro().getID());
        pdst.setDouble(3, vo.getValor());
        pdst.setDate(4, DateSqlIni);
        pdst.setDate(5, DateSqlFim);
        pdst.execute();
    }

    //Remoção
    public void removerById(OrcamentoVO vo)throws SQLException{
        conn = getConnection();
        String sql = "delete from Orcamento where id = ?";
        PreparedStatement pdst;

        pdst = conn.prepareStatement(sql);
        pdst.setLong(1, vo.getId());
        pdst.executeUpdate();
    }
    // public void removerByValor(OrcamentoVO vo){
    //     conn = getConnection();
    //     String sql = "delete from Orcamento where valor = ?";
    //     PreparedStatement pdst;
    //     try {
    //         pdst = conn.prepareStatement(sql);
    //         pdst.setDouble(1, vo.getValor());
    //         pdst.executeUpdate();
    //     } catch (SQLException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }
    // }
    // public void removerByDataInicial(OrcamentoVO vo){
    //     conn = getConnection();
    //     String sql = "delete from Orcamento where data_inicio = ?";
    //     PreparedStatement pdst;
    //     java.sql.Date DateSqlIni = new java.sql.Date(vo.getDataInicio().getTimeInMillis());
    //     try {
    //         pdst = conn.prepareStatement(sql);
    //         pdst.setDate(1, DateSqlIni);
    //         pdst.executeUpdate();
    //     } catch (SQLException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }
    // }
    // public void removerByDataFinal(OrcamentoVO vo){
    //     conn = getConnection();
    //     String sql = "delete from Orcamento where data_fim = ?";
    //     PreparedStatement pdst;
    //     java.sql.Date DateSqlFim = new java.sql.Date(vo.getDataFim().getTimeInMillis());
    //     try {
    //         pdst = conn.prepareStatement(sql);
    //         pdst.setDate(1, DateSqlFim);
    //         pdst.executeUpdate();
    //     } catch (SQLException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }
    // }

    //Listagem
    public ResultSet listar() throws SQLException{
        conn = getConnection();
        String sql = "select * from Orcamento";
        Statement st;
        ResultSet rs;
    
        st = conn.createStatement();
        rs = st.executeQuery(sql);
            
        return rs;
    }

    public ResultSet findById(OrcamentoVO vo) throws SQLException{
        conn = getConnection();
        String sql = "select * from Orcamento where id = ?";
        PreparedStatement pdst;
        ResultSet rs = null;

        pdst = conn.prepareStatement(sql);
        pdst.setLong(1, vo.getId());
        rs = pdst.executeQuery();

        return rs;
    }

    public ResultSet findByClienteId(OrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "select * from Orcamento where id_cliente = ?";
        PreparedStatement pdst;
        ResultSet rs = null;

        pdst = conn.prepareStatement(sql);
        pdst.setLong(1, vo.getCliente().getId());
        rs = pdst.executeQuery();
           
        return rs;
    }

    public ResultSet findByAutomovelId(OrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "select * from Orcamento where id_automovel = ?";
        PreparedStatement pdst;
        ResultSet rs = null;

        pdst = conn.prepareStatement(sql);
        pdst.setLong(1, vo.getCarro().getID());
        rs = pdst.executeQuery();
        
        return rs;
    }

    public ResultSet findByValor(OrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "select * from Orcamento where valor = ?";
        PreparedStatement pdst;
        ResultSet rs = null;

        pdst = conn.prepareStatement(sql);
        pdst.setDouble(1, vo.getValor());
        rs = pdst.executeQuery();
           
        return rs;
    }

    public ResultSet findByPeriodo(OrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "select * from Orcamento where data_inicio >= ? and data_fim <= ?";
        PreparedStatement pdst;
        ResultSet rs = null;
        java.sql.Date DateSqlIni = new java.sql.Date(vo.getDataInicio().getTimeInMillis());
        java.sql.Date DateSqlFim = new java.sql.Date(vo.getDataFim().getTimeInMillis());
        
        pdst = conn.prepareStatement(sql);
        pdst.setDate(1, DateSqlIni);
        pdst.setDate(2, DateSqlFim);
        rs = pdst.executeQuery();
        
        return rs;
    }

    public ResultSet findByServicoConcluido(OrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "select * from Orcamento where ServicoConcluido = ?";
        PreparedStatement pdst;
        ResultSet rs = null;

        pdst = conn.prepareStatement(sql);
        pdst.setBoolean(1, vo.getServicoConcluido());
        rs = pdst.executeQuery();
        
        return rs;
    }

    public ResultSet findByPagamentoEfetuado(OrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "select * from Orcamento where PagamentoEfetuado = ?";
        PreparedStatement pdst;
        ResultSet rs = null;

        pdst = conn.prepareStatement(sql);
        pdst.setBoolean(1, vo.getPagamentoEfetuado());
        rs = pdst.executeQuery();
        
        return rs;
    }

    //Alteração
    public void editarValor(OrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "update Orcamento set valor = ? where id = ?";
        PreparedStatement pdst;

        pdst = conn.prepareStatement(sql);
        pdst.setDouble(1, vo.getValor());
        pdst.setLong(2, vo.getId());
        pdst.executeUpdate();
    }

    public void editarDataInicial(OrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "update Orcamento set data_inicio = ? where id = ?";
        PreparedStatement pdst;
        java.sql.Date DateSqlIni = new java.sql.Date(vo.getDataInicio().getTimeInMillis());
            
        pdst = conn.prepareStatement(sql);
        pdst.setDate(1, DateSqlIni);
        pdst.setLong(2, vo.getId());
        pdst.executeUpdate();
    }

    public void editarDataFinal(OrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "update Orcamento set data_fim = ? where id = ?";
        PreparedStatement pdst;
        java.sql.Date DateSqlFim = new java.sql.Date(vo.getDataFim().getTimeInMillis());

        pdst = conn.prepareStatement(sql);
        pdst.setDate(1, DateSqlFim);
        pdst.setLong(2, vo.getId());
        pdst.executeUpdate();
    }

    public void editarClienteId(OrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "update Orcamento set id_cliente = ? where id = ?";
        PreparedStatement pdst;

        pdst = conn.prepareStatement(sql);
        pdst.setLong(1, vo.getCliente().getId());
        pdst.setLong(2, vo.getId());
        pdst.executeUpdate();
    }

    public void editarAutomovelId(OrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "update Orcamento set id_automovel = ? where id = ?";
        PreparedStatement pdst;
        
        pdst = conn.prepareStatement(sql);
        pdst.setLong(1, vo.getCarro().getID());
        pdst.setLong(2, vo.getId());
        pdst.executeUpdate();
    }

    public void editarServicoConcluido(OrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "update Orcamento set ServicoConcluido = ? where id = ?";
        PreparedStatement pdst;
        
        pdst = conn.prepareStatement(sql);
        pdst.setBoolean(1, vo.getServicoConcluido());
        pdst.setLong(2, vo.getId());
        pdst.executeUpdate();
    }

    public void editarPagamentoEfetuado(OrcamentoVO vo) throws Exception{
        conn = getConnection();
        String sql = "update Orcamento set PagamentoEfetuado = ? where id = ?";
        PreparedStatement pdst;
        
        pdst = conn.prepareStatement(sql);
        pdst.setBoolean(1, vo.getPagamentoEfetuado());
        pdst.setLong(2, vo.getId());
        pdst.executeUpdate();
    }
}
