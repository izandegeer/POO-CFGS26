package Examenes.mayo25;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Parking {

    private String ciudad;
    private int plazas_totales;
    private double precio_minuto;
    private List<Ticket> clientesActuales;

    public Parking(String ciudad, int plazas_totales, double precio_minuto) {
        this.ciudad = ciudad;
        this.plazas_totales = plazas_totales;
        this.precio_minuto = precio_minuto;
        this.clientesActuales = new ArrayList<>();
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getPlazasTotales() {
        return plazas_totales;
    }

    public double getPrecioMinuto() {
        return precio_minuto;
    }

    public List<Ticket> getClientesActuales() {
        return clientesActuales;
    }

    public void generarClientesAleatorios() {
        Random random = new Random();
        int cantidad = random.nextInt(10) + 1;

        for (int i = 0; i < cantidad; i++) {
            String matricula;
            do {
                matricula = Ticket.generarMatriculaAleatoria();
            } while (existeMatricula(matricula));

            int minutos = random.nextInt(300) + 1;
            Ticket ticket = new Ticket(matricula, minutos, Estado.RECOGIDO);
            clientesActuales.add(ticket);
        }
    }

    private boolean existeMatricula(String matricula) {
        for (Ticket t : clientesActuales) {
            if (t.getMatricula().equals(matricula)) {
                return true;
            }
        }
        return false;
    }

    public void mostrarClientesActuales() {
        System.out.println("*** PARKING MUTXAMEL ***");
        for (int i = 0; i < clientesActuales.size(); i++) {
            Ticket t = clientesActuales.get(i);
            System.out.println((i + 1) + ". Matricula: " + t.getMatricula()
                    + " - minutos: " + t.getMinutos()
                    + " - estado: " + t.getEstado());
        }
    }

    public void anyadirCliente(Ticket ticket) {
        clientesActuales.add(ticket);
    }

    public Ticket validarTicket(String matricula) {
        for (Ticket t : clientesActuales) {
            if (t.getMatricula().equals(matricula)) {
                return t;
            }
        }
        return null;
    }
}
