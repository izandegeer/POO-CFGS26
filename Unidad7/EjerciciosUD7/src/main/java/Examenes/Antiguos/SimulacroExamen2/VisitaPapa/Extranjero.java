package Examenes.Antiguos.SimulacroExamen2.VisitaPapa;

public class Extranjero extends Peregrino{
    private String pais;

    public Extranjero(Integer numReserva, String nombre, EstadoPeregrino estadoPeregrino, String pais) {
        super(numReserva, nombre, estadoPeregrino);
        this.pais = pais;
    }

    @Override
    public void recibirBesico(Peregrino peregrino) {
        System.out.println("[!] El papa le da un besico en la frente a " + peregrino.getNombre() + " y l@ despacha con una sonrisa.");
    }
}
