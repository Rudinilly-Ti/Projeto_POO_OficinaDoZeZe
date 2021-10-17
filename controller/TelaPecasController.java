package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class TelaPecasController {

    @FXML
    private TextField Fabricante;

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
    private Label nomeDoUsuario;

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
    void PesquisarServicos(ActionEvent event) {

    }

    @FXML
    void pesquisarCarros(ActionEvent event) {

    }

    @FXML
    void pesquisarCliente(ActionEvent event) {

    }

    @FXML
    void pesquisarFabricante(ActionEvent event) {

    }

    @FXML
    void pesquisarNome(ActionEvent event) {

    }

    @FXML
    void pesquisarPecas(ActionEvent event) {

    }

    @FXML
    void pesquisarPlaca(ActionEvent event) {

    }

    @FXML
    void voltarParaMenu(ActionEvent event) {

    }

}
