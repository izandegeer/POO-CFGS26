package Practica2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EstudiantesGuardados {
    private static ObservableList<Estudiante> listaEstudiantes = FXCollections.observableArrayList();

    public static void insertarEstudiante(Estudiante estudiante) {
        listaEstudiantes.add(estudiante);
    }

    public static ObservableList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }
}
