package controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import Exceptions.FindException;
import Model.BO.AutomovelBO;
import Model.BO.OrcamentoBO;
import Model.BO.PecaBO;
import Model.BO.PecasNoOrcamentoBO;
import Model.BO.ServicoBO;
import Model.BO.ServicosNoOrcamentoBO;
import Model.VO.OrcamentoVO;
import Model.VO.PecasNoOrcamentoVO;
import Model.VO.ServicosNoOrcamentoVO;
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
	private Pane dllPane;

	@FXML
	private Button buttonCancelar;

	@FXML
	private Button buttonDeletar;

	@FXML
	private TextField idItemDeletar;

	@FXML
	private DatePicker dataFim;

	@FXML
	private CheckBox servFinalizadoATT;

	@FXML
	private TableView<PecasNoOrcamentoVO> tablePecaCAD;

	@FXML
	private TableView<ServicosNoOrcamentoVO> tableServCAD;

	@FXML
	private TableColumn<PecasNoOrcamentoVO, String> pecaColCAD;

	@FXML
	private TableColumn<PecasNoOrcamentoVO, String> qntPecaColCAD;

	@FXML
	private TableColumn<ServicosNoOrcamentoVO, String> qntServColCAD;

	@FXML
	private TableColumn<PecasNoOrcamentoVO, String> qntPecaColATT;

	@FXML
	private TableColumn<ServicosNoOrcamentoVO, String> qntServColATT;

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
    private Label findPeriodoErrorText;

	@FXML
    private Label findCarroErrorText;

	@FXML
    private Label findClienteErrorText;

	@FXML
	private Button addPecaButtonATT;

	@FXML
	private Button delPecaButtonCAD;

	@FXML
	private TableColumn<OrcamentoVO, String> clienteCol;

	@FXML
	private TableColumn<OrcamentoVO, String> valorCol;

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
	private TableColumn<ServicosNoOrcamentoVO, String> servColATT;

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
	private TableView<PecasNoOrcamentoVO> tablePecaATT;

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
	private TableView<ServicosNoOrcamentoVO> tableServATT;

	@FXML
	private TableColumn<ServicosNoOrcamentoVO, String> servColCAD;

	@FXML
	private Button botaoPesquisarCliente;

	@FXML
	private DatePicker dataIni;

	@FXML
	private TableColumn<PecasNoOrcamentoVO, String> pecaColATT;

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

		placaCol.setCellValueFactory(new Callback<CellDataFeatures<OrcamentoVO, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<OrcamentoVO, String> c) {
				return new SimpleStringProperty(c.getValue().getCarro().getPlaca().toUpperCase());
			}
		});

		clienteCol.setCellValueFactory(new Callback<CellDataFeatures<OrcamentoVO, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<OrcamentoVO, String> c) {
				return new SimpleStringProperty(c.getValue().getCliente().getNome());
			}
		});

		valorCol.setCellValueFactory(new Callback<CellDataFeatures<OrcamentoVO, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<OrcamentoVO, String> c) {
				return new SimpleStringProperty(String.valueOf(c.getValue().getValor()));
			}
		});

		dataIniCol.setCellValueFactory(new Callback<CellDataFeatures<OrcamentoVO, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<OrcamentoVO, String> c) {
				return new SimpleStringProperty(
						new SimpleDateFormat("dd/MM/yyyy").format(c.getValue().getDataInicio().getTime()));
			}
		});

		dataFimCol.setCellValueFactory(new Callback<CellDataFeatures<OrcamentoVO, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<OrcamentoVO, String> c) {
				return new SimpleStringProperty(new SimpleDateFormat("dd/MM/yyyy").format(c.getValue().getDataFim().getTime()));
			}

		});
		// tabela de pecas
		pecaColATT
				.setCellValueFactory(new Callback<CellDataFeatures<PecasNoOrcamentoVO, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<PecasNoOrcamentoVO, String> c) {
						return new SimpleStringProperty(c.getValue().getPeca().getNome());
					}
				});

		qntPecaColATT
				.setCellValueFactory(new Callback<CellDataFeatures<PecasNoOrcamentoVO, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<PecasNoOrcamentoVO, String> c) {
						return new SimpleStringProperty(String.valueOf(c.getValue().getQuantidade()));
					}
				});

		// tabela de serviços
		servColATT
				.setCellValueFactory(new Callback<CellDataFeatures<ServicosNoOrcamentoVO, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<ServicosNoOrcamentoVO, String> c) {
						return new SimpleStringProperty(c.getValue().getServico().getNome());
					}
				});

		qntServColATT
				.setCellValueFactory(new Callback<CellDataFeatures<ServicosNoOrcamentoVO, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<ServicosNoOrcamentoVO, String> c) {
						return new SimpleStringProperty(String.valueOf(c.getValue().getQuantidade()));
					}
				});
		tableOrcamento.setItems(FXCollections.observableArrayList(new OrcamentoBO().listar()));

		Buttons.initButtons(attCol, 20, ATT_ICON, "svg-gray", (OrcamentoVO orc, ActionEvent event) -> {
			orcamentoATT.setId(orc.getId());
			orcamentoATT.getCarro().setID(orc.getCarro().getID());
			orcamentoATT.getCarro().setPlaca(orc.getCarro().getPlaca());
			orcamentoATT.getCliente().setId(orc.getCliente().getId());
			orcamentoATT.setDataInicio(orc.getDataInicio());
			orcamentoATT.setDataFim(orc.getDataFim());
			orcamentoATT.setPagamentoEfetuado(orc.getPagamentoEfetuado());
			orcamentoATT.setServicoConcluido(orc.getServicoConcluido());
			orcamentoATT.setValor(orc.getValor());

			openRelatorioButton.setVisible(false);
			attOrcamento.setVisible(true);
			idOrcamento.setText(orc.getId().toString());
			addAutoPlacaATT.setText(orc.getCarro().getPlaca());

			if (orc.getPagamentoEfetuado()) {
				pagEfetuadoATT.setSelected(true);
			}

			if (orc.getServicoConcluido()) {
				servFinalizadoATT.setSelected(true);
			}

			selectDataIniATT.setValue(LocalDateTime
					.ofInstant(orc.getDataInicio().toInstant(), orc.getDataInicio().getTimeZone().toZoneId()).toLocalDate());
			selectDataFimATT.setValue(LocalDateTime
					.ofInstant(orc.getDataFim().toInstant(), orc.getDataFim().getTimeZone().toZoneId()).toLocalDate());

			PecasNoOrcamentoVO peca = new PecasNoOrcamentoVO();
			peca.getOrcamento().setId(orc.getId());
			try {
				novasPecasATT = new PecasNoOrcamentoBO().buscarPorOrcId(peca);
				tablePecaATT.setItems(FXCollections.observableArrayList(novasPecasATT));
			} catch (Exception e) {
			}

			ServicosNoOrcamentoVO serv = new ServicosNoOrcamentoVO();
			serv.getOrcamento().setId(orc.getId());
			try {
				novosServicosATT = new ServicosNoOrcamentoBO().buscarPorOrcId(serv);
				tableServATT.setItems(FXCollections.observableArrayList(novosServicosATT));
			} catch (Exception e) {

			}

		});

		Buttons.initButtons(delCol, 20, DEL_ICON, "svg-red", (OrcamentoVO orc, ActionEvent event) -> {
			dllPane.setVisible(true);
			idItemDeletar.setText(orc.getId().toString());
		});
	}

	@FXML
	public void receberLogin(String login) {
		userLogin.setText(login);
	}

	@FXML
	void cancelar(ActionEvent event) throws Exception {
		idItemDeletar.setText("");
		dllPane.setVisible(false);
	}

	@FXML
	void deletar(ActionEvent event) throws Exception {
		OrcamentoVO vo = new OrcamentoVO();
		PecasNoOrcamentoVO pVo = new PecasNoOrcamentoVO();
		ServicosNoOrcamentoVO sVo = new ServicosNoOrcamentoVO();

		vo.setId((long) Integer.parseInt(idItemDeletar.getText()));
		pVo.setOrcamento(vo);
		sVo.setOrcamento(vo);

		try {
			for (PecasNoOrcamentoVO pVo2 : new PecasNoOrcamentoBO().buscarPorOrcId(pVo)) {
				new PecasNoOrcamentoBO().deletar(pVo2);
			}

			for (ServicosNoOrcamentoVO sVo2 : new ServicosNoOrcamentoBO().buscarPorOrcId(sVo)) {
				new ServicosNoOrcamentoBO().deletar(sVo2);
			}
		} catch (FindException e) {

		}

		OrcamentoBO bo = new OrcamentoBO();
		vo.setId((long) Integer.parseInt(idItemDeletar.getText()));
		bo.deletar(vo);
		tableOrcamento.setItems(FXCollections.observableArrayList(new OrcamentoBO().listar()));
		cancelar(event);
	}

	// metodos cadastrar
	List<PecasNoOrcamentoVO> novasPecas = new ArrayList<PecasNoOrcamentoVO>();
	List<ServicosNoOrcamentoVO> novosServicos = new ArrayList<ServicosNoOrcamentoVO>();

	@FXML
	void openCad(ActionEvent event) {
		pecaColCAD
				.setCellValueFactory(new Callback<CellDataFeatures<PecasNoOrcamentoVO, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<PecasNoOrcamentoVO, String> c) {
						return new SimpleStringProperty(c.getValue().getPeca().getNome());
					}
				});

		qntPecaColCAD
				.setCellValueFactory(new Callback<CellDataFeatures<PecasNoOrcamentoVO, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<PecasNoOrcamentoVO, String> c) {
						return new SimpleStringProperty(String.valueOf(c.getValue().getQuantidade()));
					}
				});

		tablePecaCAD.setItems(FXCollections.observableArrayList(novasPecas));

		servColCAD
				.setCellValueFactory(new Callback<CellDataFeatures<ServicosNoOrcamentoVO, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<ServicosNoOrcamentoVO, String> c) {
						return new SimpleStringProperty(c.getValue().getServico().getNome());
					}
				});

		qntServColCAD
				.setCellValueFactory(new Callback<CellDataFeatures<ServicosNoOrcamentoVO, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<ServicosNoOrcamentoVO, String> c) {
						return new SimpleStringProperty(String.valueOf(c.getValue().getQuantidade()));
					}
				});
		tableServCAD.setItems(FXCollections.observableArrayList(novosServicos));
		openRelatorioButton.setVisible(false);
		cadOrcamento.setVisible(true);
	}

	@FXML
	void closeCad(ActionEvent event) {
		addAutoPlacaCAD.setText("");
		pecaIdCAD.setText("");
		servIdCAD.setText("");
		pagEfetuadoCAD.setSelected(false);
		servFinalizadoCAD.setSelected(false);
		novasPecas.clear();
		novosServicos.clear();
		cadOrcamento.setVisible(false);
		openRelatorioButton.setVisible(true);
	}

	@FXML
	void addPecaCAD(ActionEvent event) {
		long novapeca = Long.parseLong(pecaIdCAD.getText());
		boolean exist = false;
		for (int i = 0; i < novasPecas.size(); i++) {
			if (novasPecas.get(i).getPeca().getId() == novapeca) {
				int qnt = novasPecas.get(i).getQuantidade() + 1;
				novasPecas.get(i).setQuantidade(qnt);
				novasPecas.get(i).setValor(novasPecas.get(i).getValor() * qnt);
				exist = true;
				tablePecaCAD.refresh();
			}
		}
		if (!exist) {
			PecasNoOrcamentoVO vo = new PecasNoOrcamentoVO();
			vo.getPeca().setId(novapeca);
			vo.getPeca().setNome(new PecaBO().buscarPorId(vo.getPeca()).get(0).getNome());
			vo.getPeca().setPreco(new PecaBO().buscarPorId(vo.getPeca()).get(0).getPreco());
			vo.setQuantidade(1);
			vo.setValor(vo.getPeca().getPreco() * vo.getQuantidade());

			novasPecas.add(vo);

			tablePecaCAD.setItems(FXCollections.observableArrayList(novasPecas));
		}

	}

	@FXML
	void addServCAD(ActionEvent event) {
		long novoServico = Long.parseLong(servIdCAD.getText());
		boolean exist = false;

		for (int i = 0; i < novosServicos.size(); i++) {
			if (novosServicos.get(i).getServico().getId() == novoServico) {
				int qnt = novosServicos.get(i).getQuantidade() + 1;
				novosServicos.get(i).setQuantidade(qnt);
				novosServicos.get(i).setValor(novosServicos.get(i).getValor() * qnt);
				tableServCAD.refresh();
				exist = true;
			}
		}

		if (!exist) {
			ServicosNoOrcamentoVO vo = new ServicosNoOrcamentoVO();
			vo.getServico().setId(novoServico);
			vo.getServico().setNome(new ServicoBO().buscarPorId(vo.getServico()).get(0).getNome());
			vo.getServico().setPreco(new ServicoBO().buscarPorId(vo.getServico()).get(0).getPreco());
			vo.setQuantidade(1);
			vo.setValor(vo.getServico().getPreco() * vo.getQuantidade());
			novosServicos.add(vo);
			tableServCAD.setItems(FXCollections.observableArrayList(novosServicos));
		}
	}

	@FXML
	void delPecaCAD(ActionEvent event) {
		long item = Long.parseLong(pecaIdCAD.getText());
		for (int i = 0; i < novasPecas.size(); i++) {
			if (novasPecas.get(i).getPeca().getId() == item) {
				if (novasPecas.get(i).getQuantidade() == 1) {
					novasPecas.remove(i);
					tablePecaCAD.setItems(FXCollections.observableArrayList(novasPecas));
				} else {
					novasPecas.get(i).setQuantidade(novasPecas.get(i).getQuantidade() - 1);
					tablePecaCAD.refresh();
				}
			}
		}

	}

	@FXML
	void delServCAD(ActionEvent event) {
		long item = Long.parseLong(servIdCAD.getText());
		for (int i = 0; i < novosServicos.size(); i++) {
			if (novosServicos.get(i).getServico().getId() == item) {
				if (novosServicos.get(i).getQuantidade() == 1) {
					novosServicos.remove(i);
					tableServCAD.setItems(FXCollections.observableArrayList(novosServicos));
				} else {
					novosServicos.get(i).setQuantidade(novosServicos.get(i).getQuantidade() - 1);
					tableServCAD.refresh();
				}
			}
		}
	}

	@FXML
	void finishCad(ActionEvent event) {
		OrcamentoVO vo = new OrcamentoVO();
		OrcamentoBO bo = new OrcamentoBO();
		for (PecasNoOrcamentoVO pecas : novasPecas) {
			vo.setValor(vo.getValor() + pecas.getValor());
		}

		for (ServicosNoOrcamentoVO servicos : novosServicos) {
			vo.setValor(vo.getValor() + servicos.getValor());
		}

		vo.getCarro().setPlaca(addAutoPlacaCAD.getText().toLowerCase());
		vo.getCarro().setID(new AutomovelBO().buscarPorPlaca(vo.getCarro()).get(0).getID());
		vo.getCliente().setId(new AutomovelBO().buscarPorPlaca(vo.getCarro()).get(0).getCliente().getId());

		vo.setDataInicio(new Calendar.Builder().setDate(selectDataIniCAD.getValue().getYear(),
				selectDataIniCAD.getValue().getMonthValue() - 1, selectDataIniCAD.getValue().getDayOfMonth()).build());

		vo.setDataFim(new Calendar.Builder().setDate(selectDataFimCAD.getValue().getYear(),
				selectDataFimCAD.getValue().getMonthValue() - 1, selectDataFimCAD.getValue().getDayOfMonth()).build());
		bo.inserir(vo);
		vo.setId(bo.retornarId(vo).getId());

		if (pagEfetuadoCAD.isSelected()) {
			vo.setPagamentoEfetuado(true);
			bo.registrarPagamento(vo);
		}

		if (servFinalizadoCAD.isSelected()) {
			vo.setServicoConcluido(true);
			bo.finalizarServico(vo);
		}

		PecasNoOrcamentoBO bopecas = new PecasNoOrcamentoBO();
		for (int i = 0; i < novasPecas.size(); i++) {
			novasPecas.get(i).getOrcamento().setId(vo.getId());
			bopecas.inserir(novasPecas.get(i));
		}

		ServicosNoOrcamentoBO boserv = new ServicosNoOrcamentoBO();
		for (int i = 0; i < novosServicos.size(); i++) {
			novosServicos.get(i).getOrcamento().setId(vo.getId());
			boserv.inserir(novosServicos.get(i));
		}
		tableOrcamento.setItems(FXCollections.observableArrayList(new OrcamentoBO().listar()));
		closeCad(event);
	}

	// metodos atualizar
	List<PecasNoOrcamentoVO> novasPecasATT = new ArrayList<PecasNoOrcamentoVO>();
	List<ServicosNoOrcamentoVO> novosServicosATT = new ArrayList<ServicosNoOrcamentoVO>();

	@FXML
	void openAtt(ActionEvent event) {
		attOrcamento.setVisible(true);
	}

	@FXML
	void closeAtt(ActionEvent event) {
		tableServATT.getItems().clear();
		tablePecaATT.getItems().clear();
		novosServicosATT.clear();
		novasPecasATT.clear();
		addAutoPlacaATT.setText("");
		pecaIdATT.setText("");
		servIdATT.setText("");
		servFinalizadoATT.setSelected(false);
		pagEfetuadoATT.setSelected(false);
		attOrcamento.setVisible(false);
		openRelatorioButton.setVisible(true);
	}

	@FXML
	void addPecaATT(ActionEvent event) {
		long novapeca = Long.parseLong(pecaIdATT.getText());
		boolean exist = false;
		for (int i = 0; i < novasPecasATT.size(); i++) {
			if (novasPecasATT.get(i).getPeca().getId() == novapeca) {
				int qnt = novasPecasATT.get(i).getQuantidade() + 1;
				novasPecasATT.get(i).setQuantidade(qnt);
				novasPecasATT.get(i).setValor(novasPecasATT.get(i).getValor() * qnt);
				exist = true;
				tablePecaATT.refresh();
			}
		}
		if (!exist) {
			PecasNoOrcamentoVO vo = new PecasNoOrcamentoVO();
			vo.getPeca().setId(novapeca);
			vo.getPeca().setNome(new PecaBO().buscarPorId(vo.getPeca()).get(0).getNome());
			vo.getPeca().setPreco(new PecaBO().buscarPorId(vo.getPeca()).get(0).getPreco());
			vo.getOrcamento().setId(orcamentoATT.getId());
			vo.setQuantidade(1);
			vo.setValor(vo.getPeca().getPreco() * vo.getQuantidade());

			novasPecasATT.add(vo);

			tablePecaATT.setItems(FXCollections.observableArrayList(novasPecasATT));
		}

	}

	@FXML
	void addServATT(ActionEvent event) {
		long novoServico = Long.parseLong(servIdATT.getText());
		boolean exist = false;

		for (int i = 0; i < novosServicosATT.size(); i++) {
			if (novosServicosATT.get(i).getServico().getId() == novoServico) {
				int qnt = novosServicosATT.get(i).getQuantidade() + 1;
				novosServicosATT.get(i).setQuantidade(qnt);
				novosServicosATT.get(i).setValor(novosServicosATT.get(i).getValor() * qnt);
				tableServATT.refresh();
				exist = true;
			}
		}

		if (!exist) {
			ServicosNoOrcamentoVO vo = new ServicosNoOrcamentoVO();
			vo.getServico().setId(novoServico);
			vo.getServico().setNome(new ServicoBO().buscarPorId(vo.getServico()).get(0).getNome());
			vo.getServico().setPreco(new ServicoBO().buscarPorId(vo.getServico()).get(0).getPreco());
			vo.setQuantidade(1);
			vo.setValor(vo.getServico().getPreco() * vo.getQuantidade());
			vo.getOrcamento().setId(orcamentoATT.getId());
			novosServicosATT.add(vo);
			tableServATT.setItems(FXCollections.observableArrayList(novosServicosATT));
		}
	}

	@FXML
	void delPecaATT(ActionEvent event) {
		long item = Long.parseLong(pecaIdATT.getText());
		for (int i = 0; i < novasPecasATT.size(); i++) {
			if (novasPecasATT.get(i).getPeca().getId() == item) {
				if (novasPecasATT.get(i).getQuantidade() == 1) {
					novasPecasATT.remove(i);
					tablePecaATT.setItems(FXCollections.observableArrayList(novasPecasATT));
				} else {
					novasPecasATT.get(i).setQuantidade(novasPecasATT.get(i).getQuantidade() - 1);
					tablePecaATT.refresh();
				}
			}
		}
	}

	@FXML
	void delServATT(ActionEvent event) {
		long item = Long.parseLong(servIdATT.getText());
		for (int i = 0; i < novosServicosATT.size(); i++) {
			if (novosServicosATT.get(i).getServico().getId() == item) {
				if (novosServicosATT.get(i).getQuantidade() == 1) {
					novosServicosATT.remove(i);
					tableServATT.setItems(FXCollections.observableArrayList(novosServicosATT));
				} else {
					novosServicosATT.get(i).setQuantidade(novosServicosATT.get(i).getQuantidade() - 1);
					tableServATT.refresh();
				}
			}
		}
	}

	OrcamentoVO orcamentoATT = new OrcamentoVO();

	@FXML
	void finishAtt(ActionEvent event) {
		// inserir novas peças
		PecasNoOrcamentoBO pecas = new PecasNoOrcamentoBO();

		PecasNoOrcamentoVO voPeca = new PecasNoOrcamentoVO();
		voPeca.getOrcamento().setId(orcamentoATT.getId());
		Double valor = 0.0;

		for (int i = 0; i < novasPecasATT.size(); i++) {
			valor += novasPecasATT.get(i).getValor();

		}
		try {
			List<PecasNoOrcamentoVO> pecasAtuais = pecas.buscarPorOrcId(voPeca);

			for (int i = 0; i < novasPecasATT.size(); i++) {
				for (int j = 0; j < pecasAtuais.size(); j++) {
					if (novasPecasATT.get(i).getId() == pecasAtuais.get(j).getId()) {
						if (novasPecasATT.get(i).getQuantidade() != pecasAtuais.get(j).getQuantidade()) {
							pecas.editarQuantidade(novasPecasATT.get(i));
						}
						if (novasPecasATT.get(i).getValor() != pecasAtuais.get(j).getValor()) {
							pecas.editarValor(novasPecasATT.get(i));
						}
						novasPecasATT.remove(i);
					}
				}
			}
		} catch (Exception e) {
		}

		for (int i = 0; i < novasPecasATT.size(); i++) {
			pecas.inserir(novasPecasATT.get(i));
		}

		// inserir novos servicos
		ServicosNoOrcamentoBO serv = new ServicosNoOrcamentoBO();

		ServicosNoOrcamentoVO voServ = new ServicosNoOrcamentoVO();
		voServ.getOrcamento().setId(orcamentoATT.getId());
		for (int i = 0; i < novosServicosATT.size(); i++) {
			valor += novosServicosATT.get(i).getValor();
		}
		try {
			List<ServicosNoOrcamentoVO> servAtuais = serv.buscarPorOrcId(voServ);

			for (int i = 0; i < novosServicosATT.size(); i++) {
				for (int j = 0; j < servAtuais.size(); j++) {
					if (novosServicosATT.get(i).getId() == servAtuais.get(j).getId()) {
						if (novosServicosATT.get(i).getQuantidade() != servAtuais.get(j).getQuantidade()) {
							serv.editarQuantidade(novosServicosATT.get(i));
						}
						if (novosServicosATT.get(i).getValor() != servAtuais.get(j).getValor()) {
							serv.editarValor(novosServicosATT.get(i));
						}
						novosServicosATT.remove(i);
					}
				}
			}
		} catch (Exception e) {
		}

		for (int i = 0; i < novosServicosATT.size(); i++) {
			serv.inserir(novosServicosATT.get(i));
		}

		OrcamentoBO boOrca = new OrcamentoBO();

		if (servFinalizadoATT.isSelected() != orcamentoATT.getServicoConcluido()) {
			orcamentoATT.setServicoConcluido(servFinalizadoATT.isSelected());
			boOrca.finalizarServico(orcamentoATT);
		}

		if (pagEfetuadoATT.isSelected() != orcamentoATT.getPagamentoEfetuado()) {
			orcamentoATT.setPagamentoEfetuado(pagEfetuadoATT.isSelected());
			boOrca.registrarPagamento(orcamentoATT);
		}
		// atualizar datas
		Calendar inicialATT = new Calendar.Builder().setDate(selectDataIniATT.getValue().getYear(),
				selectDataIniATT.getValue().getMonthValue() - 1, selectDataIniATT.getValue().getDayOfMonth()).build();

		Calendar finalATT = new Calendar.Builder().setDate(selectDataFimATT.getValue().getYear(),
				selectDataFimATT.getValue().getMonthValue() - 1, selectDataFimATT.getValue().getDayOfMonth()).build();

		if (inicialATT != orcamentoATT.getDataInicio()) {
			orcamentoATT.setDataInicio(inicialATT);
			boOrca.editarDataInicial(orcamentoATT);
		}

		if (finalATT != orcamentoATT.getDataFim()) {
			orcamentoATT.setDataFim(finalATT);
			boOrca.editarDataFinal(orcamentoATT);
		}

		String placa = addAutoPlacaATT.getText();

		if (!placa.equals(orcamentoATT.getCarro().getPlaca())) {
			orcamentoATT.getCarro().setPlaca(placa);
			orcamentoATT.getCarro().setID(new AutomovelBO().buscarPorPlaca(orcamentoATT.getCarro()).get(0).getID());
			orcamentoATT.getCliente()
					.setId(new AutomovelBO().buscarPorPlaca(orcamentoATT.getCarro()).get(0).getCliente().getId());
			boOrca.editarAutomovelId(orcamentoATT);
			boOrca.editarClienteId(orcamentoATT);
		}

		if (valor != orcamentoATT.getValor()) {
			orcamentoATT.setValor(valor);
			boOrca.editarValor(orcamentoATT);
		}

		tableOrcamento.setItems(FXCollections.observableArrayList(new OrcamentoBO().listar()));

		closeAtt(event);
	}

	// metodos relatorio

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

	// metodos pesquisar

	@FXML
	void pesquisarPeriodo(ActionEvent event) throws Exception {
		String textDataIni = dataIni.getEditor().getText();
		String textDataFim = dataFim.getEditor().getText();

		if (textDataIni != null && textDataFim != null && !textDataIni.isBlank() && !textDataFim.isBlank()) {
			
			try {
				OrcamentoVO vo = new OrcamentoVO();
				OrcamentoBO bo = new OrcamentoBO();

				Calendar dataIn = Calendar.getInstance();
				dataIn.set(Calendar.DAY_OF_MONTH, dataIni.getValue().getDayOfMonth());
				dataIn.set(Calendar.MONTH, (dataIni.getValue().getMonthValue() - 1));
				dataIn.set(Calendar.YEAR, dataIni.getValue().getYear());

				Calendar dataFi = Calendar.getInstance();
				dataFi.set(Calendar.DAY_OF_MONTH, dataFim.getValue().getDayOfMonth());
				dataFi.set(Calendar.MONTH, (dataFim.getValue().getMonthValue() - 1));
				dataFi.set(Calendar.YEAR, dataFim.getValue().getYear());

				vo.setDataInicio(dataIn);
				vo.setDataFim(dataFi);

				findClienteErrorText.setVisible(false);
				findCarroErrorText.setVisible(false);
				findPeriodoErrorText.setVisible(false);
				tableOrcamento.setItems(FXCollections.observableArrayList(bo.buscarPorPeriodo(vo)));
			} catch (FindException e) {
				findPeriodoErrorText.setVisible(true);
			}
		} else {
			findClienteErrorText.setVisible(false);
			findCarroErrorText.setVisible(false);
			findPeriodoErrorText.setVisible(false);
			tableOrcamento.setItems(FXCollections.observableArrayList(new OrcamentoBO().listar()));
		}
	}

	@FXML
	void pesquisarDataInicial(ActionEvent event) throws Exception {

	}

	@FXML
	void pesquisarPlaca(ActionEvent event) throws Exception {
		String placa = Placa.getText();

		if (placa != null && !placa.isBlank()) {
			try {
				OrcamentoBO bo = new OrcamentoBO();
				OrcamentoVO vo = new OrcamentoVO();
				vo.getCarro().setPlaca(placa);

				findClienteErrorText.setVisible(false);
				findCarroErrorText.setVisible(false);
				findPeriodoErrorText.setVisible(false);
				tableOrcamento.setItems((FXCollections.observableArrayList(bo.buscarPorAutomovel(vo.getCarro()))));
			} catch (FindException e) {
				findCarroErrorText.setVisible(true);
			}
		} else {
			findClienteErrorText.setVisible(false);
			findCarroErrorText.setVisible(false);
			findPeriodoErrorText.setVisible(false);
			tableOrcamento.setItems((FXCollections.observableArrayList(new OrcamentoBO().listar())));
		}
	}

	@FXML
	void pesquisarCliente(ActionEvent event) throws Exception {
		String cliente = dono.getText();

		if (cliente != null && !cliente.isBlank()) {
			try {
				OrcamentoBO bo = new OrcamentoBO();
				OrcamentoVO vo = new OrcamentoVO();
				vo.getCliente().setNome(cliente);

				findClienteErrorText.setVisible(false);
				findCarroErrorText.setVisible(false);
				findPeriodoErrorText.setVisible(false);
				tableOrcamento.setItems((FXCollections.observableArrayList(bo.buscarPorDono(vo.getCliente()))));
			} catch (FindException e) {
				findClienteErrorText.setVisible(true);
			}
		} else {
			findClienteErrorText.setVisible(false);
			findCarroErrorText.setVisible(false);
			findPeriodoErrorText.setVisible(false);
			tableOrcamento.setItems((FXCollections.observableArrayList(new OrcamentoBO().listar())));
		}
	}

	// menu chefe

	@FXML
	void chamarChefePeca(ActionEvent event) throws Exception {
		Telas.telaPecas();
	}

	@FXML
	void chamarChefeAuto(ActionEvent event) throws Exception {
		Telas.telaAutomovel();
	}

	@FXML
	void chamarChefeServ(ActionEvent event) throws Exception {
		Telas.telaServico();
	}

	@FXML
	void chamarChefeCliente(ActionEvent event) throws Exception {
		Telas.telaCliente();
	}

	// sair
	@FXML
	void sair(ActionEvent event) throws Exception {
		Telas.telaLogin();
	}
}
