package Model.VO;

public class UsuarioVO {
  private String login;
  private String senha;
  private String cargo;

  public UsuarioVO(String login, String senha, String cargo) {
    setLogin(login);
    setSenha(senha);
    setCargo(cargo);
  }

  public UsuarioVO() {
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    if (!login.isBlank()) {
      this.login = login;  
    }else {
      System.out.println("Login invalido");
    }
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    if (!senha.isBlank()) {
    this.senha = senha;
    }else {
      System.out.println("Senha invalido");
    }
  }

  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    if (!cargo.isBlank()) {
      this.cargo = cargo;
    }else {
      System.out.println("Cargo invalido");
    }
  }
}