package com.example.ahorcado.controller;

import com.example.ahorcado.model.Word;
import com.example.ahorcado.view.GameView;
import com.example.ahorcado.view.WelcomeView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class WelcomeController {
    @FXML
    private TextField secretWordTextField;

    @FXML
    void onHandlerButtonPlay(ActionEvent event) throws IOException {
        String secretWord = secretWordTextField.getText();

        Word word = new Word(secretWord);
        GameView.getInstance().getGameController().setWord(word);
        WelcomeView.deleteInstance();
    }

}
