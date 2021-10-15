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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Exceptions.InsertException;
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
    public void voltarParaLogin(ActionEvent event) throws Exception{
        Telas.telaLogin();
    }

    @FXML
    public void cadELogin(ActionEvent event) {
        String cargo = menuCargos.getSelectionModel().getSelectedItem().toString();
        
        try {
            if (cargo.compareTo("Funcionário") == 0) {
                FuncionarioBO funcBO = new FuncionarioBO();
                FuncionarioVO funcVO = new FuncionarioVO();
                funcVO.setLogin(cadUsuario.getText());
                funcVO.setSenha(cadSenha.getText());
                funcVO.setSalario(0.1);
    
                Calendar calAdm = Calendar.getInstance();
                calAdm.set(Calendar.DAY_OF_MONTH, dataAdm.getValue().getDayOfMonth());
                calAdm.set(Calendar.MONTH, (dataAdm.getValue().getMonthValue() - 1));//Subtrai o valor para atender a escala de meses do Calendar
                calAdm.set(Calendar.YEAR, dataAdm.getValue().getYear());
                
                funcVO.setDataDeAdmissao(calAdm);
    
                funcBO.inserir(funcVO);
            }
            else{
                if (cargo.compareTo("Chefe") == 0)  {
                    ChefeBO chefeBO = new ChefeBO();
                    ChefeVO chefeVO = new ChefeVO();
                    chefeVO.setLogin(cadUsuario.getText());
                    chefeVO.setSenha(cadSenha.getText());
        
                    chefeBO.inserir(chefeVO);
                }
            }
        } catch (InsertException e) {
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
}
