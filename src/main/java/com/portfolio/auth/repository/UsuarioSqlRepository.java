package com.portfolio.auth.repository;

import com.portfolio.auth.model.Rol;
import com.portfolio.auth.model.Usuario;

public class UsuarioSqlRepository implements UsuarioRepository {
    //se implementa print simulando las consultas
    @Override
    public Usuario guardar(Usuario usuario) {
        System.out.println("INSERT INTO usuarios (nombre, rol) VALUES ('" +
                usuario.getNombre() + "', '" + usuario.getRol() + "')");
        return usuario;
    }

    @Override
    public Usuario buscarUsuarioPorNombre(String nombre) {
        System.out.println("SELECT * FROM usuarios WHERE nombre = '" +nombre+ "'");
        return new Usuario(nombre, Rol.USUARIO);
    }

    @Override
    public boolean eliminarUsuarioPorNombre(String nombre) {
        System.out.println("DELETE FROM usuarios WHERE nombre = '" +nombre+ "'");
        return true;
    }

    @Override
    public boolean actualizarRol(String nombre, Rol nuevoRol) {
        System.out.println("UPDATE usuarios SET rol = '" + nuevoRol + "' WHERE nombre = '" +nombre+ "'");
        return true;
    }
}
