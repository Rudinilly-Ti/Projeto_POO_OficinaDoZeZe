package Model.VO;

import Exceptions.SetterException;

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
        else throw new SetterException("Quantidade inválida.\n");
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor > 0) {
            this.valor = valor;
        }
        else throw new SetterException("Valor inválido.\n");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if(id > 0){
            this.id = id;
        }
        else {
            throw new SetterException("Valor de Id inválido.\n");
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
            throw new SetterException("Serviço inválido.\n");
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
            throw new SetterException("Orçamento inválido.\n");
        }
    }
}
