package org.example;

import Clases.Estado;
import Clases.Libro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibroTest {
    Libro libro;

    @BeforeEach
    public void creoLibro() {
        this.libro = new Libro("9785-4685-78956", "Now: the physics of time", "Richard A. Muller", Estado.DISPONIBLE);
    }
    @Test
    public void testCreacionLibro(){
        assertEquals("9785-4685-78956", libro.getIsbn());
        assertEquals("Now: the physics of time", libro.getTitulo());
        assertEquals("Richard A. Muller",libro.getAutor());
        assertEquals(Estado.DISPONIBLE, libro.getEstado());
    }

    @Test
    public void testCambiarDatos(){
        this.libro.setIsbn("1111-1111-11111");
        this.libro.setAutor("Ejemplo Autor");
        this.libro.setTitulo("Ejemplo Titulo");
        this.libro.setEstado(Estado.PRESTADO);

        assertEquals("1111-1111-11111", this.libro.getIsbn());
        assertEquals("Ejemplo Titulo", this.libro.getTitulo());
        assertEquals("Ejemplo Autor", this.libro.getAutor());
        assertEquals(Estado.PRESTADO, this.libro.getEstado());
    }

}
