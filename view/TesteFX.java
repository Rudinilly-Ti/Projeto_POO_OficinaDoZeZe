package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TesteFX extends Application{
    
    @Override
    public void start(Stage telinha) throws Exception {
        Label teste = new Label();
        teste.setText("Testando a classe TesteFX");

        Scene cenario = new Scene(teste, 640, 480);

        telinha.setTitle("Telinha de teste");
        telinha.setScene(cenario);
        telinha.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
