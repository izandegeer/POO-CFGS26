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
    private static final int MIN_IMC = 20;
    private static final int MAX_IMC = 25;

    public static final int INFRAPESO = -1;
    public static final int PESO_IDEAL = 0;
    public static final int SOBREPESO = 1;

    public Paciente(String nombre, int edad, char sexo, double peso, int altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = comprobarSexo(sexo);
        this.peso = peso;
        this.altura = altura;
        this.dni = generarDNI();
    }

    public Paciente(String nombre, int edad, char sexo) {
        this(nombre, edad, sexo, 0, 0);
    }

    public Paciente() {
        this("", 0, DEF_SEXO, 0, 0);
    }

    private String generarDNI() {
        int dniNum = random.nextInt(99999999)+1;
        int resto = dniNum % 23;

        char letras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y',
                'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
                'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        return String.valueOf(dniNum) + letras[resto];
    }

    public int calcularIMC() {
        double alturaMetros = this.altura / 100.0;
        double imc = this.peso / Math.pow(alturaMetros, 2);

        if (imc < MIN_IMC) {
            return INFRAPESO;
        } else if (imc >= MIN_IMC && imc <= MAX_IMC) {
            return PESO_IDEAL;
        } else {
            return SOBREPESO;
        }
    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    private char comprobarSexo(char sexo) {
        if (sexo != 'H' && sexo != 'M') {
            return DEF_SEXO;
        }
        return sexo;
    }

    public void mostrarInfoPaciente() {
        int imcResultado = calcularIMC();
        System.out.println("*** INFO PACIENTE ***");
        System.out.println("---------------------");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Edad: " + this.edad);
        System.out.println("DNI: " + this.dni);
        System.out.println("Sexo: " + this.sexo);
        System.out.println("Peso: " + this.peso);
        System.out.println("Altura: " + this.altura);
        
        String estadoPeso = "";
        switch (imcResultado) {
            case INFRAPESO: estadoPeso = "Por debajo del peso ideal"; break;
            case PESO_IDEAL: estadoPeso = "Peso ideal"; break;
            case SOBREPESO: estadoPeso = "Sobrepeso"; break;
        }
        System.out.println("IMC: " + estadoPeso);
        System.out.println("Es mayor de edad: " + (esMayorDeEdad() ? "Sí" : "No"));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = comprobarSexo(sexo);
    }

    public String getDni() {
        return dni;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}