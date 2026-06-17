package Examenes.ExamenesUltimos.appParking;


import java.util.Random;

public class Ticket implements acciones {
    private String matricula;
    private Integer minutos;
    private Estado estado;

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

    @Override
    public void generar() {
        System.out.println("Leyendo matrícula...");
        Random random = new Random();
        String letras = "BCDFGHJKLMNPQRSTVWXYZ";
        String numeros = "0123456789";
        String matricula = "";

        for (int j = 0; j < 4; j++) {
            int randomN = random.nextInt(letras.length());
            matricula += letras.charAt(randomN);
        }
        for (int j = 0; j < 3; j++) {
            int randomN = random.nextInt(numeros.length());
            matricula += numeros.charAt(randomN);
        }

        setMatricula(matricula);
        setEstado(Estado.GENERADO);

        System.out.println("Matrícula: " + matricula);
        System.out.println("Ticket generado");
    }

    @Override
    public void recoger() {
        System.out.println("Recoja su ticket...");
        System.out.println("¡Bienvenido!");
        setEstado(Estado.RECOGIDO);
    }

    @Override
    public void pagar() {

    }
}
