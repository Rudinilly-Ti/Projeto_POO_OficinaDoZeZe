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

public class OrcamentoBO implements BaseInterBO<OrcamentoVO> {
    OrcamentoDAO dao = new OrcamentoDAO();

    // inserir
    public void inserir(OrcamentoVO vo) throws InsertException {
        boolean repetido = false;
        try {
            ResultSet rs = dao.findByPeriodo(vo);
            while (rs.next()) {
                if(rs.getLong("id_cliente") == vo.getCliente().getId()) {
                    if(rs.getLong("id_automovel") == vo.getCarro().getID()) {
                        repetido = true;    
                    }    
                }
            }
            if (!repetido) {
                dao.inserir(vo);
            }
            else{
                throw new InsertException("Já existe um orçamento com esses dados!");
            }
        } catch (Exception e) {
            throw new InsertException(e.getMessage());
        }
    }

    // listagem
    public List<OrcamentoVO> listar() throws FindException {
        List<OrcamentoVO> lista = new ArrayList<OrcamentoVO>();
        try {
            ResultSet rs = dao.listar();
            while (rs.next()) {
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
                // settar automovel
                AutomovelBO boAuto = new AutomovelBO();
                List<AutomovelVO> carro = boAuto.buscarPorId(vo.getCarro());
                vo.getCarro().setAno(carro.get(0).getAno());
                vo.getCarro().setCor(carro.get(0).getCor());
                vo.getCarro().setMarca(carro.get(0).getMarca());
                vo.getCarro().setPlaca(carro.get(0).getPlaca());
                vo.getCarro().setQuilometragem(carro.get(0).getQuilometragem());
                vo.getCliente().setId(rs.getLong("id_cliente"));
                // settar dono
                ClienteBO boCliente = new ClienteBO();
                List<ClienteVO> dono = boCliente.buscarPorId(vo.getCliente());
                vo.getCliente().setNome(dono.get(0).getNome());
                vo.getCliente().setCPF(dono.get(0).getCPF());
                vo.getCliente().setEndereco(dono.get(0).getEndereco());
                lista.add(vo);
            }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    public List<OrcamentoVO> buscarPorId(OrcamentoVO vo) throws FindException {
        List<OrcamentoVO> lista = new ArrayList<OrcamentoVO>();
        try {
            ResultSet rs = dao.findById(vo);
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum orçamento com esse Id.\n");
            } else {
                rs = dao.findById(vo);
                while (rs.next()) {
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
                    // settar automovel
                    AutomovelBO boAuto = new AutomovelBO();
                    List<AutomovelVO> carro = boAuto.buscarPorId(vo2.getCarro());
                    vo2.getCarro().setAno(carro.get(0).getAno());
                    vo2.getCarro().setCor(carro.get(0).getCor());
                    vo2.getCarro().setMarca(carro.get(0).getMarca());
                    vo2.getCarro().setPlaca(carro.get(0).getPlaca());
                    vo2.getCarro().setQuilometragem(carro.get(0).getQuilometragem());
                    vo2.getCliente().setId(rs.getLong("id_cliente"));
                    // settar dono
                    ClienteBO boCliente = new ClienteBO();
                    List<ClienteVO> dono = boCliente.buscarPorId(vo2.getCliente());
                    vo2.getCliente().setNome(dono.get(0).getNome());
                    vo2.getCliente().setCPF(dono.get(0).getCPF());
                    vo2.getCliente().setEndereco(dono.get(0).getEndereco());
                    lista.add(vo2);
                }
            }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    public List<OrcamentoVO> buscarPorPeriodo(OrcamentoVO vo) throws FindException {
        List<OrcamentoVO> lista = new ArrayList<OrcamentoVO>();
        try {
            ResultSet rs = dao.findByPeriodo(vo);
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum orçamento dentro desse periodo.\n");
            } else {
                rs = dao.findByPeriodo(vo);
                while (rs.next()) {
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
                    // settar automovel
                    AutomovelBO boAuto = new AutomovelBO();
                    List<AutomovelVO> carro = boAuto.buscarPorId(vo2.getCarro());
                    vo2.getCarro().setAno(carro.get(0).getAno());
                    vo2.getCarro().setCor(carro.get(0).getCor());
                    vo2.getCarro().setMarca(carro.get(0).getMarca());
                    vo2.getCarro().setPlaca(carro.get(0).getPlaca());
                    vo2.getCarro().setQuilometragem(carro.get(0).getQuilometragem());
                    vo2.getCliente().setId(rs.getLong("id_cliente"));
                    // settar dono
                    ClienteBO boCliente = new ClienteBO();
                    List<ClienteVO> dono = boCliente.buscarPorId(vo2.getCliente());
                    vo2.getCliente().setNome(dono.get(0).getNome());
                    vo2.getCliente().setCPF(dono.get(0).getCPF());
                    vo2.getCliente().setEndereco(dono.get(0).getEndereco());
                    lista.add(vo2);
                }
            }
        } catch (Exception e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    public List<OrcamentoVO> buscarPorAutomovel(AutomovelVO voCar) throws FindException {
        OrcamentoVO vo = new OrcamentoVO();
        AutomovelBO findCarro = new AutomovelBO();
        vo.getCarro().setID(findCarro.buscarPorPlaca(voCar).get(0).getID());

        List<OrcamentoVO> lista = new ArrayList<OrcamentoVO>();
        try {
            ResultSet rs = dao.findByAutomovelId(vo);
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum orçamento com esse veículo.\n");
            } else {
                rs = dao.findByAutomovelId(vo);
                while (rs.next()) {
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
                    // settar automovel
                    AutomovelBO boAuto = new AutomovelBO();
                    List<AutomovelVO> carro = boAuto.buscarPorId(vo2.getCarro());
                    vo2.getCarro().setAno(carro.get(0).getAno());
                    vo2.getCarro().setCor(carro.get(0).getCor());
                    vo2.getCarro().setMarca(carro.get(0).getMarca());
                    vo2.getCarro().setPlaca(carro.get(0).getPlaca());
                    vo2.getCarro().setQuilometragem(carro.get(0).getQuilometragem());
                    vo2.getCliente().setId(rs.getLong("id_cliente"));
                    // settar dono
                    ClienteBO boCliente = new ClienteBO();
                    List<ClienteVO> dono = boCliente.buscarPorId(vo2.getCliente());
                    vo2.getCliente().setNome(dono.get(0).getNome());
                    vo2.getCliente().setCPF(dono.get(0).getCPF());
                    vo2.getCliente().setEndereco(dono.get(0).getEndereco());
                    lista.add(vo2);
                }
            }
        } catch (Exception e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    public List<OrcamentoVO> buscarPorDono(ClienteVO voCli) throws FindException {
        OrcamentoVO vo = new OrcamentoVO();
        ClienteBO findCliente = new ClienteBO();
        vo.getCliente().setId(findCliente.buscarPorNome(voCli).get(0).getId());

        List<OrcamentoVO> lista = new ArrayList<OrcamentoVO>();
        try {
            ResultSet rs = dao.findByClienteId(vo);
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum orçamento com esse cliente.\n");
            } else {
                rs = dao.findByClienteId(vo);
                while (rs.next()) {
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
                    // settar automovel
                    AutomovelBO boAuto = new AutomovelBO();
                    List<AutomovelVO> carro = boAuto.buscarPorId(vo2.getCarro());
                    vo2.getCarro().setAno(carro.get(0).getAno());
                    vo2.getCarro().setCor(carro.get(0).getCor());
                    vo2.getCarro().setMarca(carro.get(0).getMarca());
                    vo2.getCarro().setPlaca(carro.get(0).getPlaca());
                    vo2.getCarro().setQuilometragem(carro.get(0).getQuilometragem());
                    vo2.getCliente().setId(rs.getLong("id_cliente"));
                    // settar dono
                    ClienteBO boCliente = new ClienteBO();
                    List<ClienteVO> dono = boCliente.buscarPorId(vo2.getCliente());
                    vo2.getCliente().setNome(dono.get(0).getNome());
                    vo2.getCliente().setCPF(dono.get(0).getCPF());
                    vo2.getCliente().setEndereco(dono.get(0).getEndereco());
                    lista.add(vo2);
                }
            }
        } catch (Exception e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    public List<OrcamentoVO> buscarPorSituaçãoDoPagamento(OrcamentoVO vo) throws FindException {
        List<OrcamentoVO> lista = new ArrayList<OrcamentoVO>();
        try {
            ResultSet rs = dao.findByPagamentoEfetuado(vo);
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum orçamento com o pagamento nessa situação.\n");
            } else {
                rs = dao.findById(vo);
                while (rs.next()) {
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
                    // settar automovel
                    AutomovelBO boAuto = new AutomovelBO();
                    List<AutomovelVO> carro = boAuto.buscarPorId(vo2.getCarro());
                    vo2.getCarro().setAno(carro.get(0).getAno());
                    vo2.getCarro().setCor(carro.get(0).getCor());
                    vo2.getCarro().setMarca(carro.get(0).getMarca());
                    vo2.getCarro().setPlaca(carro.get(0).getPlaca());
                    vo2.getCarro().setQuilometragem(carro.get(0).getQuilometragem());
                    vo2.getCliente().setId(rs.getLong("id_cliente"));
                    // settar dono
                    ClienteBO boCliente = new ClienteBO();
                    List<ClienteVO> dono = boCliente.buscarPorId(vo2.getCliente());
                    vo2.getCliente().setNome(dono.get(0).getNome());
                    vo2.getCliente().setCPF(dono.get(0).getCPF());
                    vo2.getCliente().setEndereco(dono.get(0).getEndereco());
                    lista.add(vo2);
                }
            }
        } catch (Exception e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    public List<OrcamentoVO> buscarPorSituaçãoDoServico(OrcamentoVO vo) throws FindException {
        List<OrcamentoVO> lista = new ArrayList<OrcamentoVO>();
        try {
            ResultSet rs = dao.findByServicoConcluido(vo);
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum orçamento com o serviço nessa situação.\n");
            } else {
                rs = dao.findById(vo);
                while (rs.next()) {
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
                    // settar automovel
                    AutomovelBO boAuto = new AutomovelBO();
                    List<AutomovelVO> carro = boAuto.buscarPorId(vo2.getCarro());
                    vo2.getCarro().setAno(carro.get(0).getAno());
                    vo2.getCarro().setCor(carro.get(0).getCor());
                    vo2.getCarro().setMarca(carro.get(0).getMarca());
                    vo2.getCarro().setPlaca(carro.get(0).getPlaca());
                    vo2.getCarro().setQuilometragem(carro.get(0).getQuilometragem());
                    vo2.getCliente().setId(rs.getLong("id_cliente"));
                    // settar dono
                    ClienteBO boCliente = new ClienteBO();
                    List<ClienteVO> dono = boCliente.buscarPorId(vo2.getCliente());
                    vo2.getCliente().setNome(dono.get(0).getNome());
                    vo2.getCliente().setCPF(dono.get(0).getCPF());
                    vo2.getCliente().setEndereco(dono.get(0).getEndereco());
                    lista.add(vo2);
                }
            }
        } catch (Exception e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    // Remoção por id
    public void deletar(OrcamentoVO vo) throws DeleteException {
        try {
            dao.removerById(vo);
        } catch (SQLException e) {
            throw new DeleteException(e.getMessage());
        }
    }

    // Alteração
    public void editarDataInicial(OrcamentoVO vo) throws UpgradeException {
        try {
            dao.editarDataInicial(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }

    public void editarDataFinal(OrcamentoVO vo) throws UpgradeException {
        try {
            dao.editarDataFinal(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }

    public void editarValor(OrcamentoVO vo) throws UpgradeException {
        try {
            dao.editarValor(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }

    public void editarClienteId(OrcamentoVO vo) throws UpgradeException {
        try {
            dao.editarClienteId(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }

    public void editarAutomovelId(OrcamentoVO vo) throws UpgradeException {
        try {
            dao.editarAutomovelId(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }

    //método usado para retornar o id de um orçamento a partir de seus demais atributos
    public OrcamentoVO retornarId(OrcamentoVO vo) throws InsertException {
        OrcamentoVO vo2 = new OrcamentoVO();
        try {
            ResultSet rs = dao.findByPeriodo(vo);
            while (rs.next()) {
                if(rs.getLong("id_cliente") == vo.getCliente().getId()) {
                    if(rs.getLong("id_automovel") == vo.getCarro().getID()) {
                        vo2.setId(rs.getLong("id"));    
                    }    
                }
            } 
        } catch (Exception e) {
            throw new FindException(e.getMessage());
        }
        return vo2;
    }

    // Registrar pagamento
    public void registrarPagamento(OrcamentoVO vo) throws UpgradeException {
        // Quando invocado no programa significa que o pagamento foi efetuado
        try {
            dao.editarPagamentoEfetuado(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }

    // Finalizar serviço e cadastrar Data final do serviço
    public void finalizarServico(OrcamentoVO vo) throws UpgradeException {
        // Quando invocado no programa significa que o serviço foi finalizado
        try {
            dao.editarServicoConcluido(vo);
            dao.editarDataFinal(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }
}