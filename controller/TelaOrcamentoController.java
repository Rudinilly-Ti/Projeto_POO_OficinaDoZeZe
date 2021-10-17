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
    private TextField Placa;

    @FXML
    private Text userLogin;

    @FXML
    private TextField Placa1;

    @FXML
    private TextField Placa11;

    @FXML
    private Button adicionarOrcamento;

    @FXML
    private Button botaoSair;

    @FXML
    private Button botaoAutomoveis;

    @FXML
    private Button botaoCliente;

    @FXML
    private Button botaoPecas;

    @FXML
    private Button botaoPesquisarCliente;

    @FXML
    private Button botaoPesquisarDataFinal;

    @FXML
    private Button botaoPesquisarDataInicial;

    @FXML
    private Button botaoPesquisarPlaca;

    @FXML
    private Button botaoServico;

    @FXML
    private TextField dono;
        
    // componentes cadastrar
    @FXML
    private Pane cadOrcamento;
     
    @FXML
    private TextField automovelOrca;
    
    @FXML
    private TextField pecaToAdd;

    @FXML
    private TextField servicoToAdd;
    
    @FXML
    private Button addPecaButton;

    @FXML
    private Button addServicoButton;

    @FXML
    private Button finishCadButton;
    
    @FXML
    private Button openCadButton;
   
    @FXML
    private Button closeCadButton;

    //componentes atualizar
    @FXML
    private Pane attOrcamento;

    @FXML
    private Button openAttButton;

    @FXML
    private TextField automovelOrcaAtt;

    @FXML
    private TextField pecaToAddAtt;

    @FXML
    private TextField servicoToAddAtt;

    @FXML
    private TextField idOrcamento;

    @FXML
    private Button closeAttButton;

    @FXML
    private Button finishAttButton;

    //componentes relatorio
    @FXML
    private ScrollPane relatorioPainel;

    @FXML
    private DatePicker dataFinal;

    @FXML
    private DatePicker dataInicial;

    @FXML
    private AnchorPane painelAncoraRelatorio;
    
    @FXML
    private Button gerarRelatorioButton;

    @FXML
    private Button openRelatorioButton;

    @FXML
    private Button closeRelatorioButton;

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
    void pesquisarDataFinal(ActionEvent event) {

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
