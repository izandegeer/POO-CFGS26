package Examenes.SimulacroExamen;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Docente implements AccionesHuelga {
    private String dni;
    private Integer diasHuelga;
    private EstadoDocente estado;

    public Docente(String dni, Integer diasHuelga, EstadoDocente estado) {
        this.dni = dni;
        this.diasHuelga = diasHuelga;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Docente{" +
                "dni='" + dni + '\'' +
                ", diasHuelga=" + diasHuelga +
                ", estado=" + estado +
                '}';
    }

    @Override
    public void secundar() {
        diasHuelga++;
        estado = EstadoDocente.EN_HUELGA;
    }

    @Override
    public void asignarServiciosMinimos() {
        estado = EstadoDocente.SERVICIOS_MINIMOS;
    }

    @Override
    public void finalizar() {
        System.out.println("El docente con DNI " + dni + " ha finalizado la huelga. Su estado vuelve a ser ACTIVO");
    }
}
