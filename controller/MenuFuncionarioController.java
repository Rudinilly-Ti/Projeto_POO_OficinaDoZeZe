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
    void PesquisarServicos(ActionEvent event) { // Direciona para busca de serviços

    }

    @FXML
    void pesquisarCarros(ActionEvent event) { // Direciona para buscar de automovel

    }

    @FXML
    void pesquisarCliente(ActionEvent event) { // Direciona para busca de cliente

    }

    @FXML
    void pesquisarPecas(ActionEvent event) { // Direciona para busca de peças

    }

    @FXML
    void sair(ActionEvent event) throws Exception{ // sai do programa
        Telas.telaLogin();
    }

}
