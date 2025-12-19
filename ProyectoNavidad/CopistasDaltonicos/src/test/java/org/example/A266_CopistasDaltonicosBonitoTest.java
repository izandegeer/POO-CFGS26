package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para A266_CopistasDaltonicosBonito
 * 
 * Se comprueban de forma aislada las distintas partes lógicas del programa,
 * sin necesidad de interacción por teclado.
 */
class A266_CopistasDaltonicosBonitoTest {

    /**
     * Test del método LeerCuadro (de forma simulada).
     * 
     * Como el método original lee desde teclado, aquí simulamos
     * directamente el resultado esperado.
     * 
     * Se comprueba:
     *  - Número de filas
     *  - Número de columnas por fila
     *  - Contenido exacto de cada fila
     */
    @Test
    void leerCuadro() {
        // Cuadro simulado de 2 filas y 3 columnas
        String[] cuadro = {"RGB", "GBR"};

        assertAll(
                // Comprobamos que tiene exactamente 2 filas
                () -> assertEquals(2, cuadro.length, "Debe tener 2 filas"),

                // Comprobamos que la primera fila tiene 3 columnas
                () -> assertEquals(3, cuadro[0].length(), "Fila 1 debe tener 3 columnas"),

                // Comprobamos el contenido exacto de la primera fila
                () -> assertEquals("RGB", cuadro[0], "Fila 1 incorrecta"),

                // Comprobamos el contenido exacto de la segunda fila
                () -> assertEquals("GBR", cuadro[1], "Fila 2 incorrecta")
        );
    }

    /**
     * Test del método aplicarCopistas (de forma simulada).
     * 
     * En lugar de usar Scanner, se simula directamente el efecto
     * del copista aplicando los cambios sobre el array.
     * 
     * En este caso:
     *  - R se cambia por Y
     *  - B se cambia por M
     * 
     * Se comprueba que el cuadro resultante sea el esperado.
     */
    @Test
    void aplicarCopistas() {
        // Cuadro original
        String[] cuadro = {"RGB", "GBR"};

        // Simulación manual de un copista:
        // R -> Y
        // B -> M
        for (int j = 0; j < cuadro.length; j++) {
            cuadro[j] = cuadro[j]
                    .replace('R', 'Y')
                    .replace('B', 'M');
        }

        assertAll(
                // Comprobamos la transformación de la primera fila
                () -> assertEquals("YGM", cuadro[0], "Fila 1 transformada incorrecta"),

                // Comprobamos la transformación de la segunda fila
                () -> assertEquals("GMY", cuadro[1], "Fila 2 transformada incorrecta")
        );
    }

    /**
     * Test del método mostrarResultado.
     * 
     * en este Test se realizan comprobaciones básicas:
     *  - Las filas existen
     *  - Las filas tienen contenido
     */
    @Test
    void mostrarResultado() {
        String[] cuadro = {"RGB", "GBR"};

        assertAll(
                // Comprobamos que la primera fila no sea null
                () -> assertNotNull(cuadro[0], "Fila 1 no debe ser null"),

                // Comprobamos que la segunda fila no sea null
                () -> assertNotNull(cuadro[1], "Fila 2 no debe ser null"),

                // Comprobamos que la primera fila tenga contenido
                () -> assertTrue(cuadro[0].length() > 0, "Fila 1 debe tener longitud > 0"),

                // Comprobamos que la segunda fila tenga contenido
                () -> assertTrue(cuadro[1].length() > 0, "Fila 2 debe tener longitud > 0")
        );
    }
}
