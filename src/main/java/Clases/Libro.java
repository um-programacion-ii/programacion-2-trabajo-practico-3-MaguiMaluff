package Clases;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private Estado estado;
}
