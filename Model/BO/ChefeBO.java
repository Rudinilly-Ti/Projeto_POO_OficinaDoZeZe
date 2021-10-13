package Model.BO;

import java.lang.module.FindException;
import java.sql.ResultSet;
import java.util.List;

import Exceptions.*;

import Model.DAO.ChefeDAO;
import Model.VO.ChefeVO;

public class ChefeBO implements BaseInterBO<ChefeVO>{
  ChefeDAO dao = new ChefeDAO();

  @Override
  public void inserir(ChefeVO vo) throws InsertException {
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
  
  @Override
  public List<ChefeVO> listar() throws FindException {
    return null;
  };

  @Override
  public List<ChefeVO> buscarPorId(ChefeVO vo) throws FindException {
    return null;
  }

  @Override
  public void deletar(ChefeVO vo){}
}
