package Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import Exceptions.AuthenticationException;
import Exceptions.FindException;
import Exceptions.InsertException;
import Model.DAO.ChefeDAO;
import Model.DAO.FuncionarioDAO;
import Model.DAO.UsuarioDAO;
import Model.VO.ChefeVO;
import Model.VO.FuncionarioVO;
import Model.VO.UsuarioVO;

public class UsuarioBO implements BaseInterBO<UsuarioVO> {
  private static UsuarioDAO<UsuarioVO> usuDAO = new UsuarioDAO<UsuarioVO>();  
  private static ChefeDAO chefeDAO = new ChefeDAO();  
  private static FuncionarioDAO funcDAO = new FuncionarioDAO(); 

  public UsuarioVO autenticar(UsuarioVO vo) throws AuthenticationException {
    ResultSet usuarioRS = usuDAO.findByLogin(vo);
    
    try {
      if (usuarioRS.next()) {
        if (usuarioRS.getString("senha").equals(vo.getSenha())) {
          ChefeVO chefe = new ChefeVO();
          chefe.setId(usuarioRS.getLong("id"));
  
          ResultSet chefeRS = chefeDAO.findByIdUsuario(chefe);
          if (chefeRS.next()) {
            chefe.setLogin(vo.getLogin());
            chefe.setSenha(vo.getSenha());
            return chefe;
          } else {
            FuncionarioVO funcionario = new FuncionarioVO();
            funcionario.setId(usuarioRS.getLong("id"));
  
            ResultSet funcRS = funcDAO.findByIdUsuario(funcionario);
            if (funcRS.next()) {
              funcionario.setLogin(vo.getLogin());
              funcionario.setSenha(vo.getSenha());
              funcionario.setSalario(funcRS.getDouble("salario"));
              Calendar data = Calendar.getInstance();
              data.setTime(funcRS.getDate("data_admissao"));
              funcionario.setDataDeAdmissao(data);
              return funcionario;
            }
  
            else throw new AuthenticationException("Autenticação falhou");
          } 
  
        }  else throw new AuthenticationException("Autenticação falhou");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return vo;
  }


  @Override
  public void inserir(UsuarioVO vo) throws InsertException {};

  @Override
  public List<UsuarioVO> buscarPorId(UsuarioVO vo) throws FindException{ return null;}; 

  @Override
  public List<UsuarioVO> listar() throws FindException{ return null; }; 

  @Override
  public void deletar(UsuarioVO vo) {}; 
 
}
