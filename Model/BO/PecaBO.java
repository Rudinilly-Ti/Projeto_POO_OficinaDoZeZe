package Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Exceptions.*;
import Model.DAO.PecaDAO;
import Model.VO.PecaVO;

public class PecaBO implements BaseInterBO<PecaVO>{
	PecaDAO dao = new PecaDAO();
	
	//inserir
    public void inserir(PecaVO vo) throws InsertException{
        ResultSet rs = dao.findByNome(vo);
        try {
            if (rs.next()) {
                throw new InsertException("Impossível cadastrar, pois já existe uma peça com esse nome.\n");
            }
            else{
                dao.inserir(vo);
            }
        } catch (SQLException e) {
            throw new InsertException(e.getMessage());
        }
    }
    
  //listagem
    public List<PecaVO> buscarPorId (PecaVO vo) throws FindException{
        List<PecaVO> lista = new ArrayList<PecaVO>();
        try {
        	ResultSet rs = dao.findById(vo);
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhuma peça com esse Id.\n");
            }
            else{
            	rs = dao.findById(vo);
                while(rs.next()){
                	PecaVO vo2 = new PecaVO();
                    vo2.setId(rs.getLong("id"));
                    vo2.setNome(rs.getString("nome"));
                    vo2.setPreco(rs.getDouble("preco"));
                    vo2.setFabricante(rs.getString("fabricante"));
                    lista.add(vo2);
                }
            }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }
    
    public List<PecaVO> buscarPorNome (PecaVO vo) throws FindException{
        List<PecaVO> lista = new ArrayList<PecaVO>();
        try {
        	ResultSet rs = dao.findByNome(vo);
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhuma peça com esse nome.\n");
            }
            else{
            	rs = dao.findByNome(vo);
                while(rs.next()){
                	PecaVO vo2 = new PecaVO();
                    vo2.setId(rs.getLong("id"));
                    vo2.setNome(rs.getString("nome"));
                    vo2.setPreco(rs.getDouble("preco"));
                    vo2.setFabricante(rs.getString("fabricante"));
                    lista.add(vo2);
                }
            }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }
    
    public List<PecaVO> buscarPorFabricante (PecaVO vo) throws FindException{
        List<PecaVO> lista = new ArrayList<PecaVO>();
        try {
        	ResultSet rs = dao.findByFabricante(vo);
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhuma peça com esse fabricante.\n");
            }
            else{
            	rs = dao.findByFabricante(vo);
                while(rs.next()){
                	PecaVO vo2 = new PecaVO();
                    vo2.setId(rs.getLong("id"));
                    vo2.setNome(rs.getString("nome"));
                    vo2.setPreco(rs.getDouble("preco"));
                    vo2.setFabricante(rs.getString("fabricante"));
                    lista.add(vo2);
                }
            }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }
    
    public List<PecaVO> listar() throws FindException{
        List<PecaVO> lista = new ArrayList<PecaVO>();
        try {
        	ResultSet rs = dao.listar();
        	 while(rs.next()){
        		 PecaVO vo2 = new PecaVO();
                 vo2.setId(rs.getLong("id"));
                 vo2.setNome(rs.getString("nome"));
                 vo2.setPreco(rs.getDouble("preco"));
                 vo2.setFabricante(rs.getString("fabricante"));
                 lista.add(vo2);
        	 }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }
    
  //Remoção por id
    public void deletar(PecaVO vo) throws DeleteException{
    	ResultSet rs = dao.findById(vo);
        try {
            if (!rs.next()) {
                throw new DeleteException("Impossível remover, pois não existe uma peça com esse ID.\n");
            }
            else{
            	dao.removerById(vo);
            }
        } catch (SQLException e) {
            throw new DeleteException(e.getMessage());
        }
    }
    
  //Alteração
    
    public void editarNome(PecaVO vo) throws UpgradeException{
        try {
        	dao.editarNome(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }
    
    public void editarPreco(PecaVO vo) throws UpgradeException{
        try {
        	dao.editarPreco(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }
    
    public void editarFabricante(PecaVO vo) throws UpgradeException{
        try {
        	dao.editarFabricante(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }
	
}
