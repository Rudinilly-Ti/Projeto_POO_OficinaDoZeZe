package Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Exceptions.*;
import Model.DAO.AutomovelDAO;
import Model.VO.AutomovelVO;
import Model.VO.ClienteVO;

public class AutomovelBO implements BaseInterBO<AutomovelVO>{
    AutomovelDAO dao = new AutomovelDAO();
    
    //inserir
    public void inserir(AutomovelVO vo) throws InsertException{
        try {
            ResultSet rs = dao.findByPlaca(vo);
            if (rs.next()) {
                throw new InsertException("Impossível cadastrar, pois já existe automóvel com essa placa.\n");
            }
            else{
                dao.inserir(vo);
            }
        } catch (Exception e) {
            throw new InsertException(e.getMessage());
        }
    }

    //listagem
    public List<AutomovelVO> buscarPorId (AutomovelVO vo) throws FindException{
        List<AutomovelVO> lista = new ArrayList<AutomovelVO>();
        try {
            ResultSet rs = dao.findById(vo);
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum carro com esse Id.\n");
            }
            else{
                while(rs.next()){
                    AutomovelVO vo2 = new AutomovelVO();
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
        List<AutomovelVO> lista = new ArrayList<AutomovelVO>();
        try {
            ResultSet rs = dao.findByPlaca(vo);
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum carro com essa placa.\n");
            }
            else{
                while(rs.next()){
                    AutomovelVO vo2 = new AutomovelVO();
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
        } catch (Exception e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }
    
    public List<AutomovelVO> listar() throws FindException{
        List<AutomovelVO> lista = new ArrayList<AutomovelVO>();
        try {
            ResultSet rs = dao.listar();
            while(rs.next()){
                AutomovelVO vo2 = new AutomovelVO();
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

    public List<AutomovelVO> buscarPorDono(ClienteVO voCli) throws FindException{
        AutomovelVO vo = new AutomovelVO();
        vo.getCliente().setId(voCli.getId());//Passa o valor do id inserido para o id de cliente em automovel;
        
        List<AutomovelVO> lista = new ArrayList<AutomovelVO>();
        try {
            ResultSet rs = dao.findByClienteId(vo);
            if (!rs.next()) {
                throw new FindException("Não foi encotrado nenhum carro com esse dono.\n");
            }
            else{
                rs = dao.findByClienteId(vo); 
                while(rs.next()){
                    AutomovelVO vo2 = new AutomovelVO();
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
        } catch (Exception e) {
            throw new FindException(e.getMessage());
        }
        return lista;
    }

    //Remoção por id
    public void deletar(AutomovelVO vo) throws DeleteException{
        try {
            dao.removerById(vo);
        } catch (SQLException e) {
            throw new DeleteException(e.getMessage());
        }
    }

    //Alteração
    public void editarPlaca(AutomovelVO vo) throws UpgradeException{
        try {
            dao.editarPlaca(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }
    public void editarMarca(AutomovelVO vo) throws UpgradeException{
        try {
            dao.editarMarca(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }
    public void editarCor(AutomovelVO vo) throws UpgradeException{
        try {
            dao.editarCor(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }
    public void editarAno(AutomovelVO vo) throws UpgradeException{
        try {
            dao.editarAno(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }
    public void editarClienteId(AutomovelVO vo) throws UpgradeException{
        try {
            dao.editarClienteId(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }
    public void editarQuilometragem(AutomovelVO vo) throws UpgradeException{
        try {
            dao.editarQuilometragem(vo);
        } catch (Exception e) {
            throw new UpgradeException(e.getMessage());
        }
    }
}
