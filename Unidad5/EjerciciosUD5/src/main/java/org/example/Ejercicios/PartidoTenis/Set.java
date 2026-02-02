package org.example.Ejercicios.PartidoTenis;

public class Set {
    private int puntosJ1;
    private int puntosJ2;

    public Set(int puntosJ1, int puntosJ2) {
        if (puntosJ1 >= 0 && puntosJ2 >= 0 && puntosJ1 <= 6 && puntosJ2 <= 6) {
            this.puntosJ1 = puntosJ1;
            this.puntosJ2 = puntosJ2;
        } else if (puntosJ1 == 7 && puntosJ2 == 5 || puntosJ1 == 7 && puntosJ2 == 6 || puntosJ2 == 7 && puntosJ1 == 5 || puntosJ2 == 7 && puntosJ1 == 6) {
            this.puntosJ1 = puntosJ1;
            this.puntosJ2 = puntosJ2;
        } else {
            System.out.println("ERROR. Puntuaciones no válidas.");
        }
    }

    public int getPuntosJ1() {
        return puntosJ1;
    }

    public void setPuntosJ1(int puntosJ1) {
        this.puntosJ1 = puntosJ1;
    }

    public int getPuntosJ2() {
        return puntosJ2;
    }

    public void setPuntosJ2(int puntosJ2) {
        this.puntosJ2 = puntosJ2;
    }

    @Override
    public String toString() {
        return "Set{" +
                "puntosJ1=" + puntosJ1 +
                ", puntosJ2=" + puntosJ2 +
                '}';
    }
}
