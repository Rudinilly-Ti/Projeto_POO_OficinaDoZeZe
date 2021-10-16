package controller;

import Model.BO.UsuarioBO;
import Model.VO.ChefeVO;
import Model.VO.UsuarioVO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import view.Telas;

public class LoginController{
    
    //Tela de login
    @FXML
    private PasswordField senha;

    @FXML
    private Label errorLogin;

    @FXML
    private TextField login;

    @FXML
    private CheckBox mostrarSenha;

    @FXML
    private TextField senhaVisivel;

    UsuarioBO usuBO = new UsuarioBO();
    static String textoLogin;

    @FXML
    public void autenticar(ActionEvent event){
        UsuarioVO usuVO = new UsuarioVO();
        usuVO.setLogin(login.getText());
        textoLogin = usuVO.getLogin();
        
        if (mostrarSenha.isSelected()) {    
            usuVO.setSenha(senhaVisivel.getText());
        } else {
            usuVO.setSenha(senha.getText());
        }
        
        try {
            UsuarioVO autenticado = usuBO.autenticar(usuVO);
            if (autenticado instanceof ChefeVO){
                errorLogin.setVisible(false);
                Telas.MenuChefe();
            }
            else{
                errorLogin.setVisible(false);
                Telas.MenuFuncionario();
            }
        } catch (Exception e) {
            errorLogin.setText("Usuário e/ou senha inválidos!");
            errorLogin.setVisible(true);
        }
    }

    @FXML
    public void cadastrar(ActionEvent event) throws Exception{
        Telas.TelaCadastro();
    }

    @FXML
    public String retornarLogin(){
        return textoLogin;
    }

    @FXML
    public void receberCad(String cad){
        textoLogin = cad;
    }

    @FXML
    public void mudarVisibilidade(ActionEvent event) {
        if(mostrarSenha.isSelected()){
            senhaVisivel.setText(senha.getText());
            senhaVisivel.setVisible(true);
            senha.setVisible(false);
        }
        else{
            senha.setText(senhaVisivel.getText());
            senha.setVisible(true);
            senhaVisivel.setVisible(false);
        }
    }
}
