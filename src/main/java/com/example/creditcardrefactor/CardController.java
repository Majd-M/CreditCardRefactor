package com.example.creditcardrefactor;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CardController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}