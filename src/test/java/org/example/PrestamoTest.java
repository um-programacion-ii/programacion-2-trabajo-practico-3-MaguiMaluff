package org.example;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

import Clases.Estado;
import Clases.Libro;
import Clases.Prestamo;
import org.junit.jupiter.api.Test;

public class PrestamoTest {

    @Test
    void testCrearPrestamo() {
        Libro libro = new Libro("48952-791-81491", "Titulo", "Autor", Estado.DISPONIBLE);
        Prestamo prestamo = new Prestamo(libro);

        assertNotNull(prestamo.getLibro());
        assertEquals(libro, prestamo.getLibro());
        assertEquals(LocalDate.now(), prestamo.getFechaDePrestamo());
    }
}