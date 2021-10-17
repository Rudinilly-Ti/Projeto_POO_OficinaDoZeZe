package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaServicoChefe extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stg) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("VE/TelaServicoChefe.fxml"));
        Scene cena = new Scene(root);
        stg.setTitle("Oficina do Zezé");
        stg.setScene(cena);
        stg.show();
    }
}
