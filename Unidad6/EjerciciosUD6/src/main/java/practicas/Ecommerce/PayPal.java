package practicas.Ecommerce;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

/**
 * Clase que representa el metodo de pago PayPal.
 * Valida el email y el saldo antes de procesar el pago.
 */
public class PayPal extends MetodoPago {
    private static Scanner teclado = new Scanner(System.in);
    @Getter
    @Setter
    private String cuenta;
    @Getter
    @Setter
    private double saldo = 23;


    /**
     * Valida que el email sea correcto y que haya saldo suficiente.
     * @param importe la cantidad a pagar
     * @return true si la validacion es correcta
     */
    public boolean validarPaypal(double importe) {
        boolean emailCorrecto = cuenta.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
        if (emailCorrecto && saldo >= importe) {
            return true;
        } else if (importe > saldo){
            System.out.println("No tiene suficientes fondos en la cuenta.");
            return false;
        } else {
            System.out.println("No se ha podido realizar el pago. Inténtelo de nuevo.");
            return false;
        }
    }

    /**
     * Pide al usuario que introduzca los datos de PayPal por consola.
     */
    public void rellenarDatosPaypal() {
        System.out.println("\nPAYPAL");
        System.out.println("------");

        System.out.print("Introduzca cuenta: ");
        this.cuenta = teclado.next();

        System.out.print("Introduzca saldo: ");
        saldo = teclado.nextDouble();
    }

    @Override
    public void procesarPago(double importe) {
        if (!validarPaypal(importe)) {
            return;
        }
        System.out.println("Procesando pago de " + importe + "€ con Paypal");
        System.out.println("Pago aceptado. Muchas Gracias.");
    }

    @Override
    public String toString() {
        return "PayPal";
    }
}
