package org.example.Baterias.Paciente.Clase;

import java.util.Random;

public class Paciente {

    private Random aleatorio = new Random();
    private static final char DEF_SEXO = 'X';
    private static final int INFRAPESO = -1;
    private static final int PESO_IDEAL = 0;
    private static final int SOBREPESO = 1;
    private static final int MAYOR_EDAD = 18;

    private String nombre;
    private int edad;
    private String dni;
    private char sexo;
    private double peso;
    private int altura;

    public Paciente (String nombre, int edad, char sexo, double peso, int altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = generarDNI();
        this.sexo = comprobarSexo(sexo);
        this.peso = peso;
        this.altura = altura;
    }

    public Paciente (){
        this(null,0,DEF_SEXO,0,0);
    }

    private String generarDNI(){

        String dni = "";

        char letras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y',
                'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
                'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        for (int i = 0; i < 8; i++) {
            int num = aleatorio.nextInt(10);
            dni = dni + num;
        }

        return dni + (letras[Integer.parseInt(dni)%23]);

    }

    public int calcularIMC (){

        double resultado = peso / Math.pow(((double) altura/100),2);

        System.out.println(resultado);

        if (resultado < 20){
            return INFRAPESO;
        } else if (resultado > 25) {
            return SOBREPESO;
        }else{
            return PESO_IDEAL;
        }

    }

    public boolean esMayorDeEdad (){

        if (edad >= 18){
            return true;
        }else{
            return false;
        }
    }

    private char comprobarSexo(char sexo){

        if (sexo == 'H' || sexo == 'M'){
            return sexo;
        }else{
            return DEF_SEXO;
        }

    }

    public Random getAleatorio() {
        return aleatorio;
    }

    public void setAleatorio(Random aleatorio) {
        this.aleatorio = aleatorio;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public char getSexo() {
        return sexo;
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

    @Override // Sobreescribe a la madre
    public String toString() {
        return "Paciente [Nombre: " + nombre + ", Edad: " + edad + " años, DNI: " + dni + ", Sexo: " + sexo + ", Peso: " + peso + "kg, Altura: " + altura + "cm]";
    }
}