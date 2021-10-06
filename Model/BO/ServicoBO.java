package Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Exceptions.*;
import Model.DAO.ServicoDAO;
import Model.VO.ServicoVO;

public class ServicoBO implements BaseInterBO<ServicoVO> {
	ServicoDAO dao = new ServicoDAO();
    
    //inserir
    public void inserir(ServicoVO vo) throws InsertException{
        ResultSet rs = dao.findByNome(vo);
        try {
            if (rs.next()) {
                throw new InsertException("Impossível cadastrar, pois já existe um serviço com esse nome.\n");
            }
            else{
                dao.inserir(vo);
            }
        } catch (SQLException e) {
            throw new InsertException(e.getMessage());
        }
    }

    //listagem
    public List<ServicoVO> buscarPorId (ServicoVO vo) throws FindException{
    	ResultSet rs = dao.findById(vo);
        List<ServicoVO> lista = new ArrayList<ServicoVO>();
        ServicoVO vo2 = new ServicoVO();
        try {
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum serviço com esse Id.\n");
            }
            else{
            	rs = dao.listar();
                while(rs.next()){
                    vo2.setId(rs.getLong("id"));
                    vo2.setNome(rs.getString("nome"));
                    vo2.setPreco(rs.getDouble("preco"));
                    lista.add(vo2);
                }
            }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    public List<ServicoVO> buscarPorNome (ServicoVO vo) throws FindException{
    	ResultSet rs = dao.findByNome(vo);
        List<ServicoVO> lista = new ArrayList<ServicoVO>();
        ServicoVO vo2 = new ServicoVO();
        try {
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum serviço com esse nome.\n");
            }
            else{
            	rs = dao.listar();
                while(rs.next()){
                	vo2.setId(rs.getLong("id"));
                    vo2.setNome(rs.getString("nome"));
                    vo2.setPreco(rs.getDouble("preco"));
                    lista.add(vo2);
                }
            }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }
        
    public List<ServicoVO> listar() throws FindException{
    	ResultSet rs = dao.listar();
    	List<ServicoVO> lista = new ArrayList<ServicoVO>();
        ServicoVO vo2 = new ServicoVO();
        try {
        	rs = dao.listar();
            while(rs.next()){
            	vo2.setId(rs.getLong("id"));
                vo2.setNome(rs.getString("nome"));
                vo2.setPreco(rs.getDouble("preco"));
                lista.add(vo2);
            }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    //Remoção por id
    
    public void deletar(ServicoVO vo) {
    	ResultSet rs = dao.findById(vo);
        try {
            if (!rs.next()) {
                throw new DeleteException("Impossível remover, pois não existe um serviço com esse ID.\n");
            }
            else{
            	dao.removerById(vo);
            }
        } catch (SQLException e) {
            throw new DeleteException(e.getMessage());
        }
    }

    //Alteração
    
    public void editarNome(ServicoVO vo) throws UpgradeException{
    	ResultSet rs = dao.findById(vo);
        try {
            if (!rs.next()) {
                throw new UpgradeException("Impossível editar, pois não existe um serviço com esse ID.\n");
            }
            else{
            	dao.editarNomeById(vo);
            }
        } catch (SQLException e) {
            throw new UpgradeException(e.getMessage());
        }
    }
    
    public void editarPreco(ServicoVO vo) throws UpgradeException{
    	ResultSet rs = dao.findById(vo);
        try {
            if (!rs.next()) {
                throw new UpgradeException("Impossível editar, pois não existe um serviço com esse ID.\n");
            }
            else{
            	 dao.editarPrecoById(vo);
            }
        } catch (SQLException e) {
            throw new UpgradeException(e.getMessage());
        }
    }
    
}
