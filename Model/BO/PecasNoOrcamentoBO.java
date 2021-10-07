package Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Exceptions.*;
import Model.DAO.*;
import Model.VO.*;

public class PecasNoOrcamentoBO implements BaseInterBO<PecasNoOrcamentoVO>{
    PecasNoOrcamentoDAO dao = new PecasNoOrcamentoDAO();
	
	//inserir
    public void inserir(PecasNoOrcamentoVO vo) throws InsertException{
        boolean repetido = false;
        try {
            ResultSet rs = dao.listar();//Verificando se a peça já está no orçamento.
            while(rs.next()){
                if (vo.getOrcamento().getId() == rs.getLong("id_orcamento")){
                    if (vo.getPeca().getId() == rs.getLong("id_peca")){
                        repetido = true;
                    }
                } 
            }
            if (repetido) {
                throw new InsertException("Uma peça com esses dados já existe no orçamento!\n.");
            } else {
                dao.inserir(vo);
            }
        } catch (Exception e) {
            throw new InsertException(e.getMessage());
        }
    }

    //listagem
    public List<PecasNoOrcamentoVO> buscarPorId (PecasNoOrcamentoVO vo) throws FindException{
        ResultSet rs;
        List<PecasNoOrcamentoVO> lista = new ArrayList<PecasNoOrcamentoVO>();
        try {
            rs = dao.findById(vo);
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhuma peça com esse Id.\n");
            }
            else{
                rs = dao.findById(vo);
                while(rs.next()){
                    PecasNoOrcamentoVO vo2 = new PecasNoOrcamentoVO();
                    vo2.setId(rs.getLong("id"));
                    vo2.setQuantidade(rs.getInt("quantidade"));
                    vo2.setValor(rs.getDouble("valor"));
                    vo2.getOrcamento().setId(rs.getLong("id_orcamento"));
                    vo2.getPeca().setId(rs.getLong("id_peca"));
                    lista.add(vo2);
                }
            }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    public List<PecasNoOrcamentoVO> buscarPorAutomovel (AutomovelVO voCar) throws FindException{
        OrcamentoVO voOrc = new OrcamentoVO();
        OrcamentoDAO daoOrc = new OrcamentoDAO();
        voOrc.getCarro().setID(voCar.getID());//Passa o valor do id inserido para o id de automovel em orcamento;
        ResultSet rs;
        ResultSet rs2;

        List<PecasNoOrcamentoVO> lista = new ArrayList<PecasNoOrcamentoVO>();
        try {
            rs = daoOrc.findByAutomovelId(voOrc);
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum orçamento com esse veículo.\n");
            }
            else{
                rs = daoOrc.findByAutomovelId(voOrc);
                while(rs.next()){
                    PecasNoOrcamentoVO vo = new PecasNoOrcamentoVO();
                    vo.getOrcamento().setId(rs.getLong("id"));//Passa o valor do id inserido para o id de orcamento em pecas no orcamento;
                    rs2 = dao.findByOrcamentoId(vo);
                    while(rs2.next()){
                        PecasNoOrcamentoVO vo2 = new PecasNoOrcamentoVO();
                        vo2.setId(rs2.getLong("id"));
                        vo2.setQuantidade(rs2.getInt("quantidade"));
                        vo2.setValor(rs2.getDouble("valor"));
                        vo2.getOrcamento().setId(rs2.getLong("id_orcamento"));
                        vo2.getPeca().setId(rs2.getLong("id_peca"));
                        lista.add(vo2);
                    }
                }
            }
        } catch (Exception e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    public List<PecasNoOrcamentoVO> listar() throws FindException{
        ResultSet rs;
        List<PecasNoOrcamentoVO> lista = new ArrayList<PecasNoOrcamentoVO>();
        
        try {
            rs = dao.listar();
            while(rs.next()){
                PecasNoOrcamentoVO vo = new PecasNoOrcamentoVO();
                vo.setId(rs.getLong("id"));
                vo.setQuantidade(rs.getInt("quantidade"));
                vo.setValor(rs.getDouble("valor"));
                vo.getOrcamento().setId(rs.getLong("id_orcamento"));
                vo.getPeca().setId(rs.getLong("id_peca"));
                lista.add(vo);
            }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    //Remoção por id
    public void deletar(PecasNoOrcamentoVO vo) throws DeleteException{
        try {
            dao.removerById(vo);
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }
    
    //Alteração 
    public void editarQuantidade(PecasNoOrcamentoVO vo) throws UpgradeException{
        try {
            dao.editarQuantidade(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }
    
    public void editarValor(PecasNoOrcamentoVO vo) throws UpgradeException{
        try {
            dao.editarValor(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }
    public void editarPecaId(PecasNoOrcamentoVO vo) throws UpgradeException{
        try {
            dao.editarPecaId(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }
    public void editarOrcamentoId(PecasNoOrcamentoVO vo) throws UpgradeException{
        try {
            dao.editarOrcamentoId(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }
}
