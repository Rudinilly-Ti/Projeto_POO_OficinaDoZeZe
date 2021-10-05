package Model.BO;

import java.util.List;

import Exceptions.FindException;
import Exceptions.InsertException;
import Model.VO.UsuarioVO;

public abstract class UsuarioBO implements BaseInterBO<UsuarioVO> {

  @Override
  public abstract void inserir(UsuarioVO vo) throws InsertException;

  @Override
  public abstract List<UsuarioVO> buscarPorId(UsuarioVO vo) throws FindException; 

  @Override
  public abstract List<UsuarioVO> listar() throws FindException; 

  @Override
  public abstract void deletar(UsuarioVO vo); 
}
