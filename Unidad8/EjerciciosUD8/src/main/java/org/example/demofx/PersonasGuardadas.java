package org.example.demofx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PersonasGuardadas {
    private static ObservableList<Persona> listaPersonas = FXCollections.observableArrayList();

    public static void insertarPersona(Persona persona) {
        listaPersonas.add(persona);
    }

    public static ObservableList<Persona> getListaPersonas() {
        return listaPersonas;
    }
}
