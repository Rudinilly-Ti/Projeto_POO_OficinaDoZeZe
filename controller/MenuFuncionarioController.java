package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import view.Telas;

public class MenuFuncionarioController {

    @FXML
    private Button botaoAutomoveis; // Direciona para buscar de automovel

    @FXML
    private Text userLogin; //Exibe o login do usuário

    @FXML
    private Button botaoCliente; // Direciona para busca de cliente

    @FXML
    private Button botaoPecas; // Direciona para busca de peças

    @FXML
    private Button botaoSair; // sai do programa

    @FXML
    private Button botaoServico; // Direciona para busca de serviços

    @FXML
    public void initialize() {
        LoginController c = new LoginController();
        receberLogin(c.retornarLogin());
    }

    @FXML
    public void receberLogin(String login){
        userLogin.setText(login);
    }

    @FXML
    void PesquisarServicos(ActionEvent event) throws Exception{ // Direciona para busca de serviços
        Telas.TelaServico();
    }

    @FXML
    void pesquisarCarros(ActionEvent event) throws Exception{ // Direciona para buscar de automovel
        Telas.TelaAutomovel();
    }

    @FXML
    void pesquisarCliente(ActionEvent event) throws Exception{ // Direciona para busca de cliente
        Telas.TelaCliente();
    }

    @FXML
    void pesquisarPecas(ActionEvent event) throws Exception{ // Direciona para busca de peças
        Telas.TelaPecas();
    }

    @FXML
    void sair(ActionEvent event) throws Exception{ // sai do programa
        Telas.telaLogin();
    }

}
