package Model.VO;
import Exceptions.SetterException;

public class PecaVO {
    private String nome;
    private double preco;
    private String fabricante;
    private Long id;

    public PecaVO(String nome, double preco, String fabricante){
        setNome(nome);
        setPreco(preco);
        setFabricante(fabricante);
    }
    
    public PecaVO(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nometmp) {
        if(nometmp != null){
            if (!(nometmp.isBlank())) {
                nome = nometmp;
            }
            else throw new SetterException("Nome inválido.\n");
        }
        else throw new SetterException("Nome inválido.\n");
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double precotmp) {
        if (precotmp > 0) {
            preco = precotmp;
        }
        else throw new SetterException("Valor inválido.\n");
    }

    public String getFabricante() {
        return fabricante;
    }
    
    public void setFabricante(String fabricantetmp) {
        if(fabricantetmp != null){
            if (!(fabricantetmp.isBlank())) {
                fabricante = fabricantetmp;
            }
            else throw new SetterException("Nome de fabricante inválido.\n");
        }
        else throw new SetterException("Nome de fabricante inválido.\n");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if(id > 0 && id != null){
            this.id = id;
        }
        else {
            throw new SetterException("Valor de Id inválido.\n");
        }
    }
}
