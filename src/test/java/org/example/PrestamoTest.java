package org.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

    @Test
    void testCrearPrestamoConMock() {
        Libro libroMock = mock(Libro.class);

        when(libroMock.getIsbn()).thenReturn("48952-791-81491");
        when(libroMock.getTitulo()).thenReturn("Titulo");
        when(libroMock.getAutor()).thenReturn("Autor");
        when(libroMock.getEstado()).thenReturn(Estado.DISPONIBLE);

        Prestamo prestamo = new Prestamo(libroMock);
        assertNotNull(prestamo.getLibro());
        assertEquals(libroMock, prestamo.getLibro());
        assertEquals(LocalDate.now(), prestamo.getFechaDePrestamo());
    }
}
