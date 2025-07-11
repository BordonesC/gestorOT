package com.portfolio.auth.service;

import com.portfolio.auth.model.Rol;
import com.portfolio.auth.model.Usuario;
import com.portfolio.auth.repository.UsuarioRepository;

public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;
    }

    public Usuario crearUsuario(String nombre, Rol rol){
        return repository.guardar(new Usuario(nombre,rol));
    }

    public boolean eliminarUsuarioPorNombre(String nombre){
        return repository.eliminarUsuarioPorNombre(nombre);
    }

    public boolean modificarRol(String nombre, Rol nuevoRol) {
        return repository.actualizarRol(nombre, nuevoRol);
    }

    public Usuario buscarUsuarioPorNombre(String nombre) {
        return repository.buscarUsuarioPorNombre(nombre);
    }
}
