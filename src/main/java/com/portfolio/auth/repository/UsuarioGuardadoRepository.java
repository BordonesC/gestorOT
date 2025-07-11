package com.portfolio.auth.repository;

import com.portfolio.auth.model.Rol;
import com.portfolio.auth.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioGuardadoRepository implements UsuarioRepository{
    private final List<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario guardar(Usuario usuario){
        usuarios.add(usuario);
        return usuario;
    }

    private Optional<Usuario> buscarPorNombre(String nombre){
        return usuarios.stream()
                .filter(u -> u.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }

    @Override
    public Usuario encontrarUsuarioPorNombre(String nombre){
        return buscarPorNombre(nombre).orElse(null);
    }

    @Override
    public boolean eliminarUsuarioPorNombre(String nombre){
        return buscarPorNombre(nombre)
                .map(usuarios::remove)
                .orElse(false);
    }

    @Override
    public Usuario buscarUsuarioPorNombre(String nombre) {
        return usuarios.stream()
                .filter(u -> u.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean actualizarRol(String nombre, Rol nuevoRol) {
        Usuario usuario = buscarUsuarioPorNombre(nombre);
        if (usuario != null) {
            usuarios.remove(usuario);
            usuarios.add(new Usuario(nombre, nuevoRol));
            return true;
        }
        return false;
    }
}
