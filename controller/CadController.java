package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import view.Telas;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.BO.ChefeBO;
import Model.BO.FuncionarioBO;
import Model.VO.ChefeVO;
import Model.VO.FuncionarioVO;

public class CadController implements Initializable{
    //Tela de cadastro
    @FXML
    private ComboBox<String> menuCargos;

    @FXML
    private DatePicker dataAdm;

    @FXML
    private PasswordField cadSenha;

    @FXML
    private TextField cadUsuario;

    @FXML
    private Label cadError;

    @FXML
    private TextField cadSenhaVisivel;

    @FXML
    private CheckBox mostrarCadSenha;

    static String textoLogin;

    @FXML
    public void voltarParaLogin(ActionEvent event) throws Exception{
        Telas.telaLogin();
    }

    @FXML
    public void cadELogin(ActionEvent event) {
        String cargo = menuCargos.getSelectionModel().getSelectedItem().toString();
        
        try {
            if (cargo.compareTo("Funcionário") == 0) {
                cadError.setVisible(false);
                FuncionarioBO funcBO = new FuncionarioBO();
                FuncionarioVO funcVO = new FuncionarioVO();
                funcVO.setLogin(cadUsuario.getText());
                textoLogin = funcVO.getLogin();
                
                if (mostrarCadSenha.isSelected()) {    
                    funcVO.setSenha(cadSenhaVisivel.getText());
                } else {
                    funcVO.setSenha(cadSenha.getText());
                }
                
                funcVO.setSalario(0.1);
    
                Calendar calAdm = Calendar.getInstance();
                calAdm.set(Calendar.DAY_OF_MONTH, dataAdm.getValue().getDayOfMonth());
                calAdm.set(Calendar.MONTH, (dataAdm.getValue().getMonthValue() - 1));//Subtrai o valor para atender a escala de meses do Calendar
                calAdm.set(Calendar.YEAR, dataAdm.getValue().getYear());
                
                funcVO.setDataDeAdmissao(calAdm);
    
                funcBO.inserir(funcVO);
                LoginController c = new LoginController();
                c.receberCad(textoLogin);
                Telas.MenuFuncionario();
            }
            else{
                if (cargo.compareTo("Chefe") == 0)  {
                    cadError.setVisible(false);
                    ChefeBO chefeBO = new ChefeBO();
                    ChefeVO chefeVO = new ChefeVO();
                    chefeVO.setLogin(cadUsuario.getText());
                    textoLogin = chefeVO.getLogin();
                    
                    if (mostrarCadSenha.isSelected()) {    
                        chefeVO.setSenha(cadSenhaVisivel.getText());
                    } else {
                        chefeVO.setSenha(cadSenha.getText());
                    }
        
                    chefeBO.inserir(chefeVO);
                    LoginController c = new LoginController();
                    c.receberCad(textoLogin);
                    Telas.MenuChefe();
                }
            }
        } catch (Exception e) {
            cadError.setText("Usuário já existe no sistema!");
            cadError.setVisible(true);
        }

    }

    @FXML
    public void cargoSelecionado(ActionEvent event) {
        String cargo = menuCargos.getSelectionModel().getSelectedItem().toString();
        
        if (cargo.compareTo("Funcionário") == 0) {
            dataAdm.setVisible(true);
        }
        else{
            dataAdm.setVisible(false);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> cargos = FXCollections.observableArrayList("Funcionário","Chefe");
        menuCargos.setItems(cargos);
    }

    @FXML
    void mudarVisibilidade(ActionEvent event) {
        if(mostrarCadSenha.isSelected()){
            cadSenhaVisivel.setText(cadSenha.getText());
            cadSenhaVisivel.setVisible(true);
            cadSenha.setVisible(false);
        }
        else{
            cadSenha.setText(cadSenhaVisivel.getText());
            cadSenha.setVisible(true);
            cadSenhaVisivel.setVisible(false);
        }
    }
}
