package Servicios;

import Clases.Estado;
import Clases.Libro;
import Clases.Prestamo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor

public class SistemaPrestamo {
    private Catalogo catalogo;
    private Map<String, Prestamo> prestamos;

    public SistemaPrestamo(Catalogo catalogo) {
        this.catalogo = catalogo;
        this.prestamos = new HashMap<>();
    }

    public Prestamo prestarLibro(String isbn) {
        Libro libro = catalogo.buscarLibroISBN(isbn);
        libro.setEstado(Estado.PRESTADO);
        Prestamo prestamo = new Prestamo(libro);
        prestamos.put(isbn, prestamo);
        return prestamo;
    }

    public Prestamo consultarPrestamo(String isbn) {
        return prestamos.get(isbn);
    }
}
