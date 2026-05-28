package Examenes.SimulacroExamen;

import java.util.HashSet;
import java.util.Scanner;

public class AppHuelga {
    private static CentroEducativo centro;
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        centro = new CentroEducativo("IES", 10, 95.5, new HashSet<>());
        centro.generarHuelguistasAleatorios();
        centro.mostrarHuelguistasActuales();
        verSeguimiento();
        validacion();
        abandonarHuelga();
        centro.mostrarHuelguistasActuales();
        centro.sortearServiciosMinimos();
        centro.mostrarHuelguistasActuales();
        centro.limpiarRegistro();
        centro.mostrarHuelguistasActuales();
    }

    public static void verSeguimiento() {
        int contadorTrabajadores = 0;

        for (Docente docente : centro.getHuelguistas()){
            if (docente.getEstado() != EstadoDocente.EN_HUELGA) {
                contadorTrabajadores++;
            }
        }

        if (contadorTrabajadores > 0) {
            System.out.println("El centro está en HUELGA PARCIAL (" + contadorTrabajadores + " docentes trabajando).");
        } else if (contadorTrabajadores == 0){
            System.out.println("El centro está en HUELGA TOTAL.");
        }
    }

    public static Docente validacion() throws DocenteHuelga {
        System.out.println("** VALIDACIÓN **");
        System.out.print("> Introduzca un DNI de un docente: ");
        String dni = teclado.next();

        Docente docente = centro.validarDocente(dni);

        if (docente == null) {
            System.out.println("El docente no existe como huelguista.");
            Docente nuevoDocente = new Docente(dni, 0, EstadoDocente.ACTIVO);
            insertarHuelguista(nuevoDocente);
        } else {
            calcularDescuentoSalarial(docente);
        }

        return docente;
    }

    public static void insertarHuelguista(Docente docente) {
        docente.secundar();
        insertarHuelguista(docente);
    }

    public static void calcularDescuentoSalarial(Docente docente) {
        double retencionSalarial = docente.getDiasHuelga() * centro.getDescuentoSalarialDiario();

        System.out.println("Días: " + docente.getDiasHuelga() + " - Descuento por día: " + centro.getDescuentoSalarialDiario() + "€");
        System.out.println("Importe a reneter: " + retencionSalarial + "€.");
    }

    public static void abandonarHuelga() {
        System.out.println("** ABANDONAR HUELGA **");
        System.out.print("> Introduzca un DNI de un docente: ");
        String dni = teclado.next();

        boolean docenteValido = false;

        for (Docente docente : centro.getHuelguistas()) {
            if (dni.equalsIgnoreCase(docente.getDni())) {
                docenteValido = true;
                docente.finalizar();
                docente.setEstado(EstadoDocente.ACTIVO);
            }
        }

        if (!docenteValido) {
            System.out.println("No se ha podido finalizar la huelga. El docente no existe en la lista de huelguistas.");
        }
    }

    public static void listadoConselleria() {

    }

    public static void generarEstadisticas() {

    }
}
