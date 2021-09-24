package Model.VO;

public abstract class UsuarioVO {
  private Long id;
  private String login;
  private String senha;

  public abstract void oficina();

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
}
