package Teoria.Colas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ejercicio4 {
    static Scanner teclado = new Scanner(System.in);
    static LinkedList<String> listaCompra = new LinkedList<>();
    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu(){
        System.out.println("*** Lista de la compra ***");
        System.out.println("1. Añadir producto al final");
        System.out.println("2. Eliminar primer producto");
        System.out.println("3. Eliminar producto por nombre");
        System.out.println("4. Ver primer producto");
        System.out.println("5. Buscar producto");
        System.out.println("6. Mostrar lista actual");
        System.out.println("X. Salir");

        System.out.print("\nSelecciona una opción: ");
        String opcion = teclado.next().toLowerCase();
        System.out.println("========================");

        menu(opcion);
    }

    public static void menu(String opcion){
        switch (opcion){
            case "1":
                System.out.print("Producto a añadir: ");
                String producto = teclado.next();
                listaCompra.offerLast(producto);
                System.out.println("> Producto '" + listaCompra.peekLast() + "' añadido.");
                System.out.println();
                mostrarMenu();
                break;
            case "2":
                System.out.print("Eliminando producto '" + listaCompra.peekFirst() + "'...");
                listaCompra.pollFirst();
                System.out.println();
                mostrarMenu();
                break;
            case "3":
                System.out.print("Producto a eliminar " + listaCompra + ": ");
                String productoAEliminar = teclado.next();
                if (listaCompra.contains(productoAEliminar)){
                    listaCompra.remove(productoAEliminar);
                }
                System.out.println();
                mostrarMenu();
                break;
            case "4":
                System.out.println("Primer producto: " + listaCompra.peekFirst());
                System.out.println();
                mostrarMenu();
                break;
            case "5":
                System.out.print("Introduce producto a buscar: ");
                String elementoBuscar = teclado.next();
                if (listaCompra.contains(elementoBuscar)){
                    System.out.println("'" + elementoBuscar + "' ha sido encontrado en la lista.");
                } else {
                    System.out.println("'" + elementoBuscar + "' NO ha sido encontrado en la lista.");
                }
                System.out.println();
                mostrarMenu();
                break;
            case "6":
                System.out.println("Lista de compra actual");
                for (int i = 0; i < listaCompra.size(); i++) {
                    System.out.println(i + ". " + listaCompra.get(i));
                }
                System.out.println();
                mostrarMenu();
                break;
            case "X":
            case "x":
                System.out.println("Saliendo...");
                break;
        }
    }
}
