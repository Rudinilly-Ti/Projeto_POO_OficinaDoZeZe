package Model.VO;
public class AutomovelVO {

    private String marca;
    private String cor;
    private String placa;
    private int ano;
    private double quilometragem;
    private ClienteVO dono = new ClienteVO();

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

    public ClienteVO getDono() {
        return dono;
    }

    public void setDono(ClienteVO dono) {
        this.dono = dono;
    }
}