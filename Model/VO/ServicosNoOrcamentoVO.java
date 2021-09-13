package Model.VO;

public class ServicosNoOrcamentoVO {
    private double valor;
    private int quantidade;
    private Long id;
    private ServicoVO servico = new ServicoVO();
    private OrcamentoVO orcamento = new OrcamentoVO();

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade > 0) {
            this.quantidade = quantidade;
        }
        else System.out.println("Quantidade inválida.\n");
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor > 0) {
            this.valor = valor;
        }
        else System.out.println("Valor inválido.\n");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if(id > 0){
            this.id = id;
        }
        else {
            System.out.println("Valor de Id inválido.\n");
        }
    }

    public ServicoVO getServico() {
        return servico;
    }

    public void setServico(ServicoVO servico) {
        if(servico != null){
            this.servico = servico;
        }
        else{
            System.out.println("Serviço inválido.\n");
        }
    }

    public OrcamentoVO getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(OrcamentoVO orcamento) {
        if(orcamento != null){
            this.orcamento = orcamento;
        }
        else{
            System.out.println("Orçamento inválido.\n");
        }
    }
}
