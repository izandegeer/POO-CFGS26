package org.drift_spain_series;

import java.util.ArrayList;

public class Inscripcion {
    public static ArrayList<Inscripcion> pilotosInscritos = new ArrayList<>();
    private Piloto piloto;
    private categoriaDRIFT categoria;
    private boolean pagado;

    public Inscripcion(Piloto piloto, categoriaDRIFT categoria, boolean pagado) {
        this.piloto = piloto;
        this.categoria = categoria;
        this.pagado = pagado;
        pilotosInscritos.add(piloto.inscribirse());
    }

    public Inscripcion(Piloto piloto, categoriaDRIFT categoria) {
        this.piloto = piloto;
        this.categoria = categoria;
        pilotosInscritos.add(piloto.inscribirse());
    }

    public static ArrayList<Inscripcion> getPilotosInscritos() {
        return pilotosInscritos;
    }

    public static void setPilotosInscritos(ArrayList<Inscripcion> pilotosInscritos) {
        Inscripcion.pilotosInscritos = pilotosInscritos;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public categoriaDRIFT getCategoria() {
        return categoria;
    }

    public void setCategoria(categoriaDRIFT categoria) {
        this.categoria = categoria;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "piloto=" + piloto +
                ", categoria=" + categoria +
                ", pagado=" + pagado +
                '}';
    }
}
