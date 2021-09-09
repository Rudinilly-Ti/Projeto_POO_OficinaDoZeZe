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
            pdst.setLong(3, vo.getCarro().getId());
            
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
        Integer idServicos[], idPecas[];
        Calendar dataIni = Calendar.getInstance();
        Calendar dataFim = Calendar.getInstance();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                OrcamentoVO orcVo = new OrcamentoVO();
                orcVo.setId(rs.getLong("Id"));
                orcVo.getCliente().setId(rs.getLong("Id"));
                orcVo.getCarro().setId(rs.getLong("Id"));
                
                Array pArray = rs.getArray("id_peca");
                Array sArray = rs.getArray("id_servico");
                idPecas = (Integer[])pArray.getArray();
                idServicos = (Integer[])sArray.getArray();

                for (int i = 0; i < idPecas.length; i++) {
                    for(PecaVO pvo: orcVo.getPeca()){
                        pvo.setId(new Long(idPecas[i]));
                        orcVo.getPeca().add(pvo);
                    }
                }

                for (int i = 0; i < idServicos.length; i++) {
                    for(ServicoVO svo: orcVo.getServico()){
                        svo.setId(new Long(idServicos[i]));
                        orcVo.getServico().add(svo);
                    }
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
    public void editarByValor(OrcamentoVO vo){
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

    public void editarByDataInicial(OrcamentoVO vo){
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

    public void editarByDataFinal(OrcamentoVO vo){
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
}
