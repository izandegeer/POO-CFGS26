package org.example.Practicas.Practica1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class ProgramaInvitadoTest {

    private Cadena cadena;
    private Programa programa;

    @BeforeEach
    public void setUp() {
        cadena = new Cadena("Antena 3");
        programa = new Programa("El Hormiguero", cadena, "Pablo Motos");
    }

    @Test
    public void testCrearInvitadoYVerificarQueEsteEnLaLista() {
        // Arrange
        int invitadosAntes = programa.getListaInvitados().size();

        // Act
        programa.crearInvitado("Izan", "Cantante", 1);
        int invitadosDespues = programa.getListaInvitados().size();

        // Assert
        assertEquals(invitadosAntes + 1, invitadosDespues);
        assertTrue(programa.buscarInvitado("Izan"));
    }

    @Test
    public void testBorrarInvitadoYVerificarQueSeHayaRemovido() {
        // Arrange
        programa.crearInvitado("Ismael", "Presentador", 1);
        Invitado invitado = programa.getListaInvitados().get(0);
        int invitadosAntes = programa.getListaInvitados().size();

        // Act
        programa.borrarInvitado(invitado);
        int invitadosDespues = programa.getListaInvitados().size();

        // Assert
        assertEquals(invitadosAntes - 1, invitadosDespues);
        assertFalse(programa.buscarInvitado("Ismael"));
    }

    @Test
    public void testContarVecesQueUnInvitadoHaVisitadoElPrograma() {
        // Arrange
        programa.crearInvitado("Aitana", "Cantante", 1);
        programa.crearInvitado("Aitana", "Cantante", 2);
        programa.crearInvitado("Aitana", "Cantante", 3);

        // Act
        int veces = programa.vecesInvitado("Aitana");

        // Assert
        assertEquals(3, veces);
    }

    @Test
    public void testBuscarUnInvitadoQueExiste() {
        // Arrange
        programa.crearInvitado("Iván Jorge", "Humorista", 1);

        // Act
        boolean existe = programa.buscarInvitado("Iván Jorge");

        // Assert
        assertTrue(existe);
    }

    @Test
    public void testBuscarUnInvitadoQueNoExiste() {
        // Arrange
        programa.crearInvitado("Ismael", "Humorista", 1);

        // Act
        boolean existe = programa.buscarInvitado("Persona Fantasma");

        // Assert
        assertFalse(existe);
    }
}
