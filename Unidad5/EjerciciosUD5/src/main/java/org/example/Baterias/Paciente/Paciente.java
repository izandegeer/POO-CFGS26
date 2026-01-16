package org.example.Baterias.Paciente;

import java.util.Random;
import java.util.Scanner;

public class Paciente {
    private static Random random = new Random();
    private static Scanner teclado = new Scanner(System.in);

    private String nombre;
    private int edad;
    private char sexo;
    private String dni;
    private double peso;
    private int altura;

    private static final char DEF_SEXO = 'X';

    public Paciente(String nombre, int edad, char sexo, String dni, double peso, int altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public Paciente() {
        this(null, 0, DEF_SEXO, null, 0, 0);
    }

    public String generarDNI() {

        String dni = "";

        for (int i = 0; i < 8; i++) {
            int numero = random.nextInt(10);
            dni = dni + Integer.toString(numero);
        }

        return dni;
    }
}
