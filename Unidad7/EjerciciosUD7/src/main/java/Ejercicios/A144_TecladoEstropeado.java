package Ejercicios;

import java.util.ArrayList;
import java.util.ListIterator;

// Asume fichero llamado solution.java
public class A144_TecladoEstropeado {

    static java.util.Scanner teclado;

    public static boolean casoDePrueba() {
        if (!teclado.hasNext())
            return false;
        else {
            // CÓDIGO PRINCIPAL AQUÍ
            // (-) Tecla Inicio, y el cursor se le va al principio de la línea
            // (+) Se lleva el cursor al final igual que la tecla Fin.
            // (*) Se consigue el mismo efecto que con la tecla de la flecha derecha.
            // (3) Hace lo mismo que la tecla Supr, que borra la letra que hay a la derecha del cursor

            String palabra = teclado.nextLine();

            ArrayList<Character> lista = new ArrayList<>();
            ListIterator<Character> it = lista.listIterator();

            for (Character character : palabra.toCharArray()) {
                switch (character) {
                    case '-':
                        if (it.hasPrevious()){
                            while (it.hasPrevious()) {
                                it.previous();
                            }
                            break;
                        }
                        break;
                    case '+':
                        if (it.hasNext()) {
                            while (it.hasNext()) {
                                it.next();
                            }
                        }
                        break;
                    case '*':
                        if (it.hasNext()) {
                            it.next();
                        }
                        break;
                    case '3':
                        if (it.hasNext()) {
                            it.next();
                            it.remove();
                        }
                        break;
                    default:
                        it.add(character);
                }
            }

            for (Character character1 : lista){
                System.out.print(character1);
            }
            System.out.println();
            // (incluyendo la lectura del caso de prueba)
            return true;
        }
    } // casoDePrueba

    public static void main(String[] args) {
        teclado = new java.util.Scanner(System.in);
        while (casoDePrueba()) {
        }
    } // main

} // class solution
