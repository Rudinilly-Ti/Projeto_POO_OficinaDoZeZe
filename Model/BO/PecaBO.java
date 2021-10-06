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
    	ResultSet rs = dao.findById(vo);
        List<PecaVO> lista = new ArrayList<PecaVO>();
        PecaVO vo2 = new PecaVO();
        try {
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhuma peça com esse Id.\n");
            }
            else{
            	rs = dao.listar();
                while(rs.next()){
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
    	ResultSet rs = dao.findByNome(vo);
        List<PecaVO> lista = new ArrayList<PecaVO>();
        PecaVO vo2 = new PecaVO();
        try {
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhuma peça com esse nome.\n");
            }
            else{
            	rs = dao.listar();
                while(rs.next()){
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
    	ResultSet rs = dao.findByFabricante(vo);
        List<PecaVO> lista = new ArrayList<PecaVO>();
        PecaVO vo2 = new PecaVO();
        try {
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhuma peça com esse fabricante.\n");
            }
            else{
            	rs = dao.listar();
                while(rs.next()){
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
    	ResultSet rs = dao.listar();
        List<PecaVO> lista = new ArrayList<PecaVO>();
        PecaVO vo2 = new PecaVO();
        try {
        	 while(rs.next()){
        		 rs = dao.listar();
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
    public void deletar(PecaVO vo){
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
    
    public void editarNome(PecaVO vo){
    	ResultSet rs = dao.findById(vo);
        try {
            if (!rs.next()) {
                throw new UpgradeException("Impossível editar, pois não existe uma peça com esse ID.\n");
            }
            else{
            	dao.editarNome(vo);
            }
        } catch (SQLException e) {
            throw new UpgradeException(e.getMessage());
        }
    }
    
    public void editarPreco(PecaVO vo){
    	ResultSet rs = dao.findById(vo);
        try {
            if (!rs.next()) {
                throw new UpgradeException("Impossível editar, pois não existe uma peça com esse ID.\n");
            }
            else{
            	dao.editarPreco(vo);
            }
        } catch (SQLException e) {
            throw new UpgradeException(e.getMessage());
        }
    }
    
    public void editarFabricante(PecaVO vo){
    	ResultSet rs = dao.findById(vo);
        try {
            if (!rs.next()) {
                throw new UpgradeException("Impossível editar, pois não existe uma peça com esse ID.\n");
            }
            else{
            	dao.editarFabricante(vo);
            }
        } catch (SQLException e) {
            throw new UpgradeException(e.getMessage());
        }
    }
	
}
