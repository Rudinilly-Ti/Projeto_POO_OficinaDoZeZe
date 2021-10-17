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

public class TelaAutomovelController {

    @FXML
    private TextField carroCorNova;

    @FXML
    private TextField carroPlacaNova;

    @FXML
    private TextField dono;

    @FXML
    private Button servicoButtonChefe;

    @FXML
    private Button servicoButtonFunc;

    @FXML
    private Button clienteButtonChefe;

    @FXML
    private Button automovelButtonFunc;

    @FXML
    private Pane telaDeCadastro;

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
    private TextField carroMarcaNova;

    @FXML
    private Button clienteButtonFunc;

    @FXML
    private TextField Placa;

    @FXML
    private Button botaoCadastrarNovoCarro;

    @FXML
    private Button botaoVoltar;

    @FXML
    private Button botaoSair;

    @FXML
    private TextField carroAnoNovo;

    @FXML
    private TextField carroQuilometragemNova;

/*=====================================================================================*/

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

    //menu cadastro

    @FXML
    void cadastrarNovoCarro(ActionEvent event) {

    }

    @FXML
    void voltarTelaAutomovel(ActionEvent event) {

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
    void chamarFuncServ(ActionEvent event) throws Exception{
        Telas.telaServico();
    }

    @FXML
    void chamarFuncAuto(ActionEvent event){
        
    }

    //menu chefe

    @FXML
    void chamarChefeCliente(ActionEvent event) throws Exception{
        Telas.telaCliente();
    }

    @FXML
    void chamarChefePeca(ActionEvent event) throws Exception{
        Telas.telaPecas();
    }

    @FXML
    void chamarChefeServ(ActionEvent event) throws Exception{
        Telas.telaServico();
    }

    @FXML
    void chamarOrcamento(ActionEvent event) throws Exception{
        Telas.telaOrcamento();
    }

    @FXML
    void chamarChefeAuto(ActionEvent event){
        
    }

    //logout

    @FXML
    void sair(ActionEvent event) throws Exception { //volta para o login
        Telas.telaLogin();
    }
}
