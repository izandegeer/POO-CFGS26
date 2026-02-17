package teoria.interfaces;

public class Avion implements Voladores{
    @Override
    public void volar() {
        System.out.println("[Avión] Viajando por el mundo.");
    }
}
