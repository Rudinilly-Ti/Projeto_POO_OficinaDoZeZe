package Model.VO;

public class UsuarioVO {
  private Long id;
  private String login;
  private String senha;
  private String cargo;

  public UsuarioVO(Long id, String login, String senha, String cargo) {
    setId(id);
    setLogin(login);
    setSenha(senha);
    setCargo(cargo);
  }

  public UsuarioVO() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    if(id > 0 && id != null){
      this.id = id;
    }
    else {
      System.out.println("Valor de Id inválido.\n");
    }
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    if (!login.isBlank() && login != null) {
      this.login = login;  
    }else {
      System.out.println("Login invalido");
    }
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    if (!senha.isBlank() && senha != null) {
      this.senha = senha;
    }else {
      System.out.println("Senha invalido");
    }
  }

  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    if (!cargo.isBlank() && cargo!= null) {
      this.cargo = cargo;
    }else {
      System.out.println("Cargo invalido");
    }
  }
}
