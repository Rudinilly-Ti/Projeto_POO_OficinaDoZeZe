package Model.VO;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

public class OrcamentoVO{
    private double valor;
    private Calendar dataInicio;
    private Calendar dataFim;
    private List<PecaVO> peca = new ArrayList<PecaVO>();
    private ClienteVO cliente = new ClienteVO();
    private List<ServicoVO> servico = new ArrayList<ServicoVO>();
    private AutomovelVO carro = new AutomovelVO();
    
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
        int mes = dataFim.get(Calendar.MONTH);
        int ano = dataFim.get(Calendar.YEAR);

        if ((dia > 0 && dia <= 31) && (mes >= 0 && mes <= 11) && (ano > 0)) {
            //Testando se a data final submetida é igual ou superior à inicial do período.
            if (dataFim.compareTo(dataInicio) >= 0) {
                this.dataFim = dataFim;
            }
            else System.out.println("A data inicial está após a data final inserida. Digite novamente.");
        }
        else System.out.println("Data inválida.\n");
    }

    public List<PecaVO> getPeca() {
        return peca;
    }

    public void setPeca(List<PecaVO> peca) {
        this.peca = peca;
    }

    public ClienteVO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteVO cliente) {
        this.cliente = cliente;
    }

    public List<ServicoVO> getServico() {
        return servico;
    }

    public void setServico(List<ServicoVO> servico) {
        this.servico = servico;
    }

    public AutomovelVO getCarro() {
        return carro;
    }

    public void setCarro(AutomovelVO carro) {
        this.carro = carro;
    }
}
