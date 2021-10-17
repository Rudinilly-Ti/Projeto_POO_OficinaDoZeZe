package controller;

import Model.VO.ChefeVO;
import Model.VO.UsuarioVO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import view.Telas;

public class MainMenuController{

    @FXML
    private Button orcamentoButtonChefe;

    @FXML
    private Text loginUser;

    @FXML
    private Button servicoButtonChefe;

    @FXML
    private Button servicoButtonFunc;

    @FXML
    private Button clienteButtonChefe;

    @FXML
    private Button pecaButtonFunc;

    @FXML
    private Button automovelButtonFunc;

    @FXML
    private Button clienteButtonFunc;

    @FXML
    private Button automovelButtonChefe;

    @FXML
    private Button botaoSair;

    @FXML
    private Button pecaButtonChefe;

    @FXML
    public void initialize() {
        LoginController c = new LoginController();
        receberLogin(c.retornarLogin());
        setMenu(c.retornarUsuario());
    }

    @FXML
    public void receberLogin(String login){
        loginUser.setText(login);
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
    void chamarOrcamento(ActionEvent event) throws Exception{
        Telas.telaOrcamento();
    }

    //menu funcionario

    @FXML
    void chamarFuncCliente(ActionEvent event) throws Exception{
        Telas.telaCliente();
    }

    @FXML
    void chamarFuncAuto(ActionEvent event) throws Exception{
        Telas.telaAutomovel();
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
    void sair(ActionEvent event) throws Exception{ // sai do programa
        Telas.telaLogin();
    }
}
