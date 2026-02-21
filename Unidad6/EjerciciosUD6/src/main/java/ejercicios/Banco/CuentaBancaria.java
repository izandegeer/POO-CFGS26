package ejercicios.Banco;

import java.util.Scanner;

public class CuentaBancaria {
    static Scanner teclado = new Scanner(System.in);
    private static int saldo;

    static void main() {
        System.out.println("=== Cajero Automático ===");

        System.out.println("\n[1] Consultar saldo");
        System.out.println("[2] Ingresar dinero");
        System.out.println("[3] Retirar dinero");
        System.out.println("[4] Salir");

        System.out.print("\nIntroduce opción: ");
        int opcion = teclado.nextInt();

        switch (opcion) {
            case 1:
                consultarSaldo();
                break;
            case 2:
                ingresarDinero();
                break;
            case 3:
                retirarDinero();
                break;
            default:
                return;
        }
    }

    public static void ingresarDinero() {
        System.out.println("Introduce el importe a ingresar: ");
        int importe = teclado.nextInt();
        if (importe > 0) {
            saldo += importe;
        } else if (importe > 3000) {
            throw new DepositoMaximoException();
        } else {
            System.out.println("El importe a retirar debe de ser mayor a 0");
        }

        System.out.println("Dinero ingresado con éxito. Saldo actual: " + importe);
    }

    public static void retirarDinero() {
        System.out.println("Introduce el importe a retirar: ");
        int importe = teclado.nextInt();
        if (saldo <= 0){
            throw new SaldoInsuficienteException();
        } else if (importe > 0) {
            saldo -= importe;
        } else if (importe > 600) {
            throw new LimiteDiarioException();
        } else {
            System.out.println("El importe a retirar debe de ser mayor a 0");
        }

        System.out.println("Dinero retirado con éxito. Saldo actual: " + importe);
    }

    public static void consultarSaldo() {
        System.out.println("Saldo actual: " + saldo);
    }
}
