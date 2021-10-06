package Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import Exceptions.DeleteException;
import Exceptions.FindException;
import Exceptions.InsertException;
import Exceptions.UpgradeException;
import Model.DAO.*;
import Model.VO.*;

public class OrcamentoBO implements BaseInterBO<OrcamentoVO>{
    OrcamentoDAO dao = new OrcamentoDAO();
    
    //inserir
    public void inserir(OrcamentoVO vo) throws InsertException{
        boolean repetido = false;
        java.sql.Date DateSqlIni = new java.sql.Date(vo.getDataInicio().getTimeInMillis());
        java.sql.Date DateSqlFim = new java.sql.Date(vo.getDataFim().getTimeInMillis());

        try {
            ResultSet rs = dao.listar();//Optei por utilizar uma sequencia de testes para verificar se existe um orçamento igual ao inserido
            while(rs.next()){
                if (vo.getCliente().getId() == rs.getLong("id_cliente")){
                    if (vo.getCarro().getID() == rs.getLong("id_automovel")){
                        if (DateSqlIni == rs.getDate("data_inicio")){
                            if (DateSqlFim == rs.getDate("data_fim")){
                                repetido = true;
                            }          
                        }
                    }
                } 
            }
            if (repetido) {
                throw new InsertException("Um orçamento com esses dados já existe!\n.");
            } else {
                dao.inserir(vo);
            }
        } catch (Exception e) {
            throw new InsertException(e.getMessage());
        }
    }

    //listagem
    public List<OrcamentoVO> listar() throws FindException{
        List<OrcamentoVO> lista = new ArrayList<OrcamentoVO>();
        try {
            ResultSet rs = dao.listar();
            while(rs.next()){
                OrcamentoVO vo = new OrcamentoVO();
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
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    public List<OrcamentoVO> buscarPorId(OrcamentoVO vo) throws FindException{
        List<OrcamentoVO> lista = new ArrayList<OrcamentoVO>();
        try {
            ResultSet rs = dao.findById(vo);
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum orçamento com esse Id.\n");
            }
            else{
                rs = dao.findById(vo); 
                while(rs.next()){
                    OrcamentoVO vo2 = new OrcamentoVO();
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
        List<OrcamentoVO> lista = new ArrayList<OrcamentoVO>();
        try {
            ResultSet rs = dao.findByPeriodo(vo);
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum orçamento dentro desse periodo.\n");
            }
            else{
                rs = dao.findByPeriodo(vo);
                while(rs.next()){
                    OrcamentoVO vo2 = new OrcamentoVO();
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
        } catch (Exception e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    public List<OrcamentoVO> buscarPorAutomovel(AutomovelVO voCar) throws FindException{
        OrcamentoVO vo = new OrcamentoVO();
        vo.getCarro().setID(voCar.getID());//Passa o valor do id inserido para o id de automovel em orcamento;
        
        List<OrcamentoVO> lista = new ArrayList<OrcamentoVO>();
        try {
            ResultSet rs = dao.findByAutomovelId(vo);
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum orçamento com esse veículo.\n");
            }
            else{ 
                rs = dao.findByAutomovelId(vo);
                while(rs.next()){
                    OrcamentoVO vo2 = new OrcamentoVO();
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
        } catch (Exception e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    public List<OrcamentoVO> buscarPorDono(ClienteVO voCli) throws FindException{
        OrcamentoVO vo = new OrcamentoVO();
        vo.getCliente().setId(voCli.getId());//Passa o valor do id inserido para o id de cliente em orcamento;
        
        List<OrcamentoVO> lista = new ArrayList<OrcamentoVO>();
        try {
            ResultSet rs = dao.findByClienteId(vo);
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum orçamento com esse cliente.\n");
            }
            else{
                rs = dao.findByClienteId(vo); 
                while(rs.next()){
                    OrcamentoVO vo2 = new OrcamentoVO();
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
        } catch (Exception e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    //Remoção por id
    public void deletar(OrcamentoVO vo) throws DeleteException{
        try {
            dao.removerById(vo);
        } catch (SQLException e) {
            throw new DeleteException(e.getMessage());
        }
    }

    //Alteração
    public void editarDataInicial(OrcamentoVO vo) throws UpgradeException{
        try {
            dao.editarDataInicial(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }
    public void editarDataFinal(OrcamentoVO vo) throws UpgradeException{
        try {
            dao.editarDataFinal(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }
    public void editarValor(OrcamentoVO vo) throws UpgradeException{
        try {
            dao.editarValor(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }
    public void editarClienteId(OrcamentoVO vo) throws UpgradeException{
        try {
            dao.editarClienteId(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }
    public void editarAutomovelId(OrcamentoVO vo){
        try {
            dao.editarAutomovelId(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
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