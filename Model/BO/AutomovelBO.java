package Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Exceptions.*;
import Model.DAO.AutomovelDAO;
import Model.VO.AutomovelVO;

public class AutomovelBO implements BaseInterBO<AutomovelVO>{
    AutomovelDAO dao = new AutomovelDAO();
    
    //inserir
    public void inserir(AutomovelVO vo) throws InsertException{
        ResultSet rs = dao.findByPlaca(vo);
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
    public List<AutomovelVO> buscarPorId (AutomovelVO vo) throws FindException{
        ResultSet rs = dao.findById(vo);
        List<AutomovelVO> lista = new ArrayList<AutomovelVO>();
        AutomovelVO vo2 = new AutomovelVO();
        try {
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum carro com esse Id.\n");
            }
            else{
                while(rs.next()){
                    vo2.setID(rs.getLong("id"));
                    vo2.setAno(rs.getInt("ano"));
                    vo2.getCliente().setId(rs.getLong("id_cliente"));
                    vo2.setCor(rs.getString("cor"));
                    vo2.setMarca(rs.getString("marca"));
                    vo2.setPlaca(rs.getString("placa"));
                    vo2.setQuilometragem(rs.getDouble("quilometragem"));
                    lista.add(vo2);
                }
            }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    public List<AutomovelVO> buscarPorPlaca (AutomovelVO vo) throws FindException{
        ResultSet rs = dao.findByPlaca(vo);
        List<AutomovelVO> lista = new ArrayList<AutomovelVO>();
        AutomovelVO vo2 = new AutomovelVO();
        try {
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum carro com essa placa.\n");
            }
            else{
                while(rs.next()){
                    vo2.setID(rs.getLong("id"));
                    vo2.setAno(rs.getInt("ano"));
                    vo2.getCliente().setId(rs.getLong("id_cliente"));
                    vo2.setCor(rs.getString("cor"));
                    vo2.setMarca(rs.getString("marca"));
                    vo2.setPlaca(rs.getString("placa"));
                    vo2.setQuilometragem(rs.getDouble("quilometragem"));
                    lista.add(vo2);
                }
            }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    public List<AutomovelVO> buscarPorClienteId (AutomovelVO vo) throws FindException{
        ResultSet rs = dao.findByClienteId(vo);
        List<AutomovelVO> lista = new ArrayList<AutomovelVO>();
        AutomovelVO vo2 = new AutomovelVO();
        try {
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum carro com esse dono.\n");
            }
            else{
                while(rs.next()){
                    vo2.setID(rs.getLong("id"));
                    vo2.setAno(rs.getInt("ano"));
                    vo2.getCliente().setId(rs.getLong("id_cliente"));
                    vo2.setCor(rs.getString("cor"));
                    vo2.setMarca(rs.getString("marca"));
                    vo2.setPlaca(rs.getString("placa"));
                    vo2.setQuilometragem(rs.getDouble("quilometragem"));
                    lista.add(vo2);
                }
            }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }
        
    public List<AutomovelVO> listar() throws FindException{
        ResultSet rs = dao.listar();
        List<AutomovelVO> lista = new ArrayList<AutomovelVO>();
        AutomovelVO vo2 = new AutomovelVO();
        try {
            while(rs.next()){
                vo2.setID(rs.getLong("id"));
                vo2.setAno(rs.getInt("ano"));
                vo2.getCliente().setId(rs.getLong("id_cliente"));
                vo2.setCor(rs.getString("cor"));
                vo2.setMarca(rs.getString("marca"));
                vo2.setPlaca(rs.getString("placa"));
                vo2.setQuilometragem(rs.getDouble("quilometragem"));
                lista.add(vo2);
            }
        } catch (SQLException e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    //Remoção por id
    public void deletar(AutomovelVO vo){
        dao.removerById(vo);
    }

    //Alteração
    public void editarPlaca(AutomovelVO vo){
        dao.editarPlaca(vo);
    }
    public void editarMarca(AutomovelVO vo){
        dao.editarMarca(vo);
    }
    public void editarCor(AutomovelVO vo){
        dao.editarCor(vo);
    }
    public void editarAno(AutomovelVO vo){
        dao.editarAno(vo);
    }
    public void editarClienteId(AutomovelVO vo){
        dao.editarClienteId(vo);
    }
    public void editarQuilometragem(AutomovelVO vo){
        dao.editarQuilometragem(vo);
    }
}
