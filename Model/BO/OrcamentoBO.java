package Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import Exceptions.FindException;
import Exceptions.InsertException;
import Model.DAO.*;
import Model.VO.*;

public class OrcamentoBO implements BaseInterBO<OrcamentoVO>{
    OrcamentoDAO dao = new OrcamentoDAO();
    
    //inserir
    public void inserir(OrcamentoVO vo) throws InsertException{
        ResultSet rs = dao.findByAutomovelId(vo);//Verifica se já existe um orçamento para o automóvel inserido;
        ResultSet rs2;
        try {
            if (rs.next()) {
                rs2 = dao.findByDataInicio(vo);//Verifica se já existe um orçamento no mesmo dia inicial;
                if (rs2.next()) {
                    throw new InsertException("Impossível cadastrar, pois já existe um orçamento para esse veiculo no dia registrado.\n");
                }
                else{
                    dao.inserir(vo);
                }
            }
            else{
                dao.inserir(vo);
            }
        } catch (SQLException e) {
            throw new InsertException(e.getMessage());
        }
    }

    //listagem
    public List<OrcamentoVO> listar() throws FindException{
        ResultSet rs = dao.listar();
        List<OrcamentoVO> lista = new ArrayList<OrcamentoVO>();
        OrcamentoVO vo2 = new OrcamentoVO();
        try {
            while(rs.next()){
                Calendar dataIni = Calendar.getInstance();
                Calendar dataFim = Calendar.getInstance();

                vo2.setId(rs.getLong("id"));
                dataIni.setTimeInMillis(rs.getDate("data_inicio").getTime());
                vo2.setDataInicio(dataIni);
                dataFim.setTimeInMillis(rs.getDate("data_fim").getTime());
                vo2.setDataFim(dataFim);
                vo2.setValor(rs.getDouble("valor"));
                vo2.getCarro().setID(rs.getLong("id_automovel"));
                vo2.getCliente().setId(rs.getLong("id_cliente"));
                lista.add(vo2);
            }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    public List<OrcamentoVO> buscarPorId(OrcamentoVO vo) throws FindException{
        ResultSet rs = dao.findById(vo);
        List<OrcamentoVO> lista = new ArrayList<OrcamentoVO>();
        OrcamentoVO vo2 = new OrcamentoVO();
        try {
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum orçamento com esse Id.\n");
            }
            else{ 
                while(rs.next()){
                    Calendar dataIni = Calendar.getInstance();
                    Calendar dataFim = Calendar.getInstance();

                    vo2.setId(rs.getLong("id"));
                    dataIni.setTimeInMillis(rs.getDate("data_inicio").getTime());
                    vo2.setDataInicio(dataIni);
                    dataFim.setTimeInMillis(rs.getDate("data_fim").getTime());
                    vo2.setDataFim(dataFim);
                    vo2.setValor(rs.getDouble("valor"));
                    vo2.getCarro().setID(rs.getLong("id_automovel"));
                    vo2.getCliente().setId(rs.getLong("id_cliente"));
                    lista.add(vo2);
                }
            }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    public List<OrcamentoVO> buscarPorPeriodo(OrcamentoVO vo) throws FindException{
        ResultSet rs = dao.findByDataInicio(vo);
        ResultSet rs2;
        List<OrcamentoVO> lista = new ArrayList<OrcamentoVO>();
        OrcamentoVO vo2 = new OrcamentoVO();
        try {
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum orçamento com essa data inicial.\n");
            }
            else{
                rs2 = dao.findByDataFinal(vo); 
                if (!rs2.next()) {
                    throw new FindException("Não foi encotrado nenhum orçamento com essa data final.\n");
                }
                else{ 
                    while(rs2.next()){
                        Calendar dataIni = Calendar.getInstance();
                        Calendar dataFim = Calendar.getInstance();
                    
                        vo2.setId(rs2.getLong("id"));
                        dataIni.setTimeInMillis(rs2.getDate("data_inicio").getTime());
                        vo2.setDataInicio(dataIni);
                        dataFim.setTimeInMillis(rs2.getDate("data_fim").getTime());
                        vo2.setDataFim(dataFim);
                        vo2.setValor(rs2.getDouble("valor"));
                        vo2.getCarro().setID(rs2.getLong("id_automovel"));
                        vo2.getCliente().setId(rs2.getLong("id_cliente"));
                        lista.add(vo2);
                    }
                }    
            }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    public List<OrcamentoVO> buscarPorAutomovel(AutomovelVO voCar) throws FindException{
        AutomovelDAO daoCar = new AutomovelDAO();
        ResultSet rs = daoCar.findById(voCar);
        List<OrcamentoVO> lista = new ArrayList<OrcamentoVO>();
        OrcamentoVO vo = new OrcamentoVO();
        try {
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum orçamento com esse veículo.\n");
            }
            else{ 
                while(rs.next()){
                    Calendar dataIni = Calendar.getInstance();
                    Calendar dataFim = Calendar.getInstance();

                    vo.setId(rs.getLong("id"));
                    dataIni.setTimeInMillis(rs.getDate("data_inicio").getTime());
                    vo.setDataInicio(dataIni);
                    dataFim.setTimeInMillis(rs.getDate("data_fim").getTime());
                    vo.setDataFim(dataFim);
                    vo.setValor(rs.getDouble("valor"));
                    vo.getCarro().setID(rs.getLong("id_automovel"));
                    vo.getCliente().setId(rs.getLong("id_cliente"));
                    lista.add(vo);
                }
            }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    public List<OrcamentoVO> buscarPorDono(ClienteVO voCli) throws FindException{
        ClienteDAO daoCli = new ClienteDAO();
        ResultSet rs = daoCli.findById(voCli);
        List<OrcamentoVO> lista = new ArrayList<OrcamentoVO>();
        OrcamentoVO vo = new OrcamentoVO();
        try {
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum orçamento com esse cliente.\n");
            }
            else{ 
                while(rs.next()){
                    Calendar dataIni = Calendar.getInstance();
                    Calendar dataFim = Calendar.getInstance();

                    vo.setId(rs.getLong("id"));
                    dataIni.setTimeInMillis(rs.getDate("data_inicio").getTime());
                    vo.setDataInicio(dataIni);
                    dataFim.setTimeInMillis(rs.getDate("data_fim").getTime());
                    vo.setDataFim(dataFim);
                    vo.setValor(rs.getDouble("valor"));
                    vo.getCarro().setID(rs.getLong("id_automovel"));
                    vo.getCliente().setId(rs.getLong("id_cliente"));
                    lista.add(vo);
                }
            }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    //Remoção por id
    public void deletar(OrcamentoVO vo){
        dao.removerById(vo);
    }

    //Alteração
    public void editarPerido(OrcamentoVO vo){
        dao.editarDataInicial(vo);
        dao.editarDataInicial(vo);
    }
    public void editarValor(OrcamentoVO vo){
        dao.editarValor(vo);
    }
    public void editarClienteId(OrcamentoVO vo){
        dao.editarClienteId(vo);
    }
    public void editarAutomovelId(OrcamentoVO vo){
        dao.editarAutomovelId(vo);
    }

    //Espaço para métodos que não acessam o BD

    //Registrar pagamento
    public boolean registrarPagamento(OrcamentoVO vo){
        //Quando invocado no programa significa que o pagamento foi efetuado
        final boolean pagamento = true;

        return pagamento;
    }

    //Finalizar serviço
    public boolean finalizarServico(OrcamentoVO vo){
        //Quando invocado no programa significa que o serviço foi finalizado
        final boolean servico = true;

        return servico;
    }
}