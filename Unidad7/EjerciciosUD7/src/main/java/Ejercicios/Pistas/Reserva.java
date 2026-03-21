package Ejercicios.Pistas;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
public class Reserva {
    private Usuario usuario;
    private Pista pista;
    private LocalDate fecha;

    public Reserva(Usuario usuario, Pista pista, LocalDate fecha) {
        this.usuario = usuario;
        this.pista = pista;
        this.fecha = fecha;
    }

    public Reserva(Usuario usuario, Pista pista) {
        this.usuario = usuario;
        this.pista = pista;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(usuario, reserva.usuario) && Objects.equals(pista, reserva.pista) && Objects.equals(fecha, reserva.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, pista, fecha);
    }
}
