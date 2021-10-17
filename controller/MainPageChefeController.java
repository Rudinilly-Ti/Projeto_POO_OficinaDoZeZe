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
    void chamarTelaAutomoveis(ActionEvent event) throws Exception{
        Telas.TelaAutomovel();
    }

    @FXML
    void chamarTelaClientes(ActionEvent event) throws Exception {
        Telas.TelaCliente();
    }

    @FXML
    void chamarTelaOrcamentos(ActionEvent event) throws Exception {
        Telas.TelaOrcamento();
    }

    @FXML
    void chamarTelaPecas(ActionEvent event) throws Exception {
        Telas.TelaPecas();
    }

    @FXML
    void chamarTelaServicos(ActionEvent event) throws Exception {
        Telas.TelaServicoChefe();
    }
    
    @FXML
    void sair(ActionEvent event) throws Exception{ // sai do programa
        Telas.telaLogin();
    }
}
