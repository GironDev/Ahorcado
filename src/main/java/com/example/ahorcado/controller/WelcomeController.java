package com.example.ahorcado.controller;

import com.example.ahorcado.model.Word;
import com.example.ahorcado.view.GameView;
import com.example.ahorcado.view.WelcomeView;
import com.example.ahorcado.view.alert.AlertBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class WelcomeController {
    @FXML
    private TextField secretWordTextField;

    private AlertBox alertBox = new AlertBox();

    @FXML
    void onHandlerButtonPlay(ActionEvent event) throws IOException {
        String secretWord = secretWordTextField.getText();

        if (isValidWord(secretWord)) {
            Word word = new Word(secretWord);
            GameView.getInstance().getGameController().setWord(word);
            WelcomeView.deleteInstance();
        } else {
            // Mostrar un mensaje de error al usuario
            showInvalidWordAlert();
        }
    }

    private void showInvalidWordAlert() {
        alertBox.showMessage(
                "¡Error!",
                "La palabra no es válida",
                "Debes introducir una palabra que solo contenga letras. Inténtalo de nuevo."
        );
    }
    private boolean isValidWord(String word) {
        return !word.isEmpty() && word.matches("[a-zA-Z]+");
    }
}
