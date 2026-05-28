package Examenes.mayo25;

import java.util.Random;

public class Ticket implements Acciones {

    private String matricula;
    private Integer minutos;
    private Estado estado;

    private static final String LETRAS = "BCDFGHJKLMNPQRSTVWXYZ";
    private static final String NUMEROS = "0123456789";

    public Ticket(String matricula, Integer minutos, Estado estado) {
        this.matricula = matricula;
        this.minutos = minutos;
        this.estado = estado;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getMinutos() {
        return minutos;
    }

    public void setMinutos(Integer minutos) {
        this.minutos = minutos;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public static String generarMatriculaAleatoria() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(NUMEROS.charAt(random.nextInt(NUMEROS.length())));
        }
        for (int i = 0; i < 3; i++) {
            sb.append(LETRAS.charAt(random.nextInt(LETRAS.length())));
        }
        return sb.toString();
    }

    @Override
    public void generar() {
        System.out.println("Leyendo matricula...");
        this.matricula = generarMatriculaAleatoria();
        this.estado = Estado.GENERADO;
        System.out.println("Matricula: " + this.matricula);
        System.out.println("Ticket generado.");
    }

    @Override
    public void recoger() {
        System.out.println("Recoja su ticket...");
        this.estado = Estado.RECOGIDO;
        System.out.println("BIENVENIDO!");
    }

    @Override
    public void pagar() {
        System.out.println("Pagando...");
        this.estado = Estado.PAGADO;
    }
}
