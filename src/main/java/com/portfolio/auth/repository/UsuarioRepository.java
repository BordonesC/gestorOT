package com.portfolio.auth.repository;

import com.portfolio.auth.model.Usuario;

public interface UsuarioRepository {
        Usuario guardar(Usuario usuario);
        Usuario encontrarUsuarioPorNombre(String nombre);
        boolean eliminarUsuarioPorNombre(String nombre);
}
