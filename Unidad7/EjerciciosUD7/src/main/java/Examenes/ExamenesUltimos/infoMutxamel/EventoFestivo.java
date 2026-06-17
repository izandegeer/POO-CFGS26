package Examenes.ExamenesUltimos.infoMutxamel;

public class EventoFestivo extends Comunicado {
    private String ubicacion;
    private boolean gratuito;

    public EventoFestivo(String id, String texto, Integer valoracionPrioridad, EstadoMensaje estado, String ubicacion, boolean gratuito) {
        super(id, texto, valoracionPrioridad, estado);
        this.ubicacion = ubicacion;
        this.gratuito = gratuito;
    }

    public void aplicarRuido() {
        setEstado(EstadoMensaje.DIFUNDIDO);
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isGratuito() {
        return gratuito;
    }

    public void setGratuito(boolean gratuito) {
        this.gratuito = gratuito;
    }

    @Override
    void leer() {

    }
}
