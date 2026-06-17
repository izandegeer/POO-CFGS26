package Examenes.Antiguos.SimulacroExamen2.VisitaPapa;

public class Nacional extends Peregrino{
    private String provincia;


    public Nacional(Integer numReserva, String nombre, EstadoPeregrino estadoPeregrino, String provincia) {
        super(numReserva, nombre, estadoPeregrino);
        this.provincia = provincia;
    }

    @Override
    public void recibirBesico(Peregrino peregrino) {
        System.out.println("[!] El papa le da un besico en la frente a " + peregrino.getNombre() + " y l@ despacha con una sonrisa.");
    }
}
