package teoria.Enum;

import java.util.Scanner;

public class Metodos {
    public static void main(String[] args) {
        Metodo opcion = Metodo.PAYPAL;
        System.out.println(opcion);

        Scanner teclado = new Scanner(System.in);

        System.out.println("Valores enum:");
        for (Metodo metodo : Metodo.values()){
            System.out.print("-");
            System.out.println(metodo);
        }

        System.out.println(opcion.ordinal()); // Imprime la posición
        System.out.println(opcion.name()); // Imprime el nombre

        System.out.println("Comisión para el método " + opcion + ": " + opcion.getComision());

        System.out.print("Elige un método de pago: ");
        Metodo opcion2 = Metodo.valueOf(teclado.next().toUpperCase());
        System.out.println("Método elegido: " + opcion2);


    }
}
