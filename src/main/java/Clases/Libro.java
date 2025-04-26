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

    @Override
    public String toString(){
        return  "ISBN: " + getIsbn() + '\n' +
                "Titulo: " + getTitulo() + '\n'+
                "Autor: " + getAutor() + '\n' +
                "Estado: " + getEstado() + '\n';
    }

}
