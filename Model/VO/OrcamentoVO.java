package Model.VO;
import java.util.Calendar;
import Exceptions.SetterException;

public class OrcamentoVO {
    private double valor;
    private Calendar dataInicio;
    private Calendar dataFim;
    private ClienteVO cliente = new ClienteVO();
    private AutomovelVO carro = new AutomovelVO();
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if(id > 0 && id != null){
            this.id = id;
        }
        else{
<<<<<<< HEAD
            throw new SetterException("Valor de Id inválido.\n");
=======
            throw new SetterException("Valor de Id inválido.");
>>>>>>> 9ec1e8cd93337f6e7bf185974c2a7e84d222a1e2
        }
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor > 0) {
            this.valor = valor;    
<<<<<<< HEAD
        } 
        else throw new SetterException("Valor inválido.");
=======
        } else throw new SetterException("Valor inválido.");
>>>>>>> 9ec1e8cd93337f6e7bf185974c2a7e84d222a1e2
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
        else throw new SetterException("Data inválida.");
<<<<<<< HEAD
        
=======
>>>>>>> 9ec1e8cd93337f6e7bf185974c2a7e84d222a1e2
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
            else throw new SetterException("A data inicial está após a data final inserida. Digite novamente.");
        }
<<<<<<< HEAD
        else throw new SetterException("Data inválida.\n");
=======
        else throw new SetterException("Data inválida.");
>>>>>>> 9ec1e8cd93337f6e7bf185974c2a7e84d222a1e2
    }

    public ClienteVO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteVO cliente) {
        if(cliente != null){
            this.cliente = cliente;
        }
        else{
<<<<<<< HEAD
            throw new SetterException("Cliente inválido.\n");
=======
            throw new SetterException("Ciente inválido.");
>>>>>>> 9ec1e8cd93337f6e7bf185974c2a7e84d222a1e2
        }
    }

    public AutomovelVO getCarro() {
        return carro;
    }

    public void setCarro(AutomovelVO carro) {
        if(carro != null){
            this.carro = carro;
        }
        else{
<<<<<<< HEAD
            throw new SetterException("Carro inválido.\n");
=======
            throw new SetterException("Carro inválido.");
>>>>>>> 9ec1e8cd93337f6e7bf185974c2a7e84d222a1e2
        }
    }
}
