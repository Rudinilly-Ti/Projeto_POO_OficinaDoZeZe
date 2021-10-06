package Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Exceptions.*;
import Model.DAO.ClienteDAO;
import Model.VO.ClienteVO;

public class ClienteBO implements BaseInterBO<ClienteVO>{
	ClienteDAO dao = new ClienteDAO();
	//inserir
    public void inserir(ClienteVO vo) throws InsertException{
        ResultSet rs = dao.findByCPF(vo);
        try {
            if (rs.next()) {
                throw new InsertException("Impossível cadastrar, pois já existe um cliente com esse CPF.\n");
            }
            else{
                dao.inserir(vo);
            }
        } catch (SQLException e) {
            throw new InsertException(e.getMessage());
        }
    }
    
  //listagem
    public List<ClienteVO> buscarPorId (ClienteVO vo) throws FindException{
    	ResultSet rs = dao.findById(vo);
        List<ClienteVO> lista = new ArrayList<ClienteVO>();
        ClienteVO vo2 = new ClienteVO();
        try {
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum cliente com esse Id.\n");
            }
            else{
            	rs = dao.listar();
                while(rs.next()){
                    vo2.setId(rs.getLong("id"));
                    vo2.setNome(rs.getString("nome"));
                    vo2.setEndereco(rs.getString("endereco"));
                    vo2.setCPF(rs.getString("cpf"));
                    lista.add(vo2);
                }
            }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }
    
    public List<ClienteVO> buscarPorNome (ClienteVO vo) throws FindException{
    	ResultSet rs = dao.findByNome(vo);
        List<ClienteVO> lista = new ArrayList<ClienteVO>();
        ClienteVO vo2 = new ClienteVO();
        try {
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum cliente com esse nome.\n");
            }
            else{
            	rs = dao.listar();
                while(rs.next()){
                    vo2.setId(rs.getLong("id"));
                    vo2.setNome(rs.getString("nome"));
                    vo2.setEndereco(rs.getString("endereco"));
                    vo2.setCPF(rs.getString("cpf"));
                    lista.add(vo2);
                }
            }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }
    
    public List<ClienteVO> buscarPorEndereco (ClienteVO vo) throws FindException{
    	ResultSet rs = dao.findByEndereco(vo);
        List<ClienteVO> lista = new ArrayList<ClienteVO>();
        ClienteVO vo2 = new ClienteVO();
        try {
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum cliente com esse endereço.\n");
            }
            else{
            	rs = dao.listar();
                while(rs.next()){
                    vo2.setId(rs.getLong("id"));
                    vo2.setNome(rs.getString("nome"));
                    vo2.setEndereco(rs.getString("endereco"));
                    vo2.setCPF(rs.getString("cpf"));
                    lista.add(vo2);
                }
            }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }
    
    public List<ClienteVO> listar() throws FindException{
    	ResultSet rs = dao.listar();
        List<ClienteVO> lista = new ArrayList<ClienteVO>();
        ClienteVO vo2 = new ClienteVO();
        try {
        	rs = dao.listar();
            while(rs.next()){
            	 vo2.setId(rs.getLong("id"));
                 vo2.setNome(rs.getString("nome"));
                 vo2.setEndereco(rs.getString("endereco"));
                 vo2.setCPF(rs.getString("cpf"));
                 lista.add(vo2);
            }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }
    
  //Remoção por id
    public void deletar(ClienteVO vo){
    	ResultSet rs = dao.findById(vo);
        try {
            if (!rs.next()) {
                throw new DeleteException("Impossível remover, pois não existe um cliente com esse ID.\n");
            }
            else{
            	dao.removerById(vo);
            }
        } catch (SQLException e) {
            throw new DeleteException(e.getMessage());
        }
    }

  //Alteração
    public void editarCPF(ClienteVO vo){
    	ResultSet rs = dao.findById(vo);
        try {
            if (!rs.next()) {
                throw new UpgradeException("Impossível editar, pois não existe um cliente com esse ID.\n");
            }
            else{
            	dao.editarCPF(vo);
            }
        } catch (SQLException e) {
            throw new UpgradeException(e.getMessage());
        }
    }
    
    public void editarEndereco(ClienteVO vo){
    	ResultSet rs = dao.findById(vo);
        try {
            if (!rs.next()) {
                throw new UpgradeException("Impossível editar, pois não existe um cliente com esse ID.\n");
            }
            else{
            	dao.editarEndereco(vo);
            }
        } catch (SQLException e) {
            throw new UpgradeException(e.getMessage());
        }
    } 
    
    public void editarNome(ClienteVO vo){
    	ResultSet rs = dao.findById(vo);
        try {
            if (!rs.next()) {
                throw new UpgradeException("Impossível editar, pois não existe um cliente com esse ID.\n");
            }
            else{
            	dao.editarNome(vo);
            }
        } catch (SQLException e) {
            throw new UpgradeException(e.getMessage());
        }
    }
}
