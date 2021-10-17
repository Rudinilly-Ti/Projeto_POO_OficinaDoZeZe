package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import view.Telas;

public class TelaPecasController {

    @FXML
    private TextField Fabricante;

    @FXML
    private Text userLogin;

    @FXML
    private TextField NomePeca;

    @FXML
    private TextField PlacaAutomovel;

    @FXML
    private Button botaoAutomoveis;

    @FXML
    private Button botaoCliente;

    @FXML
    private Button botaoPecas;

    @FXML
    private Button botaoPesqFabricante;

    @FXML
    private Button botaoPesqNome;

    @FXML
    private Button botaoPesqPlaca;

    @FXML
    private Button botaoSair;

    @FXML
    private Button botaoServico;

    @FXML
    private Button closeCadButton;

    @FXML
    private Button finishCadButton;

    //componentes cadastrar
    @FXML
    private TextField nomePeca;
    
    @FXML
    private TextField precoPeca;

    @FXML
    private TextField fabricantePeca;

    @FXML
    private Button openCadButton;

    @FXML
    private Pane cadPeca;

    //componentes atualizar
    @FXML
    private Pane attPeca;

    @FXML
    private Button closeAttButton;

    @FXML
    private Button finishAttButton;

    @FXML
    private Button openAttButton;

    @FXML
    private TextField fabricantePecaAtt;

    @FXML
    private TextField nomePecaAtt;

    @FXML
    private TextField precoPecaAtt;

    @FXML
    private TextField idPeca;

    @FXML
    public void initialize() {
        LoginController c = new LoginController();
        receberLogin(c.retornarLogin());
    }

    @FXML
    public void receberLogin(String login){ //Exibe o nome do usuário
        userLogin.setText(login);
    }

    //metodos cadastrar
    @FXML
    void openCad(ActionEvent event) {
        cadPeca.setVisible(true);
    }

    @FXML
    void closeCad(ActionEvent event) {
        nomePeca.setText("");
        precoPeca.setText("");
        fabricantePeca.setText("");
        cadPeca.setVisible(false);
    }

    @FXML
    void finishCad(ActionEvent event) {
        closeCad(event);
    }

    //metodos atualizar
    @FXML
    void openAtt(ActionEvent event) {
        attPeca.setVisible(true);
    }

    @FXML
    void closeAtt(ActionEvent event) {
        nomePecaAtt.setText("");
        precoPecaAtt.setText("");
        fabricantePecaAtt.setText("");
        idPeca.setText("");
        attPeca.setVisible(false);
    }

    @FXML
    void finishAtt(ActionEvent event) {
        closeAtt(event);
    }

    //metodos pesquisar
    @FXML
    void PesquisarServicos(ActionEvent event) throws Exception{
        Telas.TelaServico();
    }

    @FXML
    void pesquisarCarros(ActionEvent event) throws Exception{
        Telas.TelaAutomovel();
    }

    @FXML
    void pesquisarCliente(ActionEvent event) throws Exception{
        Telas.TelaCliente();
    }

    @FXML
    void pesquisarFabricante(ActionEvent event) {

    }

    @FXML
    void pesquisarNome(ActionEvent event) {

    }

    @FXML
    void pesquisarPecas(ActionEvent event) throws Exception{
        Telas.TelaPecas();
    }

    @FXML
    void pesquisarPlaca(ActionEvent event) {

    }

    //sair
    @FXML
    void sair(ActionEvent event) throws Exception {
        Telas.telaLogin();
    }
}
