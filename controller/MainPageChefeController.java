package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import view.Telas;

public class MainPageChefeController{

    @FXML
    private Button automovelButton;
    
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
