package Clases;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private String nombre;
    private List<Prestamo> historialPrestamos;
}
