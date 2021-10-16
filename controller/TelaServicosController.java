package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

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
    void PesquisarServicos(ActionEvent event) { // acontece nada, pois já está na tela servicos

    }

    @FXML
    void inserirServico(ActionEvent event) { // cadastra um novo servico

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
}
