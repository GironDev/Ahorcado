package com.example.ahorcado.controller;

import com.example.ahorcado.model.Word;
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

    private int remainingHelp = 3;

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
        int intentos = 6;
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
            // System.out.println("PALABRA LARGA");
        } else if (!choiceWord.matches("[a-zA-Z]+")) {
            // System.out.println("No es un caracter válido");
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

}