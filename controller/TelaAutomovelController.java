package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class TelaAutomovelController {

    @FXML
    private TextField Placa; //Barra de texto, para pesquisar por placa

    @FXML
    private Button adicionarCarro; // botao de inserir novos carros

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
    private ImageView botaoSair; // botao que volta para o menu principal

    @FXML
    private Button botaoServico; // botao que vai para tela de buscar Serviços

    @FXML
    private TextField dono; // Barra de texto, para pesquisar por cliente

    @FXML
    private Label nomeDoUsuario; // label, na qual irá aparecer o nome do usuário

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
    void PesquisarServicos(ActionEvent event) throws Exception { // encaminha para TelaServiços
        //Telas.TelaServico();
    }

    @FXML
    void inserirCarro(ActionEvent event) { // redireciona para tela de cadastrar novos carros

    }

    @FXML
    void pesquisarCarros(ActionEvent event) throws Exception { // não faz nada, retorna mensagem -> "vocẽ já está na aba de carros"
        //Telas.TelaAutomovel();
    }

    @FXML
    void pesquisarCliente(ActionEvent event) throws Exception { // encaminha para TelaCliente
        //Telas.TelaCliente();
    }

    @FXML
    void pesquisarDono(ActionEvent event) { // pesquisa no BD por ID de cliente

    }

    @FXML
    void pesquisarPecas(ActionEvent event) { // encaminha para TelaPecas

    }

    @FXML
    void pesquisarPlaca(ActionEvent event) { // pesquisa no BD por placa

    }

    @FXML
    void voltarParaMenu(ActionEvent event) throws Exception { // encaminha para TelaMenu
        //Telas.menu();
    }

    @FXML
    void cadastrarNovoCarro(ActionEvent event) { // cadastra novo carro

    }

    @FXML
    void voltarTelaAutomovel(ActionEvent event) { // volta para tela de automovel

    }
}
