package Model.VO;

import java.util.Calendar;

public class FuncionarioVO extends UsuarioVO {
    private double salario;
    private Calendar dataDeAdmissao;
    
    public void oficina(){

    }
    
    public FuncionarioVO(String login, String senha, double salario, Calendar dataDeAdmissao){
        setLogin(login);
        setSenha(senha);
        setSalario(salario);
        setDataDeAdmissao(dataDeAdmissao);
    }

    public FuncionarioVO(){}

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if(salario > 0){
            this.salario = salario;
        }
        else{
            System.out.println("Valor inválido.\n");
        }
    }
    
    public void setDataDeAdmissao(Calendar dataDeAdmissao) {
        int dia = dataDeAdmissao.get(Calendar.DAY_OF_MONTH);
        int mes = dataDeAdmissao.get(Calendar.MONTH);
        int ano = dataDeAdmissao.get(Calendar.YEAR);
        Calendar diaDoCadastro = Calendar.getInstance();
        if ((dia > 0 && dia <= 31) && (mes >= 0 && mes <= 11) && (ano > 0)) {
            //Verificando se a data de contrato do funcionario é plausível com a do cadastro no sistema.
            if(diaDoCadastro.compareTo(dataDeAdmissao) >= 0){
                this.dataDeAdmissao = dataDeAdmissao; 
            }
        }
        else System.out.println("Data inválida.\n");
    }

    public Calendar getDataDeAdmissao() {
        return dataDeAdmissao;
    }
}
