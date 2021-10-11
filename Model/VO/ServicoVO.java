package Model.VO;

import Exceptions.SetterException;

public class ServicoVO {
    // atributos
    private String nome;
    private double preco;
    private Long id; 

    // construtor da classe
    public ServicoVO(String nome, double preco, Long id){
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
    	if(nome != null) {
    		if(!nome.isBlank()){
                this.nome = nome;
            }
            else
            	throw new SetterException("Nome de serviço inválido. (Vazio)");
    	}
    	else
    		throw new SetterException("Nome de serviço inválido. (Nulo)");
    }

    public double getPreco(){
        return preco;
    }

    public void setPreco(double preco){
        if(preco > 0){
            this.preco = preco;
        }
        else
        	throw new SetterException("Preço de serviço inválido. (Valor negativo)");
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        if(id > 0){
            this.id = id;
        }
        else
        	throw new SetterException("ID de serviço inválido. (Valor negativo)");
    }
}
