package org.example;

import java.util.Scanner;

public class ExamenUD1 {
    public static void Leysin() { // Metodo para el ejercicio {
        Scanner teclado = new Scanner(System.in);

        int edad = 0;

        try { // Pedimos la edad del comprador
            System.out.println("> Introduce la edad del comprador: ");
            edad = teclado.nextInt();
        } catch (Exception e) { // En caso de formato incorrecto, por ejemplo "paco", salta la excepción
            System.err.println("El formato introducido no es correcto.");
            return;
        }

        if (edad >= 21) { // Si tiene 21 años o mas
            System.out.println("> TODO TIPO DE ALCOHOL");
        } else if (edad >= 18) { // Si tiene menos de 21 años pero 18 o mas
            System.out.println("> SOLO FERMENTADAS (Cervezas y vinos)");
        } else { // Si es menor de 18 años
            System.out.println("> CONSUMO NO PERMITIDO.");
        }
    }
    public static void Delegados() { // Metodo para el ejercicio 2
        Scanner teclado = new Scanner(System.in);

        int alumnos = 25; // Cantidad de alumnos que tiene la clase

        System.out.print("Introduce el nombre del candidato 1: "); // Pedimos el nombre del candidato 1
        String candidato1 = teclado.nextLine();

        int votos1 = 0;
        try { // Pedimos los votos para candidato 1
            System.out.print("Votos para " + candidato1 + ": ");
            votos1 = teclado.nextInt();
        } catch (Exception e) { // En caso de formato incorrecto, por ejemplo "paco", salta la excepción
            System.err.println("El formato introducido no es correcto.");
            return;
        }

        System.out.print("Introduce el nombre del candidato 2: "); // Pedimos el nombre del candidato 2
        String candidato2 = teclado.next();

        int votos2 = 0;
        try { // Pedimos los votos para candidato 2
            System.out.print("Votos para " + candidato2 + ": ");
            votos2 = teclado.nextInt();
        } catch (Exception e) { // En caso de formato incorrecto, por ejemplo "paco", salta la excepción
            System.err.println("El formato introducido no es correcto.");
            return;
        }

        System.out.println("-------------------------");

        int suma = votos1 + votos2; // Calculamos los votos totales
        System.out.println("RESULTADOS:");
        System.out.println("Total de votos: " + suma);

        if (suma > alumnos) { // Si la suma de los votos es mayor a los alumnos (25) da error
            System.err.println("ERROR. No pueden votar más personas (" + suma + ") que estudiantes tiene la clase: " + alumnos);
        } else if (votos1 == votos2) { // Si son iguales, se pide repetir la votación
            System.err.println("REPETIR VOTACiÓN");
        }  else if (suma < alumnos || suma == alumnos) { // En caso de que la suma sea menor o igual a los alumnos (25) se calcula el delegado
            int votosBlanco = alumnos - suma;
            System.out.println("Votos en blanco: " + votosBlanco);

            if (votos1 > votos2) {
                System.out.println("Delegado: " + candidato1);
            } else {
                System.out.println("Delegado: " + candidato2);
            }
        }
    }
}
