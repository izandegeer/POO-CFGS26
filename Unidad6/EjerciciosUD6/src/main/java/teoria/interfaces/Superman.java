package teoria.interfaces;

public class Superman extends Superheroe implements Voladores,Ataques{
    @Override
    public void volar() {
        System.out.println("[Superman] Sobrevolando la ciudad, vigilando a los malos.");
    }

    @Override
    public void ojosLaser() {
        System.out.println("Soltando laser por los ojos...");
    }

    @Override
    public void saltar() {
        System.out.println("Saltando 10 metros...");
    }

    @Override
    public void hielo() {
        System.out.println("Escupiendo hielos...");
    }
}
