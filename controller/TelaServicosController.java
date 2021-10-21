package controller;

import java.net.URL;
import java.util.ResourceBundle;

import Model.BO.ServicoBO;
import Model.VO.ChefeVO;
import Model.VO.ServicoVO;
import Model.VO.UsuarioVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import view.Telas;
import view.Buttons;

public class TelaServicosController implements Initializable {
	
	public static final String ATT_ICON = "M20,11.5 C20,11.2238576 20.2238576,11 20.5,11 C20.7761424,11 21,11.2238576 21,11.5 L21,18.5000057 C21,19.8807175 19.8807119,21.0000057 18.5,21.0000057 L5.48612181,21.0000057 C4.10540994,21.0000057 2.98612181,19.8807175 2.98612181,18.5000057 L2.98612181,5.5 C2.98612181,4.11928813 4.10540994,3 5.48612181,3 L12.5,3 C12.7761424,3 13,3.22385763 13,3.5 C13,3.77614237 12.7761424,4 12.5,4 L5.48612181,4 C4.65769469,4 3.98612181,4.67157288 3.98612181,5.5 L3.98612181,18.5000057 C3.98612181,19.3284328 4.65769469,20.0000057 5.48612181,20.0000057 L18.5,20.0000057 C19.3284271,20.0000057 20,19.3284328 20,18.5000057 L20,11.5 Z M18.8535534,3.14644661 L20.8535534,5.14644661 C21.0488155,5.34170876 21.0488155,5.65829124 20.8535534,5.85355339 L12.8535534,13.8535534 C12.7597852,13.9473216 12.6326082,14 12.5,14 L10.5,14 C10.2238576,14 10,13.7761424 10,13.5 L10,11.5 C10,11.3673918 10.0526784,11.2402148 10.1464466,11.1464466 L18.1464466,3.14644661 C18.3417088,2.95118446 18.6582912,2.95118446 18.8535534,3.14644661 Z M18.5,4.20710678 L11,11.7071068 L11,13 L12.2928932,13 L19.7928932,5.5 L18.5,4.20710678 Z";
    public static final String DEL_ICON = "M28,40H11.8c-3.3,0-5.9-2.7-5.9-5.9V16c0-0.6,0.4-1,1-1s1,0.4,1,1v18.1c0,2.2,1.8,3.9,3.9,3.9H28c2.2,0,3.9-1.8,3.9-3.9V16   c0-0.6,0.4-1,1-1s1,0.4,1,1v18.1C33.9,37.3,31.2,40,28,40z M33.3,4.9h-7.6C25.2,2.1,22.8,0,19.9,0s-5.3,2.1-5.8,4.9H6.5c-2.3,0-4.1,1.8-4.1,4.1S4.2,13,6.5,13h26.9   c2.3,0,4.1-1.8,4.1-4.1S35.6,4.9,33.3,4.9z M19.9,2c1.8,0,3.3,1.2,3.7,2.9h-7.5C16.6,3.2,18.1,2,19.9,2z M33.3,11H6.5   c-1.1,0-2.1-0.9-2.1-2.1c0-1.1,0.9-2.1,2.1-2.1h26.9c1.1,0,2.1,0.9,2.1,2.1C35.4,10.1,34.5,11,33.3,11z M12.9,35.1c-0.6,0-1-0.4-1-1V17.4c0-0.6,0.4-1,1-1s1,0.4,1,1v16.7C13.9,34.6,13.4,35.1,12.9,35.1z M26.9,35.1c-0.6,0-1-0.4-1-1V17.4c0-0.6,0.4-1,1-1s1,0.4,1,1v16.7C27.9,34.6,27.4,35.1,26.9,35.1z M19.9,35.1c-0.6,0-1-0.4-1-1V17.4c0-0.6,0.4-1,1-1s1,0.4,1,1v16.7C20.9,34.6,20.4,35.1,19.9,35.1z";
      
    @FXML
    private Button servicoButtonChefe;
    
    @FXML
    private Pane dllPane;
    
    @FXML
    private Button buttonCancelar;

    @FXML
    private Button buttonDeletar;

    @FXML
    private TextField idServico;
    
    @FXML
    private Pane AttPane;
    
    @FXML
    private TextField idItemDeletar;
    
    @FXML
    private Button buttonAtt;
    
    @FXML
    private Button buttonVoltar;
    
    @FXML
    private TextField nomeUpdate;
    
    @FXML
    private TextField precoUpdate;
    
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
    private Button buttonInserirNovoServico;

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
    private Button pesquisarServico;
    
    @FXML
    private TableView<ServicoVO> TableViewServico;
    
    @FXML
    private TableColumn<ServicoVO, ServicoVO> colunaAtualizar;

    @FXML
    private TableColumn<ServicoVO, ServicoVO> colunaDeletar;

    @FXML
    private TableColumn<ServicoVO, String> colunaNome;

    @FXML
    private TableColumn<ServicoVO, Double> colunaValor;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	colunaNome.setCellValueFactory(new PropertyValueFactory<ServicoVO, String>("nome"));
    	colunaValor.setCellValueFactory(new PropertyValueFactory<ServicoVO, Double>("preco"));
    	//colunaAtualizar.set
    	
    	Buttons.initButtons(colunaAtualizar, 20, ATT_ICON, "svg-gray", (ServicoVO servico, ActionEvent event) -> {
    		AttPane.setVisible(true);
    		nomeUpdate.setText(servico.getNome());
    		precoUpdate.setText(servico.fromDoubleToString(servico.getPreco()));
    		idServico.setText(servico.getId().toString());
    	});
    	
    	Buttons.initButtons(colunaDeletar, 20, DEL_ICON, "svg-red", (ServicoVO servico, ActionEvent event) -> {
    		dllPane.setVisible(true);
    		idItemDeletar.setText(servico.getId().toString());
    		
    	});
    	
    	TableViewServico.setItems(getServicoVO());
    }
    
    @FXML
    void update(ActionEvent event) throws Exception {
    	ServicoVO vo = new ServicoVO();
    	ServicoBO bo = new ServicoBO();
    	
    	vo.setNome(nomeUpdate.getText());
    	vo.setPreco(vo.fromStringToDouble(precoUpdate.getText()));
    	vo.setId((long) Integer.parseInt(idServico.getText()));

    	bo.editarNome(vo);
    	bo.editarPreco(vo);
    	TableViewServico.refresh();
    	Telas.telaServico();
    }

    @FXML
    void voltar(ActionEvent event) throws Exception {
    	Telas.telaServico();
    }
    

    @FXML
    void cancelar(ActionEvent event) throws Exception {
    	Telas.telaServico();
    }
    
    @FXML
    void deletar(ActionEvent event) throws Exception {
    	ServicoVO vo = new ServicoVO();
    	ServicoBO bo = new ServicoBO();
    	vo.setId((long) Integer.parseInt(idItemDeletar.getText()));
    	bo.deletar(vo);
    	Telas.telaServico();
    }

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
    void inserirServico(ActionEvent event) throws Exception { // abre a tela de cadastrar um novo servico
    	telaDeCadastro.setVisible(true);
    	TableViewServico.setVisible(false);
    }

    // Uma lista que retorna os valores de ServicoVO
    public ObservableList<ServicoVO> getServicoVO(){
    	ServicoBO bo = new ServicoBO();
    	ObservableList<ServicoVO> servicos = FXCollections.observableArrayList();
    	for(ServicoVO i : bo.listar())
    		servicos.add(i);
    	return servicos;
    }
    
    @FXML
    void pesquisarServicosPorNome(ActionEvent event) throws Exception { // lista servicos
    	ServicoVO vo = new ServicoVO();
    	ServicoBO bo = new ServicoBO();
    	vo.setNome(NomeServico.getText());
    	bo.buscarPorNome(vo);
    }

    @FXML
    void cadastrarNovoServico(ActionEvent event) throws Exception { // cadastra novo serviço
    	ServicoVO vo = new ServicoVO();
    	ServicoBO bo = new ServicoBO();
    	
    	vo.setNome(NomeServicoNovo.getText());
    	vo.setPreco(vo.fromStringToDouble(ValorServicoNovo.getText()));
    	bo.inserir(vo);
    }

    @FXML
    void voltarTelaServico(ActionEvent event) throws Exception { // volta para tela de serviço
    	Telas.telaServico();
    }

    //sair
    @FXML
    void sair(ActionEvent event) throws Exception {
        Telas.telaLogin();
    }
}
