package Model.VO;

public class ClienteVO {
  private Long id;
  private String nome;
  private String endereco;
  private String cpf;

  public ClienteVO(Long id, String nome, String endereco, String cpf) {
    setId(id);
    setNome(nome);
    setEndereco(endereco);
    setCPF(cpf);
  }

  public ClienteVO() {
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

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    if (!nome.isBlank() && nome != null) {
      this.nome = nome;
    }else {
      System.out.println("Nome invalido");
    }
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    if (!endereco.isBlank() && endereco != null) {
      this.endereco = endereco;
    }else {
      System.out.println("Endereço invalido");
    }
  }

  public String getCPF() {
    return cpf;
  }

  public void setCPF(String cpf) {
    if (!cpf.isBlank() && cpf != null) {
      this.cpf = cpf; 
    }else {
      System.out.println("CPF invalido");
    }
  }
}
