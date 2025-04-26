package Servicios;

import Clases.Prestamo;
import Clases.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GestionUsuariosTest {

    private GestionUsuarios gestionUsuarios;
    private SistemaPrestamo sistemaMock;

    @BeforeEach
    public void setUp() {
        sistemaMock = mock(SistemaPrestamo.class);
        gestionUsuarios = new GestionUsuarios();
        gestionUsuarios.setSistema(sistemaMock);
    }

    @Test
    public void testRegistroDeUsuarios() {
        gestionUsuarios.registroDeUsuarios("Pepe");

        List<Usuario> usuarios = gestionUsuarios.getUsuarios();
        assertEquals(1, usuarios.size());
        assertEquals("Pepe", usuarios.getFirst().getNombre());
    }

    @Test
    public void testRegistrarPrestamo() {
        gestionUsuarios.registroDeUsuarios("Juan");

        Prestamo prestamoMock = mock(Prestamo.class);
        when(sistemaMock.consultarPrestamo("4865-1835-13597")).thenReturn(prestamoMock);

        gestionUsuarios.registrarPrestamo("Juan", "4865-1835-13597");

        List<Prestamo> historial = gestionUsuarios.obtenerHistorial("Juan");
        assertEquals(1, historial.size());
        assertTrue(historial.contains(prestamoMock));
    }

    @Test
    public void testObtenerHistorial() {
        gestionUsuarios.registroDeUsuarios("Maria");

        Prestamo prestamoMock = mock(Prestamo.class);
        when(sistemaMock.consultarPrestamo("4865-1835-13597")).thenReturn(prestamoMock);

        gestionUsuarios.registrarPrestamo("Maria", "4865-1835-13597");

        List<Prestamo> historial = gestionUsuarios.obtenerHistorial("Maria");
        assertEquals(1, historial.size());
    }

    @Test
    public void testHistorialDeUsuarioNoExistente() {
        List<Prestamo> historial = gestionUsuarios.obtenerHistorial("NoExistente");
        assertTrue(historial.isEmpty());
    }
}
