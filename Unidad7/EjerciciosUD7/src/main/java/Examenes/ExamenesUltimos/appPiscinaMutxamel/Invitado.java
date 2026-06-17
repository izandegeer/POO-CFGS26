package Examenes.ExamenesUltimos.appPiscinaMutxamel;

import java.time.LocalDate;

public class Invitado extends Banyista {
    private LocalDate fechaVisita;

    @Override
    void pagar() {

    }

    public Invitado(Integer numero, String nombre, int edad, LocalDate fechaVisita) {
        super(numero, nombre, edad);
        this.fechaVisita = fechaVisita;
    }

    public LocalDate getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(LocalDate fechaVisita) {
        this.fechaVisita = fechaVisita;
    }
}
