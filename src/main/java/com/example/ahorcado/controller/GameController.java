package com.example.ahorcado.controller;

import com.example.ahorcado.model.Word;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
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
    private HBox hBoxLayout;
    @FXML
    private TextField TextFieldCreated;

    @FXML
    private TextField afterCreatedFields;
//    @FXML
//    private TextField wordTxt;

    @FXML

    private ArrayList<TextField> test = new ArrayList<>();


    public void crearCamposTextoPalabraSecreta() {
        String secretWord = word.getWordSecret();

        for (int i = 0; i < secretWord.length(); i++) {
            TextField wordTxt = new TextField();
            wordTxt.setId(String.valueOf(i));
//            TextField afterCreatedFields = new TextField();
            TextFieldCreated = wordTxt;
            wordTxt.setPrefWidth(40);
            hBoxLayout.getChildren().add(wordTxt);
//            System.out.println("added camp " + i);
//            System.out.println(wordTxt.getId());
            //manejarPulsacionTecla(wordTxt, i);
            test.add(TextFieldCreated);
        }
    }


    public void verifyWord(Word word) {
        String receivedWord = word.getWordSecret();
        String[] strippedWord = receivedWord.split("");
        ArrayList<String> wordList = new ArrayList<String>();
//        System.out.println("STRIPPED WORD : ");
        for (int i = 0; i < strippedWord.length; i++) {
            wordList.add(strippedWord[i]);
//            System.out.println(wordList.add(strippedWord[i]));
//            System.out.println("Letra del Array:");
//            System.out.println(wordList.get(i));
        }
//        System.out.println(wordList);
//        System.out.println(wordList);
//        "For" curioso qué funciona
//        for (String a : strippedWord){
//            System.out.println(a);
//        }
//        for (Node node : hBoxLayout.getChildren()) {
//            System.out.println(node);
//        }
        for (int i = 0; i < receivedWord.length(); i++) {
//            String boxLetter = String.valueOf(TextFieldCreated.getText());
//            System.out.println(boxLetter);
//            System.out.printf("Letter: " + boxLetter);
//            System.out.println(test);
//            System.out.println(hBoxLayout.getChildren().get(i));
//            System.out.println("FUNCTION getTexts:");
            ObservableList<Node> childs = hBoxLayout.getChildren();
            TextField tf  = (TextField) childs.get(i);
//            System.out.println("Text From Fields");
//            System.out.println(tf.getText());
//            System.out.println(wordList.get(i));
//            getTexts();
            String textOnField = tf.getText();
            String textReceived = wordList.get(i);
            if (textReceived.equalsIgnoreCase(textOnField)) {
                /**
                 *
                 * Only for Debug Purposes
                 * @iMrSteven was here ;)
                 * */
                System.out.println("Una letra encaja!");
                /**
                 * End Debug
                 * */

                tf.setDisable(true);
            } else {
                /**
                 *
                 * Only for Deving Purposes
                 *
                * */
//                System.out.println(textOnField.compareTo(textReceived));
//                System.out.println(textReceived + " Es Diferente de: " + textOnField + " ???");
                /**
                 * End Debug
                 * */
                System.out.println("Una letra no encajó!");


            }

        }



    }

    @FXML
    void onHandlerButtonHelp(ActionEvent event) {
        System.out.println(word.getWordSecret());
        System.out.println("HELLO HELP!");

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