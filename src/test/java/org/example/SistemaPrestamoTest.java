package org.example;

import static org.junit.jupiter.api.Assertions.*;

import Clases.Estado;
import Clases.Libro;
import Clases.Prestamo;
import Servicios.Catalogo;
import Servicios.SistemaPrestamo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaPrestamoTest {

    private Catalogo catalogo;
    private SistemaPrestamo sistemaPrestamo;

    @BeforeEach
    void setUp() {
        catalogo = new Catalogo();
        sistemaPrestamo = new SistemaPrestamo(catalogo);

        catalogo.agregarLibro(new Libro("9785-4685-78956", "Now: the physics of time", "Richard A. Muller", Estado.DISPONIBLE));
        catalogo.agregarLibro(new Libro("978-987-04-5678-9", "Rayuela", "Julio Cortázar", Estado.DISPONIBLE));
    }

    @Test
    void testPrestarLibro() {
        Prestamo prestamo = sistemaPrestamo.prestarLibro("9785-4685-78956");

        assertNotNull(prestamo);
        assertEquals("Now: the physics of time", prestamo.getLibro().getTitulo());
        assertEquals(Estado.PRESTADO, prestamo.getLibro().getEstado());
    }
}

