package Model.VO;

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
        if (!nometmp.isBlank()) {
            nome = nometmp;
        }
        else System.out.println("Nome inválido.\n");
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double precotmp) {
        if (precotmp > 0) {
            preco = precotmp;
        }
        else System.out.println("Valor inválido.\n");
    }

    public String getFabricante() {
        return fabricante;
    }
    
    public void setFabricante(String fabricantetmp) {
        if (!fabricantetmp.isBlank()) {
            fabricante = fabricantetmp;
        }
        else System.out.println("Nome de fabricante inválido.\n");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
