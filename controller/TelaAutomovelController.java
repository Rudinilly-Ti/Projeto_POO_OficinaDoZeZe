package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import view.Telas;

public class TelaAutomovelController {

    @FXML
    private TextField Placa; //Barra de texto, para pesquisar por placa

    @FXML
    private Button adicionarCarro; // botao de inserir novos carros

    @FXML
    private Button botaoSair; //botao de logout

    @FXML
    private Button botaoAutomoveis; // botao, na qual, faz nada, pois já está em buscar carros

    @FXML
    private Button botaoCliente; // botao que vai para tela de buscar clientes

    @FXML
    private Button botaoPecas; // botao que vai para tela de buscar peças

    @FXML
    private Button botaoPesquisarDono; // botao para pesquisar por cliente

    @FXML
    private Button botaoPesquisarPlaca; // botão para pesquisar por placa

    @FXML
    private Button botaoServico; // botao que vai para tela de buscar Serviços

    @FXML
    private TextField dono; // Barra de texto, para pesquisar por cliente

    @FXML
    private Text userLogin; //Text que exibe o login do usuário

    @FXML
    private Button botaoCadastrarNovoCarro;

    @FXML
    private Button botaoVoltar;

    @FXML
    private TextField carroAnoNovo;

    @FXML
    private TextField carroCorNova;

    @FXML
    private TextField carroMarcaNova;

    @FXML
    private TextField carroPlacaNova;

    @FXML
    private TextField carroQuilometragemNova;

    @FXML
    private Pane telaDeCadastro;

/*=====================================================================================*/

    @FXML
    public void initialize() {
        LoginController c = new LoginController();
        receberLogin(c.retornarLogin());
    }

    @FXML
    public void receberLogin(String login){ //Exibe o nome do usuário
        userLogin.setText(login);
    }

    @FXML
    void PesquisarServicos(ActionEvent event) throws Exception { // encaminha para TelaServiços
        Telas.TelaServico();
    }

    @FXML
    void inserirCarro(ActionEvent event) { // redireciona para tela de cadastrar novos carros

    }

    @FXML
    void pesquisarCliente(ActionEvent event) throws Exception { // encaminha para TelaCliente
        Telas.TelaCliente();
    }

    @FXML
    void pesquisarDono(ActionEvent event) { // pesquisa no BD por ID de cliente

    }

    @FXML
    void pesquisarPecas(ActionEvent event) throws Exception{ // encaminha para TelaPecas
        Telas.TelaPecas();
    }

    @FXML
    void pesquisarPlaca(ActionEvent event) { // pesquisa no BD por placa

    }

    @FXML
    void cadastrarNovoCarro(ActionEvent event) { // cadastra novo carro

    }

    @FXML
    void voltarTelaAutomovel(ActionEvent event) { // volta para tela de automovel

    }

    @FXML
    void sair(ActionEvent event) throws Exception { //volta para o login
        Telas.telaLogin();
    }
}
