package com.example.ahorcado.view.alert;

import javafx.scene.control.Alert;

public class AlertBox implements lAlertBox{
    @Override
    public void showMessage(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
