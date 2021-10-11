package Model.VO;

import Exceptions.SetterException;

public class AutomovelVO {
    // atributos

    private String marca;
    private String cor;
    private String placa;
    private int ano;
    private double quilometragem;
    private ClienteVO cliente = new ClienteVO();
    private Long ID;
    
    // construtor
    public AutomovelVO(String marca, String cor, String placa, int ano, double quilometragem, ClienteVO cliente, Long ID){
        setMarca(marca);
        setCor(cor);
        setPlaca(placa);
        setAno(ano);
        setQuilometragem(quilometragem);
        setCliente(cliente);
        setID(ID);
    }

    public AutomovelVO(){
    
    }

    // set's e get's da classe
    public String getMarca() {
        return marca;
    } 

    public void setMarca(String marca) {
    	if(marca != null) {
    		if(!marca.isBlank()){
                this.marca = marca;
            }
    		else
    			throw new SetterException("Marca de automóvel inválida.(Vazio)");
    	}
    	else
    		throw new SetterException("Marca de autómovel inválida. (Nulo)");
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
    	if(cor != null) {
    		if(!cor.isBlank()){
                this.cor = cor;
            }
            else
            	throw new SetterException("Cor de automóvel inválida. (Vazio)");
    	}
    	else
    		throw new SetterException("Cor de automóvel inválida. (Nulo)");
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
    	if(placa != null) {
    		if(!placa.isBlank()){
                this.placa = placa;
            }
            else
            	throw new SetterException("Placa de autómovel inválida. (Vazio)");
    	}
    	else
    		throw new SetterException("Placa de automóvel inválida. (Nulo)");
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if(ano > 0)
           this.ano = ano;       
        else
        	throw new SetterException("Ano do automóvel inválido. (Valor negativo)");
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        if (quilometragem >= 0) {
            this.quilometragem = quilometragem;
        }
        else
        	throw new SetterException("Quilometragem de automóvel inválida. (Valor negativo)");
    }   

    public ClienteVO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteVO cliente) {
    	if(cliente.getId() > 0) {
    		this.cliente = cliente;
    	}
    	else
    		throw new SetterException("ID de cliente inválido. (valor negativo)");
    }

	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		if(ID > 0)
			this.ID = ID;
		else
			throw new SetterException("ID de automóvel inválido. (Valor negativo)");
	}
}
