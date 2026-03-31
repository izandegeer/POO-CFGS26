package Examenes.Parking;

import Examenes.ticketMutxa.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Parking {
    List<Ticket> clientesActuales = new ArrayList<>();
    private String ciudad;
    private int plazasTotales;
    private double precioMinuto;

    public void generarClientesAleatorios() {
        String letras = "BCDFGHJKLMNPQRSTVWXYZ";
        String numeros = "0123456789";

        Random random = new Random();
        int cantidad = 3;
        String letrasMatricula = "";

        for (int i = 0; i < cantidad; i++) {
            int numerosMatricula = random.nextInt(9000) + 1000;
            for (int j = 0; j < 3; j++) {
                letrasMatricula += letras.charAt(random.nextInt(letras.length()));
            }
        }

    }

    public void mostrarClientesActuales() {

    }

    public void anyadirCliente() {

    }

    public Ticket validarTicket(String matricula) {

        return null;
    }
}
