package practicas.Ecommerce;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase que representa el metodo de pago Bizum.
 * Valida el telefono y un PIN generado aleatoriamente.
 */
public class Bizum extends MetodoPago {
    private static Scanner teclado = new Scanner(System.in);
    private Random random = new Random();
    @Getter
    @Setter
    private String telefono;
    @Getter
    @Setter
    private int pin = random.nextInt(900000) + 100000;
    private int pinUsuario;

    /**
     * Pide al usuario que introduzca los datos de Bizum por consola.
     */
    public void rellenarDatosBizum() {
        System.out.println("\nBIZUM");
        System.out.println("-----");

        System.out.print("Introduzca número de teléfono vinculado con Bizum: ");
        this.telefono = teclado.next();

        System.out.println("[SECRETO -- PIN: " + pin + "]");

        System.out.print("Introduzca su PIN: ");
        pinUsuario = teclado.nextInt();
    }

    /**
     * Valida que el telefono tenga 9 digitos y que el PIN sea correcto.
     * @return true si los datos son validos
     */
    public boolean validarBizum() {
        System.out.println("Validando Bizum...");
        if (telefono.length() == 9 && pinUsuario == pin) {
            return true;
        } else {
            System.out.println("Los datos de tu Bizum no son correctos.");
            return false;
        }
    }

    @Override
    public void procesarPago(double importe) {
        if (!validarBizum()) {
            return;
        }
        System.out.println("Procesando pago de " + importe + "€ con Bizum.");
        System.out.println("Pago aceptado. Muchas Gracias.");
    }

    @Override
    public String toString() {
        return "Bizum" ;
    }
}
