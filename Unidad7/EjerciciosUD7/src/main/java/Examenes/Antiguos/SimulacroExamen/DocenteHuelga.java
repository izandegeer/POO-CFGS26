package Examenes.Antiguos.SimulacroExamen;

public class DocenteHuelga extends RuntimeException {
    public DocenteHuelga() {
        super("El docente ya está en huelga.");
    }
}
