package org.example.demofx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button pruebaClickButton;
    @FXML
    private Label contadorLabel;
    static Contador contador = new Contador();

    @FXML
    public void initialize() {
        pruebaClickButton.setOnAction(e -> {
            contador.contar();
            contadorLabel.setText(Integer.toString(contador.getContador()) + "º Gol del atleti");
        });
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("¡Holaaaa!");
    }

    public void resetClickButton() {

        contador.setContador(0);
        contadorLabel.setText("Contador reseteado a 0");

    }

}
