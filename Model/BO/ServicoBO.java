package Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Exceptions.*;
import Model.DAO.ServicoDAO;
import Model.VO.ServicoVO;

public class ServicoBO implements baseInterBO<ServicoVO> {
	ServicoDAO dao = new ServicoDAO();
    
    //inserir
    public void inserir(ServicoVO vo) throws InsertException{
        ResultSet rs = dao.findById(vo);
        try {
            if (rs.next()) {
                throw new InsertException("Impossível cadastrar, pois já existe automóvel com essa placa.\n");
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
                throw new FindException("Não foi encotrado nenhum carro com esse Id.\n");
            }
            else{
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
                throw new FindException("Não foi encotrado nenhum carro com essa placa.\n");
            }
            else{
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

    public List<ServicoVO> buscarPorPreco (ServicoVO vo) throws FindException{
        ResultSet rs = dao.findByPreco(vo);
        List<ServicoVO> lista = new ArrayList<ServicoVO>();
        ServicoVO vo2 = new ServicoVO();
        try {
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum carro com esse dono.\n");
            }
            else{
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
    public void deletar(ServicoVO vo){
        dao.removerById(vo);
    }

    //Alteração
    public void editarPlaca(ServicoVO vo){
        dao.editarNomeById(vo);
    }
    public void editarMarca(ServicoVO vo){
        dao.editarPrecoById(vo);
    }
    
}
