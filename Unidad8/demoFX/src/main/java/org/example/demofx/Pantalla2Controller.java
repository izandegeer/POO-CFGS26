package org.example.demofx;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;

public class Pantalla2Controller {
    @FXML
    private TextField niaTextField;
    @FXML
    private TextField nombreTextField;
    @FXML
    private DatePicker fechaNacimientoDatePicker;
    @FXML
    private TableView<Persona> personasTableView;
    @FXML
    private TableColumn<Persona, String> niaTableColumn;
    @FXML
    private TableColumn<Persona, String> nombreTableColumn;
    @FXML
    private TableColumn<Persona, LocalDate> fechaNacimientoTableColumn;

    public void anteriorButton() throws IOException {
        HelloApplication.setRoot("hello-view");
    }

    public void guardarButton() {
        String nia = niaTextField.getText();
        String nombre = nombreTextField.getText();
        LocalDate fechaNacimiento = fechaNacimientoDatePicker.getValue();

        Persona persona = new Persona(nia, nombre, fechaNacimiento);
        PersonasGuardadas.insertarPersona(persona);
        System.out.println("Persona creada: " + persona);
        System.out.println(PersonasGuardadas.getListaPersonas());
        niaTextField.clear();
        nombreTextField.clear();
        fechaNacimientoDatePicker.setValue(null);
    }

    @FXML
    public void initialize() {
        niaTableColumn.setCellValueFactory(datos -> new SimpleStringProperty(datos.getValue().getNia()));
        nombreTableColumn.setCellValueFactory(datos -> new SimpleStringProperty(datos.getValue().getNombre()));
        fechaNacimientoTableColumn.setCellValueFactory(datos -> new SimpleObjectProperty<>(datos.getValue().getFechaNacimiento()));
        personasTableView.setItems(PersonasGuardadas.getListaPersonas());
    }
}
