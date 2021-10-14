package Model.BO;

import Model.VO.ChefeVO;
import Model.VO.UsuarioVO;

public class TesteBO {
  public static void main(String[] args) {
  UsuarioBO usuBO = new UsuarioBO();
  UsuarioVO usuVO = new UsuarioVO();

  usuVO.setLogin("login2");
  usuVO.setSenha("senha");

  
  
  UsuarioVO autenticado = usuBO.autenticar(usuVO);
    if (autenticado instanceof ChefeVO) {
      System.out.println("Chefe");
    } else {
      System.out.println("Funcionario");
    }

  }
}
