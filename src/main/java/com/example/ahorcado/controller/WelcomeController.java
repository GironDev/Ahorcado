
package com.example.ahorcado.controller;

import com.example.ahorcado.model.Word;
import com.example.ahorcado.view.GameView;
import com.example.ahorcado.view.WelcomeView;
import com.example.ahorcado.view.alert.AlertBox;
//import com.example.ahorcado.view.alert.AlertBoxRules;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class WelcomeController {
    @FXML
    private TextField secretWordTextField;
    @FXML
    private ImageView imageHelp;
    private AlertBox alertBox = new AlertBox();
    private AlertBox alertBoxRules = new AlertBox();

    private GameController gameController; // Referencia al GameController

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    @FXML
    void onMouseClickedImage(MouseEvent event) {
        showHelpAlert();
    }
    @FXML
    void onHandlerButtonPlay(ActionEvent event) throws IOException {
        String secretWord = secretWordTextField.getText();

        if (isValidWord(secretWord)) {
            Word word = new Word(secretWord);
            GameView.getInstance().getGameController().setWord(word);
            WelcomeView.deleteInstance();
//            gameController.crearCamposTextoPalabraSecreta();

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
    private void showHelpAlert() {
//        AlertBox.showMessage(
//                "Reglas",
//                "Reglas del juego",
//                "El Ahorcado es un juego para dos jugadores, en él cual un jugador (Jugador 1) piensa una palabra y el otro la intenta adivinar (jugador 2)." +
//                        "\nTienes 7 oportunidades para adivinar la palabra." +
//                        "\nDiviertete!!"
//        );
        System.out.println("HOLA");
    }
}
