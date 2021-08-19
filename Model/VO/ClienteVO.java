package Model.VO;

public class ClienteVO {
  private String nome;
  private String endereço;
  private String cpf;

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    if (!nome.isBlank()) {
      this.nome = nome;
    }else {
      System.out.println("Nome invalido");
    }
  }

  public String getEndereço() {
    return this.endereço;
  }

  public void setEndereço(String endereço) {
    if (!endereço.isBlank()) {
      this.endereço = endereço;
    }else {
      System.out.println("Endereço invalido");
    }
  }

  public String getCPF() {
    return this.cpf;
  }

  public void setCPF(String cpf) {
    if (!cpf.isBlank()) {
      this.cpf = cpf; 
    }else {
      System.out.println("CPF invalido");
    }
  }
}
