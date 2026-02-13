package practicas.Ecommerce;

import java.util.Scanner;

/**
 * Clase pruncipal de la tienda.
 * Permite al usuario elegir un metodo de pago y realizar un pago.
 */
public class Tienda {
    static Scanner teclado = new Scanner(System.in);
    private static double importe = 0;

    public static void main(String[] args) {
        iniciarPago();
    }

    /**
     * Realiza el pago con el metodo de pago que el usuario le pase.
     * @param metodoPago el metodo de pago elegido
     */
    public static void realizarPago(MetodoPago metodoPago) {
        System.out.println("Método " + metodoPago + " seleccionado.");
        System.out.print("Introduzca importe a pagar: ");
        try {
            importe = teclado.nextDouble();
        } catch (Exception e) {
            System.out.println("ERROR. Introduce un importe válido.");
        }

        metodoPago.procesarPago(importe);
    }

    /**
     * Muestra el menu de metodos de pago y lanza el proceso de pago.
     */
    public static void iniciarPago() {
        System.out.println("¿Qué método de pago realiza utilizar?");
        System.out.println("[1] Tarjeta de crédito");
        System.out.println("[2] PayPal");
        System.out.println("[3] Bizum");
        System.out.print("\nIntroduce método de pago: ");

        int opcion = 0;
        try {
            opcion = teclado.nextInt();
        } catch (Exception e) {
            System.out.println("El método de pago no existe.");
            return;
        }

        switch (opcion) {
            case 1: // Tarjeta de crédito
                Tarjeta tarjeta = new Tarjeta();
                tarjeta.rellenarDatosTarjeta();
                realizarPago(tarjeta);
                break;
            case 2: // PayPal
                PayPal payPal = new PayPal();
                payPal.rellenarDatosPaypal();
                realizarPago(payPal);
                break;
            case 3: // Bizum
                Bizum bizum = new Bizum();
                bizum.rellenarDatosBizum();
                realizarPago(bizum);
                break;
            default:
                System.out.println("El método de pago no existe.");
        }
    }
}
