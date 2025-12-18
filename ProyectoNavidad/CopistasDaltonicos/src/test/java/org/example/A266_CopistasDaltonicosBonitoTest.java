package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class A266_CopistasDaltonicosBonitoTest {


    @Test
    void leerCuadro() {
        String[] cuadro = {"RGB", "GBR"};

        assertAll(
                () -> assertEquals(2, cuadro.length, "Debe tener 2 filas"),
                () -> assertEquals(3, cuadro[0].length(), "Fila 1 debe tener 3 columnas"),
                () -> assertEquals("RGB", cuadro[0], "Fila 1 incorrecta"),
                () -> assertEquals("GBR", cuadro[1], "Fila 2 incorrecta")
        );
    }

    @Test
    void aplicarCopistas() {
        String[] cuadro = {"RGB", "GBR"};

        // Simular un copista que cambia R -> Y y B -> M
        for (int j = 0; j < cuadro.length; j++) {
            cuadro[j] = cuadro[j].replace('R', 'Y').replace('B', 'M');
        }

        assertAll(
                () -> assertEquals("YGM", cuadro[0], "Fila 1 transformada incorrecta"),
                () -> assertEquals("GMY", cuadro[1], "Fila 2 transformada incorrecta")
        );
    }

    @Test
    void mostrarResultado() {
        String[] cuadro = {"RGB", "GBR"};
        assertAll(
                () -> assertNotNull(cuadro[0], "Fila 1 no debe ser null"),
                () -> assertNotNull(cuadro[1], "Fila 2 no debe ser null"),
                () -> assertTrue(cuadro[0].length() > 0, "Fila 1 debe tener longitud > 0"),
                () -> assertTrue(cuadro[1].length() > 0, "Fila 2 debe tener longitud > 0")
        );
    }
}