package Servicios;

import Clases.Estado;
import Clases.Libro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Catalogo {
    private List<Libro> catalogo = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        catalogo.add(libro);
    }

    public Libro buscarLibroISBN(String isbn) {
        for (Libro libro : catalogo) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }return null;
    }

    public List obtenerLibrosDisponibles() {
        List<Libro> disponibles = new ArrayList<>();
        for (Libro libro : catalogo) {
            if (libro.getEstado().equals(Estado.DISPONIBLE)) {
               disponibles.add(libro);
            }
        }return disponibles;
    }
}