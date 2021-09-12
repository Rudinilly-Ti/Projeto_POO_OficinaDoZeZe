package Model.DAO;

import Model.VO.OrcamentoVO;
import Model.VO.PecaVO;
import Model.VO.ServicoVO;

import java.sql.Array;
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
        String sql = "insert into Orcamento (id,id_cliente,id_automovel,id_peca,id_servico,valor,data_inicio,data_fim) values (?,?,?,?,?,?,?,?)";
        PreparedStatement pdst;
        List<Long> idPecas, idServicos;
        java.sql.Date DateSqlIni = new java.sql.Date(vo.getDataInicio().getTimeInMillis());
        java.sql.Date DateSqlFim = new java.sql.Date(vo.getDataFim().getTimeInMillis());
        try {
            idPecas = new ArrayList<Long>();
            idServicos = new ArrayList<Long>(); 
            pdst = conn.prepareStatement(sql);
            pdst.setLong(1, vo.getId());
            pdst.setLong(2, vo.getCliente().getId());
            pdst.setLong(3, vo.getCarro().getID());
            
            for(PecaVO pvo: vo.getPeca()){
                idPecas.add(pvo.getId());
            }
            pdst.setArray(4, conn.createArrayOf("integer", idPecas.toArray()));
            
            for(ServicoVO svo: vo.getServico()){
                idServicos.add(svo.getId());
            }
            pdst.setArray(5, conn.createArrayOf("integer", idServicos.toArray()));

            pdst.setDouble(6, vo.getValor());
            pdst.setDate(7, DateSqlIni);
            pdst.setDate(8, DateSqlFim);
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
        PecaVO pvo = new PecaVO();
        ServicoVO svo = new ServicoVO();
        Calendar dataIni = Calendar.getInstance();
        Calendar dataFim = Calendar.getInstance();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                OrcamentoVO orcVo = new OrcamentoVO();
                orcVo.setId(rs.getLong("Id"));
                orcVo.getCliente().setId(rs.getLong("Id_cliente"));
                orcVo.getCarro().setID(rs.getLong("Id_automovel"));
                
                Array pArray = rs.getArray("id_peca");
                Array sArray = rs.getArray("id_servico");
                
                for(Integer id: (Integer[])pArray.getArray()){
                    pvo.setId(new Long(id));
                    orcVo.getPeca().add(pvo);
                }
                
                for(Integer id: (Integer[])sArray.getArray()){
                    svo.setId(new Long(id));
                    orcVo.getServico().add(svo);
                }

                orcVo.setValor(rs.getDouble("valor"));
                
                dataIni.setTime(rs.getDate("data_inicio"));
                orcVo.setDataInicio(dataIni);
                dataFim.setTime(rs.getDate("data_fim"));
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
    public void editarPecaId(OrcamentoVO vo){
        conn = getConnection();
        String sql = "update Orcamento set id_peca = ? where id = ?";
        PreparedStatement pdst;
        List<Long> idPecas;
        try {
            idPecas = new ArrayList<Long>();
            pdst = conn.prepareStatement(sql);
            for(PecaVO pvo: vo.getPeca()){
                idPecas.add(pvo.getId());
            }
            pdst.setArray(1, conn.createArrayOf("integer", idPecas.toArray()));
            pdst.setLong(2, vo.getId());
            pdst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void editarServicoId(OrcamentoVO vo){
        conn = getConnection();
        String sql = "update Orcamento set id_servico = ? where id = ?";
        PreparedStatement pdst;
        List<Long> idServicos;
        try {
            idServicos = new ArrayList<Long>();
            pdst = conn.prepareStatement(sql);
            for(ServicoVO svo: vo.getServico()){
                idServicos.add(svo.getId());
            }
            pdst.setArray(1, conn.createArrayOf("integer", idServicos.toArray()));
            pdst.setLong(2, vo.getId());
            pdst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
