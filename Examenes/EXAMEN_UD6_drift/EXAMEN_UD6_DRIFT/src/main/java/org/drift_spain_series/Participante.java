package org.drift_spain_series;

public abstract class Participante {
    private String nombre;
    private String pais;

    public Participante(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public Participante() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
