package org.drift_spain_series;

public class excepcionCocheApto extends RuntimeException {
    public excepcionCocheApto() {
        super("El coche no ha sido revisado, no puede ser cambiado a APTO.");
    }
}
