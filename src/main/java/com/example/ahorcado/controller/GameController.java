package com.example.ahorcado.controller;

import com.example.ahorcado.model.Word;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.List;

public class GameController {
    @FXML
    private ImageView imageAhorcado;
    private Word word;

    @FXML
    private HBox hBoxLayout;

    @FXML



    public void crearCamposTextoPalabraSecreta() {
        String secretWord = word.getWordSecret();

        for (int i = 0; i < secretWord.length(); i++) {
            TextField wordTxt = new TextField();
            wordTxt.setPrefWidth(40);
            hBoxLayout.getChildren().add(wordTxt);
            //manejarPulsacionTecla(wordTxt, i);
        }
    }


    @FXML
    void onHandlerButtonHelp(ActionEvent event) {
        System.out.println(word);

    }

    public void setWord(Word word) {
        this.word = word;
        crearCamposTextoPalabraSecreta(); // Crea los TextFields al asignar la palabra

    }

}