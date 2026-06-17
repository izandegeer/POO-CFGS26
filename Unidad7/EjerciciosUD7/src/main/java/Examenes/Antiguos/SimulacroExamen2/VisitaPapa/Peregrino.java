package Examenes.Antiguos.SimulacroExamen2.VisitaPapa;

public abstract class Peregrino implements AccionProtocolaria{
    private Integer numReserva;
    private String nombre;
    private EstadoPeregrino estadoPeregrino;

    public Integer getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(Integer numReserva) {
        this.numReserva = numReserva;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EstadoPeregrino getEstadoPeregrino() {
        return estadoPeregrino;
    }

    public void setEstadoPeregrino(EstadoPeregrino estadoPeregrino) {
        this.estadoPeregrino = estadoPeregrino;
    }

    @Override
    public String toString() {
        return "Peregrino{" +
                "numReserva=" + numReserva +
                ", nombre='" + nombre + '\'' +
                ", estadoPeregrino=" + estadoPeregrino +
                '}';
    }

    public Peregrino(Integer numReserva, String nombre, EstadoPeregrino estadoPeregrino) {
        this.numReserva = numReserva;
        this.nombre = nombre;
        this.estadoPeregrino = estadoPeregrino;
    }
}
