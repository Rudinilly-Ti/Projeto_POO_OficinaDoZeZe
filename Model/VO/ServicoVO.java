package Model.VO;

public class ServicoVO {

    // atributos
    private String nome;
    private double preco;
    private long id; 

    // construtor da classe
    public ServicoVO(String nome, double preco, long id){
        setNome(nome);
        setPreco(preco);
        setId(id);
    }

    public ServicoVO(){
    
    }

    // set's e get's da classe
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

    public long getId(){
        return id;
    }

    public void setId(long id){
        if(!(id<0))
            this.id = id;
    }
}
