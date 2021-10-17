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

public class TelaPecasController {

    @FXML
    private Button finishAttButton;

    @FXML
    private Button servicoButtonChefe;

    @FXML
    private TextField nomePeca;

    @FXML
    private Button clienteButtonChefe;

    @FXML
    private TextField NomePeca;

    @FXML
    private Button automovelButtonFunc;

    @FXML
    private Button automovelButtonChefe;

    @FXML
    private Pane cadPeca;

    @FXML
    private Button pecaButtonChefe;

    @FXML
    private Button closeAttButton;

    @FXML
    private Button orcamentoButtonChefe;

    @FXML
    private Button finishCadButton;

    @FXML
    private Button clienteButtonFunc;

    @FXML
    private Button openAttButton;

    @FXML
    private TextField idPeca;

    @FXML
    private Pane attPeca;

    @FXML
    private Button servicoButtonFunc;

    @FXML
    private TextField Fabricante;

    @FXML
    private TextField fabricantePecaAtt;

    @FXML
    private TextField PlacaAutomovel;

    @FXML
    private Button openCadButton;

    @FXML
    private Button botaoPesqFabricante;

    @FXML
    private TextField fabricantePeca;

    @FXML
    private TextField precoPecaAtt;

    @FXML
    private Text userLogin;

    @FXML
    private Button botaoPesqPlaca;

    @FXML
    private Button pecaButtonFunc;

    @FXML
    private TextField nomePecaAtt;

    @FXML
    private Button closeCadButton;

    @FXML
    private Button botaoSair;

    @FXML
    private Button botaoPesqNome;

    @FXML
    private TextField precoPeca;

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
    void pesquisarFabricante(ActionEvent event) {

    }

    @FXML
    void pesquisarNome(ActionEvent event) {

    }


    @FXML
    void pesquisarPlaca(ActionEvent event) {

    }

    //menu chefe

    @FXML
    void chamarChefeCliente(ActionEvent event) throws Exception{
        Telas.telaCliente();
    }

    @FXML
    void chamarChefeAuto(ActionEvent event) throws Exception{
        Telas.telaAutomovel();
    }

    @FXML
    void chamarChefePeca(ActionEvent event){

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
    void chamarFuncCliente(ActionEvent event) throws Exception{
        Telas.telaCliente();
    }

    @FXML
    void chamarFuncPeca(ActionEvent event){

    }

    @FXML
    void chamarFuncAuto(ActionEvent event) throws Exception{
        Telas.telaAutomovel();
    }

    @FXML
    void chamarFuncServ(ActionEvent event) throws Exception{
        Telas.telaServico();
    }

    //sair

    @FXML
    void sair(ActionEvent event) throws Exception {
        Telas.telaLogin();
    }
}
