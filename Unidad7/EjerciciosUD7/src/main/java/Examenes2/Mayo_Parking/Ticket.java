package Examenes2.Mayo_Parking;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter @Setter
public class Ticket implements Acciones{
    private String matricula;
    private Integer minutos;
    private Estado estado;

    @Override
    public void generar() {
        this.matricula = nuevaMatricula();
        this.estado = Estado.GENERADO;

        System.out.println("Leyendo matrícula...");
        System.out.println("Matrícula: " + this.matricula);
        System.out.println("Ticket generado.");
    }

    @Override
    public void recoger() {

    }

    @Override
    public void pagar() {
        this.estado = Estado.PAGADO;
    }

    public Ticket(String matricula, Integer minutos, Estado estado) {
        this.matricula = matricula;
        this.minutos = minutos;
        this.estado = estado;
    }

    public String nuevaMatricula() {
        Random random = new Random();
        String letras = "BCDFGHJKLMNPQRSTVWXYZ";
        String numeros = "0123456789";

        int aux = 0;

        for (int j = 0; j < 4; j++) {
            aux = random.nextInt(numeros.length());
            matricula += numeros.charAt(aux);
        }
        for (int j = 0; j < 3; j++) {
            aux = random.nextInt(letras.length());
            matricula += letras.charAt(aux);
        }

        return matricula;
    }
}
