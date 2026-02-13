package practicas.Ecommerce;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

/**
 * Clase que representa el metodo de pago con tarjeta de credito.
 * Admite VISA, MASTERCARD y MAESTRO.
 */
public class Tarjeta extends MetodoPago {
    private static Scanner teclado = new Scanner(System.in);
    @Getter
    @Setter
    private String nroTarjeta;
    @Getter
    @Setter
    private String tipo;
    private boolean tipoNovalido = false;

    /**
     * Valida que el numero de tarjeta tenga 16 digitos y el tipo sea valido.
     * @return true si la tarjeta es valida
     */
    public boolean validarTarjeta() {
        System.out.println("Validando tarjeta...");
        if (!this.nroTarjeta.matches("\\d{16}")) {
            System.out.println("ERROR. La tarjeta debe de tener 16 dígitos.");
            return false;
        }

        if (tipo == null || !tipo.equals("VISA") && !tipo.equals("MASTERCARD") && !tipo.equals("MAESTRO")) {
            System.out.println("ERROR. El tipo de tarjeta no es válido.");
            return false;
        }

        return true;
    }

    /**
     * Pide al usuario que introduzca los datos de la tarjeta por consola.
     */
    public void rellenarDatosTarjeta() {
        System.out.println("\nTARJETA");
        System.out.println("-------");

        System.out.print("Introduzca Número de tarjeta: ");
        this.nroTarjeta = teclado.next();

        System.out.println("Elija tipo:");
        System.out.println("[1] VISA");
        System.out.println("[2] MASTERCARD");
        System.out.println("[3] MAESTRO");
        System.out.print("\nIntroduzca tipo: ");
        int opcionTipoTarjeta = teclado.nextInt();

        switch (opcionTipoTarjeta) {
            case 1:
                this.tipo = "VISA" ;
                break;
            case 2:
                this.tipo = "MASTERCARD" ;
                break;
            case 3:
                this.tipo = "MAESTRO" ;
                break;
            default:
                tipoNovalido = true;
        }
    }

    @Override
    public void procesarPago(double importe) {
        if (!validarTarjeta()) {
            return;
        } else if (tipoNovalido){
            System.out.println("No existe ese tipo de tarjeta.");
            return;
        }
        System.out.println("Procesando pago de " + importe + "€ con tarjeta de crédito " + tipo);
        System.out.println("Pago aceptado. Muchas Gracias.");
    }

    @Override
    public String toString() {
        return "Tarjeta de crédito" ;
    }
}
