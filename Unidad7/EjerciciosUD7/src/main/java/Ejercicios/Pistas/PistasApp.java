package Ejercicios.Pistas;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

@Getter
@Setter
public class PistasApp {
    static Scanner teclado = new Scanner(System.in);
    static HashMap<Usuario, LinkedHashSet<Reserva>> mapa = new HashMap<>();

    static void main(String[] args) {
    }

    public static void eliminarReserva(LinkedHashSet<Reserva> listaReservas) {
        Iterator<Reserva> it = listaReservas.iterator();

        System.out.print("Introduce el tipo de pista a borrar (Padel, Tenis): ");
        String opcion = teclado.nextLine();

        while (it.hasNext()){
            Reserva reserva = it.next();
            if (opcion.equalsIgnoreCase("PADEL") && reserva.getPista() instanceof Padel){
                it.remove();
            } else if (opcion.equalsIgnoreCase("TENIS") && reserva.getPista() instanceof Tenis) {
                it.remove();
            } else {
                System.out.println("Esa opción no existe.");
            }
        }
    }

    public static LinkedHashSet<Reserva> obtenerReservas(Usuario usuario){
        return mapa.get(usuario);
    }

    public static void generarReserva(Usuario usuario, Pista pista){
        Reserva reserva = new Reserva(usuario, pista);
        obtenerReservas(usuario);

        LinkedHashSet<Reserva> listaReservas = obtenerReservas(usuario);
        if (listaReservas.contains(reserva)){
            throw new ReservaDuplicada();
        } else {
            listaReservas.add(reserva);
            mapa.put(usuario, listaReservas);
        }
    }
}
