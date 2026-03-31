package Teoria.Lambdas.Ejercicios.EjTeoria2B;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Persona {

    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}

class Main {
    public static void main(String[] args) {

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Juan", 16));
        personas.add(new Persona("Ana", 18));
        personas.add(new Persona("Pedro", 25));
        personas.add(new Persona("María", 17));
        personas.add(new Persona("Luis", 30));

        VerificadorVotoPersona verificador = persona -> persona.getEdad() >= 18;

        List<String> personasQuePuedenVotar = new ArrayList<>();

        for (Persona persona : personas) {
            if (verificador.puedeVotar(persona)) {
                personasQuePuedenVotar.add(persona.getNombre());
            }
        }

        // imprimir los nombres de las personas que pueden votar
        System.out.println("Personas que pueden votar:");
        for (String nombre : personasQuePuedenVotar) {
            System.out.println(nombre); // Ana, Pedro, Luis
        }
    }
}
