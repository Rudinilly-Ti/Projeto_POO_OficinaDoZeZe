package Model.VO;
public class ServicoVO {

    private String nome;
    private double preco;

    public String getNome(){
        return nome;
    }    

    public void setNome(String nome){
        if(!nome.isBlank()){
            this.nome = nome;
        }
        else
            System.out.println("Nome inválido");
    }

    public double getPreco(){
        return preco;
    }

    public void setPreco(double preco){
        if(preco > 0){
            this.preco = preco;
        }
    }
}
