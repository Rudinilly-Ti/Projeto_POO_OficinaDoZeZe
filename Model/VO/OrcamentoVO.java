package Model.VO;
import java.util.Calendar;

public class OrcamentoVO{
    private int qntPeca;
    private int qntServico;
    private double valor;
    private Calendar dataInicio;
    private Calendar dataFim;
    private PecaVO [] peca = new PecaVO[qntPeca];
    private ClienteVO cliente = new ClienteVO();
    private ServicoVO [] servico = new ServicoVO[qntServico];
    private AutomovelVO carro = new AutomovelVO();
    
    public int getQntPeca() {
        return qntPeca;
    }

    public void setQntPeca(int qntPeca) {
        if (qntPeca >= 0) {
            this.qntPeca = qntPeca;
        }
        else System.out.println("Quantidade de peça(s) inválida.\n");
    }

    public int getQntServico() {
        return qntServico;
    }

    public void setQntServico(int qntServico) {
        if (qntServico >= 0) {
            this.qntServico = qntServico;
        }
        else System.out.println("Quantidade de serviço(s) inválida.\n");
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor > 0) {
            this.valor = valor;    
        } else System.out.println("Valor inválido.\n");
    }

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        int dia = dataInicio.get(Calendar.DAY_OF_MONTH);
        int mes = dataInicio.get(Calendar.MONTH);
        int ano = dataInicio.get(Calendar.YEAR);

        if ((dia > 0 && dia <= 31) && (mes >= 0 && mes <= 11) && (ano > 0)) {
            this.dataInicio = dataInicio;
        }
        else System.out.println("Data inválida.\n");
    }

    public Calendar getDataFim() {
        return dataFim;
    }

    public void setDataFim(Calendar dataFim) {
        int dia = dataFim.get(Calendar.DAY_OF_MONTH);
        int mes = dataFim .get(Calendar.MONTH);
        int ano = dataFim.get(Calendar.YEAR);

        if ((dia > 0 && dia <= 31) && (mes >= 0 && mes <= 11) && (ano > 0)) {
            if (dia >= diaInicio && mes >= mesInicio && ano >= anoInicio) 
                this.dataFim = dataFim;
            else System.out.println("Data inicial está após a data final inserida. Digite novamente.\n");
        }
        else System.out.println("Data inválida.\n");
    }

    public PecaVO[] getPeca() {
        return peca;
    }

    public void setPeca(PecaVO[] peca) {
        this.peca = peca;
    }

    public ClienteVO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteVO cliente) {
        this.cliente = cliente;
    }

    public ServicoVO[] getServico() {
        return servico;
    }

    public void setServico(ServicoVO[] servico) {
        this.servico = servico;
    }

    public AutomovelVO getCarro() {
        return carro;
    }

    public void setCarro(AutomovelVO carro) {
        this.carro = carro;
    }
}
