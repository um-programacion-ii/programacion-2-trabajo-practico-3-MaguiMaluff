package Clases;

import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor

public class Prestamo {
    private LocalDate fechaDePrestamo;
    private Libro libro;

    public Prestamo(Libro libro){
        this.libro = libro;
        this.fechaDePrestamo = LocalDate.now();

    }
}
