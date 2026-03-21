package Examenes.ExcursionesMutxa;

public class AppExcursiones {
    public static void main(String[] args) {
        System.out.println("=== APP EXCURSIONES ===");

        Excursion terraMitica = new Excursion("Terra Mitica", "Benidorm", 30.0);

        terraMitica.inscribirProfesor();

        terraMitica.inscribirAsistente();
        terraMitica.inscribirAsistente();
        terraMitica.inscribirAsistente();
        terraMitica.inscribirAsistente();

        terraMitica.verAsistentes();

        terraMitica.eliminarAsistentesPorEdad(16);
        System.out.println("\nDespués de eliminar a los asistentes de 16 años de edad: ");
        terraMitica.verAsistentes();

        System.out.println("\nImporte a ingresar para la actividad: " + terraMitica.getNombreActividad() + " en " + terraMitica.getLocalidad() + ": " + terraMitica.calcularImporteIngreso());
    }
}
