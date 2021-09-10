package model.vo;

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
    			System.out.println("Marca inválida!");
    	}
    	else
    		System.out.println("Marca com valor nulo!");
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
            	System.out.println("Cor inválida!");
    	}
    	else
    		System.out.println("Cor com valor nulo!");
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
            	System.out.println("Placa inválida!");
    	}
    	else
    		System.out.println("Placa com valor nulo!");
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if(ano > 0)
           this.ano = ano;       
        else
           System.out.println("Valor inválido, tente novamente!");
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        if (quilometragem >= 0) {
            this.quilometragem = quilometragem;
        }
        else
            System.out.println("Valor inválido, tente novamente!");
    }   

    public ClienteVO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteVO cliente) {
        this.cliente = cliente;
    }

	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		if(ID > 0)
			this.ID = ID;
		else
			System.out.println("ID incorreto!");
	}
}
