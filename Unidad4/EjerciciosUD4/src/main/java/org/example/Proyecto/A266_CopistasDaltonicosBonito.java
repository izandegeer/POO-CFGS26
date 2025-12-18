package org.example.Proyecto;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Programa "Copistas Daltónicos
 * <p>
 *     Este ejercicio es como el juego del teléfono, pero con una imagen de colores.
 *     Imagina que una foto (hecha con caracteres de colores) pasa de mano en mano.
 *     Cada persona que copia tiene un tipo de daltonismo, y al copiarla, cambia los colores que confunde por los colores que sí ve.
 *     Como cada copia es la "original" para el siguiente, el color se va alterando a cada paso.
 *     El desafío es saber cómo queda la imagen al final después de todos estos cambios sucesivos.
 * </p>
 */

public class A266_CopistasDaltonicosBonito {

    /** Scanner para leer datos desde el teclado */
    static Scanner teclado = new Scanner(System.in);

    /**
     * Metodo principal que inicia el programa, mostrando el título y solicita los datos al usuario.
     *
     * @param args
     */
    public static void main(String[] args) {
        MostrarTitulo();
        IntroducirDatos();
    }

    /**
     * Muestra el título del programa
     */
    public static void MostrarTitulo() {
        System.out.println("===================================");
        System.out.println("******* COPISTAS DALTÓNICOS *******");
        System.out.println("===================================");
    }

    /**
     * Muestra un separador para el fin de cada metodo
     */
    public static void Separador() {
        System.out.println("-----------------------------------");
    }

    /**
     * Se solicita el número de filas y columnas para determinar el tamaño del cuadrado
     * Luego, llama a los métodos aplicarCopistas y Mostrar resultado para seguir el programa
     */
    public static void IntroducirDatos() {
        System.out.print("> Introduzca el nº de filas: ");

        int filas;
        try {
            filas = teclado.nextInt();
        } catch (InputMismatchException e) {
            System.out.print("X ERROR. Solo puede introducir números.");
            return;
        }

        System.out.print("> Introduzca el nº de columnas: ");
        int columnas;
        try {
            columnas = teclado.nextInt();
        } catch (InputMismatchException e) {
            System.out.print("X ERROR. Solo puede introducir números.");
            return;
        }

        teclado.nextLine();

        if (filas == 0 && columnas == 0) {
            return;
        }

        String[] cuadro = LeerCuadro(filas, columnas);
        aplicarCopistas(cuadro);
        mostrarResultado(cuadro);
    }

    /**
     * Metodo para leer fila por fila del cuadro
     *
     * @param filas Alto del cuadro
     * @param columnas Ancho del cuadro
     * @return Devuelve cada fila del cuadro
     */
    public static String[] LeerCuadro(int filas, int columnas) {
        Separador();
        String[] cuadro = new String[filas];

        for (int i = 0; i < filas; i++) {
            boolean filaValida = false;

            while (!filaValida) {
                System.out.print("Introduce los colores de la Fila " + (i + 1) + ": ");
                String fila = teclado.nextLine().toUpperCase();

                if (fila.length() != columnas) {
                    System.out.println("X ERROR. Debe tener " + columnas + " columnas.");
                } else {
                    cuadro[i] = fila;
                    filaValida = true;
                }
            }
        }
        return cuadro;
    }

    /**
     * Aplica los cambios de color según el tipo de daltonismo de cada copista
     *
     * @param cuadro Representa el cuadro
     */
    public static void aplicarCopistas(String[] cuadro) {
        Separador();

        System.out.print("> Número de copistas daltónicos: ");

        int numCopistas = 0;
        try {
            numCopistas = teclado.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("X ERROR. Solo puede introducir números.");
            return;
        }

        teclado.nextLine();


        for (int i = 0; i < numCopistas; i++) {
            boolean colorValido = false;

            while (!colorValido) {
                System.out.print("> Introduzca los cambios de letra del copista " + (i + 1) + " [Formato: X Y]: ");
                String linea = teclado.nextLine().toUpperCase().trim();

                if (linea.length() != 3 || linea.charAt(1) != ' ') {
                    System.out.println("X ERROR. Introduzca el cambio de letra de la siguiente manera: X (Color Original) Y (Color Alterado)");
                    continue;
                }

                char colorOriginal = linea.charAt(0);
                char colorDaltonico = linea.charAt(2);

                for (int j = 0; j < cuadro.length; j++) {
                    cuadro[j] = cuadro[j].replace(colorOriginal, colorDaltonico);
                }

                colorValido = true;
            }

        }
    }

    /**
     *  Muestra el resultado final del cuadro
     *
     * @param cuadro Representa el cuadro
     */
    public static void mostrarResultado(String[] cuadro) {
        Separador();
        System.out.println("Resultado final del cuadro: ");

        for (String fila : cuadro) {
            System.out.println(fila);
        }
    }
}