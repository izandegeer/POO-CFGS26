package ejercicios.Dispositivos;

public class Televisor extends Dispositivo implements ControlRemoto{

    public Televisor() {
        super("Televisor");
    }

    @Override
    public void encender() {
        System.out.println("[Televisor] Ha sido encendido.");
        setEstado(true);
    }

    @Override
    public void sincronizar() {
        System.out.println("[Televisor] Sincronizando...");
        System.out.println("[Televisor] Sincronizado.");
    }
}
