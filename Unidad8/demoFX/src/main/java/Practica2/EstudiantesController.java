package Practica2;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.time.LocalDate;

public class EstudiantesController {
    static Connection db;

    public TableView<Estudiante> estudianteTableView;
    public TableColumn<Estudiante, Integer> niaTableColum;
    public TableColumn<Estudiante, String> nombreTableColum;
    public TableColumn<Estudiante, LocalDate> fechaTableColum;
    public Label mensajeLabel;
    public TextField niaTextField;
    public TextField nombreTextField;
    public DatePicker fechaDatePicker;
    public Button insertarButton;
    public Button guardarButton;

    @FXML
    public void initialize(){

        db = DatosEstudiantes.conexion();

        niaTableColum.setCellValueFactory(datos -> new SimpleIntegerProperty(datos.getValue().getNia()).asObject());
        nombreTableColum.setCellValueFactory(datos -> new SimpleStringProperty(datos.getValue().getNombre()));
        fechaTableColum.setCellValueFactory(datos-> new ReadOnlyObjectWrapper<>(datos.getValue().getFecha_nacimiento()));

       estudianteTableView.setItems(DatosEstudiantes.consulta(db));

       guardarButton.setDisable(true);
    }

    public void editarButton() {
        Estudiante seleccionado = estudianteTableView.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            niaTextField.setText(String.valueOf(seleccionado.getNia()));
            nombreTextField.setText(seleccionado.getNombre());
            fechaDatePicker.setValue(seleccionado.getFecha_nacimiento());

            insertarButton.setDisable(true);
            guardarButton.setDisable(false);
        }else{
            System.out.println("No hay ninguna fila seleccionada.");
        }
    }

    public void eliminarButton() {
        Estudiante seleccionado = estudianteTableView.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            DatosEstudiantes.borrar(db,seleccionado);
            estudianteTableView.setItems(DatosEstudiantes.consulta(db));
        }else{
            System.out.println("No hay ninguna fila seleccionada.");
        }
    }

    public void insertarButton() {
        Integer nia = Integer.parseInt(niaTextField.getText());
        String nombre = nombreTextField.getText();
        LocalDate fecha = fechaDatePicker.getValue();
        DatosEstudiantes.insertar(db, new Estudiante(nia, nombre, fecha));
        estudianteTableView.setItems(DatosEstudiantes.consulta(db));
        mensajeLabel.setText("Estudiante insertado.");
        niaTextField.clear();
        nombreTextField.clear();
        fechaDatePicker.setValue(null);
    }

    public void guardarButton() {
        Integer nia = Integer.parseInt(niaTextField.getText());
        String nombre = nombreTextField.getText();
        LocalDate fecha = fechaDatePicker.getValue();
        DatosEstudiantes.guardar(db, new Estudiante(nia, nombre, fecha));
        estudianteTableView.setItems(DatosEstudiantes.consulta(db));
        insertarButton.setDisable(false);
        guardarButton.setDisable(true);
        mensajeLabel.setText("Estudiante modificado.");
        niaTextField.clear();
        nombreTextField.clear();
        fechaDatePicker.setValue(null);
    }
}
