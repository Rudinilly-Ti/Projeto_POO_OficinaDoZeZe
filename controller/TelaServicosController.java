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

public class TelaServicosController {
    @FXML
    private Button servicoButtonChefe;

    @FXML
    private Button servicoButtonFunc;

    @FXML
    private Button clienteButtonChefe;

    @FXML
    private TextField NomeServicoNovo;

    @FXML
    private Button voltarParaTelaServico;

    @FXML
    private Button automovelButtonFunc;

    @FXML
    private Pane telaDeCadastro;

    @FXML
    private Button botaoCadastrarServico;

    @FXML
    private Button automovelButtonChefe;

    @FXML
    private Button pecaButtonChefe;

    @FXML
    private Text userLogin;

    @FXML
    private Button orcamentoButtonChefe;

    @FXML
    private Button pecaButtonFunc;

    @FXML
    private TextField ValorServicoNovo;

    @FXML
    private Button clienteButtonFunc;

    @FXML
    private TextField NomeServico;

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
    void chamarChefeCliente(ActionEvent event) throws Exception{
        Telas.telaCliente();
    }

    @FXML
    void chamarChefeAuto(ActionEvent event) throws Exception{
        Telas.telaAutomovel();
    }

    @FXML
    void chamarChefePeca(ActionEvent event) throws Exception{
        Telas.telaPecas();
    }

    @FXML
    void chamarChefeServ(ActionEvent event) {
        
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
    void chamarFuncPeca(ActionEvent event) throws Exception{
        Telas.telaPecas();
    }

    @FXML
    void chamarFuncAuto(ActionEvent event) throws Exception{
        Telas.telaAutomovel();
    }

    @FXML
    void chamarFuncServ(ActionEvent event) {

    }

    //funcionalidades da tela

    @FXML
    void inserirServico(ActionEvent event) { // abre a tela de cadastrar um novo servico

    }

    @FXML
    void pesquisarServicosPorNome(ActionEvent event) { // lista servicos

    }

    @FXML
    void cadastrarNovoServico(ActionEvent event) { // cadastra novo serviço

    }

    @FXML
    void voltarTelaServico(ActionEvent event) { // volta para tela de serviço

    }

    //sair
    @FXML
    void sair(ActionEvent event) throws Exception {
        Telas.telaLogin();
    }
}
