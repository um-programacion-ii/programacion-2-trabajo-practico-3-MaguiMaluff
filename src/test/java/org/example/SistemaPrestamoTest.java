package org.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import Clases.Estado;
import Clases.Libro;
import Clases.Prestamo;
import Servicios.Catalogo;
import Servicios.SistemaPrestamo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class SistemaPrestamoTest {
    private Libro libro1;
    private Libro libro2;

    @Spy
    private Catalogo catalogo;

    @InjectMocks
    private SistemaPrestamo sistemaPrestamos;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sistemaPrestamos = new SistemaPrestamo(catalogo);
        libro1 = new Libro("9785-4685-78956", "Now: the physics of time", "Richard A. Muller", Estado.DISPONIBLE);
        libro2 =new Libro("978-987-04-5678-9", "Rayuela", "Julio Cortázar", Estado.DISPONIBLE);
    }

    @Test
    void testPrestarLibro() {
        when(catalogo.buscarLibroISBN("9785-4685-78956")).thenReturn(libro1);

        Prestamo prestamo = sistemaPrestamos.prestarLibro("9785-4685-78956");

        assertNotNull(prestamo);
        verify(catalogo).buscarLibroISBN("9785-4685-78956");
        assertEquals(Estado.PRESTADO, libro1.getEstado());
    }
}

