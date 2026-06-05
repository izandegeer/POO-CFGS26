package org.drift_spain_series;

import java.util.Arrays;
import java.util.Scanner;

public class Piloto extends Participante {
    private String marca;
    private estadoCoche estado;
    private int puntuacion;

    public Piloto(String nombre, String pais, String marca, estadoCoche estado, int puntuacion) {
        super(nombre, pais);
        this.marca = marca;
        this.estado = estado;
        this.puntuacion = puntuacion;
    }

    public Piloto(String marca) {
        System.out.println("==============================================================");
        Scanner teclado = new Scanner(System.in);
        this.marca = marca;

        System.out.println("Inscribiendo participante...");

        System.out.print("Nombre: ");
        setNombre(teclado.next());

        System.out.print("País: ");
        setPais(teclado.next());

        System.out.println("Piloto " + getNombre() + " de la marca " + getMarca() + " creado.");
    }

    public Inscripcion inscribirse() {
        System.out.println("==============================================================");
        Scanner teclado = new Scanner(System.in);

        System.out.println("Piloto " + getNombre() + " realizando inscripción...");
        System.out.print("Elige una categoría: " + Arrays.toString(categoriaDRIFT.values()) + ": ");
        String categoria = "";

        try {
            categoria = String.valueOf(categoriaDRIFT.valueOf(teclado.next().toUpperCase()));
        } catch (IllegalArgumentException e) {
            System.out.println("Categoría incorrecta. Elige una existente.");
            return null;
        }
        System.out.println("Piloto " + getNombre() + " inscrito en " + categoriaDRIFT.valueOf(categoria));
        return null; // No debe retornar null)?
    }

    // Falta pago
    public void pagarInscripcion(Inscripcion inscripcion) {
        if (inscripcion != null){
            System.out.println("Piloto " + getNombre() + " pagando por la categoria " + inscripcion.getCategoria());
        } else {
            System.out.println("x Ha ocurrido un error. Inscripcion es null");
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public estadoCoche getEstado() {
        return estado;
    }

    public void setEstado(estadoCoche estado) {
        this.estado = estado;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}
