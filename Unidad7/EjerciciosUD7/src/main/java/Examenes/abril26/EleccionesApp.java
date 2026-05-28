package Examenes.abril26;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class EleccionesApp {

    static double[][] matriz = new double[2][4];
    static Collection<Votante> yaHanVotado = new ArrayList<>();
    static Map<String, Integer> votosPorPueblos = new TreeMap<>();

    static String poblacion;
    static int votosSi = 0;
    static int votosNo = 0;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Censo.generarCenso();
        cargarDatosPrueba();

        System.out.println("**** ELECCIONES APP ****\n");
        System.out.println("Introduce la población:");
        poblacion = sc.nextLine().trim();

        System.out.println("\nEmpieza la votación en " + poblacion + "!!");

        while (true) {
            System.out.println("\nIntroduce el tipo de documento a validar [DNI, NIE] ó SALIR para finalizar la votación:");
            String tipo = sc.nextLine().trim().toUpperCase();
            if (tipo.equals("SALIR")) {
                break;
            }
            if (!tipo.equals("DNI") && !tipo.equals("NIE")) {
                continue;
            }

            System.out.println("Introduce el número del DNI/NIE que has presentado:");
            String doc = sc.nextLine().trim();

            if (!validarDocumento(doc)) {
                System.out.println("El DNI/NIE no es correcto");
                continue;
            }

            Votante votante;
            if (tipo.equals("DNI")) {
                votante = new Nacional(doc);
            } else {
                votante = new Extranjero(doc, "MUNDO");
            }

            if (!verificarEmpadronamiento(votante)) {
                System.out.println("La persona no está empadronada en " + poblacion);
                continue;
            }

            System.out.println("Votante " + votante.getNombre() + " censado correctamente.");

            try {
                comprobarFraude(votante);
            } catch (FraudeException e) {
                System.out.println(e.getMessage());
                continue;
            }

            String voto = votante.votar();

            // Voto registrado: añadir a yaHanVotado, marcar votado, borrar del censo
            yaHanVotado.add(votante);
            votante.setVotado(true);
            Censo.eliminarDelCenso(votante);

            // Contadores
            if (voto.equals("SI")) {
                votosSi++;
            } else {
                votosNo++;
            }

            String pob = votante.getPoblacion();
            Integer count = votosPorPueblos.get(pob);
            votosPorPueblos.put(pob, (count == null ? 0 : count) + 1);

            // Encuesta de satisfacción
            int opcion = Votante.encuestaSatisfaccion();
            contabilizarDatosEncuesta(opcion);
        }

        recuento();
    }

    public static boolean validarDocumento(String documento) {
        return documento.matches("(\\d{8}|[XYZxyz]\\d{7})[A-Za-z]");
    }

    public static boolean verificarEmpadronamiento(Votante votante) {
        for (Votante v : Censo.censo) {
            if (Censo.mismaIdentidad(v, votante)) {
                votante.setNombre(v.getNombre());
                votante.setPoblacion(v.getPoblacion());
                if (votante instanceof Extranjero && v instanceof Extranjero) {
                    ((Extranjero) votante).setPais(((Extranjero) v).getPais());
                }
                return true;
            }
        }
        return false;
    }

    public static boolean comprobarFraude(Votante votante) {
        System.out.println("\nComprobando datos...");
        for (Votante v : yaHanVotado) {
            if (Censo.mismaIdentidad(v, votante)) {
                throw new FraudeException("¡AVISO A LA GUARDIA CIVIL! Intento de doble voto detectado");
            }
        }
        System.out.println(votante.getNombre() + " puede votar.");
        return true;
    }

    public static void contabilizarDatosEncuesta(int opcion) {
        if (opcion >= 1 && opcion <= 4) {
            matriz[0][opcion - 1]++;
        }
    }

    public static void recuento() {
        System.out.println("----------------------------");
        System.out.println("RECUENTO!");
        System.out.println("Votos SI a la Guerra: " + votosSi);
        System.out.println("Votos NO a la Guerra: " + votosNo);
        System.out.println("----------------------------");

        System.out.println("Datos de voto (por población):");
        Map<String, Integer> totales = new TreeMap<>();
        for (Votante v : yaHanVotado) {
            String pob = v.getPoblacion();
            Integer count = totales.get(pob);
            totales.put(pob, (count == null ? 0 : count) + 1);
        }
        for (Map.Entry<String, Integer> e : totales.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
        System.out.println("----------------------------");

        System.out.println("Datos de experiencia de usuario con la app...");
        double total = 0;
        for (int i = 0; i < 4; i++) {
            total += matriz[0][i];
        }
        Experiencia[] exps = Experiencia.values();
        for (int i = 0; i < exps.length; i++) {
            int votes = (int) matriz[0][i];
            int pct = total > 0 ? (int) Math.round((matriz[0][i] / total) * 100) : 0;
            matriz[1][i] = pct;
            System.out.println(" - " + exps[i].name() + ": " + votes + " (" + pct + "%)");
        }
        System.out.println("----------------------------");
    }

    private static void cargarDatosPrueba() {
        yaHanVotado.add(new Nacional("Agost", "Ana", "11111111A"));
        yaHanVotado.add(new Extranjero("Agost", "John", "X1111111A", "Reino Unido"));
        yaHanVotado.add(new Nacional("Agost", "Luis", "22222222B"));
        yaHanVotado.add(new Nacional("Mutxamel", "Carmen", "33333333C"));
        yaHanVotado.add(new Extranjero("Mutxamel", "Marie", "X2222222B", "Francia"));
        yaHanVotado.add(new Nacional("Mutxamel", "Pedro", "44444444D"));
        yaHanVotado.add(new Extranjero("Mutxamel", "Luca", "X3333333C", "Italia"));
        yaHanVotado.add(new Extranjero("Mutxamel", "Hans", "X4444444D", "Alemania"));
        yaHanVotado.add(new Nacional("Mutxamel", "Miguel", "66666666F"));
        yaHanVotado.add(new Nacional("Alicante", "Sara", "77777777G"));
        yaHanVotado.add(new Extranjero("Alicante", "Emma", "X5555555E", "Irlanda"));
        yaHanVotado.add(new Nacional("Alicante", "David", "88888888H"));
        yaHanVotado.add(new Extranjero("Alicante", "Noah", "X6666666F", "EEUU"));
        yaHanVotado.add(new Nacional("Alicante", "Laura", "99999999I"));
        yaHanVotado.add(new Extranjero("Alicante", "Sofia", "X7777777G", "Portugal"));
        yaHanVotado.add(new Nacional("Alicante", "Carlos", "10101010J"));
        yaHanVotado.add(new Extranjero("Alicante", "Ali", "X8888888H", "Marruecos"));
        yaHanVotado.add(new Nacional("Alicante", "Elena", "12121212K"));
        yaHanVotado.add(new Nacional("Alicante", "Javier", "13131313L"));
    }
}
