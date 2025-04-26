package Servicios;

import Clases.Libro;
import Clases.Prestamo;
import Clases.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import java.util.*;

@Setter
@Getter
public class GestionUsuarios {
    private List<Usuario> usuarios = new ArrayList<>();
    private SistemaPrestamo sistema;
    private Map<String, List<Prestamo>> historialPrestamos = new HashMap<>();

    public void registroDeUsuarios(String nombre){
        Usuario usuario = new Usuario(nombre, null);
        usuarios.add(usuario);
        historialPrestamos.put(nombre, new ArrayList<>());
    }

    public void registrarPrestamo(String nombre, String isbn){
        Usuario aPrestar = null;
        for (Usuario usuario : usuarios){
            if (usuario.getNombre().equals(nombre)){
                aPrestar = usuario;
                break;
            }
        }

        Prestamo prestamo = sistema.consultarPrestamo(isbn);
        historialPrestamos.get(nombre).add(prestamo);
    }

    public List<Prestamo> obtenerHistorial(String nombre){
        return historialPrestamos.getOrDefault(nombre, new ArrayList<>());
    }
}

