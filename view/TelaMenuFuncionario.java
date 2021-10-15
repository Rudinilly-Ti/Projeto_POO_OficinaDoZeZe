package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaMenuFuncionario extends Application{
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stg) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("VE/TelaMenuFuncionario.fxml"));
        Scene cena = new Scene(root);
        stg.setTitle("Oficina do Zezé");
        stg.setScene(cena);
        stg.show();
    }
}