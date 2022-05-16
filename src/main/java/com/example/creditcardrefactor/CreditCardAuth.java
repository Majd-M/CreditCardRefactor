package com.example.creditcardrefactor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CreditCardAuth extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CreditCardAuth.class.getResource("CardView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Credit Card Validator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}