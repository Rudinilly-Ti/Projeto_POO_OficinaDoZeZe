package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import view.Telas;

public class MainPageChefeController{

    @FXML
    private Button automovelButton;

    @FXML
    private Text loginUser;
    
    @FXML
    private Button clienteButton;

    @FXML
    private Button funcionarioButton;

    @FXML
    private Button orcamentoButton;

    @FXML
    private Button pecaButton;

    @FXML
    private Button servicoButton;

    @FXML
    private Button botaoSair;

    @FXML
    public void initialize() {
        LoginController c = new LoginController();
        receberLogin(c.retornarLogin());
    }

    @FXML
    public void receberLogin(String login){
        loginUser.setText(login);
    }

    @FXML
    void chamarTelaAutomoveis(ActionEvent event) {

    }

    @FXML
    void chamarTelaClientes(ActionEvent event) {

    }

    @FXML
    void chamarTelaFuncionarios(ActionEvent event) {

    }

    @FXML
    void chamarTelaOrcamentos(ActionEvent event) {

    }

    @FXML
    void chamarTelaPecas(ActionEvent event) {

    }

    @FXML
    void chamarTelaServicos(ActionEvent event) {

    }
    
    @FXML
    void sair(ActionEvent event) throws Exception{ // sai do programa
        Telas.telaLogin();
    }
}
