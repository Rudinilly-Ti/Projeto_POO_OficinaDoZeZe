package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class TelaClienteController {
  @FXML
  private TextField enderecoCliente;

  @FXML
  private Button orcamentoButton;

  @FXML
  private Button openCad;

  @FXML
  private TextField cpfCliente;

  @FXML
  private Button cancelButton;

  @FXML
  private TextField sobrenomeCliente;

  @FXML
  private Button finishCadButton;

  @FXML
  private Button servicoButton;

  @FXML
  private Button automovelButton;

  @FXML
  private Pane cadCliente;

  @FXML
  private TextField nomeCliente;

  @FXML
  private Button clienteButton;

  @FXML
  private Button pecaButton;

  @FXML
  private Button funcionarioButton;

    // metodos do menu
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

    //metodos do cliente
    @FXML
    void openCadClient(ActionEvent event) {
      cadCliente.setVisible(true);
    }
    
    @FXML
    void closeCadCliente(ActionEvent event) {
      cadCliente.setVisible(false);
      nomeCliente.setText("");
      sobrenomeCliente.setText("");
      enderecoCliente.setText("");
      cpfCliente.setText("");
    }

    @FXML
    void finishCadCliente(ActionEvent event) {
      System.out.println("Nome: "+nomeCliente.getText() +" "+ sobrenomeCliente.getText());
      System.out.println("Endereco: "+ enderecoCliente.getText());
      System.out.println("CPF: "+ cpfCliente.getText());
      closeCadCliente(event);
    }
}