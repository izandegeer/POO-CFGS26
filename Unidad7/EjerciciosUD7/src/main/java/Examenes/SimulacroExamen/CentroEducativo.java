package Examenes.SimulacroExamen;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

@Getter @Setter
public class CentroEducativo {
    private String nombre;
    private int plantillaTotal;
    private double descuentoSalarialDiario;
    private HashSet<Docente> huelguistas;
    private static Random random = new Random();

    // Formato DNI: 12345678X
    public void generarHuelguistasAleatorios() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";
        int numeroHuelguistas = random.nextInt(plantillaTotal) + 1;

        while (huelguistas.size() < numeroHuelguistas) {
            String dni = "";

            for (int i = 0; i < 8; i++) {
                dni += numeros.charAt(random.nextInt(numeros.length()));
            }
                dni += letras.charAt(random.nextInt(letras.length()));
            int numDiasHuelga = random.nextInt(8)+1;

                boolean repetido = false;
                for (Docente docente : huelguistas) {
                    if (docente.getDni().equalsIgnoreCase(dni)) {
                        repetido = true;
                        break;
                    }
                }

                if (!repetido) {
                    huelguistas.add(new Docente(dni, numDiasHuelga, EstadoDocente.EN_HUELGA));
                }
        }
    }

    public void mostrarHuelguistasActuales() {
        System.out.println("** DOCENTES EN HUELGA**");
        int contador = 1;

        for (Docente docente : huelguistas) {
            System.out.println(contador + ". DNI: " + docente.getDni() + " - días huelga: " + docente.getDiasHuelga() + " - estado: " + docente.getEstado());
            contador++;
        }
    }

    public Docente validarDocente(String dni) {
        for (Docente docente : huelguistas) {
          if (docente.getDni().equalsIgnoreCase(dni)) {
              return docente;
          }
        }
        return null;
    }

    public void sortearServiciosMinimos() {
        ArrayList<Docente> listaDocentes = new ArrayList<>(huelguistas);
        int numRandom = random.nextInt(listaDocentes.size());
        Docente docenteSorteo = listaDocentes.get(numRandom);
        docenteSorteo.asignarServiciosMinimos();

        System.out.println("Ha salido el docente con DNI " + docenteSorteo.getDni() + " como elegido para los servicios mínimos.");
    }

    public void limpiarRegistro() {
        Iterator<Docente> it = huelguistas.iterator();
        while (it.hasNext()) {
            Docente docente = it.next();
            if (docente.getEstado() == EstadoDocente.ACTIVO) {
                System.out.println("Docente con DNI: " + docente.getDni() + " fulminado.");
                it.remove();
            }
        }
    }

    public CentroEducativo(String nombre, int plantillaTotal, double descuentoSalarialDiario, HashSet<Docente> huelguistas) {
        this.nombre = nombre;
        this.plantillaTotal = plantillaTotal;
        this.descuentoSalarialDiario = descuentoSalarialDiario;
        this.huelguistas = huelguistas;
    }
}
