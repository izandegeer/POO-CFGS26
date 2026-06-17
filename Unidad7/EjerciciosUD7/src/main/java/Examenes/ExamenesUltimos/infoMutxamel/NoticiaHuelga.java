package Examenes.ExamenesUltimos.infoMutxamel;

public class NoticiaHuelga extends Comunicado implements AccionPolitica{
    @Override
    public boolean evaluarRiesgo() {
        return false;
    }

    @Override
    public void tramitar() {

    }

    @Override
    public void censurar() {

    }

    @Override
    void leer() {

    }

    public NoticiaHuelga(String id, String texto, Integer valoracionPrioridad, EstadoMensaje estado) {
        super(id, texto, valoracionPrioridad, estado);
    }
}
