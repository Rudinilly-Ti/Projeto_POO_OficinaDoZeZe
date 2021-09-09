package Model.VO;

public class AutomovelVO {
    // atributos

    private String marca;
    private String cor;
    private String placa;
    private int ano;
    private double quilometragem;
    private ClienteVO cliente = new ClienteVO();
    
    // construtor
    public AutomovelVO(String marca, String cor, String placa, int ano, double quilometragem, ClienteVO cliente){
        setMarca(marca);
        setCor(cor);
        setPlaca(placa);
        setAno(ano);
        setQuilometragem(quilometragem);
        setCliente(cliente);
    }

    public AutomovelVO(){
    
    }

    // set's e get's da classe
    public String getMarca() {
        return marca;
    } 

    public void setMarca(String marca) {

        if(!marca.isBlank()){
            this.marca = marca;
        }
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        if(!cor.isBlank()){
            this.cor = cor;
        }
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        if(!placa.isBlank()){
            this.placa = placa;
        }
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if(ano > 0){
            this.ano = ano;

        }       
        else
            System.out.println("Valor inválido, tente novamente!\n");
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        if (quilometragem > 0) {
            this.quilometragem = quilometragem;
        }
        else
            System.out.println("Valor inválido, tente novamente!\n");
    }   

    public ClienteVO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteVO cliente) {
        this.cliente = cliente;
    }
}
