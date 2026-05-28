package Examenes.SimulacroExamen;

public class DocenteHuelga extends RuntimeException {
    public DocenteHuelga() {
        super("El docente ya está en huelga.");
    }
}
