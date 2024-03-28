package com.example.ahorcado.controller;

import com.example.ahorcado.model.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class GameController {
    @FXML
    private ImageView imageAhorcado;
    private Word word;

    @FXML
    void onHandlerButtonHelp(ActionEvent event) {
        System.out.println(word);

    }



    public void setWord(Word word) {
        this.word = word;
    }

}
