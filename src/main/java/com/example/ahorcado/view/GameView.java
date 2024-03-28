package com.example.ahorcado.view;

import com.example.ahorcado.controller.GameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GameView extends Stage {
    private GameController gameController;

    public GameView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ahorcado/game-view.fxml"));
        Parent root = loader.load();
        gameController = loader.getController();
        Scene scene = new Scene(root);
        setTitle("Juego del Ahorcado");
        getIcons().add(
                new Image(
                        String.valueOf(getClass().getResource("/com/example/ahorcado/images/favicon.png"))));
        setResizable(false);
        setScene(scene);
        show();
    }

    public GameController getGameController(){
        return gameController;
    }

    public static GameView getInstance() throws IOException{
        return GameViewHolder.INSTANCE = new GameView();
    }

    public static void deleteInstance() {
        GameViewHolder.INSTANCE.close();
        GameViewHolder.INSTANCE = null;
    }

    private static class GameViewHolder {
        private static GameView INSTANCE;
    }
}

