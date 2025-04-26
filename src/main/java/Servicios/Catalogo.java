package Servicios;

import Clases.Estado;
import Clases.Libro;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Catalogo {
    private List<Libro> catalogo = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        catalogo.add(libro);
    }

    public void buscarLibroISBN(String isbn) {
        for (Libro libro : catalogo) {
            if (libro.getIsbn().equals(isbn)) {
                System.out.println(libro.toString());
            }
        }
    }

    public void obtenerLibrosDisponibles() {
        for (Libro libro : catalogo) {
            if (libro.getEstado().equals(Estado.DISPONIBLE)) {
                System.out.println(libro.toString());
            }
        }
    }
}