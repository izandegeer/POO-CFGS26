package ejercicios.Semaforo;

public class semaforoApp {
    static void main() {
        Semaforo inicio = Semaforo.AMARILLO;

        for (int i = 0; i < 10; i++) {
            inicio = Semaforo.siguiente(inicio);
            System.out.println(inicio);
        }
    }
}
