package com.example.ahorcado;

import com.example.ahorcado.view.WelcomeView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        WelcomeView.getInstance();
    }
}
