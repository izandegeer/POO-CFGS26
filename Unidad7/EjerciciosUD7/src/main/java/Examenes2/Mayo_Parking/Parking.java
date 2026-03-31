package Examenes2.Mayo_Parking;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Parking {
    private List<Ticket> listaClientesActuales = new ArrayList<>();
    private String Ciudad;
    private int plazasTotales;
    private double precioMinuto;

    public Parking(String ciudad, int plazasTotales, double precioMinuto, List<Ticket> listaClientesActuales) {
        Ciudad = ciudad;
        this.plazasTotales = plazasTotales;
        this.precioMinuto = precioMinuto;
        this.listaClientesActuales = listaClientesActuales;
    }

    public Parking(String ciudad, int plazasTotales, double precioMinuto) {
        Ciudad = ciudad;
        this.plazasTotales = plazasTotales;
        this.precioMinuto = precioMinuto;
    }

    public void anyadirCliente(Ticket ticket) {
        listaClientesActuales.add(ticket);
    }

    public Ticket validarTicket(String matricula) {
        for (Ticket ticket : listaClientesActuales) {
            if (ticket.getMatricula().equalsIgnoreCase(matricula)){
                return ticket;
            }
        }

        return null;
    }

    public void generarClientesAleatorios() {
        Random random = new Random();
        int cantidadClientes = random.nextInt(8)+1;

        for (int i = 0; i < cantidadClientes; i++) {
            Ticket nuevoTicket = new Ticket("", 0, Estado.PENDIENTE);
            String matricula;

            boolean duplicado;

            do {
                duplicado = false;
                nuevoTicket.setMatricula("");
                matricula = nuevoTicket.nuevaMatricula();

                for (Ticket ticket : listaClientesActuales){
                    if (ticket.getMatricula().equalsIgnoreCase(matricula)){
                        duplicado = true;
                        break;
                    }
                }
            } while (duplicado);

            int minutos = random.nextInt(120)+1;
            nuevoTicket.setMatricula(matricula);
            nuevoTicket.setMinutos(minutos);
            nuevoTicket.setEstado(Estado.RECOGIDO);
            anyadirCliente(nuevoTicket);
        }
    }

    public void mostrarClientesActuales() {
        System.out.println("*** PARKING MUTXAMEL ***");
        System.out.println("------------------------");

        int contador = 1;
        for (Ticket cliente : listaClientesActuales) {
            System.out.println(contador + ". Matrícula: " + cliente.getMatricula() + " - minutos: " + cliente.getMinutos() + " - estado: " + cliente.getEstado());
            contador++;
        }
    }
}
