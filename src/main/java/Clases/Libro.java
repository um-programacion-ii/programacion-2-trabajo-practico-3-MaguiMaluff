package Clases;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private Estado estado;
}
