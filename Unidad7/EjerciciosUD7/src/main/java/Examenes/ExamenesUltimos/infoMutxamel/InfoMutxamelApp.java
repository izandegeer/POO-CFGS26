package Examenes.ExamenesUltimos.infoMutxamel;

import java.util.Random;
import java.util.TreeSet;

public class InfoMutxamelApp {
    private static TreeSet<Comunicado> comunicadosEmitidos = new TreeSet<>();
    private static Random random = new Random();
    private static int contadorId = 1;

    public static void main(String[] args) {
        generarRuidoPositivo();
    }

    public static void generarRuidoPositivo() {
        String letras = " ABCDEFGHI JKLMNO PQRSTU VWX YZ";
        String comunicado = "";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 100; j++) {
                int randomN = random.nextInt(letras.length());
                comunicado += letras.charAt(randomN);
            }
            EventoFestivo comunicado1 = new EventoFestivo("CM" + contadorId, comunicado, 1, EstadoMensaje.PENDIENTE, "PLAZA DEL AYTO", true);
            comunicado1.aplicarRuido();
            comunicadosEmitidos.add(comunicado1);
            contadorId++;
        }

        System.out.println("[+] Generando ruido a cascoporro...");
        for (Comunicado comunicado1 : comunicadosEmitidos) {
            System.out.println(comunicado1);
        }
    }

    public static void mostrarComunicados() {

    }

    public static void insertarComunicado() {

    }

    public static Comunicado redactarComunicado(String texto) {

        return null;
    }

    public static void revisarComunicadosHuelga() {

    }

    public static void limpiarCriticas() {

    }

    public static void generarEstadisticas() {

    }

    public TreeSet<Comunicado> getComunicadosEmitidos() {
        return comunicadosEmitidos;
    }

    public void setComunicadosEmitidos(TreeSet<Comunicado> comunicadosEmitidos) {
        this.comunicadosEmitidos = comunicadosEmitidos;
    }
}
