package Model.VO;

public class PecaVO {
    private String nome;
    private double preço;
    private String fabricante;

    public String getNome() {
        return nome;
    }

    public void setNome(String nometmp) {
        if (!nometmp.isBlank()) {
            nome = nometmp;
        }
        else System.out.println("Nome inválido.\n");
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preçotmp) {
        if (preçotmp > 0) {
            preço = preçotmp;
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
}
