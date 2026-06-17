package Examenes.ExamenesUltimos.simulacroPractico.visitaPapa;

import java.util.*;

public class VaticanoApp {
    private static Set<Peregrino> registrados = new LinkedHashSet<>();
    private static Queue<Peregrino> fila = new LinkedList<>();
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        Peregrino ivan = new Nacional(1, "Ivan", EstadoPeregrino.SOLICITUD_OK, "Alicante");
        Peregrino izan = new Nacional(2, "Izan", EstadoPeregrino.SOLICITUD_OK, "Albacete");
        Peregrino joserra = new Nacional(3, "Joserra", EstadoPeregrino.SOLICITUD_OK, "Murcia");
        Peregrino ismael = new Extranjero(4, "Ismael", EstadoPeregrino.SOLICITUD_OK, "Marruecos");
        Peregrino manuela = new Extranjero(5, "Manuela", EstadoPeregrino.SOLICITUD_OK, "Suecia");

        registrados.add(ivan);
        registrados.add(joserra);
        registrados.add(izan);
        registrados.add(ismael);
        registrados.add(manuela);

        System.out.println("*** Lista peregrinos ***");
        for (Peregrino peregrino : registrados) {
            System.out.println(peregrino.getNumReserva() + ". " + peregrino.getNombre());
        }

        llegadaPeregrino();
        System.out.println("\n*** BENDICION PAPAL ***");
        bendicionPapa();
    }

    public static void llegadaPeregrino() {
        System.out.println("\n*** Llegada peregrino ***");
        System.out.print("> Introduce número de reserva: ");
        int numReserva = teclado.nextInt();

        buscarPeregrino(numReserva);
    }

    public static Peregrino buscarPeregrino(Integer numReserva) {
        for (Peregrino peregrino : registrados) {
            if (peregrino.getNumReserva().equals(numReserva)){
                if (peregrino.getEstado() == EstadoPeregrino.BENDECIDO) {
                    System.out.println("[!] ¡Pecador! Ya has recibido tu besico, deja paso a otros.");
                    return null;
                } else {
                    peregrino.setEstado(EstadoPeregrino.EN_COLA);
                    System.out.println("[+] Peregrino " + peregrino.getNombre() + " añadido a la fila.");
                    fila.add(peregrino);
                    return peregrino;
                }
            }
        }
        System.out.println("[!] Error: Reserva no encontrada");
        return null;
    }

    public static void bendicionPapa() {
        if (fila.isEmpty()) {
            System.out.println("Su santidad está descansando, no hay nadie en la cola.");
        }

        System.out.println("> El Papa bendice: ");

        while (!fila.isEmpty()) {
            fila.poll().recibirBesico();
        }
    }

    public static Set<Peregrino> getRegistrados() {
        return registrados;
    }

    public static void setRegistrados(Set<Peregrino> registrados) {
        VaticanoApp.registrados = registrados;
    }

    public static Queue<Peregrino> getFila() {
        return fila;
    }

    public static void setFila(Queue<Peregrino> fila) {
        VaticanoApp.fila = fila;
    }
}
