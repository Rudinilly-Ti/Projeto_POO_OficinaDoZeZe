package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import view.Telas;

public class TelaServicosController {
    @FXML
    private TextField NomeServico;

    @FXML
    private Button adicionarServico;

    @FXML
    private Button botaoAutomoveis;

    @FXML
    private Button botaoCliente;

    @FXML
    private Button botaoPecas;

    @FXML
    private Button botaoPesquisarServico;

    @FXML
    private Button botaoServico;

    @FXML
    private Pane telaDeCadastro;

    @FXML
    private TextField NomeServicoNovo;

    @FXML
    private TextField ValorServicoNovo;

    @FXML
    private Button botaoCadastrarServico;

    @FXML
    private Button voltarParaTelaServico;

    @FXML
    private Button botaoSair;

    @FXML
    private Text userLogin;

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
    void inserirServico(ActionEvent event) { // abre a tela de cadastrar um novo servico

    }

    @FXML
    void pesquisarCarros(ActionEvent event) throws Exception{ // redireciona para tela automoveis
        Telas.TelaAutomovel();
    }

    @FXML
    void pesquisarCliente(ActionEvent event) throws Exception{ // redireciona para tela clientes
        Telas.TelaCliente();
    }

    @FXML
    void pesquisarPecas(ActionEvent event) throws Exception{ // redireciona para tela pecas
        Telas.TelaPecas();
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
