package Teoria.Conjuntos;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("AGENDA");
        System.out.println("--------------------");
        System.out.println("1. Añadir contacto");
        System.out.println("2. Mostrar contactos");
        System.out.println("3. Buscar contacto");
        System.out.println("4. Eliminar contacto");
        System.out.println("X. Salir");

        System.out.print("Elige una opción: ");
        char opcion = teclado.next().charAt(0);
        System.out.println("--------------------");

        switch (opcion){
            case '1':
                System.out.print("Nombre del nuevo contacto: ");
                String nuevoContacto = teclado.next();
                System.out.println(nuevoContacto);
                break;
            case '2':
                break;
            case '3':
                break;
            case '4':
                break;
            case 'X':
                System.out.println("Saliendo...");
                break;
        }
    }
}
