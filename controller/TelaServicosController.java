package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

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
    private ImageView botaoSair;

    @FXML
    private Button botaoServico;

    @FXML
    private Label nomeDoUsuario;

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
    void PesquisarServicos(ActionEvent event) { // acontece nada, pois já está na tela servicos

    }

    @FXML
    void inserirServico(ActionEvent event) { // abre a tela de cadastrar um novo servico

    }

    @FXML
    void pesquisarCarros(ActionEvent event) { // redireciona para tela automoveis

    }

    @FXML
    void pesquisarCliente(ActionEvent event) { // redireciona para tela clientes

    }

    @FXML
    void pesquisarPecas(ActionEvent event) { // redireciona para tela pecas

    }

    @FXML
    void pesquisarServicosPorNome(ActionEvent event) { // lista servicos

    }

    @FXML
    void voltarParaMenu(ActionEvent event) { // sai

    }

    @FXML
    void cadastrarNovoServico(ActionEvent event) { // cadastra novo serviço

    }

    @FXML
    void voltarTelaServico(ActionEvent event) { // volta para tela de serviço

    }
}
