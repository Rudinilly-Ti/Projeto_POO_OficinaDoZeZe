package controller;

import Model.VO.ChefeVO;
import Model.VO.UsuarioVO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import view.Telas;

public class TelaClienteController {
  @FXML
    private Button finishAttButton;

    @FXML
    private Button cancelAttButton;

    @FXML
    private Button servicoButtonChefe;

    @FXML
    private Button clienteButtonChefe;

    @FXML
    private TextField enderecoClienteAtt;

    @FXML
    private TextField nomeClienteAtt;

    @FXML
    private Button automovelButtonFunc;

    @FXML
    private Button automovelButtonChefe;

    @FXML
    private Button pecaButtonChefe;

    @FXML
    private Button orcamentoButtonChefe;

    @FXML
    private TextField cpfClienteAtt;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField sobrenomeCliente;

    @FXML
    private Button finishCadButton;

    @FXML
    private TextField idCliente;

    @FXML
    private TextField sobrenomeClienteAtt;

    @FXML
    private Button openAttButton;

    @FXML
    private Pane cadCliente;

    @FXML
    private Button clienteButtonFunc;

    @FXML
    private TextField enderecoCliente;

    @FXML
    private Button servicoButtonFunc;

    @FXML
    private Button openCad;

    @FXML
    private Text userLogin;

    @FXML
    private TextField cpfCliente;

    @FXML
    private Button pecaButtonFunc;

    @FXML
    private TextField nomeCliente;

    @FXML
    private Pane attCliente;

    @FXML
    private Button botaoSair;

    @FXML
    public void initialize() {
        LoginController c = new LoginController();
        receberLogin(c.retornarLogin());
        setMenu(c.retornarUsuario());
    }

    @FXML
    public void receberLogin(String login){
        userLogin.setText(login);
    }

    @FXML
    public void setMenu(UsuarioVO vo){
        if (vo instanceof ChefeVO) {
            //botoes do chefe
            servicoButtonChefe.setVisible(true);
            pecaButtonChefe.setVisible(true);
            clienteButtonChefe.setVisible(true);
            automovelButtonChefe.setVisible(true);
            orcamentoButtonChefe.setVisible(true);
            //botoes do func 
            servicoButtonFunc.setVisible(false);
            pecaButtonFunc.setVisible(false);
            clienteButtonFunc.setVisible(false);
            automovelButtonFunc.setVisible(false);
        } else {
            //botoes do chefe
            servicoButtonChefe.setVisible(false);
            pecaButtonChefe.setVisible(false);
            clienteButtonChefe.setVisible(false);
            automovelButtonChefe.setVisible(false);
            orcamentoButtonChefe.setVisible(false);
            //botoes do func 
            servicoButtonFunc.setVisible(true);
            pecaButtonFunc.setVisible(true);
            clienteButtonFunc.setVisible(true);
            automovelButtonFunc.setVisible(true);
        }
    }

    //menu chefe

    @FXML
    void chamarChefePeca(ActionEvent event) throws Exception{
      Telas.telaPecas();
    }

    @FXML
    void chamarChefeCliente(ActionEvent event) {
      
    }

    @FXML
    void chamarChefeAuto(ActionEvent event) throws Exception{
      Telas.telaAutomovel();
    }

    @FXML
    void chamarChefeServ(ActionEvent event) throws Exception{
      Telas.telaServico();
    }

    @FXML
    void chamarOrcamento(ActionEvent event) throws Exception{
      Telas.telaOrcamento();
    }

    //menu funcionario

    @FXML
    void chamarFuncPeca(ActionEvent event) throws Exception{
        Telas.telaPecas();
    }

    @FXML
    void chamarFuncAuto(ActionEvent event) throws Exception{
        Telas.telaAutomovel();
    }

    @FXML
    void chamarFuncServ(ActionEvent event) throws Exception{
        Telas.telaServico();
    }

    @FXML
    void chamarFuncCliente(ActionEvent event) {
      
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
