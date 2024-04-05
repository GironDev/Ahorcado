package com.example.ahorcado.controller;

import com.example.ahorcado.model.Word;
import com.example.ahorcado.view.alert.AlertBox;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class GameController {
    @FXML
    private ImageView imageAhorcado;
    private Word word;

    @FXML
    private HBox hBoxChoiceLayout;

    @FXML
    private HBox hBoxLayout;
    @FXML
    private TextField TextFieldCreated;

    @FXML
    private Button buttonHelp;

    @FXML
    private Button buttonAttemp;

    @FXML
    private TextField afterCreatedFields;
    // @FXML
    // private TextField wordTxt;

    @FXML
    private ArrayList<TextField> test = new ArrayList<>();

    private ArrayList<String> wordList;
    private ArrayList<String> copyList;

    private ArrayList<String> removedWords;

    private int intetos;
    private int fallos;

    private AlertBox alertBox = new AlertBox();

    private int remainingHelp = 3;

    private static final String[] IMAGENES = {
            "com/example/ahorcado/images/ahorcado/0.png",
            "com/example/ahorcado/images/ahorcado/1.png",
            "com/example/ahorcado/images/ahorcado/2.png",
            "com/example/ahorcado/images/ahorcado/3.png",
            "com/example/ahorcado/images/ahorcado/4.png",
            "com/example/ahorcado/images/ahorcado/5.png",
            "com/example/ahorcado/images/ahorcado/6.png"
    };

    public void crearCamposTextoPalabraSecreta() {
        String secretWord = word.getWordSecret();

        for (int i = 1; i < secretWord.length() + 1; i++) {
            TextField wordTxt = new TextField();
            wordTxt.setId(String.valueOf(i));
            // TextField afterCreatedFields = new TextField();
            TextFieldCreated = wordTxt;
            wordTxt.setPrefWidth(40);
            wordTxt.setEditable(false);
            hBoxLayout.getChildren().add(wordTxt);
            // // System.out.println("added camp " + i);
            // // System.out.println(wordTxt.getId());
            // manejarPulsacionTecla(wordTxt, i);
            test.add(TextFieldCreated);

            splitWord(secretWord);
        }
    }

    public void splitWord(String secretWord) {
        String[] splittedWord = secretWord.split("");
        wordList = new ArrayList<String>();
        copyList = new ArrayList<String>();

        // // System.out.println("STRIPPED WORD : ");
        for (int i = 0; i < splittedWord.length; i++) {
            wordList.add(splittedWord[i]);
            copyList.add(splittedWord[i]);
        }
    }

    public void verifyWord(Word word) {
        int intentos = 8;
        int fallo = 0;
        String receivedWord = word.getWordSecret();
        ObservableList<Node> sBox = hBoxChoiceLayout.getChildren();
        TextField txtChoice = (TextField) sBox.get(0);

        // System.out.println("Texto Ingresado:");
        // System.out.println(txtChoice.getText());

        // String[] splittedWord = receivedWord.split("");
        // wordList = new ArrayList<String>();

        String choiceWord = txtChoice.getText();

        if (choiceWord.length() > 1) {
            showInvalidWord();
        } else if (!choiceWord.matches("[a-zA-Z]+")) {
            showInvalidLetter();
        } else if (!choiceWord.isEmpty() && choiceWord.matches("[a-zA-Z]+")) {

            for (int i = 0; i < wordList.size(); i++) {
                ObservableList<Node> childs = hBoxLayout.getChildren();
                TextField tf = (TextField) childs.get(i);

                if (choiceWord.equalsIgnoreCase(wordList.get(i))) {
                    tf.setText(choiceWord);
                    txtChoice.setText("");
                    fallo = 0;
                } else {
                    fallo = fallo + 1;
                    actualizarImagen();
                }

            }

        }

    }

    @FXML
    void onHandlerButtonHelp(ActionEvent event) {
        remainingHelp = remainingHelp - 1;
        // System.out.println("Ayudas restantes:");
        // System.out.println(remainingHelp);
        int randomWordHelp = (int) (Math.random() * copyList.size() + 0);
        // System.out.println(randomWordHelp);
        // System.out.print("Letra a eliminar:");
        // @iMrStevenS2 was here ;)
        // System.out.println(wordList.get(randomWordHelp));
        // System.out.println("********************");
        String selectedLetter = copyList.get(randomWordHelp);
        ObservableList<Node> childs = hBoxLayout.getChildren();
        int newRandomWordHelp;
        for (int i = 0; i < wordList.size(); i++) {
            String actualPosition = wordList.get(i);
            TextField tf = (TextField) childs.get(i);
            if (tf.getText().equalsIgnoreCase(selectedLetter)) {
                // System.out.println("Espacio Ocupado");
                //

            } else {
                if (actualPosition.equalsIgnoreCase(selectedLetter)) {
                    tf.setText(selectedLetter);
                    // wordList.removeIf( n -> selectedLetter.equals(n));
                    copyList.remove(actualPosition);
                }
                // // System.out.println("Already Removed");
                // }

            }

            // System.out.println(selectedLetter);

        }

        // System.out.println(wordList);
        // System.out.println(copyList);
        if (remainingHelp == 0) {
            buttonHelp.setDisable(true);
            showInvalidHelps();
        }
    }

    @FXML
    void onHandlerTrybutton(ActionEvent event) {
        verifyWord(word);

    }

    public void setWord(Word word) {
        this.word = word;
        crearCamposTextoPalabraSecreta(); // Crea los TextFields al asignar la palabra

    }

    private void showInvalidHelps() {
        alertBox.showMessage(
                "¡Error!",
                "No te quedan mas ayudas",
                "Ya gastaste todas tus ayudas disponibles."
        );
    }

    private void showInvalidLetter() {
        alertBox.showMessage(
                "¡Error!",
                "Caractér incorrecto",
                "Debes insertar un caractér válido."
        );
    }

    private void showInvalidWord() {
        alertBox.showMessage(
                "¡Error!",
                "Error",
                "Debes insertar solo una letra."
        );
    }
    private void showLoseGame() {
        alertBox.showMessage(
                "¡Perdiste!",
                "Perdiste",
                "Ya no te quedan mas intentos, juego terminado!"
        );
    }


    private void actualizarImagen() {
        if (fallos < IMAGENES.length) {
            String imagePath = IMAGENES[fallos];
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            imageAhorcado.setImage(image);
        } else {
            showLoseGame();
            buttonAttemp.setDisable(true);
        }
    }

}