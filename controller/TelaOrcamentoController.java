package controller;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import Model.BO.OrcamentoBO;
import Model.VO.OrcamentoVO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Callback;
import view.Buttons;
import view.Telas;

public class TelaOrcamentoController implements Initializable {

    public static final String ATT_ICON = "M20,11.5 C20,11.2238576 20.2238576,11 20.5,11 C20.7761424,11 21,11.2238576 21,11.5 L21,18.5000057 C21,19.8807175 19.8807119,21.0000057 18.5,21.0000057 L5.48612181,21.0000057 C4.10540994,21.0000057 2.98612181,19.8807175 2.98612181,18.5000057 L2.98612181,5.5 C2.98612181,4.11928813 4.10540994,3 5.48612181,3 L12.5,3 C12.7761424,3 13,3.22385763 13,3.5 C13,3.77614237 12.7761424,4 12.5,4 L5.48612181,4 C4.65769469,4 3.98612181,4.67157288 3.98612181,5.5 L3.98612181,18.5000057 C3.98612181,19.3284328 4.65769469,20.0000057 5.48612181,20.0000057 L18.5,20.0000057 C19.3284271,20.0000057 20,19.3284328 20,18.5000057 L20,11.5 Z M18.8535534,3.14644661 L20.8535534,5.14644661 C21.0488155,5.34170876 21.0488155,5.65829124 20.8535534,5.85355339 L12.8535534,13.8535534 C12.7597852,13.9473216 12.6326082,14 12.5,14 L10.5,14 C10.2238576,14 10,13.7761424 10,13.5 L10,11.5 C10,11.3673918 10.0526784,11.2402148 10.1464466,11.1464466 L18.1464466,3.14644661 C18.3417088,2.95118446 18.6582912,2.95118446 18.8535534,3.14644661 Z M18.5,4.20710678 L11,11.7071068 L11,13 L12.2928932,13 L19.7928932,5.5 L18.5,4.20710678 Z";
    public static final String DEL_ICON = "M28,40H11.8c-3.3,0-5.9-2.7-5.9-5.9V16c0-0.6,0.4-1,1-1s1,0.4,1,1v18.1c0,2.2,1.8,3.9,3.9,3.9H28c2.2,0,3.9-1.8,3.9-3.9V16   c0-0.6,0.4-1,1-1s1,0.4,1,1v18.1C33.9,37.3,31.2,40,28,40z M33.3,4.9h-7.6C25.2,2.1,22.8,0,19.9,0s-5.3,2.1-5.8,4.9H6.5c-2.3,0-4.1,1.8-4.1,4.1S4.2,13,6.5,13h26.9   c2.3,0,4.1-1.8,4.1-4.1S35.6,4.9,33.3,4.9z M19.9,2c1.8,0,3.3,1.2,3.7,2.9h-7.5C16.6,3.2,18.1,2,19.9,2z M33.3,11H6.5   c-1.1,0-2.1-0.9-2.1-2.1c0-1.1,0.9-2.1,2.1-2.1h26.9c1.1,0,2.1,0.9,2.1,2.1C35.4,10.1,34.5,11,33.3,11z M12.9,35.1c-0.6,0-1-0.4-1-1V17.4c0-0.6,0.4-1,1-1s1,0.4,1,1v16.7C13.9,34.6,13.4,35.1,12.9,35.1z M26.9,35.1c-0.6,0-1-0.4-1-1V17.4c0-0.6,0.4-1,1-1s1,0.4,1,1v16.7C27.9,34.6,27.4,35.1,26.9,35.1z M19.9,35.1c-0.6,0-1-0.4-1-1V17.4c0-0.6,0.4-1,1-1s1,0.4,1,1v16.7C20.9,34.6,20.4,35.1,19.9,35.1z";
    
    @FXML
    private TableColumn<OrcamentoVO, OrcamentoVO> attCol;

    @FXML
    private TextField addAutoPlacaATT;

    @FXML
    private DatePicker dataFim;

    @FXML
    private CheckBox servFinalizadoATT;

    @FXML
    private TableView<OrcamentoVO> tablePecaCAD;

    @FXML
    private TableView<OrcamentoVO> tableServCAD;

    @FXML
    private TableColumn<OrcamentoVO, Integer> pecaColCAD;

    @FXML
    private AnchorPane painelAncoraRelatorio;

    @FXML
    private CheckBox pagEfetuadoATT;

    @FXML
    private Button openRelatorioButton;

    @FXML
    private TableColumn<OrcamentoVO, OrcamentoVO> delCol;

    @FXML
    private Button closeRelatorioButton;

    @FXML
    private Pane attOrcamento;

    @FXML
    private Button addPecaButtonATT;

    @FXML
    private Button delPecaButtonCAD;

    @FXML
    private TableColumn<OrcamentoVO, String> clienteCol;

    @FXML
    private TextField servIdCAD;

    @FXML
    private DatePicker dataFinal;

    @FXML
    private Button addServButtonCAD;

    @FXML
    private TextField dono;

    @FXML
    private CheckBox pagEfetuadoCAD;

    @FXML
    private CheckBox servFinalizadoCAD;

    @FXML
    private Button openCadButton;

    @FXML
    private TableColumn<OrcamentoVO, String> dataFimCol;

    @FXML
    private TableColumn<OrcamentoVO, Integer> servColATT;

    @FXML
    private TextField idOrcamento;

    @FXML
    private TableColumn<OrcamentoVO, String> placaCol;

    @FXML
    private TextField servIdATT;

    @FXML
    private Button closeCadButton;

    @FXML
    private TextField pecaIdATT;

    @FXML
    private DatePicker dataInicial;

    @FXML
    private Button botaoSair;

    @FXML
    private Button botaoPesquisarPlaca;

    @FXML
    private Button finishAttButton;

    @FXML
    private Button servicoButtonChefe;

    @FXML
    private Button gerarRelatorioButton;

    @FXML
    private Button clienteButtonChefe;

    @FXML
    private Button automovelButtonChefe;

    @FXML
    private ScrollPane relatorioPainel;

    @FXML
    private Button delServButtonATT;

    @FXML
    private Button addPecaButtonCAD;

    @FXML
    private Button pecaButtonChefe;

    @FXML
    private Button closeAttButton;

    @FXML
    private TextField pecaIdCAD;

    @FXML
    private Button finishCadButton;

    @FXML
    private Button botaoPesquisarPeriodo;

    @FXML
    private TableView<OrcamentoVO> tablePecaATT;

    @FXML
    private Label textoDataFimCAD;

    @FXML
    private DatePicker selectDataIniCAD;

    @FXML
    private DatePicker selectDataFimCAD;

    @FXML
    private Label textoDataFimATT;

    @FXML
    private DatePicker selectDataIniATT;

    @FXML
    private DatePicker selectDataFimATT;

    @FXML
    private TableView<OrcamentoVO> tableServATT;

    @FXML
    private TableColumn<OrcamentoVO, Integer> servColCAD;

    @FXML
    private Button botaoPesquisarCliente;

    @FXML
    private DatePicker dataIni;

    @FXML
    private TableColumn<OrcamentoVO, Integer> pecaColATT;

    @FXML
    private Pane cadOrcamento;

    @FXML
    private Text userLogin;

    @FXML
    private Button delServButtonCAD;

    @FXML
    private TableColumn<OrcamentoVO, String> dataIniCol;

    @FXML
    private TextField Placa;

    @FXML
    private Button addServButtonATT;

    @FXML
    private Button delPecaButtonATT;

    @FXML
    private TextField addAutoPlacaCAD;

    @FXML
    private TableView<OrcamentoVO> tableOrcamento;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        LoginController c = new LoginController();
        receberLogin(c.retornarLogin());
        
        placaCol.setCellValueFactory(
            new Callback <CellDataFeatures<OrcamentoVO,String>, ObservableValue<String>>() {    
                @Override    
                public ObservableValue<String> call(CellDataFeatures<OrcamentoVO, String> c) {
                    return new SimpleStringProperty(c.getValue().getCarro().getPlaca().toUpperCase());
        }});

        clienteCol.setCellValueFactory(
            new Callback <CellDataFeatures<OrcamentoVO,String>, ObservableValue<String>>() {    
                @Override    
                public ObservableValue<String> call(CellDataFeatures<OrcamentoVO, String> c) {
                    return new SimpleStringProperty(c.getValue().getCliente().getNome());
        }});

        dataIniCol.setCellValueFactory(
            new Callback <CellDataFeatures<OrcamentoVO,String>, ObservableValue<String>>() {    
                @Override    
                public ObservableValue<String> call(CellDataFeatures<OrcamentoVO, String> c) {
                    return new SimpleStringProperty(c.getValue().getDataInicio().toString());
        }});

        dataFimCol.setCellValueFactory(
            new Callback <CellDataFeatures<OrcamentoVO,String>, ObservableValue<String>>() {    
                @Override    
                public ObservableValue<String> call(CellDataFeatures<OrcamentoVO, String> c) {
                    return new SimpleStringProperty(c.getValue().getDataFim().toString());
        }});

        tableOrcamento.setItems(FXCollections.observableArrayList(
            new OrcamentoBO().listar()
        ));

        Buttons.initButtons(attCol, 20, ATT_ICON, "svg-gray", (OrcamentoVO orc, ActionEvent event) -> {
            attOrcamento.setVisible(true);
            addAutoPlacaATT.setText(orc.getCarro().getPlaca());
            //espaço para adicionar as peças e serviços no tableView
        });
    
        Buttons.initButtons(delCol, 20, DEL_ICON, "svg-red", (OrcamentoVO auto, ActionEvent event) -> {
            cadOrcamento.setVisible(true);
            addAutoPlacaCAD.setText(auto.getCarro().getPlaca());
            //espaço para adicionar as peças e serviços no tableView
        });
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
        addAutoPlacaCAD.setText("");
        cadOrcamento.setVisible(false);
    }

    @FXML
    void addPecaCAD(ActionEvent event) {
    
    }

    @FXML
    void addServCAD(ActionEvent event) {

    }

    @FXML
    void delPecaCAD(ActionEvent event) {
    
    }

    @FXML
    void delServCAD(ActionEvent event) {

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
        addAutoPlacaATT.setText("");
        attOrcamento.setVisible(false);
    }

    @FXML
    void addPecaATT(ActionEvent event) {
       
    }

    @FXML
    void addServATT(ActionEvent event) {

    }

    @FXML
    void delPecaATT(ActionEvent event) {
       
    }

    @FXML
    void delServATT(ActionEvent event) {

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
        openRelatorioButton.setVisible(true);
        relatorioPainel.setVisible(false);
    }

    @FXML
    void gerarRelatorio(ActionEvent event) {
        closeRelatorio(event);
    }

    @FXML
    void openRelatorio(ActionEvent event) {
        openRelatorioButton.setVisible(false);
        relatorioPainel.setVisible(true);
    }

    //metodos pesquisar

    @FXML
    void pesquisarPeriodo(ActionEvent event) throws Exception{
        OrcamentoVO vo = new OrcamentoVO();
    	OrcamentoBO bo = new OrcamentoBO();
    	
    	if(dataFim.getValue().toString().isBlank() || dataFim.getValue().toString() == null) {
            tableOrcamento.setItems(FXCollections.observableArrayList(
                bo.listar()
            ));
           
        } else {

            Calendar dataIn = Calendar.getInstance();
            dataIn.set(Calendar.DAY_OF_MONTH, dataIni.getValue().getDayOfMonth());
            dataIn.set(Calendar.MONTH, (dataIni.getValue().getMonthValue() - 1));//Subtrai o valor para atender a escala de meses do Calendar
            dataIn.set(Calendar.YEAR, dataIni.getValue().getYear());
                
            Calendar dataFi = Calendar.getInstance();
            dataFi.set(Calendar.DAY_OF_MONTH, dataFim.getValue().getDayOfMonth());
            dataFi.set(Calendar.MONTH, (dataFim.getValue().getMonthValue() - 1));//Subtrai o valor para atender a escala de meses do Calendar
            dataFi.set(Calendar.YEAR, dataFim.getValue().getYear());
                
            vo.setDataInicio(dataIn);
            vo.setDataInicio(dataFi);
            
            tableOrcamento.setItems(FXCollections.observableArrayList(
                bo.buscarPorPeriodo(vo)
            ));
        }
    }

    @FXML
    void pesquisarDataInicial(ActionEvent event) throws Exception{

    }

    @FXML
    void pesquisarPlaca(ActionEvent event) throws Exception{

    }

    @FXML
    void pesquisarCliente(ActionEvent event) throws Exception{

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
