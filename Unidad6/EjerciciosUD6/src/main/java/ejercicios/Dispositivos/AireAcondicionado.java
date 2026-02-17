package ejercicios.Dispositivos;

public class AireAcondicionado extends Dispositivo implements ControlRemoto{
    public AireAcondicionado() {
        super("Aire");
    }

    @Override
    public void sincronizar() {
        System.out.println("[Aire] Sincronizando...");
        System.out.println("[Aire] Sincronizado.");
    }

    @Override
    public void encender() {
        setEstado(true);
        System.out.println("[Aire] Ha sido encendido.");
    }
}
