package ejercicios.Dispositivos;

public abstract class Dispositivo {
    private String nombre;
    private boolean estado = false;

    public Dispositivo(String nombre) {
        this.nombre = nombre;
        estado=false;
    }

    public abstract void encender();

    public void apagar(){
        if (!estado){
            System.out.println("[" + nombre + "] Ya está apagado, no puede volver a apagarse.");
        } else {
            estado = false;
            System.out.println("[" + nombre + "] Apagado.");
        }
    }

    public void mostrarEstado(){
        if (estado){
            System.out.println("[" + nombre + "] Estado: Encendido");
        } else {
            System.out.println("[" + nombre + "] Estado: Apagado");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


}
