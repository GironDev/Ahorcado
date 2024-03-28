module com.example.ahorcado {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ahorcado to javafx.fxml;
    opens com.example.ahorcado.controller to javafx.fxml;

    exports com.example.ahorcado;
}