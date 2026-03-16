package Teoria.Conjuntos.Cine;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CineApp { // Colas
    static Random random = new Random();
    static Queue<Espectador> cola = new LinkedList<>();
    public static void main(String[] args) {
        generarCola();

        System.out.println(cola);

        double recaudacion = 0;
        System.out.println("");



        while (!cola.isEmpty()){
            if (cola.peek().getEdad() >= 3 && cola.peek().getEdad() <= 10){
                recaudacion += 1;
            } else if (cola.peek().getEdad() >= 11 && cola.peek().getEdad() <= 17){
                recaudacion += 2.5;
            } else if (cola.peek().getEdad() >= 18) {
               recaudacion += 3.5;
            }
            cola.poll();
        }

        System.out.println("La recaudación total ha sido de: " + recaudacion + "€");
    }

    public static void generarCola(){
        System.out.println("*** CINE DEL POBLE ***");
        System.out.println("----------------------");

        int numPersonas = random.nextInt(5);

        System.out.println("Lista de espectadores (" + numPersonas + "): ");

        for (int i = 0; i < numPersonas; i++) {
            cola.offer(new Espectador(random.nextInt(97)+3));
        }
    }
}
