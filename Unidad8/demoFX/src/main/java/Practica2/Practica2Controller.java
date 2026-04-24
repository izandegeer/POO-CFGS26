package Practica2;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class Practica2Controller {
    public Button eliminarButton;
    @FXML
    private TextField niaTextField;
    @FXML
    private TextField nombreTextField;
    @FXML
    private DatePicker fechaNacimientoDatePicker;
    @FXML
    private TableView<Estudiante> personasTableView;
    @FXML
    private TableColumn<Estudiante, Integer> niaTableColumn;
    @FXML
    private TableColumn<Estudiante, String> nombreTableColumn;
    @FXML
    private TableColumn<Estudiante, LocalDate> fechaNacimientoTableColumn;

    @FXML
    public void initialize() {
        niaTableColumn.setCellValueFactory(datos -> new SimpleIntegerProperty(datos.getValue().getNia()).asObject());
        nombreTableColumn.setCellValueFactory(datos -> new SimpleStringProperty(datos.getValue().getNombre()));
        fechaNacimientoTableColumn.setCellValueFactory(datos -> new ReadOnlyObjectWrapper<>(datos.getValue().getFecha_nacimiento()));

        personasTableView.setItems(EstudiantesGuardados.getListaEstudiantes());
    }

    public void modificarButton() {
        Estudiante seleccionada = personasTableView.getSelectionModel().getSelectedItem();
        if (seleccionada == null) {
            new Alert(Alert.AlertType.WARNING, "Selecciona una persona de la tabla para modificarla.").showAndWait();
            return;
        }

        seleccionada.setNia(Integer.parseInt(niaTextField.getText()));
        seleccionada.setNombre(nombreTextField.getText());
        seleccionada.setFecha_nacimiento(fechaNacimientoDatePicker.getValue());

        personasTableView.refresh();
        niaTextField.clear();
        nombreTextField.clear();
        fechaNacimientoDatePicker.setValue(null);
    }

    public void editarButton(ActionEvent actionEvent) {
    }

    public void eliminarButton(ActionEvent actionEvent) {
    }

    public void GuardarButton(ActionEvent actionEvent) {
        Integer nia = Integer.parseInt(niaTextField.getText());
        String nombre = nombreTextField.getText();
        LocalDate fechaNacimiento = fechaNacimientoDatePicker.getValue();

        Estudiante estudiante = new Estudiante(nia, nombre, fechaNacimiento);
        EstudiantesGuardados.insertarEstudiante(estudiante);
        niaTextField.clear();
        nombreTextField.clear();
        fechaNacimientoDatePicker.setValue(null);
    }
}
