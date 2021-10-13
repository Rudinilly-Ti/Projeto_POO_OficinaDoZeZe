package Model.BO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Exceptions.*;
import Model.DAO.FuncionarioDAO;
import Model.VO.FuncionarioVO;

public class FuncionarioBO  implements BaseInterBO<FuncionarioVO>{
  FuncionarioDAO dao = new FuncionarioDAO();

  @Override
  public void inserir(FuncionarioVO vo) throws InsertException {
    ResultSet rs = dao.findByLogin(vo);
    try {
      if(rs.next()){
        throw new InsertException("Este login não está disponível");
      } else {
        dao.inserir(vo);
      }
    } catch (Exception e) {
      throw new InsertException(e.getMessage());
    }
  }

  public List<FuncionarioVO> buscarPorDataAdimissao(FuncionarioVO vo) throws FindException {
    ResultSet rs = dao.findByDataAdmissao(vo);
    List<FuncionarioVO> lista = new ArrayList<FuncionarioVO>();
    FuncionarioVO vo2 = new FuncionarioVO();
    try {
      if (!rs.next()) {
        throw new FindException("Nenhum resultado encontrado");
      } else {
        rs = dao.findByDataAdmissao(vo);
        while (rs.next()) {
          vo2.setId(rs.getLong("id_usuario"));
          vo2.setSalario(rs.getDouble("salario"));
          Calendar data = Calendar.getInstance();
          data.setTime(rs.getDate("data_admissao"));
          vo2.setDataDeAdmissao(data);
          ResultSet user = dao.findById(vo2);
          if(user.next()){
            vo2.setLogin(user.getString("login"));
            vo2.setSenha(user.getString("senha"));
          }
          lista.add(vo2);
        }
      }

    } catch (Exception e) {
      throw new FindException(e.getMessage());
    }

    return lista;
  }

  public List<FuncionarioVO> buscarPorSalario(FuncionarioVO vo) throws FindException {
    ResultSet rs = dao.findBySalario(vo);
    List<FuncionarioVO> lista = new ArrayList<FuncionarioVO>();
    FuncionarioVO vo2 = new FuncionarioVO();
    try {
      if (!rs.next()) {
        throw new FindException("Nenhum resultado encontrado");
      } else {
        rs = dao.findBySalario(vo);
        while (rs.next()) {
          vo2.setId(rs.getLong("id_usuario"));
          vo2.setSalario(rs.getDouble("salario"));
          Calendar data = Calendar.getInstance();
          data.setTime(rs.getDate("data_admissao"));
          vo2.setDataDeAdmissao(data);
          ResultSet user = dao.findById(vo2);
          if(user.next()){
            vo2.setLogin(user.getString("login"));
            vo2.setSenha(user.getString("senha"));
          }
          lista.add(vo2);
        }
      }

    } catch (Exception e) {
      throw new FindException(e.getMessage());
    }

    return lista;
  }

  public void editarSalario(FuncionarioVO vo) throws UpgradeException{
    ResultSet rs = dao.findByIdUsuario(vo);
    try {
      if (!rs.next()) {
        throw new UpgradeException("Impossível atualizar, funcionario não encontrado");
      } else{
        dao.editarSalario(vo); 
      }
    } catch (Exception e) {
      throw new UpgradeException(e.getMessage());
    }
  }

  public void editarDataAdmissao(FuncionarioVO vo) throws UpgradeException {
    ResultSet rs = dao.findByIdUsuario(vo);
    try {
      if (!rs.next()) {
        throw new UpgradeException("Impossível atualizar, funcionario não encontrado");
      } else{
        dao.editarDataAdmissao(vo); 
      }
    } catch (Exception e) {
      throw new UpgradeException(e.getMessage());
    }
  }

  @Override
  public List<FuncionarioVO> buscarPorId(FuncionarioVO vo) throws FindException {
    return null;
  }

  @Override
  public List<FuncionarioVO> listar() throws FindException {
    return null;
  }

  @Override
  public void deletar(FuncionarioVO vo) throws DeleteException {}

}
