package Examenes.Antiguos.SimulacroExamen2.VisitaPapa;

import java.util.*;

public class VaticanoApp {
    static Set<Peregrino> registrados = new LinkedHashSet<>();
    static Queue<Peregrino> fila = new LinkedList<>();

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        Peregrino izan = new Nacional(1, "Izan", EstadoPeregrino.SOLICITUD_OK, "Alicante");
        Peregrino jose = new Nacional(2, "Jose", EstadoPeregrino.SOLICITUD_OK, "Valencia");
        Peregrino ivan = new Nacional(3, "Ivan", EstadoPeregrino.SOLICITUD_OK, "Murcia");
        Peregrino ismael = new Extranjero(4, "Ismael", EstadoPeregrino.SOLICITUD_OK, "Marruecos");
        Peregrino toni = new Extranjero(5, "Toni", EstadoPeregrino.SOLICITUD_OK, "Alemania");

        registrados.add(izan);
        registrados.add(jose);
        registrados.add(ivan);
        registrados.add(ismael);
        registrados.add(toni);

        System.out.println("*** PEREGRINOS REGISTRADOS ***");
        for (Peregrino peregrino : registrados) {
            System.out.println(peregrino.getNumReserva() + ". " + peregrino.getNombre());
        }

        System.out.println("\n*** REGISTRO PEREGRINO ***");
        llegadaPeregrino();

        System.out.println("\n*** BENDICIÓN PAPAL ***");
        bendicionPapa();
    }

    public static void llegadaPeregrino() {
        System.out.print("> Introduzca el número de reserva: ");
        int numReserva = teclado.nextInt();

        buscarPeregrino(numReserva);
    }

    public static Peregrino buscarPeregrino(Integer numReserva) {
        boolean numEncontrado = false;

        for (Peregrino peregrino : registrados) {
            if (peregrino.getNumReserva() == numReserva) {
                if (peregrino.getEstadoPeregrino() == EstadoPeregrino.BENDECIDO) {
                    System.out.println("[!] ¡Pecador! Ya has recibido tu besico, deja paso a otros.");
                    return null;
                } else if (peregrino.getEstadoPeregrino() == EstadoPeregrino.SOLICITUD_OK) {
                    System.out.println("[+] Peregrino " + peregrino.getNombre() + " añadido a la fila.");
                    peregrino.setEstadoPeregrino(EstadoPeregrino.EN_COLA);
                    fila.offer(peregrino);
                    return peregrino;
                } else if (peregrino.getEstadoPeregrino() == EstadoPeregrino.EN_COLA) {
                    System.out.println("[!] Peregrino " + peregrino.getNombre() + " ya estaba en la fila.");
                    return null;
                }
                numEncontrado = true;
            } else {
                System.out.println("[!] ERROR: Reserva no encontrada.");
                return null;
            }
        }
        return null;
    }

    public static void bendicionPapa() {
        if (fila.isEmpty()) {
            System.out.println("[-] Su Santidad está descansando, no hay nadie en la cola.");
        } else {
            while (!fila.isEmpty()) {
                Peregrino peregrinoActual = fila.poll();
                peregrinoActual.recibirBesico(peregrinoActual);
                peregrinoActual.setEstadoPeregrino(EstadoPeregrino.BENDECIDO);
            }
        }
    }
}
