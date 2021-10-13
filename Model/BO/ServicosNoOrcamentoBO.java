package Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exceptions.*;
import Model.DAO.*;
import Model.VO.*;

public class ServicosNoOrcamentoBO {
    ServicosNoOrcamentoDAO dao = new ServicosNoOrcamentoDAO();
	
	//inserir
    public void inserir(ServicosNoOrcamentoVO vo) throws InsertException{
        boolean repetido = false;
        try {
            ResultSet rs = dao.listar();//Verificando se o servico já está no orçamento.
            while(rs.next()){
                if (vo.getOrcamento().getId() == rs.getLong("id_orcamento")){
                    if (vo.getServico().getId() == rs.getLong("id_servico")){
                        repetido = true;
                    }
                } 
            }
            if (repetido) {
                throw new InsertException("Um serviço com esses dados já existe no orçamento!\n.");
            } else {
                dao.inserir(vo);
            }
        } catch (Exception e) {
            throw new InsertException(e.getMessage());
        }
    }

    //listagem
    public List<ServicosNoOrcamentoVO> buscarPorId (ServicosNoOrcamentoVO vo) throws FindException{
        ResultSet rs;
        List<ServicosNoOrcamentoVO> lista = new ArrayList<ServicosNoOrcamentoVO>();
        try {
            rs = dao.findById(vo);
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum serviço com esse Id.\n");
            }
            else{
                rs = dao.findById(vo);
                while(rs.next()){
                    ServicosNoOrcamentoVO vo2 = new ServicosNoOrcamentoVO();
                    vo2.setId(rs.getLong("id"));
                    vo2.setQuantidade(rs.getInt("quantidade"));
                    vo2.setValor(rs.getDouble("valor"));
                    vo2.getOrcamento().setId(rs.getLong("id_orcamento"));
                    vo2.getServico().setId(rs.getLong("id_servico"));
                    lista.add(vo2);
                }
            }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    public List<ServicosNoOrcamentoVO> listar() throws FindException{
        ResultSet rs;
        List<ServicosNoOrcamentoVO> lista = new ArrayList<ServicosNoOrcamentoVO>();
        try {
            rs = dao.listar();
            while(rs.next()){
                ServicosNoOrcamentoVO vo = new ServicosNoOrcamentoVO();
                vo.setId(rs.getLong("id"));
                vo.setQuantidade(rs.getInt("quantidade"));
                vo.setValor(rs.getDouble("valor"));
                vo.getOrcamento().setId(rs.getLong("id_orcamento"));
                vo.getServico().setId(rs.getLong("id_servico"));
                lista.add(vo);
            }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    //Remoção por id
    public void deletar(ServicosNoOrcamentoVO vo) throws DeleteException{
        try {
            dao.removerById(vo);
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }
    
    //Alteração 
    public void editarQuantidade(ServicosNoOrcamentoVO vo) throws UpgradeException{
        try {
            dao.editarQuantidade(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }
    
    public void editarValor(ServicosNoOrcamentoVO vo) throws UpgradeException{
        try {
            dao.editarValor(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }
    public void editarServicoId(ServicosNoOrcamentoVO vo) throws UpgradeException{
        try {
            dao.editarServicoId(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }
    public void editarOrcamentoId(ServicosNoOrcamentoVO vo) throws UpgradeException{
        try {
            dao.editarOrcamentoId(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }
}
