package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application{
    private static Stage primaryStage;

    public static Stage getPrimaryStage(){
        return primaryStage;
    }
    public static void setPrimaryStage(Stage ps){
        primaryStage = ps;
    }

    public void start(Stage ps) throws Exception {
        setPrimaryStage(ps);
        ps.setTitle("Oficina do Zezé");
        ps.show();
        telaLogin();
    }

    public static void telaLogin() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaLogin.fxml"));
        Scene cena = new Scene(root);

        primaryStage.setScene(cena);
    } 
    
    public static void telaCadastro() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaCadastro.fxml"));
        Scene cena = new Scene(root);

        primaryStage.setScene(cena);
    }

    public static void mainMenu() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/MainMenu.fxml"));
        Scene cena = new Scene(root);
       
        primaryStage.setScene(cena);
    }

    public static void telaCliente() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaCliente.fxml"));
        Scene cena = new Scene(root);

        primaryStage.setScene(cena);
    }

    public static void telaAutomovel() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaAutomovel.fxml"));
        Scene cena = new Scene(root);

        primaryStage.setScene(cena);
    }

    public static void telaPecas() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaPecas.fxml"));
        Scene cena = new Scene(root);

        primaryStage.setScene(cena);
    }

    public static void telaServico() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaServico.fxml"));
        Scene cena = new Scene(root);

        primaryStage.setScene(cena);
    }

    public static void telaOrcamento() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaOrcamento.fxml"));
        Scene cena = new Scene(root);

        primaryStage.setScene(cena);
    }

    public static void main(String[] args) {
        launch();
    }
}
