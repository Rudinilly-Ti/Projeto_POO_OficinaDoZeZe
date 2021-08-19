package Model.VO;

public class UsuarioVO {
private String login;
private String senha;
private String cargo;

public String getLogin() {
  return this.login;
}

public void setLogin(String login) {
  if (!login.isBlank()) {
    this.login = login;  
  }else {
    System.out.println("Login invalido");
  }
}

public String getSenha() {
  return this.senha;
}

public void setSenha(String senha) {
  if (!senha.isBlank()) {
  this.senha = senha;
  }else {
    System.out.println("Senha invalido");
  }
}

public String getCargo() {
  return this.cargo;
}

public void setCargo(String cargo) {
  if (!cargo.isBlank()) {
    this.cargo = cargo;
  }else {
    System.out.println("Cargo invalido");
  }
}
}