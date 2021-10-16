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
    
    public static void TelaCadastro() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaCadastro.fxml"));
        Scene cena = new Scene(root);

        primaryStage.setScene(cena);
    }

    public static void MenuChefe() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/MenuChefe.fxml"));
        Scene cena = new Scene(root);
       
        primaryStage.setScene(cena);
    }

    public static void MenuFuncionario() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaMenuFuncionario.fxml"));
        Scene cena = new Scene(root);

        primaryStage.setScene(cena);
    }

    public static void main(String[] args) {
        launch();
    }
}
