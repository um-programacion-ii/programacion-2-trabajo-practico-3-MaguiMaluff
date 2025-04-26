import Clases.Estado;
import Clases.Libro;
import Servicios.Catalogo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CatalogoTest {
    static Catalogo catalogo;

    static Libro libro1;
    static Libro libro2;
    static Libro libro3;
    static Libro libro4;

    @BeforeAll
    public static void creaLibros() {
        catalogo = new Catalogo();
        libro1 = new Libro("8468-8521-854793", "El principito", "Antoine de Saint-Exupéry", Estado.DISPONIBLE);
        libro2 = new Libro("978-950-07-1234-5", "Cien años de soledad", "Gabriel García Márquez", Estado.DISPONIBLE);
        libro3 = new Libro("978-987-04-5678-9", "Rayuela", "Julio Cortázar", Estado.DISPONIBLE);
        libro4 = new Libro("978-84-376-0494-7", "Don Quijote de la Mancha", "Miguel de Cervantes", Estado.DISPONIBLE);
    }

    @Test
    public void testAgregarLibros() {
        catalogo.agregarLibro(libro1);
        catalogo.agregarLibro(libro2);
        catalogo.agregarLibro(libro3);
        catalogo.agregarLibro(libro4);

        assertEquals(4, catalogo.getCatalogo().size());
    }
}
