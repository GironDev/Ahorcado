
package com.example.ahorcado.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeView extends Stage {
    public WelcomeView () throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource( "/com/example/ahorcado/welcome-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        setTitle("Juego del Ahorcado");
        getIcons().add(
                new Image(
                        String.valueOf(getClass().getResource("/com/example/ahorcado/images/favicon.png"))));
        setResizable(false);
        setScene(scene);
        show();
    }

    public static WelcomeView getInstance() throws IOException{
        return WelcomeViewHolder.INSTANCE = new WelcomeView();
    }

    public static void deleteInstance() {
        WelcomeViewHolder.INSTANCE.close();
        WelcomeViewHolder.INSTANCE = null;
    }

    private static class WelcomeViewHolder {
        private static WelcomeView INSTANCE;
    }
}
