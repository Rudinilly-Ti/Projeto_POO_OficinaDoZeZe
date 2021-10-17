package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import view.Telas;

public class TelaClienteController {
  @FXML
  private TextField enderecoCliente;

  @FXML
  private Text userLogin;

  @FXML
  private Button botaoSair;

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

  //componentes atualizar
  @FXML
  private Pane attCliente;

  @FXML
  private Button cancelAttButton;

  @FXML
  private TextField cpfClienteAtt;

  @FXML
  private TextField idCliente;

  @FXML
  private TextField enderecoClienteAtt;

  @FXML
  private Button finishAttButton;

  @FXML
  private TextField nomeClienteAtt;

  @FXML
  private Button openAttButton;

  @FXML
  private TextField sobrenomeClienteAtt;

    @FXML
    public void initialize() {
      LoginController c = new LoginController();
      receberLogin(c.retornarLogin());
    }

    @FXML
    public void receberLogin(String login){ //Exibe o nome do usuário
      userLogin.setText(login);
    }

    // metodos do menu
    @FXML
    void chamarTelaAutomoveis(ActionEvent event) throws Exception{
      Telas.TelaAutomovel();
    }

    @FXML
    void chamarTelaClientes(ActionEvent event) throws Exception{
      Telas.TelaCliente();
    }

    @FXML
    void chamarTelaOrcamentos(ActionEvent event) throws Exception{
      Telas.TelaOrcamento();
    }

    @FXML
    void chamarTelaPecas(ActionEvent event) throws Exception{
      Telas.TelaPecas();
    }

    @FXML
    void chamarTelaServicos(ActionEvent event) throws Exception{
      Telas.TelaServico();
    }

    //metodos atualizar
    @FXML
    void openAtt(ActionEvent event) {
      attCliente.setVisible(true);
    }

    
    @FXML
    void closeAtt(ActionEvent event) {
      nomeClienteAtt.setText("");
      sobrenomeCliente.setText("");
      enderecoClienteAtt.setText("");
      cpfClienteAtt.setText("");
      idCliente.setText("");
      attCliente.setVisible(false);
    }

    @FXML
    void finishAtt(ActionEvent event) {
      closeAtt(event);
    }
    //metodos cadastrar
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

    //sair
    @FXML
    void sair(ActionEvent event) throws Exception {
        Telas.telaLogin();
    }
}
