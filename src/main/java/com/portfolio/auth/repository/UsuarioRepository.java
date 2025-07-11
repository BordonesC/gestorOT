package com.portfolio.auth.repository;

import com.portfolio.auth.model.*;

public interface UsuarioRepository {
        Usuario guardar(Usuario usuario);
        Usuario buscarUsuarioPorNombre(String nombre);
        boolean eliminarUsuarioPorNombre(String nombre);
        boolean actualizarRol(String nombre, Rol nuevoRol);
}
