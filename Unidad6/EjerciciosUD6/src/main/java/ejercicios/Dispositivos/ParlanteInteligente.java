package ejercicios.Dispositivos;

public class ParlanteInteligente extends Dispositivo{

    public ParlanteInteligente() {
        super("Parlante");
    }

    @Override
    public void encender() {
        if (isEstado()){ // isEstado es lo mismo que getEstado (Al ser booleano es lo que pasa)
            System.out.println("[Parlante] Ya está encendido.");
        } else {
            System.out.println("[Parlante] Ha sido encendido.");
            setEstado(true);
        }
    }
}
