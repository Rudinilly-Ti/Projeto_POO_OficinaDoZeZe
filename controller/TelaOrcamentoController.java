package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import view.Telas;

public class TelaOrcamentoController {

    @FXML
    private TextField Placa11;

    @FXML
    private Button finishAttButton;

    @FXML
    private Button servicoButtonChefe;

    @FXML
    private Button gerarRelatorioButton;

    @FXML
    private Button clienteButtonChefe;

    @FXML
    private TextField servicoToAddAtt;

    @FXML
    private Button automovelButtonChefe;

    @FXML
    private ScrollPane relatorioPainel;

    @FXML
    private Button addPecaButton;

    @FXML
    private TextField Placa1;

    @FXML
    private AnchorPane painelAncoraRelatorio;

    @FXML
    private Button pecaButtonChefe;

    @FXML
    private TextField servicoToAdd;

    @FXML
    private Button addServicoButton;

    @FXML
    private Button closeAttButton;

    @FXML
    private Button openRelatorioButton;

    @FXML
    private Button addPecaAttButton;

    @FXML
    private Button finishCadButton;

    @FXML
    private Button closeRelatorioButton;

    @FXML
    private Pane attOrcamento;

    @FXML
    private Button botaoPesquisarDataInicial;

    @FXML
    private TextField pecaToAddAtt;

    @FXML
    private Button openAttButton;

    @FXML
    private DatePicker dataFinal;

    @FXML
    private Button botaoPesquisarCliente;

    @FXML
    private TextField automovelOrcaAtt;

    @FXML
    private TextField dono;

    @FXML
    private Button addServicoAttButton;

    @FXML
    private Pane cadOrcamento;

    @FXML
    private TextField automovelOrca;

    @FXML
    private Button openCadButton;

    @FXML
    private Text userLogin;

    @FXML
    private TextField idOrcamento;

    @FXML
    private Button closeCadButton;

    @FXML
    private Button botaoPesquisarDataFinal;

    @FXML
    private TextField Placa;

    @FXML
    private TextField pecaToAdd;

    @FXML
    private DatePicker dataInicial;

    @FXML
    private Button botaoSair;

    @FXML
    private Button botaoPesquisarPlaca;

    @FXML
    public void initialize() {
        LoginController c = new LoginController();
        receberLogin(c.retornarLogin());
    }

    @FXML
    public void receberLogin(String login){
        userLogin.setText(login);
    }

    //metodos cadastrar

    @FXML
    void openCad(ActionEvent event) {
        cadOrcamento.setVisible(true);
    }

    @FXML
    void closeCad(ActionEvent event) {
        automovelOrca.setText("");
        pecaToAdd.setText("");
        servicoToAdd.setText("");
        cadOrcamento.setVisible(false);
    }

    @FXML
    void addPeca(ActionEvent event) {
    
    }

    @FXML
    void addServico(ActionEvent event) {

    }
 
    @FXML
    void finishCad(ActionEvent event) {
        closeCad(event);
    }

    //metodos atualizar

    @FXML
    void openAtt(ActionEvent event) {
        attOrcamento.setVisible(true);
    }

    @FXML
    void closeAtt(ActionEvent event) {
        idOrcamento.setText("");
        automovelOrcaAtt.setText("");
        pecaToAddAtt.setText("");
        servicoToAddAtt.setText("");
        attOrcamento.setVisible(false);
    }

    @FXML
    void addPecaAtt(ActionEvent event) {
       
    }

    @FXML
    void addServicoAtt(ActionEvent event) {

    }

    @FXML
    void finishAtt(ActionEvent event) {
        closeAtt(event);
    }

    //metodos relatorio

    @FXML
    void closeRelatorio(ActionEvent event) {
        dataInicial.setValue(null);
        dataFinal.setValue(null);
        relatorioPainel.setVisible(false);
    }

    @FXML
    void gerarRelatorio(ActionEvent event) {
        closeRelatorio(event);
    }

    @FXML
    void openRelatorio(ActionEvent event) {
        relatorioPainel.setVisible(true);
    }

    //metodos pesquisar

    @FXML
    void pesquisarDataFinal(ActionEvent event) {

    }

    @FXML
    void pesquisarDataInicial(ActionEvent event) {

    }

    @FXML
    void pesquisarPlaca(ActionEvent event) {

    }

    @FXML
    void pesquisarCliente(ActionEvent event) {

    }

    //menu chefe

    @FXML
    void chamarChefePeca(ActionEvent event) throws Exception{
        Telas.telaPecas();
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
    void chamarChefeCliente(ActionEvent event) throws Exception{
        Telas.telaCliente();
    }

    //sair
    @FXML
    void sair(ActionEvent event) throws Exception {
        Telas.telaLogin();
    }
}
