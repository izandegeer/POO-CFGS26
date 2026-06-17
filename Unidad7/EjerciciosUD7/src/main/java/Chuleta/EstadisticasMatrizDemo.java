package Chuleta;

import java.util.ArrayList;
import java.util.List;

public class EstadisticasMatrizDemo {

    enum EstadoDocente {
        ACTIVO,
        EN_HUELGA,
        SERVICIOS_MINIMOS
    }

    static class Docente {
        EstadoDocente estado;

        Docente(EstadoDocente estado) {
            this.estado = estado;
        }
    }

    public static void main(String[] args) {
        List<Docente> huelguistas = new ArrayList<>();
        huelguistas.add(new Docente(EstadoDocente.ACTIVO));
        huelguistas.add(new Docente(EstadoDocente.ACTIVO));
        huelguistas.add(new Docente(EstadoDocente.EN_HUELGA));
        huelguistas.add(new Docente(EstadoDocente.EN_HUELGA));
        huelguistas.add(new Docente(EstadoDocente.EN_HUELGA));
        huelguistas.add(new Docente(EstadoDocente.EN_HUELGA));
        huelguistas.add(new Docente(EstadoDocente.EN_HUELGA));
        huelguistas.add(new Docente(EstadoDocente.EN_HUELGA));
        huelguistas.add(new Docente(EstadoDocente.EN_HUELGA));
        huelguistas.add(new Docente(EstadoDocente.SERVICIOS_MINIMOS));

        EstadoDocente[] estados = EstadoDocente.values();
        int columnas = estados.length;
        double[][] matriz = new double[2][columnas];

        for (Docente d : huelguistas) {
            int col = d.estado.ordinal();
            matriz[0][col] = matriz[0][col] + 1;
        }

        int total = huelguistas.size();
        for (int col = 0; col < columnas; col++) {
            matriz[1][col] = matriz[0][col] / total * 100;
        }

        System.out.println("Estadísticas de seguimiento:");
        for (int col = 0; col < columnas; col++) {
            System.out.println("   - " + estados[col]
                    + ": " + (int) matriz[0][col] + " docentes"
                    + " (" + String.format("%.2f", matriz[1][col]) + "%)");
        }
        System.out.println("   ----------------------------------------");
        System.out.println("   Total de huelguistas: " + total);
    }
}
