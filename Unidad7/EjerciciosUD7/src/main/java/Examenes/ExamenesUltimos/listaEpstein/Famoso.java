package Examenes.ExamenesUltimos.listaEpstein;

import java.util.Objects;

public class Famoso {
    private String nombre;
    private String pais;
    private String profesion;
    private int edad;

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

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Famoso(String nombre, String pais, String profesion, int edad) {
        this.nombre = nombre;
        this.pais = pais;
        this.profesion = profesion;
        this.edad = edad;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Famoso otro = (Famoso) obj;
        return edad == otro.edad
                && nombre.equals(otro.nombre)
                && pais.equals(otro.pais)
                && profesion.equals(otro.profesion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, pais, profesion, edad);
    }

    @Override
    public String toString() {
        return "Famoso{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", profesion='" + profesion + '\'' +
                ", edad=" + edad +
                '}';
    }
}
