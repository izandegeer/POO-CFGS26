package org.example.Ejercicios.PartidoTenis;

public class Jugador {
    private String nombre;
    private int ranking;
    private Jugador rival;

    public Jugador(String nombre, int ranking) {
        this.nombre = nombre;
        this.ranking = ranking;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public Jugador getRival() {
        return rival;
    }

    public void setRival(Jugador rival) {
        this.rival = rival;
    }
}
