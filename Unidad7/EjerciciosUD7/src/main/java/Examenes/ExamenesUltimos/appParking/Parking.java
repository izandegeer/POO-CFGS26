package Examenes.ExamenesUltimos.appParking;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Parking {
    private String ciudad;
    private int plazasTotales;
    private double precioMinuto;
    private ArrayList<Ticket> clientesActuales = new ArrayList<>();
    private int contador = 1;

    public void generarClientesAleatorios() {
        Random random = new Random();
        String letras = "BCDFGHJKLMNPQRSTVWXYZ";
        String numeros = "0123456789";
        String matricula = "";

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                int randomN = random.nextInt(letras.length());
                matricula += letras.charAt(randomN);
            }
            for (int j = 0; j < 3; j++) {
                int randomN = random.nextInt(numeros.length());
                matricula += numeros.charAt(randomN);
            }
            int minutos = random.nextInt(100);
            clientesActuales.add(new Ticket(matricula, minutos, Estado.RECOGIDO));
            matricula = "";
        }
    }

    public void mostrarClientesActuales() {
        for (Ticket ticket : clientesActuales) {
            System.out.println(contador + ". Matrícula: " + ticket.getMatricula() + " - Minutos: " + ticket.getMinutos() + " - Estado: " + ticket.getEstado());
            contador++;
        }
        contador = 1;
    }

    public void anyadirCliente(Ticket ticket) {
        clientesActuales.add(ticket);
    }

    public Ticket validarTicket(String matricula) {
        System.out.println("Validando...");
        for (Ticket ticket : clientesActuales) {
            if (Objects.equals(ticket.getMatricula(), matricula)) {
                System.out.println("Minutos: " + ticket.getMinutos() + " - Precio por minuto: " + getPrecioMinuto());
                System.out.println("Importe a pagar: " + (ticket.getMinutos() * getPrecioMinuto()) + "€");
                ticket.setEstado(Estado.PAGADO);
                return ticket;
            }
        }
        return null;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getPlazasTotales() {
        return plazasTotales;
    }

    public void setPlazasTotales(int plazasTotales) {
        this.plazasTotales = plazasTotales;
    }

    public double getPrecioMinuto() {
        return precioMinuto;
    }

    public void setPrecioMinuto(double precioMinuto) {
        this.precioMinuto = precioMinuto;
    }

    public ArrayList<Ticket> getClientesActuales() {
        return clientesActuales;
    }

    public void setClientesActuales(ArrayList<Ticket> clientesActuales) {
        this.clientesActuales = clientesActuales;
    }

    public Parking(String ciudad, int plazasTotales, double precioMinuto, ArrayList<Ticket> clientesActuales) {
        this.ciudad = ciudad;
        this.plazasTotales = plazasTotales;
        this.precioMinuto = precioMinuto;
        this.clientesActuales = clientesActuales;
    }

    public Parking(String ciudad, int plazasTotales, double precioMinuto) {
        this.ciudad = ciudad;
        this.plazasTotales = plazasTotales;
        this.precioMinuto = precioMinuto;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "ciudad='" + ciudad + '\'' +
                ", plazasTotales=" + plazasTotales +
                ", precioMinuto=" + precioMinuto +
                ", clientesActuales=" + clientesActuales +
                '}';
    }
}
