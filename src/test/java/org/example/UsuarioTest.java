package org.example;

import Clases.Estado;
import Clases.Libro;
import Clases.Prestamo;
import Clases.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    private Usuario usuario;
    private Prestamo prestamo1;
    private Prestamo prestamo2;

    @BeforeEach
    public void setUp() {
        usuario = new Usuario("Juan", new ArrayList<>());
        prestamo1 = new Prestamo(new Libro("978-987-04-5678-9", "Rayuela", "Julio Cortázar", Estado.DISPONIBLE));
        prestamo2 = new Prestamo(new Libro("978-84-376-0494-7", "Don Quijote de la Mancha", "Miguel de Cervantes", Estado.DISPONIBLE));
    }

    @Test
    public void testCrearUsuario() {
        assertNotNull(usuario);
        assertEquals("Juan", usuario.getNombre());
        assertNotNull(usuario.getHistorialPrestamos());
        assertTrue(usuario.getHistorialPrestamos().isEmpty());
    }

    @Test
    public void testAgregarPrestamo() {
        usuario.getHistorialPrestamos().add(prestamo1);
        assertEquals(1, usuario.getHistorialPrestamos().size());
        assertTrue(usuario.getHistorialPrestamos().contains(prestamo1));

        usuario.getHistorialPrestamos().add(prestamo2);
        assertEquals(2, usuario.getHistorialPrestamos().size());
        assertTrue(usuario.getHistorialPrestamos().contains(prestamo2));
    }


    @Test
    public void testHistorialPrestamosInicial() {
        assertTrue(usuario.getHistorialPrestamos().isEmpty());
    }
}
